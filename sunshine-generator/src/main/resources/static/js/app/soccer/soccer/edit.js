/**
 * @author wuj
 * @date   2018-12-05
 */
var prefix = "/soccer/soccer";
var menuTrees;
$(function() {
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
	        home_score : {
				required : true
			},		},
		messages : {
	        home_score : {
				required : icon + "请输入主队分数"
			},		}
	});
}