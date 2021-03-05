package com.jt.pojo;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain=true)
@NoArgsConstructor
@AllArgsConstructor
@TableName("tb_order_item")
public class OrderItem extends BasePojo {
	@TableId
	private String itemId;
	private String orderId;
	private Integer num;
	private String title;
	private Long price;
	private Long totalFee;
	private String picPath;
}
