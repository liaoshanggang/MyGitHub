package com.lanqiao.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lanqiao.service.IHouseService;
import com.lanqiao.vo.District;
import com.lanqiao.vo.House;
import com.lanqiao.vo.Page;
import com.lanqiao.vo.Street;

@Controller
@RequestMapping("/house")
public class HouseController {
	// 如果一个Controller类需要用到多个Service，那么你可注入多个Service
	@Resource
	IHouseService houseService;

	@RequestMapping(value = { "/list" })
	public String listForPage(House house, Integer pageNo, ModelMap modelMap,
			HttpSession session) {
		Page<House> page = (Page<House>) session.getAttribute("housePage");
		if (page == null || pageNo == null) {
			page = new Page<House>(house);
			page.setPageNo(1);
			page.setPageSize(3);
			// 统计记录数
			int totalRow = houseService.countForSelective(page);
			page.setTotalRow(totalRow);
		} else {
			page.setPageNo(pageNo);
		}
		List<House> list = houseService.selectSelective(page);
		modelMap.addAttribute("houseList", list);

		session.setAttribute("housePage", page);
		return "list";
	}

	@RequestMapping("/loaddistricts")
	public @ResponseBody List<District> loadDistrict() {
		List<District> list = houseService.selectDistrict();
		return list;
	}

	@RequestMapping("/loadstreets")
	public @ResponseBody List<Street> loadStreet(Integer districtId) {
		List<Street> list = houseService.selectStreetById(districtId);
		return list;
	}

	@RequestMapping("/detail/{id}")
	public String viewDetail(@PathVariable Integer id, ModelMap modelMap) {
		House house = houseService.selectByPrimaryKey(id);
		modelMap.addAttribute("house", house);
		return "detail";
	}

	@RequestMapping("/selectMe")
	public String selectMe(Integer userId, ModelMap modelMap) {
		List<House> list = this.houseService.selectForMe(userId);
		modelMap.addAttribute("houses", list);
		return "my";
	}

	@RequestMapping("/toUpdate/{id}")
	public String toUpdate(@PathVariable Integer id, ModelMap modelMap) {
		House house = houseService.selectByPrimaryKey(id);
		modelMap.addAttribute("house", house);
		return "post_update";// post
	}

	// @RequestMapping(value="/update")
	// public @ResponseBody String update(HttpServletRequest request){
	// String userId = request.getParameter("userId");
	//
	// House h = new House();
	// this.houseService.updateMyHouseInfo(h );
	// return "success";
	// }

	@RequestMapping("/update")
	public String update(House h, ModelMap modelMap) {
		this.houseService.updateMyHouseInfo(h);
		List<House> list = this.houseService.selectForMe(h.getUserId());
		modelMap.addAttribute("houses", list);
		System.out.println(h.getStreet().getDistrict().getId());
		return "my";
	}

	@RequestMapping("/delete")
	public String delete(@RequestParam("hid") String id, Integer userId,
			ModelMap modelMap) {
		System.out.println(userId);
		System.out.println(id);
		houseService.deleteHouseInfoById(Integer.parseInt(id));
		List<House> list = this.houseService.selectForMe(userId);
		modelMap.addAttribute("houses", list);
		return "my";
	}

	@RequestMapping("/toInsert")
	public String toInsert(Integer userId, ModelMap modelMap) {
		return "add";
	}

	@RequestMapping("/insert")
	public String insert(House house) {
		//House [id=null, userId=5, streetId=1000, typeId=null, room=2, hall=3, title=出租桂林理工613宿舍,
		//description=123456,price=213456.0, pubdate=null, telephone=12345678987, contact=12312]
		System.out.println(house);
//		houseService.insertHouseInfo(house);
		return "list";
	}

}
