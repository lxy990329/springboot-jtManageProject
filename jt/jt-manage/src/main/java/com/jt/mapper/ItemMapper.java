package com.jt.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jt.pojo.Item;

public interface ItemMapper extends BaseMapper<Item>{

	void deleteItems(long[] ids);
	//@Select("select * from tb_item order by updated desc limit #{start},#{rows}")
	//List<Item> findItemPage(int start,int rows);

	void updateStatus(int status, Date updated, Long[] ids);
}
