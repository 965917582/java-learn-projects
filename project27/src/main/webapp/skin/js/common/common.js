//=========================================================================
// DOM对象操作工具
//=========================================================================
function getAbsPosition(o){

    o = $(o);
    if (o.length == 0) {
        return false;
    }
    
    o = o[0];
    
    var left, top;
    left = o.offsetLeft;
    top = o.offsetTop;
    
    while (o = o.offsetParent) {
        left += o.offsetLeft;
        top += o.offsetTop;
    }
    
    return {
        left: left,
        top: top
    };
}

//=========================================================================
// STRING操作工具
//=========================================================================
String.prototype.trim = function(){
    return this.replace(/(^\s*)|(\s*$)/g, "");
};
String.prototype.startWith = function(str){
    if (typeof(str) === "undefined") {
        return false;
    }
    str = str.toString();
    if (this.substr(0, str.length) == str) {
        return true;
    } else {
        return false;
    }
}

String.prototype.endWith = function(otherStr){
    if (typeof(otherStr) === "undefined") {
        return false;
    }
    otherStr = otherStr.toString();
    var startPos = this.length - otherStr.length;
    if (startPos >= 0) {
        var tmp = this.substr(startPos);
        if (tmp === otherStr) {
            return true;
        } else {
            return false;
        }
    } else {
        return false;
    }
}

String.prototype.contains = function(otherStr){
    if (typeof(otherStr) === "undefined") {
        return false;
    }
    if (this.indexOf(otherStr.toString()) == -1) {
        return false;
    } else {
        return true;
    }
}
//=========================================================================
// FORM操作工具
//=========================================================================
/**
 * 将表单中各域的值自动封装成参数对象
 * @param {Object} oFrm 表单对象
 */
function getFormPara(oFrm){
    oFrm = $(oFrm)[0];
    var len = oFrm.elements.length;
    var ret = {};
    for (var i = 0; i < len; i++) {
    
        var oEle = oFrm.elements[i];
        
        if (oEle.type === "radio") {
            if (oEle.checked) {
                ret[oEle.name] = oEle.value.trim();
            }
        } else if (oEle.type === "checkbox") {
            var curVal = ret[oEle.name];
            if (curVal === undefined) {
                ret[oEle.name] = [];
                if (oEle.checked) {
                    ret[oEle.name].push(oEle.value.trim());
                }
            } else {
                if (oEle.checked) {
                    ret[oEle.name].push(oEle.value.trim());
                }
            }
        } else {
            ret[oEle.name] = oEle.value.trim();
        }
    }
    return ret;
}
//=========================================================================
// Browser操作工具
//=========================================================================
var Browser = {
    isIE: function(version){
    
        if (navigator.userAgent.toLowerCase().indexOf("msie") == -1) {
            return false;
        } else {
            if (version) {
                var regexpr = new RegExp("msie\\s*" + version, "g");
                if (navigator.userAgent.toLowerCase().match(regexpr)) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return true;
            }
        }
    }
    
};

//=========================================================================
// COOKIE操作工具
//=========================================================================
var Cookie = {
    /**
     * 设置cookie
     * @param {Object} cname 名称
     * @param {Object} cvalue 值
     * @param {Object} expires 过期时间，可以是数值，表示存活时间，可以是日期对象，表示到期日期
     */
    set: function(cname, cvalue, expires){
        var expiresString;
        if (expires) {
            if (expires instanceof Date) {
                expiresString = ";expires=" + expires.toGMTString();
            } else {
                var d = parseInt(expires);
                if (!isNaN(d)) {
                    var t = new Date();
                    t = new Date(t.getTime() + d);
                    expiresString = ";expires=" + t.toGMTString();
                }
            }
        }
        
        var tmp = cname + "=" + escape(cvalue);
        if (expiresString) {
            tmp += expiresString;
        }
        document.cookie = tmp;
    },
    
    /**
     * 按名称查找cookie
     * @param {Object} cname
     */
    find: function(cname){
        var cookies = document.cookie;
        var regexpr = new RegExp(cname + "\\s*=[^;]*(;|$)", "g");
        var ret = cookies.match(regexpr);
        if (ret) {
            var val = ret[0].replace(new RegExp(cname + "\\s*="), "").replace(";", "");
            return unescape(val);
        }
    },
    
    /**
     * 按名称删除cookie
     * @param {Object} cname
     */
    remove: function(cname){
        document.cookie = cname + "=no;expires=" + new Date(1970, 0, 0).toGMTString();
    }
};

//=========================================================================
// Object操作工具
//=========================================================================
var ObjUtils = {
    /**
     * 值字段深度复制
     */
    deepClone: function(o){
        var isSimpleVal = function(val){
            if (typeof(val) === "string" || typeof(val) === "number" || typeof(val) == "boolean") {
                return true;
            } else {
                return false;
            }
        };
        
        var isArray = function(o){
            if (o instanceof Array) {
                return true;
            } else {
                return false;
            }
        };
        
        var isObject = function(o){
            if (typeof(o) === "object") {
                return true;
            } else {
                return false;
            }
        };
        
        var cloneArray = function(o){
            if (!o) {
                return null;
            }
            
            var ret = [];
            for (var i = 0; i < o.length; i++) {
                if (isSimpleVal(o[i])) {
                    ret.push(o[i]);
                } else if (isObject(o[i])) {
                    ret.push(cloneObj(o[i]));
                }
            }
            return ret;
        };
        
        var cloneObj = function(o){
            if (!o) {
                return null;
            }
            
            var ret = {};
            for (var prop in o) {
                var val = o[prop];
                if (isArray(val)) {
                    ret[prop] = cloneArray(val);
                } else if (isSimpleVal(val)) {
                    ret[prop] = val;
                } else if (isObject(val)) {
                    ret[prop] = cloneObj(val);
                }
            }
            return ret;
        };
        
        if (isArray(o)) {
            return cloneArray(o);
        } else {
            return cloneObj(o);
        }
    }
}