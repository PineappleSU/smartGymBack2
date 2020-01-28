package cn.smartGym.service.impl;

import java.io.IOException;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.smartGym.mapper.PlayerMapper;
import cn.smartGym.pojo.AppUser;
import cn.smartGym.pojo.Application;
import cn.smartGym.pojo.GameApplication;
import cn.smartGym.pojo.Item;
import cn.smartGym.pojo.Player;
import cn.smartGym.pojo.PlayerExample;
import cn.smartGym.pojo.PlayerExample.Criteria;
import cn.smartGym.pojoCtr.PlayerCtr;
import cn.smartGym.service.CollegeService;
import cn.smartGym.service.PlayerService;
import cn.smartGym.utils.CollegeAndCampusUtils;
import common.enums.ErrorCode;
import common.enums.Gender;
import common.enums.GenderGroup;
import common.enums.Job;
import common.utils.ExcelHelper;
import common.utils.IDUtils;
import common.utils.SGResult;

/**
 * 参赛人员管理Service
 *
 * @author Ruimeng Jin
 */
@Service
public class PlayerServiceImpl implements PlayerService {
	
	@Autowired
	private PlayerMapper playerMapper;

	@Override
	public SGResult updateUser(AppUser userUpdate) {
		PlayerExample example = new PlayerExample();
		Criteria criteria = example.createCriteria();

		if (StringUtils.isNotBlank(userUpdate.getStudentNo()))
			criteria.andStudentNoEqualTo(userUpdate.getStudentNo());

		Player playerExample = new Player();
		playerExample.setName(userUpdate.getUserName());
		playerExample.setCollege(userUpdate.getCollege());
		playerExample.setUpdated(new Date());
		playerMapper.updateByExampleSelective(playerExample, example);

		return SGResult.ok();
	}
	
	/**
	 * 根据报名信息生成参赛信息
	 */
	@Override
	public SGResult genPlayerInfo(GameApplication gameApplication) {
		Player player = new Player();
		
		player.setId(IDUtils.genId());
		player.setName(gameApplication.getName());
		player.setCollege(gameApplication.getCollege());
		player.setStudentNo(gameApplication.getStudentNo());
		player.setEventId(gameApplication.getEventId());
		player.setJob(gameApplication.getJob());
		player.setGender(gameApplication.getGender());
		player.setStatus(1);
		player.setUpdated(new Date());
		player.setCreated(new Date());
		//添加参赛信息前先检查是否已经添加过
		PlayerExample example = new PlayerExample();
		Criteria criteria = example.createCriteria();
		criteria.andNameEqualTo(player.getName());
		criteria.andStudentNoEqualTo(player.getStudentNo());
		criteria.andEventIdEqualTo(player.getEventId());
		int p = playerMapper.selectByExample(example).size();
		if(p != 0)
			return SGResult.build(ErrorCode.CONFLICT.getErrorCode(), "已存在该报名信息！");
		playerMapper.insert(player);
		return SGResult.ok();
	}
	
	/**
	 * 根据参赛信息生成参赛号
	 */
	@Override
	public SGResult genPlayerNo(List<String> eventIdList) {
		PlayerExample example = new PlayerExample();
		example.setOrderByClause("college,student_no");
		for (String eventId : eventIdList) {
			Criteria criteria = example.or();
			criteria.andEventIdEqualTo(eventId);
			criteria.andStatusGreaterThanOrEqualTo(1);
		}
		List<Player> players = playerMapper.selectByExample(example);

		String curSid = "0000000";
		String curPid = "000000";
		Integer curCollege = 0;
		int index = 0;
		for (Player player : players) {
			if (!player.getStudentNo().equals(curSid)) {
				if (player.getCollege() == curCollege)
					index++;
				else
					index = 1;
				curSid = player.getStudentNo();
				curPid = String.format("%02d", player.getCollege()) + String.format("%04d", index);
				curCollege = player.getCollege();
			}

			player.setPlayerNo(curPid);
			player.setUpdated(new Date());
			playerMapper.updateByPrimaryKeySelective(player);
		}
		return SGResult.ok();
	}
	
	/**
	 * 根据参赛信息生成赛道数
	 */
	@Override
	public SGResult genPathNo(String eventId,Integer pathNum) {
		PlayerExample example = new PlayerExample();
		example.setOrderByClause("college");
		Criteria criteria = example.createCriteria();
		criteria.andEventIdEqualTo(eventId);
		criteria.andStatusNotEqualTo(0);
		List<Player> list = playerMapper.selectByExample(example);
		if (list == null || list.size() <= 0)
			return SGResult.build(ErrorCode.NO_CONTENT.getErrorCode(), "相关项目无报名人员！");

		// 取出赛道数,如果赛道数为空或为0,默认为全部运动员分为一组
		if (pathNum == null || pathNum == 0)
			pathNum = list.size() + 1;
		// 计算一共需要分多少组
		int totalGroupNum = list.size() / pathNum + 1; // 26 / 8 + 1 = 4
		// 计算最后一组有几人
		int numOfLastGroup = list.size() % pathNum; // 26 % 8 = 2;

		int index = 0;
		for (int pathNo = 1; pathNo <= numOfLastGroup; pathNo++) {
			for (int groupNo = 1; groupNo <= totalGroupNum; groupNo++) {
				Player player = list.get(index);
				player.setGroupNo(groupNo);
				player.setPathNo(pathNo);
				player.setUpdated(new Date());
				playerMapper.updateByPrimaryKeySelective(player);
				index++;
			}
		}

		for (int pathNo = numOfLastGroup + 1; pathNo <= pathNum; pathNo++) {
			for (int groupNo = 1; groupNo < totalGroupNum; groupNo++) {
				Player player = list.get(index);
				player.setGroupNo(groupNo);
				player.setPathNo(pathNo);
				player.setUpdated(new Date());
				playerMapper.updateByPrimaryKeySelective(player);
				index++;
			}
		}

		// 判断最后一组的人数，如果人数少于3人，则需要从倒数第二组取人过来补到4人
		if (numOfLastGroup < 3) {
			int num = 4 - numOfLastGroup; // 4表示补到4人
			for (int j = 0; j < num; j++) {
				Player player = list.get(index - 1 - (totalGroupNum - 1) * j);
				player.setGroupNo(totalGroupNum);
				player.setPathNo(numOfLastGroup + j + 1);
				player.setUpdated(new Date());
				playerMapper.updateByPrimaryKeySelective(player);
			}
		}

		return SGResult.ok("设置参赛队员分组和赛道成功！");
	}

	/**
	 * 根据学号和项目id获取具体参赛信息（已审核通过）
	 */
	@Override
	public Player getPlayerInfoByStudentNoAndEventId(String studengNo,String eventId) {
		PlayerExample example = new PlayerExample();
		Criteria criteria = example.createCriteria();
		criteria.andEventIdEqualTo(eventId);
		criteria.andStudentNoEqualTo(studengNo);
		criteria.andStatusNotEqualTo(0);
		List<Player> playerInfo = playerMapper.selectByExample(example);
		if(playerInfo.size()!=0)
			return playerInfo.get(0);
		return null;
	}

}
