package cn.smartGym.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.smartGym.mapper.NewsMapper;
import cn.smartGym.pojo.Information;
import cn.smartGym.pojo.News;
import cn.smartGym.pojo.NewsExample;
import cn.smartGym.pojo.NewsExample.Criteria;
import cn.smartGym.service.NewsService;
import common.enums.ErrorCode;
import common.utils.IDUtils;
import common.utils.SGResult;

/** 
* @author Ma Shuaijie:
* 
* @version 创建时间：2019年10月23日 下午4:46:54 
*
* 通知/新闻服务实现层
*/
@Service
public class NewsServiceImpl implements NewsService{
	@Autowired
	private NewsMapper newsMapper;
	
	/**
	 * 根据消息类型返回消息列表：0-通知+新闻，1-通知，2-新闻 注意：不把消息正文（content)和备注（remark）返回
	 * 实际上返回的是null
	 */
	@Override
	public List getNewsByType(int type){
		NewsExample example = new NewsExample();
		Criteria criteria = example.createCriteria();
		if (type != 0)
			criteria.andNewsTypeEqualTo(type);
		criteria.andStatusEqualTo(1);
		List<News> list = newsMapper.selectByExample(example);		
		for (News news : list) {
			news.setContent(null);
			news.setRemark(null);
			news.setNewsType(type);
		}
		return list;
	}
	
	/**
	 * 根据消息的ID返回对应的消息详情
	 */
	@Override
	public List getNewsById(Long newsId){
		NewsExample example = new NewsExample();
		Criteria criteria = example.createCriteria();
		criteria.andNewsIdEqualTo(newsId);
		criteria.andStatusEqualTo(1);
		List<News> listout = newsMapper.selectByExample(example);
		return listout;
	}
	
	/**
	 * 新增消息
	 */
	@Override
	public Long addNews(News news) {
		if(news.getNewsType() == null)
			//默认消息类型为通知
			news.setNewsType(1);
		news.setNewsId(IDUtils.genId());
		news.setStatus(1);// 0删除，1正常
		news.setCreated(new Date());
		news.setUpdated(new Date());
		newsMapper.insert(news);
		return news.getNewsId();
	}
	
	/**
	 * 编辑消息，前端edit_type： 0-修改 1-删除
	 */
	
	/**
	 * 修改消息
	 */
	@Override
	public SGResult reviseNews(News news) {
		Long newsId = news.getNewsId();
		NewsExample example = new NewsExample();
		Criteria criteria = example.createCriteria();
		criteria.andNewsIdEqualTo(newsId);
		criteria.andStatusEqualTo(1);
		List<News> list = newsMapper.selectByExample(example);
		if(list == null || list.size() == 0)
			return SGResult.build(ErrorCode.NO_CONTENT.getErrorCode(), "找不到该资源！");
		news.setUpdated(new Date());
		newsMapper.updateByPrimaryKeySelective(news);
		return SGResult.build(ErrorCode.SUCCESS.getErrorCode(), "修改成功！");
	}
	/**
	 * 删除消息
	 */
	public SGResult deleteNews(Long newsid) {
		NewsExample example = new NewsExample();
		Criteria criteria = example.createCriteria();
		criteria.andNewsIdEqualTo(newsid);
		criteria.andStatusEqualTo(1);
		List<News> list = newsMapper.selectByExample(example);
		if(list == null || list.size() == 0)
			return SGResult.build(ErrorCode.NO_CONTENT.getErrorCode(), "找不到该资源！");
		News news = list.get(0);
		news.setStatus(0);
		news.setUpdated(new Date());
		newsMapper.updateByPrimaryKeySelective(news);
		return SGResult.build(ErrorCode.SUCCESS.getErrorCode(), "删除成功！");

	}
}
