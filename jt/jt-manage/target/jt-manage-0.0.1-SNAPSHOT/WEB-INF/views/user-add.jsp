<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="/js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<div style="padding:10px 10px 10px 10px">
	<form id="itemAddForm" class="itemForm" method="post">
	    <table cellpadding="5">
	     <tr>
	            <td>UserID:</td>
	            <td><input class="easyui-textbox" type="text" name="id" data-options="required:true" style="width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>用户账号:</td>
	            <td><input class="easyui-textbox" type="text" name="username" data-options="required:true" style="width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>密码:</td>
	            <td><input class="easyui-textbox" name="password" data-options="required:true" style="height:60px;width: 280px;"></input></td>
	        </tr>
	       <tr>
	            <td>手机电话:</td>
	            <td><input class="easyui-textbox" name="phone" data-options="required:true" style="height:60px;width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>邮件:</td>
	            <td><input class="easyui-textbox" name="email" data-options="required:true" style="height:60px;width: 280px;"></input></td>
	        </tr>
	         
	    </table>
	    <input type="hidden" name="itemParams"/>
	</form>
	<div style="padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="userAddPage.submitForm()">提交</a>
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="userAddPage.clearForm()">重置</a>
	</div>
</div>
<script type="text/javascript">
var itemAddEditor ;
$(function(){
	//和form下的itemDesc组件绑定
	itemAddEditor = KindEditorUtil.createEditor("#itemAddForm [name=itemDesc]");
	KindEditorUtil.init({fun:function(node){
		KindEditorUtil.changeItemParam(node, "itemAddForm");
	}});
});

var userAddPage = {
		submitForm:function(){
			//表单校验
			if(!$('#itemAddForm').form('validate')){
				$.messager.alert('提示','表单还未填写完成!');
				return ;}
				
	$.post("/user/save",$("#itemAddForm").serialize(), function(data){
		if(data.status == 200){
			$.messager.alert('提示','新增用户成功!');
			$("#urserList").datagrid("reload");

			//TT.closeCurrentWindow();
		}else{
			$.messager.alert("提示","新增用户失败!");
		}
	});
},
	clearForm:function (){
		$('#itemAddForm').form('reset');
		itemAddEditor.html('');
	},
	
	fileUpload:function(){
		TT.createWindow({
			url : "/page/Fileupload"
		});
		}
};
</script>
