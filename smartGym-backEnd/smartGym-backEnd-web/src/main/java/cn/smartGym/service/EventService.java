package cn.smartGym.service;

import java.util.List;

import java.util.Map;

import cn.smartGym.pojo.Event;
import common.utils.SGResult;

/** 
* @author Ma Shuaijie:
* 
* @version 创建时间：2019年11月9日 下午2:56:32 
*
* 比赛项目服务层 
*/

public interface EventService {

	SGResult addEvent(Event event);

	boolean isLegal(String eventid);

	SGResult deleteEvent(String eventid);

	SGResult updateEvent(Event event);

	String getName(String eventid);

	Map<String,Object> isExist(String eventid);
	
	List<Event> getEventsByDetails(Event event, Integer type);
	
	Event getEventByEventIdAndStatuses(String eventId, Integer... statuses);

	List<Event> getEventByDetailsAndStatuses(Event event, Integer... statuses);

	SGResult getEventById(String eventId);
	
	List<String> getDescription(String eventId);

	List<String> getEventIdsByEvents(List<Event> events);

	String getCompetitionId(String eventId);

	List<String> getAllEventByCompetitionId(String competitionId);

	Integer getPathNum(String eventId);

}
