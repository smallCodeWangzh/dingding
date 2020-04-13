package com.briup.dingding.bean;

import com.dingtalk.api.request.OapiDepartmentUpdateRequest;
import io.swagger.annotations.ApiModelProperty;

public class UpdateDepartment extends OapiDepartmentUpdateRequest {
   /* @ApiModelProperty(value = "调用接口凭证")
    private String access_token;*/

    @ApiModelProperty(value = "通讯录语言(默认zh_CN另外支持en_US)，长度限制为1~64个字符，不允许包含字符‘-’‘，’以及‘,’")
    private String lang;

    @ApiModelProperty(value = "部门名称，长度限制为1~64个字符，不允许包含字符‘-’‘，’以及‘,’")
    private String name;

    @ApiModelProperty(value = "父部门id，根部门id为1")
    private String parentid;

    @ApiModelProperty(value = "在父部门中的排序值，order值小的排序靠前")
    private String order;

    @ApiModelProperty(value = "部门id")
    private Boolean id;

    @ApiModelProperty(value = "是否创建一个关联此部门的企业群，默认为false")
    private Boolean createDeptGroup;

    @ApiModelProperty(value = "部门群是否包含子部门")
    private Boolean groupContainSubDept;

    @ApiModelProperty(value = "部门群是否包含外包部门")
    private Boolean groupContainOuterDept;

    @ApiModelProperty(value = "部门群是否包含隐藏部门")
    private Boolean groupContainHiddenDept;

    @ApiModelProperty(value = "如果有新人加入部门是否会自动加入部门群")
    private Boolean autoAddUser;

    @ApiModelProperty(value = "部门的主管列表，取值为由主管的userid组成的字符串，不同的userid使用“\\|”符号进行分割")
    private Boolean deptManagerUseridList;

    @ApiModelProperty(value = "是否隐藏部门，true表示隐藏,false表示显示")
    private Boolean deptHiding;

    @ApiModelProperty(value = "可以查看指定隐藏部门的其他部门列表，如果部门隐藏，则此值生效，取值为其他的部门id组成的的字符串，使用“\\|”符号进行分割。总数不能超过200")
    private String deptPermits;

    @ApiModelProperty(value = "可以查看指定隐藏部门的其他人员列表，如果部门隐藏，则此值生效，取值为其他的人员userid组成的字符串，使用“\\|”符号进行分割。总数不能超过200")
    private  String userPermits;

    @ApiModelProperty(value = "是否本部门的员工仅可见员工自己，为true时，本部门员工默认只能看到员工自己")
    private Boolean outerDept;

    @ApiModelProperty(value = "本部门的员工仅可见员工自己为true时，可以配置额外可见部门，值为部门id组成的的字符串，使用\\|符号进行分割。总数不能超过200")
    private String outerPermitDepts;

    @ApiModelProperty(value = "本部门的员工仅可见员工自己为true时，可以配置额外可见人员，值为userid组成的的字符串，使用\\|符号进行分割。总数不能超过200")
    private String outerPermitUsers;

    @ApiModelProperty(value = "outerDept为true时，可以配置该字段，为true时，表示只能看到所在部门及下级部门通讯录")
    private Boolean outerDeptOnlySelf;

    @ApiModelProperty(value = "企业群群主的userid")
    private String orgDeptOwner;

    @ApiModelProperty(value = "部门标识字段，开发者可用该字段来唯一标识一个部门，并与钉钉外部通讯录里的部门做映射")
    private String sourceIdentifier;

    @ApiModelProperty(value = "部门自定义字段，格式为文本类型的Json格式")
    private int ext;

}
