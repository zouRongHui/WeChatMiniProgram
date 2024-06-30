package com.rone.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RightsActivityCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RightsActivityCriteria() {
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

        public Criteria andImageBackgroundIsNull() {
            addCriterion("IMAGE_BACKGROUND is null");
            return (Criteria) this;
        }

        public Criteria andImageBackgroundIsNotNull() {
            addCriterion("IMAGE_BACKGROUND is not null");
            return (Criteria) this;
        }

        public Criteria andImageBackgroundEqualTo(String value) {
            addCriterion("IMAGE_BACKGROUND =", value, "imageBackground");
            return (Criteria) this;
        }

        public Criteria andImageBackgroundNotEqualTo(String value) {
            addCriterion("IMAGE_BACKGROUND <>", value, "imageBackground");
            return (Criteria) this;
        }

        public Criteria andImageBackgroundGreaterThan(String value) {
            addCriterion("IMAGE_BACKGROUND >", value, "imageBackground");
            return (Criteria) this;
        }

        public Criteria andImageBackgroundGreaterThanOrEqualTo(String value) {
            addCriterion("IMAGE_BACKGROUND >=", value, "imageBackground");
            return (Criteria) this;
        }

        public Criteria andImageBackgroundLessThan(String value) {
            addCriterion("IMAGE_BACKGROUND <", value, "imageBackground");
            return (Criteria) this;
        }

        public Criteria andImageBackgroundLessThanOrEqualTo(String value) {
            addCriterion("IMAGE_BACKGROUND <=", value, "imageBackground");
            return (Criteria) this;
        }

        public Criteria andImageBackgroundLike(String value) {
            addCriterion("IMAGE_BACKGROUND like", value, "imageBackground");
            return (Criteria) this;
        }

        public Criteria andImageBackgroundNotLike(String value) {
            addCriterion("IMAGE_BACKGROUND not like", value, "imageBackground");
            return (Criteria) this;
        }

        public Criteria andImageBackgroundIn(List<String> values) {
            addCriterion("IMAGE_BACKGROUND in", values, "imageBackground");
            return (Criteria) this;
        }

        public Criteria andImageBackgroundNotIn(List<String> values) {
            addCriterion("IMAGE_BACKGROUND not in", values, "imageBackground");
            return (Criteria) this;
        }

        public Criteria andImageBackgroundBetween(String value1, String value2) {
            addCriterion("IMAGE_BACKGROUND between", value1, value2, "imageBackground");
            return (Criteria) this;
        }

        public Criteria andImageBackgroundNotBetween(String value1, String value2) {
            addCriterion("IMAGE_BACKGROUND not between", value1, value2, "imageBackground");
            return (Criteria) this;
        }

        public Criteria andImageLogoIsNull() {
            addCriterion("IMAGE_LOGO is null");
            return (Criteria) this;
        }

        public Criteria andImageLogoIsNotNull() {
            addCriterion("IMAGE_LOGO is not null");
            return (Criteria) this;
        }

        public Criteria andImageLogoEqualTo(String value) {
            addCriterion("IMAGE_LOGO =", value, "imageLogo");
            return (Criteria) this;
        }

        public Criteria andImageLogoNotEqualTo(String value) {
            addCriterion("IMAGE_LOGO <>", value, "imageLogo");
            return (Criteria) this;
        }

        public Criteria andImageLogoGreaterThan(String value) {
            addCriterion("IMAGE_LOGO >", value, "imageLogo");
            return (Criteria) this;
        }

        public Criteria andImageLogoGreaterThanOrEqualTo(String value) {
            addCriterion("IMAGE_LOGO >=", value, "imageLogo");
            return (Criteria) this;
        }

        public Criteria andImageLogoLessThan(String value) {
            addCriterion("IMAGE_LOGO <", value, "imageLogo");
            return (Criteria) this;
        }

        public Criteria andImageLogoLessThanOrEqualTo(String value) {
            addCriterion("IMAGE_LOGO <=", value, "imageLogo");
            return (Criteria) this;
        }

        public Criteria andImageLogoLike(String value) {
            addCriterion("IMAGE_LOGO like", value, "imageLogo");
            return (Criteria) this;
        }

        public Criteria andImageLogoNotLike(String value) {
            addCriterion("IMAGE_LOGO not like", value, "imageLogo");
            return (Criteria) this;
        }

        public Criteria andImageLogoIn(List<String> values) {
            addCriterion("IMAGE_LOGO in", values, "imageLogo");
            return (Criteria) this;
        }

        public Criteria andImageLogoNotIn(List<String> values) {
            addCriterion("IMAGE_LOGO not in", values, "imageLogo");
            return (Criteria) this;
        }

        public Criteria andImageLogoBetween(String value1, String value2) {
            addCriterion("IMAGE_LOGO between", value1, value2, "imageLogo");
            return (Criteria) this;
        }

        public Criteria andImageLogoNotBetween(String value1, String value2) {
            addCriterion("IMAGE_LOGO not between", value1, value2, "imageLogo");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("TITLE is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("TITLE is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("TITLE =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("TITLE <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("TITLE >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("TITLE >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("TITLE <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("TITLE <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("TITLE like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("TITLE not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("TITLE in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("TITLE not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("TITLE between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("TITLE not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andSubtitleIsNull() {
            addCriterion("SUBTITLE is null");
            return (Criteria) this;
        }

        public Criteria andSubtitleIsNotNull() {
            addCriterion("SUBTITLE is not null");
            return (Criteria) this;
        }

        public Criteria andSubtitleEqualTo(String value) {
            addCriterion("SUBTITLE =", value, "subtitle");
            return (Criteria) this;
        }

        public Criteria andSubtitleNotEqualTo(String value) {
            addCriterion("SUBTITLE <>", value, "subtitle");
            return (Criteria) this;
        }

        public Criteria andSubtitleGreaterThan(String value) {
            addCriterion("SUBTITLE >", value, "subtitle");
            return (Criteria) this;
        }

        public Criteria andSubtitleGreaterThanOrEqualTo(String value) {
            addCriterion("SUBTITLE >=", value, "subtitle");
            return (Criteria) this;
        }

        public Criteria andSubtitleLessThan(String value) {
            addCriterion("SUBTITLE <", value, "subtitle");
            return (Criteria) this;
        }

        public Criteria andSubtitleLessThanOrEqualTo(String value) {
            addCriterion("SUBTITLE <=", value, "subtitle");
            return (Criteria) this;
        }

        public Criteria andSubtitleLike(String value) {
            addCriterion("SUBTITLE like", value, "subtitle");
            return (Criteria) this;
        }

        public Criteria andSubtitleNotLike(String value) {
            addCriterion("SUBTITLE not like", value, "subtitle");
            return (Criteria) this;
        }

        public Criteria andSubtitleIn(List<String> values) {
            addCriterion("SUBTITLE in", values, "subtitle");
            return (Criteria) this;
        }

        public Criteria andSubtitleNotIn(List<String> values) {
            addCriterion("SUBTITLE not in", values, "subtitle");
            return (Criteria) this;
        }

        public Criteria andSubtitleBetween(String value1, String value2) {
            addCriterion("SUBTITLE between", value1, value2, "subtitle");
            return (Criteria) this;
        }

        public Criteria andSubtitleNotBetween(String value1, String value2) {
            addCriterion("SUBTITLE not between", value1, value2, "subtitle");
            return (Criteria) this;
        }

        public Criteria andIntroduceIsNull() {
            addCriterion("INTRODUCE is null");
            return (Criteria) this;
        }

        public Criteria andIntroduceIsNotNull() {
            addCriterion("INTRODUCE is not null");
            return (Criteria) this;
        }

        public Criteria andIntroduceEqualTo(String value) {
            addCriterion("INTRODUCE =", value, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceNotEqualTo(String value) {
            addCriterion("INTRODUCE <>", value, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceGreaterThan(String value) {
            addCriterion("INTRODUCE >", value, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceGreaterThanOrEqualTo(String value) {
            addCriterion("INTRODUCE >=", value, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceLessThan(String value) {
            addCriterion("INTRODUCE <", value, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceLessThanOrEqualTo(String value) {
            addCriterion("INTRODUCE <=", value, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceLike(String value) {
            addCriterion("INTRODUCE like", value, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceNotLike(String value) {
            addCriterion("INTRODUCE not like", value, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceIn(List<String> values) {
            addCriterion("INTRODUCE in", values, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceNotIn(List<String> values) {
            addCriterion("INTRODUCE not in", values, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceBetween(String value1, String value2) {
            addCriterion("INTRODUCE between", value1, value2, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceNotBetween(String value1, String value2) {
            addCriterion("INTRODUCE not between", value1, value2, "introduce");
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

        public Criteria andReceiveTimesSingleIsNull() {
            addCriterion("RECEIVE_TIMES_SINGLE is null");
            return (Criteria) this;
        }

        public Criteria andReceiveTimesSingleIsNotNull() {
            addCriterion("RECEIVE_TIMES_SINGLE is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveTimesSingleEqualTo(Integer value) {
            addCriterion("RECEIVE_TIMES_SINGLE =", value, "receiveTimesSingle");
            return (Criteria) this;
        }

        public Criteria andReceiveTimesSingleNotEqualTo(Integer value) {
            addCriterion("RECEIVE_TIMES_SINGLE <>", value, "receiveTimesSingle");
            return (Criteria) this;
        }

        public Criteria andReceiveTimesSingleGreaterThan(Integer value) {
            addCriterion("RECEIVE_TIMES_SINGLE >", value, "receiveTimesSingle");
            return (Criteria) this;
        }

        public Criteria andReceiveTimesSingleGreaterThanOrEqualTo(Integer value) {
            addCriterion("RECEIVE_TIMES_SINGLE >=", value, "receiveTimesSingle");
            return (Criteria) this;
        }

        public Criteria andReceiveTimesSingleLessThan(Integer value) {
            addCriterion("RECEIVE_TIMES_SINGLE <", value, "receiveTimesSingle");
            return (Criteria) this;
        }

        public Criteria andReceiveTimesSingleLessThanOrEqualTo(Integer value) {
            addCriterion("RECEIVE_TIMES_SINGLE <=", value, "receiveTimesSingle");
            return (Criteria) this;
        }

        public Criteria andReceiveTimesSingleIn(List<Integer> values) {
            addCriterion("RECEIVE_TIMES_SINGLE in", values, "receiveTimesSingle");
            return (Criteria) this;
        }

        public Criteria andReceiveTimesSingleNotIn(List<Integer> values) {
            addCriterion("RECEIVE_TIMES_SINGLE not in", values, "receiveTimesSingle");
            return (Criteria) this;
        }

        public Criteria andReceiveTimesSingleBetween(Integer value1, Integer value2) {
            addCriterion("RECEIVE_TIMES_SINGLE between", value1, value2, "receiveTimesSingle");
            return (Criteria) this;
        }

        public Criteria andReceiveTimesSingleNotBetween(Integer value1, Integer value2) {
            addCriterion("RECEIVE_TIMES_SINGLE not between", value1, value2, "receiveTimesSingle");
            return (Criteria) this;
        }

        public Criteria andReceiveTimesTotalIsNull() {
            addCriterion("RECEIVE_TIMES_TOTAL is null");
            return (Criteria) this;
        }

        public Criteria andReceiveTimesTotalIsNotNull() {
            addCriterion("RECEIVE_TIMES_TOTAL is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveTimesTotalEqualTo(Integer value) {
            addCriterion("RECEIVE_TIMES_TOTAL =", value, "receiveTimesTotal");
            return (Criteria) this;
        }

        public Criteria andReceiveTimesTotalNotEqualTo(Integer value) {
            addCriterion("RECEIVE_TIMES_TOTAL <>", value, "receiveTimesTotal");
            return (Criteria) this;
        }

        public Criteria andReceiveTimesTotalGreaterThan(Integer value) {
            addCriterion("RECEIVE_TIMES_TOTAL >", value, "receiveTimesTotal");
            return (Criteria) this;
        }

        public Criteria andReceiveTimesTotalGreaterThanOrEqualTo(Integer value) {
            addCriterion("RECEIVE_TIMES_TOTAL >=", value, "receiveTimesTotal");
            return (Criteria) this;
        }

        public Criteria andReceiveTimesTotalLessThan(Integer value) {
            addCriterion("RECEIVE_TIMES_TOTAL <", value, "receiveTimesTotal");
            return (Criteria) this;
        }

        public Criteria andReceiveTimesTotalLessThanOrEqualTo(Integer value) {
            addCriterion("RECEIVE_TIMES_TOTAL <=", value, "receiveTimesTotal");
            return (Criteria) this;
        }

        public Criteria andReceiveTimesTotalIn(List<Integer> values) {
            addCriterion("RECEIVE_TIMES_TOTAL in", values, "receiveTimesTotal");
            return (Criteria) this;
        }

        public Criteria andReceiveTimesTotalNotIn(List<Integer> values) {
            addCriterion("RECEIVE_TIMES_TOTAL not in", values, "receiveTimesTotal");
            return (Criteria) this;
        }

        public Criteria andReceiveTimesTotalBetween(Integer value1, Integer value2) {
            addCriterion("RECEIVE_TIMES_TOTAL between", value1, value2, "receiveTimesTotal");
            return (Criteria) this;
        }

        public Criteria andReceiveTimesTotalNotBetween(Integer value1, Integer value2) {
            addCriterion("RECEIVE_TIMES_TOTAL not between", value1, value2, "receiveTimesTotal");
            return (Criteria) this;
        }

        public Criteria andReceiveTimesDoneIsNull() {
            addCriterion("RECEIVE_TIMES_DONE is null");
            return (Criteria) this;
        }

        public Criteria andReceiveTimesDoneIsNotNull() {
            addCriterion("RECEIVE_TIMES_DONE is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveTimesDoneEqualTo(Integer value) {
            addCriterion("RECEIVE_TIMES_DONE =", value, "receiveTimesDone");
            return (Criteria) this;
        }

        public Criteria andReceiveTimesDoneNotEqualTo(Integer value) {
            addCriterion("RECEIVE_TIMES_DONE <>", value, "receiveTimesDone");
            return (Criteria) this;
        }

        public Criteria andReceiveTimesDoneGreaterThan(Integer value) {
            addCriterion("RECEIVE_TIMES_DONE >", value, "receiveTimesDone");
            return (Criteria) this;
        }

        public Criteria andReceiveTimesDoneGreaterThanOrEqualTo(Integer value) {
            addCriterion("RECEIVE_TIMES_DONE >=", value, "receiveTimesDone");
            return (Criteria) this;
        }

        public Criteria andReceiveTimesDoneLessThan(Integer value) {
            addCriterion("RECEIVE_TIMES_DONE <", value, "receiveTimesDone");
            return (Criteria) this;
        }

        public Criteria andReceiveTimesDoneLessThanOrEqualTo(Integer value) {
            addCriterion("RECEIVE_TIMES_DONE <=", value, "receiveTimesDone");
            return (Criteria) this;
        }

        public Criteria andReceiveTimesDoneIn(List<Integer> values) {
            addCriterion("RECEIVE_TIMES_DONE in", values, "receiveTimesDone");
            return (Criteria) this;
        }

        public Criteria andReceiveTimesDoneNotIn(List<Integer> values) {
            addCriterion("RECEIVE_TIMES_DONE not in", values, "receiveTimesDone");
            return (Criteria) this;
        }

        public Criteria andReceiveTimesDoneBetween(Integer value1, Integer value2) {
            addCriterion("RECEIVE_TIMES_DONE between", value1, value2, "receiveTimesDone");
            return (Criteria) this;
        }

        public Criteria andReceiveTimesDoneNotBetween(Integer value1, Integer value2) {
            addCriterion("RECEIVE_TIMES_DONE not between", value1, value2, "receiveTimesDone");
            return (Criteria) this;
        }

        public Criteria andReceiveTimesSurplusIsNull() {
            addCriterion("RECEIVE_TIMES_SURPLUS is null");
            return (Criteria) this;
        }

        public Criteria andReceiveTimesSurplusIsNotNull() {
            addCriterion("RECEIVE_TIMES_SURPLUS is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveTimesSurplusEqualTo(Integer value) {
            addCriterion("RECEIVE_TIMES_SURPLUS =", value, "receiveTimesSurplus");
            return (Criteria) this;
        }

        public Criteria andReceiveTimesSurplusNotEqualTo(Integer value) {
            addCriterion("RECEIVE_TIMES_SURPLUS <>", value, "receiveTimesSurplus");
            return (Criteria) this;
        }

        public Criteria andReceiveTimesSurplusGreaterThan(Integer value) {
            addCriterion("RECEIVE_TIMES_SURPLUS >", value, "receiveTimesSurplus");
            return (Criteria) this;
        }

        public Criteria andReceiveTimesSurplusGreaterThanOrEqualTo(Integer value) {
            addCriterion("RECEIVE_TIMES_SURPLUS >=", value, "receiveTimesSurplus");
            return (Criteria) this;
        }

        public Criteria andReceiveTimesSurplusLessThan(Integer value) {
            addCriterion("RECEIVE_TIMES_SURPLUS <", value, "receiveTimesSurplus");
            return (Criteria) this;
        }

        public Criteria andReceiveTimesSurplusLessThanOrEqualTo(Integer value) {
            addCriterion("RECEIVE_TIMES_SURPLUS <=", value, "receiveTimesSurplus");
            return (Criteria) this;
        }

        public Criteria andReceiveTimesSurplusIn(List<Integer> values) {
            addCriterion("RECEIVE_TIMES_SURPLUS in", values, "receiveTimesSurplus");
            return (Criteria) this;
        }

        public Criteria andReceiveTimesSurplusNotIn(List<Integer> values) {
            addCriterion("RECEIVE_TIMES_SURPLUS not in", values, "receiveTimesSurplus");
            return (Criteria) this;
        }

        public Criteria andReceiveTimesSurplusBetween(Integer value1, Integer value2) {
            addCriterion("RECEIVE_TIMES_SURPLUS between", value1, value2, "receiveTimesSurplus");
            return (Criteria) this;
        }

        public Criteria andReceiveTimesSurplusNotBetween(Integer value1, Integer value2) {
            addCriterion("RECEIVE_TIMES_SURPLUS not between", value1, value2, "receiveTimesSurplus");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("STATUS is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("STATUS =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("STATUS <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("STATUS >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("STATUS >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("STATUS <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("STATUS <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("STATUS like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("STATUS not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("STATUS in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("STATUS not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("STATUS between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("STATUS not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("CREATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("CREATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("CREATE_TIME =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("CREATE_TIME <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("CREATE_TIME >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("CREATE_TIME <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("CREATE_TIME in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("CREATE_TIME not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagIsNull() {
            addCriterion("DELETE_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagIsNotNull() {
            addCriterion("DELETE_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagEqualTo(Integer value) {
            addCriterion("DELETE_FLAG =", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagNotEqualTo(Integer value) {
            addCriterion("DELETE_FLAG <>", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagGreaterThan(Integer value) {
            addCriterion("DELETE_FLAG >", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("DELETE_FLAG >=", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagLessThan(Integer value) {
            addCriterion("DELETE_FLAG <", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagLessThanOrEqualTo(Integer value) {
            addCriterion("DELETE_FLAG <=", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagIn(List<Integer> values) {
            addCriterion("DELETE_FLAG in", values, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagNotIn(List<Integer> values) {
            addCriterion("DELETE_FLAG not in", values, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagBetween(Integer value1, Integer value2) {
            addCriterion("DELETE_FLAG between", value1, value2, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("DELETE_FLAG not between", value1, value2, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andStartDateIsNull() {
            addCriterion("START_DATE is null");
            return (Criteria) this;
        }

        public Criteria andStartDateIsNotNull() {
            addCriterion("START_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andStartDateEqualTo(String value) {
            addCriterion("START_DATE =", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotEqualTo(String value) {
            addCriterion("START_DATE <>", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateGreaterThan(String value) {
            addCriterion("START_DATE >", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateGreaterThanOrEqualTo(String value) {
            addCriterion("START_DATE >=", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateLessThan(String value) {
            addCriterion("START_DATE <", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateLessThanOrEqualTo(String value) {
            addCriterion("START_DATE <=", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateLike(String value) {
            addCriterion("START_DATE like", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotLike(String value) {
            addCriterion("START_DATE not like", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateIn(List<String> values) {
            addCriterion("START_DATE in", values, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotIn(List<String> values) {
            addCriterion("START_DATE not in", values, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateBetween(String value1, String value2) {
            addCriterion("START_DATE between", value1, value2, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotBetween(String value1, String value2) {
            addCriterion("START_DATE not between", value1, value2, "startDate");
            return (Criteria) this;
        }

        public Criteria andEndDateIsNull() {
            addCriterion("END_DATE is null");
            return (Criteria) this;
        }

        public Criteria andEndDateIsNotNull() {
            addCriterion("END_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andEndDateEqualTo(String value) {
            addCriterion("END_DATE =", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotEqualTo(String value) {
            addCriterion("END_DATE <>", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThan(String value) {
            addCriterion("END_DATE >", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThanOrEqualTo(String value) {
            addCriterion("END_DATE >=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThan(String value) {
            addCriterion("END_DATE <", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThanOrEqualTo(String value) {
            addCriterion("END_DATE <=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLike(String value) {
            addCriterion("END_DATE like", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotLike(String value) {
            addCriterion("END_DATE not like", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateIn(List<String> values) {
            addCriterion("END_DATE in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotIn(List<String> values) {
            addCriterion("END_DATE not in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateBetween(String value1, String value2) {
            addCriterion("END_DATE between", value1, value2, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotBetween(String value1, String value2) {
            addCriterion("END_DATE not between", value1, value2, "endDate");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNull() {
            addCriterion("START_TIME is null");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNotNull() {
            addCriterion("START_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andStartTimeEqualTo(String value) {
            addCriterion("START_TIME =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(String value) {
            addCriterion("START_TIME <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(String value) {
            addCriterion("START_TIME >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(String value) {
            addCriterion("START_TIME >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(String value) {
            addCriterion("START_TIME <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(String value) {
            addCriterion("START_TIME <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLike(String value) {
            addCriterion("START_TIME like", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotLike(String value) {
            addCriterion("START_TIME not like", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(List<String> values) {
            addCriterion("START_TIME in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(List<String> values) {
            addCriterion("START_TIME not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(String value1, String value2) {
            addCriterion("START_TIME between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(String value1, String value2) {
            addCriterion("START_TIME not between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("END_TIME is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("END_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(String value) {
            addCriterion("END_TIME =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(String value) {
            addCriterion("END_TIME <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(String value) {
            addCriterion("END_TIME >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(String value) {
            addCriterion("END_TIME >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(String value) {
            addCriterion("END_TIME <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(String value) {
            addCriterion("END_TIME <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLike(String value) {
            addCriterion("END_TIME like", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotLike(String value) {
            addCriterion("END_TIME not like", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<String> values) {
            addCriterion("END_TIME in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<String> values) {
            addCriterion("END_TIME not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(String value1, String value2) {
            addCriterion("END_TIME between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(String value1, String value2) {
            addCriterion("END_TIME not between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andReceiveCycleIsNull() {
            addCriterion("RECEIVE_CYCLE is null");
            return (Criteria) this;
        }

        public Criteria andReceiveCycleIsNotNull() {
            addCriterion("RECEIVE_CYCLE is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveCycleEqualTo(String value) {
            addCriterion("RECEIVE_CYCLE =", value, "receiveCycle");
            return (Criteria) this;
        }

        public Criteria andReceiveCycleNotEqualTo(String value) {
            addCriterion("RECEIVE_CYCLE <>", value, "receiveCycle");
            return (Criteria) this;
        }

        public Criteria andReceiveCycleGreaterThan(String value) {
            addCriterion("RECEIVE_CYCLE >", value, "receiveCycle");
            return (Criteria) this;
        }

        public Criteria andReceiveCycleGreaterThanOrEqualTo(String value) {
            addCriterion("RECEIVE_CYCLE >=", value, "receiveCycle");
            return (Criteria) this;
        }

        public Criteria andReceiveCycleLessThan(String value) {
            addCriterion("RECEIVE_CYCLE <", value, "receiveCycle");
            return (Criteria) this;
        }

        public Criteria andReceiveCycleLessThanOrEqualTo(String value) {
            addCriterion("RECEIVE_CYCLE <=", value, "receiveCycle");
            return (Criteria) this;
        }

        public Criteria andReceiveCycleLike(String value) {
            addCriterion("RECEIVE_CYCLE like", value, "receiveCycle");
            return (Criteria) this;
        }

        public Criteria andReceiveCycleNotLike(String value) {
            addCriterion("RECEIVE_CYCLE not like", value, "receiveCycle");
            return (Criteria) this;
        }

        public Criteria andReceiveCycleIn(List<String> values) {
            addCriterion("RECEIVE_CYCLE in", values, "receiveCycle");
            return (Criteria) this;
        }

        public Criteria andReceiveCycleNotIn(List<String> values) {
            addCriterion("RECEIVE_CYCLE not in", values, "receiveCycle");
            return (Criteria) this;
        }

        public Criteria andReceiveCycleBetween(String value1, String value2) {
            addCriterion("RECEIVE_CYCLE between", value1, value2, "receiveCycle");
            return (Criteria) this;
        }

        public Criteria andReceiveCycleNotBetween(String value1, String value2) {
            addCriterion("RECEIVE_CYCLE not between", value1, value2, "receiveCycle");
            return (Criteria) this;
        }

        public Criteria andReceiveTimesSingleFrequencyIsNull() {
            addCriterion("RECEIVE_TIMES_SINGLE_FREQUENCY is null");
            return (Criteria) this;
        }

        public Criteria andReceiveTimesSingleFrequencyIsNotNull() {
            addCriterion("RECEIVE_TIMES_SINGLE_FREQUENCY is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveTimesSingleFrequencyEqualTo(String value) {
            addCriterion("RECEIVE_TIMES_SINGLE_FREQUENCY =", value, "receiveTimesSingleFrequency");
            return (Criteria) this;
        }

        public Criteria andReceiveTimesSingleFrequencyNotEqualTo(String value) {
            addCriterion("RECEIVE_TIMES_SINGLE_FREQUENCY <>", value, "receiveTimesSingleFrequency");
            return (Criteria) this;
        }

        public Criteria andReceiveTimesSingleFrequencyGreaterThan(String value) {
            addCriterion("RECEIVE_TIMES_SINGLE_FREQUENCY >", value, "receiveTimesSingleFrequency");
            return (Criteria) this;
        }

        public Criteria andReceiveTimesSingleFrequencyGreaterThanOrEqualTo(String value) {
            addCriterion("RECEIVE_TIMES_SINGLE_FREQUENCY >=", value, "receiveTimesSingleFrequency");
            return (Criteria) this;
        }

        public Criteria andReceiveTimesSingleFrequencyLessThan(String value) {
            addCriterion("RECEIVE_TIMES_SINGLE_FREQUENCY <", value, "receiveTimesSingleFrequency");
            return (Criteria) this;
        }

        public Criteria andReceiveTimesSingleFrequencyLessThanOrEqualTo(String value) {
            addCriterion("RECEIVE_TIMES_SINGLE_FREQUENCY <=", value, "receiveTimesSingleFrequency");
            return (Criteria) this;
        }

        public Criteria andReceiveTimesSingleFrequencyLike(String value) {
            addCriterion("RECEIVE_TIMES_SINGLE_FREQUENCY like", value, "receiveTimesSingleFrequency");
            return (Criteria) this;
        }

        public Criteria andReceiveTimesSingleFrequencyNotLike(String value) {
            addCriterion("RECEIVE_TIMES_SINGLE_FREQUENCY not like", value, "receiveTimesSingleFrequency");
            return (Criteria) this;
        }

        public Criteria andReceiveTimesSingleFrequencyIn(List<String> values) {
            addCriterion("RECEIVE_TIMES_SINGLE_FREQUENCY in", values, "receiveTimesSingleFrequency");
            return (Criteria) this;
        }

        public Criteria andReceiveTimesSingleFrequencyNotIn(List<String> values) {
            addCriterion("RECEIVE_TIMES_SINGLE_FREQUENCY not in", values, "receiveTimesSingleFrequency");
            return (Criteria) this;
        }

        public Criteria andReceiveTimesSingleFrequencyBetween(String value1, String value2) {
            addCriterion("RECEIVE_TIMES_SINGLE_FREQUENCY between", value1, value2, "receiveTimesSingleFrequency");
            return (Criteria) this;
        }

        public Criteria andReceiveTimesSingleFrequencyNotBetween(String value1, String value2) {
            addCriterion("RECEIVE_TIMES_SINGLE_FREQUENCY not between", value1, value2, "receiveTimesSingleFrequency");
            return (Criteria) this;
        }

        public Criteria andPhaseRightsTotalNumIsNull() {
            addCriterion("PHASE_RIGHTS_TOTAL_NUM is null");
            return (Criteria) this;
        }

        public Criteria andPhaseRightsTotalNumIsNotNull() {
            addCriterion("PHASE_RIGHTS_TOTAL_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andPhaseRightsTotalNumEqualTo(Integer value) {
            addCriterion("PHASE_RIGHTS_TOTAL_NUM =", value, "phaseRightsTotalNum");
            return (Criteria) this;
        }

        public Criteria andPhaseRightsTotalNumNotEqualTo(Integer value) {
            addCriterion("PHASE_RIGHTS_TOTAL_NUM <>", value, "phaseRightsTotalNum");
            return (Criteria) this;
        }

        public Criteria andPhaseRightsTotalNumGreaterThan(Integer value) {
            addCriterion("PHASE_RIGHTS_TOTAL_NUM >", value, "phaseRightsTotalNum");
            return (Criteria) this;
        }

        public Criteria andPhaseRightsTotalNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("PHASE_RIGHTS_TOTAL_NUM >=", value, "phaseRightsTotalNum");
            return (Criteria) this;
        }

        public Criteria andPhaseRightsTotalNumLessThan(Integer value) {
            addCriterion("PHASE_RIGHTS_TOTAL_NUM <", value, "phaseRightsTotalNum");
            return (Criteria) this;
        }

        public Criteria andPhaseRightsTotalNumLessThanOrEqualTo(Integer value) {
            addCriterion("PHASE_RIGHTS_TOTAL_NUM <=", value, "phaseRightsTotalNum");
            return (Criteria) this;
        }

        public Criteria andPhaseRightsTotalNumIn(List<Integer> values) {
            addCriterion("PHASE_RIGHTS_TOTAL_NUM in", values, "phaseRightsTotalNum");
            return (Criteria) this;
        }

        public Criteria andPhaseRightsTotalNumNotIn(List<Integer> values) {
            addCriterion("PHASE_RIGHTS_TOTAL_NUM not in", values, "phaseRightsTotalNum");
            return (Criteria) this;
        }

        public Criteria andPhaseRightsTotalNumBetween(Integer value1, Integer value2) {
            addCriterion("PHASE_RIGHTS_TOTAL_NUM between", value1, value2, "phaseRightsTotalNum");
            return (Criteria) this;
        }

        public Criteria andPhaseRightsTotalNumNotBetween(Integer value1, Integer value2) {
            addCriterion("PHASE_RIGHTS_TOTAL_NUM not between", value1, value2, "phaseRightsTotalNum");
            return (Criteria) this;
        }

        public Criteria andPhaseRightsNumCycleIsNull() {
            addCriterion("PHASE_RIGHTS_NUM_CYCLE is null");
            return (Criteria) this;
        }

        public Criteria andPhaseRightsNumCycleIsNotNull() {
            addCriterion("PHASE_RIGHTS_NUM_CYCLE is not null");
            return (Criteria) this;
        }

        public Criteria andPhaseRightsNumCycleEqualTo(String value) {
            addCriterion("PHASE_RIGHTS_NUM_CYCLE =", value, "phaseRightsNumCycle");
            return (Criteria) this;
        }

        public Criteria andPhaseRightsNumCycleNotEqualTo(String value) {
            addCriterion("PHASE_RIGHTS_NUM_CYCLE <>", value, "phaseRightsNumCycle");
            return (Criteria) this;
        }

        public Criteria andPhaseRightsNumCycleGreaterThan(String value) {
            addCriterion("PHASE_RIGHTS_NUM_CYCLE >", value, "phaseRightsNumCycle");
            return (Criteria) this;
        }

        public Criteria andPhaseRightsNumCycleGreaterThanOrEqualTo(String value) {
            addCriterion("PHASE_RIGHTS_NUM_CYCLE >=", value, "phaseRightsNumCycle");
            return (Criteria) this;
        }

        public Criteria andPhaseRightsNumCycleLessThan(String value) {
            addCriterion("PHASE_RIGHTS_NUM_CYCLE <", value, "phaseRightsNumCycle");
            return (Criteria) this;
        }

        public Criteria andPhaseRightsNumCycleLessThanOrEqualTo(String value) {
            addCriterion("PHASE_RIGHTS_NUM_CYCLE <=", value, "phaseRightsNumCycle");
            return (Criteria) this;
        }

        public Criteria andPhaseRightsNumCycleLike(String value) {
            addCriterion("PHASE_RIGHTS_NUM_CYCLE like", value, "phaseRightsNumCycle");
            return (Criteria) this;
        }

        public Criteria andPhaseRightsNumCycleNotLike(String value) {
            addCriterion("PHASE_RIGHTS_NUM_CYCLE not like", value, "phaseRightsNumCycle");
            return (Criteria) this;
        }

        public Criteria andPhaseRightsNumCycleIn(List<String> values) {
            addCriterion("PHASE_RIGHTS_NUM_CYCLE in", values, "phaseRightsNumCycle");
            return (Criteria) this;
        }

        public Criteria andPhaseRightsNumCycleNotIn(List<String> values) {
            addCriterion("PHASE_RIGHTS_NUM_CYCLE not in", values, "phaseRightsNumCycle");
            return (Criteria) this;
        }

        public Criteria andPhaseRightsNumCycleBetween(String value1, String value2) {
            addCriterion("PHASE_RIGHTS_NUM_CYCLE between", value1, value2, "phaseRightsNumCycle");
            return (Criteria) this;
        }

        public Criteria andPhaseRightsNumCycleNotBetween(String value1, String value2) {
            addCriterion("PHASE_RIGHTS_NUM_CYCLE not between", value1, value2, "phaseRightsNumCycle");
            return (Criteria) this;
        }

        public Criteria andHasAllowListIsNull() {
            addCriterion("HAS_ALLOW_LIST is null");
            return (Criteria) this;
        }

        public Criteria andHasAllowListIsNotNull() {
            addCriterion("HAS_ALLOW_LIST is not null");
            return (Criteria) this;
        }

        public Criteria andHasAllowListEqualTo(String value) {
            addCriterion("HAS_ALLOW_LIST =", value, "hasAllowList");
            return (Criteria) this;
        }

        public Criteria andHasAllowListNotEqualTo(String value) {
            addCriterion("HAS_ALLOW_LIST <>", value, "hasAllowList");
            return (Criteria) this;
        }

        public Criteria andHasAllowListGreaterThan(String value) {
            addCriterion("HAS_ALLOW_LIST >", value, "hasAllowList");
            return (Criteria) this;
        }

        public Criteria andHasAllowListGreaterThanOrEqualTo(String value) {
            addCriterion("HAS_ALLOW_LIST >=", value, "hasAllowList");
            return (Criteria) this;
        }

        public Criteria andHasAllowListLessThan(String value) {
            addCriterion("HAS_ALLOW_LIST <", value, "hasAllowList");
            return (Criteria) this;
        }

        public Criteria andHasAllowListLessThanOrEqualTo(String value) {
            addCriterion("HAS_ALLOW_LIST <=", value, "hasAllowList");
            return (Criteria) this;
        }

        public Criteria andHasAllowListLike(String value) {
            addCriterion("HAS_ALLOW_LIST like", value, "hasAllowList");
            return (Criteria) this;
        }

        public Criteria andHasAllowListNotLike(String value) {
            addCriterion("HAS_ALLOW_LIST not like", value, "hasAllowList");
            return (Criteria) this;
        }

        public Criteria andHasAllowListIn(List<String> values) {
            addCriterion("HAS_ALLOW_LIST in", values, "hasAllowList");
            return (Criteria) this;
        }

        public Criteria andHasAllowListNotIn(List<String> values) {
            addCriterion("HAS_ALLOW_LIST not in", values, "hasAllowList");
            return (Criteria) this;
        }

        public Criteria andHasAllowListBetween(String value1, String value2) {
            addCriterion("HAS_ALLOW_LIST between", value1, value2, "hasAllowList");
            return (Criteria) this;
        }

        public Criteria andHasAllowListNotBetween(String value1, String value2) {
            addCriterion("HAS_ALLOW_LIST not between", value1, value2, "hasAllowList");
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