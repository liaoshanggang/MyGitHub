package com.lanqiao.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lanqiao.mapper.HouseMapper;
import com.lanqiao.service.IHouseService;
import com.lanqiao.vo.District;
import com.lanqiao.vo.House;
import com.lanqiao.vo.Page;
import com.lanqiao.vo.Street;

@Service("houseService")
public class HouseServiceImpl implements IHouseService {

	@Resource
	HouseMapper houseMapper;

	@Override
	public int countForSelective(Page<House> house) {
		return houseMapper.countForSelective(house);
	}

	@Override
	public List<House> selectSelective(Page<House> house) {
		return houseMapper.selectSelective(house);
	}

	@Override
	public List<District> selectDistrict() {
		return houseMapper.selectDistrict();
	}

	@Override
	public List<Street> selectStreetById(Integer districtId) {
		return houseMapper.selectStreetById(districtId);
	}

	@Override
	public House selectByPrimaryKey(Integer id) {
		return houseMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<House> selectForMe(Integer userId) {
		return houseMapper.selectForMe(userId);
	}

	@Override
	public void updateMyHouseInfo(House house) {
		houseMapper.updateMyHouseInfo(house);
	}

	@Override
	public void deleteHouseInfoById(Integer id) {
		houseMapper.deleteHouseInfoById(id);
	}

	@Override
	public void insertHouseInfo(House house) {
		houseMapper.insertHouseInfo(house);
	}

}
