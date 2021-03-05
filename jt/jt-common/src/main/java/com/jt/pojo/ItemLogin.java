package com.jt.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;
import lombok.experimental.Accessors;

@TableName("tb_user")	//指定表名称
@Data					
@Accessors(chain=true)
public class ItemLogin extends BasePojo{

	private static final long serialVersionUID = 1L;
	@TableId(type=IdType.AUTO)		//标识主键
	private Long id;
	private String username;
	private String password;
	private String phone;
	private String email;
}
