window.onload=function(){
    //当访问购物车页面，获取购物车数据列表
    getCartItemList();
    /*$(".checkall").on('change',function () {
        getTotalPrice();
    })*/

    //点击结算
    $("#generateOrderBtn").on('click',function () {
        //若未登录，提示登录，跳转到登录页面
        var userId = getCookie("nowuser");
        if(userId == ""){
            alert("请先登录");
            window.location.href = 'login.html';
            return;
        }

        //获取总价
        var totalPrice = Number($("#totalPrice").text());
        //获取选中的商品id，和页面上的商品数量，商品单价(方便后台不要再开销查redis了，这里其实可以不传，只要重载一个方法，在后台得到单价)
        var cnt=0;//选中的有效商品计数
        var goodsIdList = [];
        var goodsNumList = [];
        var goodsPriceList = [];

        var checkboxlist = $('input[class="cartItemCheckbox"]');
        checkboxlist.each(function () {
            if($(this).is(":checked")){
                var goodsIdInput = $(this).next();
                var goodsId = $(goodsIdInput).val();
                var goodsNum = $("#goodsNum"+goodsId).val();
                var goodsPrice = Number($("#goodsPrice"+goodsId).text());

                //重要细节：不要把数量为0的生成订单
                if(goodsNum!=0){
                    cnt++;
                    goodsIdList.push(goodsId);
                    goodsNumList.push(goodsNum);
                    goodsPriceList.push(goodsPrice)
                }

            }
        });

        //重要细节：只有存在选中的有效商品时才生成订单
        if(cnt>0){
            $.ajax({
                type:'post',
                url:'http://localhost:8080/project22/order/generateOrder',
                data:{
                    goodsIdList:goodsIdList,
                    goodsNumList:goodsNumList,
                    totalPrice:totalPrice,
                    goodsPriceList:goodsPriceList,
                    userId:userId
                },
                success: function(res){
                    console.log(res);
                    alert("已生成订单");
                    getCartItemList();
                    //总价清0
                    $("#itemCount").html(0);
                    $("#totalPrice").html(0);
                    window.location.href = 'order.html';
                }
            })
        }else{
            alert("请勾选商品，且数量不应为0")
        }


    })

}

function deleteFromCart(goodsId) {
    var userId = getCookie("nowuser");
    $.ajax({
        type:'post',
        url:'http://localhost:8080/project22/cart/deleteFromCart',
        data:{
            userId:userId,
            goodsId:goodsId
        },
        success:function (res) {
            getCartItemList();
        }
    })
}

function getCartItemList() {
    $('.cart-item-list').html("");
    $.ajax({
        type:'get',
        url:'http://localhost:8080/project22/cart/getAllCartList',
        data:{
            userId:getCookie("nowuser")
        },
        success: function(res){
            //返回购物车item列表
            console.log(res)
            if(res.code==200){
                var str='';
                $.each(res.data,function (i,ele) {
                    var goodsPriceSum = ele.goodsNum * ele.goodsPrice;
                    console.log(ele);
                    str+=`<div class="cart-item-list">
                                  <div class="cart-item">
                                    <div class="p-checkbox">
                                      <input type="checkbox" name="checkCartItem"  class="cartItemCheckbox" id="checkbox${ele.goodsId}" onchange="getTotalPrice()">
                                      <input type="text" value="${ele.goodsId}" hidden="hidden">
                                    </div>
                                    <div class="p-goods">
                                      <div class="p-msg">${ele.goodsName}</div>
                                    </div>
                                    <div class="p-price" id="goodsPrice${ele.goodsId}">${ele.goodsPrice}</div>
                                    <div class="p-num">
                                      <div class="quantity-form">
                                        <!--<a href="javascript:;" class="decrement">-</a>-->
                                        <input type="text" class="itxt" value="${ele.goodsNum}" id="goodsNum${ele.goodsId}" onchange="getGoodsPriceSum(${ele.goodsId})">
                                        <!--<a href="javascript:;" class="increment">+</a>-->
                                      </div>
                                    </div>
                                    <div class="p-sum" id="itemPrice${ele.goodsId}" data-price="${goodsPriceSum}">${goodsPriceSum}</div>
                                    <div class="p-action" onclick="deleteFromCart(${ele.goodsId})">删除</div>
                                  </div>
                    
                            </div>`

                });
                $('.cart-item-list').append(str);

            }
        },
    })
}

//更新选中数量和总价
function getTotalPrice() {
    var checkboxlist = $('input[class="cartItemCheckbox"]');
    var cnt=0;
    var totalPrice = 0.0;
    checkboxlist.each(function () {
        if($(this).is(":checked")){
            cnt++;
            var parent = $(this).parent();
            var price = $(parent).nextAll(".p-sum").text();
            totalPrice+=Number(price);
        }
    });
    $("#itemCount").html(cnt);
    $("#totalPrice").html(totalPrice);
}

//当数量改变，更新小计
//同时也更新总价
function getGoodsPriceSum(goodsId) {
    //获取本项单价
    var price = Number($("#goodsPrice"+goodsId).text());
    //获取本项数量
    var num = Number($("#goodsNum"+goodsId).val());
    //获取本项小计元素,设置小计
    $("#itemPrice"+goodsId).html(price*num);
    getTotalPrice();
}
