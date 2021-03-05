package com.jt.service;

import com.jt.pojo.OrderItem;
import com.jt.vo.EasyUITable;

public interface OrderItemService {

	EasyUITable findOrderItemBypage(int page, int rows);
	
	void saveOrderItem(OrderItem orderItem) ;
	
	void deleteOrderItems(Long[] ids);
	
	void updateOrderItem(OrderItem orderItem);

}
