/**
 * @author wuj
 * @date   2018-09-01
 */
var prefix = "/system/dict";
$(function() {
	load();
});

function load() {
	 app.table('#table',{
		    url : prefix + "/list", // 服务器数据的加载地址
			dataType : "json", // 服务器返回的数据类型
	        toolbar: '#toolbar',
	        method: 'get',
	        columns: [   { // 列配置项
								// 数据类型，详细参数配置参见文档http://bootstrap-table.wenzhixin.net.cn/zh-cn/documentation/
								checkbox : true
						// 列表中显示复选框
						},
						{
							title : '序号' ,// 列标题
							formatter: function (value, row, index) {
	 							return index+1;
	 						}

						},
					    {
							field : 'dictName', // 列字段名
							title : '名称' // 列标题
						},
					    {
							field : 'dictValue', // 列字段名
							title : '数据值' // 列标题
						},
					    {
							field : 'dictType', // 列字段名
							title : '类型' // 列标题
						},
					    {
							field : 'description', // 列字段名
							title : '描述' // 列标题
						},
					    {
							field : 'sort', // 列字段名
							title : '排序（升序）' // 列标题
						},
					    {
							field : 'parentId', // 列字段名
							title : '父级编号' // 列标题
						},
					    {
							field : 'createBy', // 列字段名
							title : '创建者' // 列标题
						},
					    {
							field : 'remarks', // 列字段名
							title : '备注信息' // 列标题
						},
					    {
							field : 'delFlag', // 列字段名
							title : '删除标记' // 列标题
						},
						{
							title : '操作',
							align : 'center',
							formatter : function(value, row, index) {
								var e = '<a class="btn btn-success btn-sm '+s_edit_h+'" href="#" mce_href="#" title="编辑" onclick="edit(\''
										+ row.dictId
										+ '\')"><i class="fa fa-edit">编辑</i></a> ';
								var d = '<a class="btn btn-danger btn-sm '+s_delete_h+'" href="#" title="删除"  mce_href="#" onclick="del(\''
										+ row.dictId
										+ '\')"><i class="fa fa-remove">删除</i></a> ';
								return e + d;
							}
						} 
	               ],
	        params:function(){
	           return $("#queryForm").serializeObject();
	        }
	    });
}
function reLoad() {
	$('#table').bootstrapTable('refresh');
}
//新增
function add() {
	app.layer_show({title:'添加',content : prefix + '/add'});
}

function edit(dictId) {
	var url = prefix + '/edit/' + dictId;
	app.layer_show({title:'修改',content : url});
}

function del(dictId) {
	
	var data ={"dictId":dictId};
	app.modalConfirm('确定要删除选中的记录？',
			function() {
						app._ajax(	{url : prefix + "/delete",
								     data :data
								})
	                    }			
	     );
}

function batchDelete() {
	
	var rows = $('#table').bootstrapTable('getSelections'); // 返回所有选择的行，当没有选择的记录时，返回一个空数组
	if (rows.length == 0) {
		layer.msg("请选择要删除的数据",{time:600});
		return;
	}
	
	app.modalConfirm('确定要删除选中的记录？',
			function() {
						var dictIds = new Array();
						$.each(rows, function(i, row) {
							dictIds[i] = row['dictId'];
						});
						var data ={"dictIds":dictIds};
						app._ajax(	{url : prefix + "/batchDelete",
								     data :data
								})
	                    }			
	 );
}