package com.sdt.controller;

import com.sdt.domain.CartItem;
import com.sdt.domain.Commodit;
import com.sdt.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@Controller
@RequestMapping("/cart")
public class ShoppingCartController {

    @Autowired
    CartService cartService;

    /**
     * 返回购物车条目列表数据
     * 跳转至购物车页面
     */
    @RequestMapping("/cartPage")
    public ModelAndView cartPage(){
        List<CartItem> items = cartService.findAll();
        ModelAndView mav = new ModelAndView();
        mav.addObject("items",items);
        mav.setViewName("shoppingCartPage");
        return mav;
    }

    /**
     * 处理点击添加到购物车后，添加一条到购物车
     * 返回添加成功信息
     */
    @RequestMapping("/addToCart")
    public String addToCart(Commodit commodit, Integer commoditNum, Model model){
        CartItem item = new CartItem();
        item.setCommodit(commodit);
        item.setCommoditNum(commoditNum);
        cartService.addToCart(item);

        model.addAttribute("msg","添加到购物车成功");
        return "forward:/commodit/detailPage";
    }


    @RequestMapping("/removeFromCart")
    public String removeFromCart(Integer commId){
        cartService.removeFromCart(commId);
        return "forward:/cart/cartPage";
    }

    /**
     * 指定商品数量减少1
     */
    @RequestMapping("/decreaseCommNum")
    public String decreaseCommNum(Integer commId,Integer commNum){
        if(commNum!=0){
            cartService.decreaseCommNum(commId);
        }
        return "forward:/cart/cartPage";
    }

    /**
     * 指定商品数量增加1
     */
    @RequestMapping("/increaseCommNum")
    public String increaseCommNum(Integer commId){
        cartService.increaseCommNum(commId);
        return "forward:/cart/cartPage";
    }


}
