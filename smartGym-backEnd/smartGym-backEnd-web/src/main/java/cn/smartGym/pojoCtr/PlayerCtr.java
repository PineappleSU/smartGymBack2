package cn.smartGym.pojoCtr;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class PlayerCtr implements Serializable {

	private static final long serialVersionUID = -1254682028835756571L;

	private Long id;

	private String name;

	private String college;

	private String student_no;

	private String item_id;

	private String game_name;

	private String category_name;

	private String item_name;

	private String job;

	private String player_no;

	private String gender;

	private Integer group_no;

	private Integer path_no;

	private String grades;

	private String final_grades;

	private Integer rank_no;

	private Integer status;
	
	private Integer item_process_type;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date item_time;
	
	private String game_place;
	
	private String game_description;
	
	private String captain_wxid;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public String getStudent_no() {
		return student_no;
	}

	public void setStudent_no(String student_no) {
		this.student_no = student_no;
	}

	public String getItem_id() {
		return item_id;
	}

	public void setItem_id(String item_id) {
		this.item_id = item_id;
	}

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

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getPlayer_no() {
		return player_no;
	}

	public void setPlayer_no(String player_no) {
		this.player_no = player_no;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getGroup_no() {
		return group_no;
	}

	public void setGroup_no(Integer group_no) {
		this.group_no = group_no;
	}

	public Integer getPath_no() {
		return path_no;
	}

	public void setPath_no(Integer path_no) {
		this.path_no = path_no;
	}

	public String getGrades() {
		return grades;
	}

	public void setGrades(String grades) {
		this.grades = grades;
	}

	public String getFinal_grades() {
		return final_grades;
	}

	public void setFinal_grades(String final_grades) {
		this.final_grades = final_grades;
	}

	public Integer getRank_no() {
		return rank_no;
	}

	public void setRank_no(Integer rank_no) {
		this.rank_no = rank_no;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getItem_process_type() {
		return item_process_type;
	}

	public void setItem_process_type(Integer item_process_type) {
		this.item_process_type = item_process_type;
	}

	public Date getItem_time() {
		return item_time;
	}

	public void setItem_time(Date item_time) {
		this.item_time = item_time;
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

	public String getCaptain_wxid() {
		return captain_wxid;
	}

	public void setCaptain_wxid(String captain_wxid) {
		this.captain_wxid = captain_wxid;
	}

	

}