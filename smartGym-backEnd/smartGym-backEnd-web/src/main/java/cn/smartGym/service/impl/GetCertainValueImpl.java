package cn.smartGym.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.smartGym.mapper.AppUserMapper;
import cn.smartGym.mapper.CategoryMapper;
import cn.smartGym.mapper.CompetitionMapper;
import cn.smartGym.mapper.EventMapper;
import cn.smartGym.mapper.GameApplicationMapper;
import cn.smartGym.mapper.PlayerMapper;
import cn.smartGym.pojo.AppUser;
import cn.smartGym.pojo.AppUserExample;
import cn.smartGym.pojo.AppUserExample.Criteria;
import cn.smartGym.pojo.Category;
import cn.smartGym.pojo.Competition;
import cn.smartGym.pojo.Event;
import cn.smartGym.service.GetCertainValueService;
import cn.smartGym.utils.ConversionUtilsAlter;

/** 
* @author Ma Shuaijie:
* 
* @version 创建时间：2020年1月11日 下午3:51:58 
*
* 根据每张表的主键获取每张表中需要的值 
*/
@Service
public class GetCertainValueImpl implements GetCertainValueService{
	@Autowired
	private AppUserMapper appUserMapper;
	@Autowired
	private CompetitionMapper competitionMapper;
	@Autowired
	private CategoryMapper categoryMapper;
	@Autowired
	private EventMapper eventMapper;
	@Autowired
	private GameApplicationMapper gameApplicationMapper;
	@Autowired
	private PlayerMapper playerMapper;

	@Override
	public Map<String,Object>getCertainValueOfCompetition(String id,String...Keys) {
		Map<String, Object> valueMap = new HashMap<String,Object>();
		Competition competition = competitionMapper.selectByPrimaryKey(id);
//		if(competition == null)
//			return valueMap;
		Map<String, Object> map = ConversionUtilsAlter.transBean2Map(competition);
		for(String Key:Keys)
			valueMap.put(Key,map.get(Key));
		return valueMap;
	}
	
	@Override
	public List<Map<String,Object>> getCertainValueOfCompetitions(List<String> id,String...Keys) {
		List<Map<String,Object>> resultMapList = new ArrayList<Map<String,Object>>();
		//防止向List中添加Map被覆盖
		for(int i = 0 ; i < id.size() ; i++) {
			Map<String,Object> valueMap = new HashMap<String, Object>();
			Competition competition = competitionMapper.selectByPrimaryKey(id.get(i));
			Map<String, Object> map = ConversionUtilsAlter.convertBeanToMap(competition);
			for(String Key:Keys)
				valueMap.put(Key,map.get(Key));
			resultMapList.add(i, valueMap);
		}
		return resultMapList;
	}
	
	@Override
	public Map<String,Object>getCertainValueOfCategory(String id,String...Keys) {
		Map<String, Object> valueMap = new HashMap<String,Object>();
		Category category = categoryMapper.selectByPrimaryKey(id);
		if(category == null)
			return valueMap;
		Map<String, Object> map = ConversionUtilsAlter.convertBeanToMap(category);
		for(String Key:Keys)
			valueMap.put(Key,map.get(Key));
		return valueMap;
	}
	
	@Override
	public List<Map<String,Object>> getCertainValueOfCategories(List<String> id,String...Keys) {
		List<Map<String,Object>> resultMapList = new ArrayList<Map<String,Object>>();
		//防止向List中添加Map被覆盖
		for(int i = 0 ; i < id.size() ; i++) {
			Map<String,Object> valueMap = new HashMap<String, Object>();
			Category category = categoryMapper.selectByPrimaryKey(id.get(i));
			Map<String, Object> map = ConversionUtilsAlter.convertBeanToMap(category);
			for(String Key:Keys)
				valueMap.put(Key,map.get(Key));
			resultMapList.add(i, valueMap);
		}
		return resultMapList;
	}
	
	@Override
	public Map<String,Object>getCertainValueOfEvent(String id,String...Keys) {
		Map<String, Object> valueMap = new HashMap<String,Object>();
		Event event = eventMapper.selectByPrimaryKey(id);
		if(event == null)
			return valueMap;
		Map<String, Object> map = ConversionUtilsAlter.convertBeanToMap(event);
		for(String Key:Keys)
			valueMap.put(Key,map.get(Key));
		return valueMap;
	}

	@Override
	public List<Map<String,Object>> getCertainValueOfEvents(List<String> id,String...Keys) {
		List<Map<String,Object>> resultMapList = new ArrayList<Map<String,Object>>();
		//防止向List中添加Map被覆盖
		for(int i = 0 ; i < id.size() ; i++) {
			Map<String,Object> valueMap = new HashMap<String, Object>();
			Event event = eventMapper.selectByPrimaryKey(id.get(i));
			Map<String, Object> map = ConversionUtilsAlter.convertBeanToMap(event);
			for(String Key:Keys)
				valueMap.put(Key,map.get(Key));
			resultMapList.add(i, valueMap);
		}
		return resultMapList;
	}
	
	/**
	 * 根据学号或微信得到指定值
	 * 
	 */
	@Override
	public Map<String,Object>getCertainValueOfAppUser(Object studentNo,Object wxId,String...Keys) {
		Map<String, Object> valueMap = new HashMap<String,Object>();
		AppUserExample example = new AppUserExample();
		Criteria criteria = example.createCriteria();
		if(studentNo != null)
			criteria.andStudentNoEqualTo((String)studentNo);
		if(wxId != null)
			criteria.andWxIdEqualTo((String)wxId);
		List<AppUser> list = appUserMapper.selectByExample(example);
		if(list.size() != 1)
			return null;
		Map<String, Object> map = ConversionUtilsAlter.convertBeanToMap(list.get(0));
		for(String Key:Keys)
			valueMap.put(Key,map.get(Key));
		return valueMap;
		
	}
	
	
}