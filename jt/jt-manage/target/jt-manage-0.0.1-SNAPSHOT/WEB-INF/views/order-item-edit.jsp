<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="/js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<div style="padding:10px 10px 10px 10px">
	<form id="itemOrderEditForm" class="itemForm" method="post">
	    <table cellpadding="5">
	        <tr>
	            <td>商品id:</td>
	            <td><input readonly="readonly" class="easyui-textbox" type="text" name="itemId" data-options="required:true" style="width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>订单id:</td>
	            <td><input class="easyui-textbox" type="text" name="orderId" style="width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>商品数量:</td>
	            <td><input class="easyui-textbox" type="text" name="num" data-options="multiline:true,validType:'length[0,150]'" style="height:60px;width: 280px;"></input>
	            </td>
	        </tr>
	         <tr>
	            <td>商品标题:</td>
	            <td><input class="easyui-textbox" type="text" name="title" style="width: 280px;"></input></td>
	        </tr>
			<tr>
	            <td>商品单价:</td>
	            <td><input class="easyui-textbox" type="text" name="price" style="width: 280px;"></input></td>
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
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="itemOrderEditPage.submitForm()">提交</a>
	   <!--   <a href="javascript:void(0)" class="easyui-linkbutton" onclick="itemOrderEditPage.clearForm()">重置</a>-->
	</div>
</div>
<script type="text/javascript">
var itemOrderEditEditor ;
$(function(){
	itemOrderEditEditor = TT.createEditor("#itemOrderEditForm [name=text]");
	TT.initOnePicUpload();
});

var itemOrderEditPage = {
		submitForm : function(){
			
			if(!$('#itemOrderEditForm').form('validate')){
				$.messager.alert('提示','表单还未填写完成!');
				return ;
			}
			
			//itemOrderEditEditor.sync();
			
			$.post("/item/order/edit",$("#itemOrderEditForm").serialize(), function(data){
				//$.messager.alert('提示','出现说明已经进入提交函数!');
				if(data.status == 200){
					//$.messager.alert('提示','出现说明返回成功');
					
					$.messager.alert('提示','修改内容成功!');
					$("#orderitemList").datagrid("reload");
					
				}
			});
		}
};

</script>