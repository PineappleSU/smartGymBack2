package cn.smartGym.pojo;

import java.util.Date;

public class Event {
    private String eventId;

    private String competitionId;

    private String competitionName;

    private String categoryId;

    private String categoryName;

    private String eventName;

    private Integer eventLevel;

    private String eventPlace;

    private Integer eventGender;

    private Integer eventType;

    private Integer peopleNum;

    private Integer rankCriterion;

    private String eventDescription;

    private Integer status;

    private String judgeWxid;

    private String competitionDescription;

    private String categoryDescription;

    private Date created;

    private Date updated;

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId == null ? null : eventId.trim();
    }

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

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId == null ? null : categoryId.trim();
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName == null ? null : categoryName.trim();
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName == null ? null : eventName.trim();
    }

    public Integer getEventLevel() {
        return eventLevel;
    }

    public void setEventLevel(Integer eventLevel) {
        this.eventLevel = eventLevel;
    }

    public String getEventPlace() {
        return eventPlace;
    }

    public void setEventPlace(String eventPlace) {
        this.eventPlace = eventPlace == null ? null : eventPlace.trim();
    }

    public Integer getEventGender() {
        return eventGender;
    }

    public void setEventGender(Integer eventGender) {
        this.eventGender = eventGender;
    }

    public Integer getEventType() {
        return eventType;
    }

    public void setEventType(Integer eventType) {
        this.eventType = eventType;
    }

    public Integer getPeopleNum() {
        return peopleNum;
    }

    public void setPeopleNum(Integer peopleNum) {
        this.peopleNum = peopleNum;
    }

    public Integer getRankCriterion() {
        return rankCriterion;
    }

    public void setRankCriterion(Integer rankCriterion) {
        this.rankCriterion = rankCriterion;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription == null ? null : eventDescription.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getJudgeWxid() {
        return judgeWxid;
    }

    public void setJudgeWxid(String judgeWxid) {
        this.judgeWxid = judgeWxid == null ? null : judgeWxid.trim();
    }

    public String getCompetitionDescription() {
        return competitionDescription;
    }

    public void setCompetitionDescription(String competitionDescription) {
        this.competitionDescription = competitionDescription == null ? null : competitionDescription.trim();
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription == null ? null : categoryDescription.trim();
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
}