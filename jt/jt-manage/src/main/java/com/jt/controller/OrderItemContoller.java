package com.jt.controller;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jt.pojo.OrderItem;
import com.jt.service.OrderItemService;
//import com.jt.service.UserService;
import com.jt.vo.EasyUITable;
import com.jt.vo.SysResult;

@RestController
public class OrderItemContoller {
	/**
	 * http://localhost:8091/page/order-item/query?page=1&rows=20
	 */
	@Autowired
	private OrderItemService orderItemService;
	
	
	@RequestMapping("/order-item/query")
	public EasyUITable findOrderItemBypage(int page,int rows) {
		System.out.print("访问了Controller");
		 //return SysResult.success();
		return orderItemService.findOrderItemBypage(page,rows);
	}
	
	@RequestMapping("/item/order/save")
	public SysResult saveOrderItem(OrderItem orderItem) {
		 orderItemService.saveOrderItem(orderItem);
         return SysResult.success();

	}
	
	@RequestMapping("/item/order/delete")
	public SysResult deleteOrderItems(Long[] ids) {
		orderItemService.deleteOrderItems(ids);
		return SysResult.success();
	}
	
	@RequestMapping("item/order/edit")
	public SysResult updateOrderItem(OrderItem orderItem) {
		orderItemService.updateOrderItem(orderItem);
        return SysResult.success();
 
	}
	
}
