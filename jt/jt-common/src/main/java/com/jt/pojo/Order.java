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
@TableName("tb_order")
public class Order extends BasePojo  {
	@TableId
	private String orderId;//订单ID
	private String payment;//实付金额
	private Integer paymentType;//支付类型
	private String postFee;//邮费
	private Integer status;//支付状态、
	private Date paymentTime;//支付时间
	private Date consignTime;//发货时间
	private Date endTime;//交易完成时间
	private Date closeTime;//交易关闭时间
	private String shippingName;//物流名称
	private String shippingCode;//物流单号
	private Integer userId;//用户Id
	private String buyerMessage;//买家留言
	private String buyerNick;//，买家昵称
	private Integer buyerRate;//买家评价状态
}
