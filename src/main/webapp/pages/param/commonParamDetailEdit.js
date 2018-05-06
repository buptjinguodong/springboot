
var commonParamDetailEdit = {};

commonParamDetailEdit.init = function() {
    var that = this;

    that.mytable = new JPF.ui.table(
        {
            id: "#table",
            removeId: "#remove",
            idField: "paramKey",
            toolbar: "#toolbar",
            responseHandler: function(res) {
                return res;
            },
            columns: [
                [
                    {
                        field: 'check',
                        checkbox: true,
                        align: 'center',
                        valign: 'middle'
                    }, {
                        title: '参数序号',
                        field: 'paramSeq',
                        align: 'center',
                        valign: 'middle',
                        sortable: true
                    }, {
                        field: 'paramKey',
                        title: '参数描述',
                        sortable: true,
                        editable: true,
                        align: 'center'
                    }, {
                        field: 'operate',
                        title: '操作',
                        align: 'center',
                        events: {
                            'click .like': function (e, value, row, index) {
                                alert('You click like action, row: ' + JSON.stringify(row));
                            },
                            'click .remove': function (e, value, row, index) {
                                that.mytable.bootstrapTable('remove', {
                                    field: 'paramSeq',
                                    values: [row.paramSeq]
                                });
                            }
                        },
                        formatter: function (value, row, index) {
                            return [
                                '<a class="like" href="javascript:void(0)" title="Like">',
                                '<i class="glyphicon glyphicon-heart"></i>',
                                '</a>  ',
                                '<a class="remove" href="javascript:void(0)" title="Remove">',
                                '<i class="glyphicon glyphicon-remove"></i>',
                                '</a>'
                            ].join('');
                        }
                    }
                ]
            ]
        }
    );

    // 按钮
    $("#query").click(function(){
        that.queryAction();
    });
    $("#reset").click(function () {
        that.resetAction();
    })
    $("#save").click(function(){
        that.saveAction();
    });
    $("#add").click(function () {
        that.addAction();
    });
    $("#edit").click(function(){
        that.editAction();
    });
    $("#subSave").click(function(){
        that.subSaveAction();
    });

    // 模态框
    that.modal = $("#myModal");

};
commonParamDetailEdit.subSaveAction = function(){
    var that = this;
    var jsonData = {
        paramSeq : $("#subparamSeq").val(),
        paramKey : $("#paramKey").val(),
        paramValue: $("#paramValue").val(),
        paramRemark: $("#paramRemark").val()
    };
    if(that.flag == "add"){
        that.mytable.bootstrapTable("append",jsonData);
    }else if(that.flag == "edit"){
        // 获取需要修改的行索引
        var allData = that.mytable.bootstrapTable("getData");
        var selectInd = Common.getFirstChecked(allData);
        if(selectInd < 0){
            Common.alert("索引不存在");
        }else{
            that.mytable.bootstrapTable("updateRow",{index:selectInd, row:jsonData});
        }
    }else{
        Common.alert("参数错误");
    }
    that.modal.modal("toggle");
};
commonParamDetailEdit.addAction = function(){
    var that = this;
    // 展示子页面
    that.modal.modal("toggle");
    that.flag = "add";

};
commonParamDetailEdit.editAction = function(){
    var that = this;
    // 展示子页面
    that.modal.modal("toggle");
    that.flag = "edit";

};
commonParamDetailEdit.saveAction = function(){
    var that = this;
    var jsonData = {
        svcTpcd: "03", //维护
        paramSeq: $("#paramSeq").val(),
        list1:that.mytable.bootstrapTable("getData")
    };
    Common.post({
        data: JSON.stringify(jsonData),
        fw_url: "/param/A06280202",
        success: function(data){
            Common.alert("保存成功");
        }
    });
};

commonParamDetailEdit.queryAction = function(){
    var that = this;
    var jsonData = {
        svcTpcd: "04",
        paramSeq: $("#paramSeq").val()
    };
    Common.post({
        data: JSON.stringify(jsonData),
        fw_url: "/param/A06280202",
        success: function(data){
            that.querySucc(data);
        }
    });
};
commonParamDetailEdit.querySucc = function(data){
    var that = this;
    that.respA06280202 = data;
    that.mytable.bootstrapTable("load", that.respA06280202);
    console.log(data);
};

commonParamDetailEdit.initAction = function(){
    var that = this;
    var jsonData = {
        svcTpcd: "04",
        paramSeq: that._paramSeq
    };
    Common.post({
        data: JSON.stringify(jsonData),
        fw_url: "/param/A06280202",
        success: function(data){
            that.querySucc(data);
        }
    });
};

$(document).ready(function(){
    // 获取URL参数
    var that = commonParamDetailEdit;
    that._paramSeq =Common.getUrlParam("paramSeq");
    $("#paramSeq").val(that._paramSeq);

    that.init();
    that.initAction();
});