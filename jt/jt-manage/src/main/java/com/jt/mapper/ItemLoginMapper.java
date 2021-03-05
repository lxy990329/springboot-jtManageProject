package com.jt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jt.pojo.ItemLogin;

public interface ItemLoginMapper extends BaseMapper<ItemLogin> {
	 /**
     * 查询用户名是否存在，若存在，不允许注册
     * 注解@Param(value) 若value与可变参数相同，注解可省略
     * 注解@Results  列名和字段名相同，注解可省略
     * @param username
     * @return
     */
    @Select(value = "select username,password from tb_user where username=#{username}")
    @Results
            ({@Result(property = "username",column = "username"),
              @Result(property = "password",column = "password")})
    ItemLogin findUserByName(@Param("username") String username);

//    /**
//     * 注册  插入一条user记录
//     * @param user
//     * @return
//     */
//    @Insert("insert into user values(#{id},#{username},#{password},#{phone},#{email})")
//    //加入该注解可以保存对象后，查看对象插入id
//    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
//    void regist(ItemLogin user);
    
    @Select("select id from tb_user  where username = #{username} and password = #{password}")
    Long login(ItemLogin user);
}
