package cn.smartGym.pojoCtr;

public class RemarkMessageCtr {

	
	private long remark_id;
	
    private String content;
    
    private String process_state;
    
    private String feedback;
    
    private String user_wxid;
    
    private String manager_wxid;
    
    
    

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getProcess_state() {
		return process_state;
	}

	public void setProcess_state(String process_state) {
		this.process_state = process_state;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public long getRemark_id() {
		return remark_id;
	}

	public void setRemark_id(long remark_id) {
		this.remark_id = remark_id;
	}

	public String getUser_wxid() {
		return user_wxid;
	}

	public void setUser_wxid(String user_wxid) {
		this.user_wxid = user_wxid;
	}

	public String getManager_wxid() {
		return manager_wxid;
	}

	public void setManager_wxid(String manager_wxid) {
		this.manager_wxid = manager_wxid;
	}

	
	
}
