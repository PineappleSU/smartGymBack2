package cn.smartGym.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.smartGym.pojo.Image;
import cn.smartGym.pojo.News;
import cn.smartGym.service.ImageService;
import cn.smartGym.service.NewsService;
import cn.smartGym.utils.ConversionUtils;
import common.enums.ErrorCode;
import common.utils.SGResult;

/** 
* @author Ma Shuaijie:
* 
* @version 创建时间：2019年10月23日 下午4:43:51 
*
* 通知/新闻表现层
*/
@Controller
public class NewsController {
	@Autowired
	private NewsService newsService;
	@Autowired
	private ImageService imageService;
	
	/**
	 *  获取通知列表 
	 *  输入type 返回对应消息列表	0-全部	1-通知	2-新闻
	 */		
	@RequestMapping(value = "/smartgym/news/getNewsList", method = { RequestMethod.POST,
			RequestMethod.GET }, consumes = "application/x-www-form-urlencoded;charset=utf-8")
	@ResponseBody
	public SGResult getNewsByType(int type) {
		List listout = newsService.getNewsByType(type);
		if (listout == null || listout.size() == 0)
			return SGResult.build(ErrorCode.BAD_REQUEST.getErrorCode(), "暂时没有新通知！");
		return SGResult.ok("查找成功！", ConversionUtils.newsDaoListToCtrList(listout));		
	}
	
	/**
	 *  根据消息id获取消息详情
	 *  输入newsid 返回对应news的详细信息
	 */		
	@RequestMapping(value = "/smartgym/news/getNewsById", method = { RequestMethod.POST,
			RequestMethod.GET }, consumes = "application/x-www-form-urlencoded;charset=utf-8")
	@ResponseBody
	public SGResult getNewsById(Long news_id) {
		List text = newsService.getNewsById(news_id);
		List image = imageService.getImage(news_id);
		Map<String,Object> MapOut = new HashMap<String,Object>();
		MapOut.put("text", text);
		MapOut.put("image", image);
		if (text == null || text.size() == 0)
			return SGResult.build(ErrorCode.BAD_REQUEST.getErrorCode(), "找不到该资源！");		
		return SGResult.ok("查找成功！", MapOut);
	}
	
	/**
	 *  添加消息
	 *  输入要添加的消息，content不能为空，返回操作状态
	 *  newsid，newstype，title，summary，content，remark
	 */	
	@RequestMapping(value = "/smartgym/news/addNews", method = { RequestMethod.POST,
			RequestMethod.GET },consumes = "application/x-www-form-urlencoded;charset=utf-8")
//	@RequestMapping(value = "/smartgym/news/addNews", method = { RequestMethod.POST,
//			RequestMethod.GET },headers = "content-type=multipart/form-data")
//	@RequestMapping(value = "/smartgym/news/addNews", method = { RequestMethod.POST,
//			RequestMethod.GET }, consumes = "multipart/form-data;charset=utf-8")
	@ResponseBody
//	public SGResult addNews(News news,Image image,@RequestParam MultipartFile[] files) {
	public SGResult addNews(News news) {
//		System.out.println("files:"+files[0]);
//		System.out.println("files:"+files[1]);
//		System.out.println(files.length);
//		image.setId(newsid);
//		imageService.addImage(image);
		
		if(news.getNewsType() !=1 || news.getNewsType() !=2)
			//默认消息类型为通知
			news.setNewsType(1);
		Long newsid = newsService.addNews(news);
		return SGResult.ok("增加消息成功！");
	}
	
	/**
	 *  编辑消息（软删除，修改）
	 *  输入编辑类型（0-修改	1-删除），并附带对应的newsid或news
	 *  newsid（必须），newstype，title，summary，content，remark
	 */	
	@RequestMapping(value = "/smartgym/news/editNews", method = { RequestMethod.POST,
			RequestMethod.GET }, consumes = "application/x-www-form-urlencoded;charset=utf-8")
	@ResponseBody
	public SGResult editNews(int edit_type,News news) {
		if(edit_type == 0)
			return newsService.reviseNews(news);
		else if (edit_type ==1){
			Long newsId = news.getNewsId();
			return newsService.deleteNews(newsId);}
		else 
			return SGResult.build(ErrorCode.BAD_REQUEST.getErrorCode(), "参数无效！");
	}
}
