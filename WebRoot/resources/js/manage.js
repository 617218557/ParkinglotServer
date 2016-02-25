$(document).ready(function () {
    $("#btn-userManage").click(function () {
        $("#div-userManage").show();
        $("#div-carManage").hide();
        $("#div-parkinglotManage").hide();
    });
    $("#btn-carManage").click(function () {
        $("#div-carManage").show();
        $("#div-userManage").hide();
        $("#div-parkinglotManage").hide();
    });
    $("#btn-parkinglotManage").click(function () {
        $("#div-parkinglotManage").show();
        $("#div-userManage").hide();
        $("#div-carManage").hide();
    });


});
