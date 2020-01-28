package cn.smartGym.controller;

import java.io.IOException;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.smartGym.service.AppUserService;
import cn.smartGym.service.DownloadService;

import cn.smartGym.service.GameApplicationService;
import cn.smartGym.service.GetCertainValueService;
import common.enums.ErrorCode;
import common.utils.SGResult;
/**
 * 下载功能控制层
 * 
 * @author pineapplesu
 *
 */
@Controller
public class DownloadController {
	
	@Autowired
	private GameApplicationService gameApplicationService;

	@Autowired
	private DownloadService downloadService;
	
	@Autowired
	private GetCertainValueService getCertainValueService;
	
	
	/**
	 * 按学院生成比赛报名表
	 * 			根据：game_name, college
	 * 			功能：院级管理员下载负责学院，校级管理员下载任一学院或者全校
	 */
	@RequestMapping(value = "/smartgym/download/generateGameApplExcelsByCollege", method = { RequestMethod.POST,
			RequestMethod.GET })
	@ResponseBody
	public SGResult generateGameApplExcelsByCollege(String game_id, String college, String user_wxid) throws IOException {
		if(StringUtils.isBlank(game_id) || college == null || user_wxid == null)
			return SGResult.build(ErrorCode.BAD_REQUEST.getErrorCode(), "比赛号、学院名和管理员微信不能为空！");
		
		Map<String, Object> adminMap = downloadService.getAdminLevelAndCollege(user_wxid);
		downloadService.generateGameApplExcelsByCollege(game_id, college, adminMap);
		String filePath = downloadService.getExcelFilePath(game_id, college);
		return SGResult.ok("表格生成成功！", filePath);
	}

	/**
	 * 生成比赛成绩表
	 * 			根据：game_name, college
	 * 			功能：院级管理员下载负责学院，校级管理员下载任一学院或者全校
	 */
	@RequestMapping(value = "/smartgym/download/generatePlayerRankExcelsByCollege", method = { RequestMethod.POST,
			RequestMethod.GET })
	@ResponseBody
	public SGResult generatePlayerRankExcelsByCollege(String game_id, String college, String user_wxid) throws IOException {
		if(StringUtils.isBlank(game_id) || college == null || user_wxid == null)
			return SGResult.build(ErrorCode.BAD_REQUEST.getErrorCode(), "比赛号、学院名和管理员微信不能为空！");
		Map<String, Object> adminMap = downloadService.getAdminLevelAndCollege(user_wxid);
		downloadService.generatePlayerRankExcelsByCollege(game_id, college, adminMap);
		String filePath = downloadService.getExcelFilePath(game_id, college);
		return SGResult.ok("表格生成成功！", filePath);
	}
	
	/**
	 * 生成某赛事下所有比赛的工作人员
	 * 
	 */
	@RequestMapping(value = "/smartgym/download/inserIntoWorkerByCompetition", method = { RequestMethod.POST,
			RequestMethod.GET })
	@ResponseBody
	public SGResult inserIntoWorkerByCompetition(String game_id, String user_wxid) throws IOException {
		if(StringUtils.isBlank(game_id) || user_wxid == null)
			return SGResult.build(ErrorCode.BAD_REQUEST.getErrorCode(), "比赛号和管理员微信不能为空！");
		int authority = (int)getCertainValueService.getCertainValueOfAppUser(null,user_wxid,"adminLevel").get("adminLevel");
		if(authority >= 3) {
			downloadService.inserIntoWorkerByCompetition(game_id);
			return SGResult.ok("生成成功");
		}
		return SGResult.build(ErrorCode.NO_CONTENT.getErrorCode(), "权限不足！" );		}

	
	/**
	 * 生成工作人员表
	 * 			根据：game_name, college
	 * 			功能：下载某赛事所有比赛工作人员名单，包括赛事competition层面负责人/裁判长，
	 * 				 category层面副裁判长，event层面裁判员即记分员。
	 * @return 
	 * 
	 */
	@RequestMapping(value = "/smartgym/download/generateWorkerExcelsByCompetition", method = { RequestMethod.POST,
			RequestMethod.GET })
	@ResponseBody
	public SGResult generateWorkerExcelsByCompetition(String game_id, String user_wxid) throws IOException {
		if(StringUtils.isBlank(game_id) || user_wxid == null)
			return SGResult.build(ErrorCode.BAD_REQUEST.getErrorCode(), "比赛号和管理员微信不能为空！");
		Map<String, Object> adminMap = downloadService.getAdminLevelAndCollege(user_wxid);
		downloadService.generateWorkerExcelsByCompetition(game_id, adminMap);
		String filePath = downloadService.getExcelFilePath(game_id);
		return SGResult.ok("表格生成成功！", filePath);
	}
	

}
