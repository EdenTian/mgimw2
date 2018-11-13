/**
 * Created by c-zouzhongxing1 on 2018/10/16. 微信:gavinjzx QQ:120534960
 */
//禁用元素
function disabledBtn(elID) {
    $(elID).attr("disabled", "disabled");
}
//启用元素
function enabledBtn(elID) {
    $(elID).removeAttr("disabled");
}
//获取地址栏参数，name:参数名称
function getUrlParms(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if (r != null)
        return decodeURI(r[2]);
    return null;
}
//URL 地址去掉参数
function getUrlDropParms(urlStr) {
    if (urlStr.indexOf("?") > -1) {
        return urlStr.split("?")[0];
    }
    else {
        return urlStr;
    }
}
//写cookies
function setCookie(name, value, days) {
    var exp = new Date();
    exp.setTime(exp.getTime() + days * 24 * 60 * 60 * 1000);
    document.cookie = name + "=" + encodeURIComponent(value) + ";expires=" + exp.toGMTString();
}
//写cookies,不设置过期时间，退出即失效
function setCookie(name, value) {
    document.cookie = name + "=" + encodeURIComponent(value);
}
//读cookie
function getCookie(name) {
    var arr, reg = new RegExp("(^| )" + name + "=([^;]*)(;|$)");
    if (arr = document.cookie.match(reg))
        return decodeURIComponent(arr[2]);
    else
        return null;
}