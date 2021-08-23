window.onload=function(){
    $("#pay").on('click',function(){

        var out_trade_no = $("#out_trade_no").val();
        var subject = $("#subject").val();
        var total_amount = $("#total_amount").val();

        $.ajax({
            type: 'post',
            url: 'http://localhost:8080/project28/pay',
            data: {
                out_trade_no: out_trade_no,
                subject: subject,
                total_amount:total_amount
            },
            success: function(res){
                console.log(res);
                $("#toAliPay").html(res);

            },
            error:function(erro){
                console.log(erro)
            }
        });

    });

}

