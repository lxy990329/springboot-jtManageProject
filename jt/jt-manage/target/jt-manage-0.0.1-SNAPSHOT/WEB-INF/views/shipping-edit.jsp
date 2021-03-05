<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="/js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<div style="padding:10px 10px 10px 10px">
	<form id="shippingEditForm" class="itemForm" method="post">
		<!--  <input type="hidden" name="id"/>-->
	    <table cellpadding="5">
	    	<tr>
	            <td>订单ID:</td>
	            <td><input class="easyui-textbox" type="text" name="id" readonly="readonly" style="width: 280px;"></input></td>
	        </tr>
	       <tr>
	            <td>收货人姓名:</td>
	            <td><input class="easyui-textbox" type="text" name="receiverName"  style="width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>固定电话:</td>
	            <td><input class="easyui-textbox" type="text" name="receiverPhone" style="width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>移动电话:</td>
	            <td><input class="easyui-textbox" type="text" name="receiverMobile"  style="width: 280px;"></input></td>
	        </tr>
	         <tr>
	            <td>省份:</td>
	            <td><input class="easyui-textbox" type="text" name="receiverState"  style="width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>城市:</td>
	            <td><input class="easyui-textbox" type="text" name="receiverCity"  style="width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>县/区:</td>
	            <td><input class="easyui-textbox" type="text" name="receiverDistrict"  style="width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>具体地址:</td>
	            <td><input class="easyui-textbox" type="text" name="receiverAddress"  style="width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>邮件编码:</td>
	            <td><input class="easyui-textbox" type="text" name="receiverZip" style="width: 280px;"></input></td>
	        </tr>
	    </table>
	</form>
	<div style="padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="contentEditPage.submitForm()">提交</a>
	    <!--  <a href="javascript:void(0)" class="easyui-linkbutton" onclick="contentEditPage.clearForm()">重置</a>-->
	</div>
</div>
<script type="text/javascript">
var ordershippingEditEditor ;
/* $(function(){
	ordershippingEditor = TT.createEditor("#shippingEditForm [name=id]");
	TT.initOnePicUpload();
}); */

var contentEditPage = {
		submitForm : function(){
			if(!$('#shippingEditForm').form('validate')){
				$.messager.alert('提示','订单还未填写完成!');
				return ;
			}
			//contentEditEditor.sync();
			
			$.post("/order-shipping/edit",$("#shippingEditForm").serialize(), function(data){
				if(data.status == 200){
					$.messager.alert('提示','修改内容成功!');
					$("#ordershippingList").datagrid("reload");
					TT.closeCurrentWindow();
				}
			});
		},
		clearForm : function(){
			$('#shippingEditForm').form('reset');
			ordershippingEditEditor.html('');
		}
};

</script>