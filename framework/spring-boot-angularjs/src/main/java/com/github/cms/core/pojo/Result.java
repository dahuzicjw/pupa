package com.github.cms.core.pojo;

import com.alibaba.fastjson2.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

public class Result<E> implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("请求响应状态,参考字典ResultStatus")
    private Integer status;
    @ApiModelProperty("消息提示")
    private String message;
    @ApiModelProperty("返回结果")
    private E infobean;

    public Result(Integer status, String message, E infobean) {
        this.status = status;
        this.message = message;
        this.infobean = infobean;
    }
    public Result() {}

    public E getInfobean() {
        return infobean;
    }
    public void setInfobean(E infobean) {
        this.infobean = infobean;
    }
    public Integer getStatus() {
        return status;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    @JSONField(serialize = false)
    @JsonIgnore
    public boolean isSuccess() {
        return status == ResultStatus.Success.code;
    }
    @JSONField(serialize = false)
    @JsonIgnore
    public boolean isFailure() {
        return status != ResultStatus.Success.code;
    }

    /**
     * 业务处理成功
     * @param message 提示信息
     * @param <T>
     * @return
     */
    public static <T> Result<T> success(String message) {
        return success(message, null);
    }

    /**
     * 业务处理成功
     * @param <T>
     * @return
     */
    public static <T> Result<T> success() {
        return success(null, null);
    }

    /**
     * 业务处理成功
     * @param infobean 返回数据对象， 不能为String类型，否则当成提示信息返回
     * @param <T>
     * @return
     */
    public static <T> Result<T> success(T infobean) {
        return success(null, infobean);
    }
    public static <T> Result<T> success(String message, T infobean) {
        return new Result(ResultStatus.Success.code, message, infobean);
    }

    /**
     * 业务处理失败
     * @param message 提示信息
     * @param <T>
     * @return
     */
    public static <T> Result<T> failure(String message) {
        return failure(message, null);
    }
    public static <T> Result<T> failure(String message, T infobean) {
        return new Result(ResultStatus.Failure.code, message, infobean);
    }
    private static final String ERROR_MESSAGE_TEMPLATE =
            "时发生异常，请检查内容是否填写正常后重试，如再次失败请联系客服或技术人员，谢谢！";

    /**
     * 系统繁盛异常
     * @param moduleName
     * @param e
     * @param <T>
     * @return
     */
    public static <T> Result<T> error(String moduleName, Exception e) {
        e.printStackTrace();
        return new Result(ResultStatus.Error.code,
                moduleName + ERROR_MESSAGE_TEMPLATE, null);
    }

    /**
     * 实名认证，补全身份信息
     * @param message
     * @param infobean
     * @param <T>
     * @return
     */
    public static <T> Result<T> authentication(String message, T infobean) {
        return new Result(ResultStatus.Authentication.code, message, infobean);
    }
    public static <T> Result<T> set(Integer status, String message, T infobean) {
        return new Result(status, message, infobean);
    }

    /**
     * Result字段Status、Message复制
     * @param result
     * @param <T>
     * @return
     */
    public static <T> Result<T> valueOf(Result result) {
        return set(result.getStatus(), result.getMessage(), null);
    }

    public static <T> Result page(List<T> infobean) {
        return set(ResultStatus.Success.code, null, new PageResult(infobean));
    }
}
