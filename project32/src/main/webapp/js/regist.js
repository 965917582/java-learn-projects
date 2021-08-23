window.onload=function(){
    $("#btn").on("click",function () {
        var account = $("#account").val();
        var pwd = $("#pwd").val();
        var phone = $("#phone").val();
        var email = $("#email").val();

        $.ajax({
            type: 'post',
            url: 'http://localhost:8080/project32/regist',
            data:{
                account:account,
                pwd:pwd,
                phone:phone,
                email:email
            },
            success: function(res){
                if(res=='success'){
                    alert("注册成功");
                }else{
                    alert("注册失败");
                }
            }

        });


    })



}