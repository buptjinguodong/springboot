JPF={};
JPF.ui={};
JPF.ui.table=function(option) {
    var that = this;
    var _id = option.id;
    var _removeId = option.removeId;
    var $table = $(_id),
        $remove = $(_removeId),
        selections = [];

    // 接收表头信息
    var _columns = option.columns;
    var _idField = option.idField;
    var _responseHandler = option.responseHandler;
    var _toolbar = option.toolbar;
    var _url = option.url;
    var _jsonData = option.jsonData;

    function initTable() {
        $table.bootstrapTable({
            locale: 'zh-CN',
            dataField: 'rows',
            totalField: 'total',
            method: 'post',
            queryParams: function (params) {
                params.svcTpcd = _jsonData.svcTpcd;
                params.paramSeq = _jsonData.paramSeq;
                return params;
            },
            // height: getHeight(),
            detailFormatter: that.detailFormatter,
            toolbar: _toolbar,
            search: true,
            showRefresh: true,
            showToggle: true,
            showColumns: true,
            showExport: true,
            detailView: true,
            minimumCountColumns: 2,
            showPaginationSwitch: true,
            pagination: true,
            idField: _idField,
            pageList:['10', '25', '50', '100', 'ALL'],
            showFooter:false,
            sidePagination:"server",
            url: _url,
            responseHandler: function(data) {
                return _responseHandler(data);
            },
            columns: _columns
        });
        // sometimes footer render error.
        setTimeout(function () {
            $table.bootstrapTable('resetView');
        }, 200);
        $table.on('check.bs.table uncheck.bs.table ' +
            'check-all.bs.table uncheck-all.bs.table', function () {
            $remove.prop('disabled', !$table.bootstrapTable('getSelections').length);

            // save your data, here just save the current page
            selections = getIdSelections();
            // push or splice the selections if you want to save all data selections
        });
        $table.on('expand-row.bs.table', function (e, index, row, $detail) {
            // ... - 定义扩展信息展示格式化
        });
        $table.on('all.bs.table', function (e, name, args) {
            console.log(name, args);
        });
        $remove.click(function () {
            var ids = getIdSelections();
            $table.bootstrapTable('remove', {
                field: _idField,
                values: ids
            });
            $remove.prop('disabled', true);
        });
        $(window).resize(function () {
            // $table.bootstrapTable('resetView', {
            //     height: getHeight()
            // });
        });
    }

    function getIdSelections() {
        return $.map($table.bootstrapTable('getSelections'), function (row) {
            return row[_idField];
        });
    }

    that.detailFormatter = function(index, row) {
        var html = [];
        $.each(row, function (key, value) {
            html.push('<p><b>' + key + ':</b> ' + value + '</p>');
        });
        return html.join('');
    }

    function getHeight() {
        return $(window).height() - $('h1').outerHeight(true);
    }
    initTable();

    return $table;
};
