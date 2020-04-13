package com.briup.dingding.web.controller;

import com.briup.dingding.bean.DepartmentDetail;
import com.briup.dingding.bean.DepartmentLIst;
import com.briup.dingding.bean.DepartmentResult;
import com.briup.dingding.util.*;
import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiDepartmentGetRequest;
import com.dingtalk.api.request.OapiDepartmentListParentDeptsByDeptRequest;
import com.dingtalk.api.request.OapiDepartmentListParentDeptsRequest;
import com.dingtalk.api.request.OapiDepartmentListRequest;
import com.dingtalk.api.response.OapiDepartmentGetResponse;
import com.dingtalk.api.response.OapiDepartmentListParentDeptsByDeptResponse;
import com.dingtalk.api.response.OapiDepartmentListParentDeptsResponse;
import com.dingtalk.api.response.OapiDepartmentListResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.taobao.api.ApiException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author cuigx@briup.com
 * 部门管理
 * 获得部分均为钉钉官方文档提供
 * 解析部分为jackson解析json
 */
@Validated
@RestController
@RequestMapping("/department")
public class DepartmentController {
    @ApiOperation(value = "获取部门列表",notes = "默认查询根部门迭代下的所有部门列表")
    @GetMapping("/getlist")
    public DingTalkMessage getDepartmentList(){
        DepartmentLIst departmentLIst = null;
        try {
            //获得
            DingTalkClient client = new DefaultDingTalkClient(DingTalkRequestURL.DEPT_LIST);
            OapiDepartmentListRequest req = new OapiDepartmentListRequest();
            req.setHttpMethod("GET");
            OapiDepartmentListResponse rsp = client.execute(req, GetATUtil.getAT());
            //解析
            ObjectMapper mapper = new ObjectMapper();
            departmentLIst =  mapper.readValue(rsp.getBody(),DepartmentLIst.class);

        } catch (ApiException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        //return ResponseEntity.ok(new Message(CodeStatus.SUCCESS,departmentLIst.getDepartment()));
        return departmentLIst;
    }

    @ApiOperation("通过id获取部门详情")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "id",value = "主键",paramType = "path")
    )
    @GetMapping("/getDeptById/{id}")
    public ResponseEntity<Message> getDepartmentById(@PathVariable String id){
            DepartmentDetail dept_detail = null;
        try {
            //获得
            DingTalkClient client = new DefaultDingTalkClient(DingTalkRequestURL.DEPT_DETAIL_BY_ID);
            OapiDepartmentGetRequest req = new OapiDepartmentGetRequest();
            req.setId(id);
            req.setHttpMethod("GET");
            OapiDepartmentGetResponse rsp = client.execute(req, GetATUtil.getAT());
            //解析
            ObjectMapper mapper = new ObjectMapper();
            dept_detail= mapper.readValue(rsp.getBody(), DepartmentDetail.class);

        } catch (ApiException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok(new Message(CodeStatus.SUCCESS,dept_detail));
    }

    @ApiOperation(value = "根据部门id查询其父部门id",notes = "返回的结果按顺序依次为其所有父部门的ID，直到根部门")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "deptid",value = "部门id",paramType = "path")
    )
    @GetMapping("/getDeptsByDept/{deptid}")
    public ResponseEntity<Message> getDeptsListByDeptId(@PathVariable String deptid){
        DepartmentResult departmentResult = null;
        try {
            DingTalkClient client = new DefaultDingTalkClient(DingTalkRequestURL.DEPTS_BY_DEPT);
            OapiDepartmentListParentDeptsByDeptRequest req = new OapiDepartmentListParentDeptsByDeptRequest();
            req.setId(deptid);
            req.setHttpMethod("GET");
            OapiDepartmentListParentDeptsByDeptResponse rsp = client.execute(req, GetATUtil.getAT());

            ObjectMapper mapper = new ObjectMapper();
            departmentResult = mapper.readValue(rsp.getBody(),DepartmentResult.class);

        } catch (ApiException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok(new Message(CodeStatus.SUCCESS,departmentResult));
    }

    @ApiOperation(value = "查询指定用户的所有父部门id",notes = "返回的结果按顺序依次为其所有父部门的ID，直到根部门")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "userid",value = "用户id",paramType = "path")
    )
    @GetMapping("/getDeptsByUser/{userid}")
    public ResponseEntity<Message> getDeptsListByUserId(@PathVariable String userid){
        DepartmentResult departmentResult = null;
        try {
            DingTalkClient client = new DefaultDingTalkClient(DingTalkRequestURL.DEPTS_BY_USER);
            OapiDepartmentListParentDeptsRequest req = new OapiDepartmentListParentDeptsRequest();
            req.setUserId(userid);
            req.setHttpMethod("GET");
            OapiDepartmentListParentDeptsResponse rsp = client.execute(req, GetATUtil.getAT());

            ObjectMapper mapper = new ObjectMapper();
            departmentResult = mapper.readValue(rsp.getBody(),DepartmentResult.class);

        } catch (ApiException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return ResponseEntity.ok(new Message(CodeStatus.SUCCESS,departmentResult));
    }

}
