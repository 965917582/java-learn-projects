window.onload=function(){

    getOrderList();

}

function pay(orderId,totalPrice) {
    $.ajax({
        type:'post',
        url:'http://localhost:8080/project22/order/pay',
        data:{
            orderId:orderId,
            totalPrice:totalPrice
        },
        success:function (res) {
            $("#QRcode").html(res);
        }

    })

}


function getOrderList() {
    $('#order-list').html(`<tr>
            <th>取消订单</th>
            <th>订单id</th>
            <th>订单创建时间</th>
            <th>总价</th>
            <th>是否支付</th>
            <th>支付</th>

            <th>商品id</th>
            <th>商品名称</th>
            <th>商品数量</th>
            <th>商品单价</th>
        </tr>`);
    $.ajax({
        type:'post',
        url:'http://localhost:8080/project22/order/getAllOrder',
        data:{
            userId:getCookie("nowuser")
        },
        success: function(res){
            console.log(res);
            if(res.code==200){
                var str='';
                $.each(res.data,function (i,order) {
                    str += `<tr>
                        <td class="cansolebtn" onclick="deleteOrder(${order.orderId})">取消</td>
                        <td>${order.orderId}</td>
                        <td>${order.orderCreateTime}</td>
                        <td>${order.orderTotalPrice}</td>
                        <td>${order.orderPaid}</td>
                        <td class="paybtn" onclick="pay(${order.orderId},${order.orderTotalPrice})">支付</td>

                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>`

                    $.each(order.goodsList, function (i, goods) {
                        str += `<tr>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                
                            <td>${goods.goodsId}</td>
                            <td>${goods.goodsName}</td>
                            <td>${goods.goodsNum}</td>
                            <td>${goods.goodsPrice}</td>
                        </tr>`

                    });

                });
                $('#order-list').append(str);
            }

        }
    })
}


function deleteOrder(orderId) {
    $.ajax({
        type: 'post',
        url:'http://localhost:8080/project22/order/deleteOrderByOrderId',
        data:{
            orderId:orderId
        },
        success: function(res){
            getOrderList();
        }
    })
}