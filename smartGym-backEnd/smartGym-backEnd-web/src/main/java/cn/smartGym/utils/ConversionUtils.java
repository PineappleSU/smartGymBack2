package cn.smartGym.utils;

import java.util.ArrayList;




import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.smartGym.pojo.AppUser;
import cn.smartGym.pojo.Application;
import cn.smartGym.pojo.Category;
import cn.smartGym.pojo.Competition;
import cn.smartGym.pojo.Event;
import cn.smartGym.pojo.GameApplication;
import cn.smartGym.pojo.Item;
import cn.smartGym.pojo.Medal;
import cn.smartGym.pojo.News;
import cn.smartGym.pojo.Player;
import cn.smartGym.pojo.RemarkMessage;
import cn.smartGym.pojo.SgUser;
import cn.smartGym.pojoCtr.AppUserCtr;
import cn.smartGym.pojoCtr.CategoryCtr;
import cn.smartGym.pojoCtr.CompetitionCtr;
import cn.smartGym.pojoCtr.EventCtr;
import cn.smartGym.pojoCtr.GameApplicationCtr;
import cn.smartGym.pojoCtr.NewsCtr;
import cn.smartGym.pojoCtr.PlayerCtr;
import cn.smartGym.pojoCtr.RemarkMessageCtr;
import cn.smartGym.service.AppUserService;
import cn.smartGym.service.CampusService;
import cn.smartGym.service.CollegeService;
import cn.smartGym.service.EventService;
import cn.smartGym.service.NewsService;
import cn.smartGym.znoUse.ApplicationCtr;
import cn.smartGym.znoUse.ItemCtr;
import cn.smartGym.znoUse.ItemService;
import cn.smartGym.znoUse.MedalCtr;
import cn.smartGym.znoUse.SgUserCtr;
import common.enums.Gender;
import common.enums.GenderGroup;
import common.enums.Job;
import common.enums.TypeOfCompetition;
import common.enums.TypeOfItem;
import common.enums.TypeOfProcessState;
import common.enums.TypeOfUser;

@Component
public class ConversionUtils {

	@Autowired
	private CollegeService collegeService;
	@Autowired
	private CampusService campusService;
	@Autowired
	private ItemService itemService;
	@Autowired
	private EventService eventService;
	@Autowired
	private NewsService newsService;
	@Autowired
	private AppUserService appUserService;

	public static ConversionUtils conversionUtils;

	@PostConstruct
	public void init() {
		conversionUtils = this;
	}
	
	public static Application applicationCtrToDao(ApplicationCtr applicationCtr) {
		Application application = new Application();

		application.setId(applicationCtr.getId());
		application.setName(applicationCtr.getName());
		application.setCollege(conversionUtils.collegeService.getId(applicationCtr.getCollege()));
		application.setJob(Job.getIndex(applicationCtr.getJob()));
		application.setGender(GenderGroup.getIndex(applicationCtr.getGender()));
		application.setStudentNo(applicationCtr.getStudentNo());
		application.setStatus(applicationCtr.getStatus());

		// 如果没有项目Id,去数据库中查
		if (applicationCtr.getItemId() == null) {
			Item item = new Item();
			item.setGame(applicationCtr.getGame());
			item.setCategory(applicationCtr.getCategory());
			item.setItem(applicationCtr.getItem());
			item.setGender(GenderGroup.getIndex(applicationCtr.getGender()));
			List<Item> items = conversionUtils.itemService.getItemsByDetailsAndStatuses(item, new Integer[0]);
			List<Long> itemIds = conversionUtils.itemService.getItemIdsByItems(items);
			if ((StringUtils.isBlank(applicationCtr.getGame()) && StringUtils.isBlank(applicationCtr.getCategory())
					&& StringUtils.isBlank(applicationCtr.getGender())) || itemIds == null || itemIds.size() == 0)
				return application;
			applicationCtr.setItemId(itemIds.get(0));
		}
		application.setItemId(applicationCtr.getItemId());

		return application;
	}

