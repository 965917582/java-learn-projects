window.onload=function(){
    getUser();
    getGoodsList();

}


function addToCart(goodsId,goodsName,goodsPrice){
    var userId = getCookie("nowuser");
    var goodsNum = $("#goodsNum"+goodsId).val();
    console.log(goodsName);
    $.ajax({
        type:'post',
        url:'http://localhost:8080/project22/cart/addTocart',
        data:{
            userId:userId,
            goodsId:goodsId,
            goodsName:goodsName,
            goodsPrice:goodsPrice,
            goodsNum:goodsNum

        },
        success: function(res){
            console.log(res)
            if(res.code==200){
                //window.location.href = './goods.html';
                alert("已添加至购物车")
            }
        },
    })
}



function getGoodsList(){
    $.ajax({
        type: 'get',
        url: 'http://localhost:8080/project22/goods/goodslist',
        success: function(res){
            console.log(res)
            if(res.code==200){
                var str='';
                $.each(res.data,function (i,ele) {
                    console.log(ele);
                    str+=`<div class="cart-item check-cart-item">
                                <div class="p-goods">
                                  <div class="p-msg">${ele.goodsName}</div>
                                </div>
                                <div class="p-price">${ele.goodsPrice}</div>
                                <div class="p-num">
                                  <div class="quantity-form">
                                    <!--<a href="javascript:;" class="decrement" >-</a>-->
                                    <input type="text" class="itxt" value="1" id="goodsNum${ele.goodsId}">
                                    <!--<a href="javascript:;" class="increment">+</a>-->
                                  </div>
                                </div>
                                <!--传值：userId,goodsId,goodsPrice,goodsNum-->
                                <div class="p-action" onclick="addToCart(${ele.goodsId},'${ele.goodsName}',${ele.goodsPrice})">加入购物车</div>
                              </div>`
                })
                $('.cart-item-list').append(str);
            }
        },
        error:function(erro){
            console.log(erro)
        }
    })
}