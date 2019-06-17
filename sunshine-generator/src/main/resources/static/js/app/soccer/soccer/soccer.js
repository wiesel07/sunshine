/**
 * @author wuj
 * @date   2018-12-05
 */
var prefix = "/soccer/soccer";
$(function() {
	load();
	 app.datetimepicker('#soccerShowStartDate');
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
	                        field: 'gmtCreate',
	                        title: '创建日期',
	                        formatter: function (value, row, index) {
	 							return value.substr(0,10);
	 						}
	                       
	                    },
					    {
							field : 'code', // 列字段名
							title : '赛事编号', // 列标题
						    align : 'center'
						},
					    {
							field : 'type', // 列字段名
							title : '赛事' // 列标题
						},
					    {
							field : 'homeTeam', // 列字段名
							title : '主队' // 列标题
						},
					    {
							field : 'guestTeam', // 列字段名
							title : '客队' // 列标题
						},
					    {
							field : 'prediction', // 列字段名
							title : '初盘推荐' // 列标题
						},
					    {
							field : 'userName', // 列字段名
							title : '推荐人' // 列标题
						},
					    {
							field : 'result', // 列字段名
							title : '赛果' ,// 列标题
							formatter : function(value, row, index) {
								if (value == '3') {
									return '<span class="label label-danger">红</span>';
								} else if (value == '1') {
									return '<span class="label label-default">走水</span>';
								}else if (value == '0') {
									return '<span class="label label-success">黑</span>';
								}
							}
						},
					    {
							field : 'homeScore', // 列字段名
							title : '主队分数' ,// 列标题
							align : 'center'
						},
					    {
							field : 'guestScore', // 列字段名
							title : '客队分数', // 列标题
							align : 'center'
						},
					    {
							field : 'diffScore', // 列字段名
							title : '分差', // 列标题
							align : 'center'
						},
					    {
							field : 'totalScore', // 列字段名
							title : '总分', // 列标题
							align : 'center'
						},
						{
							title : '操作',
							align : 'center',
							formatter : function(value, row, index) {
								var e = '<a class="btn btn-success btn-sm '+s_edit_h+'" href="#" mce_href="#" title="编辑" onclick="edit(\''
										+ row.id
										+ '\')"><i class="fa fa-edit">编辑</i></a> ';
								var d = '<a class="btn btn-danger btn-sm '+s_delete_h+'" href="#" title="删除"  mce_href="#" onclick="del(\''
										+ row.id
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


/**
* 搜索
*/
function query(){
    app.tableQuery($("#queryForm").serializeObject());
}

function reLoad() {
	$('#table').bootstrapTable('refresh');
}
//新增
function add() {
	app.layer_show({title:'添加',content : prefix + '/add'});
}

function edit(id) {
	var url = prefix + '/edit/' + id;
	app.layer_show({title:'修改',content : url});
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
	
	var rows = $('#table').bootstrapTable('getSelections'); // 返回所有选择的行，当没有选择的记录时，返回一个空数组
	if (rows.length == 0) {
		layer.msg("请选择要删除的数据",{time:600});
		return;
	}
	
	app.modalConfirm('确定要删除选中的记录？',
			function() {
						var ids = new Array();
						$.each(rows, function(i, row) {
							ids[i] = row['id'];
						});
						var data ={"ids":ids};
						app._ajax(	{url : prefix + "/batchDelete",
								     data :data
								})
	                    }			
	 );
}