package cn.smartGym.pojo;

import java.util.Date;

public class Competition {
    private String competitionId;

    private String competitionName;

    private Integer competitionType1;

    private Integer competitionType2;

    private String department;

    private String principalWxid;

    private String judgeHeaderWxid;

    private Date applyStartTime;

    private Date applyCheckTime;

    private Date checkEndTime;

    private Date competitionStartTime;

    private Date competitionEndTime;

    private String competitionPlace;

    private String competitionDescription;

    private Integer year;

    private Integer status;

    private Integer searchType;

    public String getCompetitionId() {
        return competitionId;
    }

    public void setCompetitionId(String competitionId) {
        this.competitionId = competitionId == null ? null : competitionId.trim();
    }

    public String getCompetitionName() {
        return competitionName;
    }

    public void setCompetitionName(String competitionName) {
        this.competitionName = competitionName == null ? null : competitionName.trim();
    }

    public Integer getCompetitionType1() {
        return competitionType1;
    }

    public void setCompetitionType1(Integer competitionType1) {
        this.competitionType1 = competitionType1;
    }

    public Integer getCompetitionType2() {
        return competitionType2;
    }

    public void setCompetitionType2(Integer competitionType2) {
        this.competitionType2 = competitionType2;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department == null ? null : department.trim();
    }

    public String getPrincipalWxid() {
        return principalWxid;
    }

    public void setPrincipalWxid(String principalWxid) {
        this.principalWxid = principalWxid == null ? null : principalWxid.trim();
    }

    public String getJudgeHeaderWxid() {
        return judgeHeaderWxid;
    }

    public void setJudgeHeaderWxid(String judgeHeaderWxid) {
        this.judgeHeaderWxid = judgeHeaderWxid == null ? null : judgeHeaderWxid.trim();
    }

    public Date getApplyStartTime() {
        return applyStartTime;
    }

    public void setApplyStartTime(Date applyStartTime) {
        this.applyStartTime = applyStartTime;
    }

    public Date getApplyCheckTime() {
        return applyCheckTime;
    }

    public void setApplyCheckTime(Date applyCheckTime) {
        this.applyCheckTime = applyCheckTime;
    }

    public Date getCheckEndTime() {
        return checkEndTime;
    }

    public void setCheckEndTime(Date checkEndTime) {
        this.checkEndTime = checkEndTime;
    }

    public Date getCompetitionStartTime() {
        return competitionStartTime;
    }

    public void setCompetitionStartTime(Date competitionStartTime) {
        this.competitionStartTime = competitionStartTime;
    }

    public Date getCompetitionEndTime() {
        return competitionEndTime;
    }

    public void setCompetitionEndTime(Date competitionEndTime) {
        this.competitionEndTime = competitionEndTime;
    }

    public String getCompetitionPlace() {
        return competitionPlace;
    }

    public void setCompetitionPlace(String competitionPlace) {
        this.competitionPlace = competitionPlace == null ? null : competitionPlace.trim();
    }

    public String getCompetitionDescription() {
        return competitionDescription;
    }

    public void setCompetitionDescription(String competitionDescription) {
        this.competitionDescription = competitionDescription == null ? null : competitionDescription.trim();
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getSearchType() {
        return searchType;
    }

    public void setSearchType(Integer searchType) {
        this.searchType = searchType;
    }
}