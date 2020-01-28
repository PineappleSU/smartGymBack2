package cn.smartGym.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.smartGym.mapper.RemarkMessageMapper;
import cn.smartGym.pojo.RemarkMessage;
import cn.smartGym.pojo.RemarkMessageExample;
import cn.smartGym.pojo.RemarkMessageExample.Criteria;
import cn.smartGym.service.RemarkMessageService;
import cn.smartGym.utils.ConversionUtils;
import common.enums.ErrorCode;
import common.utils.IDUtils;
import common.utils.SGResult;

@Service
public class RemarkMessageServiceImpl implements RemarkMessageService{
	@Autowired
	private RemarkMessageMapper remarkMessageMapper;
	
	private HashMap<String, Integer> time = new HashMap<String, Integer>();
	private HashMap<String, Date> lastDates = new HashMap<String, Date>();

	
	/**
	 * 增加反馈
	 * 
	 */
	@Override
	public SGResult addRemark(RemarkMessage remarkMessage) {
		Date now = new Date();
		String wxId = remarkMessage.getUserWxid();

		if (wxId== null)
			return SGResult.build(ErrorCode.BAD_REQUEST.getErrorCode(), "不能匿名反馈！");
		// 判断该用户上次添加反馈时间，一天之内不能反馈超过三次

		if (time.get(wxId) != null) {
			Date lastDate = (Date) lastDates.get(wxId);
			long between = now.getTime() - lastDate.getTime();
			if (between > (24 * 3600000)) {
				time.put(wxId, 0);
			} else if (time.get(wxId) >= 3)
				return SGResult.build(ErrorCode.BAD_REQUEST.getErrorCode(), "一天内不能反馈超过3次！");
		}

		remarkMessage.setReamrkId(IDUtils.genId());;
		remarkMessage.setCreated(now);
		remarkMessage.setUpdated(now);
		remarkMessage.setRemarkProcessState(1);
		remarkMessageMapper.insert(remarkMessage);

		if (time.get(wxId) == null || time.get(wxId) == 0)
			time.put(wxId, 1);
		else
			time.put(wxId, time.get(wxId) + 1);
		lastDates.put(wxId, now);

		return SGResult.ok("添加反馈成功！");
		
	}
	
	/**
	 * 显示反馈内容
	 * 			- 0-所有反馈 1-未回复/未处理  2-已回复/已处理
	 */
	@Override
	public SGResult showRemark(RemarkMessage rm) {
		RemarkMessageExample example = new RemarkMessageExample();
		Criteria criteria = example.createCriteria();
		criteria.andUserWxidEqualTo(rm.getUserWxid());
		if(rm.getRemarkMessage()!= null)
			criteria.andRemarkMessageEqualTo(rm.getRemarkMessage());
		if(rm.getRemarkProcessState() != 0) 
			criteria.andRemarkProcessStateEqualTo(rm.getRemarkProcessState());
		List<RemarkMessage> rms = remarkMessageMapper.selectByExample(example); 
		
		return SGResult.ok("显示反馈信息成功！", ConversionUtils.remarkMessageDaoListToCtrList(rms));
	}

}
