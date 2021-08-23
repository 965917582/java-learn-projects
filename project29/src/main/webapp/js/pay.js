window.onload=function(){
    $("#pay").on('click',function(){

        var out_trade_no = $("#out_trade_no").val();
        var total_fee = $("#total_fee").val();

        $.ajax({
            type: 'post',
            url: 'http://aijia.free.idcfengye.com/project29/pay',
            data: {
                out_trade_no: out_trade_no,
                total_fee:total_fee
            },
            success: function(res){
                console.log(res);
                location.href=res;

            },
            error:function(erro){
                console.log(erro)
            }
        });

    });

}

