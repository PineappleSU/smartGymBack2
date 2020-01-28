package cn.smartGym.service;

import java.io.IOException;

import java.util.List;

import cn.smartGym.pojo.AppUser;
import cn.smartGym.pojo.GameApplication;
import common.utils.SGResult;



public interface GameApplicationService  {
	
	void generateGameApplicationsExcelByCollege(String game,String college) throws IOException;

	List<GameApplication> getGameApplicationListByEventIdsAndCollegeAndStatus(List<String> eventIds, String college,
			Integer... statuses);
	
	String getGameApplicationsExcelFilePath(String competition, String college);
	
	SGResult addGameApplication(GameApplication gameApplication);

	SGResult checkGameApplcationData(GameApplication gameApplication);

	SGResult getApplicationByCategoryId(GameApplication gameApplication);

	SGResult getApplicationByItemId(GameApplication gameApplication);

	SGResult VerifyApplication(GameApplication gameApplication,int checked,int authority);

	SGResult updateUser(AppUser userUpdate);

	List<GameApplication> getAllGameApplication(String game_id);

	List<GameApplication> getMyGameApplicationListByStudentNo(String student_no);

}
