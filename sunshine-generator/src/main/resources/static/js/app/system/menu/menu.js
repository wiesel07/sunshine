var prefix = "/sys/menu"
$(document).ready(function () {
    load();
});
function load() {
	var options= {
	        id: 'menuId',
	        code: 'menuId',
	        parentCode: 'parentId',
	        type: "GET", // 请求数据的ajax类型
	        url: prefix + '/list', // 请求数据的ajax的url
	        ajaxParams: {sort:'order_num'}, // 请求数据的ajax的data属性
	        expandColumn: '0',// 在哪一列上面显示展开按钮
	       // striped: true, // 是否各行渐变色
	      //  bordered: true, // 是否显示边框
	        expandAll: false, // 是否全部展开
	        // toolbar : '#exampleToolbar',
	        columns: [
	            {
	                title: '名称',
	                field: 'name'
	            },
	            {
	                title: '图标',
	                field: 'icon',
	                align: "center",
	                formatter: function (value,row, index) {
	                    return row.icon == null ? ''
	                        : '<i class="' + row.icon
	                        + ' fa-lg"></i>';
	                }
	            },
	            {
	                title: '类型',
	                field: 'type',
	                align: "center",
	                formatter: function (value,row, index) {
	                    if (row.type === 0) {
	                        return '<span class="label label-primary">目录</span>';
	                    }
	                    if (row.type === 1) {
	                        return '<span class="label label-success">菜单</span>';
	                    }
	                    if (row.type === 2) {
	                        return '<span class="label label-warning">按钮</span>';
	                    }
	                }
	            },
	            {
	                title: '地址',
	                align: "center",
	                field: 'url'
	            },
	            {
	                title: '权限标识',
	                align: "center",
	                field: 'perms'
	            },
	            {
	                title: '操作',
	                field: 'id',
	                align: "center",
	                formatter: function (value,row, index) {
	                    var e = '<a class="btn btn-success btn-sm '
	                        + s_edit_h
	                        + '" href="#" mce_href="#" title="编辑" onclick="edit(\''
	                        + row.menuId
	                        + '\')"><i class="fa fa-edit">编辑</i></a> ';
	                    var p = '<a class="btn btn-primary btn-sm '
	                        + s_add_h
	                        + '" href="#" mce_href="#" title="添加下级" onclick="add(\''
	                        + row.menuId
	                        + '\')"><i class="fa fa-plus">新增</i></a> ';
	                    var d = '<a class="btn btn-danger btn-sm '
	                        + s_delete_h
	                        + '" href="#" title="删除"  mce_href="#" onclick="del(\''
	                        + row.menuId
	                        + '\')"><i class="fa fa-remove">删除</i></a> ';
	                    return e + p + d;
	                }
	            }]
	    }
	   $.treeTable.init(options);
}


function add(pId) {
	var url=prefix + '/add/'+pId;
	app.layer_show({title:'添加菜单',content : url});
}


function edit(pId) {
	var url = prefix + '/edit/' + pId;
	app.layer_show({title:'菜单修改',content : url});
}

function del(id) {
    layer.confirm('确定要删除选中的记录？', {
        btn: ['确定', '取消']
    }, function () {
        $.ajax({
            url: prefix + "/delete",
            type: "post",
            data: {
                'id': id
            },
            success: function (data) {
                if (data.code == 0) {
                    layer.msg("删除成功",{time: 800});
                    $.treeTable.refresh();
                } else {
                    layer.msg(data.msg);
                }
            }
        });
    })
}
