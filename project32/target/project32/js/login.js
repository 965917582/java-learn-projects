window.onload=function(){

    $("#btn").on("click",function () {
        var account = $("#account").val();
        var pwd = $("#pwd").val();

        $.ajax({
            type: 'post',
            url: 'http://localhost:8080/project32/login',
            data:{
                account:account,
                pwd:pwd
            },
            success: function(res){
                if(res=='success'){
                    window.location.href = "selectStation.html";
                }else{
                    alert("用户名或密码错误");
                }

            }

        });


    });


    $("#logout").on("click",function () {

        $.ajax({
            type: 'get',
            url: 'http://localhost:8080/project32/logout',
            success: function(res){
                alert("已注销");
            }
        });
    });
}