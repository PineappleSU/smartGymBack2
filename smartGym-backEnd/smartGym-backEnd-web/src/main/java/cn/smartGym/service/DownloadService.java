package cn.smartGym.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import cn.smartGym.pojo.GameApplication;
import cn.smartGym.pojo.Player;

/**
 * 下载管理Service
 * 
 * @author pineapplesu
 *
 */
public interface DownloadService {

	void generateGameApplExcelsByCollege(String competition, String college, Map<String, Object> adminMap) throws IOException;

	Map<String, Object> getAdminLevelAndCollege(String userWxid);

	List<GameApplication> getGameApplListByEventIdsAndCollegeAndStatus(List<String> eventIds, String college,
			Map<String, Object> adminMap, Integer... statuses);

	void generatePlayerRankExcelsByCollege(String game_name, String college, Map<String, Object> adminMap) throws IOException;

	List<Player> getPlayerListByEventIdAndCollegeAndStatus(List<String> eventIds, String college,
			Map<String, Object> adminMap, Integer... statuses);
	String getExcelFilePath(String competition, String... college);

	void inserIntoWorkerByCompetition(String competition);

	void generateWorkerExcelsByCompetition(String competition, Map<String, Object> adminMap) throws IOException;

}
