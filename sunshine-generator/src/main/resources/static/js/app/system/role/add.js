
// 树结构初始化加载
var prefix = "/sys/role"
var menuTrees;
$(function() {
	loadTree();
	validateRule();
});


function loadTree(){
	var setting = {
			check:{enable:true,nocheckInherit:true,chkboxType:{"Y":"ps","N":"ps"}},
			view:{selectedMulti:false,nameIsHTML: true},
			data:{simpleData:{enable:true, idKey: "id",
		        pIdKey: "pid"},key:{title:"title"}},
			callback:{
				beforeClick: function (treeId, treeNode, clickFlag) {
					var menuTrees = $.fn.zTree.getZTreeObj(treeId);
					menuTrees.checkNode(treeNode, !treeNode.checked, true, true);
					return false;
				}
			}
		};
	
	$.ajax({
		type : "GET",
		url : "/sys/menu/tree",
		success : function(result) {
			menuTrees = $.fn.zTree.init($("#menuTree"), setting, result); //.expandAll(true);
		}
	});
};

$.validator.setDefaults({
	submitHandler : function() {
		getAllSelectNodes();
		save();
	}
});

//获取选中的菜单
function getAllSelectNodes() {
    var menuIds = "";
    var treeNodes = menuTrees.getCheckedNodes(true);
    for (var i = 0; i < treeNodes.length; i++) {
        if (0 == i) {
        	menuIds = treeNodes[i].id;
        } else {
        	menuIds += ("," + treeNodes[i].id);
        }
    }
	$('#menuIds').val(menuIds);
}

//新增
function save() {
	app.doSave({url:prefix+'/save',data : $('#addForm').serialize(),action:ACTION.ADD});
}


function validateRule() {
	var icon = "<i class='fa fa-times-circle'></i> ";
	$("#addForm").validate({
		rules : {
			roleName : {
				required : true
			},
			roleSign : {
				required : true
			}
		},
		messages : {
			roleName : {
				required : icon + "请输入角色名"
			},
			roleSign : {
				required : icon + "请输入角色标识"
			}
		}
	});
}