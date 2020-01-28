package cn.smartGym.service.impl;

import java.io.IOException;
import java.lang.Thread.State;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysql.cj.x.protobuf.MysqlxCrud.Collection;

import cn.smartGym.mapper.AppUserMapper;
import cn.smartGym.mapper.CategoryMapper;
import cn.smartGym.mapper.CompetitionMapper;
import cn.smartGym.mapper.EventMapper;
import cn.smartGym.mapper.GameApplicationMapper;
import cn.smartGym.mapper.PlayerMapper;
import cn.smartGym.mapper.WorkerMapper;
import cn.smartGym.pojo.AppUser;
import cn.smartGym.pojo.AppUserExample;
import cn.smartGym.pojo.Category;
import cn.smartGym.pojo.CategoryExample;
import cn.smartGym.pojo.Competition;
import cn.smartGym.pojo.Event;
import cn.smartGym.pojo.EventExample;
import cn.smartGym.pojo.GameApplication;
import cn.smartGym.pojo.GameApplicationExample;
import cn.smartGym.pojo.Player;
import cn.smartGym.pojo.PlayerExample;
import cn.smartGym.pojo.Worker;
import cn.smartGym.pojo.WorkerExample;
import cn.smartGym.pojo.PlayerExample.Criteria;
import cn.smartGym.service.AppUserService;
import cn.smartGym.service.CollegeService;
import cn.smartGym.service.DownloadService;
import cn.smartGym.service.EventService;
import cn.smartGym.service.GetCertainValueService;
import cn.smartGym.utils.CollegeAndCampusUtils;
import cn.smartGym.utils.ConversionUtils;
import common.enums.Gender;
import common.enums.GenderGroup;
import common.enums.Job;
import common.enums.TypeOfWorker;
import common.utils.ExcelHelper;
import common.utils.IDUtils;

@Service
public class DownloadServiceImpl implements DownloadService{
	@Autowired
	private GameApplicationMapper gameApplicationMapper;
	
	@Autowired
	private AppUserMapper appUserMapper;
	
	@Autowired
	private PlayerMapper playerMapper;
	
	@Autowired
	private CompetitionMapper competitionMapper;
	
	@Autowired
	private WorkerMapper workerMapper;
	
	@Autowired
	private CategoryMapper categoryMapper;
	
	@Autowired
	private EventMapper eventMapper;
	
	@Autowired
	private EventService eventService;
	
	@Autowired
	private CollegeService collegeService;
	
	@Autowired
	private AppUserService appUserService;
	
	@Autowired
	private GetCertainValueService getCertainValueService;
	
	/**
	 * 生成比赛报名表
	 * 			-根据competition, college
	 * @throws IOException 
	 */
	@Override
	public void generateGameApplExcelsByCollege(String competition, String college, Map<String, Object> adminMap) throws IOException {
		// 构建Excel文件路径
		String filePath = getExcelFilePath(competition, college);
		// 获取Excel标题行数据
		List<String> title = Arrays.asList(ExcelHelper.applicationsExcelTitleArray);
		// 获取GameApplicationsData
		Event event = new Event();		
		event.setCompetitionId(competition);
		//根据比赛名得到该比赛的项目列表
		List<Event> events = eventService.getEventByDetailsAndStatuses(event,1,2,3);
		//查找每个项目的项目id
		List<String> eventIds = eventService.getEventIdsByEvents(events);
		//得到报名信息列表
		List<GameApplication> applications = getGameApplListByEventIdsAndCollegeAndStatus(eventIds, college, adminMap, 1);
		//信息列表按序排列成多行数据
		List<List<String>> applicationData = new ArrayList<>();
		for (GameApplication application : applications) {
			applicationData.add(convertGameApplToRowData(application));
		}
		ExcelHelper.writeExcel(title, applicationData, filePath);
	}

