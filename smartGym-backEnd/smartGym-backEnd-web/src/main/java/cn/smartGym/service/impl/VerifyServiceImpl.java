package cn.smartGym.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.smartGym.mapper.PlayerMapper;
import cn.smartGym.pojo.Player;
import cn.smartGym.pojo.PlayerExample;
import cn.smartGym.pojo.PlayerExample.Criteria;
import cn.smartGym.pojoCtr.PlayerCtr;
import cn.smartGym.service.VerifyService;
import cn.smartGym.utils.ConversionUtils;
import common.enums.ErrorCode;
import common.utils.SGResult;

/** 
* @author Ma Shuaijie:
* 
* @version 创建时间：2020年1月10日 下午9:45:53 
*
* 审核功能服务实现层
*/
@Service
public class VerifyServiceImpl implements VerifyService{
	@Autowired
	PlayerMapper playerMapper;

	
	/** 
	 *登记成绩
	*/
	@Override
	public SGResult recordScore(PlayerCtr playCtr, String user_wxid) {
		PlayerExample example = new PlayerExample();
		Criteria criteria = example.createCriteria();
		criteria.andEventIdEqualTo(playCtr.getItem_id());
		criteria.andStudentNoEqualTo(playCtr.getStudent_no());
		Player player = playerMapper.selectByExample(example).get(0);
		player.setRaterWxId(user_wxid);
		playerMapper.updateByPrimaryKey(player);
		return SGResult.build(ErrorCode.SUCCESS.getErrorCode(), "登记成功！");
	}

	@Override
	public SGResult generateRank(PlayerCtr playerCtr, String user_wxid) {
		Player playerReceived = ConversionUtils.playerCtrToDao(playerCtr);
		PlayerExample example = new PlayerExample();
		Criteria criteria = example.createCriteria();
		criteria.andEventIdEqualTo(playerReceived.getEventId());
		criteria.andGenderEqualTo(playerReceived.getGender());
		example.setOrderByClause("grades");
		List<Player> playerList = playerMapper.selectByExample(example);
		List<Map<String,Object>> itemlist = new ArrayList<>();
		int index = 1;
		for (Player player :playerList) {
			player.setRankNo(index);
			playerMapper.updateByPrimaryKeySelective(player);
			Map<String,Object> rankMap = new HashMap<String, Object>();
			rankMap.put("item_id",player.getEventId());
			rankMap.put("item_name",player.getName());
			rankMap.put("student_no",player.getStudentNo());
			rankMap.put("grades",player.getGrades());
			rankMap.put("rank_no",index);
			index++;
			itemlist.add(rankMap);
		}
		return SGResult.build(ErrorCode.SUCCESS.getErrorCode(), "查找成功！",itemlist);
	}

}
