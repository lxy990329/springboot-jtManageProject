<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" charset="utf-8" src="/js/md5.js"></script>
<title>用户注册</title>
<jsp:include page="/commons/common-js.jsp"></jsp:include>
</head>
<body style="background-color: #F3F3F3">
    <div class="easyui-dialog" title="用户注册" data-options="closable:false,draggable:false" style="width:400px;height:400px;padding:10px;">
       	<div style="margin-left: 50px;margin-top: 50px;">
       		<div style="margin-bottom:20px;">
	            <div>
	            	用户名: <input name="username" id="username" class="easyui-textbox" data-options="required:true" style="width:200px;height:32px" onkeyup="showHint(this.value)"/>
                    <p><span id="txtHint"></span></p>
                </div>
	        </div>
	        <div style="margin-bottom:20px">
	            <div>
	            	密&nbsp;&nbsp;&nbsp;码: <input name="password" class="easyui-textbox" type="password" style="width:200px;height:32px" />
	            </div>
            </div>
            <div style="margin-bottom:20px;">
	            <div>
	            	手机号: <input name="phone" class="easyui-textbox" data-options="required:true" style="width:200px;height:32px" />
	            </div>
            </div>
            <div style="margin-bottom:20px">
	            <div>
	            	邮&nbsp;&nbsp;&nbsp;箱: <input name="email" class="easyui-textbox" style="width:200px;height:32px" />
	            </div>
            </div>
	        <div>
                <a id="register" class="easyui-linkbutton" iconCls="icon-ok" style="width:100px;height:32px;margin-left: 10px">注册</a>
				<a id="login" class="easyui-linkbutton" iconCls="icon-undo" style="width:100px;height:32px;margin-left: 60px" href="/page/login">返回登录</a>
	        </div>
       	</div>
    </div>
    
	<script type="text/javascript">
	    // $("#username").keyup(function(){
		// 	console.log("----2");
		// });
		// $("#username").keyup=function(){
		// 	console.log("----2");
		// };
        //  function showHint(str) {
        //     console.log("----2");
        //     if (str.length != 0) {
        //         document.getElementById("txtHint").innerHTML = "你好";
        //         console.log("----3");
        //         return;
        //     }
        // }
    	$("#register").click(function(){
            console.log("----1");
    		var username = $("[name=username]").val();
    		var password = $("[name=password]").val();
			var phone = $("[name=phone]").val();
    		var email = $("[name=email]").val();
			console.log(password.length);
			if(username ==  ""){
				$.messager.alert('错误','账号名不能为空');
				//window.location.reload(true);
				return;
			}
			if(password.length < 8){
				$.messager.alert('错误','密码不能小于8位');
				//window.location.reload(true);
				return;
			}
			var pattern = /(^(([0\+]\d{2,3}-)?(0\d{2,3})-)(\d{7,8})(-(\d{3,}))?$)|(^(([0\+]\d{2,3})?(0\d{2,3}))(\d{7,8})((\d{3,}))?$)|(^0{0,1}1[3|4|5|6|7|8|9][0-9]{9}$)/;
			if(!pattern.test(phone)){
                 $.messager.alert('错误','请输入合法手机号');  
				 return;                                                                           
            }
			//var pattern1 = /(^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$)/;
			var pattern1 = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
			if(!pattern1.test(email)){
                 $.messager.alert('错误','请输入合法邮箱号');  
				 return;                                                                           
            }
            var md5password = hex_md5(password);
			var params = { "username": username, "password": md5password, "phone": phone, "email": email};
			console.log(params);
			$.post("/item/login/register", params, function (data) {
				if (data.success) {
					$.messager.alert('提示', '注册成功!', undefined, function () {
						window.location.href="/page/login";
					});
					// $.messager.alert('提示', '注册成功!', function () {
					// 	//$("#itemList").datagrid("reload");
						
					// });
				}
				else{
					$.messager.alert('错误', data.msg);
					return;
				}
				//console.log(data);
			});

        });

    </script>
</body>
</html>