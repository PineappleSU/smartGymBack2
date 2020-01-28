package cn.smartGym.controller;

import java.util.ArrayList;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sound.midi.Soundbank;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.smartGym.pojo.AppUser;
import cn.smartGym.pojoCtr.AppUserCtr;
import cn.smartGym.service.AppUserService;
import cn.smartGym.service.CampusService;
import cn.smartGym.service.CollegeService;
import cn.smartGym.service.GameApplicationService;
import cn.smartGym.service.GetCertainValueService;
import cn.smartGym.utils.ConversionUtils;
import cn.smartGym.service.PlayerService;
import common.enums.ErrorCode;
import common.utils.SGResult;

/**
 * 用户管理Controller
 * 
 * @author pineapplesu
 *
 */

@Controller
public class AppUserController {
	
	@Autowired
	private AppUserService appUserService;
	
	@Autowired
	private CollegeService collegeService;
	
	@Autowired
	private GameApplicationService gameApplicationService;
	
	@Autowired
	private CampusService campusService;
	
	@Autowired
	private PlayerService playerService;
	
	@Autowired
	private GetCertainValueService getCertainValueService;
	
	/**
	 * 获取用户信息
	 * @throws Exception 
	 * 			-首次登录时，注册返回user_wxid
	 * 			-已注册时，根据wxid获取信息，设wxid为user_wxid
	 * 
	 */
	@RequestMapping(value = "/smartgym/appUser/getAppUserList", method = { RequestMethod.POST,
			RequestMethod.GET }, consumes = "application/x-www-form-urlencoded;charset=utf-8")
	@ResponseBody
	public SGResult getAppUserList(AppUserCtr appUserCtr) throws Exception {
		// 检查是否需要解密用户数据
		if (StringUtils.isBlank(appUserCtr.getUser_wxid()) || "undefined".equals(appUserCtr.getUser_wxid())){
			// 解密用户敏感数据
			SGResult sgResult = appUserCtr.decodeWxId();

			if (sgResult.isOK())
				appUserCtr.setUser_wxid((String) sgResult.getData());
			else
				return sgResult;
			
		}
		
		AppUser appUser = (AppUser)appUserService.getAppUserList(ConversionUtils.appUserCtrToDao(appUserCtr)).getData();
		
		if(appUser != null) {
			AppUserCtr appUserCtrSigned = ConversionUtils.appUserDaoToCtr(appUser);
			return SGResult.ok("该用户已注册！", appUserCtrSigned);
		}
		else {
			appUserCtr.setStatus(0);
			return SGResult.ok("该用户未注册！", appUserCtr);
		}
		
	}
	
	/**
	 * 查询用户信息
	 * 
	 */
	@RequestMapping(value = "/smartgym/appUser/getAppUserListByDetails", method = { RequestMethod.POST,
			RequestMethod.GET }, consumes = "application/x-www-form-urlencoded;charset=utf-8")
	@ResponseBody
	public SGResult getAppUserListByDetails(String user_wxid, String student_no) throws Exception{
		return appUserService.getAppUserListByDetails(user_wxid,student_no);
	}
	
	
	/**
	 * 用户信息维护-注册
	 */
	@RequestMapping(value = "/smartgym/appUser/register", method = { RequestMethod.POST,
			RequestMethod.GET }, consumes = "application/x-www-form-urlencoded;charset=utf-8")
	@ResponseBody
	public SGResult register(AppUserCtr appUserCtr) throws Exception {
		SGResult sGResult = appUserService.register(ConversionUtils.appUserCtrToDao(appUserCtr));
		if (sGResult.isOK()) {
			// 把结果返回
			AppUserCtr appUserCtrRegister = ConversionUtils.appUserDaoToCtr((AppUser) sGResult.getData());
			return SGResult.ok("注册成功！", appUserCtrRegister);
		} else
			return sGResult;

	}

	/***
	 * 用户信息维护-修改
	 * 
	 *
	 */
	@RequestMapping(value = "/smartgym/appUser/update", method = { RequestMethod.POST,
			RequestMethod.GET }, consumes = "application/x-www-form-urlencoded;charset=utf-8")
	@ResponseBody
	public SGResult updateUser(AppUserCtr appUserCtr) throws Exception {
		SGResult sGResult = appUserService.update(ConversionUtils.appUserCtrToDao(appUserCtr));
		if (sGResult.isOK()) {
			AppUser userUpdate = (AppUser) sGResult.getData();
			gameApplicationService.updateUser(userUpdate);
			playerService.updateUser(userUpdate);
			AppUserCtr userCtrUpdate = ConversionUtils.appUserDaoToCtr(userUpdate);
			// 把结果返回
			return SGResult.ok("修改资料成功！", userCtrUpdate);
		} else
			return sGResult;
	}
	
	/**
	 * 更新用户权限
	 * 
	 */
	@RequestMapping(value = "/smartgym/appUser/updateUserAuthority", method = { RequestMethod.POST,
			RequestMethod.GET }, consumes = "application/x-www-form-urlencoded;charset=utf-8")
	@ResponseBody
	public SGResult updateUserAuthority(String user_wxid, String stu_wxid, Integer user_admin_type, Integer
			user_admin_level,String game_id) throws Exception {
		Map<String,Object> map = getCertainValueService.getCertainValueOfAppUser(null,user_wxid, "userType","judgeLevel","adminLevel","wxId");
		return appUserService.updateUserAuthority(map,stu_wxid,user_admin_type,user_admin_level,game_id);
		
	}
	
	/**
	 * 设置副裁判长和裁判员
	 * 
	 */
	@RequestMapping(value = "/smartgym/appUser/setJudgeByIdList", method = { RequestMethod.POST,
			RequestMethod.GET }, consumes = "application/x-www-form-urlencoded;charset=utf-8")
	@ResponseBody
	public SGResult setJudgeByIdList(String user_wxid, String stu_wxid, Integer user_admin_type, Integer
			user_admin_level,String game_id, @RequestParam("category_id_list") List<String> category_id_list, @RequestParam("item_id_list") List<String> item_id_list) throws Exception {
		Map<String,Object> map = getCertainValueService.getCertainValueOfAppUser(null,user_wxid, "userType","judgeLevel","adminLevel","wxId");
		return appUserService.setJudgeByIdList(map,stu_wxid,user_admin_type,user_admin_level,game_id,category_id_list,item_id_list);
		
	}
	
	/**
	 * 获取所有学院和校区
	 */
	@RequestMapping(value = "/smartgym/appUser/getCollegeList", method = { RequestMethod.POST,
			RequestMethod.GET }, consumes = "application/x-www-form-urlencoded;charset=utf-8")
	@ResponseBody
	public SGResult getCollegeList() throws Exception {
		List<String> colleges = collegeService.getAllColleges();
		List<String> campuses = campusService.getAllCampuses();
		Map<String, List<String>> result = new HashMap<String, List<String>>();
		result.put("campuses", campuses);
		result.put("colleges", colleges);
		
		return SGResult.ok("获取校区和学院信息成功！", result);
	}

}
