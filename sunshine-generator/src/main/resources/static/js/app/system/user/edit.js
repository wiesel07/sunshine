var prefix = "/sys/user"
$().ready(function() {
	validateRule();
});

$.validator.setDefaults({
	submitHandler : function() {
		update();
	}
});
function update() {
	app.doSave({url:prefix+'/update',data : $('#editForm').serialize(),action:ACTION.EDIT});
}

function validateRule() {
	var icon = "<i class='fa fa-times-circle'></i> ";
	$("#editForm").validate({
		rules : {
			name : {
				required : true
			},
			username : {
				required : true,
				minlength : 2
			},
			email : {
				required : true,
				email : true
			}
		},
		messages : {

			name : {
				required : icon + "请输入姓名"
			},
			username : {
				required : icon + "请输入您的用户名",
				minlength : icon + "用户名必须两个字符以上"
			},
			email : icon + "请输入您的E-mail",
		}
	})
}

function selectDeptTree(){
	var url= '/sys/dept/treeView/xxx';
	app.layer_show({title:'选择部门',content : url,area:["360px","360px"]});
}