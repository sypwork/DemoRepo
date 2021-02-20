package com.candao.spas.demo.core.result;

import org.springframework.util.Assert;

import java.io.Serializable;

/**
 * 通用返回结果
 *
 * @param <T> 结果泛型
 */
public class RespData<T> implements Serializable {

    public static Integer CODE_SUCCESS = 0;

    /**
     * 错误码
     */
    private Integer code;
    /**
     * 错误提示
     */
    private String message;
    /**
     * 返回数据
     */
    private T data;

    /**
     * 将传入的 result 对象，转换成另外一个泛型结果的对象
     *
     * 因为 A 方法返回的 RespData 对象，不满足调用其的 B 方法的返回，所以需要进行转换。
     *
     * @param result 传入的 result 对象
     * @param <T> 返回的泛型
     * @return 新的 RespData 对象
     */
    public static <T> RespData<T> error(RespData<?> result) {
        return error(result.getCode(), result.getMessage());
    }

    public static <T> RespData<T> error(Integer code, String message) {
        Assert.isTrue(!CODE_SUCCESS.equals(code), "code 必须是错误的！");
        RespData<T> result = new RespData<>();
        result.code = code;
        result.message = message;
        return result;
    }

    public static <T> RespData<T> success() {
        RespData<T> result = new RespData<>();
        result.code = CODE_SUCCESS;
        result.message = "success";
        return result;
    }

    public static <T> RespData<T> success(T data) {
        RespData<T> result = new RespData<>();
        result.code = CODE_SUCCESS;
        result.data = data;
        result.message = "";
        return result;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


    @Override
    public String toString() {
        return "RespData{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

}
