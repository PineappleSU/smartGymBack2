package cn.smartGym.pojo;

import java.util.Date;

public class AppUser {
    private Long userId;

    private String userName;

    private String wxId;

    private String studentNo;

    private Integer gender;

    private Integer campus;

    private Integer college;

    private String phone;

    private Integer status;

    private Integer type;

    private Integer userType;

    private String association;

    private String email;

    private Integer adminLevel;

    private Integer judgeLevel;

    private Date created;

    private Date updated;

    private String remarkMessage;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getWxId() {
        return wxId;
    }

    public void setWxId(String wxId) {
        this.wxId = wxId == null ? null : wxId.trim();
    }

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo == null ? null : studentNo.trim();
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getCampus() {
        return campus;
    }

    public void setCampus(Integer campus) {
        this.campus = campus;
    }

    public Integer getCollege() {
        return college;
    }

    public void setCollege(Integer college) {
        this.college = college;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public String getAssociation() {
        return association;
    }

    public void setAssociation(String association) {
        this.association = association == null ? null : association.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Integer getAdminLevel() {
        return adminLevel;
    }

    public void setAdminLevel(Integer adminLevel) {
        this.adminLevel = adminLevel;
    }

    public Integer getJudgeLevel() {
        return judgeLevel;
    }

    public void setJudgeLevel(Integer judgeLevel) {
        this.judgeLevel = judgeLevel;
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

    public String getRemarkMessage() {
        return remarkMessage;
    }

    public void setRemarkMessage(String remarkMessage) {
        this.remarkMessage = remarkMessage == null ? null : remarkMessage.trim();
    }
}