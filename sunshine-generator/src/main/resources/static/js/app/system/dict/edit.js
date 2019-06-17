/**
 * @author wuj
 * @date   2018-09-01
 */
var prefix = "/system/dict";
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
		},
		messages : {
		}
	});
}