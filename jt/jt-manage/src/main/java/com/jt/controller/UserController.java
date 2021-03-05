package com.jt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jt.pojo.User;
import com.jt.service.UserService;
import com.jt.vo.EasyUITable;
import com.jt.vo.SysResult;

@RestController
@RequestMapping("/user")
public class UserController {
	/**
	 * url:http://localhost:8091/page/user/query?page=1&rows=20
	 *分页显示
	 */
		@Autowired
		UserService userService;
		@RequestMapping("/query")
		public EasyUITable findUserBypage(int page,int rows) {
			System.out.print("访问了Controller");
			 //return SysResult.success();
			return userService.findUserByPage(page,rows);
		}
		/*新增
		 * url:http://localhost:8091/user/save
		 * 参数：form 表单提交
		 * 返回值：vo对象
		 */
	     @RequestMapping("/save")
		public SysResult saveUser(User user) {
	    	 	 userService.saveUser(user);
	    	 	 return SysResult.success();
	     }
	    /**
	     *  http://localhost:8091/user/update
	     * @param user
	     * @return
	     */
	     @RequestMapping("/update")
	 	public SysResult updateContent(User user){
	    	 userService.updateUser(user);
	 		return SysResult.success();
	 	}
	 	
	    /**
	     * http://localhost:8091/user/delete
	     */
	 	@RequestMapping("/delete")
	 	public SysResult deleteContent(Long[] ids) {
	 		userService.deleteUser(ids);
	 		return SysResult.success();	}
}
