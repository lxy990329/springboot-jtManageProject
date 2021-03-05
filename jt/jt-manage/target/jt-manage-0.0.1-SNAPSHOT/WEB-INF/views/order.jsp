<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table class="easyui-datagrid" id="orderList" title="订单列表" 
       data-options="singleSelect:false,fitColumns:true,collapsible:true,pagination:true,url:'/order/query',method:'get',pageSize:20,toolbar:toolbar">
    <thead>
        <tr>
        	<th data-options="field:'ck',checkbox:true"></th>
        	<th data-options="field:'orderId',width:60">订单ID</th>
            <th data-options="field:'payment',width:70">实付金额</th>
            <th data-options="field:'paymentType',width:70">支付类型</th>
             <th data-options="field:'postFee',width:70">邮费</th>
             <th data-options="field:'status',width:70,align:'right'">状态</th>
             <th data-options="field:'consignTime',width:70">付款时间</th>
             <th data-options="field:'endTime',width:70">发货时间</th>
             <th data-options="field:'paymentTime',width:70">完成时间</th>
             <th data-options="field:'closeTime',width:70">关闭时间</th>
             <th data-options="field:'shippingName',width:70">物流名称</th>
             <th data-options="field:'shippingCode',width:70">物流单号</th>
             <th data-options="field:'userId',width:70">用户ID</th>
              <th data-options="field:'buyerMessage',width:70">买家昵称</th>
               <th data-options="field:'buyerNick',width:70">买家留言</th>
              <th data-options="field:'buyerRate',width:70">是否评价</th>   
      <th data-options="field:'created',width:40,align:'right',formatter:KindEditorUtil.formatDateTime">创建日期</th>
            <th data-options="field:'updated',width:40,align:'right',formatter:KindEditorUtil.formatDateTime">更新日期</th>
        </tr>
    </thead>
</table>
<div id="itemEditWindow" class="easyui-window" title="编辑商品" data-options="modal:true,closed:true,iconCls:'icon-save',href:'/page/item-edit'" style="width:80%;height:80%;padding:10px;">
</div>
<script>

    function getSelectionsIds(){
    	var orderList = $("#orderList");
    	/*[item,item,item,item]*/
    	var sels = orderList.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].orderId);
    	}
		console.log(ids);
    	//将数组拼接成串 1,2,3,4,5
    	ids = ids.join(",");
    	return ids;
    }
    
    var toolbar = [{
        text:'新增',
        iconCls:'icon-add',
        handler:function(){
        	//$(".tree-title:contains('新增商品')").parent().click();
        	TT.createWindow({
    			url : "/page/order-add"
    		}); 
        }
    },{
        text:'编辑',
        iconCls:'icon-edit',
        handler:function(){
        	//获取用户选中的数据
        	var ids = getSelectionsIds();
        	if(ids.length == 0){
        		$.messager.alert('提示','必须选择一个商品才能编辑!');
        		return ;
        	}
        	if(ids.indexOf(',') > 0){
        		$.messager.alert('提示','只能选择一个商品!');
        		return ;
        	}
        	
        	
			TT.createWindow({
			url : "/page/order-edit",
			onLoad : function(){
				var data = $("#orderList").datagrid("getSelections")[0];
				console.log("----");
			    console.log(data);
				$("#orderAddForm").form("load",data);
				//$("#orderList").datagrid("reload");
			}
		});    	
        }
    },{
        text:'删除',
        iconCls:'icon-cancel',
        handler:function(){
        	var ids = getSelectionsIds();
        	if(ids.length == 0){
        		$.messager.alert('提示','未选中商品!');
        		return ;
        	}
        	$.messager.confirm('确认','确定删除ID为 '+ids+' 的商品吗？',function(r){
        	    if (r){
        	    	var params = {"ids":ids};
					console.log("----");
			        console.log(ids);
                	$.post("/order/delete",params, function(data){
            			if(data.status == 200){
            				$.messager.alert('提示','删除商品成功!',undefined,function(){
            					$("#orderList").datagrid("reload");
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