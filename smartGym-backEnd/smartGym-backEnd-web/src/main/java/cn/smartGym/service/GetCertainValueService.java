package cn.smartGym.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

/** 
* @author Ma Shuaijie:
* 
* @version 创建时间：2020年1月11日 下午3:47:37 
*
* 根据每张表的主键获取每张表中需要的值
 * @param <K>
 * @param <V>
*/

public interface GetCertainValueService {

	Map<String, Object> getCertainValueOfCompetition(String id, String... Keys);

	Map<String, Object> getCertainValueOfCategory(String id, String... Keys);

	Map<String, Object> getCertainValueOfEvent(String id, String... Keys);

	List<Map<String, Object>> getCertainValueOfCategories(List<String> id,String...Keys);


	Map<String, Object> getCertainValueOfAppUser(Object studentNo, Object wxId, String... Keys);

	List<Map<String, Object>> getCertainValueOfEvents(List<String> id, String... Keys);

	List<Map<String, Object>> getCertainValueOfCompetitions(List<String> id, String... Keys);

}
