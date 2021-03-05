package com.jt.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.experimental.Accessors;

@JsonIgnoreProperties(ignoreUnknown=true) //表示JSON转化时忽略未知属性
@TableName("tb_content")	//指定表名称
@Data					
@Accessors(chain=true)
public class ItemContent extends BasePojo{

	private static final long serialVersionUID = 1L;
	@TableId(type=IdType.AUTO)		//标识主键
	private Long id;				//商品id
	private Long categoryId;       //内容类目
	private String title;           //内容标题
	private String subTitle;       //子标题
	private String titleDesc;      //标题描述
	private String url;             //链接
	private String pic;             //图片绝对路径
	private String pic2;            //图片2
	private String content;            //内容

}
