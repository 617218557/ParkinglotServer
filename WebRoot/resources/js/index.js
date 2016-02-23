//ajax管理员登录请求
$(document).ready(function () {
    $("#btn-login").on("click", function () {
        $.get("adminlogincl", $('#login-info').serialize(),
            function (data) {
                alert($.base64.decode(data));
                return data;
            });
    });
});
