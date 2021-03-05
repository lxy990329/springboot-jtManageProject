package com.jt.md5;

import java.math.BigInteger;
import java.security.MessageDigest;

public class GetMd5Value {
	public  String getMd5Value(String value){
		try {
			//1. 获得md5加密算法工具类
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			//2. 加密的结果为十进制
			byte[] md5Bytes = messageDigest.digest(value.getBytes());
			//3. 将md5加密算法值转化为16进制
			BigInteger bigInteger = new BigInteger(1, md5Bytes);
			return bigInteger.toString(16);
			
		} catch (Exception e) {
			//如果产生错误则抛出异常
			throw new RuntimeException();
		}
	}
}
