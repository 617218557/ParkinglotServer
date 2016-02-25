$(document).ready(function () {
    // 显示用户信息
    $("#btn-userManage").click(function () {
        $.get("getalluserinfocl", function (data) {
            var result = $.parseJSON($.base64.decode(data));
            if (result.code == 1) {} else {
                // 显示错误信息
            }
        });

        $("#div-userManage").show();
        $("#div-carManage").hide();
        $("#div-parkinglotManage").hide();
    });

    // 显示车辆信息
    $("#btn-carManage").click(function () {
        $.get("getallcarinfocl", function (data) {
            var result = $.parseJSON($.base64.decode(data));
            if (result.code == 1) {} else {
                // 显示错误信息
            }
        });

        $("#div-carManage").show();
        $("#div-userManage").hide();
        $("#div-parkinglotManage").hide();
    });

    // 显示车位信息
    $("#btn-parkinglotManage").click(function () {
        $.get("getparkinglotinfocl", function (data) {
            var result = $.parseJSON($.base64.decode(data));
            if (result.code == 1) {} else {
                // 显示错误信息
            }
        });

        $("#div-parkinglotManage").show();
        $("#div-userManage").hide();
        $("#div-carManage").hide();
    });


});
