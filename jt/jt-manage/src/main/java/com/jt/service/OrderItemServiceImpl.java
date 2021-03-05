package com.jt.service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jt.mapper.OrderItemMapper;
import com.jt.pojo.OrderItem;
import com.jt.vo.EasyUITable;

@Service
public class OrderItemServiceImpl implements OrderItemService{
   
	@Autowired
	private OrderItemMapper orderItemMapper;
	
	
	@Override
	public EasyUITable findOrderItemBypage(int page, int rows) {
		Integer total=orderItemMapper.selectCount(null);
		int start=(page-1)*rows;
		List<OrderItem> orderItemList=orderItemMapper.findorderItemPage(start, rows);
		return new EasyUITable(total,orderItemList);
	}
	
	@Override
	public void saveOrderItem(OrderItem orderItem) {
		orderItem.setTotalFee(orderItem.getPrice()*(long)orderItem.getNum())
		.setCreated(new Date())
        .setUpdated(orderItem.getCreated()); 
		orderItemMapper.insert(orderItem);
	}
	
	@Override
	public void deleteOrderItems(Long[] ids) {
		List<Long> idList=Arrays.asList(ids);
		orderItemMapper.deleteBatchIds(idList);	
	}
	
	@Override
	public void updateOrderItem(OrderItem orderItem) {
		orderItem.setTotalFee(orderItem.getPrice()*(long)orderItem.getNum());
		orderItem.setUpdated(new Date());
		orderItemMapper.updateById(orderItem);
	}

}
