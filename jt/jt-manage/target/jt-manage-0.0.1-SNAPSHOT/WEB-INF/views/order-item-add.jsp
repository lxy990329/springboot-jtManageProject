<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="/js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<div style="padding:10px 10px 10px 10px">
	<form id="itemAddOrderForm" class="itemForm" method="post">
	    <table cellpadding="5" id="itemOrderList">
	        
			<tr>
	            <td>商品id:</td>
	            <td><input class="easyui-textbox" type="text" name="itemId" data-options="required:true" style="width: 280px;"></input></td>
	        </tr>
			<tr>
	            <td>订单id:</td>
	            <td><input class="easyui-textbox" type="text" name="orderId" data-options="required:true" style="width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>商品数量:</td>
	            <td><input class="easyui-textbox" type="text" name="num" data-options="required:true" style="width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>商品标题:</td>
	            <td><input class="easyui-textbox" type="text" name="title" data-options="required:true" style="width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>商品单价:</td>
	            <td><input class="easyui-textbox" type="text" name="price" data-options="required:true" style="width: 280px;"></input></td>
	        </tr>
			<tr>
	            <td>图片:</td>
	            <td>
	                <input type="hidden" name="picPath" />
	                <a href="javascript:void(0)" class="easyui-linkbutton onePicUpload">图片上传</a>
	            </td>
	        </tr>
	        
	    </table>
	</form>
	<div style="padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="orderItemAddPage.submitForm()">提交</a>
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="orderItemAddPage.clearForm()">重置</a>
	</div>
</div>
<script type="text/javascript">
	var orderItemAddEditer;
		$(function(){
		//orderItemAddEditer = TT.createEditor("#itemAddOrderForm [name=picPath]");
		TT.initOnePicUpload();
		//$("#itemAddOrderForm [name=orderId]").val($("#orderCategoryTree").tree("getSelected").orderId);
	});
	
	var orderItemAddPage  = {
			submitForm : function (){
				if(!$('#itemAddOrderForm').form('validate')){
					$.messager.alert('提示','表单还未填写完成!');
					return ;
				}
			console.log($("#itemAddOrderForm").serialize());
			$.post("/item/order/save",$("#itemAddOrderForm").serialize(), function(data){
				console.log($("#itemAddOrderForm").serialize());
				if(data.status == 200){
					$.messager.alert('提示','添加商品成功!',undefined,function(){
						//$.messager.alert('提示','出现我说明进入刷新界面函数了!');
						$("#orderitemList").datagrid("reload");
    					//$.messager.alert('提示','出现我说明函数执行完了但是没成功!');
    				});
					//closeCurrentWindow();
				}
				});
				
			},
			clearForm : function(){
				$('#itemAddOrderForm').form('reset');
				contentAddEditor.html('');
			}
	};
</script>
