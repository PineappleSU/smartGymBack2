package cn.smartGym.pojoCtr;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/** 
* @author Ma Shuaijie:
* 
* @version 创建时间：2019年11月18日 下午2:13:10 
*
*实体类，用于接收与回传 
*/

public class CompetitionCtr {
	private static final long serialVersionUID = -7957559496821484853L;
	
	private String game_id;
	
	private String game_name;
	
	private String game_type;
	
	private Integer game_type2;
	
	private String department;
	
	private String principal_wxid;
	
	private String judge_header_wxid;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date apply_start_time;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date apply_check_time;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date check_end_time;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date game_start_time;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date game_end_time; 
	
	private String game_place;
	
	private String game_description;
	
	private Integer search_type;
	
	
	
//	public CompetitionCtr(String gameID, String game_name, Integer game_type1, Integer game_type2, String department,
//			String principal_WxId, String judge_header_WxId, Date apply_start_time, Date apply_check_time,
//			Date check_end_time, Date game_start_time, Date game_end_time, String game_place, String game_description) {
//		super();
//		this.gameID = gameID;
//		this.game_name = game_name;
//		this.game_type1 = game_type1;
//		this.game_type2 = game_type2;
//		this.department = department;
//		this.principal_WxId = principal_WxId;
//		this.judge_header_WxId = judge_header_WxId;
//		this.apply_start_time = apply_start_time;
//		this.apply_check_time = apply_check_time;
//		this.check_end_time = check_end_time;
//		this.game_start_time = game_start_time;
//		this.game_end_time = game_end_time;
//		this.game_place = game_place;
//		this.game_description = game_description;
//	}



	public String getGame_name() {
		return game_name;
	}

	public void setGame_name(String game_name) {
		this.game_name = game_name;
	}


	public String getGame_type() {
		return game_type;
	}

	public void setGame_type(String string) {
		this.game_type = string;
	}

	public Integer getGame_type2() {
		return game_type2;
	}

	public void setGame_type2(Integer game_type2) {
		this.game_type2 = game_type2;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Date getApply_start_time() {
		return apply_start_time;
	}

	public void setApply_start_time(Date apply_start_time) {
		this.apply_start_time = apply_start_time;
	}

	public Date getApply_check_time() {
		return apply_check_time;
	}

	public void setApply_check_time(Date apply_check_time) {
		this.apply_check_time = apply_check_time;
	}

	public Date getCheck_end_time() {
		return check_end_time;
	}

	public void setCheck_end_time(Date check_end_time) {
		this.check_end_time = check_end_time;
	}

	public Date getGame_start_time() {
		return game_start_time;
	}

	public void setGame_start_time(Date game_start_time) {
		this.game_start_time = game_start_time;
	}

	public Date getGame_end_time() {
		return game_end_time;
	}

	public void setGame_end_time(Date game_end_time) {
		this.game_end_time = game_end_time;
	}

	public String getGame_place() {
		return game_place;
	}

	public void setGame_place(String game_place) {
		this.game_place = game_place;
	}

	public String getGame_description() {
		return game_description;
	}

	public void setGame_description(String game_description) {
		this.game_description = game_description;
	}

	public String getGame_id() {
		return game_id;
	}

	public void setGame_id(String game_id) {
		this.game_id = game_id;
	}

	public String getPrincipal_wxid() {
		return principal_wxid;
	}

	public void setPrincipal_wxid(String principal_wxid) {
		this.principal_wxid = principal_wxid;
	}

	public String getJudge_header_wxid() {
		return judge_header_wxid;
	}

	public void setJudge_header_wxid(String judge_header_wxid) {
		this.judge_header_wxid = judge_header_wxid;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getSearch_type() {
		return search_type;
	}

	public void setSearch_type(Integer integer) {
		this.search_type = integer;
	}
	
	
	
}
