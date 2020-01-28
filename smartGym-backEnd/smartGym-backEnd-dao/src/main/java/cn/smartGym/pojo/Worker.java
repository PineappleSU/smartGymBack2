package cn.smartGym.pojo;

public class Worker {
    private Long workerId;

    private String workerWxid;

    private String workerName;

    private String workerNo;

    private Integer workerType;

    private Integer workerLevel;

    private String workCompetition;

    private String workerCategory;

    private String workerEvent;

    private String workerEventId;

    public Long getWorkerId() {
        return workerId;
    }

    public void setWorkerId(Long workerId) {
        this.workerId = workerId;
    }

    public String getWorkerWxid() {
        return workerWxid;
    }

    public void setWorkerWxid(String workerWxid) {
        this.workerWxid = workerWxid == null ? null : workerWxid.trim();
    }

    public String getWorkerName() {
        return workerName;
    }

    public void setWorkerName(String workerName) {
        this.workerName = workerName == null ? null : workerName.trim();
    }

    public String getWorkerNo() {
        return workerNo;
    }

    public void setWorkerNo(String workerNo) {
        this.workerNo = workerNo == null ? null : workerNo.trim();
    }

    public Integer getWorkerType() {
        return workerType;
    }

    public void setWorkerType(Integer workerType) {
        this.workerType = workerType;
    }

    public Integer getWorkerLevel() {
        return workerLevel;
    }

    public void setWorkerLevel(Integer workerLevel) {
        this.workerLevel = workerLevel;
    }

    public String getWorkCompetition() {
        return workCompetition;
    }

    public void setWorkCompetition(String workCompetition) {
        this.workCompetition = workCompetition == null ? null : workCompetition.trim();
    }

    public String getWorkerCategory() {
        return workerCategory;
    }

    public void setWorkerCategory(String workerCategory) {
        this.workerCategory = workerCategory == null ? null : workerCategory.trim();
    }

    public String getWorkerEvent() {
        return workerEvent;
    }

    public void setWorkerEvent(String workerEvent) {
        this.workerEvent = workerEvent == null ? null : workerEvent.trim();
    }

    public String getWorkerEventId() {
        return workerEventId;
    }

    public void setWorkerEventId(String workerEventId) {
        this.workerEventId = workerEventId == null ? null : workerEventId.trim();
    }
}