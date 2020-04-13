package com.briup.dingding.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@ApiModel
public class Person implements Serializable {
    @ApiModelProperty(value = "编号")
    private int id;

    @ApiModelProperty(value = "名字")
    private String name;
}