	public static ApplicationCtr applicationDaoToCtr(Application application) {
		ApplicationCtr applicationCtr = new ApplicationCtr();

		Item item = conversionUtils.itemService.getItemByItemIdAndStatuses(application.getItemId(), new Integer[0]);
		if (item == null)
			return applicationCtr;

		applicationCtr.setId(application.getId());
		applicationCtr.setName(application.getName());
		applicationCtr.setCollege(conversionUtils.collegeService.getCollege(application.getCollege()));
		applicationCtr.setJob(Job.getName(application.getJob()));
		applicationCtr.setGender(GenderGroup.getName(application.getGender()));
		applicationCtr.setStudentNo(application.getStudentNo());
		applicationCtr.setItemId(application.getItemId());
		applicationCtr.setStatus(application.getStatus());
		applicationCtr.setItem(item.getItem());
		applicationCtr.setGame(item.getGame());
		applicationCtr.setCategory(item.getCategory());
		return applicationCtr;
	}

	public static List<ApplicationCtr> applicationdaoListToCtrList(List<Application> applications) {
		ArrayList<ApplicationCtr> applicationsCtr = new ArrayList<>();
		for (Application application : applications) {
			applicationsCtr.add(applicationDaoToCtr(application));
		}
		return applicationsCtr;
	}

	public static GameApplicationCtr gameApplicationDaoToCtr(GameApplication gameApplication) {
		GameApplicationCtr gameApplicationCtr = new GameApplicationCtr();
		gameApplicationCtr.setCaptain_wxid(gameApplication.getCaptainWxId());
		gameApplicationCtr.setGame_id(gameApplication.getCompetitionId());
		gameApplicationCtr.setCategory_id(gameApplication.getCategoryId());
		gameApplicationCtr.setItem_id(gameApplication.getEventId());
		gameApplicationCtr.setCollege(conversionUtils.collegeService.getCollege(gameApplication.getCollege()));
		gameApplicationCtr.setGender(Gender.getName(gameApplication.getGender()));
		gameApplicationCtr.setJob(Job.getName(gameApplication.getJob()));
		gameApplicationCtr.setName(gameApplication.getName());
		gameApplicationCtr.setStudent_no(gameApplication.getStudentNo());
		gameApplicationCtr.setPlayer_wxid(gameApplication.getUserWxId());
		if (gameApplication.getStatus() <=21)
			gameApplicationCtr.setChecked(0);
		else 
			gameApplicationCtr.setChecked(1);
		return gameApplicationCtr;
	}
	
	public static GameApplication gameApplicationCtrToDao(GameApplicationCtr gameApplicationCtr) {
		GameApplication gameApplication = new GameApplication();
		gameApplication.setId(gameApplicationCtr.getId());
		gameApplication.setName(gameApplicationCtr.getName());
		gameApplication.setUserWxId(gameApplicationCtr.getUser_wxid());
		gameApplication.setCollege(conversionUtils.collegeService.getId(gameApplicationCtr.getCollege()));
		gameApplication.setJob(Job.getIndex(gameApplicationCtr.getJob()));
		gameApplication.setGender(Gender.getIndex(gameApplicationCtr.getGender()));
		gameApplication.setStudentNo(gameApplicationCtr.getStudent_no());
		// 需检查一致性（未实现）
		gameApplication.setCompetitionId(gameApplicationCtr.getGame_id());
		gameApplication.setCategoryId(gameApplicationCtr.getCategory_id());
		gameApplication.setEventId(gameApplicationCtr.getItem_id());
		gameApplication.setCaptainWxId(gameApplicationCtr.getCaptain_wxid());
		return gameApplication;
	}

	public static List<GameApplicationCtr> gameApplicationdaoListToCtrList(List<GameApplication> applications) {
		ArrayList<GameApplicationCtr> applicationsCtr = new ArrayList<>();
		for (GameApplication application : applications) {
			applicationsCtr.add(gameApplicationDaoToCtr(application));
		}
		return applicationsCtr;
	}
	
	

	public static ItemCtr itemDaoToCtr(Item item) {
		ItemCtr itemCtr = new ItemCtr();
		itemCtr.setId(item.getId());
		itemCtr.setGame(item.getGame());
		itemCtr.setCategory(item.getCategory());
		itemCtr.setItem(item.getItem());
		itemCtr.setGender(GenderGroup.getName(item.getGender()));
		itemCtr.setPath_num(item.getPathNum());
		itemCtr.setDate(item.getDate());
		itemCtr.setPlace(item.getPlace());
		itemCtr.setParticipant_num(item.getParticipantNum());
		itemCtr.setStatus(item.getStatus());
		itemCtr.setDescription(item.getDescription());
		itemCtr.setType(TypeOfItem.getTypeName(item.getType()));
		itemCtr.setType_id(item.getTypeId());
		itemCtr.setRank_criterion(item.getRankCriterion());

		return itemCtr;
	}

