package cn.smartGym.service;

import java.util.List;

import cn.smartGym.pojo.Image;
import common.utils.SGResult;

/** 
* @author Ma Shuaijie:
* 
* @version 创建时间：2019年10月26日 下午2:30:26 
*
* 图片服务层
*/

public interface ImageService {
	
	List getImage(Long newsid);
	
	void addImage(Image image);
	
//	SGResult deleteImage(Long newsid,int[] imageOrder);

}
