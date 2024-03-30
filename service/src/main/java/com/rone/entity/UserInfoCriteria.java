package com.rone.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserInfoCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserInfoCriteria() {
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

        public Criteria andWuiCustNoIsNull() {
            addCriterion("WUI_CUST_NO is null");
            return (Criteria) this;
        }

        public Criteria andWuiCustNoIsNotNull() {
            addCriterion("WUI_CUST_NO is not null");
            return (Criteria) this;
        }

        public Criteria andWuiCustNoEqualTo(String value) {
            addCriterion("WUI_CUST_NO =", value, "wuiCustNo");
            return (Criteria) this;
        }

        public Criteria andWuiCustNoNotEqualTo(String value) {
            addCriterion("WUI_CUST_NO <>", value, "wuiCustNo");
            return (Criteria) this;
        }

        public Criteria andWuiCustNoGreaterThan(String value) {
            addCriterion("WUI_CUST_NO >", value, "wuiCustNo");
            return (Criteria) this;
        }

        public Criteria andWuiCustNoGreaterThanOrEqualTo(String value) {
            addCriterion("WUI_CUST_NO >=", value, "wuiCustNo");
            return (Criteria) this;
        }

        public Criteria andWuiCustNoLessThan(String value) {
            addCriterion("WUI_CUST_NO <", value, "wuiCustNo");
            return (Criteria) this;
        }

        public Criteria andWuiCustNoLessThanOrEqualTo(String value) {
            addCriterion("WUI_CUST_NO <=", value, "wuiCustNo");
            return (Criteria) this;
        }

        public Criteria andWuiCustNoLike(String value) {
            addCriterion("WUI_CUST_NO like", value, "wuiCustNo");
            return (Criteria) this;
        }

        public Criteria andWuiCustNoNotLike(String value) {
            addCriterion("WUI_CUST_NO not like", value, "wuiCustNo");
            return (Criteria) this;
        }

        public Criteria andWuiCustNoIn(List<String> values) {
            addCriterion("WUI_CUST_NO in", values, "wuiCustNo");
            return (Criteria) this;
        }

        public Criteria andWuiCustNoNotIn(List<String> values) {
            addCriterion("WUI_CUST_NO not in", values, "wuiCustNo");
            return (Criteria) this;
        }

        public Criteria andWuiCustNoBetween(String value1, String value2) {
            addCriterion("WUI_CUST_NO between", value1, value2, "wuiCustNo");
            return (Criteria) this;
        }

        public Criteria andWuiCustNoNotBetween(String value1, String value2) {
            addCriterion("WUI_CUST_NO not between", value1, value2, "wuiCustNo");
            return (Criteria) this;
        }

        public Criteria andWuiOpenidIsNull() {
            addCriterion("WUI_OPENID is null");
            return (Criteria) this;
        }

        public Criteria andWuiOpenidIsNotNull() {
            addCriterion("WUI_OPENID is not null");
            return (Criteria) this;
        }

        public Criteria andWuiOpenidEqualTo(String value) {
            addCriterion("WUI_OPENID =", value, "wuiOpenid");
            return (Criteria) this;
        }

        public Criteria andWuiOpenidNotEqualTo(String value) {
            addCriterion("WUI_OPENID <>", value, "wuiOpenid");
            return (Criteria) this;
        }

        public Criteria andWuiOpenidGreaterThan(String value) {
            addCriterion("WUI_OPENID >", value, "wuiOpenid");
            return (Criteria) this;
        }

        public Criteria andWuiOpenidGreaterThanOrEqualTo(String value) {
            addCriterion("WUI_OPENID >=", value, "wuiOpenid");
            return (Criteria) this;
        }

        public Criteria andWuiOpenidLessThan(String value) {
            addCriterion("WUI_OPENID <", value, "wuiOpenid");
            return (Criteria) this;
        }

        public Criteria andWuiOpenidLessThanOrEqualTo(String value) {
            addCriterion("WUI_OPENID <=", value, "wuiOpenid");
            return (Criteria) this;
        }

        public Criteria andWuiOpenidLike(String value) {
            addCriterion("WUI_OPENID like", value, "wuiOpenid");
            return (Criteria) this;
        }

        public Criteria andWuiOpenidNotLike(String value) {
            addCriterion("WUI_OPENID not like", value, "wuiOpenid");
            return (Criteria) this;
        }

        public Criteria andWuiOpenidIn(List<String> values) {
            addCriterion("WUI_OPENID in", values, "wuiOpenid");
            return (Criteria) this;
        }

        public Criteria andWuiOpenidNotIn(List<String> values) {
            addCriterion("WUI_OPENID not in", values, "wuiOpenid");
            return (Criteria) this;
        }

        public Criteria andWuiOpenidBetween(String value1, String value2) {
            addCriterion("WUI_OPENID between", value1, value2, "wuiOpenid");
            return (Criteria) this;
        }

        public Criteria andWuiOpenidNotBetween(String value1, String value2) {
            addCriterion("WUI_OPENID not between", value1, value2, "wuiOpenid");
            return (Criteria) this;
        }

        public Criteria andWuiMobileNoIsNull() {
            addCriterion("WUI_MOBILE_NO is null");
            return (Criteria) this;
        }

        public Criteria andWuiMobileNoIsNotNull() {
            addCriterion("WUI_MOBILE_NO is not null");
            return (Criteria) this;
        }

        public Criteria andWuiMobileNoEqualTo(String value) {
            addCriterion("WUI_MOBILE_NO =", value, "wuiMobileNo");
            return (Criteria) this;
        }

        public Criteria andWuiMobileNoNotEqualTo(String value) {
            addCriterion("WUI_MOBILE_NO <>", value, "wuiMobileNo");
            return (Criteria) this;
        }

        public Criteria andWuiMobileNoGreaterThan(String value) {
            addCriterion("WUI_MOBILE_NO >", value, "wuiMobileNo");
            return (Criteria) this;
        }

        public Criteria andWuiMobileNoGreaterThanOrEqualTo(String value) {
            addCriterion("WUI_MOBILE_NO >=", value, "wuiMobileNo");
            return (Criteria) this;
        }

        public Criteria andWuiMobileNoLessThan(String value) {
            addCriterion("WUI_MOBILE_NO <", value, "wuiMobileNo");
            return (Criteria) this;
        }

        public Criteria andWuiMobileNoLessThanOrEqualTo(String value) {
            addCriterion("WUI_MOBILE_NO <=", value, "wuiMobileNo");
            return (Criteria) this;
        }

        public Criteria andWuiMobileNoLike(String value) {
            addCriterion("WUI_MOBILE_NO like", value, "wuiMobileNo");
            return (Criteria) this;
        }

        public Criteria andWuiMobileNoNotLike(String value) {
            addCriterion("WUI_MOBILE_NO not like", value, "wuiMobileNo");
            return (Criteria) this;
        }

        public Criteria andWuiMobileNoIn(List<String> values) {
            addCriterion("WUI_MOBILE_NO in", values, "wuiMobileNo");
            return (Criteria) this;
        }

        public Criteria andWuiMobileNoNotIn(List<String> values) {
            addCriterion("WUI_MOBILE_NO not in", values, "wuiMobileNo");
            return (Criteria) this;
        }

        public Criteria andWuiMobileNoBetween(String value1, String value2) {
            addCriterion("WUI_MOBILE_NO between", value1, value2, "wuiMobileNo");
            return (Criteria) this;
        }

        public Criteria andWuiMobileNoNotBetween(String value1, String value2) {
            addCriterion("WUI_MOBILE_NO not between", value1, value2, "wuiMobileNo");
            return (Criteria) this;
        }

        public Criteria andWuiStatusIsNull() {
            addCriterion("WUI_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andWuiStatusIsNotNull() {
            addCriterion("WUI_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andWuiStatusEqualTo(String value) {
            addCriterion("WUI_STATUS =", value, "wuiStatus");
            return (Criteria) this;
        }

        public Criteria andWuiStatusNotEqualTo(String value) {
            addCriterion("WUI_STATUS <>", value, "wuiStatus");
            return (Criteria) this;
        }

        public Criteria andWuiStatusGreaterThan(String value) {
            addCriterion("WUI_STATUS >", value, "wuiStatus");
            return (Criteria) this;
        }

        public Criteria andWuiStatusGreaterThanOrEqualTo(String value) {
            addCriterion("WUI_STATUS >=", value, "wuiStatus");
            return (Criteria) this;
        }

        public Criteria andWuiStatusLessThan(String value) {
            addCriterion("WUI_STATUS <", value, "wuiStatus");
            return (Criteria) this;
        }

        public Criteria andWuiStatusLessThanOrEqualTo(String value) {
            addCriterion("WUI_STATUS <=", value, "wuiStatus");
            return (Criteria) this;
        }

        public Criteria andWuiStatusLike(String value) {
            addCriterion("WUI_STATUS like", value, "wuiStatus");
            return (Criteria) this;
        }

        public Criteria andWuiStatusNotLike(String value) {
            addCriterion("WUI_STATUS not like", value, "wuiStatus");
            return (Criteria) this;
        }

        public Criteria andWuiStatusIn(List<String> values) {
            addCriterion("WUI_STATUS in", values, "wuiStatus");
            return (Criteria) this;
        }

        public Criteria andWuiStatusNotIn(List<String> values) {
            addCriterion("WUI_STATUS not in", values, "wuiStatus");
            return (Criteria) this;
        }

        public Criteria andWuiStatusBetween(String value1, String value2) {
            addCriterion("WUI_STATUS between", value1, value2, "wuiStatus");
            return (Criteria) this;
        }

        public Criteria andWuiStatusNotBetween(String value1, String value2) {
            addCriterion("WUI_STATUS not between", value1, value2, "wuiStatus");
            return (Criteria) this;
        }

        public Criteria andWuiRegisterTimeIsNull() {
            addCriterion("WUI_REGISTER_TIME is null");
            return (Criteria) this;
        }

        public Criteria andWuiRegisterTimeIsNotNull() {
            addCriterion("WUI_REGISTER_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andWuiRegisterTimeEqualTo(Date value) {
            addCriterion("WUI_REGISTER_TIME =", value, "wuiRegisterTime");
            return (Criteria) this;
        }

        public Criteria andWuiRegisterTimeNotEqualTo(Date value) {
            addCriterion("WUI_REGISTER_TIME <>", value, "wuiRegisterTime");
            return (Criteria) this;
        }

        public Criteria andWuiRegisterTimeGreaterThan(Date value) {
            addCriterion("WUI_REGISTER_TIME >", value, "wuiRegisterTime");
            return (Criteria) this;
        }

        public Criteria andWuiRegisterTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("WUI_REGISTER_TIME >=", value, "wuiRegisterTime");
            return (Criteria) this;
        }

        public Criteria andWuiRegisterTimeLessThan(Date value) {
            addCriterion("WUI_REGISTER_TIME <", value, "wuiRegisterTime");
            return (Criteria) this;
        }

        public Criteria andWuiRegisterTimeLessThanOrEqualTo(Date value) {
            addCriterion("WUI_REGISTER_TIME <=", value, "wuiRegisterTime");
            return (Criteria) this;
        }

        public Criteria andWuiRegisterTimeIn(List<Date> values) {
            addCriterion("WUI_REGISTER_TIME in", values, "wuiRegisterTime");
            return (Criteria) this;
        }

        public Criteria andWuiRegisterTimeNotIn(List<Date> values) {
            addCriterion("WUI_REGISTER_TIME not in", values, "wuiRegisterTime");
            return (Criteria) this;
        }

        public Criteria andWuiRegisterTimeBetween(Date value1, Date value2) {
            addCriterion("WUI_REGISTER_TIME between", value1, value2, "wuiRegisterTime");
            return (Criteria) this;
        }

        public Criteria andWuiRegisterTimeNotBetween(Date value1, Date value2) {
            addCriterion("WUI_REGISTER_TIME not between", value1, value2, "wuiRegisterTime");
            return (Criteria) this;
        }

        public Criteria andWuiUnionidIsNull() {
            addCriterion("WUI_UNIONID is null");
            return (Criteria) this;
        }

        public Criteria andWuiUnionidIsNotNull() {
            addCriterion("WUI_UNIONID is not null");
            return (Criteria) this;
        }

        public Criteria andWuiUnionidEqualTo(String value) {
            addCriterion("WUI_UNIONID =", value, "wuiUnionid");
            return (Criteria) this;
        }

        public Criteria andWuiUnionidNotEqualTo(String value) {
            addCriterion("WUI_UNIONID <>", value, "wuiUnionid");
            return (Criteria) this;
        }

        public Criteria andWuiUnionidGreaterThan(String value) {
            addCriterion("WUI_UNIONID >", value, "wuiUnionid");
            return (Criteria) this;
        }

        public Criteria andWuiUnionidGreaterThanOrEqualTo(String value) {
            addCriterion("WUI_UNIONID >=", value, "wuiUnionid");
            return (Criteria) this;
        }

        public Criteria andWuiUnionidLessThan(String value) {
            addCriterion("WUI_UNIONID <", value, "wuiUnionid");
            return (Criteria) this;
        }

        public Criteria andWuiUnionidLessThanOrEqualTo(String value) {
            addCriterion("WUI_UNIONID <=", value, "wuiUnionid");
            return (Criteria) this;
        }

        public Criteria andWuiUnionidLike(String value) {
            addCriterion("WUI_UNIONID like", value, "wuiUnionid");
            return (Criteria) this;
        }

        public Criteria andWuiUnionidNotLike(String value) {
            addCriterion("WUI_UNIONID not like", value, "wuiUnionid");
            return (Criteria) this;
        }

        public Criteria andWuiUnionidIn(List<String> values) {
            addCriterion("WUI_UNIONID in", values, "wuiUnionid");
            return (Criteria) this;
        }

        public Criteria andWuiUnionidNotIn(List<String> values) {
            addCriterion("WUI_UNIONID not in", values, "wuiUnionid");
            return (Criteria) this;
        }

        public Criteria andWuiUnionidBetween(String value1, String value2) {
            addCriterion("WUI_UNIONID between", value1, value2, "wuiUnionid");
            return (Criteria) this;
        }

        public Criteria andWuiUnionidNotBetween(String value1, String value2) {
            addCriterion("WUI_UNIONID not between", value1, value2, "wuiUnionid");
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