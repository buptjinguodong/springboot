
var commonParamEdit = {};

commonParamEdit.init = function(){
    // 初始化Table
    $('#myTable').bootstrapTable({
        locale:'zh-CN',
        url: Common.ROOT + '/param/A06280201',
        columns: [{
            field: 'paramSeq',
            title: 'Item ID'
        }, {
            field: 'paramDesc',
            title: 'Item Name'
        }, {
            field: 'price',
            title: 'Item Price'
        }, ]
    });
};


$(document).ready(function(){
    commonParamEdit.init();
});