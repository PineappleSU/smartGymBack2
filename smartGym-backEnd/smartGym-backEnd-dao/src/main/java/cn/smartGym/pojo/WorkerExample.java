package cn.smartGym.pojo;

import java.util.ArrayList;
import java.util.List;

public class WorkerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WorkerExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andWorkerIdIsNull() {
            addCriterion("worker_id is null");
            return (Criteria) this;
        }

        public Criteria andWorkerIdIsNotNull() {
            addCriterion("worker_id is not null");
            return (Criteria) this;
        }

        public Criteria andWorkerIdEqualTo(Long value) {
            addCriterion("worker_id =", value, "workerId");
            return (Criteria) this;
        }

        public Criteria andWorkerIdNotEqualTo(Long value) {
            addCriterion("worker_id <>", value, "workerId");
            return (Criteria) this;
        }

        public Criteria andWorkerIdGreaterThan(Long value) {
            addCriterion("worker_id >", value, "workerId");
            return (Criteria) this;
        }

        public Criteria andWorkerIdGreaterThanOrEqualTo(Long value) {
            addCriterion("worker_id >=", value, "workerId");
            return (Criteria) this;
        }

        public Criteria andWorkerIdLessThan(Long value) {
            addCriterion("worker_id <", value, "workerId");
            return (Criteria) this;
        }

        public Criteria andWorkerIdLessThanOrEqualTo(Long value) {
            addCriterion("worker_id <=", value, "workerId");
            return (Criteria) this;
        }

        public Criteria andWorkerIdIn(List<Long> values) {
            addCriterion("worker_id in", values, "workerId");
            return (Criteria) this;
        }

        public Criteria andWorkerIdNotIn(List<Long> values) {
            addCriterion("worker_id not in", values, "workerId");
            return (Criteria) this;
        }

        public Criteria andWorkerIdBetween(Long value1, Long value2) {
            addCriterion("worker_id between", value1, value2, "workerId");
            return (Criteria) this;
        }

        public Criteria andWorkerIdNotBetween(Long value1, Long value2) {
            addCriterion("worker_id not between", value1, value2, "workerId");
            return (Criteria) this;
        }

        public Criteria andWorkerWxidIsNull() {
            addCriterion("worker_wxid is null");
            return (Criteria) this;
        }

        public Criteria andWorkerWxidIsNotNull() {
            addCriterion("worker_wxid is not null");
            return (Criteria) this;
        }

        public Criteria andWorkerWxidEqualTo(String value) {
            addCriterion("worker_wxid =", value, "workerWxid");
            return (Criteria) this;
        }

        public Criteria andWorkerWxidNotEqualTo(String value) {
            addCriterion("worker_wxid <>", value, "workerWxid");
            return (Criteria) this;
        }

        public Criteria andWorkerWxidGreaterThan(String value) {
            addCriterion("worker_wxid >", value, "workerWxid");
            return (Criteria) this;
        }

        public Criteria andWorkerWxidGreaterThanOrEqualTo(String value) {
            addCriterion("worker_wxid >=", value, "workerWxid");
            return (Criteria) this;
        }

        public Criteria andWorkerWxidLessThan(String value) {
            addCriterion("worker_wxid <", value, "workerWxid");
            return (Criteria) this;
        }

        public Criteria andWorkerWxidLessThanOrEqualTo(String value) {
            addCriterion("worker_wxid <=", value, "workerWxid");
            return (Criteria) this;
        }

        public Criteria andWorkerWxidLike(String value) {
            addCriterion("worker_wxid like", value, "workerWxid");
            return (Criteria) this;
        }

        public Criteria andWorkerWxidNotLike(String value) {
            addCriterion("worker_wxid not like", value, "workerWxid");
            return (Criteria) this;
        }

        public Criteria andWorkerWxidIn(List<String> values) {
            addCriterion("worker_wxid in", values, "workerWxid");
            return (Criteria) this;
        }

        public Criteria andWorkerWxidNotIn(List<String> values) {
            addCriterion("worker_wxid not in", values, "workerWxid");
            return (Criteria) this;
        }

        public Criteria andWorkerWxidBetween(String value1, String value2) {
            addCriterion("worker_wxid between", value1, value2, "workerWxid");
            return (Criteria) this;
        }

        public Criteria andWorkerWxidNotBetween(String value1, String value2) {
            addCriterion("worker_wxid not between", value1, value2, "workerWxid");
            return (Criteria) this;
        }

        public Criteria andWorkerNameIsNull() {
            addCriterion("worker_name is null");
            return (Criteria) this;
        }

        public Criteria andWorkerNameIsNotNull() {
            addCriterion("worker_name is not null");
            return (Criteria) this;
        }

        public Criteria andWorkerNameEqualTo(String value) {
            addCriterion("worker_name =", value, "workerName");
            return (Criteria) this;
        }

        public Criteria andWorkerNameNotEqualTo(String value) {
            addCriterion("worker_name <>", value, "workerName");
            return (Criteria) this;
        }

        public Criteria andWorkerNameGreaterThan(String value) {
            addCriterion("worker_name >", value, "workerName");
            return (Criteria) this;
        }

        public Criteria andWorkerNameGreaterThanOrEqualTo(String value) {
            addCriterion("worker_name >=", value, "workerName");
            return (Criteria) this;
        }

        public Criteria andWorkerNameLessThan(String value) {
            addCriterion("worker_name <", value, "workerName");
            return (Criteria) this;
        }

        public Criteria andWorkerNameLessThanOrEqualTo(String value) {
            addCriterion("worker_name <=", value, "workerName");
            return (Criteria) this;
        }

        public Criteria andWorkerNameLike(String value) {
            addCriterion("worker_name like", value, "workerName");
            return (Criteria) this;
        }

        public Criteria andWorkerNameNotLike(String value) {
            addCriterion("worker_name not like", value, "workerName");
            return (Criteria) this;
        }

        public Criteria andWorkerNameIn(List<String> values) {
            addCriterion("worker_name in", values, "workerName");
            return (Criteria) this;
        }

        public Criteria andWorkerNameNotIn(List<String> values) {
            addCriterion("worker_name not in", values, "workerName");
            return (Criteria) this;
        }

        public Criteria andWorkerNameBetween(String value1, String value2) {
            addCriterion("worker_name between", value1, value2, "workerName");
            return (Criteria) this;
        }

        public Criteria andWorkerNameNotBetween(String value1, String value2) {
            addCriterion("worker_name not between", value1, value2, "workerName");
            return (Criteria) this;
        }

        public Criteria andWorkerNoIsNull() {
            addCriterion("worker_no is null");
            return (Criteria) this;
        }

        public Criteria andWorkerNoIsNotNull() {
            addCriterion("worker_no is not null");
            return (Criteria) this;
        }

        public Criteria andWorkerNoEqualTo(String value) {
            addCriterion("worker_no =", value, "workerNo");
            return (Criteria) this;
        }

        public Criteria andWorkerNoNotEqualTo(String value) {
            addCriterion("worker_no <>", value, "workerNo");
            return (Criteria) this;
        }

        public Criteria andWorkerNoGreaterThan(String value) {
            addCriterion("worker_no >", value, "workerNo");
            return (Criteria) this;
        }

        public Criteria andWorkerNoGreaterThanOrEqualTo(String value) {
            addCriterion("worker_no >=", value, "workerNo");
            return (Criteria) this;
        }

        public Criteria andWorkerNoLessThan(String value) {
            addCriterion("worker_no <", value, "workerNo");
            return (Criteria) this;
        }

        public Criteria andWorkerNoLessThanOrEqualTo(String value) {
            addCriterion("worker_no <=", value, "workerNo");
            return (Criteria) this;
        }

        public Criteria andWorkerNoLike(String value) {
            addCriterion("worker_no like", value, "workerNo");
            return (Criteria) this;
        }

        public Criteria andWorkerNoNotLike(String value) {
            addCriterion("worker_no not like", value, "workerNo");
            return (Criteria) this;
        }

        public Criteria andWorkerNoIn(List<String> values) {
            addCriterion("worker_no in", values, "workerNo");
            return (Criteria) this;
        }

        public Criteria andWorkerNoNotIn(List<String> values) {
            addCriterion("worker_no not in", values, "workerNo");
            return (Criteria) this;
        }

        public Criteria andWorkerNoBetween(String value1, String value2) {
            addCriterion("worker_no between", value1, value2, "workerNo");
            return (Criteria) this;
        }

        public Criteria andWorkerNoNotBetween(String value1, String value2) {
            addCriterion("worker_no not between", value1, value2, "workerNo");
            return (Criteria) this;
        }

        public Criteria andWorkerTypeIsNull() {
            addCriterion("worker_type is null");
            return (Criteria) this;
        }

        public Criteria andWorkerTypeIsNotNull() {
            addCriterion("worker_type is not null");
            return (Criteria) this;
        }

        public Criteria andWorkerTypeEqualTo(Integer value) {
            addCriterion("worker_type =", value, "workerType");
            return (Criteria) this;
        }

        public Criteria andWorkerTypeNotEqualTo(Integer value) {
            addCriterion("worker_type <>", value, "workerType");
            return (Criteria) this;
        }

        public Criteria andWorkerTypeGreaterThan(Integer value) {
            addCriterion("worker_type >", value, "workerType");
            return (Criteria) this;
        }

        public Criteria andWorkerTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("worker_type >=", value, "workerType");
            return (Criteria) this;
        }

        public Criteria andWorkerTypeLessThan(Integer value) {
            addCriterion("worker_type <", value, "workerType");
            return (Criteria) this;
        }

        public Criteria andWorkerTypeLessThanOrEqualTo(Integer value) {
            addCriterion("worker_type <=", value, "workerType");
            return (Criteria) this;
        }

        public Criteria andWorkerTypeIn(List<Integer> values) {
            addCriterion("worker_type in", values, "workerType");
            return (Criteria) this;
        }

        public Criteria andWorkerTypeNotIn(List<Integer> values) {
            addCriterion("worker_type not in", values, "workerType");
            return (Criteria) this;
        }

        public Criteria andWorkerTypeBetween(Integer value1, Integer value2) {
            addCriterion("worker_type between", value1, value2, "workerType");
            return (Criteria) this;
        }

        public Criteria andWorkerTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("worker_type not between", value1, value2, "workerType");
            return (Criteria) this;
        }

        public Criteria andWorkerLevelIsNull() {
            addCriterion("worker_level is null");
            return (Criteria) this;
        }

        public Criteria andWorkerLevelIsNotNull() {
            addCriterion("worker_level is not null");
            return (Criteria) this;
        }

        public Criteria andWorkerLevelEqualTo(Integer value) {
            addCriterion("worker_level =", value, "workerLevel");
            return (Criteria) this;
        }

        public Criteria andWorkerLevelNotEqualTo(Integer value) {
            addCriterion("worker_level <>", value, "workerLevel");
            return (Criteria) this;
        }

        public Criteria andWorkerLevelGreaterThan(Integer value) {
            addCriterion("worker_level >", value, "workerLevel");
            return (Criteria) this;
        }

        public Criteria andWorkerLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("worker_level >=", value, "workerLevel");
            return (Criteria) this;
        }

        public Criteria andWorkerLevelLessThan(Integer value) {
            addCriterion("worker_level <", value, "workerLevel");
            return (Criteria) this;
        }

        public Criteria andWorkerLevelLessThanOrEqualTo(Integer value) {
            addCriterion("worker_level <=", value, "workerLevel");
            return (Criteria) this;
        }

        public Criteria andWorkerLevelIn(List<Integer> values) {
            addCriterion("worker_level in", values, "workerLevel");
            return (Criteria) this;
        }

        public Criteria andWorkerLevelNotIn(List<Integer> values) {
            addCriterion("worker_level not in", values, "workerLevel");
            return (Criteria) this;
        }

        public Criteria andWorkerLevelBetween(Integer value1, Integer value2) {
            addCriterion("worker_level between", value1, value2, "workerLevel");
            return (Criteria) this;
        }

        public Criteria andWorkerLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("worker_level not between", value1, value2, "workerLevel");
            return (Criteria) this;
        }

        public Criteria andWorkCompetitionIsNull() {
            addCriterion("work_competition is null");
            return (Criteria) this;
        }

        public Criteria andWorkCompetitionIsNotNull() {
            addCriterion("work_competition is not null");
            return (Criteria) this;
        }

        public Criteria andWorkCompetitionEqualTo(String value) {
            addCriterion("work_competition =", value, "workCompetition");
            return (Criteria) this;
        }

        public Criteria andWorkCompetitionNotEqualTo(String value) {
            addCriterion("work_competition <>", value, "workCompetition");
            return (Criteria) this;
        }

        public Criteria andWorkCompetitionGreaterThan(String value) {
            addCriterion("work_competition >", value, "workCompetition");
            return (Criteria) this;
        }

        public Criteria andWorkCompetitionGreaterThanOrEqualTo(String value) {
            addCriterion("work_competition >=", value, "workCompetition");
            return (Criteria) this;
        }

        public Criteria andWorkCompetitionLessThan(String value) {
            addCriterion("work_competition <", value, "workCompetition");
            return (Criteria) this;
        }

        public Criteria andWorkCompetitionLessThanOrEqualTo(String value) {
            addCriterion("work_competition <=", value, "workCompetition");
            return (Criteria) this;
        }

        public Criteria andWorkCompetitionLike(String value) {
            addCriterion("work_competition like", value, "workCompetition");
            return (Criteria) this;
        }

        public Criteria andWorkCompetitionNotLike(String value) {
            addCriterion("work_competition not like", value, "workCompetition");
            return (Criteria) this;
        }

        public Criteria andWorkCompetitionIn(List<String> values) {
            addCriterion("work_competition in", values, "workCompetition");
            return (Criteria) this;
        }

        public Criteria andWorkCompetitionNotIn(List<String> values) {
            addCriterion("work_competition not in", values, "workCompetition");
            return (Criteria) this;
        }

        public Criteria andWorkCompetitionBetween(String value1, String value2) {
            addCriterion("work_competition between", value1, value2, "workCompetition");
            return (Criteria) this;
        }

        public Criteria andWorkCompetitionNotBetween(String value1, String value2) {
            addCriterion("work_competition not between", value1, value2, "workCompetition");
            return (Criteria) this;
        }

        public Criteria andWorkerCategoryIsNull() {
            addCriterion("worker_category is null");
            return (Criteria) this;
        }

        public Criteria andWorkerCategoryIsNotNull() {
            addCriterion("worker_category is not null");
            return (Criteria) this;
        }

        public Criteria andWorkerCategoryEqualTo(String value) {
            addCriterion("worker_category =", value, "workerCategory");
            return (Criteria) this;
        }

        public Criteria andWorkerCategoryNotEqualTo(String value) {
            addCriterion("worker_category <>", value, "workerCategory");
            return (Criteria) this;
        }

        public Criteria andWorkerCategoryGreaterThan(String value) {
            addCriterion("worker_category >", value, "workerCategory");
            return (Criteria) this;
        }

        public Criteria andWorkerCategoryGreaterThanOrEqualTo(String value) {
            addCriterion("worker_category >=", value, "workerCategory");
            return (Criteria) this;
        }

        public Criteria andWorkerCategoryLessThan(String value) {
            addCriterion("worker_category <", value, "workerCategory");
            return (Criteria) this;
        }

        public Criteria andWorkerCategoryLessThanOrEqualTo(String value) {
            addCriterion("worker_category <=", value, "workerCategory");
            return (Criteria) this;
        }

        public Criteria andWorkerCategoryLike(String value) {
            addCriterion("worker_category like", value, "workerCategory");
            return (Criteria) this;
        }

        public Criteria andWorkerCategoryNotLike(String value) {
            addCriterion("worker_category not like", value, "workerCategory");
            return (Criteria) this;
        }

        public Criteria andWorkerCategoryIn(List<String> values) {
            addCriterion("worker_category in", values, "workerCategory");
            return (Criteria) this;
        }

        public Criteria andWorkerCategoryNotIn(List<String> values) {
            addCriterion("worker_category not in", values, "workerCategory");
            return (Criteria) this;
        }

        public Criteria andWorkerCategoryBetween(String value1, String value2) {
            addCriterion("worker_category between", value1, value2, "workerCategory");
            return (Criteria) this;
        }

        public Criteria andWorkerCategoryNotBetween(String value1, String value2) {
            addCriterion("worker_category not between", value1, value2, "workerCategory");
            return (Criteria) this;
        }

        public Criteria andWorkerEventIsNull() {
            addCriterion("worker_event is null");
            return (Criteria) this;
        }

        public Criteria andWorkerEventIsNotNull() {
            addCriterion("worker_event is not null");
            return (Criteria) this;
        }

        public Criteria andWorkerEventEqualTo(String value) {
            addCriterion("worker_event =", value, "workerEvent");
            return (Criteria) this;
        }

        public Criteria andWorkerEventNotEqualTo(String value) {
            addCriterion("worker_event <>", value, "workerEvent");
            return (Criteria) this;
        }

        public Criteria andWorkerEventGreaterThan(String value) {
            addCriterion("worker_event >", value, "workerEvent");
            return (Criteria) this;
        }

        public Criteria andWorkerEventGreaterThanOrEqualTo(String value) {
            addCriterion("worker_event >=", value, "workerEvent");
            return (Criteria) this;
        }

        public Criteria andWorkerEventLessThan(String value) {
            addCriterion("worker_event <", value, "workerEvent");
            return (Criteria) this;
        }

        public Criteria andWorkerEventLessThanOrEqualTo(String value) {
            addCriterion("worker_event <=", value, "workerEvent");
            return (Criteria) this;
        }

        public Criteria andWorkerEventLike(String value) {
            addCriterion("worker_event like", value, "workerEvent");
            return (Criteria) this;
        }

        public Criteria andWorkerEventNotLike(String value) {
            addCriterion("worker_event not like", value, "workerEvent");
            return (Criteria) this;
        }

        public Criteria andWorkerEventIn(List<String> values) {
            addCriterion("worker_event in", values, "workerEvent");
            return (Criteria) this;
        }

        public Criteria andWorkerEventNotIn(List<String> values) {
            addCriterion("worker_event not in", values, "workerEvent");
            return (Criteria) this;
        }

        public Criteria andWorkerEventBetween(String value1, String value2) {
            addCriterion("worker_event between", value1, value2, "workerEvent");
            return (Criteria) this;
        }

        public Criteria andWorkerEventNotBetween(String value1, String value2) {
            addCriterion("worker_event not between", value1, value2, "workerEvent");
            return (Criteria) this;
        }

        public Criteria andWorkerEventIdIsNull() {
            addCriterion("worker_event_id is null");
            return (Criteria) this;
        }

        public Criteria andWorkerEventIdIsNotNull() {
            addCriterion("worker_event_id is not null");
            return (Criteria) this;
        }

        public Criteria andWorkerEventIdEqualTo(String value) {
            addCriterion("worker_event_id =", value, "workerEventId");
            return (Criteria) this;
        }

        public Criteria andWorkerEventIdNotEqualTo(String value) {
            addCriterion("worker_event_id <>", value, "workerEventId");
            return (Criteria) this;
        }

        public Criteria andWorkerEventIdGreaterThan(String value) {
            addCriterion("worker_event_id >", value, "workerEventId");
            return (Criteria) this;
        }

        public Criteria andWorkerEventIdGreaterThanOrEqualTo(String value) {
            addCriterion("worker_event_id >=", value, "workerEventId");
            return (Criteria) this;
        }

        public Criteria andWorkerEventIdLessThan(String value) {
            addCriterion("worker_event_id <", value, "workerEventId");
            return (Criteria) this;
        }

        public Criteria andWorkerEventIdLessThanOrEqualTo(String value) {
            addCriterion("worker_event_id <=", value, "workerEventId");
            return (Criteria) this;
        }

        public Criteria andWorkerEventIdLike(String value) {
            addCriterion("worker_event_id like", value, "workerEventId");
            return (Criteria) this;
        }

        public Criteria andWorkerEventIdNotLike(String value) {
            addCriterion("worker_event_id not like", value, "workerEventId");
            return (Criteria) this;
        }

        public Criteria andWorkerEventIdIn(List<String> values) {
            addCriterion("worker_event_id in", values, "workerEventId");
            return (Criteria) this;
        }

        public Criteria andWorkerEventIdNotIn(List<String> values) {
            addCriterion("worker_event_id not in", values, "workerEventId");
            return (Criteria) this;
        }

        public Criteria andWorkerEventIdBetween(String value1, String value2) {
            addCriterion("worker_event_id between", value1, value2, "workerEventId");
            return (Criteria) this;
        }

        public Criteria andWorkerEventIdNotBetween(String value1, String value2) {
            addCriterion("worker_event_id not between", value1, value2, "workerEventId");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}