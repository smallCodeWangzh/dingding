package com.briup.dingding.util;

import com.briup.dingding.exception.CustomerException;
import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.request.OapiGettokenRequest;
import com.dingtalk.api.response.OapiGettokenResponse;
import com.taobao.api.ApiException;

public class GetToken {
    public static void main(String[] args) {
        GetToken myToken =new GetToken();
        String token = myToken.getToken();
        System.out.println(token);

    }
    public String getToken(){

        try {
            DefaultDingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/gettoken");
            OapiGettokenRequest req = new OapiGettokenRequest();
            req.setAppkey("dingtr8oxqmbqmywxgot");
            req.setAppsecret("qhz2jl1QK6Xu0WO_kCd-KZ8-pOS6xlPg43pinvJ1tkFMZDpOTaf307MH-nBM07wR");
            req.setHttpMethod("GET");
            OapiGettokenResponse rsp = client.execute(req);
          //  System.out.println(rsp.getBody());
            return  rsp.getAccessToken();
        } catch (ApiException e) {
            e.printStackTrace();
            throw new CustomerException(CodeStatus.ERROR);
        }

    }
}
