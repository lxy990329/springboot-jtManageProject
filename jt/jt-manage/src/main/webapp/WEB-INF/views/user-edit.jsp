<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="/js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<div style="padding:10px 10px 10px 10px">
	<form id="itemeEditForm" class="itemForm" method="post">
		<input type="hidden" name="id"/>
	    <table cellpadding="5">
	        <tr>
	            <td>用户姓名:</td>
	            <td><input class="easyui-textbox" type="text" name="username" data-options="required:true" style="width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>密码:</td>
	            <td><input class="easyui-textbox" name="password" data-options="multiline:true,validType:'length[0,150]'" style="height:60px;width: 280px;"></input></td>
	        </tr>
	       <tr>
	            <td>手机电话:</td>
	            <td><input class="easyui-textbox" name="phone" data-options="multiline:true,validType:'length[0,150]'" style="height:60px;width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>邮件:</td>
	            <td><input class="easyui-textbox" name="email" data-options="multiline:true,validType:'length[0,150]'" style="height:60px;width: 280px;"></input></td>
	        </tr>
	    </table>
	    <input type="hidden" name="itemParams"/>
	    <input type="hidden" name="itemParamId"/>
	</form>
	<div style="padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">提交</a>
	</div>
</div>
<script type="text/javascript">
	var itemEditEditor ;
	$(function(){
		//实例化编辑器
		itemEditEditor = KindEditorUtil.createEditor("#itemeEditForm [name=itemDesc]");
	});
	
	function submitForm(){
		if(!$('#itemeEditForm').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}
		//alert($("#itemeEditForm"))
		$.post("/user/update",$("#itemeEditForm").serialize(), function(data){
			if(data.status == 200){
				$.messager.alert('提示','修改成功!','info',function(){
					$("#itemEditWindow").window('close');
					$("#itemList").datagrid("reload");
				});
			}else{
				$.message.alert("提示",data.msg);
			}
		});
	}
</script>
