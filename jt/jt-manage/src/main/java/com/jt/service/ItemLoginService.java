package com.jt.service;

import com.jt.pojo.ItemLogin;
import com.jt.vo.Result;

public interface ItemLoginService {

	//String getLoginResule(String username, String password);

	Result login(ItemLogin user);

	Result register(ItemLogin itemLogin);

}
