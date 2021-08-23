window.onload=function(){
    $("#outTicket").on("click",function () {

        var orderid = $("#orderid").val();
        $.ajax({
            type: 'post',
            url: 'http://localhost:8080/project32/outTicket',
            data:{
                orderid:orderid
            },
            success: function(res){
                if(res=='success'){
                    alert("出票成功");
                    window.location.href = "ticketBack.html";
                }else{
                    alert("出票失败");
                }

            }

        });

    });


}