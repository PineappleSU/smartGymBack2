package cn.smartGym.service;

import cn.smartGym.pojo.RemarkMessage;
import cn.smartGym.pojoCtr.RemarkMessageCtr;
import common.utils.SGResult;

public interface RemarkMessageService {

	SGResult addRemark(RemarkMessage remarkMessage);

	SGResult showRemark(RemarkMessage remarkMessage);




	

}
