window.onload=function(){

    $(".btn").on("click",function () {
        var fromStation = $("#fromStation").val();
        var toStation = $("#toStation").val();
        var goTime = $("#goTime").val()
        sessionStorage.setItem("fromStation",fromStation);
        sessionStorage.setItem("toStation",toStation);
        sessionStorage.setItem("goTime",goTime);
        window.location.href = "selectDetails.html";

    })

    $.ajax({
        type: 'get',
        url: 'http://localhost:8080/project32/getStation',
        dataType: "json",
        success: function(res){
            //$("#station").html(res.result);
            var str='';
            console.log(res.result);
            $.each(res.result,function(i,ele){
                console.log(ele);
                str+= `<option value="${ele.code}">${ele.name}</option>>`;
            });
            $('#fromStation').append(str);
            $('#toStation').append(str);
        }

    })
}


