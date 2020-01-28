package cn.smartGym.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.smartGym.mapper.EventMapper;
import cn.smartGym.mapper.GameApplicationMapper;
import cn.smartGym.pojo.AppUser;
import cn.smartGym.pojo.Application;
import cn.smartGym.pojo.ApplicationExample;
import cn.smartGym.pojo.Event;
import cn.smartGym.pojo.GameApplication;
import cn.smartGym.pojo.GameApplicationExample;
import cn.smartGym.pojo.GameApplicationExample.Criteria;
import cn.smartGym.pojo.Item;
import cn.smartGym.pojo.Player;
import cn.smartGym.pojo.PlayerExample;
import cn.smartGym.pojoCtr.GameApplicationCtr;
import cn.smartGym.service.CollegeService;
import cn.smartGym.service.EventService;
import cn.smartGym.service.GameApplicationService;
import cn.smartGym.utils.CollegeAndCampusUtils;
import cn.smartGym.utils.ConversionUtils;
import common.enums.ErrorCode;
import common.enums.Gender;
import common.enums.GenderGroup;
import common.enums.Job;
import common.utils.ExcelHelper;
import common.utils.IDUtils;
import common.utils.SGResult;

@Service
public class GameApplicationServiceImpl implements GameApplicationService{
	
	@Autowired
	private GameApplicationMapper gameApplicationMapper;
	
	@Autowired
	private EventService eventService;
	
	@Autowired
	private CollegeService collegeService;
	
	/**
	 * 
	 */
	@Override
	public SGResult updateUser(AppUser userUpdate) {
		GameApplicationExample example = new GameApplicationExample();
		Criteria criteria = example.createCriteria();

		if (StringUtils.isNotBlank(userUpdate.getStudentNo()))
			criteria.andStudentNoEqualTo(userUpdate.getStudentNo());

		GameApplication gameApplicationExample = new GameApplication();
		gameApplicationExample.setName(userUpdate.getUserName());
		gameApplicationExample.setCollege(userUpdate.getCollege());
		gameApplicationExample.setUpdated(new Date());
		gameApplicationMapper.updateByExampleSelective(gameApplicationExample, example);

		return SGResult.ok();
	}

	
	/**
	 * 生成比赛报名表
	 * 			-根据competition, college
	 */
	@Override
	public void generateGameApplicationsExcelByCollege(String competition, String college) throws IOException {
		// 构建Excel文件路径
		String filePath = getGameApplicationsExcelFilePath(competition, college);
		// 获取Excel标题行数据
		List<String> title = Arrays.asList(ExcelHelper.applicationsExcelTitleArray);
		// 获取applicationsData
		Event event = new Event();		
		event.setCompetitionName(competition);
		List<Event> events = eventService.getEventByDetailsAndStatuses(event,1,2,3);
		List<String> eventIds = eventService.getEventIdsByEvents(events);
		
		List<GameApplication> applications = getGameApplicationListByEventIdsAndCollegeAndStatus(eventIds, college, 2, 3);
		List<List<String>> applicationData = new ArrayList<>();
		for (GameApplication application : applications) {
			applicationData.add(convertGameApplicationToRowData(application));
		}
		ExcelHelper.writeExcel(title, applicationData, filePath);
	}
	
	/**
	 * 获取报名Excel的文件路径
	 * @param comprtition
	 * @param college
	 * @return
	 */
	@Override
	public String getGameApplicationsExcelFilePath(String competition, String college) {
		String fileName = String.valueOf((competition + college).hashCode());
		//String filePath = "downloadFiles/" + fileName + ".xls";
		String filePath =  fileName + ".xls";
		return filePath;
	}

	/**
	 * 获取报名记录
	 * 			-根据项目id、学院和状态
	 */
	@Override
	public List<GameApplication> getGameApplicationListByEventIdsAndCollegeAndStatus(List<String> eventIds, String college,
			Integer... statuses) {
		GameApplicationExample example = new GameApplicationExample();
		cn.smartGym.pojo.GameApplicationExample.Criteria criteria = example.createCriteria();
		if (eventIds != null && eventIds.size() !=0)
			criteria.andEventIdIn(eventIds);		
		if (statuses != null & statuses.length != 0)
			criteria.andStatusIn(Arrays.asList(statuses));
		if (!StringUtils.isBlank(college))
			if (college != null && !college.equals("total"))
				criteria.andCollegeEqualTo(CollegeAndCampusUtils.getCollegeIndex(college));

		example.setOrderByClause("updated DESC");
		List<GameApplication> applications = gameApplicationMapper.selectByExample(example);

		return applications;
	}
	
	/**
	 * 将gameApplication对象转化为秩序册EXCEL行数据
	 * 
	 * @param application
	 * @return
	 */
	private List<String> convertGameApplicationToRowData(GameApplication application) {
		List<String> data = new ArrayList<>();
		data.add(application.getStudentNo());
		data.add(application.getName());
		data.add(Gender.getName(application.getGender()));
		data.add(collegeService.getCollege(application.getCollege()));
		Event event = eventService.getEventByEventIdAndStatuses(application.getEventId());
		data.add(event.getCompetitionId());
		data.add(event.getCategoryId());
		data.add(event.getEventId());
		data.add(GenderGroup.getName(event.getEventGender()));
		data.add(Job.getName(application.getJob()));
		data.add("已审核");
		return data;
	}
	
