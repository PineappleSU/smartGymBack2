package cn.smartGym.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EventExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EventExample() {
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

        public Criteria andEventIdIsNull() {
            addCriterion("event_id is null");
            return (Criteria) this;
        }

        public Criteria andEventIdIsNotNull() {
            addCriterion("event_id is not null");
            return (Criteria) this;
        }

        public Criteria andEventIdEqualTo(String value) {
            addCriterion("event_id =", value, "eventId");
            return (Criteria) this;
        }

        public Criteria andEventIdNotEqualTo(String value) {
            addCriterion("event_id <>", value, "eventId");
            return (Criteria) this;
        }

        public Criteria andEventIdGreaterThan(String value) {
            addCriterion("event_id >", value, "eventId");
            return (Criteria) this;
        }

        public Criteria andEventIdGreaterThanOrEqualTo(String value) {
            addCriterion("event_id >=", value, "eventId");
            return (Criteria) this;
        }

        public Criteria andEventIdLessThan(String value) {
            addCriterion("event_id <", value, "eventId");
            return (Criteria) this;
        }

        public Criteria andEventIdLessThanOrEqualTo(String value) {
            addCriterion("event_id <=", value, "eventId");
            return (Criteria) this;
        }

        public Criteria andEventIdLike(String value) {
            addCriterion("event_id like", value, "eventId");
            return (Criteria) this;
        }

        public Criteria andEventIdNotLike(String value) {
            addCriterion("event_id not like", value, "eventId");
            return (Criteria) this;
        }

        public Criteria andEventIdIn(List<String> values) {
            addCriterion("event_id in", values, "eventId");
            return (Criteria) this;
        }

        public Criteria andEventIdNotIn(List<String> values) {
            addCriterion("event_id not in", values, "eventId");
            return (Criteria) this;
        }

        public Criteria andEventIdBetween(String value1, String value2) {
            addCriterion("event_id between", value1, value2, "eventId");
            return (Criteria) this;
        }

        public Criteria andEventIdNotBetween(String value1, String value2) {
            addCriterion("event_id not between", value1, value2, "eventId");
            return (Criteria) this;
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

        public Criteria andCategoryIdIsNull() {
            addCriterion("category_id is null");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIsNotNull() {
            addCriterion("category_id is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryIdEqualTo(String value) {
            addCriterion("category_id =", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotEqualTo(String value) {
            addCriterion("category_id <>", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdGreaterThan(String value) {
            addCriterion("category_id >", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdGreaterThanOrEqualTo(String value) {
            addCriterion("category_id >=", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdLessThan(String value) {
            addCriterion("category_id <", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdLessThanOrEqualTo(String value) {
            addCriterion("category_id <=", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdLike(String value) {
            addCriterion("category_id like", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotLike(String value) {
            addCriterion("category_id not like", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIn(List<String> values) {
            addCriterion("category_id in", values, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotIn(List<String> values) {
            addCriterion("category_id not in", values, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdBetween(String value1, String value2) {
            addCriterion("category_id between", value1, value2, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotBetween(String value1, String value2) {
            addCriterion("category_id not between", value1, value2, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryNameIsNull() {
            addCriterion("category_name is null");
            return (Criteria) this;
        }

        public Criteria andCategoryNameIsNotNull() {
            addCriterion("category_name is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryNameEqualTo(String value) {
            addCriterion("category_name =", value, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameNotEqualTo(String value) {
            addCriterion("category_name <>", value, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameGreaterThan(String value) {
            addCriterion("category_name >", value, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameGreaterThanOrEqualTo(String value) {
            addCriterion("category_name >=", value, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameLessThan(String value) {
            addCriterion("category_name <", value, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameLessThanOrEqualTo(String value) {
            addCriterion("category_name <=", value, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameLike(String value) {
            addCriterion("category_name like", value, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameNotLike(String value) {
            addCriterion("category_name not like", value, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameIn(List<String> values) {
            addCriterion("category_name in", values, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameNotIn(List<String> values) {
            addCriterion("category_name not in", values, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameBetween(String value1, String value2) {
            addCriterion("category_name between", value1, value2, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameNotBetween(String value1, String value2) {
            addCriterion("category_name not between", value1, value2, "categoryName");
            return (Criteria) this;
        }

        public Criteria andEventNameIsNull() {
            addCriterion("event_name is null");
            return (Criteria) this;
        }

        public Criteria andEventNameIsNotNull() {
            addCriterion("event_name is not null");
            return (Criteria) this;
        }

        public Criteria andEventNameEqualTo(String value) {
            addCriterion("event_name =", value, "eventName");
            return (Criteria) this;
        }

        public Criteria andEventNameNotEqualTo(String value) {
            addCriterion("event_name <>", value, "eventName");
            return (Criteria) this;
        }

        public Criteria andEventNameGreaterThan(String value) {
            addCriterion("event_name >", value, "eventName");
            return (Criteria) this;
        }

        public Criteria andEventNameGreaterThanOrEqualTo(String value) {
            addCriterion("event_name >=", value, "eventName");
            return (Criteria) this;
        }

        public Criteria andEventNameLessThan(String value) {
            addCriterion("event_name <", value, "eventName");
            return (Criteria) this;
        }

        public Criteria andEventNameLessThanOrEqualTo(String value) {
            addCriterion("event_name <=", value, "eventName");
            return (Criteria) this;
        }

        public Criteria andEventNameLike(String value) {
            addCriterion("event_name like", value, "eventName");
            return (Criteria) this;
        }

        public Criteria andEventNameNotLike(String value) {
            addCriterion("event_name not like", value, "eventName");
            return (Criteria) this;
        }

        public Criteria andEventNameIn(List<String> values) {
            addCriterion("event_name in", values, "eventName");
            return (Criteria) this;
        }

        public Criteria andEventNameNotIn(List<String> values) {
            addCriterion("event_name not in", values, "eventName");
            return (Criteria) this;
        }

        public Criteria andEventNameBetween(String value1, String value2) {
            addCriterion("event_name between", value1, value2, "eventName");
            return (Criteria) this;
        }

        public Criteria andEventNameNotBetween(String value1, String value2) {
            addCriterion("event_name not between", value1, value2, "eventName");
            return (Criteria) this;
        }

        public Criteria andEventLevelIsNull() {
            addCriterion("event_level is null");
            return (Criteria) this;
        }

        public Criteria andEventLevelIsNotNull() {
            addCriterion("event_level is not null");
            return (Criteria) this;
        }

        public Criteria andEventLevelEqualTo(Integer value) {
            addCriterion("event_level =", value, "eventLevel");
            return (Criteria) this;
        }

        public Criteria andEventLevelNotEqualTo(Integer value) {
            addCriterion("event_level <>", value, "eventLevel");
            return (Criteria) this;
        }

        public Criteria andEventLevelGreaterThan(Integer value) {
            addCriterion("event_level >", value, "eventLevel");
            return (Criteria) this;
        }

        public Criteria andEventLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("event_level >=", value, "eventLevel");
            return (Criteria) this;
        }

        public Criteria andEventLevelLessThan(Integer value) {
            addCriterion("event_level <", value, "eventLevel");
            return (Criteria) this;
        }

        public Criteria andEventLevelLessThanOrEqualTo(Integer value) {
            addCriterion("event_level <=", value, "eventLevel");
            return (Criteria) this;
        }

        public Criteria andEventLevelIn(List<Integer> values) {
            addCriterion("event_level in", values, "eventLevel");
            return (Criteria) this;
        }

        public Criteria andEventLevelNotIn(List<Integer> values) {
            addCriterion("event_level not in", values, "eventLevel");
            return (Criteria) this;
        }

        public Criteria andEventLevelBetween(Integer value1, Integer value2) {
            addCriterion("event_level between", value1, value2, "eventLevel");
            return (Criteria) this;
        }

        public Criteria andEventLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("event_level not between", value1, value2, "eventLevel");
            return (Criteria) this;
        }

        public Criteria andEventPlaceIsNull() {
            addCriterion("event_place is null");
            return (Criteria) this;
        }

        public Criteria andEventPlaceIsNotNull() {
            addCriterion("event_place is not null");
            return (Criteria) this;
        }

        public Criteria andEventPlaceEqualTo(String value) {
            addCriterion("event_place =", value, "eventPlace");
            return (Criteria) this;
        }

        public Criteria andEventPlaceNotEqualTo(String value) {
            addCriterion("event_place <>", value, "eventPlace");
            return (Criteria) this;
        }

        public Criteria andEventPlaceGreaterThan(String value) {
            addCriterion("event_place >", value, "eventPlace");
            return (Criteria) this;
        }

        public Criteria andEventPlaceGreaterThanOrEqualTo(String value) {
            addCriterion("event_place >=", value, "eventPlace");
            return (Criteria) this;
        }

        public Criteria andEventPlaceLessThan(String value) {
            addCriterion("event_place <", value, "eventPlace");
            return (Criteria) this;
        }

        public Criteria andEventPlaceLessThanOrEqualTo(String value) {
            addCriterion("event_place <=", value, "eventPlace");
            return (Criteria) this;
        }

        public Criteria andEventPlaceLike(String value) {
            addCriterion("event_place like", value, "eventPlace");
            return (Criteria) this;
        }

        public Criteria andEventPlaceNotLike(String value) {
            addCriterion("event_place not like", value, "eventPlace");
            return (Criteria) this;
        }

        public Criteria andEventPlaceIn(List<String> values) {
            addCriterion("event_place in", values, "eventPlace");
            return (Criteria) this;
        }

        public Criteria andEventPlaceNotIn(List<String> values) {
            addCriterion("event_place not in", values, "eventPlace");
            return (Criteria) this;
        }

        public Criteria andEventPlaceBetween(String value1, String value2) {
            addCriterion("event_place between", value1, value2, "eventPlace");
            return (Criteria) this;
        }

        public Criteria andEventPlaceNotBetween(String value1, String value2) {
            addCriterion("event_place not between", value1, value2, "eventPlace");
            return (Criteria) this;
        }

        public Criteria andEventGenderIsNull() {
            addCriterion("event_gender is null");
            return (Criteria) this;
        }

        public Criteria andEventGenderIsNotNull() {
            addCriterion("event_gender is not null");
            return (Criteria) this;
        }

        public Criteria andEventGenderEqualTo(Integer value) {
            addCriterion("event_gender =", value, "eventGender");
            return (Criteria) this;
        }

        public Criteria andEventGenderNotEqualTo(Integer value) {
            addCriterion("event_gender <>", value, "eventGender");
            return (Criteria) this;
        }

        public Criteria andEventGenderGreaterThan(Integer value) {
            addCriterion("event_gender >", value, "eventGender");
            return (Criteria) this;
        }

        public Criteria andEventGenderGreaterThanOrEqualTo(Integer value) {
            addCriterion("event_gender >=", value, "eventGender");
            return (Criteria) this;
        }

        public Criteria andEventGenderLessThan(Integer value) {
            addCriterion("event_gender <", value, "eventGender");
            return (Criteria) this;
        }

        public Criteria andEventGenderLessThanOrEqualTo(Integer value) {
            addCriterion("event_gender <=", value, "eventGender");
            return (Criteria) this;
        }

        public Criteria andEventGenderIn(List<Integer> values) {
            addCriterion("event_gender in", values, "eventGender");
            return (Criteria) this;
        }

        public Criteria andEventGenderNotIn(List<Integer> values) {
            addCriterion("event_gender not in", values, "eventGender");
            return (Criteria) this;
        }

        public Criteria andEventGenderBetween(Integer value1, Integer value2) {
            addCriterion("event_gender between", value1, value2, "eventGender");
            return (Criteria) this;
        }

        public Criteria andEventGenderNotBetween(Integer value1, Integer value2) {
            addCriterion("event_gender not between", value1, value2, "eventGender");
            return (Criteria) this;
        }

        public Criteria andEventTypeIsNull() {
            addCriterion("event_type is null");
            return (Criteria) this;
        }

        public Criteria andEventTypeIsNotNull() {
            addCriterion("event_type is not null");
            return (Criteria) this;
        }

        public Criteria andEventTypeEqualTo(Integer value) {
            addCriterion("event_type =", value, "eventType");
            return (Criteria) this;
        }

        public Criteria andEventTypeNotEqualTo(Integer value) {
            addCriterion("event_type <>", value, "eventType");
            return (Criteria) this;
        }

        public Criteria andEventTypeGreaterThan(Integer value) {
            addCriterion("event_type >", value, "eventType");
            return (Criteria) this;
        }

        public Criteria andEventTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("event_type >=", value, "eventType");
            return (Criteria) this;
        }

        public Criteria andEventTypeLessThan(Integer value) {
            addCriterion("event_type <", value, "eventType");
            return (Criteria) this;
        }

        public Criteria andEventTypeLessThanOrEqualTo(Integer value) {
            addCriterion("event_type <=", value, "eventType");
            return (Criteria) this;
        }

        public Criteria andEventTypeIn(List<Integer> values) {
            addCriterion("event_type in", values, "eventType");
            return (Criteria) this;
        }

        public Criteria andEventTypeNotIn(List<Integer> values) {
            addCriterion("event_type not in", values, "eventType");
            return (Criteria) this;
        }

        public Criteria andEventTypeBetween(Integer value1, Integer value2) {
            addCriterion("event_type between", value1, value2, "eventType");
            return (Criteria) this;
        }

        public Criteria andEventTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("event_type not between", value1, value2, "eventType");
            return (Criteria) this;
        }

        public Criteria andPeopleNumIsNull() {
            addCriterion("people_num is null");
            return (Criteria) this;
        }

        public Criteria andPeopleNumIsNotNull() {
            addCriterion("people_num is not null");
            return (Criteria) this;
        }

        public Criteria andPeopleNumEqualTo(Integer value) {
            addCriterion("people_num =", value, "peopleNum");
            return (Criteria) this;
        }

        public Criteria andPeopleNumNotEqualTo(Integer value) {
            addCriterion("people_num <>", value, "peopleNum");
            return (Criteria) this;
        }

        public Criteria andPeopleNumGreaterThan(Integer value) {
            addCriterion("people_num >", value, "peopleNum");
            return (Criteria) this;
        }

        public Criteria andPeopleNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("people_num >=", value, "peopleNum");
            return (Criteria) this;
        }

        public Criteria andPeopleNumLessThan(Integer value) {
            addCriterion("people_num <", value, "peopleNum");
            return (Criteria) this;
        }

        public Criteria andPeopleNumLessThanOrEqualTo(Integer value) {
            addCriterion("people_num <=", value, "peopleNum");
            return (Criteria) this;
        }

        public Criteria andPeopleNumIn(List<Integer> values) {
            addCriterion("people_num in", values, "peopleNum");
            return (Criteria) this;
        }

        public Criteria andPeopleNumNotIn(List<Integer> values) {
            addCriterion("people_num not in", values, "peopleNum");
            return (Criteria) this;
        }

        public Criteria andPeopleNumBetween(Integer value1, Integer value2) {
            addCriterion("people_num between", value1, value2, "peopleNum");
            return (Criteria) this;
        }

        public Criteria andPeopleNumNotBetween(Integer value1, Integer value2) {
            addCriterion("people_num not between", value1, value2, "peopleNum");
            return (Criteria) this;
        }

        public Criteria andRankCriterionIsNull() {
            addCriterion("rank_criterion is null");
            return (Criteria) this;
        }

        public Criteria andRankCriterionIsNotNull() {
            addCriterion("rank_criterion is not null");
            return (Criteria) this;
        }

        public Criteria andRankCriterionEqualTo(Integer value) {
            addCriterion("rank_criterion =", value, "rankCriterion");
            return (Criteria) this;
        }

        public Criteria andRankCriterionNotEqualTo(Integer value) {
            addCriterion("rank_criterion <>", value, "rankCriterion");
            return (Criteria) this;
        }

        public Criteria andRankCriterionGreaterThan(Integer value) {
            addCriterion("rank_criterion >", value, "rankCriterion");
            return (Criteria) this;
        }

        public Criteria andRankCriterionGreaterThanOrEqualTo(Integer value) {
            addCriterion("rank_criterion >=", value, "rankCriterion");
            return (Criteria) this;
        }

        public Criteria andRankCriterionLessThan(Integer value) {
            addCriterion("rank_criterion <", value, "rankCriterion");
            return (Criteria) this;
        }

        public Criteria andRankCriterionLessThanOrEqualTo(Integer value) {
            addCriterion("rank_criterion <=", value, "rankCriterion");
            return (Criteria) this;
        }

        public Criteria andRankCriterionIn(List<Integer> values) {
            addCriterion("rank_criterion in", values, "rankCriterion");
            return (Criteria) this;
        }

        public Criteria andRankCriterionNotIn(List<Integer> values) {
            addCriterion("rank_criterion not in", values, "rankCriterion");
            return (Criteria) this;
        }

        public Criteria andRankCriterionBetween(Integer value1, Integer value2) {
            addCriterion("rank_criterion between", value1, value2, "rankCriterion");
            return (Criteria) this;
        }

        public Criteria andRankCriterionNotBetween(Integer value1, Integer value2) {
            addCriterion("rank_criterion not between", value1, value2, "rankCriterion");
            return (Criteria) this;
        }

        public Criteria andEventDescriptionIsNull() {
            addCriterion("event_description is null");
            return (Criteria) this;
        }

        public Criteria andEventDescriptionIsNotNull() {
            addCriterion("event_description is not null");
            return (Criteria) this;
        }

        public Criteria andEventDescriptionEqualTo(String value) {
            addCriterion("event_description =", value, "eventDescription");
            return (Criteria) this;
        }

        public Criteria andEventDescriptionNotEqualTo(String value) {
            addCriterion("event_description <>", value, "eventDescription");
            return (Criteria) this;
        }

        public Criteria andEventDescriptionGreaterThan(String value) {
            addCriterion("event_description >", value, "eventDescription");
            return (Criteria) this;
        }

        public Criteria andEventDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("event_description >=", value, "eventDescription");
            return (Criteria) this;
        }

        public Criteria andEventDescriptionLessThan(String value) {
            addCriterion("event_description <", value, "eventDescription");
            return (Criteria) this;
        }

        public Criteria andEventDescriptionLessThanOrEqualTo(String value) {
            addCriterion("event_description <=", value, "eventDescription");
            return (Criteria) this;
        }

        public Criteria andEventDescriptionLike(String value) {
            addCriterion("event_description like", value, "eventDescription");
            return (Criteria) this;
        }

        public Criteria andEventDescriptionNotLike(String value) {
            addCriterion("event_description not like", value, "eventDescription");
            return (Criteria) this;
        }

        public Criteria andEventDescriptionIn(List<String> values) {
            addCriterion("event_description in", values, "eventDescription");
            return (Criteria) this;
        }

        public Criteria andEventDescriptionNotIn(List<String> values) {
            addCriterion("event_description not in", values, "eventDescription");
            return (Criteria) this;
        }

        public Criteria andEventDescriptionBetween(String value1, String value2) {
            addCriterion("event_description between", value1, value2, "eventDescription");
            return (Criteria) this;
        }

        public Criteria andEventDescriptionNotBetween(String value1, String value2) {
            addCriterion("event_description not between", value1, value2, "eventDescription");
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

        public Criteria andJudgeWxidIsNull() {
            addCriterion("judge_wxid is null");
            return (Criteria) this;
        }

        public Criteria andJudgeWxidIsNotNull() {
            addCriterion("judge_wxid is not null");
            return (Criteria) this;
        }

        public Criteria andJudgeWxidEqualTo(String value) {
            addCriterion("judge_wxid =", value, "judgeWxid");
            return (Criteria) this;
        }

        public Criteria andJudgeWxidNotEqualTo(String value) {
            addCriterion("judge_wxid <>", value, "judgeWxid");
            return (Criteria) this;
        }

        public Criteria andJudgeWxidGreaterThan(String value) {
            addCriterion("judge_wxid >", value, "judgeWxid");
            return (Criteria) this;
        }

        public Criteria andJudgeWxidGreaterThanOrEqualTo(String value) {
            addCriterion("judge_wxid >=", value, "judgeWxid");
            return (Criteria) this;
        }

        public Criteria andJudgeWxidLessThan(String value) {
            addCriterion("judge_wxid <", value, "judgeWxid");
            return (Criteria) this;
        }

        public Criteria andJudgeWxidLessThanOrEqualTo(String value) {
            addCriterion("judge_wxid <=", value, "judgeWxid");
            return (Criteria) this;
        }

        public Criteria andJudgeWxidLike(String value) {
            addCriterion("judge_wxid like", value, "judgeWxid");
            return (Criteria) this;
        }

        public Criteria andJudgeWxidNotLike(String value) {
            addCriterion("judge_wxid not like", value, "judgeWxid");
            return (Criteria) this;
        }

        public Criteria andJudgeWxidIn(List<String> values) {
            addCriterion("judge_wxid in", values, "judgeWxid");
            return (Criteria) this;
        }

        public Criteria andJudgeWxidNotIn(List<String> values) {
            addCriterion("judge_wxid not in", values, "judgeWxid");
            return (Criteria) this;
        }

        public Criteria andJudgeWxidBetween(String value1, String value2) {
            addCriterion("judge_wxid between", value1, value2, "judgeWxid");
            return (Criteria) this;
        }

        public Criteria andJudgeWxidNotBetween(String value1, String value2) {
            addCriterion("judge_wxid not between", value1, value2, "judgeWxid");
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

        public Criteria andCategoryDescriptionIsNull() {
            addCriterion("category_description is null");
            return (Criteria) this;
        }

        public Criteria andCategoryDescriptionIsNotNull() {
            addCriterion("category_description is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryDescriptionEqualTo(String value) {
            addCriterion("category_description =", value, "categoryDescription");
            return (Criteria) this;
        }

        public Criteria andCategoryDescriptionNotEqualTo(String value) {
            addCriterion("category_description <>", value, "categoryDescription");
            return (Criteria) this;
        }

        public Criteria andCategoryDescriptionGreaterThan(String value) {
            addCriterion("category_description >", value, "categoryDescription");
            return (Criteria) this;
        }

        public Criteria andCategoryDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("category_description >=", value, "categoryDescription");
            return (Criteria) this;
        }

        public Criteria andCategoryDescriptionLessThan(String value) {
            addCriterion("category_description <", value, "categoryDescription");
            return (Criteria) this;
        }

        public Criteria andCategoryDescriptionLessThanOrEqualTo(String value) {
            addCriterion("category_description <=", value, "categoryDescription");
            return (Criteria) this;
        }

        public Criteria andCategoryDescriptionLike(String value) {
            addCriterion("category_description like", value, "categoryDescription");
            return (Criteria) this;
        }

        public Criteria andCategoryDescriptionNotLike(String value) {
            addCriterion("category_description not like", value, "categoryDescription");
            return (Criteria) this;
        }

        public Criteria andCategoryDescriptionIn(List<String> values) {
            addCriterion("category_description in", values, "categoryDescription");
            return (Criteria) this;
        }

        public Criteria andCategoryDescriptionNotIn(List<String> values) {
            addCriterion("category_description not in", values, "categoryDescription");
            return (Criteria) this;
        }

        public Criteria andCategoryDescriptionBetween(String value1, String value2) {
            addCriterion("category_description between", value1, value2, "categoryDescription");
            return (Criteria) this;
        }

        public Criteria andCategoryDescriptionNotBetween(String value1, String value2) {
            addCriterion("category_description not between", value1, value2, "categoryDescription");
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