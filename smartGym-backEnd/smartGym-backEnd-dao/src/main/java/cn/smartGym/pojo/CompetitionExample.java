package cn.smartGym.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CompetitionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CompetitionExample() {
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

        public Criteria andCompetitionIdIsNull() {
            addCriterion("competition_id is null");
            return (Criteria) this;
        }

        public Criteria andCompetitionIdIsNotNull() {
            addCriterion("competition_id is not null");
            return (Criteria) this;
        }

        public Criteria andCompetitionIdEqualTo(String value) {
            addCriterion("competition_id =", value, "competitionId");
            return (Criteria) this;
        }

        public Criteria andCompetitionIdNotEqualTo(String value) {
            addCriterion("competition_id <>", value, "competitionId");
            return (Criteria) this;
        }

        public Criteria andCompetitionIdGreaterThan(String value) {
            addCriterion("competition_id >", value, "competitionId");
            return (Criteria) this;
        }

        public Criteria andCompetitionIdGreaterThanOrEqualTo(String value) {
            addCriterion("competition_id >=", value, "competitionId");
            return (Criteria) this;
        }

        public Criteria andCompetitionIdLessThan(String value) {
            addCriterion("competition_id <", value, "competitionId");
            return (Criteria) this;
        }

        public Criteria andCompetitionIdLessThanOrEqualTo(String value) {
            addCriterion("competition_id <=", value, "competitionId");
            return (Criteria) this;
        }

        public Criteria andCompetitionIdLike(String value) {
            addCriterion("competition_id like", value, "competitionId");
            return (Criteria) this;
        }

        public Criteria andCompetitionIdNotLike(String value) {
            addCriterion("competition_id not like", value, "competitionId");
            return (Criteria) this;
        }

        public Criteria andCompetitionIdIn(List<String> values) {
            addCriterion("competition_id in", values, "competitionId");
            return (Criteria) this;
        }

        public Criteria andCompetitionIdNotIn(List<String> values) {
            addCriterion("competition_id not in", values, "competitionId");
            return (Criteria) this;
        }

        public Criteria andCompetitionIdBetween(String value1, String value2) {
            addCriterion("competition_id between", value1, value2, "competitionId");
            return (Criteria) this;
        }

        public Criteria andCompetitionIdNotBetween(String value1, String value2) {
            addCriterion("competition_id not between", value1, value2, "competitionId");
            return (Criteria) this;
        }

        public Criteria andCompetitionNameIsNull() {
            addCriterion("competition_name is null");
            return (Criteria) this;
        }

        public Criteria andCompetitionNameIsNotNull() {
            addCriterion("competition_name is not null");
            return (Criteria) this;
        }

        public Criteria andCompetitionNameEqualTo(String value) {
            addCriterion("competition_name =", value, "competitionName");
            return (Criteria) this;
        }

        public Criteria andCompetitionNameNotEqualTo(String value) {
            addCriterion("competition_name <>", value, "competitionName");
            return (Criteria) this;
        }

        public Criteria andCompetitionNameGreaterThan(String value) {
            addCriterion("competition_name >", value, "competitionName");
            return (Criteria) this;
        }

        public Criteria andCompetitionNameGreaterThanOrEqualTo(String value) {
            addCriterion("competition_name >=", value, "competitionName");
            return (Criteria) this;
        }

        public Criteria andCompetitionNameLessThan(String value) {
            addCriterion("competition_name <", value, "competitionName");
            return (Criteria) this;
        }

        public Criteria andCompetitionNameLessThanOrEqualTo(String value) {
            addCriterion("competition_name <=", value, "competitionName");
            return (Criteria) this;
        }

        public Criteria andCompetitionNameLike(String value) {
            addCriterion("competition_name like", value, "competitionName");
            return (Criteria) this;
        }

        public Criteria andCompetitionNameNotLike(String value) {
            addCriterion("competition_name not like", value, "competitionName");
            return (Criteria) this;
        }

        public Criteria andCompetitionNameIn(List<String> values) {
            addCriterion("competition_name in", values, "competitionName");
            return (Criteria) this;
        }

        public Criteria andCompetitionNameNotIn(List<String> values) {
            addCriterion("competition_name not in", values, "competitionName");
            return (Criteria) this;
        }

        public Criteria andCompetitionNameBetween(String value1, String value2) {
            addCriterion("competition_name between", value1, value2, "competitionName");
            return (Criteria) this;
        }

        public Criteria andCompetitionNameNotBetween(String value1, String value2) {
            addCriterion("competition_name not between", value1, value2, "competitionName");
            return (Criteria) this;
        }

        public Criteria andCompetitionType1IsNull() {
            addCriterion("competition_type1 is null");
            return (Criteria) this;
        }

        public Criteria andCompetitionType1IsNotNull() {
            addCriterion("competition_type1 is not null");
            return (Criteria) this;
        }

        public Criteria andCompetitionType1EqualTo(Integer value) {
            addCriterion("competition_type1 =", value, "competitionType1");
            return (Criteria) this;
        }

        public Criteria andCompetitionType1NotEqualTo(Integer value) {
            addCriterion("competition_type1 <>", value, "competitionType1");
            return (Criteria) this;
        }

        public Criteria andCompetitionType1GreaterThan(Integer value) {
            addCriterion("competition_type1 >", value, "competitionType1");
            return (Criteria) this;
        }

        public Criteria andCompetitionType1GreaterThanOrEqualTo(Integer value) {
            addCriterion("competition_type1 >=", value, "competitionType1");
            return (Criteria) this;
        }

        public Criteria andCompetitionType1LessThan(Integer value) {
            addCriterion("competition_type1 <", value, "competitionType1");
            return (Criteria) this;
        }

        public Criteria andCompetitionType1LessThanOrEqualTo(Integer value) {
            addCriterion("competition_type1 <=", value, "competitionType1");
            return (Criteria) this;
        }

        public Criteria andCompetitionType1In(List<Integer> values) {
            addCriterion("competition_type1 in", values, "competitionType1");
            return (Criteria) this;
        }

        public Criteria andCompetitionType1NotIn(List<Integer> values) {
            addCriterion("competition_type1 not in", values, "competitionType1");
            return (Criteria) this;
        }

        public Criteria andCompetitionType1Between(Integer value1, Integer value2) {
            addCriterion("competition_type1 between", value1, value2, "competitionType1");
            return (Criteria) this;
        }

        public Criteria andCompetitionType1NotBetween(Integer value1, Integer value2) {
            addCriterion("competition_type1 not between", value1, value2, "competitionType1");
            return (Criteria) this;
        }

        public Criteria andCompetitionType2IsNull() {
            addCriterion("competition_type2 is null");
            return (Criteria) this;
        }

        public Criteria andCompetitionType2IsNotNull() {
            addCriterion("competition_type2 is not null");
            return (Criteria) this;
        }

        public Criteria andCompetitionType2EqualTo(Integer value) {
            addCriterion("competition_type2 =", value, "competitionType2");
            return (Criteria) this;
        }

        public Criteria andCompetitionType2NotEqualTo(Integer value) {
            addCriterion("competition_type2 <>", value, "competitionType2");
            return (Criteria) this;
        }

        public Criteria andCompetitionType2GreaterThan(Integer value) {
            addCriterion("competition_type2 >", value, "competitionType2");
            return (Criteria) this;
        }

        public Criteria andCompetitionType2GreaterThanOrEqualTo(Integer value) {
            addCriterion("competition_type2 >=", value, "competitionType2");
            return (Criteria) this;
        }

        public Criteria andCompetitionType2LessThan(Integer value) {
            addCriterion("competition_type2 <", value, "competitionType2");
            return (Criteria) this;
        }

        public Criteria andCompetitionType2LessThanOrEqualTo(Integer value) {
            addCriterion("competition_type2 <=", value, "competitionType2");
            return (Criteria) this;
        }

        public Criteria andCompetitionType2In(List<Integer> values) {
            addCriterion("competition_type2 in", values, "competitionType2");
            return (Criteria) this;
        }

        public Criteria andCompetitionType2NotIn(List<Integer> values) {
            addCriterion("competition_type2 not in", values, "competitionType2");
            return (Criteria) this;
        }

        public Criteria andCompetitionType2Between(Integer value1, Integer value2) {
            addCriterion("competition_type2 between", value1, value2, "competitionType2");
            return (Criteria) this;
        }

        public Criteria andCompetitionType2NotBetween(Integer value1, Integer value2) {
            addCriterion("competition_type2 not between", value1, value2, "competitionType2");
            return (Criteria) this;
        }

        public Criteria andDepartmentIsNull() {
            addCriterion("department is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentIsNotNull() {
            addCriterion("department is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentEqualTo(String value) {
            addCriterion("department =", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentNotEqualTo(String value) {
            addCriterion("department <>", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentGreaterThan(String value) {
            addCriterion("department >", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentGreaterThanOrEqualTo(String value) {
            addCriterion("department >=", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentLessThan(String value) {
            addCriterion("department <", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentLessThanOrEqualTo(String value) {
            addCriterion("department <=", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentLike(String value) {
            addCriterion("department like", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentNotLike(String value) {
            addCriterion("department not like", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentIn(List<String> values) {
            addCriterion("department in", values, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentNotIn(List<String> values) {
            addCriterion("department not in", values, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentBetween(String value1, String value2) {
            addCriterion("department between", value1, value2, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentNotBetween(String value1, String value2) {
            addCriterion("department not between", value1, value2, "department");
            return (Criteria) this;
        }

        public Criteria andPrincipalWxidIsNull() {
            addCriterion("principal_wxid is null");
            return (Criteria) this;
        }

        public Criteria andPrincipalWxidIsNotNull() {
            addCriterion("principal_wxid is not null");
            return (Criteria) this;
        }

        public Criteria andPrincipalWxidEqualTo(String value) {
            addCriterion("principal_wxid =", value, "principalWxid");
            return (Criteria) this;
        }

        public Criteria andPrincipalWxidNotEqualTo(String value) {
            addCriterion("principal_wxid <>", value, "principalWxid");
            return (Criteria) this;
        }

        public Criteria andPrincipalWxidGreaterThan(String value) {
            addCriterion("principal_wxid >", value, "principalWxid");
            return (Criteria) this;
        }

        public Criteria andPrincipalWxidGreaterThanOrEqualTo(String value) {
            addCriterion("principal_wxid >=", value, "principalWxid");
            return (Criteria) this;
        }

        public Criteria andPrincipalWxidLessThan(String value) {
            addCriterion("principal_wxid <", value, "principalWxid");
            return (Criteria) this;
        }

        public Criteria andPrincipalWxidLessThanOrEqualTo(String value) {
            addCriterion("principal_wxid <=", value, "principalWxid");
            return (Criteria) this;
        }

        public Criteria andPrincipalWxidLike(String value) {
            addCriterion("principal_wxid like", value, "principalWxid");
            return (Criteria) this;
        }

        public Criteria andPrincipalWxidNotLike(String value) {
            addCriterion("principal_wxid not like", value, "principalWxid");
            return (Criteria) this;
        }

        public Criteria andPrincipalWxidIn(List<String> values) {
            addCriterion("principal_wxid in", values, "principalWxid");
            return (Criteria) this;
        }

        public Criteria andPrincipalWxidNotIn(List<String> values) {
            addCriterion("principal_wxid not in", values, "principalWxid");
            return (Criteria) this;
        }

        public Criteria andPrincipalWxidBetween(String value1, String value2) {
            addCriterion("principal_wxid between", value1, value2, "principalWxid");
            return (Criteria) this;
        }

        public Criteria andPrincipalWxidNotBetween(String value1, String value2) {
            addCriterion("principal_wxid not between", value1, value2, "principalWxid");
            return (Criteria) this;
        }

        public Criteria andJudgeHeaderWxidIsNull() {
            addCriterion("judge_header_wxid is null");
            return (Criteria) this;
        }

        public Criteria andJudgeHeaderWxidIsNotNull() {
            addCriterion("judge_header_wxid is not null");
            return (Criteria) this;
        }

        public Criteria andJudgeHeaderWxidEqualTo(String value) {
            addCriterion("judge_header_wxid =", value, "judgeHeaderWxid");
            return (Criteria) this;
        }

        public Criteria andJudgeHeaderWxidNotEqualTo(String value) {
            addCriterion("judge_header_wxid <>", value, "judgeHeaderWxid");
            return (Criteria) this;
        }

        public Criteria andJudgeHeaderWxidGreaterThan(String value) {
            addCriterion("judge_header_wxid >", value, "judgeHeaderWxid");
            return (Criteria) this;
        }

        public Criteria andJudgeHeaderWxidGreaterThanOrEqualTo(String value) {
            addCriterion("judge_header_wxid >=", value, "judgeHeaderWxid");
            return (Criteria) this;
        }

        public Criteria andJudgeHeaderWxidLessThan(String value) {
            addCriterion("judge_header_wxid <", value, "judgeHeaderWxid");
            return (Criteria) this;
        }

        public Criteria andJudgeHeaderWxidLessThanOrEqualTo(String value) {
            addCriterion("judge_header_wxid <=", value, "judgeHeaderWxid");
            return (Criteria) this;
        }

        public Criteria andJudgeHeaderWxidLike(String value) {
            addCriterion("judge_header_wxid like", value, "judgeHeaderWxid");
            return (Criteria) this;
        }

        public Criteria andJudgeHeaderWxidNotLike(String value) {
            addCriterion("judge_header_wxid not like", value, "judgeHeaderWxid");
            return (Criteria) this;
        }

        public Criteria andJudgeHeaderWxidIn(List<String> values) {
            addCriterion("judge_header_wxid in", values, "judgeHeaderWxid");
            return (Criteria) this;
        }

        public Criteria andJudgeHeaderWxidNotIn(List<String> values) {
            addCriterion("judge_header_wxid not in", values, "judgeHeaderWxid");
            return (Criteria) this;
        }

        public Criteria andJudgeHeaderWxidBetween(String value1, String value2) {
            addCriterion("judge_header_wxid between", value1, value2, "judgeHeaderWxid");
            return (Criteria) this;
        }

        public Criteria andJudgeHeaderWxidNotBetween(String value1, String value2) {
            addCriterion("judge_header_wxid not between", value1, value2, "judgeHeaderWxid");
            return (Criteria) this;
        }

        public Criteria andApplyStartTimeIsNull() {
            addCriterion("apply_start_time is null");
            return (Criteria) this;
        }

        public Criteria andApplyStartTimeIsNotNull() {
            addCriterion("apply_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andApplyStartTimeEqualTo(Date value) {
            addCriterion("apply_start_time =", value, "applyStartTime");
            return (Criteria) this;
        }

        public Criteria andApplyStartTimeNotEqualTo(Date value) {
            addCriterion("apply_start_time <>", value, "applyStartTime");
            return (Criteria) this;
        }

        public Criteria andApplyStartTimeGreaterThan(Date value) {
            addCriterion("apply_start_time >", value, "applyStartTime");
            return (Criteria) this;
        }

        public Criteria andApplyStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("apply_start_time >=", value, "applyStartTime");
            return (Criteria) this;
        }

        public Criteria andApplyStartTimeLessThan(Date value) {
            addCriterion("apply_start_time <", value, "applyStartTime");
            return (Criteria) this;
        }

        public Criteria andApplyStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("apply_start_time <=", value, "applyStartTime");
            return (Criteria) this;
        }

        public Criteria andApplyStartTimeIn(List<Date> values) {
            addCriterion("apply_start_time in", values, "applyStartTime");
            return (Criteria) this;
        }

        public Criteria andApplyStartTimeNotIn(List<Date> values) {
            addCriterion("apply_start_time not in", values, "applyStartTime");
            return (Criteria) this;
        }

        public Criteria andApplyStartTimeBetween(Date value1, Date value2) {
            addCriterion("apply_start_time between", value1, value2, "applyStartTime");
            return (Criteria) this;
        }

        public Criteria andApplyStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("apply_start_time not between", value1, value2, "applyStartTime");
            return (Criteria) this;
        }

        public Criteria andApplyCheckTimeIsNull() {
            addCriterion("apply_check_time is null");
            return (Criteria) this;
        }

        public Criteria andApplyCheckTimeIsNotNull() {
            addCriterion("apply_check_time is not null");
            return (Criteria) this;
        }

        public Criteria andApplyCheckTimeEqualTo(Date value) {
            addCriterion("apply_check_time =", value, "applyCheckTime");
            return (Criteria) this;
        }

        public Criteria andApplyCheckTimeNotEqualTo(Date value) {
            addCriterion("apply_check_time <>", value, "applyCheckTime");
            return (Criteria) this;
        }

        public Criteria andApplyCheckTimeGreaterThan(Date value) {
            addCriterion("apply_check_time >", value, "applyCheckTime");
            return (Criteria) this;
        }

        public Criteria andApplyCheckTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("apply_check_time >=", value, "applyCheckTime");
            return (Criteria) this;
        }

        public Criteria andApplyCheckTimeLessThan(Date value) {
            addCriterion("apply_check_time <", value, "applyCheckTime");
            return (Criteria) this;
        }

        public Criteria andApplyCheckTimeLessThanOrEqualTo(Date value) {
            addCriterion("apply_check_time <=", value, "applyCheckTime");
            return (Criteria) this;
        }

        public Criteria andApplyCheckTimeIn(List<Date> values) {
            addCriterion("apply_check_time in", values, "applyCheckTime");
            return (Criteria) this;
        }

        public Criteria andApplyCheckTimeNotIn(List<Date> values) {
            addCriterion("apply_check_time not in", values, "applyCheckTime");
            return (Criteria) this;
        }

        public Criteria andApplyCheckTimeBetween(Date value1, Date value2) {
            addCriterion("apply_check_time between", value1, value2, "applyCheckTime");
            return (Criteria) this;
        }

        public Criteria andApplyCheckTimeNotBetween(Date value1, Date value2) {
            addCriterion("apply_check_time not between", value1, value2, "applyCheckTime");
            return (Criteria) this;
        }

        public Criteria andCheckEndTimeIsNull() {
            addCriterion("check_end_time is null");
            return (Criteria) this;
        }

        public Criteria andCheckEndTimeIsNotNull() {
            addCriterion("check_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andCheckEndTimeEqualTo(Date value) {
            addCriterion("check_end_time =", value, "checkEndTime");
            return (Criteria) this;
        }

        public Criteria andCheckEndTimeNotEqualTo(Date value) {
            addCriterion("check_end_time <>", value, "checkEndTime");
            return (Criteria) this;
        }

        public Criteria andCheckEndTimeGreaterThan(Date value) {
            addCriterion("check_end_time >", value, "checkEndTime");
            return (Criteria) this;
        }

        public Criteria andCheckEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("check_end_time >=", value, "checkEndTime");
            return (Criteria) this;
        }

        public Criteria andCheckEndTimeLessThan(Date value) {
            addCriterion("check_end_time <", value, "checkEndTime");
            return (Criteria) this;
        }

        public Criteria andCheckEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("check_end_time <=", value, "checkEndTime");
            return (Criteria) this;
        }

        public Criteria andCheckEndTimeIn(List<Date> values) {
            addCriterion("check_end_time in", values, "checkEndTime");
            return (Criteria) this;
        }

        public Criteria andCheckEndTimeNotIn(List<Date> values) {
            addCriterion("check_end_time not in", values, "checkEndTime");
            return (Criteria) this;
        }

        public Criteria andCheckEndTimeBetween(Date value1, Date value2) {
            addCriterion("check_end_time between", value1, value2, "checkEndTime");
            return (Criteria) this;
        }

        public Criteria andCheckEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("check_end_time not between", value1, value2, "checkEndTime");
            return (Criteria) this;
        }

        public Criteria andCompetitionStartTimeIsNull() {
            addCriterion("competition_start_time is null");
            return (Criteria) this;
        }

        public Criteria andCompetitionStartTimeIsNotNull() {
            addCriterion("competition_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andCompetitionStartTimeEqualTo(Date value) {
            addCriterion("competition_start_time =", value, "competitionStartTime");
            return (Criteria) this;
        }

        public Criteria andCompetitionStartTimeNotEqualTo(Date value) {
            addCriterion("competition_start_time <>", value, "competitionStartTime");
            return (Criteria) this;
        }

        public Criteria andCompetitionStartTimeGreaterThan(Date value) {
            addCriterion("competition_start_time >", value, "competitionStartTime");
            return (Criteria) this;
        }

        public Criteria andCompetitionStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("competition_start_time >=", value, "competitionStartTime");
            return (Criteria) this;
        }

        public Criteria andCompetitionStartTimeLessThan(Date value) {
            addCriterion("competition_start_time <", value, "competitionStartTime");
            return (Criteria) this;
        }

        public Criteria andCompetitionStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("competition_start_time <=", value, "competitionStartTime");
            return (Criteria) this;
        }

        public Criteria andCompetitionStartTimeIn(List<Date> values) {
            addCriterion("competition_start_time in", values, "competitionStartTime");
            return (Criteria) this;
        }

        public Criteria andCompetitionStartTimeNotIn(List<Date> values) {
            addCriterion("competition_start_time not in", values, "competitionStartTime");
            return (Criteria) this;
        }

        public Criteria andCompetitionStartTimeBetween(Date value1, Date value2) {
            addCriterion("competition_start_time between", value1, value2, "competitionStartTime");
            return (Criteria) this;
        }

        public Criteria andCompetitionStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("competition_start_time not between", value1, value2, "competitionStartTime");
            return (Criteria) this;
        }

        public Criteria andCompetitionEndTimeIsNull() {
            addCriterion("competition_end_time is null");
            return (Criteria) this;
        }

        public Criteria andCompetitionEndTimeIsNotNull() {
            addCriterion("competition_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andCompetitionEndTimeEqualTo(Date value) {
            addCriterion("competition_end_time =", value, "competitionEndTime");
            return (Criteria) this;
        }

        public Criteria andCompetitionEndTimeNotEqualTo(Date value) {
            addCriterion("competition_end_time <>", value, "competitionEndTime");
            return (Criteria) this;
        }

        public Criteria andCompetitionEndTimeGreaterThan(Date value) {
            addCriterion("competition_end_time >", value, "competitionEndTime");
            return (Criteria) this;
        }

        public Criteria andCompetitionEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("competition_end_time >=", value, "competitionEndTime");
            return (Criteria) this;
        }

        public Criteria andCompetitionEndTimeLessThan(Date value) {
            addCriterion("competition_end_time <", value, "competitionEndTime");
            return (Criteria) this;
        }

        public Criteria andCompetitionEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("competition_end_time <=", value, "competitionEndTime");
            return (Criteria) this;
        }

        public Criteria andCompetitionEndTimeIn(List<Date> values) {
            addCriterion("competition_end_time in", values, "competitionEndTime");
            return (Criteria) this;
        }

        public Criteria andCompetitionEndTimeNotIn(List<Date> values) {
            addCriterion("competition_end_time not in", values, "competitionEndTime");
            return (Criteria) this;
        }

        public Criteria andCompetitionEndTimeBetween(Date value1, Date value2) {
            addCriterion("competition_end_time between", value1, value2, "competitionEndTime");
            return (Criteria) this;
        }

        public Criteria andCompetitionEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("competition_end_time not between", value1, value2, "competitionEndTime");
            return (Criteria) this;
        }

        public Criteria andCompetitionPlaceIsNull() {
            addCriterion("competition_place is null");
            return (Criteria) this;
        }

        public Criteria andCompetitionPlaceIsNotNull() {
            addCriterion("competition_place is not null");
            return (Criteria) this;
        }

        public Criteria andCompetitionPlaceEqualTo(String value) {
            addCriterion("competition_place =", value, "competitionPlace");
            return (Criteria) this;
        }

        public Criteria andCompetitionPlaceNotEqualTo(String value) {
            addCriterion("competition_place <>", value, "competitionPlace");
            return (Criteria) this;
        }

        public Criteria andCompetitionPlaceGreaterThan(String value) {
            addCriterion("competition_place >", value, "competitionPlace");
            return (Criteria) this;
        }

        public Criteria andCompetitionPlaceGreaterThanOrEqualTo(String value) {
            addCriterion("competition_place >=", value, "competitionPlace");
            return (Criteria) this;
        }

        public Criteria andCompetitionPlaceLessThan(String value) {
            addCriterion("competition_place <", value, "competitionPlace");
            return (Criteria) this;
        }

        public Criteria andCompetitionPlaceLessThanOrEqualTo(String value) {
            addCriterion("competition_place <=", value, "competitionPlace");
            return (Criteria) this;
        }

        public Criteria andCompetitionPlaceLike(String value) {
            addCriterion("competition_place like", value, "competitionPlace");
            return (Criteria) this;
        }

        public Criteria andCompetitionPlaceNotLike(String value) {
            addCriterion("competition_place not like", value, "competitionPlace");
            return (Criteria) this;
        }

        public Criteria andCompetitionPlaceIn(List<String> values) {
            addCriterion("competition_place in", values, "competitionPlace");
            return (Criteria) this;
        }

        public Criteria andCompetitionPlaceNotIn(List<String> values) {
            addCriterion("competition_place not in", values, "competitionPlace");
            return (Criteria) this;
        }

        public Criteria andCompetitionPlaceBetween(String value1, String value2) {
            addCriterion("competition_place between", value1, value2, "competitionPlace");
            return (Criteria) this;
        }

        public Criteria andCompetitionPlaceNotBetween(String value1, String value2) {
            addCriterion("competition_place not between", value1, value2, "competitionPlace");
            return (Criteria) this;
        }

        public Criteria andCompetitionDescriptionIsNull() {
            addCriterion("competition_description is null");
            return (Criteria) this;
        }

        public Criteria andCompetitionDescriptionIsNotNull() {
            addCriterion("competition_description is not null");
            return (Criteria) this;
        }

        public Criteria andCompetitionDescriptionEqualTo(String value) {
            addCriterion("competition_description =", value, "competitionDescription");
            return (Criteria) this;
        }

        public Criteria andCompetitionDescriptionNotEqualTo(String value) {
            addCriterion("competition_description <>", value, "competitionDescription");
            return (Criteria) this;
        }

        public Criteria andCompetitionDescriptionGreaterThan(String value) {
            addCriterion("competition_description >", value, "competitionDescription");
            return (Criteria) this;
        }

        public Criteria andCompetitionDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("competition_description >=", value, "competitionDescription");
            return (Criteria) this;
        }

        public Criteria andCompetitionDescriptionLessThan(String value) {
            addCriterion("competition_description <", value, "competitionDescription");
            return (Criteria) this;
        }

        public Criteria andCompetitionDescriptionLessThanOrEqualTo(String value) {
            addCriterion("competition_description <=", value, "competitionDescription");
            return (Criteria) this;
        }

        public Criteria andCompetitionDescriptionLike(String value) {
            addCriterion("competition_description like", value, "competitionDescription");
            return (Criteria) this;
        }

        public Criteria andCompetitionDescriptionNotLike(String value) {
            addCriterion("competition_description not like", value, "competitionDescription");
            return (Criteria) this;
        }

        public Criteria andCompetitionDescriptionIn(List<String> values) {
            addCriterion("competition_description in", values, "competitionDescription");
            return (Criteria) this;
        }

        public Criteria andCompetitionDescriptionNotIn(List<String> values) {
            addCriterion("competition_description not in", values, "competitionDescription");
            return (Criteria) this;
        }

        public Criteria andCompetitionDescriptionBetween(String value1, String value2) {
            addCriterion("competition_description between", value1, value2, "competitionDescription");
            return (Criteria) this;
        }

        public Criteria andCompetitionDescriptionNotBetween(String value1, String value2) {
            addCriterion("competition_description not between", value1, value2, "competitionDescription");
            return (Criteria) this;
        }

        public Criteria andYearIsNull() {
            addCriterion("year is null");
            return (Criteria) this;
        }

        public Criteria andYearIsNotNull() {
            addCriterion("year is not null");
            return (Criteria) this;
        }

        public Criteria andYearEqualTo(Integer value) {
            addCriterion("year =", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotEqualTo(Integer value) {
            addCriterion("year <>", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearGreaterThan(Integer value) {
            addCriterion("year >", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearGreaterThanOrEqualTo(Integer value) {
            addCriterion("year >=", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLessThan(Integer value) {
            addCriterion("year <", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLessThanOrEqualTo(Integer value) {
            addCriterion("year <=", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearIn(List<Integer> values) {
            addCriterion("year in", values, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotIn(List<Integer> values) {
            addCriterion("year not in", values, "year");
            return (Criteria) this;
        }

        public Criteria andYearBetween(Integer value1, Integer value2) {
            addCriterion("year between", value1, value2, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotBetween(Integer value1, Integer value2) {
            addCriterion("year not between", value1, value2, "year");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andSearchTypeIsNull() {
            addCriterion("search_type is null");
            return (Criteria) this;
        }

        public Criteria andSearchTypeIsNotNull() {
            addCriterion("search_type is not null");
            return (Criteria) this;
        }

        public Criteria andSearchTypeEqualTo(Integer value) {
            addCriterion("search_type =", value, "searchType");
            return (Criteria) this;
        }

        public Criteria andSearchTypeNotEqualTo(Integer value) {
            addCriterion("search_type <>", value, "searchType");
            return (Criteria) this;
        }

        public Criteria andSearchTypeGreaterThan(Integer value) {
            addCriterion("search_type >", value, "searchType");
            return (Criteria) this;
        }

        public Criteria andSearchTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("search_type >=", value, "searchType");
            return (Criteria) this;
        }

        public Criteria andSearchTypeLessThan(Integer value) {
            addCriterion("search_type <", value, "searchType");
            return (Criteria) this;
        }

        public Criteria andSearchTypeLessThanOrEqualTo(Integer value) {
            addCriterion("search_type <=", value, "searchType");
            return (Criteria) this;
        }

        public Criteria andSearchTypeIn(List<Integer> values) {
            addCriterion("search_type in", values, "searchType");
            return (Criteria) this;
        }

        public Criteria andSearchTypeNotIn(List<Integer> values) {
            addCriterion("search_type not in", values, "searchType");
            return (Criteria) this;
        }

        public Criteria andSearchTypeBetween(Integer value1, Integer value2) {
            addCriterion("search_type between", value1, value2, "searchType");
            return (Criteria) this;
        }

        public Criteria andSearchTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("search_type not between", value1, value2, "searchType");
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