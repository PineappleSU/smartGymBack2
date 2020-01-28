package cn.smartGym.znoUse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import common.utils.SGResult;

@Controller
public class PictureController {

	@Autowired
	private PictureService pictureService;
	
	@RequestMapping(value = "/smartgym/pirture/getPictureUrl", method = { RequestMethod.POST,
			RequestMethod.GET }, consumes = "application/x-www-form-urlencoded;charset=utf-8")
	@ResponseBody
	public SGResult getPictureUrl(Integer type) {
		return pictureService.getPictureUrl(type);
	}
}
