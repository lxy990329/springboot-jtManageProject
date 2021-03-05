<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="/js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<div style="padding:10px 10px 10px 10px">
	<form id="orderAddForm" class="itemForm" method="post">
		<!-- <input type="hidden" name="categoryId"/> -->
	    <table cellpadding="5" id="orderList">
	        <tr>
	            <td>订单ID:</td>
	            <td><input id="orderId" class="easyui-textbox" type="text" name="orderId" readonly="readonly" data-options="required:true" style="width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>实付金额:</td>
	            <td><input class="easyui-textbox" type="text" name="payment" data-options="required:true" style="width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>支付类型:</td>
	            <td><input class="easyui-textbox" type="text" name="paymentType" data-options="required:true" style="width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>邮费:</td>
	            <td><input class="easyui-textbox" type="text" name="status" data-options="required:true" style="width: 280px;"></input></td>
	        </tr>
	        <!-- <tr>
	            <td>支付时间:</td>
	            <td><input class="easyui-textbox" type="text" name="paymentTime" data-options="required:true" style="width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>发货时间:</td>
	            <td><input class="easyui-textbox" type="text" name="consignTime" data-options="required:true" style="width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>交易完成时间:</td>
	            <td><input class="easyui-textbox" type="text" name="endTime" data-options="required:true" style="width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>交易关闭时间:</td>
	            <td><input class="easyui-textbox" type="text" name="closeTime" data-options="required:true" style="width: 280px;"></input></td>
	        </tr> -->
	        <tr>
	            <td>物流名称:</td>
	            <td><input class="easyui-textbox" type="text" name="shippingName" data-options="required:true" style="width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>物流单号:</td>
	            <td><input class="easyui-textbox" type="text" name="shippingCode" data-options="required:true" style="width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>用户Id:</td>
	            <td><input class="easyui-textbox" type="text" name="userId" data-options="required:true" style="width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>买家留言:</td>
	            <td><input class="easyui-textbox" type="text" name="buyerMessage" data-options="required:true" style="width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>买家昵称:</td>
	            <td><input class="easyui-textbox" type="text" name="buyerNick" data-options="required:true" style="width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>买家评价状态:</td>
	            <td><input class="easyui-textbox" type="text" name="buyerRate" data-options="required:true" style="width: 280px;"></input></td>
	        </tr>
	        <!-- <tr>
	            <td>内容描述:</td>
	            <td><input class="easyui-textbox" name="titleDesc" data-options="multiline:true,validType:'length[0,150]'" style="height:60px;width: 280px;"></input>
	            </td>
	        </tr> -->
	         <!-- <tr>
	            <td>URL:</td>
	            <td><input class="easyui-textbox" type="text" name="url" style="width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>图片:</td>
	            <td>
	                <input type="hidden" name="pic" />
	                <a href="javascript:void(0)" class="easyui-linkbutton onePicUpload">图片上传</a>
	            </td>
	        </tr>
	        <tr>
	            <td>图片2:</td>
	            <td>
	            	<input type="hidden" name="pic2" />
	            	<a href="javascript:void(0)" class="easyui-linkbutton onePicUpload">图片上传</a>
	            </td>
	        </tr>
	        <tr>
	            <td>内容:</td>
	            <td>
	                <textarea style="width:800px;height:300px;visibility:hidden;" name="content"></textarea>
	            </td>
	        </tr> -->
	    </table>
	</form>
	<div style="padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="orderAddPage.submitForm()">提交</a>
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="orderAddPage.clearForm()">重置</a>
	</div>
</div>
<script type="text/javascript">
   // $('#orderId').textbox('textbox').attr('readonly',true);
	var orderAddEditor;
	//  $(function(){
	// 	orderAddEditor = TT.createEditor("#orderAddForm [name=order]");
	// 	TT.initOnePicUpload();
	// // 	$("#orderAddForm [name=orderId]").val($("#orderCategoryTree").tree("getSelected").orderId);
	// });
	
	var orderAddPage  = {
			submitForm : function (){
				if(!$('#orderAddForm').form('validate')){
					$.messager.alert('提示','表单还未填写完成!');
					return ;
				}
			console.log($("#orderAddForm").serialize());
			$.post("/order/update",$("#orderAddForm").serialize(), function(data){
				console.log($("#orderAddForm").serialize());
				if(data.status == 200){
					$.messager.alert('提示','编辑内容成功!',undefined,function(){
						$("#orderList").datagrid("reload");
					});
				}
				});
			},
			clearForm : function(){
				$('#orderAddForm').form('reset');
				contentAddEditor.html('');
			}
	};
</script>
