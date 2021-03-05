package com.jt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jt.pojo.OrderItem;


public interface OrderItemMapper extends BaseMapper<OrderItem> {
	@Select("select * from tb_order_item order by updated desc limit #{start},#{rows}")
	List<OrderItem> findorderItemPage(int start, int rows);
	
	//void deleteOrderItems(Long[] ids);
}
