window.onload=function(){
    /**
     * 设置监听，若商品数量为0，减少按钮失效
     */
    //减少数量的
    /*var decreaseAs = document.getElementsByClassName("decreaseA")
    for(var i in decreaseAs) {
        decreaseAs[i].onclick = function () {
            $(this).css("pointer-events","none");
            var commNum = $(this).attr("data-commNum");
            if(commNum==0){
                //$(this).css({"pointer-events":"none","color":"#afafaf","cursor":"default"});
                $(this).css("pointer-events","none");
            }
        }
    }*/


    /*//减少数量的
    var decreaseBtns = document.getElementsByClassName("decreaseCommNum")
    //增加数量的
    var increaseBtns = document.getElementsByClassName("increaseCommNum");

    for(var i in decreaseBtns){
        decreaseBtns[i].onclick=function () {
            //var commNum = $(this).attr("data-commNum");
            var thisObj = this;
            var commId = $(this).attr("data-commId");
            if(commNum==0){
                return;
            }


            //服务器的购物车数据同步
            var pathName = window.document.location.pathname;
            var projectName = pathName.substring(0,pathName.substr(1).indexOf('/')+1);
            $.ajax({
                url:projectName+'/cart/decreaseCommNum',
                type:'POST',
                data:{"commId":commId},
                success:function(data){
                    //页面数量和总价改变
                    $(thisObj).nextSibling().html(commId-1)

                }
            })
        }
    }
    for(var i in increaseBtns){
        increaseBtns[i].onclick=function () {
            var commId = $(this).attr("data-commId");

        }
    }*/
}