package cn.smartGym.service;

import java.util.List;
import java.util.Map;


import cn.smartGym.pojo.AppUser;
import common.utils.SGResult;

/**
 * 用户管理service
 * 
 * @author pineapplesu
 *
 */
public interface AppUserService {

	SGResult getAppUserList(AppUser appUser);

	SGResult register(AppUser appUser);

	SGResult checkData(String param, int type);

	SGResult update(AppUser appUser);

	SGResult getAppUserListByDetails(String userWxId, String studentNo);
	
	Map<String, Object> getAuthority(String userWxId);

	SGResult getAppUserByDetail(AppUser appUser);

	SGResult updateUserAuthority(Map<String, Object> map, String stuWxId, Integer userAdminType, Integer userAdminLevel,
			String competitionId);

	SGResult setJudgeByIdList(Map<String, Object> map, String stu_wxid, Integer user_admin_type,
			Integer user_admin_level, String game_id, List<String> category_id_list, List<String> item_id_list);
}
