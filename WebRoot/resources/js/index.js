//ajax管理员登录请求
$(document).ready(function () {
    $("#btn-login").on("click", function () {
        $.get("adminlogincl", $('#login-info').serialize(),
            function (data) {
                var result = $.parseJSON($.base64.decode(data));
                if (result.code == 1) {
                    // 跳转管理界面
                    self.location='manage.html'; 
                } else {
                    // 显示错误信息
                    alert(result.msg);
                }
            });
    });
});