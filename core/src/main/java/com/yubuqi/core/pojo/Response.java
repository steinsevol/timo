package com.yubuqi.core.pojo;

import com.yubuqi.core.base.ResponseResult;
import com.yubuqi.core.eums.ResultCode;

public class Response {
    public static <T> ResponseResult<T> makeOKRsp() {
        return new ResponseResult<T>().setCode(ResultCode.SUCCESS.getCode()).setMsg(ResultCode.SUCCESS.getName());
    }

    public static <T> ResponseResult<T> makeOKRsp(String message) {
        return new ResponseResult<T>().setCode(ResultCode.SUCCESS.getCode()).setMsg(message);
    }

    public static <T> ResponseResult<T> makeOKRsp(T data) {
        return new ResponseResult<T>().setCode(ResultCode.SUCCESS.getCode()).setMsg(ResultCode.SUCCESS.getName()).setData(data);
    }

    public static <T> ResponseResult<T> makeErrRsp(String message) {
        return new ResponseResult<T>().setCode(ResultCode.BUSINESS_ERROR.getCode()).setMsg(message);
    }

    public static <T> ResponseResult<T> makeServerErrRsp(String message) {
        return new ResponseResult<T>().setCode(ResultCode.INTERNAL_SERVER_ERROR.getCode()).setMsg(message);
    }


    public static <T> ResponseResult<T> makeUnknownSourceRsp(String message) {
        return new ResponseResult<T>().setCode(ResultCode.UNKNOWN_SOURCE.getCode()).setMsg(message);
    }

    public static <T> ResponseResult<T> makeNotFoundRsp(String message) {
        return new ResponseResult<T>().setCode(ResultCode.NOT_FOUND.getCode()).setMsg(message);
    }


    public static <T> ResponseResult<T> makeRsp(int code, String msg) {
        return new ResponseResult<T>().setCode(code).setMsg(msg);
    }

    public static <T> ResponseResult<T> makeRsp(int code, String msg, T data) {
        return new ResponseResult<T>().setCode(code).setMsg(msg).setData(data);
    }

    public static <T> ResponseResult<T> makeUnAuthErrRsp(String message) {
        return new ResponseResult<T>().setCode(ResultCode.UNAUTHORIZED.getCode()).setMsg(message);
    }
}
