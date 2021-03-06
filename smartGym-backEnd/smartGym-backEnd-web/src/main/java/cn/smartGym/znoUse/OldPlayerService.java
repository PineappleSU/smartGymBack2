
package cn.smartGym.znoUse;

import java.io.IOException;
import java.util.List;

import cn.smartGym.pojo.AppUser;
import cn.smartGym.pojo.Application;
import cn.smartGym.pojo.Player;
import cn.smartGym.pojo.SgUser;
import common.utils.SGResult;

public interface OldPlayerService {

	Player applicationDaoToPlayerDao(Application apply);

	SGResult reviewByUniversityManager(List<Application> applications);

	void hardDeletePlayer();

	void maintenancePlayer(List<Long> itemIds, List<String> studentNos);

	SGResult updateUser(AppUser userUpdate);

	void genPlayerNo(List<Long> itemsId);

	SGResult genGroupNoAndPathNo(Long itemId, Integer pathNum);

	SGResult registerGrades(Player player, Integer type, Integer type2);

	Player getPlayerByPlayerIdAndStatuses(Long playerId, Integer... statuses);

	SGResult genRank(Long itemId, Integer type);

	SGResult getTopK(Long itemId, Integer k);

	List<Player> getPlayersByStudentNo(String studentNo);

	List<Player> getPlayersByCollegeAndItemIds(String college, Long... itemIds);

	/**
	 * 根据赛事名获取秩序册文件路径 by zh
	 *
	 * @param game
	 * @return
	 */
	String getPlayersExcelFilePath(String game);

	/**
	 * 根据赛事名生成比赛秩序册 by zh
	 *
	 * @param game
	 */

	void generatePlayersExcel(String game) throws IOException;

	void generatePlayersDetailedExcel(String game) throws IOException;
}
