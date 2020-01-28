package cn.smartGym.pojoCtr;

public class GameApplicationCtr {
	
private long id;
	
	private String name;
	
	private String user_wxid;
	
	private String player_wxid;
	
	private String captain_wxid;

	private String college;

	private String job;

	private String gender;

	private String student_no;

	private String game_id;		//competitionID
	
	private String category_id;	
	
	private String item_id;	//eventID
	
	private String item_name;

	private Integer status;
	
	private Integer checked;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUser_wxid() {
		return user_wxid;
	}

	public void setUser_wxid(String user_wxid) {
		this.user_wxid = user_wxid;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getStudent_no() {
		return student_no;
	}

	public void setStudent_no(String student_no) {
		this.student_no = student_no;
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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getChecked() {
		return checked;
	}

	public void setChecked(Integer checked) {
		this.checked = checked;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public String getPlayer_wxid() {
		return player_wxid;
	}

	public void setPlayer_wxid(String player_wxid) {
		this.player_wxid = player_wxid;
	}

	public String getCaptain_wxid() {
		return captain_wxid;
	}

	public void setCaptain_wxid(String captain_wxid) {
		this.captain_wxid = captain_wxid;
	}
	
	

}
