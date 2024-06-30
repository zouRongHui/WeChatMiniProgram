package com.rone.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RightsReceiveLogCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RightsReceiveLogCriteria() {
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

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andOpenIdIsNull() {
            addCriterion("OPEN_ID is null");
            return (Criteria) this;
        }

        public Criteria andOpenIdIsNotNull() {
            addCriterion("OPEN_ID is not null");
            return (Criteria) this;
        }

        public Criteria andOpenIdEqualTo(String value) {
            addCriterion("OPEN_ID =", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdNotEqualTo(String value) {
            addCriterion("OPEN_ID <>", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdGreaterThan(String value) {
            addCriterion("OPEN_ID >", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdGreaterThanOrEqualTo(String value) {
            addCriterion("OPEN_ID >=", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdLessThan(String value) {
            addCriterion("OPEN_ID <", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdLessThanOrEqualTo(String value) {
            addCriterion("OPEN_ID <=", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdLike(String value) {
            addCriterion("OPEN_ID like", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdNotLike(String value) {
            addCriterion("OPEN_ID not like", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdIn(List<String> values) {
            addCriterion("OPEN_ID in", values, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdNotIn(List<String> values) {
            addCriterion("OPEN_ID not in", values, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdBetween(String value1, String value2) {
            addCriterion("OPEN_ID between", value1, value2, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdNotBetween(String value1, String value2) {
            addCriterion("OPEN_ID not between", value1, value2, "openId");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("PHONE is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("PHONE is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("PHONE =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("PHONE <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("PHONE >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("PHONE >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("PHONE <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("PHONE <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("PHONE like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("PHONE not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("PHONE in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("PHONE not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("PHONE between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("PHONE not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andRightsIdIsNull() {
            addCriterion("RIGHTS_ID is null");
            return (Criteria) this;
        }

        public Criteria andRightsIdIsNotNull() {
            addCriterion("RIGHTS_ID is not null");
            return (Criteria) this;
        }

        public Criteria andRightsIdEqualTo(String value) {
            addCriterion("RIGHTS_ID =", value, "rightsId");
            return (Criteria) this;
        }

        public Criteria andRightsIdNotEqualTo(String value) {
            addCriterion("RIGHTS_ID <>", value, "rightsId");
            return (Criteria) this;
        }

        public Criteria andRightsIdGreaterThan(String value) {
            addCriterion("RIGHTS_ID >", value, "rightsId");
            return (Criteria) this;
        }

        public Criteria andRightsIdGreaterThanOrEqualTo(String value) {
            addCriterion("RIGHTS_ID >=", value, "rightsId");
            return (Criteria) this;
        }

        public Criteria andRightsIdLessThan(String value) {
            addCriterion("RIGHTS_ID <", value, "rightsId");
            return (Criteria) this;
        }

        public Criteria andRightsIdLessThanOrEqualTo(String value) {
            addCriterion("RIGHTS_ID <=", value, "rightsId");
            return (Criteria) this;
        }

        public Criteria andRightsIdLike(String value) {
            addCriterion("RIGHTS_ID like", value, "rightsId");
            return (Criteria) this;
        }

        public Criteria andRightsIdNotLike(String value) {
            addCriterion("RIGHTS_ID not like", value, "rightsId");
            return (Criteria) this;
        }

        public Criteria andRightsIdIn(List<String> values) {
            addCriterion("RIGHTS_ID in", values, "rightsId");
            return (Criteria) this;
        }

        public Criteria andRightsIdNotIn(List<String> values) {
            addCriterion("RIGHTS_ID not in", values, "rightsId");
            return (Criteria) this;
        }

        public Criteria andRightsIdBetween(String value1, String value2) {
            addCriterion("RIGHTS_ID between", value1, value2, "rightsId");
            return (Criteria) this;
        }

        public Criteria andRightsIdNotBetween(String value1, String value2) {
            addCriterion("RIGHTS_ID not between", value1, value2, "rightsId");
            return (Criteria) this;
        }

        public Criteria andRightsStartDateIsNull() {
            addCriterion("RIGHTS_START_DATE is null");
            return (Criteria) this;
        }

        public Criteria andRightsStartDateIsNotNull() {
            addCriterion("RIGHTS_START_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andRightsStartDateEqualTo(String value) {
            addCriterion("RIGHTS_START_DATE =", value, "rightsStartDate");
            return (Criteria) this;
        }

        public Criteria andRightsStartDateNotEqualTo(String value) {
            addCriterion("RIGHTS_START_DATE <>", value, "rightsStartDate");
            return (Criteria) this;
        }

        public Criteria andRightsStartDateGreaterThan(String value) {
            addCriterion("RIGHTS_START_DATE >", value, "rightsStartDate");
            return (Criteria) this;
        }

        public Criteria andRightsStartDateGreaterThanOrEqualTo(String value) {
            addCriterion("RIGHTS_START_DATE >=", value, "rightsStartDate");
            return (Criteria) this;
        }

        public Criteria andRightsStartDateLessThan(String value) {
            addCriterion("RIGHTS_START_DATE <", value, "rightsStartDate");
            return (Criteria) this;
        }

        public Criteria andRightsStartDateLessThanOrEqualTo(String value) {
            addCriterion("RIGHTS_START_DATE <=", value, "rightsStartDate");
            return (Criteria) this;
        }

        public Criteria andRightsStartDateLike(String value) {
            addCriterion("RIGHTS_START_DATE like", value, "rightsStartDate");
            return (Criteria) this;
        }

        public Criteria andRightsStartDateNotLike(String value) {
            addCriterion("RIGHTS_START_DATE not like", value, "rightsStartDate");
            return (Criteria) this;
        }

        public Criteria andRightsStartDateIn(List<String> values) {
            addCriterion("RIGHTS_START_DATE in", values, "rightsStartDate");
            return (Criteria) this;
        }

        public Criteria andRightsStartDateNotIn(List<String> values) {
            addCriterion("RIGHTS_START_DATE not in", values, "rightsStartDate");
            return (Criteria) this;
        }

        public Criteria andRightsStartDateBetween(String value1, String value2) {
            addCriterion("RIGHTS_START_DATE between", value1, value2, "rightsStartDate");
            return (Criteria) this;
        }

        public Criteria andRightsStartDateNotBetween(String value1, String value2) {
            addCriterion("RIGHTS_START_DATE not between", value1, value2, "rightsStartDate");
            return (Criteria) this;
        }

        public Criteria andRightsEndDateIsNull() {
            addCriterion("RIGHTS_END_DATE is null");
            return (Criteria) this;
        }

        public Criteria andRightsEndDateIsNotNull() {
            addCriterion("RIGHTS_END_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andRightsEndDateEqualTo(String value) {
            addCriterion("RIGHTS_END_DATE =", value, "rightsEndDate");
            return (Criteria) this;
        }

        public Criteria andRightsEndDateNotEqualTo(String value) {
            addCriterion("RIGHTS_END_DATE <>", value, "rightsEndDate");
            return (Criteria) this;
        }

        public Criteria andRightsEndDateGreaterThan(String value) {
            addCriterion("RIGHTS_END_DATE >", value, "rightsEndDate");
            return (Criteria) this;
        }

        public Criteria andRightsEndDateGreaterThanOrEqualTo(String value) {
            addCriterion("RIGHTS_END_DATE >=", value, "rightsEndDate");
            return (Criteria) this;
        }

        public Criteria andRightsEndDateLessThan(String value) {
            addCriterion("RIGHTS_END_DATE <", value, "rightsEndDate");
            return (Criteria) this;
        }

        public Criteria andRightsEndDateLessThanOrEqualTo(String value) {
            addCriterion("RIGHTS_END_DATE <=", value, "rightsEndDate");
            return (Criteria) this;
        }

        public Criteria andRightsEndDateLike(String value) {
            addCriterion("RIGHTS_END_DATE like", value, "rightsEndDate");
            return (Criteria) this;
        }

        public Criteria andRightsEndDateNotLike(String value) {
            addCriterion("RIGHTS_END_DATE not like", value, "rightsEndDate");
            return (Criteria) this;
        }

        public Criteria andRightsEndDateIn(List<String> values) {
            addCriterion("RIGHTS_END_DATE in", values, "rightsEndDate");
            return (Criteria) this;
        }

        public Criteria andRightsEndDateNotIn(List<String> values) {
            addCriterion("RIGHTS_END_DATE not in", values, "rightsEndDate");
            return (Criteria) this;
        }

        public Criteria andRightsEndDateBetween(String value1, String value2) {
            addCriterion("RIGHTS_END_DATE between", value1, value2, "rightsEndDate");
            return (Criteria) this;
        }

        public Criteria andRightsEndDateNotBetween(String value1, String value2) {
            addCriterion("RIGHTS_END_DATE not between", value1, value2, "rightsEndDate");
            return (Criteria) this;
        }

        public Criteria andRightsNumIsNull() {
            addCriterion("RIGHTS_NUM is null");
            return (Criteria) this;
        }

        public Criteria andRightsNumIsNotNull() {
            addCriterion("RIGHTS_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andRightsNumEqualTo(Integer value) {
            addCriterion("RIGHTS_NUM =", value, "rightsNum");
            return (Criteria) this;
        }

        public Criteria andRightsNumNotEqualTo(Integer value) {
            addCriterion("RIGHTS_NUM <>", value, "rightsNum");
            return (Criteria) this;
        }

        public Criteria andRightsNumGreaterThan(Integer value) {
            addCriterion("RIGHTS_NUM >", value, "rightsNum");
            return (Criteria) this;
        }

        public Criteria andRightsNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("RIGHTS_NUM >=", value, "rightsNum");
            return (Criteria) this;
        }

        public Criteria andRightsNumLessThan(Integer value) {
            addCriterion("RIGHTS_NUM <", value, "rightsNum");
            return (Criteria) this;
        }

        public Criteria andRightsNumLessThanOrEqualTo(Integer value) {
            addCriterion("RIGHTS_NUM <=", value, "rightsNum");
            return (Criteria) this;
        }

        public Criteria andRightsNumIn(List<Integer> values) {
            addCriterion("RIGHTS_NUM in", values, "rightsNum");
            return (Criteria) this;
        }

        public Criteria andRightsNumNotIn(List<Integer> values) {
            addCriterion("RIGHTS_NUM not in", values, "rightsNum");
            return (Criteria) this;
        }

        public Criteria andRightsNumBetween(Integer value1, Integer value2) {
            addCriterion("RIGHTS_NUM between", value1, value2, "rightsNum");
            return (Criteria) this;
        }

        public Criteria andRightsNumNotBetween(Integer value1, Integer value2) {
            addCriterion("RIGHTS_NUM not between", value1, value2, "rightsNum");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeIsNull() {
            addCriterion("RECEIVE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeIsNotNull() {
            addCriterion("RECEIVE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeEqualTo(Date value) {
            addCriterion("RECEIVE_TIME =", value, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeNotEqualTo(Date value) {
            addCriterion("RECEIVE_TIME <>", value, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeGreaterThan(Date value) {
            addCriterion("RECEIVE_TIME >", value, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("RECEIVE_TIME >=", value, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeLessThan(Date value) {
            addCriterion("RECEIVE_TIME <", value, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeLessThanOrEqualTo(Date value) {
            addCriterion("RECEIVE_TIME <=", value, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeIn(List<Date> values) {
            addCriterion("RECEIVE_TIME in", values, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeNotIn(List<Date> values) {
            addCriterion("RECEIVE_TIME not in", values, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeBetween(Date value1, Date value2) {
            addCriterion("RECEIVE_TIME between", value1, value2, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeNotBetween(Date value1, Date value2) {
            addCriterion("RECEIVE_TIME not between", value1, value2, "receiveTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private final String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private final String typeHandler;

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