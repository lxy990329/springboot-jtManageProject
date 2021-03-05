package com.jt.pojo;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@JsonIgnoreProperties(ignoreUnknown=true) //表示JSON转化时忽略未知属性
@TableName("tb_item_param")	//指定表名称
@Data					
@Accessors(chain=true)
@AllArgsConstructor
@NoArgsConstructor
public class ItemParam{
	
	private static final long serialVersionUID = -113421486821062779L;
	@TableId(type=IdType.AUTO)		//标识主键
	private Long   id;				//商品id
	private Long   itemCatId;
	private String paramData;
	private String itemCatName;
	private Date created;
	private Date updated;
}