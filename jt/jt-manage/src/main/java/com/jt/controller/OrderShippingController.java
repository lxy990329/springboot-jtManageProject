package com.jt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jt.pojo.OrderShipping;
import com.jt.service.OrderShippingService;
import com.jt.vo.EasyUITable;
import com.jt.vo.SysResult;

@RestController
@RequestMapping("/order-shipping")//order-shipping/query
public class OrderShippingController {
	
/**
 *url:http://localhost:8091/order-shipping/query?page=1&rows=20
 */
	@Autowired
	OrderShippingService orderShippingService;
	@RequestMapping("/query")
	public EasyUITable findOderShippingByPage(int page,int rows) {
		return orderShippingService.findOderShippingByPage(page,rows);
	}
	/**
	 * Request URL: http://localhost:8091/order-shipping/save
	 * @param orderShipping
	 * @return
	 */
	@RequestMapping("/save")
	public SysResult saveOrderShipping(OrderShipping orderShipping) {
		orderShippingService.saveOrderShipping(orderShipping);
		 return SysResult.success();	
	}
	/**
	 * /order-shipping/edit
	 * @param orderShipping
	 * @return
	 */
	@RequestMapping("/edit")
	public SysResult updateOrderShipping(OrderShipping orderShipping){
		orderShippingService.updateOrderShipping(orderShipping);
		return SysResult.success();
	}
	/**
	 * Request URL: http://localhost:8091/order-shipping/delete
	 * @param ids
	 * @return
	 */
	@RequestMapping("/delete")
	public SysResult deleteOrderShipping(Long[] ids) {
		System.out.print(ids);
		orderShippingService.deleteOrderShipping(ids);
		return SysResult.success();	
	}
}
