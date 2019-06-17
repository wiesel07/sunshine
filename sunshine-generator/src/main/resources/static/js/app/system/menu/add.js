var prefix = "/sys/menu"
$(function() {
	validateRule();
});

function selectMenuTree(){
	var parentId = $("#parentId").val();
	var url=prefix + '/treeView/'+parentId;
	app.layer_show({title:'选择菜单',content : url,area:["360px","360px"]});
	
}
//打开图标列表
function selectIcon(){
	var url = "/FontIcoList.html";
	app.layer_show({title:'图标列表',content : url, area: ['600px', '90%']});
}

$.validator.setDefaults({
	submitHandler : function() {
		save();
	}
});
function save() {
	app.doSave({url:prefix+'/save',data : $('#addForm').serialize(),action:ACTION.ADD});
}

function validateRule() {
	var icon = "<i class='fa fa-times-circle'></i> ";
	$("#addForm").validate({
		rules : {
			name : {
				required : true
			},
			type : {
				required : true
			},
			perms : {
				required : true,
				remote : {
					url : prefix+"/checkPerms", // 后台处理程序
					type : "post", // 数据发送方式
					dataType : "json", // 接受数据格式
					data : { // 要传递的数据
						perms : function() {
							return $("#perms").val();
						}
					}
				}
			},
		},
		messages : {
			name : {
				required : icon + "请输入菜单名"
			},
			type : {
				required : icon + "请选择菜单类型"
			},
			perms : {
				required : icon + "请输入您的权限标识符",
				remote : icon + "权限标识符已经存在"
			},
		}
	})
}