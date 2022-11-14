package edu.swu.Exception;


import edu.swu.enums.StatusCodeEnum;

public class SystemException extends RuntimeException{

    private int code;

    private String msg;

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public SystemException(StatusCodeEnum statusCodeEnum) {
        super(statusCodeEnum.getDesc());
        this.code = statusCodeEnum.getCode();
        this.msg = statusCodeEnum.getDesc();
    }
    
}
