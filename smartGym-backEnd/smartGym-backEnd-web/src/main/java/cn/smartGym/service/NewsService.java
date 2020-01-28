package cn.smartGym.service;

import java.util.List;

import cn.smartGym.pojo.News;
import common.utils.SGResult;

/** 
* @author Ma Shuaijie:
* 
* @version 创建时间：2019年10月23日 下午4:46:07 
*
* 通知/新闻服务层
*/

public interface NewsService {
	List getNewsByType(int type);

	List getNewsById(Long newsId);

	Long addNews(News news);

	SGResult deleteNews(Long newsid);

	SGResult reviseNews(News news);
}
