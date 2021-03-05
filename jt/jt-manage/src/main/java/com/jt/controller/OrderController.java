package com.jt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jt.pojo.Order;
import com.jt.service.OrderService;
import com.jt.vo.EasyUITable;
import com.jt.vo.SysResult;

@RestController
@RequestMapping("/order")
public class OrderController {
///order/query
	/**
	 * http://localhost:8091/order/query?page=1&rows=20
	 *显示
	 */
	@Autowired
	OrderService orderService;
	@RequestMapping("/query")
	public EasyUITable findOrderByPage(int page,int rows) {
		return orderService.findOrderByPage(page,rows);
		
	}
	
	@RequestMapping("/save")
	public SysResult saveItem(Order order) {
		System.out.println(order);
		orderService.saveItem(order);
		return SysResult.success();
		
	}
	
	@RequestMapping("/update")
	public SysResult update(Order order) {
		System.out.println(order);
		orderService.updateItem(order);
		return SysResult.success();
	}
	
	@RequestMapping("/delete")
	public SysResult deleteItem(Long[] ids) {
		System.out.println(ids);
		orderService.deleteItem(ids);
		return SysResult.success();
	}
}
