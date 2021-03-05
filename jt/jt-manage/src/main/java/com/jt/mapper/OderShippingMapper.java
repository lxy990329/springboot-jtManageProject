package com.jt.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jt.pojo.OrderShipping;

public interface OderShippingMapper extends BaseMapper<OrderShipping>{
//	@Select("select * from tb_order_shipping order by updated desc limit #{start},#{rows}")   
//	List<OrderShipping> findOderShippingPage(int start,int rows);
//	void deleteOrderShipping(Long[] ids);
//	//void updateStatus(int status, Date updated, Long[] ids); 
}