	public static Item itemCtrtoDao(ItemCtr itemCtr) {
		Item item = new Item();
		item.setId(itemCtr.getId());
		item.setGame(itemCtr.getGame());
		item.setCategory(itemCtr.getCategory());
		item.setItem(itemCtr.getItem());
		item.setGender(GenderGroup.getIndex(itemCtr.getGender()));
		item.setPathNum(itemCtr.getPath_num());
		item.setDate(itemCtr.getDate());
		item.setPlace(itemCtr.getPlace());
		item.setParticipantNum(itemCtr.getParticipant_num());
		item.setDescription(itemCtr.getDescription());
		item.setStatus(itemCtr.getStatus());
		item.setType(TypeOfItem.getType(itemCtr.getType()));
		item.setTypeId(itemCtr.getType_id());
		item.setRankCriterion(itemCtr.getRank_criterion());

		return item;
	}

	public static List<ItemCtr> itemDaoListToCtrList(List<Item> items) {
		ArrayList<ItemCtr> itemsCtr = new ArrayList<>();
		for (Item item : items) {
			itemsCtr.add(itemDaoToCtr(item));
		}
		return itemsCtr;
	}

	public static PlayerCtr playerDaoToCtr(Player player) {
		PlayerCtr playerCtr = new PlayerCtr();

		playerCtr.setItem_id(player.getEventId());
		playerCtr.setId(player.getId());
		playerCtr.setName(player.getName());
		playerCtr.setCollege(conversionUtils.collegeService.getCollege(player.getCollege()));
		playerCtr.setStudent_no(player.getStudentNo());
		playerCtr.setJob(Job.getName(player.getJob()));
		playerCtr.setPlayer_no(player.getPlayerNo());
		playerCtr.setGender(GenderGroup.getName(player.getGender()));
		playerCtr.setGroup_no(player.getGroupNo());
		playerCtr.setPath_no(player.getPathNo());
		playerCtr.setGrades(player.getGrades());
		playerCtr.setFinal_grades(player.getFinalGrades());
		playerCtr.setRank_no(player.getRankNo());
		playerCtr.setStatus(player.getStatus());
		playerCtr.setItem_process_type(player.getItemProcessType());

		return playerCtr;
	}

	public static Player playerCtrToDao(PlayerCtr playerCtr) {
		Player player = new Player();

		player.setId(playerCtr.getId());
		player.setName(playerCtr.getName());
		player.setCollege(conversionUtils.collegeService.getId(playerCtr.getCollege()));
		player.setStudentNo(playerCtr.getStudent_no());
		player.setJob(Job.getIndex(playerCtr.getJob()));
		player.setGender(GenderGroup.getIndex(playerCtr.getGender()));
		player.setPlayerNo(playerCtr.getPlayer_no());
		player.setGroupNo(playerCtr.getGroup_no());
		player.setPathNo(playerCtr.getPath_no());
		player.setGrades(playerCtr.getGrades());
		player.setFinalGrades(playerCtr.getFinal_grades());
		player.setRankNo(playerCtr.getRank_no());
		player.setStatus(playerCtr.getStatus());
		player.setItemProcessType(playerCtr.getItem_process_type());
		player.setEventId(playerCtr.getItem_id());

		// 如果没有项目Id,去数据库中查
//		if (playerCtr.getItemId() == null) {
//			Item item = new Item();
//			item.setGame(playerCtr.getGame());
//			item.setCategory(playerCtr.getCategory());
//			item.setItem(playerCtr.getItem());
//			item.setGender(GenderGroup.getIndex(playerCtr.getGender()));
//			List<Item> items = conversionUtils.itemService.getItemsByDetailsAndStatuses(item, new Integer[0]);
//			List<Long> itemIds = conversionUtils.itemService.getItemIdsByItems(items);
//			if ((StringUtils.isBlank(playerCtr.getGame()) && StringUtils.isBlank(playerCtr.getCategory())
//					&& StringUtils.isBlank(playerCtr.getGender())) || itemIds == null || itemIds.size() == 0)
//				return player;
//			playerCtr.setItemId(itemIds.get(0));
//		}
//		player.setItemId(playerCtr.getItemId());

		return player;
	}

