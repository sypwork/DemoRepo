package com.candao.spas.demo.core.exception;

import com.candao.spas.demo.enums.ServiceExceptionEnum;

/**
 * 服务异常
 *
 */
public final class ServiceException extends RuntimeException {

    /**
     * 错误码
     */
    private final Integer code;

    public ServiceException(ServiceExceptionEnum serviceExceptionEnum) {
        // 使用父类的 message 字段
        super(serviceExceptionEnum.getMessage());
        // 设置错误码
        this.code = serviceExceptionEnum.getCode();
    }

    public ServiceException(Integer code,String message) {
        // 使用父类的 message 字段
        super(message);
        // 设置错误码
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

}
