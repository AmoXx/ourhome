package com.xinlizz.oh.rock.enums;

/**
 * RockErrorMsgEnum 异步任务错误信息枚举类
 *
 * @Author: xinlizz
 * @Date: 2018/8/3
 */
public enum RockErrorMsgEnum {

    /** 任务类名称为空 */
    ERR_CLASS_NAME_EMPTY("ERR_CLASS_NAME_EMPTY", "任务类名称为空"),

    /** 执行方法名称为空 */
    ERR_METHOD_NAME_EMPTY("ERR_METHOD_NAME_EMPTY", "执行方法名称为空"),

    /** 执行方法未找到 */
    ERR_METHOD_NOT_FOUND("ERR_METHOD_NOT_FOUND", "执行方法未找到"),

    /** 解析执行任务发生异常 */
    ERR_PARSE_AND_EXECUTE_JOB("ERR_PARSE_AND_EXECUTE_JOB", "解析执行任务发生异常");

    private String code;

    private String message;

    RockErrorMsgEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
