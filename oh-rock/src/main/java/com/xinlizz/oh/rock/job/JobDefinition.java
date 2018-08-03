package com.xinlizz.oh.rock.job;

import com.xinlizz.oh.rock.enums.JobStatusEnum;

import java.io.Serializable;

/**
 * JobDefinition 工作定义类
 *
 * @Author: xinlizz
 * @Date: 2018/8/3
 */
public class JobDefinition implements Serializable {

    private static final long serialVersionUID = 832815501827081333L;

    /** 工作顺序 */
    private int sort;

    /** 工作类名 */
    private String className;

    /** 工作执行方法名 */
    private String methodName;

    /** 工作执行方法所需参数 */
    private Object[] params;

    /** 工作状态 */
    private JobStatusEnum status;

    /** 失败次数 */
    private int failNum;

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Object[] getParams() {
        return params;
    }

    public void setParams(Object[] params) {
        this.params = params;
    }

    public JobStatusEnum getStatus() {
        return status;
    }

    public void setStatus(JobStatusEnum status) {
        this.status = status;
    }

    public int getFailNum() {
        return failNum;
    }

    public void setFailNum(int failNum) {
        this.failNum = failNum;
    }

    @Override
    public String toString() {
        return "JobDefinition{" +
                "sort=" + sort +
                ", className='" + className + '\'' +
                ", methodName='" + methodName + '\'' +
                ", status=" + status +
                '}';
    }
}
