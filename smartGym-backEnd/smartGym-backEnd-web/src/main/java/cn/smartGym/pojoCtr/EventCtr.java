package cn.smartGym.pojoCtr;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/** 
* @author Ma Shuaijie:
* 
* @version 创建时间：2019年11月18日 下午3:37:00 
*
* 实体类，用于接收与回传
*/

public class EventCtr {
	private String game_id;
	
	private String game_name;
	
	private String category_id;
	
	private String category_name;
	
	private String item_id;
	
	private String item_name;
	
	private Integer item_level;
	
	private String item_place;
	
	private Integer gender;
	
	private Integer item_type;
	
	private Integer path_num;
	
	private Integer rank_criterion;
	
	private String game_description;
	
	private String category_description;
	
	private String item_description;

	private String judge_wxid;

	public String getGame_name() {
		return game_name;
	}

	public void setGame_name(String game_name) {
		this.game_name = game_name;
	}

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public Integer getItem_level() {
		return item_level;
	}

	public void setItem_level(Integer item_level) {
		this.item_level = item_level;
	}

	public String getItem_place() {
		return item_place;
	}

	public void setItem_place(String item_place) {
		this.item_place = item_place;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public Integer getItem_type() {
		return item_type;
	}

	public void setItem_type(Integer item_type) {
		this.item_type = item_type;
	}

	public Integer getRank_criterion() {
		return rank_criterion;
	}

	public void setRank_criterion(Integer rank_criterion) {
		this.rank_criterion = rank_criterion;
	}

	public String getItem_description() {
		return item_description;
	}

	public void setItem_description(String item_description) {
		this.item_description = item_description;
	}

	public String getGame_description() {
		return game_description;
	}

	public void setGame_description(String game_description) {
		this.game_description = game_description;
	}

	public String getCategory_description() {
		return category_description;
	}

	public void setCategory_description(String category_description) {
		this.category_description = category_description;
	}

	public String getGame_id() {
		return game_id;
	}

	public void setGame_id(String game_id) {
		this.game_id = game_id;
	}

	public String getCategory_id() {
		return category_id;
	}

	public void setCategory_id(String category_id) {
		this.category_id = category_id;
	}

	public String getItem_id() {
		return item_id;
	}

	public void setItem_id(String item_id) {
		this.item_id = item_id;
	}

	public Integer getPath_num() {
		return path_num;
	}

	public void setPath_num(Integer path_num) {
		this.path_num = path_num;
	}

	public String getJudge_wxid() {
		return judge_wxid;
	}

	public void setJudge_wxid(String judge_wxid) {
		this.judge_wxid = judge_wxid;
	}
	
}
