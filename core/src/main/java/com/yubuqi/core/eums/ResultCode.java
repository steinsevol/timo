package com.yubuqi.core.eums;

public enum ResultCode {
    // 成功
    SUCCESS(200,"成功"),

    // 失败
    FAIL(400,"失败"),

    //
    UNAUTHORIZED(401,"未认证（签名错误）"),

    //未知的来源
    UNKNOWN_SOURCE(402,"未知的来源"),
    // 接口不存在
    NOT_FOUND(404,"接口不存在"),

    BUSINESS_ERROR(409,"业务异常"),

    // 服务器内部错误
    INTERNAL_SERVER_ERROR(500,"服务器内部错误");

    private int code;
    private String name;

    ResultCode(int code,String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int name) {
        this.code = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
