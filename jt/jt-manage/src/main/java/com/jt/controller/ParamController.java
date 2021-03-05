package com.jt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jt.pojo.ItemParam;
import com.jt.service.ItemParamService;
import com.jt.vo.EasyUITable;
import com.jt.vo.SysResult;

@RestController
public class ParamController {
	@Autowired
	private ItemParamService itemParamService;
		/**
		 * 规格信息参数显示
		 * url:/item/param/list
		 * 参数：pages=1&rows=20
		 * 返回值：EasyUITable数据
		 */
		@RequestMapping("/item/param/list")
		public EasyUITable findItemParamByPage(int page,int rows) {         //在业务层,实现分页处理
	        
			return itemParamService.findItemParamByPage(page,rows);
	    }
		 
		/**
		 * 实现新增
		 * @param itemParam
		 * @return
		 */
		@RequestMapping("/item/param/save/{itemCatId}")
		public SysResult saveItemParam(ItemParam itemParam,@PathVariable Long itemCatId) {

				itemParamService.saveItemParam(itemParam,itemCatId);
				return SysResult.success();

		}
		
		/**
		 * 实现删除
		 */
		@RequestMapping("/item/param/delete")
		public SysResult deleteItemParam(Long[] ids) {
			itemParamService.deleteItemParams(ids);
			return SysResult.success();
		}
		
		/**
		 * 商品更新
		 */
		@RequestMapping("/item/param/update")
		public SysResult updateItemParam(ItemParam itemParam) {
			itemParamService.updateItemParam(itemParam);
	        return SysResult.success();
	 
		}
		
		
}
