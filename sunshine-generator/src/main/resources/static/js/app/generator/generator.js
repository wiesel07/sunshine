/**
 * wuj 20180821
 */
var prefix = "/generator";
$(function() {
	load();
});

function query() {
	$('#table').bootstrapTable('refresh');
}

function load() {
	app.table('#table', {
		url : prefix + "/list", // 服务器数据的加载地址
		dataType : "json", // 服务器返回的数据类型
		toolbar : '#toolbar',
		queryParamsType : 'limit' ,
		method : 'get',
		columns : [ { // 列配置项
			// 数据类型，详细参数配置参见文档http://bootstrap-table.wenzhixin.net.cn/zh-cn/documentation/
			checkbox : true
		// 列表中显示复选框
		}, {
			title : '序号',// 列标题
			formatter : function(value, row, index) {
				return index + 1;
			}

		}, {
			field : 'tableName', // 列字段名
			title : '表名', // 列标题
		}, {
			field : 'engine',
			title : 'Engine'
		}, {
			field : 'tableComment',
			title : '表备注'
		}, {
			field : 'owner',
			title : '所属用户'
		}, {
			title : '操作',
			align : 'center',
			formatter : function(value, row, index) {
				var g = '<a class="btn btn-primary btn-sm " href="#" title="生成"  mce_href="#" onclick="code(\''
				+ row.tableName
				+ '\')">生成</a> ';
				
				return g;
			}
		} ],
		params : function() {
			return $("#queryForm").serializeObject();
		}
	});
}

function code(tableName) {
	location.href = prefix + "/code/" + tableName;
}
function batchCode() {
	var rows = $('#table').bootstrapTable('getSelections'); // 返回所有选择的行，当没有选择的记录时，返回一个空数组
	if (rows.length == 0) {
		layer.msg("请选择要生成代码的表");
		return;
	}
	var tables = new Array();
	// 遍历所有选择的行数据，取每条数据对应的ID
	$.each(rows, function(i, row) {
		tables[i] = row['tableName'];
	});

    location.href = prefix + "/batchCode?tables=" + JSON.stringify(tables);
//	var url=  prefix + "/batchCode?tables=" + JSON.stringify(tables);
//
//	$.ajax({
//        url: url,
//        type: "post",
//        data: {
//        },
//        success: function (data) {
//            if (data.code == 0) {
//                layer.msg("生成成功");
//            } else {
//                layer.msg(data.msg);
//            }
//        }
//    });
}

function edit(){
	console.log('打开配置页面');
	layer.open({
		type : 2,
		title : '增加',
		maxmin : true,
		shadeClose : false, 
		area : [ '800px', '520px' ],
		content : prefix + '/edit'
	});
}