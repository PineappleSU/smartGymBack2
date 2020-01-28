package cn.smartGym.service;

import java.util.List;

import cn.smartGym.pojo.Player;
import cn.smartGym.pojo.AppUser;
import cn.smartGym.pojo.GameApplication;
import cn.smartGym.pojoCtr.PlayerCtr;
import common.utils.SGResult;


public interface PlayerService {
	
	SGResult updateUser(AppUser userUpdate);

	SGResult genPlayerInfo(GameApplication gameApplication);

	SGResult genPlayerNo(List<String> eventIdList);

	SGResult genPathNo(String eventId,Integer pathNum);

	Player getPlayerInfoByStudentNoAndEventId(String studeng_no,String event_id);

}
