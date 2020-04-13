package com.briup.dingding.util;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * @author cuigx@briup.com
 * @param <T>
 */

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
