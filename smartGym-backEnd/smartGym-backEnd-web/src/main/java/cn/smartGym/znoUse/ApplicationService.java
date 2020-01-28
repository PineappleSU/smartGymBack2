package cn.smartGym.znoUse;

import java.io.IOException;

import java.util.List;

import cn.smartGym.pojo.AppUser;
import cn.smartGym.pojo.Application;
import cn.smartGym.pojo.Item;
import cn.smartGym.pojoCtr.response.ApplicationInfo;
import common.utils.SGResult;

/**
 * 比赛报名服务层
 * 
 * @author Ruimeng Jin
 *
 */
public interface ApplicationService {
	SGResult addApplication(Application application);

	SGResult checkData(Application application);

	void hardDeleteApplication();
	
	SGResult deleteApplication(Application application);
	
	SGResult updateUser(AppUser userUpdate);
	
	void maintenanceApplication(List<Long> itemIds, List<String> studentNos);

	List<Application> getApplicationListByStatusAndStudentNo(Integer status, String... studentNos);

	SGResult reviewByCollegeManager(List<Long> ids);

	List<Application> reviewByUniversityManager(List<Long> itemsId);
	
	//List<Application> reviewByUniversityManager(List<String> eventIds);

	Long countByitem(Long itemId);

	List<ApplicationInfo> getApplicationNumGroupByItem(List<Item> items);

	List<ApplicationInfo> getApplicationNumGroupByItemDetail(Item items);

	List<ApplicationInfo> getApplicationNumGroupByCollege(List<Item> items);

	List<ApplicationInfo> getApplicationNumGroupByCollegeDetail(List<Item> items, String college);

	List<Long> getIdsByApplications(List<Application> applications);

	/**
	 * 根据学院生成比赛报名Excel
	 * @param college
	 */
	//void generateApplicationsExcelByCollege(String game,String college) throws IOException;

	/**
	 * 获取报名Excel的文件路径
	 * @param game
	 * @param college
	 * @return
	 */
	String getApplicationsExcelFilePath(String game,String college);

	List<Application> getApplicationListByItemIdsAndCollegeAndStatus(List<Long> itemIdsIds, String college,
			Integer... statuses);


	//List<Application> getApplicationListByEventIdsAndCollegeAndStatus(List<String> eventIds, String college,
	//		Integer... statuses);



}
