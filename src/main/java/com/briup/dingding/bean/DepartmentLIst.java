package com.briup.dingding.bean;

import com.briup.dingding.util.DingTalkMessage;
import com.briup.dingding.util.Message;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * @author cuigx@briup.com
 * 部门列表实体类
 * 该实体类字段必须按照钉钉官方文档返回格式为准，不必遵守命名规范
 * 文档地址：https://ding-doc.dingtalk.com/doc#/serverapi2/dubakq/e6e1604e
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@ApiModel
public class DepartmentLIst extends DingTalkMessage {
    @ApiModelProperty(value = "部门列表")
    private List<DepartmentMini> department;
}
