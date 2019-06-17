/**
 * @author wuj
 * @date   2018-09-01
 */
var prefix = "/system/dict";
$(function() {
	validateRule();
});


$.validator.setDefaults({
	submitHandler : function() {
		save();
	}
});

// 新增
function save() {
	app.doSave({url:prefix+'/save',data : $('#addForm').serialize(),action:ACTION.ADD});
}


// 校验规则
function validateRule() {
	var icon = "<i class='fa fa-times-circle'></i> ";
	$("#addForm").validate({
		rules : {
		},
		messages : {
		}
	});
}