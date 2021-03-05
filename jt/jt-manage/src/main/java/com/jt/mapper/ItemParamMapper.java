package com.jt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jt.pojo.ItemParam;

public interface ItemParamMapper extends BaseMapper<ItemParam>{
	@Select("select * from tb_item_param order by updated desc limit #{start},#{rows}")
	List<ItemParam> findItemParamByPage(int start, int rows);
	//void deleteItemParams(Long[] ids);
	
	@Select("select name from tb_item_cat where id=#{itemCatId}")
	String findName(Long id);
}
