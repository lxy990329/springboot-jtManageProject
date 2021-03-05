package com.jt.pojo;

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
@TableName("tb_order_shipping")
public class OrderShipping extends BasePojo{
	@TableId
	private String id;
	private String receiverName;
	private String receiverPhone;
	private String receiverMobile;
	private String receiverState;
	private String receiverCity;
	private String receiverDistrict;
	private String receiverAddress;
	private String receiverZip;
}
