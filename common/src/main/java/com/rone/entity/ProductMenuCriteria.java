package com.rone.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductMenuCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProductMenuCriteria() {
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

        public Criteria andMenuNameIsNull() {
            addCriterion("MENU_NAME is null");
            return (Criteria) this;
        }

        public Criteria andMenuNameIsNotNull() {
            addCriterion("MENU_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andMenuNameEqualTo(String value) {
            addCriterion("MENU_NAME =", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameNotEqualTo(String value) {
            addCriterion("MENU_NAME <>", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameGreaterThan(String value) {
            addCriterion("MENU_NAME >", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameGreaterThanOrEqualTo(String value) {
            addCriterion("MENU_NAME >=", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameLessThan(String value) {
            addCriterion("MENU_NAME <", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameLessThanOrEqualTo(String value) {
            addCriterion("MENU_NAME <=", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameLike(String value) {
            addCriterion("MENU_NAME like", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameNotLike(String value) {
            addCriterion("MENU_NAME not like", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameIn(List<String> values) {
            addCriterion("MENU_NAME in", values, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameNotIn(List<String> values) {
            addCriterion("MENU_NAME not in", values, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameBetween(String value1, String value2) {
            addCriterion("MENU_NAME between", value1, value2, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameNotBetween(String value1, String value2) {
            addCriterion("MENU_NAME not between", value1, value2, "menuName");
            return (Criteria) this;
        }

        public Criteria andProductDescIsNull() {
            addCriterion("PRODUCT_DESC is null");
            return (Criteria) this;
        }

        public Criteria andProductDescIsNotNull() {
            addCriterion("PRODUCT_DESC is not null");
            return (Criteria) this;
        }

        public Criteria andProductDescEqualTo(String value) {
            addCriterion("PRODUCT_DESC =", value, "productDesc");
            return (Criteria) this;
        }

        public Criteria andProductDescNotEqualTo(String value) {
            addCriterion("PRODUCT_DESC <>", value, "productDesc");
            return (Criteria) this;
        }

        public Criteria andProductDescGreaterThan(String value) {
            addCriterion("PRODUCT_DESC >", value, "productDesc");
            return (Criteria) this;
        }

        public Criteria andProductDescGreaterThanOrEqualTo(String value) {
            addCriterion("PRODUCT_DESC >=", value, "productDesc");
            return (Criteria) this;
        }

        public Criteria andProductDescLessThan(String value) {
            addCriterion("PRODUCT_DESC <", value, "productDesc");
            return (Criteria) this;
        }

        public Criteria andProductDescLessThanOrEqualTo(String value) {
            addCriterion("PRODUCT_DESC <=", value, "productDesc");
            return (Criteria) this;
        }

        public Criteria andProductDescLike(String value) {
            addCriterion("PRODUCT_DESC like", value, "productDesc");
            return (Criteria) this;
        }

        public Criteria andProductDescNotLike(String value) {
            addCriterion("PRODUCT_DESC not like", value, "productDesc");
            return (Criteria) this;
        }

        public Criteria andProductDescIn(List<String> values) {
            addCriterion("PRODUCT_DESC in", values, "productDesc");
            return (Criteria) this;
        }

        public Criteria andProductDescNotIn(List<String> values) {
            addCriterion("PRODUCT_DESC not in", values, "productDesc");
            return (Criteria) this;
        }

        public Criteria andProductDescBetween(String value1, String value2) {
            addCriterion("PRODUCT_DESC between", value1, value2, "productDesc");
            return (Criteria) this;
        }

        public Criteria andProductDescNotBetween(String value1, String value2) {
            addCriterion("PRODUCT_DESC not between", value1, value2, "productDesc");
            return (Criteria) this;
        }

        public Criteria andMenuIconIsNull() {
            addCriterion("MENU_ICON is null");
            return (Criteria) this;
        }

        public Criteria andMenuIconIsNotNull() {
            addCriterion("MENU_ICON is not null");
            return (Criteria) this;
        }

        public Criteria andMenuIconEqualTo(String value) {
            addCriterion("MENU_ICON =", value, "menuIcon");
            return (Criteria) this;
        }

        public Criteria andMenuIconNotEqualTo(String value) {
            addCriterion("MENU_ICON <>", value, "menuIcon");
            return (Criteria) this;
        }

        public Criteria andMenuIconGreaterThan(String value) {
            addCriterion("MENU_ICON >", value, "menuIcon");
            return (Criteria) this;
        }

        public Criteria andMenuIconGreaterThanOrEqualTo(String value) {
            addCriterion("MENU_ICON >=", value, "menuIcon");
            return (Criteria) this;
        }

        public Criteria andMenuIconLessThan(String value) {
            addCriterion("MENU_ICON <", value, "menuIcon");
            return (Criteria) this;
        }

        public Criteria andMenuIconLessThanOrEqualTo(String value) {
            addCriterion("MENU_ICON <=", value, "menuIcon");
            return (Criteria) this;
        }

        public Criteria andMenuIconLike(String value) {
            addCriterion("MENU_ICON like", value, "menuIcon");
            return (Criteria) this;
        }

        public Criteria andMenuIconNotLike(String value) {
            addCriterion("MENU_ICON not like", value, "menuIcon");
            return (Criteria) this;
        }

        public Criteria andMenuIconIn(List<String> values) {
            addCriterion("MENU_ICON in", values, "menuIcon");
            return (Criteria) this;
        }

        public Criteria andMenuIconNotIn(List<String> values) {
            addCriterion("MENU_ICON not in", values, "menuIcon");
            return (Criteria) this;
        }

        public Criteria andMenuIconBetween(String value1, String value2) {
            addCriterion("MENU_ICON between", value1, value2, "menuIcon");
            return (Criteria) this;
        }

        public Criteria andMenuIconNotBetween(String value1, String value2) {
            addCriterion("MENU_ICON not between", value1, value2, "menuIcon");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIsNull() {
            addCriterion("CATEGORY_ID is null");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIsNotNull() {
            addCriterion("CATEGORY_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryIdEqualTo(Integer value) {
            addCriterion("CATEGORY_ID =", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotEqualTo(Integer value) {
            addCriterion("CATEGORY_ID <>", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdGreaterThan(Integer value) {
            addCriterion("CATEGORY_ID >", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("CATEGORY_ID >=", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdLessThan(Integer value) {
            addCriterion("CATEGORY_ID <", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdLessThanOrEqualTo(Integer value) {
            addCriterion("CATEGORY_ID <=", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIn(List<Integer> values) {
            addCriterion("CATEGORY_ID in", values, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotIn(List<Integer> values) {
            addCriterion("CATEGORY_ID not in", values, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdBetween(Integer value1, Integer value2) {
            addCriterion("CATEGORY_ID between", value1, value2, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotBetween(Integer value1, Integer value2) {
            addCriterion("CATEGORY_ID not between", value1, value2, "categoryId");
            return (Criteria) this;
        }

        public Criteria andAdvertPhotoIsNull() {
            addCriterion("ADVERT_PHOTO is null");
            return (Criteria) this;
        }

        public Criteria andAdvertPhotoIsNotNull() {
            addCriterion("ADVERT_PHOTO is not null");
            return (Criteria) this;
        }

        public Criteria andAdvertPhotoEqualTo(String value) {
            addCriterion("ADVERT_PHOTO =", value, "advertPhoto");
            return (Criteria) this;
        }

        public Criteria andAdvertPhotoNotEqualTo(String value) {
            addCriterion("ADVERT_PHOTO <>", value, "advertPhoto");
            return (Criteria) this;
        }

        public Criteria andAdvertPhotoGreaterThan(String value) {
            addCriterion("ADVERT_PHOTO >", value, "advertPhoto");
            return (Criteria) this;
        }

        public Criteria andAdvertPhotoGreaterThanOrEqualTo(String value) {
            addCriterion("ADVERT_PHOTO >=", value, "advertPhoto");
            return (Criteria) this;
        }

        public Criteria andAdvertPhotoLessThan(String value) {
            addCriterion("ADVERT_PHOTO <", value, "advertPhoto");
            return (Criteria) this;
        }

        public Criteria andAdvertPhotoLessThanOrEqualTo(String value) {
            addCriterion("ADVERT_PHOTO <=", value, "advertPhoto");
            return (Criteria) this;
        }

        public Criteria andAdvertPhotoLike(String value) {
            addCriterion("ADVERT_PHOTO like", value, "advertPhoto");
            return (Criteria) this;
        }

        public Criteria andAdvertPhotoNotLike(String value) {
            addCriterion("ADVERT_PHOTO not like", value, "advertPhoto");
            return (Criteria) this;
        }

        public Criteria andAdvertPhotoIn(List<String> values) {
            addCriterion("ADVERT_PHOTO in", values, "advertPhoto");
            return (Criteria) this;
        }

        public Criteria andAdvertPhotoNotIn(List<String> values) {
            addCriterion("ADVERT_PHOTO not in", values, "advertPhoto");
            return (Criteria) this;
        }

        public Criteria andAdvertPhotoBetween(String value1, String value2) {
            addCriterion("ADVERT_PHOTO between", value1, value2, "advertPhoto");
            return (Criteria) this;
        }

        public Criteria andAdvertPhotoNotBetween(String value1, String value2) {
            addCriterion("ADVERT_PHOTO not between", value1, value2, "advertPhoto");
            return (Criteria) this;
        }

        public Criteria andJumpUrlIsNull() {
            addCriterion("JUMP_URL is null");
            return (Criteria) this;
        }

        public Criteria andJumpUrlIsNotNull() {
            addCriterion("JUMP_URL is not null");
            return (Criteria) this;
        }

        public Criteria andJumpUrlEqualTo(String value) {
            addCriterion("JUMP_URL =", value, "jumpUrl");
            return (Criteria) this;
        }

        public Criteria andJumpUrlNotEqualTo(String value) {
            addCriterion("JUMP_URL <>", value, "jumpUrl");
            return (Criteria) this;
        }

        public Criteria andJumpUrlGreaterThan(String value) {
            addCriterion("JUMP_URL >", value, "jumpUrl");
            return (Criteria) this;
        }

        public Criteria andJumpUrlGreaterThanOrEqualTo(String value) {
            addCriterion("JUMP_URL >=", value, "jumpUrl");
            return (Criteria) this;
        }

        public Criteria andJumpUrlLessThan(String value) {
            addCriterion("JUMP_URL <", value, "jumpUrl");
            return (Criteria) this;
        }

        public Criteria andJumpUrlLessThanOrEqualTo(String value) {
            addCriterion("JUMP_URL <=", value, "jumpUrl");
            return (Criteria) this;
        }

        public Criteria andJumpUrlLike(String value) {
            addCriterion("JUMP_URL like", value, "jumpUrl");
            return (Criteria) this;
        }

        public Criteria andJumpUrlNotLike(String value) {
            addCriterion("JUMP_URL not like", value, "jumpUrl");
            return (Criteria) this;
        }

        public Criteria andJumpUrlIn(List<String> values) {
            addCriterion("JUMP_URL in", values, "jumpUrl");
            return (Criteria) this;
        }

        public Criteria andJumpUrlNotIn(List<String> values) {
            addCriterion("JUMP_URL not in", values, "jumpUrl");
            return (Criteria) this;
        }

        public Criteria andJumpUrlBetween(String value1, String value2) {
            addCriterion("JUMP_URL between", value1, value2, "jumpUrl");
            return (Criteria) this;
        }

        public Criteria andJumpUrlNotBetween(String value1, String value2) {
            addCriterion("JUMP_URL not between", value1, value2, "jumpUrl");
            return (Criteria) this;
        }

        public Criteria andJumpParamIsNull() {
            addCriterion("JUMP_PARAM is null");
            return (Criteria) this;
        }

        public Criteria andJumpParamIsNotNull() {
            addCriterion("JUMP_PARAM is not null");
            return (Criteria) this;
        }

        public Criteria andJumpParamEqualTo(String value) {
            addCriterion("JUMP_PARAM =", value, "jumpParam");
            return (Criteria) this;
        }

        public Criteria andJumpParamNotEqualTo(String value) {
            addCriterion("JUMP_PARAM <>", value, "jumpParam");
            return (Criteria) this;
        }

        public Criteria andJumpParamGreaterThan(String value) {
            addCriterion("JUMP_PARAM >", value, "jumpParam");
            return (Criteria) this;
        }

        public Criteria andJumpParamGreaterThanOrEqualTo(String value) {
            addCriterion("JUMP_PARAM >=", value, "jumpParam");
            return (Criteria) this;
        }

        public Criteria andJumpParamLessThan(String value) {
            addCriterion("JUMP_PARAM <", value, "jumpParam");
            return (Criteria) this;
        }

        public Criteria andJumpParamLessThanOrEqualTo(String value) {
            addCriterion("JUMP_PARAM <=", value, "jumpParam");
            return (Criteria) this;
        }

        public Criteria andJumpParamLike(String value) {
            addCriterion("JUMP_PARAM like", value, "jumpParam");
            return (Criteria) this;
        }

        public Criteria andJumpParamNotLike(String value) {
            addCriterion("JUMP_PARAM not like", value, "jumpParam");
            return (Criteria) this;
        }

        public Criteria andJumpParamIn(List<String> values) {
            addCriterion("JUMP_PARAM in", values, "jumpParam");
            return (Criteria) this;
        }

        public Criteria andJumpParamNotIn(List<String> values) {
            addCriterion("JUMP_PARAM not in", values, "jumpParam");
            return (Criteria) this;
        }

        public Criteria andJumpParamBetween(String value1, String value2) {
            addCriterion("JUMP_PARAM between", value1, value2, "jumpParam");
            return (Criteria) this;
        }

        public Criteria andJumpParamNotBetween(String value1, String value2) {
            addCriterion("JUMP_PARAM not between", value1, value2, "jumpParam");
            return (Criteria) this;
        }

        public Criteria andFontIdIsNull() {
            addCriterion("FONT_ID is null");
            return (Criteria) this;
        }

        public Criteria andFontIdIsNotNull() {
            addCriterion("FONT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andFontIdEqualTo(Integer value) {
            addCriterion("FONT_ID =", value, "fontId");
            return (Criteria) this;
        }

        public Criteria andFontIdNotEqualTo(Integer value) {
            addCriterion("FONT_ID <>", value, "fontId");
            return (Criteria) this;
        }

        public Criteria andFontIdGreaterThan(Integer value) {
            addCriterion("FONT_ID >", value, "fontId");
            return (Criteria) this;
        }

        public Criteria andFontIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("FONT_ID >=", value, "fontId");
            return (Criteria) this;
        }

        public Criteria andFontIdLessThan(Integer value) {
            addCriterion("FONT_ID <", value, "fontId");
            return (Criteria) this;
        }

        public Criteria andFontIdLessThanOrEqualTo(Integer value) {
            addCriterion("FONT_ID <=", value, "fontId");
            return (Criteria) this;
        }

        public Criteria andFontIdIn(List<Integer> values) {
            addCriterion("FONT_ID in", values, "fontId");
            return (Criteria) this;
        }

        public Criteria andFontIdNotIn(List<Integer> values) {
            addCriterion("FONT_ID not in", values, "fontId");
            return (Criteria) this;
        }

        public Criteria andFontIdBetween(Integer value1, Integer value2) {
            addCriterion("FONT_ID between", value1, value2, "fontId");
            return (Criteria) this;
        }

        public Criteria andFontIdNotBetween(Integer value1, Integer value2) {
            addCriterion("FONT_ID not between", value1, value2, "fontId");
            return (Criteria) this;
        }

        public Criteria andSortIsNull() {
            addCriterion("SORT is null");
            return (Criteria) this;
        }

        public Criteria andSortIsNotNull() {
            addCriterion("SORT is not null");
            return (Criteria) this;
        }

        public Criteria andSortEqualTo(Integer value) {
            addCriterion("SORT =", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotEqualTo(Integer value) {
            addCriterion("SORT <>", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThan(Integer value) {
            addCriterion("SORT >", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThanOrEqualTo(Integer value) {
            addCriterion("SORT >=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThan(Integer value) {
            addCriterion("SORT <", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThanOrEqualTo(Integer value) {
            addCriterion("SORT <=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortIn(List<Integer> values) {
            addCriterion("SORT in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotIn(List<Integer> values) {
            addCriterion("SORT not in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortBetween(Integer value1, Integer value2) {
            addCriterion("SORT between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotBetween(Integer value1, Integer value2) {
            addCriterion("SORT not between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andDeletedIsNull() {
            addCriterion("DELETED is null");
            return (Criteria) this;
        }

        public Criteria andDeletedIsNotNull() {
            addCriterion("DELETED is not null");
            return (Criteria) this;
        }

        public Criteria andDeletedEqualTo(String value) {
            addCriterion("DELETED =", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotEqualTo(String value) {
            addCriterion("DELETED <>", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedGreaterThan(String value) {
            addCriterion("DELETED >", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedGreaterThanOrEqualTo(String value) {
            addCriterion("DELETED >=", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedLessThan(String value) {
            addCriterion("DELETED <", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedLessThanOrEqualTo(String value) {
            addCriterion("DELETED <=", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedLike(String value) {
            addCriterion("DELETED like", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotLike(String value) {
            addCriterion("DELETED not like", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedIn(List<String> values) {
            addCriterion("DELETED in", values, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotIn(List<String> values) {
            addCriterion("DELETED not in", values, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedBetween(String value1, String value2) {
            addCriterion("DELETED between", value1, value2, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotBetween(String value1, String value2) {
            addCriterion("DELETED not between", value1, value2, "deleted");
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

        public Criteria andUpdateTimeIsNull() {
            addCriterion("UPDATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("UPDATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("UPDATE_TIME =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("UPDATE_TIME <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("UPDATE_TIME >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("UPDATE_TIME >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("UPDATE_TIME <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("UPDATE_TIME <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("UPDATE_TIME in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("UPDATE_TIME not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("UPDATE_TIME between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("UPDATE_TIME not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andConsultWorkNoIsNull() {
            addCriterion("CONSULT_WORK_NO is null");
            return (Criteria) this;
        }

        public Criteria andConsultWorkNoIsNotNull() {
            addCriterion("CONSULT_WORK_NO is not null");
            return (Criteria) this;
        }

        public Criteria andConsultWorkNoEqualTo(String value) {
            addCriterion("CONSULT_WORK_NO =", value, "consultWorkNo");
            return (Criteria) this;
        }

        public Criteria andConsultWorkNoNotEqualTo(String value) {
            addCriterion("CONSULT_WORK_NO <>", value, "consultWorkNo");
            return (Criteria) this;
        }

        public Criteria andConsultWorkNoGreaterThan(String value) {
            addCriterion("CONSULT_WORK_NO >", value, "consultWorkNo");
            return (Criteria) this;
        }

        public Criteria andConsultWorkNoGreaterThanOrEqualTo(String value) {
            addCriterion("CONSULT_WORK_NO >=", value, "consultWorkNo");
            return (Criteria) this;
        }

        public Criteria andConsultWorkNoLessThan(String value) {
            addCriterion("CONSULT_WORK_NO <", value, "consultWorkNo");
            return (Criteria) this;
        }

        public Criteria andConsultWorkNoLessThanOrEqualTo(String value) {
            addCriterion("CONSULT_WORK_NO <=", value, "consultWorkNo");
            return (Criteria) this;
        }

        public Criteria andConsultWorkNoLike(String value) {
            addCriterion("CONSULT_WORK_NO like", value, "consultWorkNo");
            return (Criteria) this;
        }

        public Criteria andConsultWorkNoNotLike(String value) {
            addCriterion("CONSULT_WORK_NO not like", value, "consultWorkNo");
            return (Criteria) this;
        }

        public Criteria andConsultWorkNoIn(List<String> values) {
            addCriterion("CONSULT_WORK_NO in", values, "consultWorkNo");
            return (Criteria) this;
        }

        public Criteria andConsultWorkNoNotIn(List<String> values) {
            addCriterion("CONSULT_WORK_NO not in", values, "consultWorkNo");
            return (Criteria) this;
        }

        public Criteria andConsultWorkNoBetween(String value1, String value2) {
            addCriterion("CONSULT_WORK_NO between", value1, value2, "consultWorkNo");
            return (Criteria) this;
        }

        public Criteria andConsultWorkNoNotBetween(String value1, String value2) {
            addCriterion("CONSULT_WORK_NO not between", value1, value2, "consultWorkNo");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeIsNull() {
            addCriterion("BUSINESS_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeIsNotNull() {
            addCriterion("BUSINESS_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeEqualTo(String value) {
            addCriterion("BUSINESS_TYPE =", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeNotEqualTo(String value) {
            addCriterion("BUSINESS_TYPE <>", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeGreaterThan(String value) {
            addCriterion("BUSINESS_TYPE >", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeGreaterThanOrEqualTo(String value) {
            addCriterion("BUSINESS_TYPE >=", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeLessThan(String value) {
            addCriterion("BUSINESS_TYPE <", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeLessThanOrEqualTo(String value) {
            addCriterion("BUSINESS_TYPE <=", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeLike(String value) {
            addCriterion("BUSINESS_TYPE like", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeNotLike(String value) {
            addCriterion("BUSINESS_TYPE not like", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeIn(List<String> values) {
            addCriterion("BUSINESS_TYPE in", values, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeNotIn(List<String> values) {
            addCriterion("BUSINESS_TYPE not in", values, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeBetween(String value1, String value2) {
            addCriterion("BUSINESS_TYPE between", value1, value2, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeNotBetween(String value1, String value2) {
            addCriterion("BUSINESS_TYPE not between", value1, value2, "businessType");
            return (Criteria) this;
        }

        public Criteria andHoldUrlIsNull() {
            addCriterion("HOLD_URL is null");
            return (Criteria) this;
        }

        public Criteria andHoldUrlIsNotNull() {
            addCriterion("HOLD_URL is not null");
            return (Criteria) this;
        }

        public Criteria andHoldUrlEqualTo(String value) {
            addCriterion("HOLD_URL =", value, "holdUrl");
            return (Criteria) this;
        }

        public Criteria andHoldUrlNotEqualTo(String value) {
            addCriterion("HOLD_URL <>", value, "holdUrl");
            return (Criteria) this;
        }

        public Criteria andHoldUrlGreaterThan(String value) {
            addCriterion("HOLD_URL >", value, "holdUrl");
            return (Criteria) this;
        }

        public Criteria andHoldUrlGreaterThanOrEqualTo(String value) {
            addCriterion("HOLD_URL >=", value, "holdUrl");
            return (Criteria) this;
        }

        public Criteria andHoldUrlLessThan(String value) {
            addCriterion("HOLD_URL <", value, "holdUrl");
            return (Criteria) this;
        }

        public Criteria andHoldUrlLessThanOrEqualTo(String value) {
            addCriterion("HOLD_URL <=", value, "holdUrl");
            return (Criteria) this;
        }

        public Criteria andHoldUrlLike(String value) {
            addCriterion("HOLD_URL like", value, "holdUrl");
            return (Criteria) this;
        }

        public Criteria andHoldUrlNotLike(String value) {
            addCriterion("HOLD_URL not like", value, "holdUrl");
            return (Criteria) this;
        }

        public Criteria andHoldUrlIn(List<String> values) {
            addCriterion("HOLD_URL in", values, "holdUrl");
            return (Criteria) this;
        }

        public Criteria andHoldUrlNotIn(List<String> values) {
            addCriterion("HOLD_URL not in", values, "holdUrl");
            return (Criteria) this;
        }

        public Criteria andHoldUrlBetween(String value1, String value2) {
            addCriterion("HOLD_URL between", value1, value2, "holdUrl");
            return (Criteria) this;
        }

        public Criteria andHoldUrlNotBetween(String value1, String value2) {
            addCriterion("HOLD_URL not between", value1, value2, "holdUrl");
            return (Criteria) this;
        }

        public Criteria andHoldParamIsNull() {
            addCriterion("HOLD_PARAM is null");
            return (Criteria) this;
        }

        public Criteria andHoldParamIsNotNull() {
            addCriterion("HOLD_PARAM is not null");
            return (Criteria) this;
        }

        public Criteria andHoldParamEqualTo(String value) {
            addCriterion("HOLD_PARAM =", value, "holdParam");
            return (Criteria) this;
        }

        public Criteria andHoldParamNotEqualTo(String value) {
            addCriterion("HOLD_PARAM <>", value, "holdParam");
            return (Criteria) this;
        }

        public Criteria andHoldParamGreaterThan(String value) {
            addCriterion("HOLD_PARAM >", value, "holdParam");
            return (Criteria) this;
        }

        public Criteria andHoldParamGreaterThanOrEqualTo(String value) {
            addCriterion("HOLD_PARAM >=", value, "holdParam");
            return (Criteria) this;
        }

        public Criteria andHoldParamLessThan(String value) {
            addCriterion("HOLD_PARAM <", value, "holdParam");
            return (Criteria) this;
        }

        public Criteria andHoldParamLessThanOrEqualTo(String value) {
            addCriterion("HOLD_PARAM <=", value, "holdParam");
            return (Criteria) this;
        }

        public Criteria andHoldParamLike(String value) {
            addCriterion("HOLD_PARAM like", value, "holdParam");
            return (Criteria) this;
        }

        public Criteria andHoldParamNotLike(String value) {
            addCriterion("HOLD_PARAM not like", value, "holdParam");
            return (Criteria) this;
        }

        public Criteria andHoldParamIn(List<String> values) {
            addCriterion("HOLD_PARAM in", values, "holdParam");
            return (Criteria) this;
        }

        public Criteria andHoldParamNotIn(List<String> values) {
            addCriterion("HOLD_PARAM not in", values, "holdParam");
            return (Criteria) this;
        }

        public Criteria andHoldParamBetween(String value1, String value2) {
            addCriterion("HOLD_PARAM between", value1, value2, "holdParam");
            return (Criteria) this;
        }

        public Criteria andHoldParamNotBetween(String value1, String value2) {
            addCriterion("HOLD_PARAM not between", value1, value2, "holdParam");
            return (Criteria) this;
        }

        public Criteria andUsableIsNull() {
            addCriterion("USABLE is null");
            return (Criteria) this;
        }

        public Criteria andUsableIsNotNull() {
            addCriterion("USABLE is not null");
            return (Criteria) this;
        }

        public Criteria andUsableEqualTo(String value) {
            addCriterion("USABLE =", value, "usable");
            return (Criteria) this;
        }

        public Criteria andUsableNotEqualTo(String value) {
            addCriterion("USABLE <>", value, "usable");
            return (Criteria) this;
        }

        public Criteria andUsableGreaterThan(String value) {
            addCriterion("USABLE >", value, "usable");
            return (Criteria) this;
        }

        public Criteria andUsableGreaterThanOrEqualTo(String value) {
            addCriterion("USABLE >=", value, "usable");
            return (Criteria) this;
        }

        public Criteria andUsableLessThan(String value) {
            addCriterion("USABLE <", value, "usable");
            return (Criteria) this;
        }

        public Criteria andUsableLessThanOrEqualTo(String value) {
            addCriterion("USABLE <=", value, "usable");
            return (Criteria) this;
        }

        public Criteria andUsableLike(String value) {
            addCriterion("USABLE like", value, "usable");
            return (Criteria) this;
        }

        public Criteria andUsableNotLike(String value) {
            addCriterion("USABLE not like", value, "usable");
            return (Criteria) this;
        }

        public Criteria andUsableIn(List<String> values) {
            addCriterion("USABLE in", values, "usable");
            return (Criteria) this;
        }

        public Criteria andUsableNotIn(List<String> values) {
            addCriterion("USABLE not in", values, "usable");
            return (Criteria) this;
        }

        public Criteria andUsableBetween(String value1, String value2) {
            addCriterion("USABLE between", value1, value2, "usable");
            return (Criteria) this;
        }

        public Criteria andUsableNotBetween(String value1, String value2) {
            addCriterion("USABLE not between", value1, value2, "usable");
            return (Criteria) this;
        }

        public Criteria andShowFirstIsNull() {
            addCriterion("SHOW_FIRST is null");
            return (Criteria) this;
        }

        public Criteria andShowFirstIsNotNull() {
            addCriterion("SHOW_FIRST is not null");
            return (Criteria) this;
        }

        public Criteria andShowFirstEqualTo(String value) {
            addCriterion("SHOW_FIRST =", value, "showFirst");
            return (Criteria) this;
        }

        public Criteria andShowFirstNotEqualTo(String value) {
            addCriterion("SHOW_FIRST <>", value, "showFirst");
            return (Criteria) this;
        }

        public Criteria andShowFirstGreaterThan(String value) {
            addCriterion("SHOW_FIRST >", value, "showFirst");
            return (Criteria) this;
        }

        public Criteria andShowFirstGreaterThanOrEqualTo(String value) {
            addCriterion("SHOW_FIRST >=", value, "showFirst");
            return (Criteria) this;
        }

        public Criteria andShowFirstLessThan(String value) {
            addCriterion("SHOW_FIRST <", value, "showFirst");
            return (Criteria) this;
        }

        public Criteria andShowFirstLessThanOrEqualTo(String value) {
            addCriterion("SHOW_FIRST <=", value, "showFirst");
            return (Criteria) this;
        }

        public Criteria andShowFirstLike(String value) {
            addCriterion("SHOW_FIRST like", value, "showFirst");
            return (Criteria) this;
        }

        public Criteria andShowFirstNotLike(String value) {
            addCriterion("SHOW_FIRST not like", value, "showFirst");
            return (Criteria) this;
        }

        public Criteria andShowFirstIn(List<String> values) {
            addCriterion("SHOW_FIRST in", values, "showFirst");
            return (Criteria) this;
        }

        public Criteria andShowFirstNotIn(List<String> values) {
            addCriterion("SHOW_FIRST not in", values, "showFirst");
            return (Criteria) this;
        }

        public Criteria andShowFirstBetween(String value1, String value2) {
            addCriterion("SHOW_FIRST between", value1, value2, "showFirst");
            return (Criteria) this;
        }

        public Criteria andShowFirstNotBetween(String value1, String value2) {
            addCriterion("SHOW_FIRST not between", value1, value2, "showFirst");
            return (Criteria) this;
        }

        public Criteria andNeedLoginIsNull() {
            addCriterion("NEED_LOGIN is null");
            return (Criteria) this;
        }

        public Criteria andNeedLoginIsNotNull() {
            addCriterion("NEED_LOGIN is not null");
            return (Criteria) this;
        }

        public Criteria andNeedLoginEqualTo(String value) {
            addCriterion("NEED_LOGIN =", value, "needLogin");
            return (Criteria) this;
        }

        public Criteria andNeedLoginNotEqualTo(String value) {
            addCriterion("NEED_LOGIN <>", value, "needLogin");
            return (Criteria) this;
        }

        public Criteria andNeedLoginGreaterThan(String value) {
            addCriterion("NEED_LOGIN >", value, "needLogin");
            return (Criteria) this;
        }

        public Criteria andNeedLoginGreaterThanOrEqualTo(String value) {
            addCriterion("NEED_LOGIN >=", value, "needLogin");
            return (Criteria) this;
        }

        public Criteria andNeedLoginLessThan(String value) {
            addCriterion("NEED_LOGIN <", value, "needLogin");
            return (Criteria) this;
        }

        public Criteria andNeedLoginLessThanOrEqualTo(String value) {
            addCriterion("NEED_LOGIN <=", value, "needLogin");
            return (Criteria) this;
        }

        public Criteria andNeedLoginLike(String value) {
            addCriterion("NEED_LOGIN like", value, "needLogin");
            return (Criteria) this;
        }

        public Criteria andNeedLoginNotLike(String value) {
            addCriterion("NEED_LOGIN not like", value, "needLogin");
            return (Criteria) this;
        }

        public Criteria andNeedLoginIn(List<String> values) {
            addCriterion("NEED_LOGIN in", values, "needLogin");
            return (Criteria) this;
        }

        public Criteria andNeedLoginNotIn(List<String> values) {
            addCriterion("NEED_LOGIN not in", values, "needLogin");
            return (Criteria) this;
        }

        public Criteria andNeedLoginBetween(String value1, String value2) {
            addCriterion("NEED_LOGIN between", value1, value2, "needLogin");
            return (Criteria) this;
        }

        public Criteria andNeedLoginNotBetween(String value1, String value2) {
            addCriterion("NEED_LOGIN not between", value1, value2, "needLogin");
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