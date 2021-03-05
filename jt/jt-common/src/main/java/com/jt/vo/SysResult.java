package com.jt.vo;
/**
 * 系统级的返回值对象
 */
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain=true)
public class SysResult {
	private Integer status;//业务操做成功的标识符，目的是为了前后台数据的交互；规定标识状态信息 200成功 201失败;其中此处的200与http协议中的没有关系，此处表示业务调用成功的标识。
	private String msg;//提示信息
	private Object data;//服务器返回页面数据的信息
	/**
	 * 为什么写静态方法，简化用户调用
	 * 因为静态方法属于类的，所以访问时，
	 * 可以用类名.方法名
	 * 对象.方法名
	 */

	//用户返回的值不确定，所以编辑公共的API，简化用户的调用
	public static SysResult success() {
		return new SysResult(200,"操作成功",null);
	}
	public static SysResult success(Object data) {
		return new SysResult(200, "操作成功", data);
	}

	public static SysResult success(String msg,Object data) {

		return new SysResult(200, msg, data);
	}

	public static SysResult fail() {
		return new SysResult(201, "业务调用失败", null);
	}

}
