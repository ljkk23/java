package org.example.utils;

import java.io.Serializable;

public class toJson<E> implements Serializable {

    private String message;
    private E data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public toJson() {
        super();
    }


    /** 出现异常时调用 */
    public toJson(Throwable e) {
        super();
        // 获取异常对象中的异常信息
        this.message = e.getMessage();
    }
    public toJson(E data) {
        super();
        this.data = data;
    }
}
