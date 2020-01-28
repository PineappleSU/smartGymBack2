package cn.smartGym.controller;

import java.util.List;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.smartGym.pojo.Event;
import cn.smartGym.pojoCtr.EventCtr;
import cn.smartGym.service.AppUserService;
import cn.smartGym.service.CategoryService;
import cn.smartGym.service.CompetitionService;
import cn.smartGym.service.EventService;
import cn.smartGym.utils.ConversionUtils;
import common.enums.ErrorCode;
import common.utils.SGResult;

/** 
* @author Ma Shuaijie:
* 
* @version 创建时间：2019年11月9日 下午2:55:30 
*
* 比赛项目Controller 
*/
@Controller
public class EventController {
	@Autowired
	CompetitionService competitionService;
	@Autowired
	CategoryService categoryService;
	@Autowired
	EventService eventService;
	@Autowired
	AppUserService appUserService;	

	/** 
	 * 获取比赛项目列表
	 * 	 		-根据赛事id、比赛id
	 * 			-权限等级4及以上或为对应赛事负责人
	*/
	@RequestMapping(value = "/smartgym/event/getEventList", method = { RequestMethod.POST,
			RequestMethod.GET }, consumes = "application/x-www-form-urlencoded;charset=utf-8")
	@ResponseBody
	public SGResult getEventList(EventCtr eventCtr,Integer get_type,String user_wxid) {
		int authority = (int) appUserService.getAuthority(user_wxid).get("adminLevel");
		Map<String,Object> map = competitionService.getPrincipalAndJudgeHeaderWxId(eventCtr.getGame_id());
		
		if (authority > 3 || map.get("PrincipalWxId").equals (user_wxid)) {
			if(get_type == null) 
				return SGResult.build(ErrorCode.BAD_REQUEST.getErrorCode(), "请输入get_type值！");
			else {
				List<Event> events = eventService.getEventsByDetails(ConversionUtils.eventCtrToDao(eventCtr), get_type);
				return SGResult.ok("获取项目列表成功！" , ConversionUtils.eventDaoListToCtrList(events));
			}	
		}else {
			return SGResult.build(ErrorCode.NO_CONTENT.getErrorCode(), "权限不足！" );			
		}

	

	}
	
	/** 
	 * 根据id获取比赛项目-尚未加入statues
	*/
	@RequestMapping(value = "/smartgym/event/getEventById", method = { RequestMethod.POST,
			RequestMethod.GET }, consumes = "application/x-www-form-urlencoded;charset=utf-8")
	@ResponseBody
	public SGResult getEventById(EventCtr eventCtr,String user_wxid) {
		int authority = (int) appUserService.getAuthority(user_wxid).get("adminLevel");
		if (authority < 4)
			return SGResult.build(ErrorCode.BAD_REQUEST.getErrorCode(), "权限不足！");
		return  eventService.getEventById(ConversionUtils.eventCtrToDao(eventCtr).getEventId());
	}
	
	/** 
	 * 添加项目信息
	 * eventlevel项目等级（初赛、决赛等） 0-初赛 1-决赛、eventPlace项目举办地点、
	 * eventGender项目组别0-男子组 1-女子组 2-男女混合、eventType项目类型 0-个人赛 1-团体赛 2-接力赛
	 * peopleNum赛道数/参赛人数、rankCriterion计分方式 0-时间 1-距离 2-个数
	 * eventDescription比赛重要备注
	 * 添加项目信息时项目名称eventname与所属比赛（大类）categoryid不能为空
	*/
	@RequestMapping(value = "/smartgym/event/addEvent", method = { RequestMethod.POST,
			RequestMethod.GET }, consumes = "application/x-www-form-urlencoded;charset=utf-8")
	@ResponseBody
	public SGResult addEvent(EventCtr eventCtr,String user_wxid) {
		Event event = ConversionUtils.eventCtrToDao(eventCtr);
		int authority = (int) appUserService.getAuthority(user_wxid).get("adminLevel");
		Map<String,Object> map = competitionService.getPrincipalAndJudgeHeaderWxId(eventCtr.getGame_id());
		
		if (authority > 3 || map.get("PrincipalWxId").equals (user_wxid)){
			if(event.getEventName() == null||event.getCategoryId() == null||
					(boolean) categoryService.isExist(event.getCategoryId()).get("existNum"))
				return SGResult.build(ErrorCode.BAD_REQUEST.getErrorCode(), "输入信息错误！");
			event.setCompetitionName(competitionService.getName(event.getCompetitionId()));
			event.setCategoryName(categoryService.getName(event.getCategoryId()));
			return eventService.addEvent(event);
		}
		return SGResult.build(ErrorCode.BAD_REQUEST.getErrorCode(), "权限不足！");
	}
	
	/** 
	 * 修改项目信息
	*/
	@RequestMapping(value = "/smartgym/event/updateEvent", method = { RequestMethod.POST,
			RequestMethod.GET }, consumes = "application/x-www-form-urlencoded;charset=utf-8")
	@ResponseBody
	public SGResult updateEvent(EventCtr eventCtr,String user_wxid) {
		Event event = ConversionUtils.eventCtrToDao(eventCtr);
		int authority = (int) appUserService.getAuthority(user_wxid).get("adminLevel");
		Map<String,Object> map = competitionService.getPrincipalAndJudgeHeaderWxId(eventService.getCompetitionId(eventCtr.getItem_id()));
		
		if (authority > 3 || map.get("PrincipalWxId").equals (user_wxid)){
			if(eventService.isLegal(event.getEventId()))
				return SGResult.build(ErrorCode.BAD_REQUEST.getErrorCode(), "输入信息错误！");
			return eventService.updateEvent(event);
		}
		return SGResult.build(ErrorCode.BAD_REQUEST.getErrorCode(), "权限不足！");
	}
	
	/** 
	 * 删除比赛项目信息，需要输入项目id
	*/
	@RequestMapping(value = "/smartgym/event/deleteEvent", method = { RequestMethod.POST,
			RequestMethod.GET }, consumes = "application/x-www-form-urlencoded;charset=utf-8")
	@ResponseBody
	public SGResult deleteCompetition(String item_id,String user_wxid) {
		int authority = (int) appUserService.getAuthority(user_wxid).get("adminLevel");
		Map<String,Object> map = competitionService.getPrincipalAndJudgeHeaderWxId(eventService.getCompetitionId(item_id));
		
		if (authority > 3 || map.get("PrincipalWxId").equals (user_wxid)){
		return eventService.deleteEvent(item_id);
		}
		return SGResult.build(ErrorCode.BAD_REQUEST.getErrorCode(), "权限不足！");
	}
	
}
