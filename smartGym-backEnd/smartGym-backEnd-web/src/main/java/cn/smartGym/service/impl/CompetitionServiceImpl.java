package cn.smartGym.service.impl;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.smartGym.mapper.CompetitionMapper;
import cn.smartGym.pojo.Competition;
import cn.smartGym.pojo.CompetitionExample;
import cn.smartGym.pojo.CompetitionExample.Criteria;
import cn.smartGym.service.CompetitionService;
import cn.smartGym.utils.ConversionUtils;
import common.enums.ErrorCode;
import common.utils.IDUtils;
import common.utils.SGResult;

/** 
* @author Ma Shuaijie:
* 
* @version 创建时间：2019年11月2日 下午12:23:30 
*
* 赛事服务实现层
*/
@Service
public class CompetitionServiceImpl implements CompetitionService{
	@Autowired
	private CompetitionMapper competitionMapper;
	
	/**
	 * 获得所有赛事列表-(根据微信号）
	 */
	@Override
	public List<Competition> getCompetitions(Competition competition) {
		
		CompetitionExample example = new CompetitionExample();
		Criteria criteria = example.createCriteria();

		criteria.andStatusEqualTo(1);
		criteria.andSearchTypeEqualTo(competition.getSearchType());
		if(competition.getCompetitionType1() != 0)
			criteria.andCompetitionType1EqualTo(competition.getCompetitionType1());
		List<Competition> competitionList = competitionMapper.selectByExample(example);
		System.out.println(competitionList);
		return competitionList;	
	}
	
	/**
	 * 根据competitionId返回具体赛事信息
	 */
	@Override
	public SGResult getCompetitionById(String competitionId) {
		Competition competition = competitionMapper.selectByPrimaryKey(competitionId);
		if (competitionId == null) 
			return SGResult.build(ErrorCode.NO_CONTENT.getErrorCode(), "没有找到您要找的赛事信息！");	
		return SGResult.ok("查找赛事信息成功！", ConversionUtils.competitionDaoToCtr(competition));
	}

	/** 
	 * 添加赛事信息
	*/
	@Override
	public SGResult addCompetition(Competition competition) {
		//获取赛事开始年份,默认是添加该记录时的年份
		Calendar startTime = Calendar.getInstance();
		if(competition.getCompetitionStartTime()==null) {
			startTime.setTime(new Date());
			competition.setCompetitionStartTime(new Date());
		}
		else 
			startTime.setTime(competition.getCompetitionStartTime());
		int year = startTime.get(Calendar.YEAR);
		//设置查找条件
		CompetitionExample example = new CompetitionExample();
		Criteria criteria = example.createCriteria();
		criteria.andYearEqualTo(year);
		//获取同年份已存在的不同赛事数目
		int existNum = competitionMapper.selectByExample(example).size();	
		//以比赛名称为准防止重复添加
		criteria.andCompetitionNameEqualTo(competition.getCompetitionName());
		criteria.andStatusEqualTo(1);
		int sameNum = competitionMapper.selectByExample(example).size();
		if(sameNum == 0) {
			int type1 = competition.getCompetitionType1();
			int type2 = competition.getCompetitionType2();
			competition.setCompetitionId(IDUtils.comID(existNum,type1,type2,year));
			competition.setYear(year);
			competition.setStatus(1);
			competitionMapper.insert(competition);
			return SGResult.build(ErrorCode.SUCCESS.getErrorCode(), "添加成功！");
			}
		return SGResult.build(ErrorCode.CONFLICT.getErrorCode(), "添加失败，赛事已存在！");	
	}
	
	/** 
	 * 修改赛事信息
	*/
	@Override
	public SGResult updateCompetition(Competition competition) {
		competitionMapper.updateByPrimaryKeySelective(competition);
		return SGResult.build(ErrorCode.SUCCESS.getErrorCode(), "修改成功！");
	}
	
	/** 
	 * 删除赛事（软删除）
	*/
	@Override
	public SGResult deleteCompetition(String competitionid) {
		CompetitionExample example = new CompetitionExample();
		Criteria criteria = example.createCriteria();
		criteria.andCompetitionIdEqualTo(competitionid);
		criteria.andStatusEqualTo(1);
		List<Competition> list = competitionMapper.selectByExample(example);
		if(list == null || list.size() == 0)
			return SGResult.build(ErrorCode.NO_CONTENT.getErrorCode(), "找不到该资源！");
		Competition competition = list.get(0);
		competition.setStatus(0);
		competitionMapper.updateByPrimaryKeySelective(competition);
		return SGResult.build(ErrorCode.SUCCESS.getErrorCode(), "删除成功！");
	}
	
	/** 
	 *审核赛事
	*/
	@Override
	public SGResult verifyCompetition(String userWxId, String gameID,int authority) {
		Competition competition = competitionMapper.selectByPrimaryKey(gameID);
		if(competition.getStatus()==0)
			return SGResult.build(ErrorCode.NO_CONTENT.getErrorCode(), "赛事请求错误！");
		if(authority == 3||competition.getStatus() < 2)
			competition.setStatus(2);
		else if(authority > 3)
			competition.setStatus(3);
		competitionMapper.updateByPrimaryKeySelective(competition);
		return SGResult.build(ErrorCode.SUCCESS.getErrorCode(), "审核通过！");
	}
	
	/** 
	 * 验证赛事id是否存在，1-不存在，0-存在
	*/
	@Override
	public boolean isLegal(String competitionid) {
		CompetitionExample example = new CompetitionExample();
		Criteria criteria = example.createCriteria();
		criteria.andCompetitionIdEqualTo(competitionid);
		criteria.andStatusEqualTo(1);
		int existNum = competitionMapper.selectByExample(example).size();
		return existNum == 0;
				
	}
		
	/** 
	 * 根据赛事id获取赛事名称
	*/
	@Override
	public String getName(String competitionid){
		CompetitionExample example = new CompetitionExample();
		Criteria criteria = example.createCriteria();
		criteria.andCompetitionIdEqualTo(competitionid);
		criteria.andStatusNotEqualTo(0);
		Competition competition = competitionMapper.selectByExample(example).get(0);
		return competition.getCompetitionName();
	}

	/** 
	 *获取赛事负责人与裁判长wxid
	*/
	@Override
	public Map<String, Object> getPrincipalAndJudgeHeaderWxId(String gameID) {
		Competition competition = competitionMapper.selectByPrimaryKey(gameID);
		Map<String, Object> wxidMap = new HashMap<String, Object>();
		if(competition == null)
			return wxidMap;
		wxidMap.put("PrincipalWxId",competition.getPrincipalWxid());
		wxidMap.put("JudgeHeaderWxId",competition.getJudgeHeaderWxid());
		return wxidMap;
	}

	/**
	 * 获取所管理的赛事列表
	 */
	@Override
	public List<Competition> getCompetitionsInCharge(String wxId) {
		CompetitionExample example  = new CompetitionExample();
		Criteria criteria = example.createCriteria();
		criteria.andPrincipalWxidEqualTo(wxId);
		criteria.andSearchTypeNotEqualTo(4);
		List<Competition> competitions = competitionMapper.selectByExample(example);
		return competitions;
	}
	
}
