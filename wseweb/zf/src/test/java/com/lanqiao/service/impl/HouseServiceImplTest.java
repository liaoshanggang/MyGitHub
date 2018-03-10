package com.lanqiao.service.impl;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lanqiao.service.IHouseService;
import com.lanqiao.vo.District;
import com.lanqiao.vo.House;
import com.lanqiao.vo.Page;
import com.lanqiao.vo.Street;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class HouseServiceImplTest {

	@Resource
	IHouseService houseService;
	
	@Test
	public void testInsertHouseInfo(){
		House house = new House(null,5 , 1002, 3, 1, 1, "出租鼓楼地铁附近/鼓楼西大街!", "房子是一个单间,和一个厨房,两间都能洗澡,电视,冰箱,洗衣机,空调什么都齐全,有意者尽快与我联系! ", 1500.0, new Date(), "15801424883", "赵先生");
		houseService.insertHouseInfo(house );
	}
	
	@Test
	public void testDeleteHouseInfoById(){
		
		houseService.deleteHouseInfoById(32);
	}
	
	@Test
	public void testUpdateMyHouseInfo(){
		House house = new House(null,5 , 1002, 3, 1, 1, "出租鼓楼地铁附近/鼓楼西大街!", "房子是一个单间,和一个厨房,两间都能洗澡,电视,冰箱,洗衣机,空调什么都齐全,有意者尽快与我联系! ", 1500.0, new Date(), "15801424883", "赵先生");
		houseService.updateMyHouseInfo(house);
	}
	
	@Test
	public void testSelectForMe(){
		List<House> list = this.houseService.selectForMe(3);
		for (House house : list) {
			System.out.println(house);
		}
	}
	
	@Test
	public void testSelectByPrimaryKey(){
		House house = this.houseService.selectByPrimaryKey(5);
		System.out.println(house.getUserInfo());
		System.out.println(house.getStreet().getDistrict()+">>>"+house.getStreet());
		System.out.println(house.getTypes());
	}
	
	@Ignore
	@Test
	public void testCountForSelective() {
		
	}

	@Test
	public void testSelectSelective() {
		House house = new House();
		Page<House> page = new Page<House>(house);
		page.setPageSize(10);
		page.setPageNo(1);
	
		int totalRow = houseService.countForSelective(page);
		page.setTotalRow(totalRow);
		System.out.println(page);
		List<House> list = houseService.selectSelective(page);
		for (House h : list) {
			System.out.println(h);
		}
	
	}

	@Ignore
	@Test
	public void testSelectDistrict() {
		List<District> list = houseService.selectDistrict();
		for (District district : list) {
			System.out.println(district);
		}
	}

	@Ignore
	@Test
	public void testSelectStreetById() {
		List<Street> streets = houseService.selectStreetById(101);
		for (Street street : streets) {
			System.out.println(street);
		}
	}
	
}
