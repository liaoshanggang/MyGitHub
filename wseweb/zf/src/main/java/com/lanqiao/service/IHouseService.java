package com.lanqiao.service;

import java.util.List;

import com.lanqiao.vo.District;
import com.lanqiao.vo.House;
import com.lanqiao.vo.Page;
import com.lanqiao.vo.Street;


/**
 * 因为service包中要加入事务的所以方法要满足嵌入方法的规则
 * @author gg
 *
 */
public interface IHouseService {
	/**
	 * 
	 * @param house
	 * @return
	 */
	public int countForSelective(Page<House> house);
	
	/**
	 * 搜索出租信息
	 * @param house
	 * @return
	 */
	public List<House> selectSelective(Page<House> house);
	
	/**
	 * 
	 * @return
	 */
	public List<District> selectDistrict();
	
	public List<Street> selectStreetById(Integer districtId);
}
