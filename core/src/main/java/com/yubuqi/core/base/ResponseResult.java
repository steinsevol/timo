package com.yubuqi.core.base;


import com.yubuqi.core.eums.ResultCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(value= "返回体")
public class ResponseResult<T>{
    @ApiModelProperty(value = "返回状态码200成功")
    public int code; //返回状态码200成功
    @ApiModelProperty(value = "返回描述信息")
    private String msg; //返回描述信息
    @ApiModelProperty(value = "返回内容体")
    private T data; //返回内容体

    public ResponseResult<T> setCode(ResultCode retCode) {
        this.code = retCode.getCode();
        return this;
    }

    public int getCode() {
        return code;
    }

    public ResponseResult<T> setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public ResponseResult<T> setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public T getData() {
        return data;
    }

    public ResponseResult<T> setData(T data) {
        this.data = data;
        return this;
    }

}