	public static List<PlayerCtr> playerDaoListToCtrList(List<Player> players) {
		ArrayList<PlayerCtr> playersCtr = new ArrayList<>();
		for (Player player : players) {
			playersCtr.add(playerDaoToCtr(player));
		}
		return playersCtr;
	}

	public static SgUserCtr userDaoToCtr(SgUser user) {
		SgUserCtr userCtr = new SgUserCtr();
		userCtr.setId(user.getId());
		userCtr.setName(user.getName());
		userCtr.setWxId(user.getWxId());
		userCtr.setStudentNo(user.getStudentNo());
		userCtr.setGender(Gender.getName(user.getGender()));
		userCtr.setCampus(conversionUtils.campusService.getCampus(user.getCampus()));
		userCtr.setCollege(conversionUtils.collegeService.getCollege(user.getCollege()));
		userCtr.setPhone(user.getPhone());
		userCtr.setStatus(user.getStatus());
		userCtr.setAuthority(user.getAuthority());
		userCtr.setType(TypeOfUser.getTypeName(user.getType()));
		userCtr.setEmail(user.getEmail());
		return userCtr;
	}

	public static AppUserCtr appUserDaoToCtr(AppUser appUser) {
		AppUserCtr appUserCtr = new AppUserCtr();
		appUserCtr.setUser_id(appUser.getUserId());
		appUserCtr.setUser_name(appUser.getUserName());
		appUserCtr.setUser_wxid(appUser.getWxId());
		appUserCtr.setStudent_no(appUser.getStudentNo());
		appUserCtr.setGender(Gender.getName(appUser.getGender()));
		appUserCtr.setCampus(conversionUtils.campusService.getCampus(appUser.getCampus()));
		appUserCtr.setCollege(conversionUtils.collegeService.getCollege(appUser.getCollege()));
		appUserCtr.setUser_type(appUser.getUserType());
		appUserCtr.setAdmin_level(appUser.getAdminLevel());
		appUserCtr.setJudge_level(appUser.getJudgeLevel());
		appUserCtr.setType(TypeOfUser.getTypeName(appUser.getType()));
		appUserCtr.setUpdated(appUser.getUpdated());
		appUserCtr.setCreated(appUser.getCreated());
		appUserCtr.setEmail(appUser.getEmail());
		appUserCtr.setPhone(appUser.getPhone());
		appUserCtr.setStatus(appUser.getStatus());
		appUserCtr.setAssociation(appUser.getAssociation());
		return appUserCtr;
	}
	
	public static AppUser appUserCtrToDao(AppUserCtr appUserCtr) {
		AppUser appUser = new AppUser();
		appUser.setUserId(appUserCtr.getUser_id());
		appUser.setUserName(appUserCtr.getUser_name());
		appUser.setWxId(appUserCtr.getUser_wxid());
		appUser.setStudentNo(appUserCtr.getStudent_no());
		appUser.setGender(Gender.getIndex(appUserCtr.getGender()));
		appUser.setCampus(conversionUtils.campusService.getId(appUserCtr.getCampus()));
		appUser.setCollege(conversionUtils.collegeService.getId(appUserCtr.getCollege()));
		appUser.setUserType(appUserCtr.getUser_type());
		appUser.setAdminLevel(appUserCtr.getAdmin_level());
		appUser.setJudgeLevel(appUserCtr.getJudge_level());
		appUser.setType(TypeOfUser.getType(appUserCtr.getType()));
		appUser.setPhone(appUserCtr.getPhone());
		appUser.setAssociation(appUserCtr.getAssociation());
		
		return appUser;
	}
	
	public static List<AppUserCtr> appUserDaoListToCtrList(List<AppUser> appUsers) {
		List<AppUserCtr> appUserCtrs = new ArrayList<>();
		for(AppUser appUser : appUsers) {
			appUserCtrs.add(appUserDaoToCtr(appUser));
		}
		return appUserCtrs;
		
	}
	public static SgUser userCtrToDao(SgUserCtr userCtr) {
		SgUser user = new SgUser();

		user.setId(userCtr.getId());
		user.setName(userCtr.getName());
		user.setWxId(userCtr.getWxId());
		user.setStudentNo(userCtr.getStudentNo());
		user.setGender(Gender.getIndex(userCtr.getGender()));
		user.setCampus(conversionUtils.campusService.getId(userCtr.getCampus()));
		user.setCollege(conversionUtils.collegeService.getId(userCtr.getCollege()));
		user.setPhone(userCtr.getPhone());
		user.setStatus(userCtr.getStatus());
		user.setAuthority(userCtr.getAuthority());
		user.setType(TypeOfUser.getType(userCtr.getType()));
		user.setEmail(userCtr.getEmail());
		return user;
	}

