<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" charset="utf-8" src="/js/md5.js"></script>
<title>管理员登录</title>
<jsp:include page="/commons/common-js.jsp"></jsp:include>
</head>
<body style="background-color: #F3F3F3">
    <div class="easyui-dialog" title="管理员登录" data-options="closable:false,draggable:false" style="width:400px;height:300px;padding:10px;">
       	<div style="margin-left: 50px;margin-top: 50px;">
       		<div style="margin-bottom:20px;">
	            <div>
	            	用户名: <input name="username" class="easyui-textbox" data-options="required:true" style="width:200px;height:32px" />
	            </div>
	        </div>
	        <div style="margin-bottom:20px">
	            <div>
	            	密&nbsp;&nbsp;&nbsp;码: <input name="password" class="easyui-textbox" type="password" style="width:200px;height:32px" data-options="" />
	            </div>
	        </div>
	        <div>
				<a id="login" class="easyui-linkbutton" iconCls="icon-ok" style="width:100px;height:32px;margin-left: 10px">登录</a>
				<a id="register" class="easyui-linkbutton" iconCls="icon-redo" style="width:100px;height:32px;margin-left: 60px" href="/page/register">注册</a>
	        </div>
       	</div>
    </div>
    
    <script type="text/javascript">
    	$("#login").click(function(){
    		var username = $("[name=username]").val();
    		var password = $("[name=password]").val();
			var md5password = hex_md5(password);
			var params = { "username": username, "password": md5password};
			$.post("/item/login", params, function (data) {
				if (data.success ) {
					$.messager.alert('提示', '登录成功!', undefined, function () {
						//$("#itemList").datagrid("reload");
						window.location.href="/page/index";
					});
				}
				else{
					$.messager.alert('错误', "用户名密码不正确！");
					return;
				}
				//console.log(data);
			});
    		// if(username!="admin" || password!="admin"){
    		// 	$.messager.alert('错误',"用户名密码不正确！");
    		// 	return ;
    		// }

    	});
    </script>
</body>
</html>