window.onload=function(){
    init();


    $("#btn").on("click",function () {
        var piaotypename = $("#piaotypename").val();
        var zwname = $("#zwname").val();
        var realname = $("#realname").val();
        var idno = $("#idno").val();
        var phone = $("#phone").val();

        //做实名认证
        $.ajax({
            type: 'post',
            url: 'http://localhost:8080/project32/trainidverification',
            data:{
                passenger_name:realname,
                passenger_id_no:idno,
                encMobileNo:phone,
            },
            success: function(res){
                if(res=='ok'){
                    alert(realname+"认证成功");
                    //提交订单
                    submitOrder();
                }else{
                    alert(realname+"认证失败");
                }
            }
        });

    });

}


function init(){
    var checi = sessionStorage.getItem("checi");
    var fromcode = sessionStorage.getItem("fromcode");
    var tocode = sessionStorage.getItem("tocode");
    var goTime = sessionStorage.getItem("goTime");

    var swz_num = sessionStorage.getItem("swz_num");
    var ydz_num = sessionStorage.getItem("ydz_num");
    var edz_num = sessionStorage.getItem("edz_num");
    var swz_price;
    var ydz_price;
    var edz_price;
    if(swz_num!='0'){
        swz_price = sessionStorage.getItem("swz_price");
        $("#zwname").append('<option>商务座(￥'+swz_price+')</option>');
    }
    if(ydz_num!='0'){
        ydz_price = sessionStorage.getItem("ydz_price");
        $("#zwname").append('<option>一等座(￥'+ydz_price+')</option>');
    }
    if(edz_num!='0'){
        edz_price = sessionStorage.getItem("edz_price");
        $("#zwname").append('<option>二等座(￥'+edz_price+')</option>');
    }


    $("#checi").append(checi);
    $("#fromcode").append(fromcode);
    $("#tocode").append(tocode);
    $("#goTime").append(goTime);
}


function  submitOrder() {
    var checi = sessionStorage.getItem("checi");
    var fromcode = sessionStorage.getItem("fromcode");
    var tocode = sessionStorage.getItem("tocode");
    var goTime = sessionStorage.getItem("goTime");

    $.ajax({
        type: 'post',
        url: 'http://localhost:8080/project32/generateOrder',
        data:{
            checi:checi,
            from_station_code:fromcode,
            to_station_code:tocode,
            train_date:goTime
        },
        success: function(res){
            if(res=='success'){
                alert("提交成功");
                window.location.href = "orderBack.html";
            }else{
                alert("提交失败");
            }
        }
    });
}