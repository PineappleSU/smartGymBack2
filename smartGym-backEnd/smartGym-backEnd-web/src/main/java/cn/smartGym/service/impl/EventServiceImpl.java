package cn.smartGym.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.smartGym.mapper.CategoryMapper;
import cn.smartGym.mapper.CompetitionMapper;
import cn.smartGym.mapper.EventMapper;
import cn.smartGym.pojo.Event;
import cn.smartGym.pojo.EventExample;
import cn.smartGym.pojo.EventExample.Criteria;
import cn.smartGym.service.EventService;
import cn.smartGym.utils.ConversionUtils;
import common.enums.ErrorCode;
import common.utils.IDUtils;
import common.utils.SGResult;

/** 
* @author Ma Shuaijie:
* 
* @version 创建时间：2019年11月9日 下午2:58:33 
*
* 比赛项目服务实现层
*/
@Service
public class EventServiceImpl implements EventService{
	@Autowired
	private EventMapper eventMapper;
	@Autowired
	private CompetitionMapper competitionMapper;
	@Autowired
	private CategoryMapper categoryMapper;
	
	/**
	 * 获取已有项目列表
	 * 			-type = 0 根据赛事id type = 1 根据比赛id
	 * 
	 */
	@Override
	public List<Event> getEventsByDetails(Event event, Integer type){
		
		EventExample example = new EventExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(1);
		if(type == 0)
			criteria.andCompetitionIdEqualTo(event.getCompetitionId());
		if(type == 1)
			criteria.andCategoryIdEqualTo(event.getCategoryId());
		List<Event> events = eventMapper.selectByExample(example);
		return events;
	}
	
	/**
	 * 获取具体项目信息
	 * 			-根据eventId
	 */
	@Override
	public SGResult getEventById(String eventId) {
		Event event = eventMapper.selectByPrimaryKey(eventId);
		if(event == null)
			return SGResult.build(ErrorCode.NO_CONTENT.getErrorCode(), "没有找到您要找的项目信息！");
		return SGResult.ok("返回项目信息成功！", ConversionUtils.eventDaoToCtr(event));
	}
	
	@Override
	public List<String> getEventIdsByEvents(List<Event> events){
		ArrayList<String> eventIds = new ArrayList<>();
		for(Event event : events) {
			eventIds.add(event.getEventId());
		}
		return eventIds;
	}
	
	/**
	 * 获取具体项目信息
	 * 			-根据eventId,statues
	 */
	public Event getEventByEventIdAndStatuses(String eventId, Integer... statuses) { 
		// 根据项目id和状态status查询比赛项目信息
		EventExample example = new EventExample();
		Criteria criteria = example.createCriteria();
		criteria.andEventIdEqualTo(eventId);
		if (statuses == null || statuses.length == 0 || !Arrays.asList(statuses).contains(0))
			criteria.andStatusNotEqualTo(0);
		if (statuses != null && statuses.length != 0)
			// 0-已取消 1-正在报名 2-已结束
			criteria.andStatusIn(Arrays.asList(statuses));

		List<Event> eventList = eventMapper.selectByExample(example);
		if (eventList== null || eventList.size() <= 0)
			return null;
		else
			return eventList.get(0);
	}
	
	/**
	 * 获取具体项目信息
	 * 			-根据：competitionName, categoryName, event.., statues
	 */

	public List<Event> getEventByDetailsAndStatuses(Event event, Integer... statuses) {
		EventExample example = new EventExample();
		Criteria criteria = example.createCriteria();

		if (statuses == null || statuses.length == 0)
			criteria.andStatusNotEqualTo(0);
		else
			criteria.andStatusIn(Arrays.asList(statuses));

		if (event != null) {
			if (!StringUtils.isBlank(event.getEventName()))
				criteria.andEventNameEqualTo(event.getEventName());
			if(!StringUtils.isBlank(event.getCompetitionId()))
				criteria.andCompetitionIdEqualTo(event.getCompetitionId());
			if (!StringUtils.isBlank(event.getCompetitionName()))
				criteria.andCompetitionNameEqualTo(event.getCompetitionName());
			if (!StringUtils.isBlank(event.getCategoryName()))
				criteria.andCategoryNameEqualTo(event.getCategoryName());
			//项目组别 0-男子组 1-女子组 2-男女混合组
			if (event.getEventGender() != null && !StringUtils.isBlank(event.getEventGender().toString()))
				criteria.andEventGenderEqualTo(event.getEventGender());
			//项目类型 0-个人赛 1-团体赛 2-接力赛
			if (event.getEventType() != null)			
				criteria.andEventTypeEqualTo(event.getEventType());
			if (event.getEventId() != null)
				criteria.andEventIdEqualTo(event.getEventId());
			if(event.getEventPlace() != null)
				criteria.andEventPlaceEqualTo(event.getEventPlace());
			//项目等级（初赛、决赛等） 0-初赛 1-决赛
			if(event.getEventLevel() != null)
				criteria.andEventLevelEqualTo(event.getEventLevel());
			if(event.getJudgeWxid() != null)
				criteria.andJudgeWxidEqualTo(event.getJudgeWxid());
			
		}

		// 执行查询
		List<Event> eventList = eventMapper.selectByExample(example);
		return eventList;
		
	}
	
	
	/**
	 * 获取比赛及赛事备注
	 * 			-根据eventID，List(0)赛事备注，List(1)比赛备注
	 */
	@Override
	public List<String> getDescription(String eventId){
		Event event = eventMapper.selectByPrimaryKey(eventId);
		String competitionId = event.getCompetitionId();
		String categoryId = event.getCategoryId();
		String competitionDescription = competitionMapper.selectByPrimaryKey(competitionId).getCompetitionDescription();
		String categoryDescription = categoryMapper.selectByPrimaryKey(categoryId).getCategoryDescription();
		List<String> listout = new ArrayList<>();
		listout.add(competitionDescription);
		listout.add(categoryDescription);
		return listout;
	}
	
