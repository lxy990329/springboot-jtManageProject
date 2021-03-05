package com.jt.service;

import com.jt.pojo.OrderShipping;
import com.jt.vo.EasyUITable;

public interface OrderShippingService {

	EasyUITable findOderShippingByPage(int page, int rows);

	void saveOrderShipping(OrderShipping orderShipping);

	void updateOrderShipping(OrderShipping orderShipping);

	void deleteOrderShipping(Long[] ids);

}
