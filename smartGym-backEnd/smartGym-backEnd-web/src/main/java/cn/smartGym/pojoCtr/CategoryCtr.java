package cn.smartGym.pojoCtr;

/** 
* @author Ma Shuaijie:
* 
* @version 创建时间：2019年11月18日 下午3:19:24 
*
* 实体类，用于接收与回传 
*/

public class CategoryCtr {
	private static final long serialVersionUID = 1786323146286067760L;
	
	private String game_id;
	
	private String game_name;
	
	private String category_id;
	
	private String category_name;
	
	private String category_description;
	
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
	public String getJudge_wxid() {
		return judge_wxid;
	}
	public void setJudge_wxid(String judge_wxid) {
		this.judge_wxid = judge_wxid;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
		
}
