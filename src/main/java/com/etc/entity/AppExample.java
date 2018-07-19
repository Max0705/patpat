package com.etc.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class AppExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table app
     *
     * @mbggenerated Thu Jul 19 15:40:10 CST 2018
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table app
     *
     * @mbggenerated Thu Jul 19 15:40:10 CST 2018
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table app
     *
     * @mbggenerated Thu Jul 19 15:40:10 CST 2018
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table app
     *
     * @mbggenerated Thu Jul 19 15:40:10 CST 2018
     */
    public AppExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table app
     *
     * @mbggenerated Thu Jul 19 15:40:10 CST 2018
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table app
     *
     * @mbggenerated Thu Jul 19 15:40:10 CST 2018
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table app
     *
     * @mbggenerated Thu Jul 19 15:40:10 CST 2018
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table app
     *
     * @mbggenerated Thu Jul 19 15:40:10 CST 2018
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table app
     *
     * @mbggenerated Thu Jul 19 15:40:10 CST 2018
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table app
     *
     * @mbggenerated Thu Jul 19 15:40:10 CST 2018
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table app
     *
     * @mbggenerated Thu Jul 19 15:40:10 CST 2018
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table app
     *
     * @mbggenerated Thu Jul 19 15:40:10 CST 2018
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table app
     *
     * @mbggenerated Thu Jul 19 15:40:10 CST 2018
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table app
     *
     * @mbggenerated Thu Jul 19 15:40:10 CST 2018
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table app
     *
     * @mbggenerated Thu Jul 19 15:40:10 CST 2018
     */
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andAppidIsNull() {
            addCriterion("appId is null");
            return (Criteria) this;
        }

        public Criteria andAppidIsNotNull() {
            addCriterion("appId is not null");
            return (Criteria) this;
        }

        public Criteria andAppidEqualTo(Integer value) {
            addCriterion("appId =", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidNotEqualTo(Integer value) {
            addCriterion("appId <>", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidGreaterThan(Integer value) {
            addCriterion("appId >", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidGreaterThanOrEqualTo(Integer value) {
            addCriterion("appId >=", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidLessThan(Integer value) {
            addCriterion("appId <", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidLessThanOrEqualTo(Integer value) {
            addCriterion("appId <=", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidIn(List<Integer> values) {
            addCriterion("appId in", values, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidNotIn(List<Integer> values) {
            addCriterion("appId not in", values, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidBetween(Integer value1, Integer value2) {
            addCriterion("appId between", value1, value2, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidNotBetween(Integer value1, Integer value2) {
            addCriterion("appId not between", value1, value2, "appid");
            return (Criteria) this;
        }

        public Criteria andAppnameIsNull() {
            addCriterion("appName is null");
            return (Criteria) this;
        }

        public Criteria andAppnameIsNotNull() {
            addCriterion("appName is not null");
            return (Criteria) this;
        }

        public Criteria andAppnameEqualTo(String value) {
            addCriterion("appName =", value, "appname");
            return (Criteria) this;
        }

        public Criteria andAppnameNotEqualTo(String value) {
            addCriterion("appName <>", value, "appname");
            return (Criteria) this;
        }

        public Criteria andAppnameGreaterThan(String value) {
            addCriterion("appName >", value, "appname");
            return (Criteria) this;
        }

        public Criteria andAppnameGreaterThanOrEqualTo(String value) {
            addCriterion("appName >=", value, "appname");
            return (Criteria) this;
        }

        public Criteria andAppnameLessThan(String value) {
            addCriterion("appName <", value, "appname");
            return (Criteria) this;
        }

        public Criteria andAppnameLessThanOrEqualTo(String value) {
            addCriterion("appName <=", value, "appname");
            return (Criteria) this;
        }

        public Criteria andAppnameLike(String value) {
            addCriterion("appName like", value, "appname");
            return (Criteria) this;
        }

        public Criteria andAppnameNotLike(String value) {
            addCriterion("appName not like", value, "appname");
            return (Criteria) this;
        }

        public Criteria andAppnameIn(List<String> values) {
            addCriterion("appName in", values, "appname");
            return (Criteria) this;
        }

        public Criteria andAppnameNotIn(List<String> values) {
            addCriterion("appName not in", values, "appname");
            return (Criteria) this;
        }

        public Criteria andAppnameBetween(String value1, String value2) {
            addCriterion("appName between", value1, value2, "appname");
            return (Criteria) this;
        }

        public Criteria andAppnameNotBetween(String value1, String value2) {
            addCriterion("appName not between", value1, value2, "appname");
            return (Criteria) this;
        }

        public Criteria andAppiconIsNull() {
            addCriterion("appIcon is null");
            return (Criteria) this;
        }

        public Criteria andAppiconIsNotNull() {
            addCriterion("appIcon is not null");
            return (Criteria) this;
        }

        public Criteria andAppiconEqualTo(String value) {
            addCriterion("appIcon =", value, "appicon");
            return (Criteria) this;
        }

        public Criteria andAppiconNotEqualTo(String value) {
            addCriterion("appIcon <>", value, "appicon");
            return (Criteria) this;
        }

        public Criteria andAppiconGreaterThan(String value) {
            addCriterion("appIcon >", value, "appicon");
            return (Criteria) this;
        }

        public Criteria andAppiconGreaterThanOrEqualTo(String value) {
            addCriterion("appIcon >=", value, "appicon");
            return (Criteria) this;
        }

        public Criteria andAppiconLessThan(String value) {
            addCriterion("appIcon <", value, "appicon");
            return (Criteria) this;
        }

        public Criteria andAppiconLessThanOrEqualTo(String value) {
            addCriterion("appIcon <=", value, "appicon");
            return (Criteria) this;
        }

        public Criteria andAppiconLike(String value) {
            addCriterion("appIcon like", value, "appicon");
            return (Criteria) this;
        }

        public Criteria andAppiconNotLike(String value) {
            addCriterion("appIcon not like", value, "appicon");
            return (Criteria) this;
        }

        public Criteria andAppiconIn(List<String> values) {
            addCriterion("appIcon in", values, "appicon");
            return (Criteria) this;
        }

        public Criteria andAppiconNotIn(List<String> values) {
            addCriterion("appIcon not in", values, "appicon");
            return (Criteria) this;
        }

        public Criteria andAppiconBetween(String value1, String value2) {
            addCriterion("appIcon between", value1, value2, "appicon");
            return (Criteria) this;
        }

        public Criteria andAppiconNotBetween(String value1, String value2) {
            addCriterion("appIcon not between", value1, value2, "appicon");
            return (Criteria) this;
        }

        public Criteria andAppdownloadsIsNull() {
            addCriterion("appDownloads is null");
            return (Criteria) this;
        }

        public Criteria andAppdownloadsIsNotNull() {
            addCriterion("appDownloads is not null");
            return (Criteria) this;
        }

        public Criteria andAppdownloadsEqualTo(String value) {
            addCriterion("appDownloads =", value, "appdownloads");
            return (Criteria) this;
        }

        public Criteria andAppdownloadsNotEqualTo(String value) {
            addCriterion("appDownloads <>", value, "appdownloads");
            return (Criteria) this;
        }

        public Criteria andAppdownloadsGreaterThan(String value) {
            addCriterion("appDownloads >", value, "appdownloads");
            return (Criteria) this;
        }

        public Criteria andAppdownloadsGreaterThanOrEqualTo(String value) {
            addCriterion("appDownloads >=", value, "appdownloads");
            return (Criteria) this;
        }

        public Criteria andAppdownloadsLessThan(String value) {
            addCriterion("appDownloads <", value, "appdownloads");
            return (Criteria) this;
        }

        public Criteria andAppdownloadsLessThanOrEqualTo(String value) {
            addCriterion("appDownloads <=", value, "appdownloads");
            return (Criteria) this;
        }

        public Criteria andAppdownloadsLike(String value) {
            addCriterion("appDownloads like", value, "appdownloads");
            return (Criteria) this;
        }

        public Criteria andAppdownloadsNotLike(String value) {
            addCriterion("appDownloads not like", value, "appdownloads");
            return (Criteria) this;
        }

        public Criteria andAppdownloadsIn(List<String> values) {
            addCriterion("appDownloads in", values, "appdownloads");
            return (Criteria) this;
        }

        public Criteria andAppdownloadsNotIn(List<String> values) {
            addCriterion("appDownloads not in", values, "appdownloads");
            return (Criteria) this;
        }

        public Criteria andAppdownloadsBetween(String value1, String value2) {
            addCriterion("appDownloads between", value1, value2, "appdownloads");
            return (Criteria) this;
        }

        public Criteria andAppdownloadsNotBetween(String value1, String value2) {
            addCriterion("appDownloads not between", value1, value2, "appdownloads");
            return (Criteria) this;
        }

        public Criteria andAppdateIsNull() {
            addCriterion("appDate is null");
            return (Criteria) this;
        }

        public Criteria andAppdateIsNotNull() {
            addCriterion("appDate is not null");
            return (Criteria) this;
        }

        public Criteria andAppdateEqualTo(Date value) {
            addCriterionForJDBCDate("appDate =", value, "appdate");
            return (Criteria) this;
        }

        public Criteria andAppdateNotEqualTo(Date value) {
            addCriterionForJDBCDate("appDate <>", value, "appdate");
            return (Criteria) this;
        }

        public Criteria andAppdateGreaterThan(Date value) {
            addCriterionForJDBCDate("appDate >", value, "appdate");
            return (Criteria) this;
        }

        public Criteria andAppdateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("appDate >=", value, "appdate");
            return (Criteria) this;
        }

        public Criteria andAppdateLessThan(Date value) {
            addCriterionForJDBCDate("appDate <", value, "appdate");
            return (Criteria) this;
        }

        public Criteria andAppdateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("appDate <=", value, "appdate");
            return (Criteria) this;
        }

        public Criteria andAppdateIn(List<Date> values) {
            addCriterionForJDBCDate("appDate in", values, "appdate");
            return (Criteria) this;
        }

        public Criteria andAppdateNotIn(List<Date> values) {
            addCriterionForJDBCDate("appDate not in", values, "appdate");
            return (Criteria) this;
        }

        public Criteria andAppdateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("appDate between", value1, value2, "appdate");
            return (Criteria) this;
        }

        public Criteria andAppdateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("appDate not between", value1, value2, "appdate");
            return (Criteria) this;
        }

        public Criteria andApptypeIsNull() {
            addCriterion("appType is null");
            return (Criteria) this;
        }

        public Criteria andApptypeIsNotNull() {
            addCriterion("appType is not null");
            return (Criteria) this;
        }

        public Criteria andApptypeEqualTo(String value) {
            addCriterion("appType =", value, "apptype");
            return (Criteria) this;
        }

        public Criteria andApptypeNotEqualTo(String value) {
            addCriterion("appType <>", value, "apptype");
            return (Criteria) this;
        }

        public Criteria andApptypeGreaterThan(String value) {
            addCriterion("appType >", value, "apptype");
            return (Criteria) this;
        }

        public Criteria andApptypeGreaterThanOrEqualTo(String value) {
            addCriterion("appType >=", value, "apptype");
            return (Criteria) this;
        }

        public Criteria andApptypeLessThan(String value) {
            addCriterion("appType <", value, "apptype");
            return (Criteria) this;
        }

        public Criteria andApptypeLessThanOrEqualTo(String value) {
            addCriterion("appType <=", value, "apptype");
            return (Criteria) this;
        }

        public Criteria andApptypeLike(String value) {
            addCriterion("appType like", value, "apptype");
            return (Criteria) this;
        }

        public Criteria andApptypeNotLike(String value) {
            addCriterion("appType not like", value, "apptype");
            return (Criteria) this;
        }

        public Criteria andApptypeIn(List<String> values) {
            addCriterion("appType in", values, "apptype");
            return (Criteria) this;
        }

        public Criteria andApptypeNotIn(List<String> values) {
            addCriterion("appType not in", values, "apptype");
            return (Criteria) this;
        }

        public Criteria andApptypeBetween(String value1, String value2) {
            addCriterion("appType between", value1, value2, "apptype");
            return (Criteria) this;
        }

        public Criteria andApptypeNotBetween(String value1, String value2) {
            addCriterion("appType not between", value1, value2, "apptype");
            return (Criteria) this;
        }

        public Criteria andApplinkIsNull() {
            addCriterion("appLink is null");
            return (Criteria) this;
        }

        public Criteria andApplinkIsNotNull() {
            addCriterion("appLink is not null");
            return (Criteria) this;
        }

        public Criteria andApplinkEqualTo(String value) {
            addCriterion("appLink =", value, "applink");
            return (Criteria) this;
        }

        public Criteria andApplinkNotEqualTo(String value) {
            addCriterion("appLink <>", value, "applink");
            return (Criteria) this;
        }

        public Criteria andApplinkGreaterThan(String value) {
            addCriterion("appLink >", value, "applink");
            return (Criteria) this;
        }

        public Criteria andApplinkGreaterThanOrEqualTo(String value) {
            addCriterion("appLink >=", value, "applink");
            return (Criteria) this;
        }

        public Criteria andApplinkLessThan(String value) {
            addCriterion("appLink <", value, "applink");
            return (Criteria) this;
        }

        public Criteria andApplinkLessThanOrEqualTo(String value) {
            addCriterion("appLink <=", value, "applink");
            return (Criteria) this;
        }

        public Criteria andApplinkLike(String value) {
            addCriterion("appLink like", value, "applink");
            return (Criteria) this;
        }

        public Criteria andApplinkNotLike(String value) {
            addCriterion("appLink not like", value, "applink");
            return (Criteria) this;
        }

        public Criteria andApplinkIn(List<String> values) {
            addCriterion("appLink in", values, "applink");
            return (Criteria) this;
        }

        public Criteria andApplinkNotIn(List<String> values) {
            addCriterion("appLink not in", values, "applink");
            return (Criteria) this;
        }

        public Criteria andApplinkBetween(String value1, String value2) {
            addCriterion("appLink between", value1, value2, "applink");
            return (Criteria) this;
        }

        public Criteria andApplinkNotBetween(String value1, String value2) {
            addCriterion("appLink not between", value1, value2, "applink");
            return (Criteria) this;
        }

        public Criteria andAppscoreIsNull() {
            addCriterion("appScore is null");
            return (Criteria) this;
        }

        public Criteria andAppscoreIsNotNull() {
            addCriterion("appScore is not null");
            return (Criteria) this;
        }

        public Criteria andAppscoreEqualTo(Float value) {
            addCriterion("appScore =", value, "appscore");
            return (Criteria) this;
        }

        public Criteria andAppscoreNotEqualTo(Float value) {
            addCriterion("appScore <>", value, "appscore");
            return (Criteria) this;
        }

        public Criteria andAppscoreGreaterThan(Float value) {
            addCriterion("appScore >", value, "appscore");
            return (Criteria) this;
        }

        public Criteria andAppscoreGreaterThanOrEqualTo(Float value) {
            addCriterion("appScore >=", value, "appscore");
            return (Criteria) this;
        }

        public Criteria andAppscoreLessThan(Float value) {
            addCriterion("appScore <", value, "appscore");
            return (Criteria) this;
        }

        public Criteria andAppscoreLessThanOrEqualTo(Float value) {
            addCriterion("appScore <=", value, "appscore");
            return (Criteria) this;
        }

        public Criteria andAppscoreIn(List<Float> values) {
            addCriterion("appScore in", values, "appscore");
            return (Criteria) this;
        }

        public Criteria andAppscoreNotIn(List<Float> values) {
            addCriterion("appScore not in", values, "appscore");
            return (Criteria) this;
        }

        public Criteria andAppscoreBetween(Float value1, Float value2) {
            addCriterion("appScore between", value1, value2, "appscore");
            return (Criteria) this;
        }

        public Criteria andAppscoreNotBetween(Float value1, Float value2) {
            addCriterion("appScore not between", value1, value2, "appscore");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table app
     *
     * @mbggenerated do_not_delete_during_merge Thu Jul 19 15:40:10 CST 2018
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table app
     *
     * @mbggenerated Thu Jul 19 15:40:10 CST 2018
     */
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