	/** 
	 * 项目报名
	*/
	@Override
	public SGResult addGameApplication(GameApplication gameApplication) {
		
		SGResult result = checkGameApplcationData(gameApplication);
		
		if (!result.isOK()) {
			return result;
		}
		
		//补全剩余数据
		gameApplication.setId(IDUtils.genId());
		gameApplication.setStatus(1);
		// 0-已删除（或已通过校级审核）1-正在审核 2-院级审核通过 3-校级审核通过
		gameApplication.setCreated(new Date());
		gameApplication.setUpdated(new Date());
		// 插入数据库
		gameApplicationMapper.insert(gameApplication);
		return SGResult.build(ErrorCode.SUCCESS.getErrorCode(), "添加成功！");
	} 
	
	/** 
	 * 检查数据是否合法
	 * 1.是否重复报名 2.项目id与赛事id、比赛id是否对应
	*/
	@Override
	public SGResult checkGameApplcationData(GameApplication gameApplication) {
		GameApplicationExample example = new GameApplicationExample();
		Criteria criteria = example.createCriteria();
		
		criteria.andJobEqualTo(gameApplication.getJob());
		criteria.andStudentNoEqualTo(gameApplication.getStudentNo());
		criteria.andEventIdEqualTo(gameApplication.getEventId());
		criteria.andStatusNotEqualTo(0);
		
		// 执行查询
		List<GameApplication> list = gameApplicationMapper.selectByExample(example);
		// 判断结果中是否包含数据
		if (list != null && list.size() > 0) {
			// 如果有数据返回false
			return SGResult.build(ErrorCode.CONFLICT.getErrorCode(), "已报名该项目！");
		}
		// 如果没有数据返回true
		return SGResult.ok();
	}

	/** 
	 * 	按照具体赛事的比赛查询某个学院的报名人员列表
	*/
	@Override
	public SGResult getApplicationByCategoryId(GameApplication gameApplication) {
		GameApplicationExample example = new GameApplicationExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusNotEqualTo(0);
		criteria.andCategoryIdEqualTo(gameApplication.getCategoryId());
		if (gameApplication.getCollege() != null)
			criteria.andCollegeEqualTo(gameApplication.getCollege());
		criteria.andJobEqualTo(0);
		
		List<GameApplication> list = gameApplicationMapper.selectByExample(example);
		
		if(list == null || list.size() ==0)
			return SGResult.build(ErrorCode.BAD_REQUEST.getErrorCode(), "暂无报名信息");
		List<GameApplicationCtr> listout = new ArrayList<>();
		for (GameApplication gameApp : list) {
			listout.add(ConversionUtils.gameApplicationDaoToCtr(gameApp));
		}
		
		return SGResult.build(ErrorCode.SUCCESS.getErrorCode(), "获取报名信息成功！",listout);
	}

	/** 
	 * 	按照具体赛事的项目查询某个学院的报名人员列表
	*/
	@Override
	public SGResult getApplicationByItemId(GameApplication gameApplication) {
		GameApplicationExample example = new GameApplicationExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusNotEqualTo(0);
		criteria.andEventIdEqualTo(gameApplication.getEventId());
		if (gameApplication.getCollege() != null)
			criteria.andCollegeEqualTo(gameApplication.getCollege());
		criteria.andJobEqualTo(0);
		
		List<GameApplication> list = gameApplicationMapper.selectByExample(example);
		
		if(list == null || list.size() ==0)
			return SGResult.build(ErrorCode.BAD_REQUEST.getErrorCode(), "暂无报名信息");
		List<GameApplicationCtr> listout = new ArrayList<>();
		for (GameApplication gameApp : list) {
			listout.add(ConversionUtils.gameApplicationDaoToCtr(gameApp));
		}
		
		return SGResult.build(ErrorCode.SUCCESS.getErrorCode(), "获取报名信息成功！",listout);
	}
	
	/** 
	 * 	院级审核
	*/
	@Override
	public SGResult VerifyApplication(GameApplication gameApplication,int checked,int authority) {
		GameApplicationExample example = new GameApplicationExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusNotEqualTo(0);
		criteria.andEventIdEqualTo(gameApplication.getEventId());
		criteria.andUserWxIdEqualTo(gameApplication.getUserWxId());
		if(gameApplication.getName() != null )
			criteria.andNameEqualTo(gameApplication.getName());
		if(gameApplication.getStudentNo() != null )
			criteria.andStudentNoEqualTo(gameApplication.getStudentNo());
		List<GameApplication> list = gameApplicationMapper.selectByExample(example);
		if(list.size()==1) {
			GameApplication gameApp = list.get(0);
			gameApp.setStatus(21);
			if(checked == 1)
				gameApp.setStatus(22);
			if(authority > 2)
				gameApp.setStatus(32);
			gameApplicationMapper.updateByPrimaryKeySelective(gameApp);
			return SGResult.build(ErrorCode.SUCCESS.getErrorCode(), "审核成功！");
		}
		return SGResult.build(ErrorCode.CONFLICT.getErrorCode(), "数据异常！");
	}

	/** 
	 * 	根据game_id获取所有报名信息
	*/
	@Override
	public List<GameApplication> getAllGameApplication(String game_id){
		GameApplicationExample example = new GameApplicationExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusNotEqualTo(0);
		criteria.andCompetitionIdEqualTo(game_id);
		return gameApplicationMapper.selectByExample(example);
	}
	
	/**
	 * 根据学号获取报名信息
	 */
	@Override
	public List<GameApplication> getMyGameApplicationListByStudentNo(String student_no) {
		GameApplicationExample example = new GameApplicationExample();
		Criteria criteria = example.createCriteria();
		criteria.andStudentNoEqualTo(student_no);
		return gameApplicationMapper.selectByExample(example);
	}
}
