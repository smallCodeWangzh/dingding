package com.briup.dingding.web.controller;

import com.briup.dingding.bean.UpdateDepartment;
import com.briup.dingding.exception.CustomerException;
import com.briup.dingding.util.CodeStatus;
import com.briup.dingding.util.Message;
import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiDepartmentDeleteRequest;
import com.dingtalk.api.request.OapiDepartmentListIdsRequest;
import com.dingtalk.api.request.OapiDepartmentListRequest;
import com.dingtalk.api.response.*;
import com.taobao.api.ApiException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.briup.dingding.util.GetToken;
import com.briup.dingding.bean.CreateDepartment;


@Api(tags = {"部门管理"})
@RestController
@RequestMapping("/department")
public class DepartmentController {

   /* @ApiOperation("获取部门列表")
    @GetMapping("departmentList")
    public ResponseEntity<Message<OapiDepartmentListResponse>> getDepartmentList() {
        try{
            GetToken myToken = new GetToken();
            String token = myToken.getToken();
            DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/department/list");
            OapiDepartmentListRequest request = new OapiDepartmentListRequest();
            //request.setId("1");
            request.setHttpMethod("GET");
            // System.out.println(token);
            OapiDepartmentListResponse depList = client.execute(request, token);
            // depList.setParams({"access_token":token});
            return ResponseEntity.ok(new Message(CodeStatus.SUCCESS, depList));
        }catch (ApiException e){
            e.printStackTrace();
            throw new CustomerException(CodeStatus.ERROR);
        }
    }*/

    @ApiOperation("获取子部门id列表")
    @GetMapping("departmentList_ids/{id}/")
    @ApiImplicitParam(name = "id",value = "父部门id，根部门默认为1")
    public ResponseEntity<Message<OapiDepartmentListResponse>> getDepartmentIds(@PathVariable String id) {
        try{
            GetToken myToken = new GetToken();
            String token = myToken.getToken();
            DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/department/list_ids");
            OapiDepartmentListIdsRequest request = new OapiDepartmentListIdsRequest();
            request.setId(id);
            //request.setId("123");
            //request.setHttpMethod("GET");
            OapiDepartmentListIdsResponse response = client.execute(request, token);
            // depList.setParams({"access_token":token});
            return ResponseEntity.ok(new Message(CodeStatus.SUCCESS, response));
        }catch (ApiException e){
            e.printStackTrace();
            throw new CustomerException(CodeStatus.ERROR);
        }
    }

    @ApiOperation("新增部门")
    @PostMapping("/add")
    public ResponseEntity<Message<OapiDepartmentCreateResponse>> add(CreateDepartment request){
        try {
            GetToken myToken = new GetToken();
            String token = myToken.getToken();
            DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/department/create");
            //OapiDepartmentCreateRequest request = new OapiDepartmentCreateRequest();
            //request.setParentid("1");
            //request.setCreateDeptGroup(true);
            //request.setOrder("100");
            //request.setName("部门");
            OapiDepartmentCreateResponse response = client.execute(request, token);
            return ResponseEntity.ok(new Message(CodeStatus.SUCCESS, response));
        } catch (ApiException e){
            throw new CustomerException(CodeStatus.ERROR);
        }
    }


    @ApiOperation("更新部门信息")
    @PostMapping("/update")
    @ApiModelProperty(value = "父部门编号，根部门默认为1")
    public  ResponseEntity<Message<OapiDepartmentUpdateResponse>> update(UpdateDepartment request){
        try {
            GetToken myToken = new GetToken();
            String token = myToken.getToken();
            DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/department/update");
            //OapiDepartmentCreateRequest request = new OapiDepartmentCreateRequest();
            //request.setParentid("1");
            //request.setCreateDeptGroup(true);
            //request.setOrder("100");
            //request.setName("部门");
            OapiDepartmentUpdateResponse response = client.execute(request, token);
            return ResponseEntity.ok(new Message(CodeStatus.SUCCESS, response));
        } catch (ApiException e){
            throw new CustomerException(CodeStatus.ERROR);
        }
    }


    @ApiOperation("删除已存在部门")
    @GetMapping("delete/{id}")
    @ApiImplicitParam(name = "id",value = "部门id")
    public ResponseEntity<Message<OapiDepartmentDeleteResponse>> delete(@PathVariable String id){
        try{
            GetToken myToken = new GetToken();
            String token = myToken.getToken();
            DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/department/delete");
            OapiDepartmentDeleteRequest request = new OapiDepartmentDeleteRequest();
            request.setId(id);
            //request.setHttpMethod("GET");
            OapiDepartmentDeleteResponse response = client.execute(request, token);
            return ResponseEntity.ok(new Message(CodeStatus.SUCCESS, response));
        } catch (ApiException e){
            throw new CustomerException(CodeStatus.ERROR);
        }
    }

}
