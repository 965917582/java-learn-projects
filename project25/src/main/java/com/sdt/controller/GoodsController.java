package com.sdt.controller;

import com.sdt.domain.Goods;
import com.sdt.domain.ResponseMsg;
import com.sdt.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class GoodsController {
    @Autowired
    GoodsService goodsService;

    @RequestMapping(value = "/shoplist",method = RequestMethod.GET)
    @ResponseBody
    public ResponseMsg shoplist(){
        ResponseMsg msg = new ResponseMsg();

        List<Goods> goods = goodsService.findAll();
        msg.setCode("200");
        msg.setMsg("查询成功");
        msg.setData(goods);
        return msg;
    }

}
