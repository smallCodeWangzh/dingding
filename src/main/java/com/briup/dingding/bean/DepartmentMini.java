package com.briup.dingding.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author cuigx@briup.com
 * 部门列表中部门简单展示实体类
 * 该实体类字段必须按照钉钉官方文档返回格式为准，不必遵守命名规范
 * 文档地址：https://ding-doc.dingtalk.com/doc#/serverapi2/dubakq/e6e1604e
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@ApiModel
public class DepartmentMini {
    @ApiModelProperty(value = "是否同步创建一个关联此部门的企业群，true表示是，false表示不是")
    private  boolean createDeptGroup;
    @ApiModelProperty(value = "部门名称")
    private  String name;
    @ApiModelProperty(value = "部门id")
    private  long id;
    @ApiModelProperty(value = "当群已经创建后，是否有新人加入部门会自动加入该群, true表示是，false表示不是")
    private  boolean autoAddUser;
    @ApiModelProperty(value = "父部门id，根部门为1")
    private  long parentid;
    @ApiModelProperty(value = "部门自定义字段")
    private String ext;
    @ApiModelProperty(value = "标记")
    private String tags;
}
