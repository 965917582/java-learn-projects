package com.sdt.controller;

import com.sdt.domain.CartForShow;
import com.sdt.domain.CartItem;
import com.sdt.domain.ResponseMsg;
import com.sdt.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class CartController {

    @Autowired
    CartService cartService;

    @RequestMapping(value = "/cartlist",method = RequestMethod.GET)
    @ResponseBody
    public ResponseMsg getAllCartList(Integer userid){
        ResponseMsg msg = new ResponseMsg();
        CartForShow cartForShow = null;
        if(userid==null){
            msg.setCode("400");
            msg.setMsg("用户id为null");
            return msg;
        }
        else{
            cartForShow = cartService.getAll(userid);
        }
        msg.setCode("200");
        msg.setData(cartForShow);
        msg.setMsg("返回全部"+(userid==null?"游客":userid+"用户")+"的购物车信息");
        return msg;
    }

    @RequestMapping(value = "/addcart",method = RequestMethod.POST)
    @ResponseBody
    public ResponseMsg addcart(CartItem cartItem ){
        cartService.addToCart(cartItem);
        ResponseMsg msg = new ResponseMsg();
        msg.setCode("200");
        msg.setMsg("添加购物车成功");
        return msg;
    }

    @RequestMapping(value = "/ucartnum",method = RequestMethod.POST)
    @ResponseBody
    public ResponseMsg ucartnum(CartItem cartItem ){
        boolean status = cartService.modifyGoodsNum(cartItem);
        ResponseMsg msg = new ResponseMsg();
        if(status){
            msg.setCode("200");
            msg.setMsg("已修改购物车商品数量");
        }else{
            msg.setCode("400");
            msg.setMsg("商品不存在");
        }

        return msg;
    }

    @RequestMapping(value = "/delcartshop",method = RequestMethod.POST)
    @ResponseBody
    public ResponseMsg delcartshop(Integer cartid,Integer userid){
        ResponseMsg msg = new ResponseMsg();

        boolean status = cartService.deleteFromCart(cartid,userid);

        if(status){
            msg.setCode("200");
            msg.setMsg("已删除"+userid+"用户的购物车的"+cartid+"项");
            return msg;
        }else{
            msg.setCode("400");
            msg.setMsg(userid+"号用户的购物车不存在"+cartid+"项");
            return msg;
        }
    }

}
