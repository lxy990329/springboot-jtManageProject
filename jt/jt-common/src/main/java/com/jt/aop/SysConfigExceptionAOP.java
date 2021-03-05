package com.jt.aop;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jt.vo.SysResult;

import lombok.extern.slf4j.Slf4j;

/**
 * 全局异常处理类
 * @author 刘泽东
 *
 */
@RestControllerAdvice
@Slf4j//日志注解
public class SysConfigExceptionAOP {
	/**
	 * 1、拦截什么异常 运行时异常
	 * 2、返回值结果是什么 系统返回值VO对象
	 */
	@ExceptionHandler(RuntimeException.class)//异常处理适配器 捕获运行时异常
    public Object sysResult(Exception exception) {
    	//在日志中显示
    	log.error(exception.getMessage());
    	//打印错误信息
    	exception.printStackTrace();
    	return SysResult.fail();
    }
}
