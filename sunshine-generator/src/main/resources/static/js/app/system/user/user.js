var prefix = "/sys/user"
$(function() {
	loadTree();
	load();
});

function load() {
	 app.table('#table',{
				url : prefix + "/list", // 服务器数据的加载地址
				iconSize : 'outline',
				toolbar : '#toolbar',
				dataType : "json", // 服务器返回的数据类型
				method : 'get', 
				columns : [
					{
						checkbox : true
					},
					{
						title : '序号' ,// 列标题
						formatter: function (value, row, index) {
 							return index+1;
 						}

					},
					{
						field : 'userId', // 列字段名
						title : '用户ID', // 列标题
					    visible:false		
					},
					{
						field : 'name',
						title : '姓名'
					},
					{
						field : 'username',
						title : '用户名'
					},
					{
						field : 'email',
						title : '邮箱'
					},
					{
						field : 'status',
						title : '状态',
						align : 'center',
						formatter : function(value, row, index) {
							if (value == '0') {
								return '<span class="label label-danger">禁用</span>';
							} else if (value == '1') {
								return '<span class="label label-primary">正常</span>';
							}
						}
					},
					{
						title : '操作',
						field : 'id',
						align : 'center',
						formatter : function(value, row, index) {
							var e = '<a  class="btn btn-success btn-sm ' + s_edit_h + '" href="#" mce_href="#" title="编辑" onclick="edit(\''
								+ row.userId
								+ '\')"><i class="fa fa-edit ">编辑</i></a> ';
							var d = '<a class="btn btn-danger btn-sm ' + s_delete_h + '" href="#" title="删除"  mce_href="#" onclick="del(\''
								+ row.userId
								+ '\')"><i class="fa fa-remove">删除</i></a> ';
							var f = '<a class="btn btn-info btn-sm ' + s_resetPwd_h + '" href="#" title="重置密码"  mce_href="#" onclick="resetPwd(\''
								+ row.userId
								+ '\')"><i class="fa fa-key">重置密码</i></a> ';
							return e + d + f;
						}
					} ],
				params:function(){
			           return $("#queryForm").serializeObject();
			     }
			});
}
function reLoad() {
	$('#table').bootstrapTable('refresh');
}

/**
* 搜索
*/
function query(){
    app.tableQuery($("#queryForm").serializeObject());
}

function add() {
	var url=prefix + '/add';
	app.layer_show({title:'添加用户',content : url});
}
function del(id) {
	var data ={"id":id};
	app.modalConfirm('确定要删除选中的记录？',
			function() {
						app._ajax(	{url : prefix + "/delete",
								     data :data
								})
	                    }			
	     );
}
function edit(id) {
	var url=prefix + '/edit/'+id;
	app.layer_show({title:'用户修改',content : url});
}
function resetPwd(id) {
	var url=prefix + '/resetPwd/'+ id;
	app.layer_show({title:'重置密码',content : url,area:["600px","400px"]});
}
function batchDelete() {
	var ids=app.getTableSelections('userId');
	if (ids.length == 0) {
		layer.msg("请选择要删除的数据",{time:600});
		return;
	}
	
	app.modalConfirm('确定要删除选中的记录？',
			function() {
						var data ={"ids":ids};
						app._ajax(	{url : prefix + "/batchDelete",
								     data :data
								})
	                    }			
	 );
}


function loadTree() {
	var setting = {
		view : {
			selectedMulti : false
		},
		data : {
			key : {
				title : "name"
			},
			simpleData : {
				enable : true,
				idKey : "id",
				pIdKey : "pid"
			}
		},
		callback : {
			onClick : function(event, treeId, treeNode) {
				$("#deptId").val(treeNode.id);
				$("#parentId").val(treeNode.pId);
				query();
			}
		}
	}
	$.ajax({
		type : "GET",
		url : "/sys/dept/tree",
		success : function(result) {
			tree = $.fn.zTree.init($("#deptTree"), setting, result); //.expandAll(true);
			 // 展开第一级节点
		    var nodes = tree.getNodesByParam("level", 0);
		    for (var i = 0; i < nodes.length; i++) {
		        tree.expandNode(nodes[i], true, false, false);
		    }
		    // 展开第二级节点
		    nodes = tree.getNodesByParam("level", 1);
		    for (var i = 0; i < nodes.length; i++) {
		        tree.expandNode(nodes[i], true, false, false);
		    } 
		}
	});
};