package com.sdt.exception;

/**
 * 自定义异常信息类
 * 可以抛有自己提示信息的异常
 */
public class SysException extends Exception {

    //存储提示信息的
    private String message;

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public SysException(String message) {
        this.message = message;
    }
}
