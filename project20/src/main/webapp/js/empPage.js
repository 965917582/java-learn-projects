window.onload=function(){
    //管理的下拉列表
    var mgrlist = document.getElementById("mgrlist");
    var pathName = window.document.location.pathname;
    var projectName = pathName.substring(0,pathName.substr(1).indexOf('/')+1);
    var url = projectName+'/emp/findEmpById';
    mgrlist.onchange = function(){
        //alert(this.value);
        $.ajax({
            url:url,
            type:'GET',
            data:{"mgrno":this.value},
            success:function (data) {
                //alert(data.ename)
                $("#mrginfo").html(data.empno+" "+data.ename+" "+data.job)
            }
        });

    }



}
