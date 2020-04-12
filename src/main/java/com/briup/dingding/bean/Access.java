package com.briup.dingding.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@ApiModel
public class Access {
    @ApiModelProperty(value = "错误编码")
    private int errcode;
    @ApiModelProperty(value = "通行证")
    private String access_token;
    @ApiModelProperty(value = "错误信息")
    private String errmsg;
    @ApiModelProperty(value = "in")
    private int expires_in;
}
