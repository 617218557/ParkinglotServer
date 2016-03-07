$(document).ready(function () {
    $(function () {
        initUserPage();
        initCarPage();
        initParkinglotPage();
    });

    // 显示用户信息
    $("#btn-userManage").click(function () {
        $("#div-userManage").show();
        $("#div-carManage").hide();
        $("#div-parkinglotManage").hide();
    });

    // 显示车辆信息
    $("#btn-carManage").click(function () {
        $("#div-carManage").show();
        $("#div-userManage").hide();
        $("#div-parkinglotManage").hide();
    });

    // 显示车位信息
    $("#btn-parkinglotManage").click(function () {
        $("#div-parkinglotManage").show();
        $("#div-userManage").hide();
        $("#div-carManage").hide();
    });

    $("#btn-logout").click(function () {
        window.location.href = "index.html";
    });

    function initUserPage() {
        jQuery("#list-user").jqGrid({
            url: 'getalluserinfocl',
            datatype: "json",
            width: window.screen.availWidth - 50,
            autowidth: false,
            shrinkToFit: true,
            colNames: ['id', '昵称', '手机号', '密码', '年龄', '性别', '头像地址', '操作'],
            height: "auto", //高度，表格高度。可为数值、百分比或'auto'
            colModel: [{
                name: 'user_id',
                index: 'user_id',
                key: true,
                sortable: true,
                align: "center"
                }, {
                name: 'user_name',
                index: 'user_name',
                editable: true,
                sortable: true,
                align: "center",
                }, {
                name: 'user_phoneNum',
                index: 'user_phoneNum',
                editable: true,
                sortable: true,
                align: "center"
                }, {
                name: 'user_password',
                index: 'user_password',
                editable: true,
                sortable: true,
                align: "center"
                }, {
                name: 'user_age',
                index: 'user_age',
                editable: true,
                sortable: true,
                align: "center"
                }, {
                name: 'user_gender',
                index: 'user_gender',
                sortable: true,
                align: "center",
                editable: true,
                edittype: "select",
                editoptions: {
                    value: "0:女;1:男"
                }
                }, {
                name: 'user_img',
                index: 'user_img',
                editable: true,
                sortable: true,
                align: "left",
                }, {
                name: 'act',
                index: 'act',
                sortable: false,
                }],
            rowNum: 99999,
            pager: '#pager-user',
            sortname: 'id',
            altRows: true, //设置为交替行表格
            mtype: "post",
            viewrecords: true,
            sortorder: "desc",
            caption: "用户管理",
            gridComplete: function () {
                var ids = jQuery("#list-user").jqGrid('getDataIDs');
                for (var i = 0; i < ids.length; i++) {
                    var cl = ids[i];
                    be = "<input style='height:22px;width:50px;' type='button' value='编辑' onclick=\"jQuery('#list-user').editRow('" + cl + "');\" />";
                    se = "<input style='height:22px;width:50px;' type='button' value='保存' onclick=\"jQuery('#list-user').saveRow('" + cl + "');\" />";
                    ce = "<input style='height:22px;width:50px;' type='button' value='删除' onclick='delUser(" + cl + ")' />";
                    de = "<input style='height:22px;width:50px;' type='button' value='取消' onclick=\"jQuery('#list-user').restoreRow('" + cl + "');\" />";
                    jQuery("#list-user").jqGrid('setRowData', ids[i], {
                        act: be + se + ce + de
                    });
                }
            },
            editurl: "updateuserinfocl",
        });
        jQuery("#list-user").jqGrid('navGrid', '#pager-user', {
            edit: false,
            add: false,
            del: false
        });

    }

    function initCarPage() {
        jQuery("#list-car").jqGrid({
            url: 'getallcarinfocl',
            datatype: "json",
            width: window.screen.availWidth - 50,
            autowidth: false,
            shrinkToFit: true,
            colNames: ['id', '车牌号', '车主id', '车辆类型', '车辆图片地址', '操作'],
            height: "auto", //高度，表格高度。可为数值、百分比或'auto'
            colModel: [{
                name: 'car_id',
                index: 'car_id',
                key: true,
                align: "center"
                }, {
                name: 'car_licenseNum',
                index: 'car_licenseNum',
                editable: true,
                sortable: true,
                align: "center",
                }, {
                name: 'user_id',
                index: 'user_id',
                editable: true,
                sortable: true,
                align: "center"
                }, {
                name: 'car_type',
                index: 'car_type',
                editable: true,
                sortable: true,
                align: "center"
                }, {
                name: 'car_img',
                index: 'car_img',
                editable: true,
                sortable: true,
                align: "center",
                }, {
                name: 'act',
                index: 'act',
                sortable: false,
                }],
            rowNum: 99999,
            pager: '#pager-car',
            sortname: 'id',
            altRows: true, //设置为交替行表格
            mtype: "post",
            viewrecords: true,
            sortorder: "desc",
            caption: "车辆管理",
            gridComplete: function () {
                var ids = jQuery("#list-car").jqGrid('getDataIDs');
                for (var i = 0; i < ids.length; i++) {
                    var cl = ids[i];
                    be = "<input style='height:22px;width:50px;' type='button' value='编辑' onclick=\"jQuery('#list-car').editRow('" + cl + "');\" />";
                    se = "<input style='height:22px;width:50px;' type='button' value='保存' onclick=\"jQuery('#list-car').saveRow('" + cl + "');\" />";
                    ce = "<input style='height:22px;width:50px;' type='button' value='删除' onclick='delCar(" + cl + ")' />";
                    de = "<input style='height:22px;width:50px;' type='button' value='取消' onclick=\"jQuery('#list-car').restoreRow('" + cl + "');\" />";
                    jQuery("#list-car").jqGrid('setRowData', ids[i], {
                        act: be + se + ce + de
                    });
                }
            },
            editurl: "updatecarinfocl",
        });
        jQuery("#list-car").jqGrid('navGrid', '#pager-car', {
            edit: false,
            add: false,
            del: false
        });
    }

    function initParkinglotPage() {
        jQuery("#list-parkinglot").jqGrid({
            url: 'getparkinglotinfocl',
            datatype: "json",
            width: window.screen.availWidth - 50,
            autowidth: false,
            shrinkToFit: true,
            colNames: ['id', '费用', '是否被占用', '停靠车辆id', '开始停车时间', '操作'],
            height: "auto", //高度，表格高度。可为数值、百分比或'auto'
            colModel: [{
                name: 'park_id',
                index: 'park_id',
                key: true,
                align: "center"
                }, {
                name: 'park_fee',
                index: 'park_fee',
                editable: true,
                sortable: true,
                align: "center",
                }, {
                name: 'park_isUse',
                index: 'park_isUse',
                editable: true,
                sortable: true,
                align: "center"
                }, {
                name: 'park_car',
                index: 'park_car',
                editable: true,
                sortable: true,
                align: "center"
                }, {
                name: 'park_startTime',
                index: 'park_startTime',
                editable: true,
                sortable: true,
                align: "center"
                }, {
                name: 'act',
                index: 'act',
                sortable: false,
                }],
            rowNum: 99999,
            pager: '#pager-parkinglot',
            sortname: 'id',
            altRows: true, //设置为交替行表格
            mtype: "post",
            viewrecords: true,
            sortorder: "desc",
            caption: "车位管理",
            gridComplete: function () {
                var ids = jQuery("#list-parkinglot").jqGrid('getDataIDs');
                for (var i = 0; i < ids.length; i++) {
                    var cl = ids[i];
                    be = "<input style='height:22px;width:50px;' type='button' value='编辑' onclick=\"jQuery('#list-parkinglot').editRow('" + cl + "');\" />";
                    se = "<input style='height:22px;width:50px;' type='button' value='保存' onclick=\"jQuery('#list-parkinglot').saveRow('" + cl + "');\" />";
                    ce = "<input style='height:22px;width:50px;' type='button' value='取消' onclick=\"jQuery('#list-parkinglot').restoreRow('" + cl + "');\" />";
                    jQuery("#list-parkinglot").jqGrid('setRowData', ids[i], {
                        act: be + se + ce
                    });
                }
            },
            editurl: "updateparkinglotinfocl",
        });
        jQuery("#list-parkinglot").jqGrid('navGrid', '#pager-parkinglot', {
            edit: false,
            add: false,
            del: false
        });
    }
});