	/** 
	 * 添加项目信息
	*/
	@Override
	public SGResult addEvent(Event event) {
		EventExample example = new EventExample();
		Criteria criteria = example.createCriteria();
//		获取同一比赛（大类）下的项目数目，用于编号
		criteria.andCategoryIdEqualTo(event.getCategoryId());
		int existNum = eventMapper.selectByExample(example).size();
//		以项目名称为准防止重复
		criteria.andEventNameEqualTo(event.getEventName());
		criteria.andStatusEqualTo(1);
		int sameNum = eventMapper.selectByExample(example).size();
		
		if(sameNum ==0) {
			event.setEventId(IDUtils.ceID(existNum, event.getCategoryId()));
			event.setCompetitionId(event.getCategoryId().split("sj")[0]);
			event.setStatus(1);
			event.setCreated(new Date());
			event.setUpdated(new Date());
			eventMapper.insert(event);
			return SGResult.build(ErrorCode.SUCCESS.getErrorCode(), "添加成功！");
		}
		return SGResult.build(ErrorCode.CONFLICT.getErrorCode(), "添加失败，项目已存在！");
	}
	
	/** 
	 * 修改比赛项目信息
	*/
	@Override
	public SGResult updateEvent(Event event) {
		event.setUpdated(new Date());
		eventMapper.updateByPrimaryKeySelective(event);
		return SGResult.build(ErrorCode.SUCCESS.getErrorCode(), "修改成功！");
	}
	
	/** 
	 * 删除比赛项目（软删除）
	*/
	@Override
	public SGResult deleteEvent(String eventid) {
		EventExample example = new EventExample();
		Criteria criteria = example.createCriteria();
		criteria.andEventIdEqualTo(eventid);
		criteria.andStatusEqualTo(1);
		List<Event> list = eventMapper.selectByExample(example);
		if(list == null || list.size() == 0)
			return SGResult.build(ErrorCode.NO_CONTENT.getErrorCode(), "找不到该资源！");
		Event event = list.get(0);
		event.setStatus(0);
		event.setUpdated(new Date());
		eventMapper.updateByPrimaryKeySelective(event);
		return SGResult.build(ErrorCode.SUCCESS.getErrorCode(), "删除成功！");
	}
	
	/** 
	 * 验证项目id是否存在，返回是否存在，1-不存在，0-存在
	*/
	@Override
	public boolean isLegal(String eventid) {
		EventExample example = new EventExample();
		Criteria criteria = example.createCriteria();
		criteria.andEventIdEqualTo(eventid);
		criteria.andStatusEqualTo(1);
		int existNum = eventMapper.selectByExample(example).size();
		return existNum == 0;
				
	}
	
	@Override
	public Map<String,Object> isExist(String eventid) {
		EventExample example = new EventExample();
		Criteria criteria = example.createCriteria();
		criteria.andEventIdEqualTo(eventid);
		criteria.andStatusEqualTo(1);
		Map<String,Object> map = new HashMap<>(); 
		List<Event> List = eventMapper.selectByExample(example);
		map.put("existNum", List.size()==0);
		map.put("Name", List.get(0).getEventName());
		return map;			
	}

	/** 
	 * 根据项目id获取项目名称
	*/
	@Override
	public String getName (String eventid) {
		EventExample example = new EventExample();
		Criteria criteria = example.createCriteria();
		criteria.andEventIdEqualTo(eventid);
		criteria.andStatusEqualTo(1);
		Event event = eventMapper.selectByExample(example).get(0);
		return event.getEventName();
	}
	
	/** 
	 * 根据项目id查询赛事id
	*/
	@Override
	public String getCompetitionId(String eventId){
		Event event = eventMapper.selectByPrimaryKey(eventId);
		return event.getCompetitionId();
	}
	
	/** 
	 * 根据赛事id查询下属的所有项目id
	*/
	@Override
	public List<String> getAllEventByCompetitionId(String competitionId){
		EventExample example = new EventExample();
		Criteria criteria = example.createCriteria();
		criteria.andCompetitionIdEqualTo(competitionId);
		criteria.andStatusNotEqualTo(0);
		List<Event> eventList = eventMapper.selectByExample(example);
		List<String> eventIdList = new ArrayList<>();
		for(Event event:eventList) {
			eventIdList.add(event.getEventId());
		}
		return eventIdList;
	}
	/** 
	 * 根据项目id获取赛事数
	*/
	@Override
	public Integer getPathNum(String eventId){
		Event event = eventMapper.selectByPrimaryKey(eventId);
		if(event !=null && event.getPeopleNum()!= null)
			return event.getPeopleNum();
		return 0;
	}
}
