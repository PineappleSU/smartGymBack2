package cn.smartGym.controller;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.smartGym.pojo.Competition;
import cn.smartGym.pojo.GameApplication;
import cn.smartGym.pojoCtr.CompetitionCtr;
import cn.smartGym.service.AppUserService;
import cn.smartGym.service.CompetitionService;
import cn.smartGym.service.GameApplicationService;
import cn.smartGym.service.GetCertainValueService;
import cn.smartGym.service.PlayerService;
import cn.smartGym.utils.ConversionUtils;
import common.enums.ErrorCode;
import common.utils.SGResult;

/** 
* @author Ma Shuaijie:
* 
* @version 创建时间：2019年11月2日 下午12:04:20 
*
* 赛事信息controller 
*/
@Controller
public class CompetitionController {
	@Autowired
	CompetitionService competitionService;
	@Autowired
	AppUserService appUserService;
	@Autowired
	PlayerService playerService;
	@Autowired
	GameApplicationService gameApplicationService;
	@Autowired
	GetCertainValueService getCertainValueService;

	/**
	 * 获取已有赛事列表
	 * * @author pineapplesu
	 */
	@RequestMapping(value = "/smartgym/competition/getCompetitionList", method = { RequestMethod.POST,
			RequestMethod.GET } , consumes = "application/x-www-form-urlencoded;charset=utf-8")
	@ResponseBody
	public SGResult getCompetitionList(CompetitionCtr competitionCtr,String user_wxid) {
		//仅权限4及以上的管理员可以获取赛事列表
		int authority = (int) appUserService.getAuthority(user_wxid).get("adminLevel");
		if (authority < 4)
			return SGResult.build(ErrorCode.BAD_REQUEST.getErrorCode(), "权限不足！");
		List<Competition> competitions = competitionService.getCompetitions(ConversionUtils.competitionCtrToDao(competitionCtr));
		if(competitions == null || competitions.size() == 0) 
			return SGResult.build(ErrorCode.NO_CONTENT.getErrorCode(), "未暂无赛事信息！");
		return SGResult.ok( "返回赛事列表成功!" , ConversionUtils.competitionDaoListToCtrList(competitions));
		}
	
	/**
	 * 获取所管理的赛事列表
	 */
	@RequestMapping(value = "/smartgym/competition/getCompetitionListInCharge", method = { RequestMethod.POST,
			RequestMethod.GET } , consumes = "application/x-www-form-urlencoded;charset=utf-8")
	@ResponseBody
	public SGResult getCompetitionListInCharge(String user_wxid) {
		//仅权限4及以上的管理员可以获取赛事列表
		int authority = (int) appUserService.getAuthority(user_wxid).get("adminLevel");
		List<Competition> competitions = competitionService.getCompetitionsInCharge(user_wxid);
		if(competitions == null || competitions.size() == 0) 
			return SGResult.build(ErrorCode.NO_CONTENT.getErrorCode(), "未暂无赛事信息！");
		return SGResult.ok( "返回赛事列表成功!" , ConversionUtils.competitionDaoListToCtrList(competitions));
		}
	
	/**
	 * 获取具体赛事信息
	 * * @author pineapplesu
	 */
	@RequestMapping(value = "/smartgym/competition/getCompetitionById", method = { RequestMethod.POST,
			RequestMethod.GET }, consumes = "application/x-www-form-urlencoded;charset=utf-8")
	@ResponseBody
	public SGResult getCompetitionById(CompetitionCtr competitionCtr,String user_wxid) {
		//仅权限3及以上的管理员可以获取具体赛事信息
		int authority = (int) appUserService.getAuthority(user_wxid).get("adminLevel");
		if (authority < 3)
			return SGResult.build(ErrorCode.BAD_REQUEST.getErrorCode(), "权限不足！");
		return competitionService.getCompetitionById(competitionCtr.getGame_id());
	}
	
	/** 
	 * 添加赛事信息
	 * competitionname赛事名称、competitiontype1赛事类型1、competitiontype2赛事类型2、department部门
	 * principalwxid赛事负责人微信号、judgeheaderwxid裁判长微信号、applystarttime申请开始时间
	 * checkstarttime审核开始时间、checkendtime审核结束时间、starttime赛事开始时间、endtime赛事结束时间
	 * competitionplace赛事场地、competitiondescription赛事备注
	 * 添加赛事信息时赛事名称与赛事负责人微信号不能为空，其余信息可后续添加（修改）
	*/
	@RequestMapping(value = "/smartgym/competition/addCompetition", method = { RequestMethod.POST,
			RequestMethod.GET }, consumes = "application/x-www-form-urlencoded;charset=utf-8")
	@ResponseBody
	public SGResult addCompetition(CompetitionCtr competitionCtr,String user_wxid) {
		int authority = (int) appUserService.getAuthority(user_wxid).get("adminLevel");
		if (authority < 4)
			return SGResult.build(ErrorCode.BAD_REQUEST.getErrorCode(), "权限不足！");	
		Competition competition = ConversionUtils.competitionCtrToDao(competitionCtr);
		if(competition.getCompetitionName() == null||competition.getPrincipalWxid() == null)
			return SGResult.build(ErrorCode.BAD_REQUEST.getErrorCode(), "输入信息不足！");
		if(competition.getCompetitionType1() == null)
			//默认类型为校运会(类型为1)
			competition.setCompetitionType1(1);
		if(competition.getCompetitionType2() == null)
			//默认类型为0
			competition.setCompetitionType2(0);
		return competitionService.addCompetition(competition);
	}
	
	/** 
	 * 修改赛事信息
	*/
	@RequestMapping(value = "/smartgym/competition/updateCompetition", method = { RequestMethod.POST,
			RequestMethod.GET }, consumes = "application/x-www-form-urlencoded;charset=utf-8")
	@ResponseBody
	public SGResult updateCompetition(CompetitionCtr competitionCtr,String user_wxid) {
		int authority = (int) appUserService.getAuthority(user_wxid).get("adminLevel");
		if (authority < 4)
			return SGResult.build(ErrorCode.BAD_REQUEST.getErrorCode(), "权限不足！");
		
		Competition competition = ConversionUtils.competitionCtrToDao(competitionCtr);
		if(competitionService.isLegal(competition.getCompetitionId()))
			return SGResult.build(ErrorCode.BAD_REQUEST.getErrorCode(), "输入信息错误！");
		return competitionService.updateCompetition(competition);
	}
	
	/** 
	 * 删除赛事信息，只用输入赛事id
	*/
	@RequestMapping(value = "/smartgym/competition/deleteCompetition", method = { RequestMethod.POST,
			RequestMethod.GET }, consumes = "application/x-www-form-urlencoded;charset=utf-8")
	@ResponseBody
	public SGResult deleteCompetition(String game_id,String user_wxid) {
		int authority = (int) appUserService.getAuthority(user_wxid).get("adminLevel");
		if (authority < 4)
			return SGResult.build(ErrorCode.BAD_REQUEST.getErrorCode(), "权限不足！");
		return competitionService.deleteCompetition(game_id);
	}
	
//	/**
//	 * ceshiController
//	 * */
//	@RequestMapping(value = "/test", method = { RequestMethod.POST,
//			RequestMethod.GET } , consumes = "application/x-www-form-urlencoded;charset=utf-8")
//	@ResponseBody
//	public Map<String,Object> test(String game_id){
//		return getCertainValueService.getCertainValueOfCompetition(game_id,"game_description","game_descriptssion","game_descriptions","game_descriptiossn");
//	}
	
}
