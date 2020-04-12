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
public class DepartmentDetail {
    @ApiModelProperty(value = "返回码")
    private int errcode;
    @ApiModelProperty(value = "可以查看指定隐藏部门的其他人员列表，如果部门隐藏，则此值生效，取值为其他的人员userid组成的的字符串，使用“\\|”符号进行分割")
    private String userPermits;
    @ApiModelProperty(value = "无意义字段1")
    private String userPerimits;
    @ApiModelProperty(value = "是否本部门的员工仅可见员工自己，为true时，本部门员工默认只能看到员工自己")
    private boolean outerDept;
    @ApiModelProperty(value = "对返回码的文本描述内容")
    private String errmsg;
    @ApiModelProperty(value = "部门的主管列表，取值为由主管的userid组成的字符串，不同的userid使用“\\|”符号进行分割")
    private String deptManagerUseridList;
    @ApiModelProperty(value = "父部门id，根部门为1")
    private long parentid;
    @ApiModelProperty(value = "部门群是否包含子部门")
    private boolean groupContainSubDept;
    @ApiModelProperty(value = "本部门的员工仅可见员工自己为true时，可以配置额外可见人员，值为userid组成的的字符串，使用“\\|”符号进行分割")
    private String outerPermitUsers;
    @ApiModelProperty(value = "本部门的员工仅可见员工自己为true时，可以配置额外可见部门，值为部门id组成的的字符串，使用“\\|”符号进行分割")
    private String outerPermitDepts;
    @ApiModelProperty(value = "无意义字段2")
    private String deptPerimits;
    @ApiModelProperty(value = "是否同步创建一个关联此部门的企业群，true表示是，false表示不是")
    private boolean createDeptGroup;
    @ApiModelProperty(value = "部门名称")
    private String name;
    @ApiModelProperty(value = "部门id")
    private long id;
    @ApiModelProperty(value = "当部门群已经创建后，是否有新人加入部门会自动加入该群，true表示是，false表示不是")
    private boolean autoAddUser;
    @ApiModelProperty(value = "是否隐藏部门，true表示隐藏，false表示显示")
    private boolean deptHiding;
    @ApiModelProperty(value = "可以查看指定隐藏部门的其他部门列表，如果部门隐藏，则此值生效，取值为其他的部门id组成的的字符串，使用“\\|”符号进行分割")
    private String deptPermits;
    @ApiModelProperty(value = "当前部门在父部门下的所有子部门中的排序值")
    private int order;
}
