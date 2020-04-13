package com.briup.dingding.util;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *钉钉返回数据接收父类
 * 主要封装共有的信息码和信息正文，其余实体类继承自此父类
 */

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@ApiModel
public class DingTalkMessage {
    @ApiModelProperty(value = "返回码")
    private int errcode;
    @ApiModelProperty(value = "返回信息")
    private String errmsg;
}
