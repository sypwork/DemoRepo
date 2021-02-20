package com.candao.spas.demo.enums;

/**
 * 业务异常枚举
 */
public enum ServiceExceptionEnum {

    // ========== 系统级别 ==========
    SUCCESS(0, "成功"),
    SYS_ERROR(50000, "服务端发生异常"),
    MISSING_REQUEST_PARAM_ERROR(50001, "参数缺失"),
    INVALID_REQUEST_PARAM_ERROR(50002, "请求参数不合法"),

    // ========== 用户模块 ==========
    USER_NOT_FOUND(10001, "用户不存在"),


    ;

    /**
     * 错误码
     */
    private final int code;
    /**
     * 错误提示
     */
    private final String message;

    ServiceExceptionEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
