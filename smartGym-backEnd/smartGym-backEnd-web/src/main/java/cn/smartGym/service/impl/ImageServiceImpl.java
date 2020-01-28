package cn.smartGym.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.smartGym.mapper.ImageMapper;
import cn.smartGym.pojo.Image;
import cn.smartGym.pojo.ImageExample;
import cn.smartGym.pojo.ImageExample.Criteria;
import cn.smartGym.service.ImageService;
import common.utils.IDUtils;

/** 
* @author Ma Shuaijie:
* 
* @version 创建时间：2019年10月26日 下午3:02:31 
*
* 图片服务实现层 
*/

@Service
public class ImageServiceImpl implements ImageService{
	@Autowired
	private ImageMapper imageMapper;
	
	@Override
	public List getImage(Long newsid){
		ImageExample example = new ImageExample();
		Criteria criteria = example.createCriteria();
		criteria.andNewsidEqualTo(newsid);
		criteria.andStatusEqualTo(1);
		List<Image> list = imageMapper.selectByExample(example);
		List<Map<String,Object>> listout = new ArrayList<Map<String,Object>>();
		for (Image image : list) {
			Map<String,Object> modelMap = new HashMap<String,Object>();
			modelMap.put("imageOrder", image.getImageorder());
			modelMap.put("url", image.getUrl());
			listout.add(modelMap);
		}			
		return listout;	
	}
	
	@Override
	public void addImage(Image image) {
		if(image.getType() == null)
			image.setType(0);
		image.setCreated(new Date());
		image.setUpdated(new Date());
		image.setId(IDUtils.genId());
		image.setStatus(1);
		if(image.getImagename() == null)
			image.setImagename(image.getUpdated()+"");
		imageMapper.insert(image);// 0删除，1正常
	}
}
