<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table class="easyui-datagrid" id="userList" title="单据列表" 
       data-options="singleSelect:false,fitColumns:true,collapsible:true,pagination:true,url:'/user/query',method:'get',pageSize:20,toolbar:toolbar">
    <thead>
        <tr>
        	<th data-options="field:'ck',checkbox:true"></th>
            <th data-options="field:'id',width:10,align:'center'">userID</th>
             <th data-options="field:'username',width:10,align:'center'">用户账号</th>
             <th data-options="field:'password',width:25,align:'center'">密码</th>
             <th data-options="field:'phone',width:10,align:'center'">手机电话</th>
             <th data-options="field:'email',width:10,align:'center'">邮件</th>
            <th data-options="field:'created',width:20,align:'center',formatter:KindEditorUtil.formatDateTime">创建日期</th>
            <th data-options="field:'updated',width:20,align:'center',formatter:KindEditorUtil.formatDateTime">更新日期</th>
        </tr>
    </thead>

</table>
<div id="itemUserEditWindow" class="easyui-window" title="编辑用户 " data-options="modal:true,closed:true,iconCls:'icon-save',href:'/page/user-edit'" style="width:80%;height:80%;padding:10px;">
</div>

<script>

    function getSelectionsIds(){
    	var userList = $("#userList");
    	/*[item,item,item,item]*/
    	var sels = userList.datagrid("getSelections");
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
    			url : "/page/user-add"
    		}); }
    },{
        text:'编辑',
        iconCls:'icon-edit',
        handler:function(){
        	//获取用户选中的数据
        	var ids = getSelectionsIds();
        	if(ids.length == 0){
        		$.messager.alert('提示','必须选择一个用户才能编辑!');
        		return ;
        	}
        	if(ids.indexOf(',') > 0){
        		$.messager.alert('提示','只能选择一个用户!');
        		return ;
        	}
        	
        	$("#itemUserEditWindow").window({
        		onLoad :function(){
        			//回显数据
        			var data = $("#userList").datagrid("getSelections")[0];
        			data.priceView = KindEditorUtil.formatPrice(data.price);
        			$("#itemeEditForm").form("load",data);
        			
        			//加载商品规格
        			$.getJSON('/user/param/item/query/'+data.id,function(_data){
        				if(_data && _data.status == 200 && _data.data && _data.data.paramData){
        					$("#itemeEditForm .params").show();
        					$("#itemeEditForm [name=itemParams]").val(_data.data.paramData);
        					$("#itemeEditForm [name=itemParamId]").val(_data.data.id);
        					
        					//回显商品规格
        					 var paramData = JSON.parse(_data.data.paramData);
        					
        					 var html = "<ul>";
        					 for(var i in paramData){
        						 var pd = paramData[i];
        						 html+="<li><table>";
        						 html+="<tr><td colspan=\"2\" class=\"group\">"+pd.group+"</td></tr>";
        						 
        						 for(var j in pd.params){
        							 var ps = pd.params[j];
        							 html+="<tr><td class=\"param\"><span>"+ps.k+"</span>: </td><td><input autocomplete=\"off\" type=\"text\" value='"+ps.v+"'/></td></tr>";
        						 }
        						 
        						 html+="</li></table>";
        					 }
        					 html+= "</ul>";
        					 $("#itemeEditForm .params td").eq(1).html(html);
        				}
        			});
        		var itemCatId=data.cid;
        			$.get("/user/cat/queryItemName",{"itemCatId":itemCatId},function(name){
            			alert(name);
                     $("#itemeEditForm [name=cid]").siblings("span").text(name);
            			});
        			KindEditorUtil.init({
        				"pics" : data.image,
        				"cid" : data.cid,
        				fun:function(node){
        					KindEditorUtil.changeItemParam(node, "itemeEditForm");
        				} 
        			});
        		}
			//$("#urserList").datagrid("reload");
        	}).window("open");
        }
    },{
        text:'删除',
        iconCls:'icon-cancel',
        handler:function(){
        	var ids = TT.getSelectionsIds("#userList");
        	if(ids.length == 0){
        		$.messager.alert('提示','未选中用户!');
        		return ;
        	}
        	$.messager.confirm('确认','确定删除ID为 '+ids+' 的用户吗？',function(r){
        	    if (r){
        	    	var params = {"ids":ids};
                	$.post("/user/delete",params, function(data){
            			if(data.status == 200){
            				$.messager.alert('提示','删除用户成功!',undefined,function(){
            					$("#userList").datagrid("reload");
            				});
            			}
            		});
        	    }
        	});
        }
    }];
</script>
