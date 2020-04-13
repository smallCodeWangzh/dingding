package com.briup.dingding.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CodeStatus {
    SUCCESS(200,"SUCCESS"),
    ERROR(500,"服务器内部错误");
    private int code;
    private String msg;
}
