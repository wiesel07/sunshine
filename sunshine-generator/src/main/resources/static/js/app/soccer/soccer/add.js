/**
 * @author wuj
 * @date   2018-12-05
 */
var prefix = "/soccer/soccer";
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
	        home_score : {
				required : true
			},		},
		messages : {
	        home_score : {
				required : icon + "请输入主队分数"
			},		}
	});
}