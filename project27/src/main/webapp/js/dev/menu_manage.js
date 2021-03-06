/**
 * 常量: 菜单类型,3为分隔线
 */
var MENUTYPE_LINE = 3;

$().ready(function(){
    //设置容器表格、IFRAME高度
    $("#treeContainer, #ifrm").css("height", $(window).height() - 22);
    $(window).resize(function(){
        $("#treeContainer, #ifrm").css("height", $(window).height() - 22);
    });

    loadTree();
});

function loadTree() {
    //加载树
    $.getJSON("/menu/menuManage_menuTree", {
        ts: new Date().getTime()
    }, function(data){
        //alert(data)
        //var treeData = [data];
        /**
         * 修改此处即可
         */
        var datastr = JSON.stringify(data);
        var treeData = JSON.parse(datastr);

        function addUrlToMenu(dataList){
            for (var i = 0; i < dataList.length; i++) {
                var menu = dataList[i];
                //alert(menu)
                if (menu.type != MENUTYPE_LINE) {
                    menu.url = "/menu/menu_detail?menuId=" + menu.menuId + "&type=" + menu.type;
                    if (menu.subMenuList && menu.subMenuList.length > 0) {
                        addUrlToMenu(menu.subMenuList);
                    }
                }
            }
        }

        addUrlToMenu(treeData);

        var props = ObjUtils.deepClone(treeDefaultProps);
        props.fieldNameMap.id = "menuId";
        props.fieldNameMap.label = "menuName";
        props.fieldNameMap.subTree = "subMenuList";
        props.urlTarget = "menuDetail";
        props.expandLevel = 3;
        $("#treeContainer").html("");
        $("#treeContainer").tree(treeData, props);
    });
}