	public static List<SgUserCtr> daoListToCtrList(List<SgUser> users) {
		List<SgUserCtr> usersCtr = new ArrayList<>();
		for (SgUser user : users) {
			usersCtr.add(userDaoToCtr(user));
		}
		return usersCtr;
	}

	public static MedalCtr medalDaoToCtr(Medal medal) {
		MedalCtr medalCtr = new MedalCtr();

		medalCtr.setId(medal.getId());
		medalCtr.setGame(medal.getGame());
		medalCtr.setCollege(conversionUtils.collegeService.getCollege(medal.getCollege()));
		medalCtr.setStatus(medal.getStatus());
		medalCtr.setFirst(medal.getFirst());
		medalCtr.setSecond(medal.getSecond());
		medalCtr.setThird(medal.getThird());
		medalCtr.setFourth(medal.getFourth());
		medalCtr.setFifth(medal.getFifth());
		medalCtr.setSixth(medal.getSixth());
		medalCtr.setSeventh(medal.getSeventh());
		medalCtr.setEighth(medal.getEighth());
		medalCtr.setScore(medal.getScore());
		medalCtr.setCreated(medal.getCreated());
		medalCtr.setUpdated(medal.getUpdated());
		return medalCtr;
	}

	public static Medal medalCtrToDao(MedalCtr medalCtr) {
		Medal medal = new Medal();

		medal.setId(medalCtr.getId());
		medal.setGame(medalCtr.getGame());
		medal.setCollege(conversionUtils.collegeService.getId(medalCtr.getCollege()));
		medal.setStatus(medalCtr.getStatus());
		medal.setFirst(medalCtr.getFirst());
		medal.setSecond(medalCtr.getSecond());
		medal.setThird(medalCtr.getThird());
		medal.setFourth(medalCtr.getFourth());
		medal.setFifth(medalCtr.getFifth());
		medal.setSixth(medalCtr.getSixth());
		medal.setSeventh(medalCtr.getSeventh());
		medal.setEighth(medalCtr.getEighth());
		medal.setScore(medalCtr.getScore());
		medal.setCreated(medalCtr.getCreated());
		medal.setUpdated(medalCtr.getUpdated());
		return medal;
	}

	public static List<MedalCtr> medalDaoListToCtrList(List<Medal> medals) {
		List<MedalCtr> medalCtrs = new ArrayList<>();
		for (Medal medal : medals) {
			medalCtrs.add(medalDaoToCtr(medal));
		}
		return medalCtrs;
	}
	
	public static Competition competitionCtrToDao(CompetitionCtr competitionCtr) {
		Competition competition = new Competition();
		competition.setCompetitionId(competitionCtr.getGame_id());
		competition.setCompetitionName(competitionCtr.getGame_name());
		competition.setCompetitionType1(TypeOfCompetition.getType(competitionCtr.getGame_type()));
		competition.setCompetitionType2(competitionCtr.getGame_type2());
		competition.setDepartment(competitionCtr.getDepartment());
		competition.setPrincipalWxid(competitionCtr.getPrincipal_wxid());
		competition.setJudgeHeaderWxid(competitionCtr.getJudge_header_wxid());
		competition.setApplyStartTime(competitionCtr.getApply_start_time());
		competition.setApplyCheckTime(competitionCtr.getApply_check_time());
		competition.setCheckEndTime(competitionCtr.getCheck_end_time());
		competition.setCompetitionStartTime(competitionCtr.getGame_start_time());
		competition.setCompetitionEndTime(competitionCtr.getGame_end_time());
		competition.setCompetitionPlace(competitionCtr.getGame_place());
		competition.setCompetitionDescription(competitionCtr.getGame_description());
		competition.setSearchType(competitionCtr.getSearch_type());
		return competition;
	}
	
