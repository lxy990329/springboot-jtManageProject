package com.jt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jt.pojo.ItemLogin;
import com.jt.service.ItemLoginService;
import com.jt.vo.Result;


@RestController
public class ItemLoginController {
	@Autowired
	private ItemLoginService itemLoginService;
	@RequestMapping("/item/login")
	public Result login(ItemLogin itemLogin){
        return itemLoginService.login(itemLogin);
    }
	@RequestMapping("/item/login/register")
	public Result register(ItemLogin itemLogin){
        return itemLoginService.register(itemLogin);
    }
}
