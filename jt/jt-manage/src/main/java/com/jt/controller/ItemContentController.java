 package com.jt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jt.pojo.Item;
import com.jt.pojo.ItemContent;
import com.jt.pojo.ItemContentCategory;
import com.jt.pojo.ItemDesc;
import com.jt.service.ItemContentService;
import com.jt.vo.EasyUITable;
import com.jt.vo.EasyUITree;
import com.jt.vo.Result;
import com.jt.vo.SysResult;


@RestController
@RequestMapping("/content")
public class ItemContentController {
	@Autowired
	private ItemContentService itemContentService;
	
	@RequestMapping("/query/list")
	public EasyUITable findItemBypage(Long categoryId,int page,int rows) {
		return itemContentService.findItemByPage(categoryId,page,rows);
	}
	
	@RequestMapping("/category/list")
	public List<EasyUITree> findItemCatList(
			@RequestParam(value="id",defaultValue="0")Long parentId){
		return itemContentService.findItemCatList(parentId);
		
	}
	
	@RequestMapping("/category/create")
	public Result saveItem(ItemContentCategory itemContentCategory) {
		return itemContentService.saveItem(itemContentCategory);
	}
	
	@RequestMapping("/category/update")
	public Result updateItem(ItemContentCategory itemContentCategory) {
		return itemContentService.updateItem(itemContentCategory);
	}
	
	@RequestMapping("/category/delete")
	public Result deleteItem(Long id) {
		return itemContentService.deleteItem(id);
	}
	
	@RequestMapping("/save")
	public SysResult saveContent(ItemContent content) {
		itemContentService.saveContent(content);
		 return SysResult.success();	
	}
	@RequestMapping("/edit")
	public SysResult updateContent(ItemContent content){
		itemContentService.updateContent(content);
		return SysResult.success();
	}
	
	@RequestMapping("/delete")
	public SysResult deleteContent(Long[] ids) {
		itemContentService.deleteContent(ids);
		return SysResult.success();	}

}