	public static Category categoryCtrToDao(CategoryCtr categoryCtr) {
		Category category = new Category();
		category.setCategoryId(categoryCtr.getCategory_id());
		category.setCategoryName(categoryCtr.getCategory_name());
		category.setCompetitionId(categoryCtr.getGame_id());
		category.setJudgeWxid(categoryCtr.getJudge_wxid());
		category.setCategoryDescription(categoryCtr.getCategory_description());
		category.setCompetitionName(categoryCtr.getGame_name());
		return category;
	}
	
	public static Event eventCtrToDao(EventCtr eventCtr) {
		Event event = new Event();
		event.setCompetitionId(eventCtr.getGame_id());
		event.setCompetitionName(eventCtr.getGame_name());
		event.setCategoryId(eventCtr.getCategory_id());
		event.setCategoryName(eventCtr.getCategory_name());
		event.setEventId(eventCtr.getItem_id());
		event.setEventName(eventCtr.getItem_name());
		event.setEventLevel(eventCtr.getItem_level());
		event.setEventPlace(eventCtr.getItem_place());
		event.setEventGender(eventCtr.getGender());
		event.setEventDescription(eventCtr.getItem_description());
		event.setEventType(eventCtr.getItem_type());
		event.setPeopleNum(eventCtr.getPath_num());
		event.setRankCriterion(eventCtr.getRank_criterion());
		event.setJudgeWxid(eventCtr.getJudge_wxid());
		return event;
	}
	
	public static CompetitionCtr competitionDaoToCtr(Competition competition) {
		CompetitionCtr competitionCtr = new CompetitionCtr();
		competitionCtr.setApply_check_time(competition.getApplyCheckTime());
		competitionCtr.setApply_start_time(competition.getApplyStartTime());
		competitionCtr.setCheck_end_time(competition.getCheckEndTime());
		competitionCtr.setDepartment(competition.getDepartment());
		competitionCtr.setGame_description(competition.getCompetitionDescription());
		competitionCtr.setGame_end_time(competition.getCompetitionEndTime());
		competitionCtr.setGame_name(competition.getCompetitionName());
		competitionCtr.setGame_place(competition.getCompetitionPlace());
		competitionCtr.setGame_start_time(competition.getCompetitionStartTime());
		competitionCtr.setGame_type(TypeOfCompetition.getTypeName(competition.getCompetitionType1()));
		competitionCtr.setGame_type2(competition.getCompetitionType2());
		competitionCtr.setGame_id(competition.getCompetitionId());
		competitionCtr.setJudge_header_wxid(competition.getJudgeHeaderWxid());
		competitionCtr.setPrincipal_wxid(competition.getPrincipalWxid());
		competitionCtr.setSearch_type(competition.getSearchType());
		return competitionCtr;
	}
	
	public static CategoryCtr categoryDaoToCtr(Category category) {
		CategoryCtr categoryCtr = new CategoryCtr();
		categoryCtr.setCategory_description(category.getCategoryDescription());
		categoryCtr.setCategory_name(category.getCategoryName());
		categoryCtr.setCategory_id(category.getCategoryId());
		categoryCtr.setGame_name(category.getCompetitionName());
		categoryCtr.setGame_id(category.getCompetitionId());
		categoryCtr.setJudge_wxid(category.getJudgeWxid());
		return categoryCtr;
	}
	
	public static EventCtr eventDaoToCtr(Event event) {
		EventCtr eventCtr = new EventCtr();
		eventCtr.setCategory_name(event.getCategoryName());
		eventCtr.setCategory_id(event.getCategoryId());
		eventCtr.setGame_name(event.getCompetitionName());
		eventCtr.setGame_id(event.getCompetitionId());
		eventCtr.setGender(event.getEventGender());
		eventCtr.setItem_description(event.getEventDescription());
		eventCtr.setItem_level(event.getEventLevel());
		eventCtr.setItem_name(event.getEventName());
		eventCtr.setItem_place(event.getEventPlace());
		eventCtr.setItem_type(event.getEventType());
		eventCtr.setItem_id(event.getEventId());
		eventCtr.setJudge_wxid(event.getJudgeWxid());
		eventCtr.setPath_num(event.getPeopleNum());
		eventCtr.setRank_criterion(event.getRankCriterion());
		List<String> desList = conversionUtils.eventService.getDescription(event.getEventId());
		eventCtr.setCategory_description(desList.get(1));
		eventCtr.setGame_description(desList.get(0));
		
		return eventCtr;
	}
	
