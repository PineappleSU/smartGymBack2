package cn.smartGym.pojo;

import java.util.Date;

public class RemarkMessage {
    private Long reamrkId;

    private String userWxid;

    private String remarkMessage;

    private String feedback;

    private Integer remarkProcessState;

    private Date created;

    private Date updated;

    private String managerWxid;

    public Long getReamrkId() {
        return reamrkId;
    }

    public void setReamrkId(Long reamrkId) {
        this.reamrkId = reamrkId;
    }

    public String getUserWxid() {
        return userWxid;
    }

    public void setUserWxid(String userWxid) {
        this.userWxid = userWxid == null ? null : userWxid.trim();
    }

    public String getRemarkMessage() {
        return remarkMessage;
    }

    public void setRemarkMessage(String remarkMessage) {
        this.remarkMessage = remarkMessage == null ? null : remarkMessage.trim();
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback == null ? null : feedback.trim();
    }

    public Integer getRemarkProcessState() {
        return remarkProcessState;
    }

    public void setRemarkProcessState(Integer remarkProcessState) {
        this.remarkProcessState = remarkProcessState;
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

    public String getManagerWxid() {
        return managerWxid;
    }

    public void setManagerWxid(String managerWxid) {
        this.managerWxid = managerWxid == null ? null : managerWxid.trim();
    }
}