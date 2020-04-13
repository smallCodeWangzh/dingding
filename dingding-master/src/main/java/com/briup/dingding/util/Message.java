package com.briup.dingding.util;

import lombok.Data;

import java.util.Date;

@Data
public class Message<T> {
    private int code;
    private String message;
    private long time;
    private T data;

    public Message(CodeStatus codeStatus) {
        this.code = codeStatus.getCode();
        this.message = codeStatus.getMsg();
        this.time = new Date().getTime();
    }


    public Message(CodeStatus codeStatus,T data) {
        this(codeStatus);
        this.data = data;
    }
}
