package com.controller;

import com.pojo.NotifyUrl;
import com.pojo.Resp;
import com.service.NotifyUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 设置回调url
 */
@Controller
public class NotifyUrlController {
    @Autowired
    NotifyUrlService notifyUrlService;

    @RequestMapping("/setPush")
    @ResponseBody
    public Resp setPush(NotifyUrl notifyUrl){
        Resp resp = new Resp();
        int res=-1;
        try{
            res = notifyUrlService.add(notifyUrl);
        }catch (Exception e){
            e.printStackTrace();
        }

        if(res==1){
            resp.setError_code(0);
            resp.setReason("成功的返回");
            resp.setResult(notifyUrl);
        }else{
            resp.setError_code(-1);
            resp.setReason("设置回调失败");
        }

        return resp;
    }

}
