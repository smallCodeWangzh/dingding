package com.briup.dingding.util;

/**
 * @author cuigx@briup.com
 * 钉钉请求接口地址汇总
 */
public class DingTalkRequestURL {

    /**
     * AppKey
     */
    public static final String APP_KEY = "dingtr8oxqmbqmywxgot";
    /**
     * AppSecret
     */
    public static final String APP_SECRET = "qhz2jl1QK6Xu0WO_kCd-KZ8-pOS6xlPg43pinvJ1tkFMZDpOTaf307MH-nBM07wR";
    /**
     * 获取accecc_token值
     */
    public static final String TOKEN_URL = "https://oapi.dingtalk.com/gettoken";

    /**
     *获取部门列表。默认为根部门遍历所有子部门
     */
    public static final String DEPT_LIST = "https://oapi.dingtalk.com/department/list";
    /**
     *通过部门id查询部门详情
     */
    public static final String DEPT_DETAIL_BY_ID = "https://oapi.dingtalk.com/department/get";
    /**
     *通过部门id查询所有的父部门，返回的结果按顺序依次为当前部门id及其所有父部门的ID，直到根部门
     */
    public static final String DEPTS_BY_DEPT = "https://oapi.dingtalk.com/department/list_parent_depts_by_dept";
    /**
     *通过用户id查询所有的父部门，返回的结果按顺序依次为当前部门id及其所有父部门的ID，直到根部门
     */
    public static final String DEPTS_BY_USER = "https://oapi.dingtalk.com/department/list_parent_depts";
}
