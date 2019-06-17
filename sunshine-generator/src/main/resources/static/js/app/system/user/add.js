var prefix = "/sys/user"
$().ready(function() {
//	if(navigator.userAgent.toLowerCase().indexOf("chrome") != -1){ 
//		   var inputers = document.getElementsByTagName("input"); 
//		   for(var i=0;i<inputers.length;i++){ 
//		    if((inputers[i].type !== "submit") && (inputers[i].type !== "password")){ 
//		     inputers[i].disabled= true; 
//		    } 
//		   } 
//		   setTimeout(function(){ 
//		    for(var i=0;i<inputers.length;i++){ 
//		     if(inputers[i].type !== "submit"){ 
//		      inputers[i].disabled= false; 
//		     } 
//		    } 
//		   },100) 
//		  }
	validateRule();
});

$.validator.setDefaults({
	submitHandler : function() {
		save();
	}
});

function save() {
	//app.doSave({url:'/sys/role/save',data : $('#addForm').serialize()});
	app.doSave({url:prefix+'/save',data : $('#addForm').serialize(),action:ACTION.ADD});
}
function validateRule() {
	var icon = "<i class='fa fa-times-circle'></i> ";
	$("#addForm").validate({
		rules : {
			name : {
				required : true
			},
			username : {
				required : true,
				minlength : 2,
				remote : {
					url : prefix+"/checkUsername", // 后台处理程序
					type : "post", // 数据发送方式
					dataType : "json", // 接受数据格式
					data : { // 要传递的数据
						username : function() {
							return $("#username").val();
						}
					}
				}
			},
			password : {
				required : true,
				minlength : 6
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
				minlength : icon + "用户名必须两个字符以上",
				remote : icon + "用户名已经存在"
			},
			password : {
				required : icon + "请输入您的密码",
				minlength : icon + "密码必须6个字符以上"
			},
			email : icon + "请输入您的E-mail",
		}
	})
}

function selectDeptTree(){
	var url= '/sys/dept/treeView/xxx';
	app.layer_show({title:'选择部门',content : url,area:["360px","360px"]});
}
