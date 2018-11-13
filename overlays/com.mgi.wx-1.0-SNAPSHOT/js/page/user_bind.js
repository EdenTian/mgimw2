/**
 * Created by c-zouzhongxing1 on 2018/10/16. 微信:gavinjzx QQ:120534960
 */
init();
function init() {
    bindBlur();
    bindFormSubmit()
    GetQueryString(pname)
}
function bindBlur() {
    //必填项验证
    $("input[required],input[requiredNin1],input[pattern]").on({
        blur: function () {
            checkInput($(this));
        },
        input: function () {
            checkInput($(this));
        }
    });
}
function bindFormSubmit() {
    $("#btnSubmit").on("click", function () {
        var errs = checkForm();
        if (errs == 0) {
            submitForm();
        }
    });
}
function GetQueryString(pname) {
    var reg = new RegExp('(^|&)' + pname + '=([^&]*)(&|$)', 'i');
    var r = window.location.search.substr(1).match(reg);
    if (r != null) {
        return unescape(r[2]);
    }
    return null;
}
function submitForm() {
    var loading = weui.loading('提交中...');
    //防重复提交
    disabledBtn("#btnSubmit");
    // 工单编号
    var SN = $("#txtSN").val();
    // 客户名称
    var customerName = $("#txtCustomerName").val();
    // 联系人姓名
    var contact = $("#txtContact").val();
    // 电话
    var tel = $("#txtTel").val();
    // txtEmail
    var email = $("#txtEmail").val();
    // 地址
    var address = $("#txtAddress").val();
    //openID
   // var openID = $("#txtOpenID").val();
     var openId =  GetQueryString("openid");
    var postJsonData = {
        orderNum: SN,
        clientName: customerName,
        contactName: contact,
        phone: tel,
        mail: email,
        contactLocation: address,
        openId: openId
    };

// 这样调用：
    $.post("/service/bind", postJsonData, function (json) {
        // if (json.message == "success") {
            if (json.status == 200) {
            loading.hide();
            weui.toast('绑定成功', 3000);
            setTimeout(function () {
                location.href = "user_bind_success.html"
            }, 1500);
        } else {
            loading.hide();
            weui.toast("提交失败，原因：" + json.message);
            //启用按钮
            enabledBtn("#btnSubmit");
        }
    });

}
function checkForm() {
    var eles = $("input[required],input[requiredNin1],input[pattern]");
    eles.each(function () {
        checkInput($(this));
    });
    return $(".weui-cell_warn").length;
}
//表单项检测
function checkInput(oneInput) {
    //必填
    if ($(oneInput)[0].hasAttribute("required")) {
        if (!$(oneInput).val()) {
            $(oneInput).parents(".weui-cell").addClass("weui-cell_warn").find("i").addClass("weui-icon-warn");
            weui.topTips($(oneInput).attr("emptyTips"));
        }
        else {
            $(oneInput).parents(".weui-cell").not(".hide").removeClass("weui-cell_warn").find("i").removeClass("weui-icon-warn");
        }
    }
    //N项必填一项
    if ($(oneInput)[0].hasAttribute("requiredNin1")) {
        var eleName = oneInput.attr("requiredNin1");
        var eles = $(eleName);
        var eleValue = "";
        eles.each(function () {
            eleValue += $(this).val();
        });
        //无值
        if (!eleValue) {
            $(eleName).parents(".weui-cell").addClass("weui-cell_warn").find("i").addClass("weui-icon-warn");
            weui.topTips($(oneInput).attr("emptyTips"));
        }
        //有值
        else {
            //遍历
            eles.each(function (i, item) {
                //无正则属性
                if (!$(item)[0].hasAttribute("pattern") || !$(item).val()) {
                    $(item).parents(".weui-cell").not(".hide").removeClass("weui-cell_warn").find("i").removeClass("weui-icon-warn");
                }
                else {
                    var reg = eval("/" + $(item).attr("pattern") + "/");
                    //有值并匹配
                    if (!reg.test($(item).val())) {
                        $(item).parents(".weui-cell").addClass("weui-cell_warn").find("i").addClass("weui-icon-warn");
                        weui.topTips($(item).attr("notmatchtips"));
                    }
                }
            })
        }
    }
    //正则表达式
    if (oneInput[0].hasAttribute("pattern")) {
        var reg = eval("/" + $(oneInput).attr("pattern") + "/");
        //有值
        if (oneInput.val()) {
            //正则不匹配
            if (!reg.test(oneInput.val())) {
                oneInput.parents(".weui-cell").addClass("weui-cell_warn").find("i").addClass("weui-icon-warn");
                weui.topTips($(oneInput).attr("notmatchtips"));
            }
            //正则匹配
            else {
                oneInput.parents(".weui-cell").not(".hide").removeClass("weui-cell_warn").find("i").removeClass("weui-icon-warn");
            }
        }
        //无值
        else {
            //无必填选项
            if ((!oneInput[0].hasAttribute("requiredNin1")) && (!oneInput[0].hasAttribute("required"))) {
                oneInput.parents(".weui-cell").not(".hide").removeClass("weui-cell_warn").find("i").removeClass("weui-icon-warn");
            }
        }
    }
}

