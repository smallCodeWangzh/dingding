package com.briup.dingding.web.controller;

import com.briup.dingding.bean.Access;
import com.briup.dingding.bean.DepartmentDetail;
import com.briup.dingding.bean.DepartmentLIst;
import com.briup.dingding.util.CodeStatus;
import com.briup.dingding.util.DingTalkRequestURL;
import com.briup.dingding.util.GetATUtil;
import com.briup.dingding.util.Message;
import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiDepartmentGetRequest;
import com.dingtalk.api.request.OapiDepartmentListRequest;
import com.dingtalk.api.response.OapiDepartmentGetResponse;
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

@Validated
@RestController
@RequestMapping("/department")
public class DepartmentController {
    @ApiOperation(value = "获取部门列表",notes = "默认查询根部门迭代下的所有部门列表")
    @GetMapping("/getlist")
    public ResponseEntity<Message> getDepartmentList(){
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
        return ResponseEntity.ok(new Message(CodeStatus.SUCCESS,departmentLIst.getDepartment()));
    }

    @ApiOperation("通过id获取部门详情")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "id",value = "主键",paramType = "query")
    )
    @GetMapping("/getDeptById/{id}")
    public ResponseEntity<Message> getDepartmentById(@PathVariable String id){
            System.out.println(id);
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
}
