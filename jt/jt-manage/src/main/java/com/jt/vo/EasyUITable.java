package com.jt.vo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor //无参数
@AllArgsConstructor//全参数

public class EasyUITable {
	private Integer total;//定义总记录数
	private List rows;//定义集合的信息，写的就是用户展现的记录

}
