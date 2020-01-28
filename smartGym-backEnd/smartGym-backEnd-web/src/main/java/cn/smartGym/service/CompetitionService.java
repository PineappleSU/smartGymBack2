package cn.smartGym.service;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

import cn.smartGym.pojo.Competition;
import common.utils.SGResult;

/** 
* @author Ma Shuaijie:
* 
* @version 创建时间：2019年11月2日 下午12:22:26 
*
*  赛事服务层
*/

public interface CompetitionService {
	SGResult addCompetition(Competition competition);

	boolean isLegal(String competitionid);

	SGResult deleteCompetition(String competitionid);

	SGResult updateCompetition(Competition competition);

	String getName(String competitionid);

	List<Competition> getCompetitions(Competition competition);
	
	SGResult getCompetitionById(String competitionId);

	SGResult verifyCompetition(String userWxId, String gameID, int authority);

	Map<String, Object> getPrincipalAndJudgeHeaderWxId(String gameID);

	List<Competition> getCompetitionsInCharge(String user_wxid);

}
