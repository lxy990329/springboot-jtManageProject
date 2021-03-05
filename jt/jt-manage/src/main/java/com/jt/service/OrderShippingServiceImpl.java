package com.jt.service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jt.mapper.OderShippingMapper;
import com.jt.pojo.OrderShipping;
import com.jt.vo.EasyUITable;

@Service
public class OrderShippingServiceImpl implements OrderShippingService {

	 @Autowired
	 private OderShippingMapper orderShippingMapper;
	@Override
	public EasyUITable findOderShippingByPage(int page, int rows) {
		//使用mybatisPlus的分页插件
				IPage<OrderShipping> iPage=new Page<>(page,rows);
				QueryWrapper<OrderShipping> queryWrapper = new QueryWrapper<>();
				//降序排列
				queryWrapper.orderByDesc("updated");
				iPage=orderShippingMapper.selectPage(iPage,queryWrapper);
				// 1.找到总记录数
				//Integer total=itemMapper.selectCount(null);
				int total=(int) iPage.getTotal();
				List<OrderShipping> orderShippingList=iPage.getRecords();
				//2.list分页之后的结果
				//int start=(page-1)*rows;
				//List<Item> itemList=itemMapper.findItemPage(start,rows);
				return new EasyUITable(total,orderShippingList);
	}
	@Override
	public void saveOrderShipping(OrderShipping orderShipping) {
		orderShipping.setCreated(new Date()).setUpdated(orderShipping.getCreated());
		orderShippingMapper.insert(orderShipping);
		
	}
	@Override
	public void updateOrderShipping(OrderShipping orderShipping) {
		orderShipping.setUpdated(new Date());
		System.out.println(orderShipping);
		orderShippingMapper.updateById(orderShipping);
		
	}
	@Override
	public void deleteOrderShipping(Long[] ids) {
			//MybatisPlus
			List<Long> idList=Arrays.asList(ids);
			//itemMapper.deleteBatchIds(idList);
			//Mybatis手动实现
			//itemMapper.deleteBatchIds(idList);
			//Mybatis手动实现
			orderShippingMapper.deleteBatchIds(idList);
		// itemDescMapper.deleteBatchIds(idList);
			//orderShippingMapper.deleteOrderShipping(ids);
		}

}
