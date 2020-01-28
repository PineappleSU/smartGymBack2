package cn.smartGym.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.smartGym.pojo.Category;
import cn.smartGym.pojo.Competition;
import cn.smartGym.pojoCtr.CategoryCtr;
import cn.smartGym.service.AppUserService;
import cn.smartGym.service.CategoryService;
import cn.smartGym.service.CompetitionService;
import cn.smartGym.utils.ConversionUtils;
import common.enums.ErrorCode;
import common.utils.SGResult;

/** 
* @author Ma Shuaijie:
* 
* @version 创建时间：2019年11月9日 下午2:53:17 
*
* 比赛（大类）Controller 
*/
@Controller
public class CategoryController {
	@Autowired
	CompetitionService competitionService;
	@Autowired
	CategoryService categoryService;
	@Autowired
	AppUserService appUserService;
	
	/**
	 * 获取已有比赛列表
	 * * @author pineapplesu
	 * 			-根据赛事id
	 * 			-权限等级4及以上或为对应赛事负责人
	 */
	@RequestMapping(value = "/smartgym/category/getCategoryList", method = { RequestMethod.POST,
			RequestMethod.GET } , consumes = "application/x-www-form-urlencoded;charset=utf-8")
	@ResponseBody
	public SGResult getCategoryList(CategoryCtr categoryCtr,String user_wxid) {
		int authority = (int) appUserService.getAuthority(user_wxid).get("adminLevel");
		Map<String,Object> map = competitionService.getPrincipalAndJudgeHeaderWxId(categoryCtr.getGame_id());
		if (authority > 3 || map.get("PrincipalWxId").equals (user_wxid))  {
			List<Category> categories =categoryService.getCategoriesListByWxIdAndCompetitionId(ConversionUtils.categoryCtrToDao(categoryCtr));
			return SGResult.ok( "获取已有比赛列表成功！" , ConversionUtils.categoryDaoListToCtrList(categories));
		}else {
			return SGResult.build(ErrorCode.NO_CONTENT.getErrorCode(), "权限不足！");		
		}
	}
	
	/** 
	 * 添加比赛（大类）信息
	 * categoryname比赛名称、competitionid所属赛事id、categorydescription比赛描述
	 * 添加比赛信息时比赛名称与所属赛事id不能为空
	*/
	@RequestMapping(value = "/smartgym/category/addCategory", method = { RequestMethod.POST,
			RequestMethod.GET }, consumes = "application/x-www-form-urlencoded;charset=utf-8")
	@ResponseBody
	public SGResult addCompetition(CategoryCtr categoryCtr,String user_wxid) {
		int authority = (int) appUserService.getAuthority(user_wxid).get("adminLevel");
		Map<String,Object> map = competitionService.getPrincipalAndJudgeHeaderWxId(categoryCtr.getGame_id());

		if (authority > 3 || map.get("PrincipalWxId").equals (user_wxid)){
			Category category = ConversionUtils.categoryCtrToDao(categoryCtr);
			if(category.getCategoryName() == null||category.getCompetitionId() == null||
					competitionService.isLegal(category.getCompetitionId()))
				return SGResult.build(ErrorCode.BAD_REQUEST.getErrorCode(), "输入信息错误！");
			category.setCompetitionName(competitionService.getName(category.getCompetitionId()));
			return categoryService.addCategory(category);
		}
		return SGResult.build(ErrorCode.BAD_REQUEST.getErrorCode(), "权限不足！");
	}
	
	/** 
	 * 修改比赛（大类）信息
	*/
	@RequestMapping(value = "/smartgym/category/updateCategory", method = { RequestMethod.POST,
			RequestMethod.GET }, consumes = "application/x-www-form-urlencoded;charset=utf-8")
	@ResponseBody
	public SGResult updateCategory(CategoryCtr categoryCtr,String user_wxid) {
		Category category = ConversionUtils.categoryCtrToDao(categoryCtr);
		int authority = (int) appUserService.getAuthority(user_wxid).get("adminLevel");
		Map<String,Object> map = competitionService.getPrincipalAndJudgeHeaderWxId(categoryService.getCompetitionId(categoryCtr.getCategory_id()));

		if (authority > 3 || map.get("PrincipalWxId").equals (user_wxid)) {
			if(categoryService.isLegal(category.getCategoryId()))
				return SGResult.build(ErrorCode.BAD_REQUEST.getErrorCode(), "输入信息错误！");
			return categoryService.updateCategory(category);
		}
		return SGResult.build(ErrorCode.BAD_REQUEST.getErrorCode(), "权限不足！");
	}
	
	/** 
	 * 删除比赛（大类）信息，只能输入比赛id
	*/
	@RequestMapping(value = "/smartgym/category/deleteCategory", method = { RequestMethod.POST,
			RequestMethod.GET }, consumes = "application/x-www-form-urlencoded;charset=utf-8")
	@ResponseBody
	public SGResult deleteCategory(String category_id,String user_wxid) {
		int authority = (int) appUserService.getAuthority(user_wxid).get("adminLevel");
		Map<String,Object> map = competitionService.getPrincipalAndJudgeHeaderWxId(categoryService.getCompetitionId(category_id));

		if (authority > 3 || map.get("PrincipalWxId").equals (user_wxid))
			return categoryService.deleteCategory(category_id);
		return SGResult.build(ErrorCode.BAD_REQUEST.getErrorCode(), "权限不足！");	
	}
	
}
