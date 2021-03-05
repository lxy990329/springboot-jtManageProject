<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="/js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<div style="padding:10px 10px 10px 10px">
	<form id="shippingAddForm" class="itemForm" method="post">
		
	    <table cellpadding="5">
	        <tr>
	            <td>订单ID:</td>
	            <td><input class="easyui-textbox" type="text" name="id" data-options="required:true" style="width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>*收货人姓名:</td>
	            <td><input class="easyui-textbox" type="text" name="receiverName" data-options="required:true" style="width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>固定电话:</td>
	            <td><input class="easyui-textbox" type="text" name="receiverPhone" style="width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>*移动电话:</td>
	            <td><input class="easyui-textbox" type="text" name="receiverMobile" data-options="required:true" style="width: 280px;"></input></td>
	        </tr>
	         <tr>
	            <td>*省份:</td>
	            <td><input class="easyui-textbox" type="text" name="receiverState" data-options="required:true" style="width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>*城市:</td>
	            <td><input class="easyui-textbox" type="text" name="receiverCity" data-options="required:true" style="width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>*县/区:</td>
	            <td><input class="easyui-textbox" type="text" name="receiverDistrict" data-options="required:true" style="width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>*具体地址:</td>
	            <td><input class="easyui-textbox" type="text" name="receiverAddress" data-options="required:true" style="width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>邮件编码:</td>
	            <td><input class="easyui-textbox" type="text" name="receiverZip" style="width: 280px;"></input></td>
	        </tr>
	    </table>
	</form>
	<div style="padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="shippingAddPage.submitForm()">提交</a>
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="shippingAddPage.clearForm()">重置</a>
	</div>
</div>
<script type="text/javascript">
	var shippingAddEditor ;
	$(function(){
		shippingAddEditor = TT.createEditor("#shippingAddForm [name=shipping]");
		TT.initOnePicUpload();
		$("#shippingAddForm [name=orderId]").val($("#contentCategoryTree").tree("getSelected").id);
	});
	
	var shippingAddPage  = {
			submitForm : function (){
				if(!$('#shippingAddForm').form('validate')){
					$.messager.alert('提示','订单还未填写完成!');
					return ;
				}
				//contentAddEditor.sync();
				
				$.post("/order-shipping/save",$("#shippingAddForm").serialize(), function(data){
					if(data.status == 200){
						$.messager.alert('提示','新增订单成功!');
    					$("#ordershippingList").datagrid("reload");
    					TT.closeCurrentWindow();
					}
				});
			},
			clearForm : function(){
				$('#shippingAddForm').form('reset');
				shippingAddEditor.html('');
			}
	};
</script>
