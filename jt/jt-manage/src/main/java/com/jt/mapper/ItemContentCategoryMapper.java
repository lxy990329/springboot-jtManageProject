package com.jt.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jt.pojo.ItemContentCategory;
import com.jt.pojo.ItemLogin;
@Mapper
public interface ItemContentCategoryMapper extends BaseMapper<ItemContentCategory>{
    @Select("select * from tb_content_category  where id = #{id}")
    ItemContentCategory SelectAll(ItemContentCategory itemContentCategory);

}
