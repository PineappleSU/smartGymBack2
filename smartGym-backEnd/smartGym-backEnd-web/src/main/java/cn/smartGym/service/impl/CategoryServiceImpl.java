package cn.smartGym.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.smartGym.mapper.CategoryMapper;
import cn.smartGym.mapper.CompetitionMapper;
import cn.smartGym.pojo.Category;
import cn.smartGym.pojo.CategoryExample;
import cn.smartGym.pojo.CategoryExample.Criteria;
import cn.smartGym.pojo.Competition;
import cn.smartGym.service.CategoryService;
import common.enums.ErrorCode;
import common.utils.IDUtils;
import common.utils.SGResult;

/** 
* @author Ma Shuaijie:
* 
* @version 创建时间：2019年11月9日 下午2:57:06 
*
* 比赛（大类）服务实现层
*/
@Service
public class CategoryServiceImpl implements CategoryService{
	@Autowired
	private CategoryMapper categoryMapper;
	@Autowired
	private CompetitionMapper competitionMapper;
	 
	/**
	 * 根据id返回具体比赛信息
	 */
	@Override
	public List<Category> getCategoriesListByWxIdAndCompetitionId(Category category) {
		CategoryExample example = new CategoryExample();
		Criteria criteria = example.createCriteria();
		if(category.getJudgeWxid() != null) {
			if(category.getCompetitionId() != null)
				criteria.andCompetitionIdEqualTo(category.getCompetitionId());
		}
		criteria.andStatusEqualTo(1);
		List<Category> categoriesList = categoryMapper.selectByExample(example);
		return categoriesList;
	}
	
	/** 
	 * 添加比赛（大类）信息
	*/
	@Override
	public SGResult addCategory(Category category) {
		CategoryExample example = new CategoryExample();
		Criteria criteria = example.createCriteria();
//		获取同一赛事下的大类数目，用于编号
		criteria.andCompetitionIdEqualTo(category.getCompetitionId());
		int existNum = categoryMapper.selectByExample(example).size();
//		以赛事名称为准防止重复
		criteria.andCategoryNameEqualTo(category.getCategoryName());
		criteria.andStatusEqualTo(1);
		int sameNum = categoryMapper.selectByExample(example).size();
		
		if(sameNum ==0) {
			category.setCategoryId(IDUtils.ceID(existNum,category.getCompetitionId()));
			if(category.getStatus()==null)
				category.setStatus(1);
			category.setCreated(new Date());
			category.setUpdated(new Date());
			categoryMapper.insert(category);
			return SGResult.build(ErrorCode.SUCCESS.getErrorCode(), "添加成功！");
		}
		return SGResult.build(ErrorCode.CONFLICT.getErrorCode(), "添加失败，比赛已存在！");
	}
	
	/** 
	 * 修改比赛（大类）信息
	*/
	@Override
	public SGResult updateCategory(Category category) {
		category.setUpdated(new Date());
		categoryMapper.updateByPrimaryKeySelective(category);
		return SGResult.build(ErrorCode.SUCCESS.getErrorCode(), "修改成功！");
	}
	
	/** 
	 * 删除比赛（大类）（软删除）
	*/
	@Override
	public SGResult deleteCategory(String categoryid) {
		CategoryExample example = new CategoryExample();
		Criteria criteria = example.createCriteria();
		criteria.andCategoryIdEqualTo(categoryid);
		criteria.andStatusEqualTo(1);
		List<Category> list = categoryMapper.selectByExample(example);
		if(list == null || list.size() == 0)
			return SGResult.build(ErrorCode.NO_CONTENT.getErrorCode(), "找不到该资源！");
		Category category = list.get(0);
		category.setStatus(0);
		category.setUpdated(new Date());
		categoryMapper.updateByPrimaryKeySelective(category);
		return SGResult.build(ErrorCode.SUCCESS.getErrorCode(), "删除成功！");
	}
		
	/** 
	 * 根据比赛id查询赛事id
	*/
	@Override
	public String getCompetitionId(String categoryId){
		Category category = categoryMapper.selectByPrimaryKey(categoryId);
		return category.getCompetitionId();
	}
	
	/** 
	 * 根据比赛id获取比赛名称
	*/
	@Override
	public String getName(String categoryid){
		CategoryExample example = new CategoryExample();
		Criteria criteria = example.createCriteria();
		criteria.andCategoryIdEqualTo(categoryid);
		criteria.andStatusEqualTo(1);
		Category category = categoryMapper.selectByExample(example).get(0);
		return category.getCategoryName();
	}

	/** 
	 * 验证比赛（大类）id是否存在，返回是否存在，1-不存在，0-存在
	*/
	@Override
	public boolean isLegal(String categoryid){
		CategoryExample example = new CategoryExample();
		Criteria criteria = example.createCriteria();
		criteria.andCategoryIdEqualTo(categoryid);
		criteria.andStatusEqualTo(1);
		int existNum = categoryMapper.selectByExample(example).size();
		return existNum == 0;		
	}
	
	@Override
	public Map<String,Object> isExist(String categoryid) {
		CategoryExample example = new CategoryExample();
		Criteria criteria = example.createCriteria();
		criteria.andCategoryIdEqualTo(categoryid);
		criteria.andStatusEqualTo(1);
		Map<String,Object> map = new HashMap<>(); 
		List<Category> List = categoryMapper.selectByExample(example);
		map.put("existNum", List.size()!=1);
		map.put("Name", List.get(0).getCategoryName());
		return map;			
	}
	
}
