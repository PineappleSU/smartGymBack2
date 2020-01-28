package cn.smartGym.service.impl;


import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import cn.smartGym.mapper.AppUserMapper;
import cn.smartGym.mapper.CompetitionMapper;
import cn.smartGym.mapper.EventMapper;
import cn.smartGym.pojo.AppUser;
import cn.smartGym.pojo.AppUserExample;
import cn.smartGym.pojo.AppUserExample.Criteria;
import cn.smartGym.pojo.Competition;
import cn.smartGym.pojo.CompetitionExample;
import cn.smartGym.pojo.Event;
import cn.smartGym.pojo.EventExample;
import cn.smartGym.service.AppUserService;
import cn.smartGym.utils.ConversionUtils;
import common.enums.ErrorCode;
import common.utils.IDUtils;
import common.utils.SGResult;

/**
 * 用户管理ServiceImpl
 * 
 * @author pineapplesu
 *
 */

@Service
public class AppUserServiceImpl implements AppUserService{
	
	@Autowired
	private AppUserMapper appUserMapper;
	
	@Autowired
	private CompetitionMapper competitionMapper;
	
	@Autowired
	private EventMapper eventMapper;
	
	
	@Value("${SESSION_EXPIRE}")
	private Integer SESSION_EXPIRE;
	
	/**
	 * 获取用户信息
	 */
	@Override
	public SGResult getAppUserList(AppUser appUser) {
	
		if(appUser == null)
			return SGResult.build(ErrorCode.BAD_REQUEST.getErrorCode(), "请输入用户信息！");
		
		
		AppUserExample example = new AppUserExample();
		
		if(StringUtils.isBlank(appUser.getWxId()))
			return SGResult.build(ErrorCode.BAD_REQUEST.getErrorCode(), "微信号不能为空！");
		
		Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(1);
		criteria.andWxIdEqualTo(appUser.getWxId());
		
		List<AppUser> appUserList = appUserMapper.selectByExample(example);
		if(appUserList == null || appUserList.size() <= 0)
			return SGResult.build(ErrorCode.NO_CONTENT.getErrorCode(), "未查到该用户信息！");
		
		return SGResult.ok("查询成功!", appUserList.get(0));
	}
	
	/**
	 * 查询用户信息-根据微信号和学号
	 */
	@Override
	public SGResult getAppUserListByDetails(String userWxId, String studentNo) {
		
		AppUserExample example = new AppUserExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(1);
		if(userWxId == null) 
			return SGResult.build(ErrorCode.NO_CONTENT.getErrorCode(), "请输入微信号！");
		if(studentNo == null) 
			return SGResult.build(ErrorCode.NO_CONTENT.getErrorCode(), "请输输入学号！");
		
		criteria.andWxIdEqualTo(userWxId);
		criteria.andStudentNoEqualTo(studentNo);
		List<AppUser> appUserList = appUserMapper.selectByExample(example);
		
		if(appUserList == null || appUserList.size() <= 0)
			return SGResult.build(ErrorCode.NO_CONTENT.getErrorCode(), "未查到该用户信息！");
		
		return SGResult.ok("查询成功!", ConversionUtils.appUserDaoListToCtrList(appUserList));
	}
	
	/**
	 * 查询用户：根据用户信息（微信或学号）查询记录
	 * 
	 * @param studentNo
	 */
	@Override
	public SGResult getAppUserByDetail(AppUser appUser) {
		if (appUser == null)
			return SGResult.build(ErrorCode.BAD_REQUEST.getErrorCode(), "请输入用户信息！");

		AppUser result = new AppUser();
		String wxId = appUser.getWxId();
		if (!StringUtils.isBlank(wxId) && !"undefined".equals(wxId)) {
			// 缓存中查不到信息，从数据库中查找
			AppUserExample example = new AppUserExample();
			if (StringUtils.isBlank(appUser.getWxId()) && StringUtils.isBlank(appUser.getStudentNo()))
				return SGResult.build(ErrorCode.BAD_REQUEST.getErrorCode(), "微信号和学号不能都为空！");
	
			Criteria criteria = example.createCriteria();
			criteria.andStatusEqualTo(1);
	
			if (!StringUtils.isBlank(appUser.getWxId()))
				criteria.andWxIdEqualTo(appUser.getWxId());
			if (!StringUtils.isBlank(appUser.getStudentNo()))
				criteria.andStudentNoEqualTo(appUser.getStudentNo());
	
			List<AppUser> userList = appUserMapper.selectByExample(example);
			if (userList == null || userList.size() <= 0)
				return SGResult.build(ErrorCode.NO_CONTENT.getErrorCode(), "未查到该用户信息！");
	
			result = userList.get(0);
	
			return SGResult.ok("查询成功！", result);
		}else 
		return SGResult.build(ErrorCode.NO_CONTENT.getErrorCode(), "未查到该用户信息！");
	}
	
