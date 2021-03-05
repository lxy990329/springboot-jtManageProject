package com.jt.vo;

import lombok.Data;

@Data
public class Result<T> {
	private String msg;
	private boolean success;
	private T detail;
}
