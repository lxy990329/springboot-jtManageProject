package com.jt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jt.pojo.Item;
import com.jt.pojo.ItemDesc;
import com.jt.service.ItemService;
import com.jt.vo.EasyUITable;
import com.jt.vo.SysResult;

@RestController
@RequestMapping("/item")
public class ItemController {
	
	@Autowired
	
	private ItemService itemService;
	@RequestMapping("/query")
	public EasyUITable findItemBypage(int page,int rows) {
		return itemService.findItemByPage(page, rows);
	}
	/**
	 * 商品新增
	 * http://localhost:8091/item/save
	 * 参数：form表单提交
	 * 返回值：form对象
	 */
	@RequestMapping("/save")
	public SysResult saveItem(Item item,ItemDesc itemdesc) {
		itemService.saveItem(item,itemdesc);
		return SysResult.success();
	}
	/**
	 * 商品编辑功能
	 * http://localhost:8091/item/updata
	 * 参数：form表单提交
	 * 返回值：SysResult
	 */
	@RequestMapping("/update")
	public SysResult updateItem(Item item,ItemDesc itemDesc) {
		itemService.updateItem(item,itemDesc);
		return SysResult.success();
	}
	/**
	 * 商品删除功能
	 * url:http://localhost:8091/item/delete
	 * 参数：主键若有多个id中间使用逗号隔开
	 * 返回值：SysResult
	 * @param item
	 * @return
	 */
	@RequestMapping("/delete")
	public SysResult deleteItem(long[] ids) {
		//System.out.println(ids);
		itemService.deleteItem(ids);
		return SysResult.success();
	}
	/**
	 * 商品上架和下架
	 * url:http://localhost:8091/item/updateStatus/2
	 * 参数：主键若有多个id中间使用逗号隔开
	 * 返回值：ids
	 * @param item
	 * @return
	 */
	@RequestMapping("/updateStatus/{status}")
	public SysResult updateStatus(@PathVariable int status,Long...ids) {//先返回可变参数
		itemService.updateStatus(status,ids);
		return SysResult.success();
	}
	/**商品描述回显
	 * url:http://localhost:8091/item/query/item/desc/
	 * 参数：itemId
	 * 返回值：SysResult
	 * @param item
	 * @return
	 */
	@RequestMapping("/query/item/desc/{itemId}")
	public SysResult findItemDescById(@PathVariable Long itemId) {
		ItemDesc itemDesc=itemService.findItemDescById(itemId);
		return SysResult.success(itemDesc);
	}
}
