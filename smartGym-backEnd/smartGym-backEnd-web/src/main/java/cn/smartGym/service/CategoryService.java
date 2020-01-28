package cn.smartGym.service;

import java.util.List;
import java.util.Map;

import cn.smartGym.pojo.Category;
import cn.smartGym.pojo.Competition;
import common.utils.SGResult;

/** 
* @author Ma Shuaijie:
* 
* @version 创建时间：2019年11月9日 下午2:56:11 
*
* 比赛（大类）服务层
*/

public interface CategoryService {
	SGResult addCategory(Category category);

	boolean isLegal(String categoryid);

	SGResult deleteCategory(String categoryid);

	SGResult updateCategory(Category category);

	String getName(String categoryid);

	Map isExist(String categoryid);

	String getCompetitionId(String categoryId);

	List<Category> getCategoriesListByWxIdAndCompetitionId(Category category);
}
