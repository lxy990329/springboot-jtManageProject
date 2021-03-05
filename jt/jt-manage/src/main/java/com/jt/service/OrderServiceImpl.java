package com.jt.service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jt.mapper.OrderMapper;
import com.jt.pojo.Order;
import com.jt.vo.EasyUITable;
import com.jt.vo.SysResult;
@Service
public class OrderServiceImpl implements OrderService{

	 @Autowired
	 private OrderMapper orderMapper;
	@Override
	public EasyUITable findOrderByPage(int page, int rows) {
		IPage<Order> iPage=new Page<>(page,rows);
		QueryWrapper<Order> queryWrapper=new QueryWrapper<>();
		queryWrapper.orderByDesc("updated");
		iPage=orderMapper.selectPage(iPage,queryWrapper);
		int total=(int) iPage.getTotal();
		List<Order> orderList=iPage.getRecords();
		return new EasyUITable(total,orderList);
	}
	@Override
	public void saveItem(Order order) {
		// TODO Auto-generated method stub
		order.setPaymentTime(new Date()).setConsignTime(new Date()).setEndTime(new Date()).setCloseTime(new Date()).setCreated(new Date()).setUpdated(order.getCreated());
		orderMapper.insert(order);
	}
	@Override
	public void updateItem(Order order) {
		// TODO Auto-generated method stub
		order.setPaymentTime(new Date()).setConsignTime(new Date()).setEndTime(new Date()).setCloseTime(new Date()).setCreated(new Date()).setUpdated(order.getCreated());
		orderMapper.updateById(order);
		
	}
	@Override
	public void deleteItem(Long[] ids) {
		// TODO Auto-generated method stub
		List<Long> idList=Arrays.asList(ids);
		orderMapper.deleteBatchIds(idList);	
		
	}

}
