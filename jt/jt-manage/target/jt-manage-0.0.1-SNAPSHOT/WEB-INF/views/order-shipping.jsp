<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table class="easyui-datagrid" id="ordershippingList" title="单据列表" 
       data-options="singleSelect:false,fitColumns:true,collapsible:true,pagination:true,url:'/order-shipping/query',method:'get',pageSize:20,toolbar:toolbar">
    <thead>
        <tr>
        	<th data-options="field:'ck',checkbox:true"></th>
        	<th data-options="field:'id',width:25">订单ID</th>
            <th data-options="field:'receiverName',width:20">收货人姓名</th>
             <th data-options="field:'receiverPhone',width:20">固定电话 </th>
             <th data-options="field:'receiverMobile',width:20">移动电话</th>
             <th data-options="field:'receiverState',width:10">省份</th>
             <th data-options="field:'receiverCity',width:10">城市</th>
              <th data-options="field:'receiverDistrict',width:10">区/县</th>
              <th data-options="field:'receiverAddress',width:50">具体地址</th>
               <th data-options="field:'receiverZip',width:15">邮政编码</th>
            <th data-options="field:'created',width:40,align:'right',formatter:KindEditorUtil.formatDateTime">创建日期</th>
            <th data-options="field:'updated',width:40,align:'right',formatter:KindEditorUtil.formatDateTime">更新日期</th>
        </tr>
    </thead>
</table>
<div id="shippingEditWindow" class="easyui-window" title="编辑商品" data-options="modal:true,closed:true,iconCls:'icon-save',href:'/page/shipping-edit'" style="width:80%;height:80%;padding:10px;">
</div>
<script>

    function getSelectionsIds(){
    	var ordershippingList = $("#ordershippingList");
    	/*[item,item,item,item]*/
    	var sels = ordershippingList.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].id);
    	}
    	//将数组拼接成串 1,2,3,4,5
    	ids = ids.join(",");
    	return ids;
    }
    
    	var toolbar = [{
        text:'新增',
        iconCls:'icon-add',
        handler:function(){
        	TT.createWindow({
    			url : "/page/shipping-add"
    		});
        	//$(".tree-title:contains('新增商品')").parent().click();
        }
    },{
		text:'编辑',
        iconCls:'icon-edit',
        handler:function(){
        	//获取用户选中的数据
        	var ids = getSelectionsIds();
        	if(ids.length == 0){
        		$.messager.alert('提示','必须选择一笔订单才能编辑!');
        		return ;
        	}
        	if(ids.indexOf(',') > 0){
        		$.messager.alert('提示','只能选择一笔订单!');
        		return ;
        	}
        	/* TT.createWindow({
    			url : "/page/shipping-edit",
    			onLoad : function(){
    				var data = $("#ordershippingList").datagrid("getSelections")[0];
    				console.log("----");
    			    console.log(data);
    				$("#shippingEditForm").form("load",data);
    				//$("#orderList").datagrid("reload");
    			}
			)}; */
        	$("#shippingEditWindow").window({
        		onLoad :function(){
        			//回显数据
        			var data = $("#ordershippingList").datagrid("getSelections")[0];
        			//data.priceView = KindEditorUtil.formatPrice(data.price);
        			$("#shippingEditForm").form("load",data);
        			
        		}
        	}).window("open"); 
        	
        }
    },{
        text:'删除',
        iconCls:'icon-cancel',
        handler:function(){
        	var ids = getSelectionsIds();
        	if(ids.length == 0){
        		$.messager.alert('提示','未选中订单!');
        		return ;
        	}
        	$.messager.confirm('确认','确定删除订单ID为 '+ids+' 的订单吗？',function(r){
        	    if (r){
        	    	var params = {"ids":ids};
                	$.post("/order-shipping/delete",params, function(data){
            			if(data.status == 200){
            				$.messager.alert('提示','删除订单成功!',undefined,function(){
            					$("#ordershippingList").datagrid("reload");
            				});
            			}else{
            				$.messager.alert("提示",data.msg);
            			}
            		});
        	    }
        	});
        }
    },'-',];
</script>