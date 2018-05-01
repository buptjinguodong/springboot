
var commonParamDetailEdit = {};

commonParamDetailEdit.init = function() {
    var that = this;

    that.mytable = new JPF.ui.table(
        {
            id: "#table",
            removeId: "#remove",
            idField: "paramSeq",
            toolbar: "#toolbar",
            url: "/demo/param/A06280202",
            jsonData: {
                "svcTpcd":"04",
                "paramSeq":"0000000001"
            },
            responseHandler: function(res) {
                return res;
            },
            columns: [
                [
                    {
                        field: '',
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
};




$(document).ready(function(){
    commonParamDetailEdit.init();
});