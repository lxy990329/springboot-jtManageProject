package com.jt.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;
import lombok.experimental.Accessors;

@TableName("tb_content_category")	//指定表名称
@Data					
@Accessors(chain=true)
public class ItemContentCategory extends BasePojo{

	private static final long serialVersionUID = 1L;
	@TableId(type=IdType.AUTO)		//标识主键
	private Long id;
	private Long parentId;
	private String name;
	private Integer status;
	private Integer sortOrder;//排序号
	private Boolean isParent;

}
