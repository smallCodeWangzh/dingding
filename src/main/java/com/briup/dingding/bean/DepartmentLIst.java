package com.briup.dingding.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@ApiModel
public class DepartmentLIst {

    @ApiModelProperty(value = "返回码")
    private int errcode;
    @ApiModelProperty(value = "返回信息")
    private String errmsg;
    @ApiModelProperty(value = "部门列表")
    private List<DepartmentMini> department;
}
