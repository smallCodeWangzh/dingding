package com.briup.dingding.bean;

import com.briup.dingding.util.DingTalkMessage;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * @author cuigx@briup.com
 * 获取父部门id列表实体类
 * 该实体类字段必须按照钉钉官方文档返回格式为准，不必遵守命名规范
 * 文档地址：https://ding-doc.dingtalk.com/doc#/serverapi2/dubakq/e6e1604e
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@ApiModel
public class DepartmentResult extends DingTalkMessage {
    @ApiModelProperty(value = "通过用户查询到的父部门列表使用此属性")
    private List<Long> department;
    @ApiModelProperty(value = "通过部门查询到的父部门列表使用此属性")
    private List<Long> parentIds;

}
