window.onload=function(){

    $(".btn").on('click',function(){
        var username = $("#userName").val();
        var password = $("#userPsd").val();
        $.ajax({
            type: 'post',
            url: 'http://localhost:8080/project22/user/sign',
            data: {
                userName: username,
                userPsd: password
            },
            success: function(res){
                console.log(res)
                if(res.code==200){

                }
                $("#msg").html(res.msg);
                
            },
            error:function(erro){
                console.log(erro)
            }

        })
    })



}