	/**
	 * 获取Excel的文件路径
	 */
	@Override
	public String getExcelFilePath(String competition, String... college) {
//		String fileName = String.valueOf((competition + college.hashCode()));
//		String filePath = "downloadFiles/" + fileName + ".xls";
		SimpleDateFormat sf_ = new SimpleDateFormat("yyyyMMddHHmmss");
		String times = sf_.format(new Date());
		String fileName = times + (int) (Math.random() * (99999 - 10000) + 10000) + ".xls" ;
		String filePath = "downloadFiles/" + fileName;
		return filePath;
	}
	/**
	 * 获取报名记录
	 * 			-根据项目id、学院和状态
	 * 			-功能：院级管理员下载负责学院，校级管理员下载任一学院或者所有学院
	 */
	@Override
	public List<GameApplication> getGameApplListByEventIdsAndCollegeAndStatus(List<String> eventIds, String college, Map<String, Object> adminMap, Integer... statuses) {
		int authority = (int)adminMap.get("adminLevel");
		GameApplicationExample example = new GameApplicationExample();
		cn.smartGym.pojo.GameApplicationExample.Criteria criteria = example.createCriteria();
		if (eventIds != null && eventIds.size() !=0)
			criteria.andEventIdIn(eventIds);		
		if (statuses != null & statuses.length != 0)
			criteria.andStatusIn(Arrays.asList(statuses));
		if(authority > 1) {
			if(authority == 2 ) {
				criteria.andCollegeEqualTo(collegeService.getId(college));
				example.setOrderByClause("updated DESC");
				List<GameApplication> applications = gameApplicationMapper.selectByExample(example);
				return applications;
			}else {
				if(authority > 2 && !(college == "所有学院")) 
					criteria.andCollegeEqualTo(collegeService.getId(college));
				example.setOrderByClause("updated DESC");
				List<GameApplication> applications = gameApplicationMapper.selectByExample(example);
				return applications;
			
			}
		}
		
		return null;
	}
	
