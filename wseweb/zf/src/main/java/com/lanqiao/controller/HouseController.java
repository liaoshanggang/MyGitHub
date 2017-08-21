package com.lanqiao.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
	@RequestMapping(value={"/list"})
	public String listForPage(House house,Integer pageNo,ModelMap modelMap,HttpSession session){
		Page<House> page = (Page<House>) session.getAttribute("housePage");
		if(page==null||pageNo==null){
			page = new Page<House>(house);
			page.setPageNo(1);
			page.setPageSize(3);
			//统计记录数
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
	public @ResponseBody List<District> loadDistrict(){
		List<District> list = houseService.selectDistrict();
		return list;
	}
	
	@RequestMapping("/loadstreets")
	public @ResponseBody List<Street> loadStreet(Integer districtId){
		List<Street> list = houseService.selectStreetById(districtId);
		return list;
	}
}
