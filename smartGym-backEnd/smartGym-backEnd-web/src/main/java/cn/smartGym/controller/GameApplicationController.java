package cn.smartGym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.smartGym.pojo.GameApplication;
import cn.smartGym.pojoCtr.GameApplicationCtr;
import cn.smartGym.service.AppUserService;
import cn.smartGym.service.GameApplicationService;
import cn.smartGym.utils.ConversionUtils;
import common.enums.ErrorCode;
import common.utils.SGResult;

/**
 * 比赛项目管理Controller
 * 
 * @author Ma Shuaijie
 *
 */
@Controller
public class GameApplicationController {
	
	@Autowired
	GameApplicationService gameApplicationService;
	
	@Autowired
	AppUserService appUserService;
	
	/**
	 * 项目报名实现
	 * 
	 */
	@RequestMapping(value = "/smartgym/gameApplication/addApplication", method = { RequestMethod.POST,
			RequestMethod.GET }, consumes = "application/x-www-form-urlencoded")
	@ResponseBody
	public SGResult addApplication(GameApplicationCtr gameApplicationCtr) {
		if (gameApplicationCtr.getUser_wxid() == null||gameApplicationCtr.getStudent_no() == null
				||gameApplicationCtr.getItem_id() == null)
			return SGResult.build(ErrorCode.BAD_REQUEST.getErrorCode(), "输入信息不足");
		GameApplication gameApplication = ConversionUtils.gameApplicationCtrToDao(gameApplicationCtr);
		return gameApplicationService.addGameApplication(gameApplication);
	}
	
	/**
	 *按照具体赛事的比赛查询某个学院的报名人员列表
	 */
	@RequestMapping(value = "/smartgym/gameApplication/getApplicationByCategoryId", method = { RequestMethod.POST,
			RequestMethod.GET }, consumes = "application/x-www-form-urlencoded")
	@ResponseBody
	public SGResult getApplicationByCategoryId(GameApplicationCtr gameApplicationCtr) {
		if (gameApplicationCtr.getCategory_id() == null)
			return SGResult.build(ErrorCode.BAD_REQUEST.getErrorCode(), "输入信息不足");
		GameApplication gameApplication = ConversionUtils.gameApplicationCtrToDao(gameApplicationCtr);
		return gameApplicationService.getApplicationByCategoryId(gameApplication);
	}
	
	/**
	 *按照具体赛事的项目查询某个学院的报名人员列表
	 */
	@RequestMapping(value = "/smartgym/gameApplication/getApplicationByItemId", method = { RequestMethod.POST,
			RequestMethod.GET }, consumes = "application/x-www-form-urlencoded")
	@ResponseBody
	public SGResult getApplicationByItemId(GameApplicationCtr gameApplicationCtr) {
		if (gameApplicationCtr.getItem_id() == null)
			return SGResult.build(ErrorCode.BAD_REQUEST.getErrorCode(), "输入信息不足");
		GameApplication gameApplication = ConversionUtils.gameApplicationCtrToDao(gameApplicationCtr);
		return gameApplicationService.getApplicationByItemId(gameApplication);
	}
}
