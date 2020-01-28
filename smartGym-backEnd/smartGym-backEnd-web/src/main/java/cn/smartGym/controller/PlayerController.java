package cn.smartGym.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.smartGym.pojo.Competition;
import cn.smartGym.pojo.Event;
import cn.smartGym.pojo.GameApplication;
import cn.smartGym.pojo.Player;
import cn.smartGym.pojoCtr.CompetitionCtr;
import cn.smartGym.pojoCtr.EventCtr;
import cn.smartGym.pojoCtr.PlayerCtr;
import cn.smartGym.service.AppUserService;
import cn.smartGym.service.CompetitionService;
import cn.smartGym.service.EventService;
import cn.smartGym.service.GameApplicationService;
import cn.smartGym.service.PlayerService;
import cn.smartGym.utils.ConversionUtils;
import common.enums.ErrorCode;
import common.utils.SGResult;

/**
 * 参赛人员管理Controller
 * 
 * @author Ma Shuaijie
 *
 */
@Controller
public class PlayerController {

	@Autowired
	PlayerService playerService;
	@Autowired
	GameApplicationService gameApplicationService;
	@Autowired
	AppUserService appUserService;
	@Autowired
	CompetitionService competitionService;
	@Autowired
	EventService eventService;
	
	/** 
	 * 我的报名信息(项目)列表(从gameApplication表中查找)
	*/
	@RequestMapping(value = "/smartgym/player/getMyEventListByStudentNo", method = { RequestMethod.POST,
			RequestMethod.GET }, consumes = "application/x-www-form-urlencoded;charset=utf-8")
	@ResponseBody
	public SGResult getMyEventListByStudentNo(PlayerCtr playerCtr, String user_wxid, int item_process_type) {
		if (playerCtr.getStudent_no() == null || user_wxid == null)
			return SGResult.build(ErrorCode.BAD_REQUEST.getErrorCode(), "输入信息不足！");
		//判断user_wxid与student_no是否与数据库中一致
		if ((List) appUserService.getAppUserListByDetails(user_wxid, playerCtr.getStudent_no()).getData() != null) {
			int size = ((List) appUserService.getAppUserListByDetails(user_wxid, playerCtr.getStudent_no()).getData())
					.size();
			//如果查找到多个数据，则说明数据异常
			if (size == 1) {
				List<GameApplication> gameApplicationList = gameApplicationService
						.getMyGameApplicationListByStudentNo(playerCtr.getStudent_no());
				List<Map<String,Object>> myEventList = new ArrayList<>();
				for(GameApplication gameApplication:gameApplicationList) {
					Map<String, Object> map = new HashMap<String, Object>();
					map.put("game_id",gameApplication.getCompetitionId());
					map.put("game_name",competitionService.getName(gameApplication.getCompetitionId()));
					map.put("item_id",gameApplication.getEventId());
					map.put("item_name",eventService.getName(gameApplication.getEventId()));
					map.put("item_process_type",item_process_type);
					myEventList.add(map);
				}
				return SGResult.build(ErrorCode.SUCCESS.getErrorCode(), "查找成功！", myEventList);
			}
			return SGResult.build(ErrorCode.CONFLICT.getErrorCode(), "微信号异常！");
		}
		return SGResult.build(ErrorCode.CONFLICT.getErrorCode(), "该用户未注册");
	}
	
	/** 
	 * 我的参赛信息(项目)详情(从player表中查找)
	*/
	@RequestMapping(value = "/smartgym/player/getMyEventDetailByStudentNo", method = { RequestMethod.POST,
			RequestMethod.GET }, consumes = "application/x-www-form-urlencoded;charset=utf-8")
	@ResponseBody
	public SGResult getMyEventDetailByStudentNo(PlayerCtr playerCtr, String user_wxid) {
		if (playerCtr.getStudent_no() == null || playerCtr.getItem_id() == null || user_wxid == null)
			return SGResult.build(ErrorCode.BAD_REQUEST.getErrorCode(), "输入信息不足！");
		//判断user_wxid与student_no是否与数据库中一致
		if ((List) appUserService.getAppUserListByDetails(user_wxid, playerCtr.getStudent_no()).getData() != null) {
			int size = ((List) appUserService.getAppUserListByDetails(user_wxid, playerCtr.getStudent_no()).getData())
					.size();
			//如果查找到多个数据，则说明数据异常
			if (size == 1) {
				String studentNo = playerCtr.getStudent_no();
				String eventId = playerCtr.getItem_id();
				Player player = playerService.
						getPlayerInfoByStudentNoAndEventId(studentNo,eventId);
				PlayerCtr playerCtrOut = ConversionUtils.playerDaoToCtr(player);
				CompetitionCtr competitionCtr = (CompetitionCtr) competitionService.getCompetitionById(eventService.getCompetitionId(eventId)).getData();
				EventCtr eventCtr = (EventCtr) eventService.getEventById(eventId).getData();
				//将数据整合入playerCtr
				playerCtrOut.setGame_name(competitionCtr.getGame_name());
				playerCtrOut.setItem_name(eventCtr.getItem_name());
				//未实现item_time
				playerCtrOut.setItem_time(new Date());
				playerCtrOut.setGame_place(eventCtr.getItem_place());
				playerCtrOut.setGame_description(eventCtr.getItem_description());
				return SGResult.build(ErrorCode.SUCCESS.getErrorCode(), "查找成功！", playerCtrOut);
			}
			return SGResult.build(ErrorCode.CONFLICT.getErrorCode(), "微信号异常！");
		}
		return SGResult.build(ErrorCode.CONFLICT.getErrorCode(), "该用户未注册");
	}
	
}