	/**
	 * 用户注册
	 * 
	 */
	@Override
	public SGResult register(AppUser appUser) {
		// 数据有效性检验
		if (StringUtils.isBlank(appUser.getStudentNo()) || StringUtils.isBlank(appUser.getUserName())
				|| StringUtils.isBlank(appUser.getPhone()) || StringUtils.isBlank(appUser.getWxId()))
			return SGResult.build(ErrorCode.BAD_REQUEST.getErrorCode(), "用户数据不完整，注册失败");
		// 1：学号 2：微信号 3：手机号
		SGResult result = checkData(appUser.getStudentNo(), 1);
		if (!result.isOK())
			return result;
		if (!(boolean) result.getData()) {
			return SGResult.build(ErrorCode.CONFLICT.getErrorCode(), "此学号已经被注册!");
		}

		result = checkData(appUser.getWxId(), 2);
		if (!result.isOK())
			return result;
		if (!(boolean) result.getData()) {
			return SGResult.build(ErrorCode.CONFLICT.getErrorCode(), "此微信已注册账号！");
		}

		result = checkData(appUser.getPhone(), 3);
		if (!result.isOK())
			return result;
		if (!(boolean) result.getData()) {
			return SGResult.build(ErrorCode.CONFLICT.getErrorCode(), "此手机号已经被占用!");
		}

		// 补全pojo属性
		appUser.setAdminLevel(0); // 0是普通用户
		appUser.setJudgeLevel(0);
		appUser.setUserType(0);

		if(appUser.getType() == null)
			appUser.setType(0);
		
		appUser.setCreated(new Date());
		appUser.setUpdated(new Date());
		appUser.setStatus(1); // 0是删除，1是正常
		appUser.setUserId(IDUtils.genId());

		// 把用户数据插入数据库
		appUserMapper.insert(appUser);

		// 返回添加成功
		return SGResult.ok("注册成功！", appUser);
	}
	
	/**
	 * 检查记录是否已存在
	 */
	@Override
	public SGResult checkData(String param, int type) {
		// 根据不同的type生成不同的查询条件
		AppUserExample example = new AppUserExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(1);

		// 1：学号 2：微信号 3：手机号
		if (type == 1) {
			criteria.andStudentNoEqualTo(param);
		} else if (type == 2) {
			criteria.andWxIdEqualTo(param);
		} else if (type == 3) {
			criteria.andPhoneEqualTo(param);
		} else {
			return SGResult.build(ErrorCode.BAD_REQUEST.getErrorCode(), "数据类型错误!");
		}

		// 执行查询
		List<AppUser> list = appUserMapper.selectByExample(example);
		// 判断结果中是否包含数据
		if (list != null && list.size() > 0) {
			// 如果有数据返回false
			return SGResult.ok(false);
		}

		// 如果没有数据返回true
		return SGResult.ok(true);
	}

