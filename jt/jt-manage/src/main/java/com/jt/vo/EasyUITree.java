package com.jt.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors//列表方式添加
@AllArgsConstructor
@NoArgsConstructor
public class EasyUITree {
	private Long id;//代表节点id
	private String text;//节点名称
	private String state;//打开 open / 关闭closed
}
