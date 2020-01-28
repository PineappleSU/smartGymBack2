package cn.smartGym.service;

import cn.smartGym.pojoCtr.PlayerCtr;
import common.utils.SGResult;

/** 
* @author Ma Shuaijie:
* 
* @version 创建时间：2020年1月10日 下午9:45:53 
*
* 审核功能服务层 
*/
public interface VerifyService {
	public SGResult recordScore(PlayerCtr playCtr,String user_wxid);

	public SGResult generateRank(PlayerCtr playerCtr, String user_wxid);
}
