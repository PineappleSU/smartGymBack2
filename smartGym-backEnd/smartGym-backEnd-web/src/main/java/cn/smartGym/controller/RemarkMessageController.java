package cn.smartGym.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.smartGym.pojoCtr.RemarkMessageCtr;
import cn.smartGym.service.RemarkMessageService;
import cn.smartGym.utils.ConversionUtils;
import common.utils.SGResult;

@Controller
public class RemarkMessageController {
	
	@Autowired
	RemarkMessageService remarkMessageService;
	
	/**
	 * 增加用户反馈
	 */
	@RequestMapping(value = "/smartgym/remark/addRemark", method = { RequestMethod.POST,
			RequestMethod.GET }, consumes = "application/x-www-form-urlencoded;charset=utf-8")
	@ResponseBody
	public SGResult addRemarkMessage(RemarkMessageCtr remarkMessageCtr) throws Exception {
		
		return remarkMessageService.addRemark(ConversionUtils.remarkMessageCtrToDao(remarkMessageCtr));
		
	}
	
	/**
	 * 显示用户反馈
	 */
	@RequestMapping(value = "/smartgym/remark/showRemark", method = { RequestMethod.POST,
			RequestMethod.GET }, consumes = "application/x-www-form-urlencoded;charset=utf-8")
	@ResponseBody
	public SGResult showRemark(RemarkMessageCtr remarkMessageCtr) throws Exception {
		
		return remarkMessageService.showRemark(ConversionUtils.remarkMessageCtrToDao(remarkMessageCtr));
	}

}
