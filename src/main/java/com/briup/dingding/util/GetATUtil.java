package com.briup.dingding.util;

import com.briup.dingding.bean.Access;
import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiGettokenRequest;
import com.dingtalk.api.response.OapiGettokenResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.taobao.api.ApiException;

public class GetATUtil {
    public static String getAT() throws ApiException, JsonProcessingException {
        //实例化token实体类
        Access access = null;
        //钉钉官方文档获取token
        //地址：https://ding-doc.dingtalk.com/doc#/serverapi2/eev437
        DingTalkClient client = new DefaultDingTalkClient(DingTalkRequestURL.TOKEN_URL);
        OapiGettokenRequest req = new OapiGettokenRequest();
        req.setAppkey(DingTalkRequestURL.APP_KEY);
        req.setAppsecret(DingTalkRequestURL.APP_SECRET);
        req.setHttpMethod("GET");
        OapiGettokenResponse rsp = client.execute(req);
        //jackson解析json并且封装成对象
        ObjectMapper mapper = new ObjectMapper();
        access = mapper.readValue(rsp.getBody(), Access.class);

        return access.getAccess_token();

    }

    public static void main(String[] args) throws JsonProcessingException, ApiException {
        System.out.println(getAT());
    }

}
