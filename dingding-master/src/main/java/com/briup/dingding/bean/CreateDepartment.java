package com.briup.dingding.bean;

import com.dingtalk.api.request.OapiDepartmentCreateRequest;
import com.dingtalk.api.request.OapiDepartmentUpdateRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;

public class CreateDepartment extends OapiDepartmentCreateRequest {
    @ApiModelProperty(value = "部门名称，长度限制为1~64个字符，不允许包含字符‘-’‘，’以及‘,’")
    private String name;

    @ApiModelProperty(value = "父部门id，根部门id为1")
    private String parentid;

    @ApiModelProperty(value = "在父部门中的排序值，order值小的排序靠前")
    private String order;

    @ApiModelProperty(value = "是否创建一个关联此部门的企业群，默认为false")
    private Boolean createDeptGroup;

    @ApiModelProperty(value = "是否隐藏部门:true表示隐藏;false表示显示")
    private Boolean deptHiding;

    @ApiModelProperty(value = "可以查看指定隐藏部门的其他部门列表，如果部门隐藏，则此值生效，取值为其他的部门id组成的" +
            "字符串，使用“\\|”符号进行分割。总数不能超过200",required = false)
    private String deptPermits;

    @ApiModelProperty(value = "可以查看指定隐藏部门的其他人员列表，如果部门隐藏，则此值生效，取值为其他的人员" +
            "userid组成的字符串，使用“\\|”符号进行分割。总数不能超过200", hidden = true)
    private String deptPerimits;

    @ApiModelProperty(value = "可以查看指定隐藏部门的其他人员列表，如果部门隐藏，则此值生效，取值为其他的人员userid组成的字符串，使用“\\|”符号进行分割。总数不能超过200")
    private  String userPermits;

    @ApiModelProperty(value = "限制本部门成员查看通讯录，限制开启后，本部门成员只能看到限定范围内的通讯录。true表示限制开启")
    private Boolean outerDept;

    @ApiModelProperty(value = "outerDept为true时，可以配置额外可见部门，值为部门id组成的的字符串，使用“\\|”符号进行分割。总数不能超过200",required = false)
    private String outerPermitDepts;

    @ApiModelProperty(value = "outerDept为true时，可以配置额外可见人员，值为userid组成的的字符串，使用“\\|”符号进行分割。总数不能超过200",required = false)
    private String outerPermitUsers;

    @ApiModelProperty(value = "outerDept为true时，可以配置额外可见人员，值为userid组成的的字符串，使用“\\|”符号进行分割。总数不能超过200",required = false)
    private Boolean outerDeptOnlySelf;

    @ApiModelProperty(value = "部门标识字段，开发者可用该字段来唯一标识一个部门，并与钉钉外部通讯录里的部门做映射")
    private String sourceIdentifier;

    @ApiModelProperty(value = "部门自定义字段，格式为文本类型的Json格式:\"{\"deptNo\":1}",required = false)
    private String ext;

    @ApiModelProperty(value = "",hidden = true,required = false)
    private int timestamp;

    @ApiModelProperty(required = false)
    @JsonIgnore
    private  String targetAppkey;

    @ApiModelProperty(required = false)
    @JsonIgnore
    private  String topMixParams;

    public CreateDepartment() {
    }
}
