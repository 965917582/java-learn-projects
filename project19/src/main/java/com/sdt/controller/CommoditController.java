package com.sdt.controller;


import com.sdt.domain.Commodit;
import com.sdt.service.CommoditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import redis.clients.jedis.Jedis;

import java.util.List;

@Controller
@RequestMapping("/commodit")
public class CommoditController {

    @Autowired
    CommoditService commoditService;

    @Autowired
    Jedis jedis;

    /**
     * 查出全部商品，跳转到商品列表页面
     */
    @RequestMapping("/commoditPage")
    public ModelAndView commoditPage(){
        ModelAndView mav = new ModelAndView();
        List<Commodit> commodits = commoditService.findAll();
        mav.addObject("commodits",commodits);
        mav.setViewName("commoditPage");
        return mav;
    }

    /**
     * 查出单个商品信息，跳转到单个商品详情页面
     */
    @RequestMapping("/detailPage")
    public ModelAndView detailPage(Integer commId){
        ModelAndView mav = new ModelAndView();
        Commodit commodit = commoditService.findById(commId);
        mav.addObject("commodit",commodit);
        mav.setViewName("commoditDetailPage");
        return mav;
    }




}
