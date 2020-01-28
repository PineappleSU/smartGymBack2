package cn.smartGym.pojoCtr;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class NewsCtr {
	
	private Long news_id;

    private Integer news_type;

    private Integer status;

    private String title;

    private String summary;

    private String content;

    private String remark;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date created;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updated;

    private String author_wxid;

	public Long getNews_id() {
		return news_id;
	}

	public void setNews_id(Long news_id) {
		this.news_id = news_id;
	}

	public Integer getNews_type() {
		return news_type;
	}

	public void setNews_type(Integer news_type) {
		this.news_type = news_type;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public String getAuthor_wxid() {
		return author_wxid;
	}

	public void setAuthor_wxid(String author_wxid) {
		this.author_wxid = author_wxid;
	}
    
    


}
