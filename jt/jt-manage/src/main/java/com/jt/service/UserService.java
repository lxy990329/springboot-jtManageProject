package com.jt.service;

import com.jt.pojo.User;
import com.jt.vo.EasyUITable;

public interface UserService {

	EasyUITable findUserByPage(int page, int rows);

	void saveUser(User user);

	void updateUser(User user);

	void deleteUser(Long[] ids);

}
