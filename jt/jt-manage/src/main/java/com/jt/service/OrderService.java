package com.jt.service;

import com.jt.pojo.Order;
import com.jt.vo.EasyUITable;
import com.jt.vo.SysResult;

public interface OrderService {

	EasyUITable findOrderByPage(int page, int rows);

	void saveItem(Order order);

	void updateItem(Order order);

	void deleteItem(Long[] ids);

}
