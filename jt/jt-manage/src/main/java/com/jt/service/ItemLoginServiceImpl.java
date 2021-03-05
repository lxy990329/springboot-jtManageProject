package com.jt.service;

import java.util.Date;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jt.mapper.ItemLoginMapper;
import com.jt.pojo.ItemLogin;
import com.jt.vo.Result;

@Service
@ResponseBody
public class ItemLoginServiceImpl implements ItemLoginService {
    @Autowired
    private ItemLoginMapper itemLoginMapper;
    
    /**
     * 登录验证
     */
	@Override
	public Result login(ItemLogin user) {
		Result loginresult = new Result();
		loginresult.setSuccess(false);
		loginresult.setDetail(null);
        try {
            Long userId= itemLoginMapper.login(user);
            if(userId == null){
            	loginresult.setMsg("用户名或密码错误");
            }else{
            	loginresult.setMsg("登录成功");
            	loginresult.setSuccess(true);
                user.setId(userId);
                loginresult.setDetail(user);
            }
        } catch (Exception e) {
        	loginresult.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return loginresult;
	}
    
    /**
     * 注册
     */
	@Override
	@Transactional//事务控制
	public Result register(ItemLogin itemLogin) {

		Result result = new Result();
	        result.setSuccess(false);
	        //result.setDetail(null);
	        try {
	            ItemLogin existUser = itemLoginMapper.findUserByName(itemLogin.getUsername());
	            if(existUser != null){
	                //如果用户名已存在
	                result.setMsg("用户名已存在");

	            }else{
	            	//itemLoginMapper.regist(itemLogin);
	                //System.out.println(user.getId());
	            	itemLogin.setCreated(new Date()).setUpdated(itemLogin.getCreated());
	            	itemLoginMapper.insert(itemLogin);
	                result.setMsg("注册成功");
	                result.setSuccess(true);
	                //result.setDetail(itemLogin);
	            }
	        } catch (Exception e) {
	            result.setMsg(e.getMessage());
	            e.printStackTrace();
	        }
	        return result;
	}

}
