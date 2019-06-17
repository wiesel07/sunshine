var prefix = "/sys/sysLog"
$(function () {
    load();
});


function load() {
	 app.table('#table',{
				url : prefix + "/list", // 服务器数据的加载地址
				iconSize : 'outline',
				toolbar : '#toolbar',
				dataType : "json", // 服务器返回的数据类型
				method : 'get', 
				 columns: [
	                    {
	                        checkbox: true
	                    },
	                	{
							title : '序号' ,// 列标题
							formatter: function (value, row, index) {
	 							return index+1;
	 						}

						},
//	                    {
//	                        field: 'userId',
//	                        title: '用户Id'
//	                    },
	                    {
	                        field: 'username',
	                        title: '用户名'
	                    },
	                    {
	                        field: 'operation',
	                        title: '操作'
	                    },
	                    {
	                        field: 'time',
	                        title: '用时'
	                    },
	                    {
	                        field: 'method',
	                        title: '方法'
	                    },
	                    {
	                        field: 'params',
	                        title: '参数',
	                        formatter: function (value, row, index) {
	 							return '';
	 						}
	                    },
	                    {
	                        field: 'ip',
	                        title: 'IP地址'
	                    },
	                    {
	                        field: 'gmtCreate',
	                        title: '创建时间'
	                    },
	                    {
	                        title: '操作',
	                        field: 'id',
	                        align: 'center',
	                        formatter: function (value, row, index) {
	                            var d = '<a class="btn btn-danger btn-sm ' + s_delete_h + '" href="#" title="删除"  mce_href="#" onclick="del(\''
								+ row.id
								+ '\')"><i class="fa fa-remove">删除</i></a> ';
	                            return d;
	                        }
	                    }],
				params:function(){
			           return $("#queryForm").serializeObject();
			     }
			});
}


/**
* 搜索
*/
function query(){
    app.tableQuery($("#queryForm").serializeObject());
}

function reLoad() {
	$('#table').bootstrapTable('refresh');
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

function batchDelete() {
	var ids=app.getTableSelections('id');
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


function clearAll() {
	var data ={};
	app.modalConfirm('确定要清空所有的记录？',
			function() {
						app._ajax(	{url : prefix + "/clear",
								     data :data
								})
	                    }			
	     );
}