	public static NewsCtr newsDaoToCtr(News news) {
		NewsCtr newsCtr = new NewsCtr();
		newsCtr.setNews_id(news.getNewsId());
		newsCtr.setNews_type(news.getNewsType());
		newsCtr.setAuthor_wxid(news.getAuthorWxid());
		newsCtr.setContent(news.getContent());
		newsCtr.setRemark(news.getRemark());
		newsCtr.setStatus(news.getStatus());
		newsCtr.setSummary(news.getSummary());
		newsCtr.setTitle(news.getTitle());
		newsCtr.setCreated(news.getCreated());
		newsCtr.setUpdated(news.getUpdated());
		return newsCtr;
	}
	
	public static News newsDaoToCtr(NewsCtr newsCtr) {
		News news = new News();
		news.setNewsId(newsCtr.getNews_id());
		news.setNewsType(newsCtr.getNews_type());
		news.setAuthorWxid(news.getAuthorWxid());
		news.setContent(newsCtr.getContent());
		news.setRemark(newsCtr.getRemark());
		news.setStatus(newsCtr.getStatus());
		news.setSummary(newsCtr.getSummary());
		news.setTitle(newsCtr.getTitle());
		news.setCreated(newsCtr.getCreated());
		news.setUpdated(newsCtr.getUpdated());
		return news;
	}
	
	public static List<NewsCtr> newsDaoListToCtrList(List<News> newss){
		List<NewsCtr> newsCtrs = new ArrayList<>();
		for(News news : newss){
			newsCtrs.add(newsDaoToCtr(news));
		}
		return newsCtrs;
	}
	
	public static List<CompetitionCtr> competitionDaoListToCtrList(List<Competition> competitions){
		List<CompetitionCtr> competitionCtrs = new ArrayList<>();
		for(Competition competition : competitions) {
			competitionCtrs.add(competitionDaoToCtr(competition));
		}
		return competitionCtrs;
	}
	
	public static List<CategoryCtr> categoryDaoListToCtrList(List<Category> categories) {
		List<CategoryCtr> categoryCtrs = new ArrayList<>();
		for(Category category : categories) {
			categoryCtrs.add(categoryDaoToCtr(category));
		}	
		return categoryCtrs;	
	}
	
	public static List<EventCtr> eventDaoListToCtrList(List<Event> events) {
		List<EventCtr> eventCtrs = new ArrayList<>();
		for(Event event : events) {
			eventCtrs.add(eventDaoToCtr(event));
		}
		return eventCtrs;	
	}
	
	public static RemarkMessageCtr remarkMessageDaoToCtr(RemarkMessage remarkMessage) {
		RemarkMessageCtr remarkMessageCtr = new RemarkMessageCtr();
		remarkMessageCtr.setUser_wxid(remarkMessage.getUserWxid());
		remarkMessageCtr.setContent(remarkMessage.getRemarkMessage());
		remarkMessageCtr.setManager_wxid(remarkMessage.getManagerWxid());;
		remarkMessageCtr.setProcess_state(TypeOfProcessState.getTypeName(remarkMessage.getRemarkProcessState()));
		remarkMessageCtr.setFeedback(remarkMessage.getFeedback());
		return remarkMessageCtr;
	}
	
	public static RemarkMessage remarkMessageCtrToDao(RemarkMessageCtr remarkMessageCtr) {
		RemarkMessage remark = new RemarkMessage();
		remark.setUserWxid(remarkMessageCtr.getUser_wxid());
		remark.setRemarkMessage(remarkMessageCtr.getContent());
		remark.setManagerWxid(remarkMessageCtr.getManager_wxid());
		remark.setRemarkProcessState(TypeOfProcessState.getType(remarkMessageCtr.getProcess_state()));
		remark.setFeedback(remarkMessageCtr.getFeedback());
		return remark;
	}
	
	public static List<RemarkMessageCtr> remarkMessageDaoListToCtrList(List<RemarkMessage> remarkMessages){
		List<RemarkMessageCtr> remarkMessageCtrs = new ArrayList<>();
		for(RemarkMessage rmMessage : remarkMessages) {
			remarkMessageCtrs.add(remarkMessageDaoToCtr(rmMessage));
		}
		return remarkMessageCtrs;
	}
}
