package com.xinlizz.oh.rock.enums;

/**
 * JobStatusEnum 工作的状态枚举类
 *
 * @Author: xinlizz
 * @Date: 2018/8/3
 */
public enum  JobStatusEnum {

    /** 待执行——初始态 */
    WAITING,

    /** 执行中——运行态 */
    RUNNING,

    /** 已失败——完结态 */
    FAILURE,

    /** 已成功——完结态 */
    SUCCESS;
}
