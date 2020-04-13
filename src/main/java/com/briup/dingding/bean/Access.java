package com.briup.dingding.bean;

import com.briup.dingding.util.DingTalkMessage;
import com.briup.dingding.util.Message;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Cuigx@briup.com
 * 获取token实体类
 * 该实体类字段必须按照钉钉官方文档返回格式为准，不必遵守命名规范
 * 官方文档地址：https://ding-doc.dingtalk.com/doc#/serverapi2/eev437
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@ApiModel
public class Access extends DingTalkMessage {
    @ApiModelProperty(value = "通行证")
    private String access_token;
    @ApiModelProperty(value = "in")
    private int expires_in;
}