	/**
	 * 修改用户信息
	 * 
	 */
	@Override
	public SGResult update(AppUser appUser) {
		// 检查数据合法性
		if (appUser.getStudentNo() == null)
			return SGResult.build(ErrorCode.BAD_REQUEST.getErrorCode(), "学号不能为空！");
		if (appUser.getWxId() == null)
			return SGResult.build(ErrorCode.BAD_REQUEST.getErrorCode(), "微信号不能为空！");

		// 检查学号和微信是否对应
		AppUserExample example = new AppUserExample();
		Criteria criteria = example.createCriteria();
		criteria.andStudentNoEqualTo(appUser.getStudentNo());
		criteria.andWxIdEqualTo(appUser.getWxId());
		criteria.andStatusEqualTo(1);
		List<AppUser> result = appUserMapper.selectByExample(example);
		if (result.isEmpty())
			return SGResult.build(ErrorCode.CONFLICT.getErrorCode(), "不能修改学号！");

		AppUser userOld = result.get(0);

		// 如果手机号已修改，检查新手机号是否合法
		if(appUser.getPhone() != null) {
			if (!appUser.getPhone().equals(userOld.getPhone())) {
				if (!(boolean) checkData(appUser.getPhone(), 3).getData())
					return SGResult.build(ErrorCode.CONFLICT.getErrorCode(), "该手机号已经被注册！");
			}
		}

		appUser.setUserId(userOld.getUserId());
		appUser.setUpdated(new Date());

		appUserMapper.updateByPrimaryKeySelective(appUser);

		return SGResult.ok("修改资料成功！", appUser);
	}
	
	
	/**
	 * 修改用户权限
	 * UserAdminLevel:0-普通（默认） 1-裁判 2-赛事临时管理员 3-管理员 
	 * UserAdminType:
	 * 			judgelevel:0-普通 1-裁判员（项目裁判)  2-副裁判长（比赛裁判） 3-裁判长
	 * 			adminlevel:0-普通 1-院级体育部部长 2-院级管理员 3-赛事负责人 4-校级管理员 5-后台管理员			
	 */
	@Override
	public SGResult updateUserAuthority(Map<String, Object> map, String stuWxId, Integer userAdminType, Integer userAdminLevel,String competitionId) {
		
		AppUserExample example = new AppUserExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(1);
		criteria.andWxIdEqualTo(stuWxId);
		List<AppUser> stuuser = appUserMapper.selectByExample(example);
		if((int)map.get("judgeLevel") == 3 && userAdminType == 1 && (String)map.get("wxId") != stuWxId) {		//任命裁判
			if(userAdminLevel > 3)
				stuuser.get(0).setJudgeLevel(userAdminLevel);			//只能任命裁判长或副裁判长			
		}else if ((userAdminType == 2 || userAdminType == 3) && (String)map.get("wxId") != stuWxId) {			//任命管理员
			if((int)map.get("adminLevel") > userAdminLevel) {
				stuuser.get(0).setAdminLevel(userAdminLevel);			
				if(competitionId != null) {
					Competition competition = new Competition();		//管理员绑定赛事
					competition.setCompetitionId(competitionId);
					competition.setPrincipalWxid(stuWxId);
					competitionMapper.updateByPrimaryKeySelective(competition);
				}
				else 
					return SGResult.build(ErrorCode.BAD_REQUEST.getErrorCode(), "管理员未指定所绑定的赛事ID！");
			}
			else 
				return SGResult.build(ErrorCode.BAD_REQUEST.getErrorCode(), "管理员只能上级任命下级！");
			}
		else 
			return SGResult.build(ErrorCode.BAD_REQUEST.getErrorCode(), "权限不足！");
		stuuser.get(0).setAdminLevel(userAdminLevel);
		appUserMapper.updateByPrimaryKeySelective(stuuser.get(0));
		return SGResult.ok("设置权限成功！");
	}

	
	/**
	 * 获取用户权限
	 */
	@Override
	public Map<String, Object> getAuthority (String userWxId) {
		Map<String, Object> authorityMap = new HashMap<String, Object>();
		AppUserExample example = new AppUserExample();
		Criteria criteria = example.createCriteria();
		criteria.andWxIdEqualTo(userWxId);
		List<AppUser> list = appUserMapper.selectByExample(example);
		if(list.size()==1) {
		AppUser appUser = list.get(0);
		authorityMap.put("adminLevel", appUser.getAdminLevel());  
		authorityMap.put("judgeLevel", appUser.getJudgeLevel());
		}
		else {
		authorityMap.put("adminLevel", 0);  
		authorityMap.put("judgeLevel", 0);
		}
		return authorityMap;		
	}
	
	/**
	 * 设置副裁判长和裁判员
	 * 			裁判部分，只有裁判长能任命用户为裁判员或副裁判长；
	 * 			副裁判长可以判决所有比赛，而裁判员需绑定对应的比赛、项目或者某个项目的具体哪一场比赛
	 */
	@Override
	public SGResult setJudgeByIdList(Map<String, Object> map, String stuWxId, Integer userAdminType,
			Integer userAdminLevel, String competitionId, List<String> category_id_list, List<String> event_id_list) {
		AppUserExample example = new AppUserExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(1);
		criteria.andWxIdEqualTo(stuWxId);
		List<AppUser> stuuser = appUserMapper.selectByExample(example);
		
		if((int)map.get("judgeLevel") == 3 && userAdminType == 1 && (String)map.get("wxId") != stuWxId) {		//任命裁判
			if(userAdminLevel < 3 && userAdminLevel > 0 ) {
				stuuser.get(0).setJudgeLevel(userAdminLevel);			//只能任命副裁判长和裁判员	
				if(userAdminLevel == 1)	{									//裁判员绑定对应的比赛和项目
					EventExample eventExample = new EventExample();
					cn.smartGym.pojo.EventExample.Criteria criteria2 = eventExample.createCriteria();
					criteria2.andCompetitionIdEqualTo(competitionId);
					criteria2.andCategoryIdIn(category_id_list);
					criteria2.andEventIdIn(event_id_list);
					List<Event> events = eventMapper.selectByExample(eventExample);
					for(Event event : events) {
						event.setJudgeWxid(stuWxId);
						eventMapper.updateByPrimaryKeySelective(event);
					}
					appUserMapper.updateByPrimaryKeySelective(stuuser.get(0));
					return SGResult.ok("裁判员设置成功，绑定比赛和项目成功！");
				}
				appUserMapper.updateByPrimaryKeySelective(stuuser.get(0));
				return SGResult.ok("副裁判长设置成功！");
				
			}
			
		}
		return SGResult.build(ErrorCode.BAD_REQUEST.getErrorCode(), "权限不足！");

		
	}


	
}
