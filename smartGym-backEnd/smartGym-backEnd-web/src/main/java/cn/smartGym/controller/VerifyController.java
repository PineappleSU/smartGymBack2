package cn.smartGym.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.smartGym.pojo.GameApplication;
import cn.smartGym.pojoCtr.GameApplicationCtr;
import cn.smartGym.pojoCtr.PlayerCtr;
import cn.smartGym.service.AppUserService;
import cn.smartGym.service.CompetitionService;
import cn.smartGym.service.EventService;
import cn.smartGym.service.GameApplicationService;
import cn.smartGym.service.PlayerService;
import cn.smartGym.service.VerifyService;
import cn.smartGym.utils.ConversionUtils;
import common.enums.ErrorCode;
import common.utils.SGResult;

/** 
* @author Ma Shuaijie:
* 
* @version 创建时间：2020年1月10日 下午2:19:38 
*
* 审核控制层
*/
@Controller
public class VerifyController {
	
	@Autowired
	CompetitionService competitionService;
	@Autowired
	EventService eventService;
	@Autowired
	AppUserService appUserService;
	@Autowired
	PlayerService playerService;
	@Autowired
	GameApplicationService gameApplicationService;
	@Autowired
	VerifyService verifyService;

	/**
	 *院级管理员审核
	 */
	@RequestMapping(value = "/smartgym/verify/verifyApplication", method = { RequestMethod.POST,
			RequestMethod.GET }, consumes = "application/x-www-form-urlencoded")
	@ResponseBody
	public SGResult verifyApplication(GameApplicationCtr gameApplicationCtr) {
		if(gameApplicationCtr.getItem_id()==null || gameApplicationCtr.getPlayer_wxid()==null || gameApplicationCtr.getUser_wxid()==null)
			return SGResult.build(ErrorCode.BAD_REQUEST.getErrorCode(), "输入信息不足");
		String user_wxid = gameApplicationCtr.getUser_wxid();
		int authority = (int) appUserService.getAuthority(user_wxid).get("adminLevel");
		if(authority > 1) {
			GameApplication gameApplication = ConversionUtils.gameApplicationCtrToDao(gameApplicationCtr);
			gameApplication.setUserWxId(gameApplicationCtr.getPlayer_wxid());
			return gameApplicationService.VerifyApplication(gameApplication,gameApplicationCtr.getChecked(),authority);
		}
		return SGResult.build(ErrorCode.BAD_REQUEST.getErrorCode(), "权限不足！");
	}
	
	/** 
	 *负责人与校级管理员审核赛事
	*/
	@RequestMapping(value = "/smartgym/verify/verifyCompetition", method = { RequestMethod.POST,
			RequestMethod.GET }, consumes = "application/x-www-form-urlencoded;charset=utf-8")
	@ResponseBody
	public SGResult verifyCompetition(String user_wxid,String game_id) {
		if(user_wxid == null||game_id ==null)
			return SGResult.build(ErrorCode.BAD_REQUEST.getErrorCode(), "输入信息不足！");
		int authority = (int) appUserService.getAuthority(user_wxid).get("adminLevel");
		if( authority < 3)
			return SGResult.build(ErrorCode.BAD_REQUEST.getErrorCode(), "权限不足！");
		else if (authority > 2 && authority < 4)
			return competitionService.verifyCompetition(user_wxid,game_id,authority);
		else {
			List<GameApplication> gameApplications = gameApplicationService.getAllGameApplication(game_id);
			List<String> eventIdList = eventService.getAllEventByCompetitionId(game_id);
			List<String> msgs = new ArrayList<>();
			for (GameApplication gameApplication: gameApplications) {
				msgs.add(playerService.genPlayerInfo(gameApplication).getMsg());
				gameApplicationService.VerifyApplication(gameApplication,1,authority);
				}
			playerService.genPlayerNo(eventIdList);
			for (String eventId: eventIdList) {
				Integer pathNum = eventService.getPathNum(eventId);
				playerService.genPathNo(eventId,pathNum);
				}
			competitionService.verifyCompetition(user_wxid,game_id,authority);
			return SGResult.build(ErrorCode.SUCCESS.getErrorCode(), "审核通过！",msgs);
		}
	}
	
	/** 
	 *登记成绩
	*/
	@RequestMapping(value = "/smartgym/verify/recordScore", method = { RequestMethod.POST,
			RequestMethod.GET }, consumes = "application/x-www-form-urlencoded;charset=utf-8")
	@ResponseBody
	public SGResult recordScore(PlayerCtr playerCtr,String user_wxid) {
		if(playerCtr.getItem_id() != null || playerCtr.getStudent_no() != null || user_wxid != null)
			return verifyService.recordScore(playerCtr, user_wxid);
		return SGResult.build(ErrorCode.BAD_REQUEST.getErrorCode(), "信息不足！");
	}
	
	/** 
	 *成绩排名
	*/
	@RequestMapping(value = "/smartgym/verify/generateRank", method = { RequestMethod.POST,
			RequestMethod.GET }, consumes = "application/x-www-form-urlencoded;charset=utf-8")
	@ResponseBody
	public SGResult generateRank(PlayerCtr playerCtr,String user_wxid) {
		if(playerCtr.getItem_id() != null || playerCtr.getGender()!= null || user_wxid != null) {
			playerCtr.setItem_name(eventService.getName(playerCtr.getItem_id()));
			return verifyService.generateRank(playerCtr, user_wxid);
			}
		return SGResult.build(ErrorCode.BAD_REQUEST.getErrorCode(), "信息不足！");
	}
}
