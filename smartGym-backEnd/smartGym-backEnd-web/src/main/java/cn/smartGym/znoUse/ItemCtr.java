package cn.smartGym.znoUse;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ItemCtr implements Serializable {

	private static final long serialVersionUID = 6605952592376124670L;

	private Long id;

	private String game;

	private String category;

	private String item;

	private String gender;

	private Integer path_num;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date date;

	private String place;

	private Integer participant_num;

	private Integer status;

	private String description;
	
	private String type;
	
	private Long type_id;
	
	private Integer rank_criterion;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getGame() {
		return game;
	}

	public void setGame(String game) {
		this.game = game;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public ItemCtr() {
		super();
	}

	public Integer getPath_num() {
		return path_num;
	}

	public void setPath_num(Integer path_num) {
		this.path_num = path_num;
	}

	public Integer getParticipant_num() {
		return participant_num;
	}

	public void setParticipant_num(Integer participant_num) {
		this.participant_num = participant_num;
	}

	public Long getType_id() {
		return type_id;
	}

	public void setType_id(Long type_id) {
		this.type_id = type_id;
	}

	public Integer getRank_criterion() {
		return rank_criterion;
	}

	public void setRank_criterion(Integer rank_criterion) {
		this.rank_criterion = rank_criterion;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
