var prefix = "/sys/dept"
$(function() {
	load();
});

function load() {
	
    var options = {
			code : 'deptId',
            parentCode : 'parentId',
			type : "GET", // 请求数据的ajax类型
			url : prefix + '/list', // 请求数据的ajax的url
			ajaxParams : {}, // 请求数据的ajax的data属性
			expandAll : true, // 是否全部展开
			// toolbar : '#exampleToolbar',
			columns : [
				{
					field : 'name',
					title : '部门名称',
				},
				 {
		            field: 'orderNum',
		            title: '排序',
		            align: "center"
		        },
				{
					field : 'delFlag',
					title : '状态',
					align : 'center',
					formatter : function(value, row, index) {
						if (row.delFlag == '0') {
							return '<span class="label label-danger">禁用</span>';
						} else if (row.delFlag == '1') {
							return '<span class="label label-primary">正常</span>';
						}
					}
				},
				{
					title : '操作',
					field : 'id',
					align : 'center',
                    valign : 'center',
					formatter : function(value, row, index) {
						var e = '<a class="btn btn-success btn-sm ' + s_edit_h + '" href="#" mce_href="#" title="编辑" onclick="edit(\''
							+ row.deptId
							+ '\')"><i class="fa fa-edit">编辑</i></a> ';
						
						var a = '<a class="btn btn-primary btn-sm ' + s_add_h + '" href="#" title="增加下級"  mce_href="#" onclick="add(\''
							+ row.deptId
							+ '\')"><i class="fa fa-plus">新增</i></a> ';
						
						var d = '<a class="btn btn-danger btn-sm ' + s_delete_h + '" href="#" title="删除"  mce_href="#" onclick="del(\''
							+ row.deptId
							+ '\')"><i class="fa fa-remove">删除</i></a> ';
						return e + a + d;
					}
				} ]
	    };
	    $.treeTable.init(options);
}
function reLoad() {
	$.treeTable.refresh();
}

var $tree={};
function getTreeObj(){
	return $tree;
}
//新增
function add(pId) {
	$tree=$.treeTable;
	console.log("输出:"+JSON.stringify($.treeTable._option))
	var url=prefix + '/add/'+pId;
	app.layer_show({title:'添加部门',content : url});
}

function edit(pId) {
	var url = prefix + '/edit/' + pId;
	app.layer_show({title:'部门修改',content : url});
}


function del(id) {
	var data ={"id":id};
//	app.modalConfirm('确定要删除选中的记录？',
//			function() {
//						app._ajax(	{url : prefix + "/delete",
//								     data :data
//								})
//	                    }			
//	     );
	layer.confirm('确定要删除选中的记录？', {
		btn : [ '确定', '取消' ]
	}, function() {
		$.ajax({
			url :  prefix + "/delete",
			type : "post",
			data :data,
			success : function(r) {
				if (r.code == 0) {
					layer.msg(r.msg,{time:600});
					reLoad();
				} else {
					layer.msg(r.msg,{time:600});
				}
			}
		});
	})
	
}

function batchDelete() {
	
	var rows = $('#bootstrap-treeTable').bootstrapTable('getSelections'); // 返回所有选择的行，当没有选择的记录时，返回一个空数组
	if (rows.length == 0) {
		layer.msg("请选择要删除的数据",{time:600});
		return;
	}
	
	app.modalConfirm('确定要删除选中的记录？',
			function() {
						var ids = new Array();
						$.each(rows, function(i, row) {
							ids[i] = row['deptId'];
						});
						var data ={"ids":ids};
						$.ajax({
							url :  prefix + "/batchDelete",
							type : "post",
							data :data,
							success : function(r) {
								if (r.code == 0) {
									layer.msg(r.msg,{time:600});
									reLoad();
								} else {
									layer.msg(r.msg,{time:600});
								}
							}
						});
	    })			
}