	/**
	 * 将gameApplication对象转化为秩序册EXCEL行数据
	 * 			按照顺序：学号/姓名/性别/学院/赛事/类别/项目/组别/职责/状态/备注
	 * @param application
	 * @return
	 */
	private List<String> convertGameApplToRowData(GameApplication application) {
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
	 *获取获取管理员权限与所在学院
	*/
	@Override
	public Map<String, Object> getAdminLevelAndCollege(String userWxid) {
		AppUser appUser = new AppUser();
		appUser.setWxId(userWxid);
		AppUser result = (AppUser)appUserService.getAppUserByDetail(appUser).getData();
		Map<String, Object> adminMap = new HashMap<String, Object>();
		if(result != null) {
			adminMap.put("adminLevel",result.getAdminLevel());
			adminMap.put("college",result.getCollege());
		}
		
		return adminMap;
	}

	/**
	 * 生成比赛成绩表
	 */
	@Override
	public void generatePlayerRankExcelsByCollege(String competition, String college, Map<String, Object> adminMap) throws IOException {
		// 构建Excel文件路径
		String filePath = getExcelFilePath(competition, college);
		// 获取Excel标题行数据
		List<String> title = Arrays.asList(ExcelHelper.playersDetailedExcelTitleArray);
		// 获取PlayerData
		Event event = new Event();		
		event.setCompetitionId(competition);
		//根据比赛名得到该比赛的项目列表
		List<Event> events = eventService.getEventByDetailsAndStatuses(event,1,2,3);
		//查找每个项目的项目id
		List<String> eventIds = eventService.getEventIdsByEvents(events);
		//得到比赛信息列表
		List<Player> players = getPlayerListByEventIdAndCollegeAndStatus(eventIds, college, adminMap, 1);
		//信息列表按序排列成多行数据
		List<List<String>> playerData = new ArrayList<>();
		for(Player player : players) {
			playerData.add(convertPlayerToRowData(player));
		}
		ExcelHelper.writeExcel(title, playerData, filePath);

	}
	
	@Override
	public List<Player> getPlayerListByEventIdAndCollegeAndStatus(List<String> eventIds, String college, Map<String, Object> adminMap, Integer... statuses) {
		int authority = (int)adminMap.get("adminLevel");
		PlayerExample example = new PlayerExample();
		Criteria criteria = example.createCriteria();
		if(eventIds != null && eventIds.size() != 0)
			criteria.andEventIdIn(eventIds);
		if(statuses != null && statuses.length != 0 )
			criteria.andStatusIn(Arrays.asList(statuses));
		if(authority > 2) {
			if(!(college == "所有学院"))
				criteria.andCollegeEqualTo(collegeService.getId(college));
			example.setOrderByClause("rank_no");
			List<Player> players = playerMapper.selectByExample(example);
			return players;
		}
		return null;
	}
	
	
	private List<String> convertPlayerToRowData(Player player) {
		List<String> data = new ArrayList<>();
		data.add(player.getPlayerNo());
		data.add(player.getStudentNo());
		data.add(player.getName());
		Map<String, Object> valueMap = getCertainValueService.getCertainValueOfAppUser(player.getStudentNo(),"gender");
		if(valueMap == null)
			data.add("未知");
		else 
			data.add(Gender.getName((Integer)valueMap.get("gender")));	
		data.add(collegeService.getCollege(player.getCollege()));
		Event event = eventService.getEventByEventIdAndStatuses(player.getEventId());
		data.add(event.getCompetitionName());
		data.add(event.getCategoryName());
		data.add(event.getEventName());
		data.add(GenderGroup.getName(event.getEventGender()));
		data.add(Job.getName(player.getJob()));
		// "组号", "道次", "成绩", "排名"
		data.add(player.getGroupNo().toString());
		data.add(player.getPathNo().toString());
		data.add(player.getGrades());
		data.add(player.getRankNo().toString());
		data.add("已审核");
		return data;
	}
	
	/**
	 * 生成数据库工作人员表
	 * 			根据:app_user,competition,category,event
	 * 			功能:根据各表将工作人员信息插入到数据库work表格中
	 */
	@Override
	public void inserIntoWorkerByCompetition(String competition) {
		
		//1.查找competition级赛事负责人及裁判长
		
		//获取competition中competition以及对应judge_wxid,pricipal_wxid的Map
		List<Map<String,Object>> competitionList = getCertainValueService.getCertainValueOfCompetitions(Arrays.asList(competition),"competitionName","judgeHeaderWxid", "principalWxid");
		AppUserExample example = new AppUserExample();
		cn.smartGym.pojo.AppUserExample.Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(1);
		criteria.andWxIdIn(Arrays.asList((String)competitionList.get(0).get("judgeHeaderWxid"),(String)competitionList.get(0).get("principalWxid")));
		List<AppUser> result = appUserMapper.selectByExample(example);	
		
		for(int i = 0; i < result.size() ; i++) {
			insertIntoWorkerByAppUserWxid(result.get(i),competitionList, 0);
		}
		
		
		//2.查找category级副裁判长

		CategoryExample example2 = new CategoryExample();
		cn.smartGym.pojo.CategoryExample.Criteria criteria2 = example2.createCriteria();
		criteria2.andStatusEqualTo(1);
		criteria2.andCompetitionIdEqualTo(competition);
		List<Category> resultCategories = categoryMapper.selectByExample(example2);
		//获取Category中category_id的一个List
		List<String> categoryIdList = resultCategories.stream().map(Category::getCategoryId).collect(Collectors.toList());
		//获取Category中category_id以及对应judge_wxid的Map
		List<Map<String,Object>> categoryList = getCertainValueService.getCertainValueOfCategories(categoryIdList, "competitionName", "categoryName","judgeWxid");
		for(int i=0 ; i < categoryList.size() ; i++) {
		
			AppUserExample eAppUserExample = new AppUserExample();
			cn.smartGym.pojo.AppUserExample.Criteria criteriaAppCriteria = eAppUserExample.createCriteria();
			criteriaAppCriteria.andStatusEqualTo(1);
			criteriaAppCriteria.andWxIdEqualTo((String)categoryList.get(i).get("judgeWxid"));
			List<AppUser> result2 = appUserMapper.selectByExample(eAppUserExample);
			insertIntoWorkerByAppUserWxid(result2.get(0), categoryList, i);
			
		}
		
		//3.查找event级裁判员/记分员
		
		EventExample example3 = new EventExample();
		cn.smartGym.pojo.EventExample.Criteria criteria3 = example3.createCriteria();
		criteria3.andCompetitionIdEqualTo(competition);
		List<Event> resultEvents = eventMapper.selectByExample(example3);
		//获取Event中event_id的一个List
		List<String> eventIdList = resultEvents.stream().map(Event::getEventId).collect(Collectors.toList());
		//获取Event中event_id以及对应judge_wxid的Map
		List<Map<String,Object>> eventList = getCertainValueService.getCertainValueOfEvents(eventIdList, "competitionName", "categoryName","eventName","eventId","judgeWxid");
		for(int i=0 ; i < eventList.size() ; i++) {
			
			AppUserExample eAppUserExample = new AppUserExample();
			cn.smartGym.pojo.AppUserExample.Criteria criteriaAppCriteria = eAppUserExample.createCriteria();
			criteriaAppCriteria.andStatusEqualTo(1);
			criteriaAppCriteria.andWxIdEqualTo((String)eventList.get(i).get("judgeWxid"));
			List<AppUser> result3 = appUserMapper.selectByExample(eAppUserExample);
			insertIntoWorkerByAppUserWxid(result3.get(0), eventList, i);
		}
		
	}
	
	public void insertIntoWorkerByAppUserWxid(AppUser result, List<Map<String,Object>> map,int i) {
		Worker worker = new Worker();
		worker.setWorkerId(IDUtils.genId());
		worker.setWorkerWxid(result.getWxId());
		worker.setWorkerName(result.getUserName());
		worker.setWorkerNo(result.getStudentNo());
		worker.setWorkerType(result.getUserType());
		worker.setWorkerLevel(result.getUserType() == 1 ? result.getJudgeLevel() : result.getAdminLevel());
		worker.setWorkCompetition((String)map.get(i).get("competitionName"));
		if(map.get(i).get("categoryName") != null)
			worker.setWorkerCategory((String)map.get(i).get("categoryName"));
		if(map.get(i).get("eventName") != null)
			worker.setWorkerEvent((String)map.get(i).get("eventName"));
		if(map.get(i).get("eventId") != null)
			worker.setWorkerEventId((String)map.get(i).get("eventId"));
		workerMapper.insert(worker);
		
	}
	
	
	/**
	 * 生成工作人员表
	 * 			根据：worker表下载工作人员信息
	 * 			功能：工作人员与对应职责表
	 */
	@Override
	public void generateWorkerExcelsByCompetition(String competition, Map<String, Object> adminMap) throws IOException {
		
		// 构建Excel文件路径
		String filePath = getExcelFilePath(competition);
		// 获取Excel标题行数据
		List<String> title = Arrays.asList(ExcelHelper.playersExcelTitleArray);
		String competitionName = (String)getCertainValueService.getCertainValueOfCompetition(competition, "competitionName").get("competitionName");
		//得到工作人员信息列表
		WorkerExample example = new WorkerExample();
		cn.smartGym.pojo.WorkerExample.Criteria criteria = example.createCriteria();
		criteria.andWorkCompetitionEqualTo(competitionName);
		List<Worker> workers = workerMapper.selectByExample(example);
		//信息列表按序排列成多行数据
		List<List<String>> workerData = new ArrayList<>();
		for(Worker worker : workers) {
			workerData.add(convertWorkersToRowData(worker));
		}

		ExcelHelper.writeExcel(title, workerData, filePath);

	}

	
	private List<String> convertWorkersToRowData(Worker worker) {
		List<String> data = new ArrayList<>();
		//"工号","姓名","职责","负责比赛","负责项目","状态"
		data.add(worker.getWorkerNo());
		data.add(worker.getWorkerName());
		data.add(TypeOfWorker.getTypeName(worker.getWorkerType()));
		data.add(worker.getWorkerCategory());
		data.add(worker.getWorkerEvent());
		return data;
	}



}

