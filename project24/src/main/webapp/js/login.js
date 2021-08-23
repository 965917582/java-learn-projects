window.onload=function(){
    init();

    $(".btn").on('click',function(){
        var username = $("#userName").val();
        var password = $("#userPsd").val();
        $.ajax({
            type: 'post',
            url: 'http://localhost:8080/project22/user/login',
            data: {
                userName: username,
                userPsd: password
            },
            success: function(res){
                console.log(res)
                if(res.code==200){
                    //window.location.href = './goods.html';
                    
                }
                $("#msg").html(res.msg);
                
            },
            error:function(erro){
                console.log(erro)
            }

        })
    })

    
    function init(){
        $("#userId").html(getCookie("nowuser"));
    }
    


}