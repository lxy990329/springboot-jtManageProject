<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table class="easyui-datagrid" id="orderitemList" title="订单商品列表" 
       data-options="singleSelect:false,fitColumns:true,collapsible:true,pagination:true,url:'/order-item/query',method:'get',pageSize:20,toolbar:toolbar">
    <thead>
        <tr>
        	<th data-options="field:'ck',checkbox:true"></th>
        	<th data-options="field:'itemId',width:30">商品ID</th>
        	<th data-options="field:'orderId',width:30">订单ID</th>
            <th data-options="field:'num',width:50">商品购买数量</th>
            <!--  <th data-options="field:'total',width:50">商品标题</th>--> 
             <th data-options="field:'price',width:50">商品单价</th>
             <th data-options="field:'totalFee',width:50">总金额</th>
             <th data-options="field:'picPath',width:50,align:'center',formatter:KindEditorUtil.formatUrl">图片地址</th>
            <th data-options="field:'created',width:110,align:'right',formatter:KindEditorUtil.formatDateTime">创建日期</th>
            <th data-options="field:'updated',width:110,align:'right',formatter:KindEditorUtil.formatDateTime">更新日期</th>
        </tr>
    </thead>
</table>
<div id="orderItemEditWindow" class="easyui-window" title="编辑商品" data-options="modal:true,closed:true,iconCls:'icon-save',href:'/page/order-item-edit'" style="width:80%;height:80%;padding:10px;">
</div>
<script>

function getSelectionsIds(){
	var orderitemList = $("#orderitemList");
	/*[item,item,item,item]*/
	//.datagrid("getSelections");//easyUI提供的 筛选用户选中的数据
	var sels = orderitemList.datagrid("getSelections");
	console.log(sels);
	var ids = [];
	for(var i in sels){
		ids.push(sels[i].itemId);//为数组添加id值
	}
	
	//将数组拼接成串 1,2,3,4,5
	ids = ids.join(",");//将数组转化为字符串
	return ids;
}
    
    var toolbar = [{
        text:'新增',
        iconCls:'icon-add',
        handler:function(){
        	TT.createWindow({
    			url : "/page/order-item-add"
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
			url : "/page/order-item-edit",
			onLoad : function(){
				var data = $("#orderitemList").datagrid("getSelections")[0];
				$("#itemOrderEditForm").form("load",data);

				if(data.pic){
					$("#itemOrderEditForm [name=picPath]").after("<a href='"+data.picPath+"' target='_blank'><img src='"+data.picPath+"' width='80' height='50'/></a>");	
				}
				//TT.closeCurrentWindow();
				
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
					//$.messager.alert('提示','执行到这里!');
        	    	var params = {"ids":ids};
                	$.post("/item/order/delete",params, function(data){
            			if(data.status == 200){
            				$.messager.alert('提示','删除商品成功!',undefined,function(){
            					$("#orderitemList").datagrid("reload");
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