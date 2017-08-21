package com.lanqiao.mapper;

import java.util.List;

import com.lanqiao.vo.District;
import com.lanqiao.vo.House;
import com.lanqiao.vo.Page;
import com.lanqiao.vo.Street;

public interface HouseMapper {

	/**
	 * @param house
	 * @return
	 */
	public int countForSelective(Page<House> house);
	
	/**
	 * @param house
	 * @return
	 */
	public List<House> selectSelective(Page<House> house);
	
	/**
	 * @return
	 */
	public List<District> selectDistrict();
	
	/**
	 * @param districtId
	 * @return
	 */
	public List<Street> selectStreetById(Integer districtId);
	
	
}
