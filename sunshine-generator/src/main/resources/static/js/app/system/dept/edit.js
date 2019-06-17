var prefix = "/sys/dept"

	$().ready(function() {
	validateRule();
});


$.validator.setDefaults({
	submitHandler : function() {
		update();
	}
});

function selectDeptTree(){
	var url=prefix + '/treeView/xxx';
	app.layer_show({title:'选择部门',content : url,area:["360px","360px"]});
	
}

function update() {
	
	$.ajax({
		cache : true,
		type : "POST",
		url  : prefix+"/update",
		data : $('#editForm').serialize(),
		async : false,
		error : function(request) {
			app.modalAlert("系统错误", modal_status.FAIL);
		},
		success : function(result) {
			if (result.code == web_status.SUCCESS) {
				parent.layer.msg("修改成功,正在刷新数据请稍后……",{icon:1,time: 800,shade: [0.1,'#fff']},function(){
					app.parentReload();
				});
			} else {
				app.modalAlert(result.msg, modal_status.FAIL);
			}

		}
   });
}

function validateRule() {
	var icon = "<i class='fa fa-times-circle'></i> ";
	$("#editForm").validate({
		rules : {
			name : {
				required : true
			}
		},
		messages : {
			name : {
				required : icon + "请输入名字"
			}
		}
	})
}