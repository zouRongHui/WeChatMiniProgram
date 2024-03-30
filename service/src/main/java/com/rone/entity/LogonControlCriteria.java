package com.rone.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LogonControlCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LogonControlCriteria() {
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

        public Criteria andWlcLogonSeqIsNull() {
            addCriterion("WLC_LOGON_SEQ is null");
            return (Criteria) this;
        }

        public Criteria andWlcLogonSeqIsNotNull() {
            addCriterion("WLC_LOGON_SEQ is not null");
            return (Criteria) this;
        }

        public Criteria andWlcLogonSeqEqualTo(String value) {
            addCriterion("WLC_LOGON_SEQ =", value, "wlcLogonSeq");
            return (Criteria) this;
        }

        public Criteria andWlcLogonSeqNotEqualTo(String value) {
            addCriterion("WLC_LOGON_SEQ <>", value, "wlcLogonSeq");
            return (Criteria) this;
        }

        public Criteria andWlcLogonSeqGreaterThan(String value) {
            addCriterion("WLC_LOGON_SEQ >", value, "wlcLogonSeq");
            return (Criteria) this;
        }

        public Criteria andWlcLogonSeqGreaterThanOrEqualTo(String value) {
            addCriterion("WLC_LOGON_SEQ >=", value, "wlcLogonSeq");
            return (Criteria) this;
        }

        public Criteria andWlcLogonSeqLessThan(String value) {
            addCriterion("WLC_LOGON_SEQ <", value, "wlcLogonSeq");
            return (Criteria) this;
        }

        public Criteria andWlcLogonSeqLessThanOrEqualTo(String value) {
            addCriterion("WLC_LOGON_SEQ <=", value, "wlcLogonSeq");
            return (Criteria) this;
        }

        public Criteria andWlcLogonSeqLike(String value) {
            addCriterion("WLC_LOGON_SEQ like", value, "wlcLogonSeq");
            return (Criteria) this;
        }

        public Criteria andWlcLogonSeqNotLike(String value) {
            addCriterion("WLC_LOGON_SEQ not like", value, "wlcLogonSeq");
            return (Criteria) this;
        }

        public Criteria andWlcLogonSeqIn(List<String> values) {
            addCriterion("WLC_LOGON_SEQ in", values, "wlcLogonSeq");
            return (Criteria) this;
        }

        public Criteria andWlcLogonSeqNotIn(List<String> values) {
            addCriterion("WLC_LOGON_SEQ not in", values, "wlcLogonSeq");
            return (Criteria) this;
        }

        public Criteria andWlcLogonSeqBetween(String value1, String value2) {
            addCriterion("WLC_LOGON_SEQ between", value1, value2, "wlcLogonSeq");
            return (Criteria) this;
        }

        public Criteria andWlcLogonSeqNotBetween(String value1, String value2) {
            addCriterion("WLC_LOGON_SEQ not between", value1, value2, "wlcLogonSeq");
            return (Criteria) this;
        }

        public Criteria andWlcCustNoIsNull() {
            addCriterion("WLC_CUST_NO is null");
            return (Criteria) this;
        }

        public Criteria andWlcCustNoIsNotNull() {
            addCriterion("WLC_CUST_NO is not null");
            return (Criteria) this;
        }

        public Criteria andWlcCustNoEqualTo(String value) {
            addCriterion("WLC_CUST_NO =", value, "wlcCustNo");
            return (Criteria) this;
        }

        public Criteria andWlcCustNoNotEqualTo(String value) {
            addCriterion("WLC_CUST_NO <>", value, "wlcCustNo");
            return (Criteria) this;
        }

        public Criteria andWlcCustNoGreaterThan(String value) {
            addCriterion("WLC_CUST_NO >", value, "wlcCustNo");
            return (Criteria) this;
        }

        public Criteria andWlcCustNoGreaterThanOrEqualTo(String value) {
            addCriterion("WLC_CUST_NO >=", value, "wlcCustNo");
            return (Criteria) this;
        }

        public Criteria andWlcCustNoLessThan(String value) {
            addCriterion("WLC_CUST_NO <", value, "wlcCustNo");
            return (Criteria) this;
        }

        public Criteria andWlcCustNoLessThanOrEqualTo(String value) {
            addCriterion("WLC_CUST_NO <=", value, "wlcCustNo");
            return (Criteria) this;
        }

        public Criteria andWlcCustNoLike(String value) {
            addCriterion("WLC_CUST_NO like", value, "wlcCustNo");
            return (Criteria) this;
        }

        public Criteria andWlcCustNoNotLike(String value) {
            addCriterion("WLC_CUST_NO not like", value, "wlcCustNo");
            return (Criteria) this;
        }

        public Criteria andWlcCustNoIn(List<String> values) {
            addCriterion("WLC_CUST_NO in", values, "wlcCustNo");
            return (Criteria) this;
        }

        public Criteria andWlcCustNoNotIn(List<String> values) {
            addCriterion("WLC_CUST_NO not in", values, "wlcCustNo");
            return (Criteria) this;
        }

        public Criteria andWlcCustNoBetween(String value1, String value2) {
            addCriterion("WLC_CUST_NO between", value1, value2, "wlcCustNo");
            return (Criteria) this;
        }

        public Criteria andWlcCustNoNotBetween(String value1, String value2) {
            addCriterion("WLC_CUST_NO not between", value1, value2, "wlcCustNo");
            return (Criteria) this;
        }

        public Criteria andWlcLogonTypeIsNull() {
            addCriterion("WLC_LOGON_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andWlcLogonTypeIsNotNull() {
            addCriterion("WLC_LOGON_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andWlcLogonTypeEqualTo(String value) {
            addCriterion("WLC_LOGON_TYPE =", value, "wlcLogonType");
            return (Criteria) this;
        }

        public Criteria andWlcLogonTypeNotEqualTo(String value) {
            addCriterion("WLC_LOGON_TYPE <>", value, "wlcLogonType");
            return (Criteria) this;
        }

        public Criteria andWlcLogonTypeGreaterThan(String value) {
            addCriterion("WLC_LOGON_TYPE >", value, "wlcLogonType");
            return (Criteria) this;
        }

        public Criteria andWlcLogonTypeGreaterThanOrEqualTo(String value) {
            addCriterion("WLC_LOGON_TYPE >=", value, "wlcLogonType");
            return (Criteria) this;
        }

        public Criteria andWlcLogonTypeLessThan(String value) {
            addCriterion("WLC_LOGON_TYPE <", value, "wlcLogonType");
            return (Criteria) this;
        }

        public Criteria andWlcLogonTypeLessThanOrEqualTo(String value) {
            addCriterion("WLC_LOGON_TYPE <=", value, "wlcLogonType");
            return (Criteria) this;
        }

        public Criteria andWlcLogonTypeLike(String value) {
            addCriterion("WLC_LOGON_TYPE like", value, "wlcLogonType");
            return (Criteria) this;
        }

        public Criteria andWlcLogonTypeNotLike(String value) {
            addCriterion("WLC_LOGON_TYPE not like", value, "wlcLogonType");
            return (Criteria) this;
        }

        public Criteria andWlcLogonTypeIn(List<String> values) {
            addCriterion("WLC_LOGON_TYPE in", values, "wlcLogonType");
            return (Criteria) this;
        }

        public Criteria andWlcLogonTypeNotIn(List<String> values) {
            addCriterion("WLC_LOGON_TYPE not in", values, "wlcLogonType");
            return (Criteria) this;
        }

        public Criteria andWlcLogonTypeBetween(String value1, String value2) {
            addCriterion("WLC_LOGON_TYPE between", value1, value2, "wlcLogonType");
            return (Criteria) this;
        }

        public Criteria andWlcLogonTypeNotBetween(String value1, String value2) {
            addCriterion("WLC_LOGON_TYPE not between", value1, value2, "wlcLogonType");
            return (Criteria) this;
        }

        public Criteria andWlcOpenidIsNull() {
            addCriterion("WLC_OPENID is null");
            return (Criteria) this;
        }

        public Criteria andWlcOpenidIsNotNull() {
            addCriterion("WLC_OPENID is not null");
            return (Criteria) this;
        }

        public Criteria andWlcOpenidEqualTo(String value) {
            addCriterion("WLC_OPENID =", value, "wlcOpenid");
            return (Criteria) this;
        }

        public Criteria andWlcOpenidNotEqualTo(String value) {
            addCriterion("WLC_OPENID <>", value, "wlcOpenid");
            return (Criteria) this;
        }

        public Criteria andWlcOpenidGreaterThan(String value) {
            addCriterion("WLC_OPENID >", value, "wlcOpenid");
            return (Criteria) this;
        }

        public Criteria andWlcOpenidGreaterThanOrEqualTo(String value) {
            addCriterion("WLC_OPENID >=", value, "wlcOpenid");
            return (Criteria) this;
        }

        public Criteria andWlcOpenidLessThan(String value) {
            addCriterion("WLC_OPENID <", value, "wlcOpenid");
            return (Criteria) this;
        }

        public Criteria andWlcOpenidLessThanOrEqualTo(String value) {
            addCriterion("WLC_OPENID <=", value, "wlcOpenid");
            return (Criteria) this;
        }

        public Criteria andWlcOpenidLike(String value) {
            addCriterion("WLC_OPENID like", value, "wlcOpenid");
            return (Criteria) this;
        }

        public Criteria andWlcOpenidNotLike(String value) {
            addCriterion("WLC_OPENID not like", value, "wlcOpenid");
            return (Criteria) this;
        }

        public Criteria andWlcOpenidIn(List<String> values) {
            addCriterion("WLC_OPENID in", values, "wlcOpenid");
            return (Criteria) this;
        }

        public Criteria andWlcOpenidNotIn(List<String> values) {
            addCriterion("WLC_OPENID not in", values, "wlcOpenid");
            return (Criteria) this;
        }

        public Criteria andWlcOpenidBetween(String value1, String value2) {
            addCriterion("WLC_OPENID between", value1, value2, "wlcOpenid");
            return (Criteria) this;
        }

        public Criteria andWlcOpenidNotBetween(String value1, String value2) {
            addCriterion("WLC_OPENID not between", value1, value2, "wlcOpenid");
            return (Criteria) this;
        }

        public Criteria andWlcSessionKeyIsNull() {
            addCriterion("WLC_SESSION_KEY is null");
            return (Criteria) this;
        }

        public Criteria andWlcSessionKeyIsNotNull() {
            addCriterion("WLC_SESSION_KEY is not null");
            return (Criteria) this;
        }

        public Criteria andWlcSessionKeyEqualTo(String value) {
            addCriterion("WLC_SESSION_KEY =", value, "wlcSessionKey");
            return (Criteria) this;
        }

        public Criteria andWlcSessionKeyNotEqualTo(String value) {
            addCriterion("WLC_SESSION_KEY <>", value, "wlcSessionKey");
            return (Criteria) this;
        }

        public Criteria andWlcSessionKeyGreaterThan(String value) {
            addCriterion("WLC_SESSION_KEY >", value, "wlcSessionKey");
            return (Criteria) this;
        }

        public Criteria andWlcSessionKeyGreaterThanOrEqualTo(String value) {
            addCriterion("WLC_SESSION_KEY >=", value, "wlcSessionKey");
            return (Criteria) this;
        }

        public Criteria andWlcSessionKeyLessThan(String value) {
            addCriterion("WLC_SESSION_KEY <", value, "wlcSessionKey");
            return (Criteria) this;
        }

        public Criteria andWlcSessionKeyLessThanOrEqualTo(String value) {
            addCriterion("WLC_SESSION_KEY <=", value, "wlcSessionKey");
            return (Criteria) this;
        }

        public Criteria andWlcSessionKeyLike(String value) {
            addCriterion("WLC_SESSION_KEY like", value, "wlcSessionKey");
            return (Criteria) this;
        }

        public Criteria andWlcSessionKeyNotLike(String value) {
            addCriterion("WLC_SESSION_KEY not like", value, "wlcSessionKey");
            return (Criteria) this;
        }

        public Criteria andWlcSessionKeyIn(List<String> values) {
            addCriterion("WLC_SESSION_KEY in", values, "wlcSessionKey");
            return (Criteria) this;
        }

        public Criteria andWlcSessionKeyNotIn(List<String> values) {
            addCriterion("WLC_SESSION_KEY not in", values, "wlcSessionKey");
            return (Criteria) this;
        }

        public Criteria andWlcSessionKeyBetween(String value1, String value2) {
            addCriterion("WLC_SESSION_KEY between", value1, value2, "wlcSessionKey");
            return (Criteria) this;
        }

        public Criteria andWlcSessionKeyNotBetween(String value1, String value2) {
            addCriterion("WLC_SESSION_KEY not between", value1, value2, "wlcSessionKey");
            return (Criteria) this;
        }

        public Criteria andWlcSessionidIsNull() {
            addCriterion("WLC_SESSIONID is null");
            return (Criteria) this;
        }

        public Criteria andWlcSessionidIsNotNull() {
            addCriterion("WLC_SESSIONID is not null");
            return (Criteria) this;
        }

        public Criteria andWlcSessionidEqualTo(String value) {
            addCriterion("WLC_SESSIONID =", value, "wlcSessionid");
            return (Criteria) this;
        }

        public Criteria andWlcSessionidNotEqualTo(String value) {
            addCriterion("WLC_SESSIONID <>", value, "wlcSessionid");
            return (Criteria) this;
        }

        public Criteria andWlcSessionidGreaterThan(String value) {
            addCriterion("WLC_SESSIONID >", value, "wlcSessionid");
            return (Criteria) this;
        }

        public Criteria andWlcSessionidGreaterThanOrEqualTo(String value) {
            addCriterion("WLC_SESSIONID >=", value, "wlcSessionid");
            return (Criteria) this;
        }

        public Criteria andWlcSessionidLessThan(String value) {
            addCriterion("WLC_SESSIONID <", value, "wlcSessionid");
            return (Criteria) this;
        }

        public Criteria andWlcSessionidLessThanOrEqualTo(String value) {
            addCriterion("WLC_SESSIONID <=", value, "wlcSessionid");
            return (Criteria) this;
        }

        public Criteria andWlcSessionidLike(String value) {
            addCriterion("WLC_SESSIONID like", value, "wlcSessionid");
            return (Criteria) this;
        }

        public Criteria andWlcSessionidNotLike(String value) {
            addCriterion("WLC_SESSIONID not like", value, "wlcSessionid");
            return (Criteria) this;
        }

        public Criteria andWlcSessionidIn(List<String> values) {
            addCriterion("WLC_SESSIONID in", values, "wlcSessionid");
            return (Criteria) this;
        }

        public Criteria andWlcSessionidNotIn(List<String> values) {
            addCriterion("WLC_SESSIONID not in", values, "wlcSessionid");
            return (Criteria) this;
        }

        public Criteria andWlcSessionidBetween(String value1, String value2) {
            addCriterion("WLC_SESSIONID between", value1, value2, "wlcSessionid");
            return (Criteria) this;
        }

        public Criteria andWlcSessionidNotBetween(String value1, String value2) {
            addCriterion("WLC_SESSIONID not between", value1, value2, "wlcSessionid");
            return (Criteria) this;
        }

        public Criteria andWlcLogonTimeIsNull() {
            addCriterion("WLC_LOGON_TIME is null");
            return (Criteria) this;
        }

        public Criteria andWlcLogonTimeIsNotNull() {
            addCriterion("WLC_LOGON_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andWlcLogonTimeEqualTo(Date value) {
            addCriterion("WLC_LOGON_TIME =", value, "wlcLogonTime");
            return (Criteria) this;
        }

        public Criteria andWlcLogonTimeNotEqualTo(Date value) {
            addCriterion("WLC_LOGON_TIME <>", value, "wlcLogonTime");
            return (Criteria) this;
        }

        public Criteria andWlcLogonTimeGreaterThan(Date value) {
            addCriterion("WLC_LOGON_TIME >", value, "wlcLogonTime");
            return (Criteria) this;
        }

        public Criteria andWlcLogonTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("WLC_LOGON_TIME >=", value, "wlcLogonTime");
            return (Criteria) this;
        }

        public Criteria andWlcLogonTimeLessThan(Date value) {
            addCriterion("WLC_LOGON_TIME <", value, "wlcLogonTime");
            return (Criteria) this;
        }

        public Criteria andWlcLogonTimeLessThanOrEqualTo(Date value) {
            addCriterion("WLC_LOGON_TIME <=", value, "wlcLogonTime");
            return (Criteria) this;
        }

        public Criteria andWlcLogonTimeIn(List<Date> values) {
            addCriterion("WLC_LOGON_TIME in", values, "wlcLogonTime");
            return (Criteria) this;
        }

        public Criteria andWlcLogonTimeNotIn(List<Date> values) {
            addCriterion("WLC_LOGON_TIME not in", values, "wlcLogonTime");
            return (Criteria) this;
        }

        public Criteria andWlcLogonTimeBetween(Date value1, Date value2) {
            addCriterion("WLC_LOGON_TIME between", value1, value2, "wlcLogonTime");
            return (Criteria) this;
        }

        public Criteria andWlcLogonTimeNotBetween(Date value1, Date value2) {
            addCriterion("WLC_LOGON_TIME not between", value1, value2, "wlcLogonTime");
            return (Criteria) this;
        }

        public Criteria andWlcLogonIpIsNull() {
            addCriterion("WLC_LOGON_IP is null");
            return (Criteria) this;
        }

        public Criteria andWlcLogonIpIsNotNull() {
            addCriterion("WLC_LOGON_IP is not null");
            return (Criteria) this;
        }

        public Criteria andWlcLogonIpEqualTo(String value) {
            addCriterion("WLC_LOGON_IP =", value, "wlcLogonIp");
            return (Criteria) this;
        }

        public Criteria andWlcLogonIpNotEqualTo(String value) {
            addCriterion("WLC_LOGON_IP <>", value, "wlcLogonIp");
            return (Criteria) this;
        }

        public Criteria andWlcLogonIpGreaterThan(String value) {
            addCriterion("WLC_LOGON_IP >", value, "wlcLogonIp");
            return (Criteria) this;
        }

        public Criteria andWlcLogonIpGreaterThanOrEqualTo(String value) {
            addCriterion("WLC_LOGON_IP >=", value, "wlcLogonIp");
            return (Criteria) this;
        }

        public Criteria andWlcLogonIpLessThan(String value) {
            addCriterion("WLC_LOGON_IP <", value, "wlcLogonIp");
            return (Criteria) this;
        }

        public Criteria andWlcLogonIpLessThanOrEqualTo(String value) {
            addCriterion("WLC_LOGON_IP <=", value, "wlcLogonIp");
            return (Criteria) this;
        }

        public Criteria andWlcLogonIpLike(String value) {
            addCriterion("WLC_LOGON_IP like", value, "wlcLogonIp");
            return (Criteria) this;
        }

        public Criteria andWlcLogonIpNotLike(String value) {
            addCriterion("WLC_LOGON_IP not like", value, "wlcLogonIp");
            return (Criteria) this;
        }

        public Criteria andWlcLogonIpIn(List<String> values) {
            addCriterion("WLC_LOGON_IP in", values, "wlcLogonIp");
            return (Criteria) this;
        }

        public Criteria andWlcLogonIpNotIn(List<String> values) {
            addCriterion("WLC_LOGON_IP not in", values, "wlcLogonIp");
            return (Criteria) this;
        }

        public Criteria andWlcLogonIpBetween(String value1, String value2) {
            addCriterion("WLC_LOGON_IP between", value1, value2, "wlcLogonIp");
            return (Criteria) this;
        }

        public Criteria andWlcLogonIpNotBetween(String value1, String value2) {
            addCriterion("WLC_LOGON_IP not between", value1, value2, "wlcLogonIp");
            return (Criteria) this;
        }

        public Criteria andWlcLastLogonTimeIsNull() {
            addCriterion("WLC_LAST_LOGON_TIME is null");
            return (Criteria) this;
        }

        public Criteria andWlcLastLogonTimeIsNotNull() {
            addCriterion("WLC_LAST_LOGON_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andWlcLastLogonTimeEqualTo(Date value) {
            addCriterion("WLC_LAST_LOGON_TIME =", value, "wlcLastLogonTime");
            return (Criteria) this;
        }

        public Criteria andWlcLastLogonTimeNotEqualTo(Date value) {
            addCriterion("WLC_LAST_LOGON_TIME <>", value, "wlcLastLogonTime");
            return (Criteria) this;
        }

        public Criteria andWlcLastLogonTimeGreaterThan(Date value) {
            addCriterion("WLC_LAST_LOGON_TIME >", value, "wlcLastLogonTime");
            return (Criteria) this;
        }

        public Criteria andWlcLastLogonTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("WLC_LAST_LOGON_TIME >=", value, "wlcLastLogonTime");
            return (Criteria) this;
        }

        public Criteria andWlcLastLogonTimeLessThan(Date value) {
            addCriterion("WLC_LAST_LOGON_TIME <", value, "wlcLastLogonTime");
            return (Criteria) this;
        }

        public Criteria andWlcLastLogonTimeLessThanOrEqualTo(Date value) {
            addCriterion("WLC_LAST_LOGON_TIME <=", value, "wlcLastLogonTime");
            return (Criteria) this;
        }

        public Criteria andWlcLastLogonTimeIn(List<Date> values) {
            addCriterion("WLC_LAST_LOGON_TIME in", values, "wlcLastLogonTime");
            return (Criteria) this;
        }

        public Criteria andWlcLastLogonTimeNotIn(List<Date> values) {
            addCriterion("WLC_LAST_LOGON_TIME not in", values, "wlcLastLogonTime");
            return (Criteria) this;
        }

        public Criteria andWlcLastLogonTimeBetween(Date value1, Date value2) {
            addCriterion("WLC_LAST_LOGON_TIME between", value1, value2, "wlcLastLogonTime");
            return (Criteria) this;
        }

        public Criteria andWlcLastLogonTimeNotBetween(Date value1, Date value2) {
            addCriterion("WLC_LAST_LOGON_TIME not between", value1, value2, "wlcLastLogonTime");
            return (Criteria) this;
        }

        public Criteria andWlcLastLogonIpIsNull() {
            addCriterion("WLC_LAST_LOGON_IP is null");
            return (Criteria) this;
        }

        public Criteria andWlcLastLogonIpIsNotNull() {
            addCriterion("WLC_LAST_LOGON_IP is not null");
            return (Criteria) this;
        }

        public Criteria andWlcLastLogonIpEqualTo(String value) {
            addCriterion("WLC_LAST_LOGON_IP =", value, "wlcLastLogonIp");
            return (Criteria) this;
        }

        public Criteria andWlcLastLogonIpNotEqualTo(String value) {
            addCriterion("WLC_LAST_LOGON_IP <>", value, "wlcLastLogonIp");
            return (Criteria) this;
        }

        public Criteria andWlcLastLogonIpGreaterThan(String value) {
            addCriterion("WLC_LAST_LOGON_IP >", value, "wlcLastLogonIp");
            return (Criteria) this;
        }

        public Criteria andWlcLastLogonIpGreaterThanOrEqualTo(String value) {
            addCriterion("WLC_LAST_LOGON_IP >=", value, "wlcLastLogonIp");
            return (Criteria) this;
        }

        public Criteria andWlcLastLogonIpLessThan(String value) {
            addCriterion("WLC_LAST_LOGON_IP <", value, "wlcLastLogonIp");
            return (Criteria) this;
        }

        public Criteria andWlcLastLogonIpLessThanOrEqualTo(String value) {
            addCriterion("WLC_LAST_LOGON_IP <=", value, "wlcLastLogonIp");
            return (Criteria) this;
        }

        public Criteria andWlcLastLogonIpLike(String value) {
            addCriterion("WLC_LAST_LOGON_IP like", value, "wlcLastLogonIp");
            return (Criteria) this;
        }

        public Criteria andWlcLastLogonIpNotLike(String value) {
            addCriterion("WLC_LAST_LOGON_IP not like", value, "wlcLastLogonIp");
            return (Criteria) this;
        }

        public Criteria andWlcLastLogonIpIn(List<String> values) {
            addCriterion("WLC_LAST_LOGON_IP in", values, "wlcLastLogonIp");
            return (Criteria) this;
        }

        public Criteria andWlcLastLogonIpNotIn(List<String> values) {
            addCriterion("WLC_LAST_LOGON_IP not in", values, "wlcLastLogonIp");
            return (Criteria) this;
        }

        public Criteria andWlcLastLogonIpBetween(String value1, String value2) {
            addCriterion("WLC_LAST_LOGON_IP between", value1, value2, "wlcLastLogonIp");
            return (Criteria) this;
        }

        public Criteria andWlcLastLogonIpNotBetween(String value1, String value2) {
            addCriterion("WLC_LAST_LOGON_IP not between", value1, value2, "wlcLastLogonIp");
            return (Criteria) this;
        }

        public Criteria andWlcLogonStatusIsNull() {
            addCriterion("WLC_LOGON_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andWlcLogonStatusIsNotNull() {
            addCriterion("WLC_LOGON_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andWlcLogonStatusEqualTo(String value) {
            addCriterion("WLC_LOGON_STATUS =", value, "wlcLogonStatus");
            return (Criteria) this;
        }

        public Criteria andWlcLogonStatusNotEqualTo(String value) {
            addCriterion("WLC_LOGON_STATUS <>", value, "wlcLogonStatus");
            return (Criteria) this;
        }

        public Criteria andWlcLogonStatusGreaterThan(String value) {
            addCriterion("WLC_LOGON_STATUS >", value, "wlcLogonStatus");
            return (Criteria) this;
        }

        public Criteria andWlcLogonStatusGreaterThanOrEqualTo(String value) {
            addCriterion("WLC_LOGON_STATUS >=", value, "wlcLogonStatus");
            return (Criteria) this;
        }

        public Criteria andWlcLogonStatusLessThan(String value) {
            addCriterion("WLC_LOGON_STATUS <", value, "wlcLogonStatus");
            return (Criteria) this;
        }

        public Criteria andWlcLogonStatusLessThanOrEqualTo(String value) {
            addCriterion("WLC_LOGON_STATUS <=", value, "wlcLogonStatus");
            return (Criteria) this;
        }

        public Criteria andWlcLogonStatusLike(String value) {
            addCriterion("WLC_LOGON_STATUS like", value, "wlcLogonStatus");
            return (Criteria) this;
        }

        public Criteria andWlcLogonStatusNotLike(String value) {
            addCriterion("WLC_LOGON_STATUS not like", value, "wlcLogonStatus");
            return (Criteria) this;
        }

        public Criteria andWlcLogonStatusIn(List<String> values) {
            addCriterion("WLC_LOGON_STATUS in", values, "wlcLogonStatus");
            return (Criteria) this;
        }

        public Criteria andWlcLogonStatusNotIn(List<String> values) {
            addCriterion("WLC_LOGON_STATUS not in", values, "wlcLogonStatus");
            return (Criteria) this;
        }

        public Criteria andWlcLogonStatusBetween(String value1, String value2) {
            addCriterion("WLC_LOGON_STATUS between", value1, value2, "wlcLogonStatus");
            return (Criteria) this;
        }

        public Criteria andWlcLogonStatusNotBetween(String value1, String value2) {
            addCriterion("WLC_LOGON_STATUS not between", value1, value2, "wlcLogonStatus");
            return (Criteria) this;
        }

        public Criteria andWlcFailMsgIsNull() {
            addCriterion("WLC_FAIL_MSG is null");
            return (Criteria) this;
        }

        public Criteria andWlcFailMsgIsNotNull() {
            addCriterion("WLC_FAIL_MSG is not null");
            return (Criteria) this;
        }

        public Criteria andWlcFailMsgEqualTo(String value) {
            addCriterion("WLC_FAIL_MSG =", value, "wlcFailMsg");
            return (Criteria) this;
        }

        public Criteria andWlcFailMsgNotEqualTo(String value) {
            addCriterion("WLC_FAIL_MSG <>", value, "wlcFailMsg");
            return (Criteria) this;
        }

        public Criteria andWlcFailMsgGreaterThan(String value) {
            addCriterion("WLC_FAIL_MSG >", value, "wlcFailMsg");
            return (Criteria) this;
        }

        public Criteria andWlcFailMsgGreaterThanOrEqualTo(String value) {
            addCriterion("WLC_FAIL_MSG >=", value, "wlcFailMsg");
            return (Criteria) this;
        }

        public Criteria andWlcFailMsgLessThan(String value) {
            addCriterion("WLC_FAIL_MSG <", value, "wlcFailMsg");
            return (Criteria) this;
        }

        public Criteria andWlcFailMsgLessThanOrEqualTo(String value) {
            addCriterion("WLC_FAIL_MSG <=", value, "wlcFailMsg");
            return (Criteria) this;
        }

        public Criteria andWlcFailMsgLike(String value) {
            addCriterion("WLC_FAIL_MSG like", value, "wlcFailMsg");
            return (Criteria) this;
        }

        public Criteria andWlcFailMsgNotLike(String value) {
            addCriterion("WLC_FAIL_MSG not like", value, "wlcFailMsg");
            return (Criteria) this;
        }

        public Criteria andWlcFailMsgIn(List<String> values) {
            addCriterion("WLC_FAIL_MSG in", values, "wlcFailMsg");
            return (Criteria) this;
        }

        public Criteria andWlcFailMsgNotIn(List<String> values) {
            addCriterion("WLC_FAIL_MSG not in", values, "wlcFailMsg");
            return (Criteria) this;
        }

        public Criteria andWlcFailMsgBetween(String value1, String value2) {
            addCriterion("WLC_FAIL_MSG between", value1, value2, "wlcFailMsg");
            return (Criteria) this;
        }

        public Criteria andWlcFailMsgNotBetween(String value1, String value2) {
            addCriterion("WLC_FAIL_MSG not between", value1, value2, "wlcFailMsg");
            return (Criteria) this;
        }

        public Criteria andWlcDayFailTimesIsNull() {
            addCriterion("WLC_DAY_FAIL_TIMES is null");
            return (Criteria) this;
        }

        public Criteria andWlcDayFailTimesIsNotNull() {
            addCriterion("WLC_DAY_FAIL_TIMES is not null");
            return (Criteria) this;
        }

        public Criteria andWlcDayFailTimesEqualTo(Long value) {
            addCriterion("WLC_DAY_FAIL_TIMES =", value, "wlcDayFailTimes");
            return (Criteria) this;
        }

        public Criteria andWlcDayFailTimesNotEqualTo(Long value) {
            addCriterion("WLC_DAY_FAIL_TIMES <>", value, "wlcDayFailTimes");
            return (Criteria) this;
        }

        public Criteria andWlcDayFailTimesGreaterThan(Long value) {
            addCriterion("WLC_DAY_FAIL_TIMES >", value, "wlcDayFailTimes");
            return (Criteria) this;
        }

        public Criteria andWlcDayFailTimesGreaterThanOrEqualTo(Long value) {
            addCriterion("WLC_DAY_FAIL_TIMES >=", value, "wlcDayFailTimes");
            return (Criteria) this;
        }

        public Criteria andWlcDayFailTimesLessThan(Long value) {
            addCriterion("WLC_DAY_FAIL_TIMES <", value, "wlcDayFailTimes");
            return (Criteria) this;
        }

        public Criteria andWlcDayFailTimesLessThanOrEqualTo(Long value) {
            addCriterion("WLC_DAY_FAIL_TIMES <=", value, "wlcDayFailTimes");
            return (Criteria) this;
        }

        public Criteria andWlcDayFailTimesIn(List<Long> values) {
            addCriterion("WLC_DAY_FAIL_TIMES in", values, "wlcDayFailTimes");
            return (Criteria) this;
        }

        public Criteria andWlcDayFailTimesNotIn(List<Long> values) {
            addCriterion("WLC_DAY_FAIL_TIMES not in", values, "wlcDayFailTimes");
            return (Criteria) this;
        }

        public Criteria andWlcDayFailTimesBetween(Long value1, Long value2) {
            addCriterion("WLC_DAY_FAIL_TIMES between", value1, value2, "wlcDayFailTimes");
            return (Criteria) this;
        }

        public Criteria andWlcDayFailTimesNotBetween(Long value1, Long value2) {
            addCriterion("WLC_DAY_FAIL_TIMES not between", value1, value2, "wlcDayFailTimes");
            return (Criteria) this;
        }

        public Criteria andWlcTotalFailTimesIsNull() {
            addCriterion("WLC_TOTAL_FAIL_TIMES is null");
            return (Criteria) this;
        }

        public Criteria andWlcTotalFailTimesIsNotNull() {
            addCriterion("WLC_TOTAL_FAIL_TIMES is not null");
            return (Criteria) this;
        }

        public Criteria andWlcTotalFailTimesEqualTo(Long value) {
            addCriterion("WLC_TOTAL_FAIL_TIMES =", value, "wlcTotalFailTimes");
            return (Criteria) this;
        }

        public Criteria andWlcTotalFailTimesNotEqualTo(Long value) {
            addCriterion("WLC_TOTAL_FAIL_TIMES <>", value, "wlcTotalFailTimes");
            return (Criteria) this;
        }

        public Criteria andWlcTotalFailTimesGreaterThan(Long value) {
            addCriterion("WLC_TOTAL_FAIL_TIMES >", value, "wlcTotalFailTimes");
            return (Criteria) this;
        }

        public Criteria andWlcTotalFailTimesGreaterThanOrEqualTo(Long value) {
            addCriterion("WLC_TOTAL_FAIL_TIMES >=", value, "wlcTotalFailTimes");
            return (Criteria) this;
        }

        public Criteria andWlcTotalFailTimesLessThan(Long value) {
            addCriterion("WLC_TOTAL_FAIL_TIMES <", value, "wlcTotalFailTimes");
            return (Criteria) this;
        }

        public Criteria andWlcTotalFailTimesLessThanOrEqualTo(Long value) {
            addCriterion("WLC_TOTAL_FAIL_TIMES <=", value, "wlcTotalFailTimes");
            return (Criteria) this;
        }

        public Criteria andWlcTotalFailTimesIn(List<Long> values) {
            addCriterion("WLC_TOTAL_FAIL_TIMES in", values, "wlcTotalFailTimes");
            return (Criteria) this;
        }

        public Criteria andWlcTotalFailTimesNotIn(List<Long> values) {
            addCriterion("WLC_TOTAL_FAIL_TIMES not in", values, "wlcTotalFailTimes");
            return (Criteria) this;
        }

        public Criteria andWlcTotalFailTimesBetween(Long value1, Long value2) {
            addCriterion("WLC_TOTAL_FAIL_TIMES between", value1, value2, "wlcTotalFailTimes");
            return (Criteria) this;
        }

        public Criteria andWlcTotalFailTimesNotBetween(Long value1, Long value2) {
            addCriterion("WLC_TOTAL_FAIL_TIMES not between", value1, value2, "wlcTotalFailTimes");
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