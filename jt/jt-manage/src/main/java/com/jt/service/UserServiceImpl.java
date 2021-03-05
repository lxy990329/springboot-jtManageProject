package com.jt.service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jt.mapper.ItemDescMapper;
import com.jt.mapper.ItemMapper;
import com.jt.mapper.UserMapper;
import com.jt.pojo.User;
import com.jt.vo.EasyUITable;

@Service
public class UserServiceImpl implements UserService {

	 @Autowired
	 private UserMapper userMapper;
	@Override
	public EasyUITable findUserByPage(int page, int rows) {
		Integer total=userMapper.selectCount(null);
		int start=(page-1)*rows;
		List<User> userList=userMapper.findUserPage(start, rows);
		return new EasyUITable(total,userList);
	}
	@Override
	public void saveUser(User user) {
		user.setCreated(new Date()).setUpdated(user.getCreated());
		userMapper.insert(user);
	}
	@Override
	public void updateUser(User user) {
		user.setUpdated(new Date());
		userMapper.updateById(user);
		
	}
	@Override
	public void deleteUser(Long[] ids) {
		List<Long> idList=Arrays.asList(ids);
		userMapper.deleteBatchIds(idList);
		}
}
