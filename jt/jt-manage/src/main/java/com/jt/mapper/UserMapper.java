package com.jt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jt.pojo.User;

public interface UserMapper extends BaseMapper<User> {
	@Select("select * from tb_user order by updated desc limit #{start},#{rows}")   
	List<User> findUserPage(int start,int rows);
}
