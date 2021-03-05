package com.jt.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 实现图片的回显
 * @author 刘泽东
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FileImage {
	private Integer error;//0表示成功
	private String url;
	private Integer width;
	private Integer height;
	public static FileImage success(String url,Integer width,Integer height) {
		return new FileImage(0,url,width,height);
	}
	public static FileImage fail() {
		return new FileImage(1,null,null,null);
	}
}
