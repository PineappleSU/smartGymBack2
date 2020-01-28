package cn.smartGym.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RemarkMessageExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RemarkMessageExample() {
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

        public Criteria andReamrkIdIsNull() {
            addCriterion("reamrk_id is null");
            return (Criteria) this;
        }

        public Criteria andReamrkIdIsNotNull() {
            addCriterion("reamrk_id is not null");
            return (Criteria) this;
        }

        public Criteria andReamrkIdEqualTo(Long value) {
            addCriterion("reamrk_id =", value, "reamrkId");
            return (Criteria) this;
        }

        public Criteria andReamrkIdNotEqualTo(Long value) {
            addCriterion("reamrk_id <>", value, "reamrkId");
            return (Criteria) this;
        }

        public Criteria andReamrkIdGreaterThan(Long value) {
            addCriterion("reamrk_id >", value, "reamrkId");
            return (Criteria) this;
        }

        public Criteria andReamrkIdGreaterThanOrEqualTo(Long value) {
            addCriterion("reamrk_id >=", value, "reamrkId");
            return (Criteria) this;
        }

        public Criteria andReamrkIdLessThan(Long value) {
            addCriterion("reamrk_id <", value, "reamrkId");
            return (Criteria) this;
        }

        public Criteria andReamrkIdLessThanOrEqualTo(Long value) {
            addCriterion("reamrk_id <=", value, "reamrkId");
            return (Criteria) this;
        }

        public Criteria andReamrkIdIn(List<Long> values) {
            addCriterion("reamrk_id in", values, "reamrkId");
            return (Criteria) this;
        }

        public Criteria andReamrkIdNotIn(List<Long> values) {
            addCriterion("reamrk_id not in", values, "reamrkId");
            return (Criteria) this;
        }

        public Criteria andReamrkIdBetween(Long value1, Long value2) {
            addCriterion("reamrk_id between", value1, value2, "reamrkId");
            return (Criteria) this;
        }

        public Criteria andReamrkIdNotBetween(Long value1, Long value2) {
            addCriterion("reamrk_id not between", value1, value2, "reamrkId");
            return (Criteria) this;
        }

        public Criteria andUserWxidIsNull() {
            addCriterion("user_wxid is null");
            return (Criteria) this;
        }

        public Criteria andUserWxidIsNotNull() {
            addCriterion("user_wxid is not null");
            return (Criteria) this;
        }

        public Criteria andUserWxidEqualTo(String value) {
            addCriterion("user_wxid =", value, "userWxid");
            return (Criteria) this;
        }

        public Criteria andUserWxidNotEqualTo(String value) {
            addCriterion("user_wxid <>", value, "userWxid");
            return (Criteria) this;
        }

        public Criteria andUserWxidGreaterThan(String value) {
            addCriterion("user_wxid >", value, "userWxid");
            return (Criteria) this;
        }

        public Criteria andUserWxidGreaterThanOrEqualTo(String value) {
            addCriterion("user_wxid >=", value, "userWxid");
            return (Criteria) this;
        }

        public Criteria andUserWxidLessThan(String value) {
            addCriterion("user_wxid <", value, "userWxid");
            return (Criteria) this;
        }

        public Criteria andUserWxidLessThanOrEqualTo(String value) {
            addCriterion("user_wxid <=", value, "userWxid");
            return (Criteria) this;
        }

        public Criteria andUserWxidLike(String value) {
            addCriterion("user_wxid like", value, "userWxid");
            return (Criteria) this;
        }

        public Criteria andUserWxidNotLike(String value) {
            addCriterion("user_wxid not like", value, "userWxid");
            return (Criteria) this;
        }

        public Criteria andUserWxidIn(List<String> values) {
            addCriterion("user_wxid in", values, "userWxid");
            return (Criteria) this;
        }

        public Criteria andUserWxidNotIn(List<String> values) {
            addCriterion("user_wxid not in", values, "userWxid");
            return (Criteria) this;
        }

        public Criteria andUserWxidBetween(String value1, String value2) {
            addCriterion("user_wxid between", value1, value2, "userWxid");
            return (Criteria) this;
        }

        public Criteria andUserWxidNotBetween(String value1, String value2) {
            addCriterion("user_wxid not between", value1, value2, "userWxid");
            return (Criteria) this;
        }

        public Criteria andRemarkMessageIsNull() {
            addCriterion("remark_message is null");
            return (Criteria) this;
        }

        public Criteria andRemarkMessageIsNotNull() {
            addCriterion("remark_message is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkMessageEqualTo(String value) {
            addCriterion("remark_message =", value, "remarkMessage");
            return (Criteria) this;
        }

        public Criteria andRemarkMessageNotEqualTo(String value) {
            addCriterion("remark_message <>", value, "remarkMessage");
            return (Criteria) this;
        }

        public Criteria andRemarkMessageGreaterThan(String value) {
            addCriterion("remark_message >", value, "remarkMessage");
            return (Criteria) this;
        }

        public Criteria andRemarkMessageGreaterThanOrEqualTo(String value) {
            addCriterion("remark_message >=", value, "remarkMessage");
            return (Criteria) this;
        }

        public Criteria andRemarkMessageLessThan(String value) {
            addCriterion("remark_message <", value, "remarkMessage");
            return (Criteria) this;
        }

        public Criteria andRemarkMessageLessThanOrEqualTo(String value) {
            addCriterion("remark_message <=", value, "remarkMessage");
            return (Criteria) this;
        }

        public Criteria andRemarkMessageLike(String value) {
            addCriterion("remark_message like", value, "remarkMessage");
            return (Criteria) this;
        }

        public Criteria andRemarkMessageNotLike(String value) {
            addCriterion("remark_message not like", value, "remarkMessage");
            return (Criteria) this;
        }

        public Criteria andRemarkMessageIn(List<String> values) {
            addCriterion("remark_message in", values, "remarkMessage");
            return (Criteria) this;
        }

        public Criteria andRemarkMessageNotIn(List<String> values) {
            addCriterion("remark_message not in", values, "remarkMessage");
            return (Criteria) this;
        }

        public Criteria andRemarkMessageBetween(String value1, String value2) {
            addCriterion("remark_message between", value1, value2, "remarkMessage");
            return (Criteria) this;
        }

        public Criteria andRemarkMessageNotBetween(String value1, String value2) {
            addCriterion("remark_message not between", value1, value2, "remarkMessage");
            return (Criteria) this;
        }

        public Criteria andFeedbackIsNull() {
            addCriterion("feedback is null");
            return (Criteria) this;
        }

        public Criteria andFeedbackIsNotNull() {
            addCriterion("feedback is not null");
            return (Criteria) this;
        }

        public Criteria andFeedbackEqualTo(String value) {
            addCriterion("feedback =", value, "feedback");
            return (Criteria) this;
        }

        public Criteria andFeedbackNotEqualTo(String value) {
            addCriterion("feedback <>", value, "feedback");
            return (Criteria) this;
        }

        public Criteria andFeedbackGreaterThan(String value) {
            addCriterion("feedback >", value, "feedback");
            return (Criteria) this;
        }

        public Criteria andFeedbackGreaterThanOrEqualTo(String value) {
            addCriterion("feedback >=", value, "feedback");
            return (Criteria) this;
        }

        public Criteria andFeedbackLessThan(String value) {
            addCriterion("feedback <", value, "feedback");
            return (Criteria) this;
        }

        public Criteria andFeedbackLessThanOrEqualTo(String value) {
            addCriterion("feedback <=", value, "feedback");
            return (Criteria) this;
        }

        public Criteria andFeedbackLike(String value) {
            addCriterion("feedback like", value, "feedback");
            return (Criteria) this;
        }

        public Criteria andFeedbackNotLike(String value) {
            addCriterion("feedback not like", value, "feedback");
            return (Criteria) this;
        }

        public Criteria andFeedbackIn(List<String> values) {
            addCriterion("feedback in", values, "feedback");
            return (Criteria) this;
        }

        public Criteria andFeedbackNotIn(List<String> values) {
            addCriterion("feedback not in", values, "feedback");
            return (Criteria) this;
        }

        public Criteria andFeedbackBetween(String value1, String value2) {
            addCriterion("feedback between", value1, value2, "feedback");
            return (Criteria) this;
        }

        public Criteria andFeedbackNotBetween(String value1, String value2) {
            addCriterion("feedback not between", value1, value2, "feedback");
            return (Criteria) this;
        }

        public Criteria andRemarkProcessStateIsNull() {
            addCriterion("remark_process_state is null");
            return (Criteria) this;
        }

        public Criteria andRemarkProcessStateIsNotNull() {
            addCriterion("remark_process_state is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkProcessStateEqualTo(Integer value) {
            addCriterion("remark_process_state =", value, "remarkProcessState");
            return (Criteria) this;
        }

        public Criteria andRemarkProcessStateNotEqualTo(Integer value) {
            addCriterion("remark_process_state <>", value, "remarkProcessState");
            return (Criteria) this;
        }

        public Criteria andRemarkProcessStateGreaterThan(Integer value) {
            addCriterion("remark_process_state >", value, "remarkProcessState");
            return (Criteria) this;
        }

        public Criteria andRemarkProcessStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("remark_process_state >=", value, "remarkProcessState");
            return (Criteria) this;
        }

        public Criteria andRemarkProcessStateLessThan(Integer value) {
            addCriterion("remark_process_state <", value, "remarkProcessState");
            return (Criteria) this;
        }

        public Criteria andRemarkProcessStateLessThanOrEqualTo(Integer value) {
            addCriterion("remark_process_state <=", value, "remarkProcessState");
            return (Criteria) this;
        }

        public Criteria andRemarkProcessStateIn(List<Integer> values) {
            addCriterion("remark_process_state in", values, "remarkProcessState");
            return (Criteria) this;
        }

        public Criteria andRemarkProcessStateNotIn(List<Integer> values) {
            addCriterion("remark_process_state not in", values, "remarkProcessState");
            return (Criteria) this;
        }

        public Criteria andRemarkProcessStateBetween(Integer value1, Integer value2) {
            addCriterion("remark_process_state between", value1, value2, "remarkProcessState");
            return (Criteria) this;
        }

        public Criteria andRemarkProcessStateNotBetween(Integer value1, Integer value2) {
            addCriterion("remark_process_state not between", value1, value2, "remarkProcessState");
            return (Criteria) this;
        }

        public Criteria andCreatedIsNull() {
            addCriterion("created is null");
            return (Criteria) this;
        }

        public Criteria andCreatedIsNotNull() {
            addCriterion("created is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedEqualTo(Date value) {
            addCriterion("created =", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotEqualTo(Date value) {
            addCriterion("created <>", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedGreaterThan(Date value) {
            addCriterion("created >", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedGreaterThanOrEqualTo(Date value) {
            addCriterion("created >=", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedLessThan(Date value) {
            addCriterion("created <", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedLessThanOrEqualTo(Date value) {
            addCriterion("created <=", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedIn(List<Date> values) {
            addCriterion("created in", values, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotIn(List<Date> values) {
            addCriterion("created not in", values, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedBetween(Date value1, Date value2) {
            addCriterion("created between", value1, value2, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotBetween(Date value1, Date value2) {
            addCriterion("created not between", value1, value2, "created");
            return (Criteria) this;
        }

        public Criteria andUpdatedIsNull() {
            addCriterion("updated is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedIsNotNull() {
            addCriterion("updated is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedEqualTo(Date value) {
            addCriterion("updated =", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedNotEqualTo(Date value) {
            addCriterion("updated <>", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedGreaterThan(Date value) {
            addCriterion("updated >", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedGreaterThanOrEqualTo(Date value) {
            addCriterion("updated >=", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedLessThan(Date value) {
            addCriterion("updated <", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedLessThanOrEqualTo(Date value) {
            addCriterion("updated <=", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedIn(List<Date> values) {
            addCriterion("updated in", values, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedNotIn(List<Date> values) {
            addCriterion("updated not in", values, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedBetween(Date value1, Date value2) {
            addCriterion("updated between", value1, value2, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedNotBetween(Date value1, Date value2) {
            addCriterion("updated not between", value1, value2, "updated");
            return (Criteria) this;
        }

        public Criteria andManagerWxidIsNull() {
            addCriterion("manager_wxid is null");
            return (Criteria) this;
        }

        public Criteria andManagerWxidIsNotNull() {
            addCriterion("manager_wxid is not null");
            return (Criteria) this;
        }

        public Criteria andManagerWxidEqualTo(String value) {
            addCriterion("manager_wxid =", value, "managerWxid");
            return (Criteria) this;
        }

        public Criteria andManagerWxidNotEqualTo(String value) {
            addCriterion("manager_wxid <>", value, "managerWxid");
            return (Criteria) this;
        }

        public Criteria andManagerWxidGreaterThan(String value) {
            addCriterion("manager_wxid >", value, "managerWxid");
            return (Criteria) this;
        }

        public Criteria andManagerWxidGreaterThanOrEqualTo(String value) {
            addCriterion("manager_wxid >=", value, "managerWxid");
            return (Criteria) this;
        }

        public Criteria andManagerWxidLessThan(String value) {
            addCriterion("manager_wxid <", value, "managerWxid");
            return (Criteria) this;
        }

        public Criteria andManagerWxidLessThanOrEqualTo(String value) {
            addCriterion("manager_wxid <=", value, "managerWxid");
            return (Criteria) this;
        }

        public Criteria andManagerWxidLike(String value) {
            addCriterion("manager_wxid like", value, "managerWxid");
            return (Criteria) this;
        }

        public Criteria andManagerWxidNotLike(String value) {
            addCriterion("manager_wxid not like", value, "managerWxid");
            return (Criteria) this;
        }

        public Criteria andManagerWxidIn(List<String> values) {
            addCriterion("manager_wxid in", values, "managerWxid");
            return (Criteria) this;
        }

        public Criteria andManagerWxidNotIn(List<String> values) {
            addCriterion("manager_wxid not in", values, "managerWxid");
            return (Criteria) this;
        }

        public Criteria andManagerWxidBetween(String value1, String value2) {
            addCriterion("manager_wxid between", value1, value2, "managerWxid");
            return (Criteria) this;
        }

        public Criteria andManagerWxidNotBetween(String value1, String value2) {
            addCriterion("manager_wxid not between", value1, value2, "managerWxid");
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