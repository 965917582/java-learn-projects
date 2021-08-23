window.onload=function(){

    getGoodsList();
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
                                    <a href="javascript:;" class="decrement" >-</a>
                                    <input type="text" class="itxt" value="1" id="goodsNum${ele.goodsId}">
                                    <a href="javascript:;" class="increment">+</a>
                                  </div>
                                </div>
                                <div class="p-sum">${ele.goodsStock}</div>
                                <div class="p-action" onclick="add(`+$(".itxt")+`)">加入购物车</div>
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


    

}


function add(e){
  console.log(e)
 // var nums=$("input")
}