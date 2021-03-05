package com.jt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jt.pojo.ItemCat;
import com.jt.service.ItemCatService;
import com.jt.vo.EasyUITree;

@RestController
@RequestMapping("/item/cat")
public class ItemCatController {
	@Autowired
	private ItemCatService itemCatService;
	
	@RequestMapping("/queryItemName")
	public String queryItemName(Long itemCatId) {
		
		ItemCat itemCat=itemCatService.findItemCatNameById(itemCatId);
		return itemCat.getName();
	}
	/**
	 * http://localhost:8091/item/cat/list
	 * 参数：无参
	 * 返回值：List<EasyUITree>
	 *
	 * 业务说明：
	 * 1、用户第一次查询时展现的时全部的一级目录，没有携带任何数据，应给都是制定默认值
	 * 2、当用户查询子集目录时，会携带当前节点id id =1 根据父级查询子集
	 * 
	 * 参数转化的注解：@RequestParam
	 * 作用：接受用户参数，并且实现数据的转换
	 *  参数说明：
	 *  value/name:用户传递的参数名称
	 *  boolean require() default true;是否为必传项
	 *  defaultvalue:设定默认值
	 * 说明：如果用户没有传递参数则parentId默认为0，否则使用用户的参数查询子集信息
	 */
	
	@RequestMapping("/list")
	public List<EasyUITree> findItemCatList(
			@RequestParam(value="id",defaultValue="0")Long parentId){
		return itemCatService.findItemCatList(parentId);
		
	}
}
