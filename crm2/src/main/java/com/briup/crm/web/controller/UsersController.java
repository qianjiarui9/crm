package com.briup.crm.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.briup.crm.bean.SysUser;
import com.briup.crm.service.UsersService;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/users")
public class UsersController {
	@Autowired
	private UsersService usersService;
	@RequestMapping("/findAllUsersByPage/{curPage}")
	public String findAllUsersByPage(@PathVariable int curPage,HttpSession session) {
		PageInfo<SysUser> usersinfo = usersService.findAllUsersByPage(curPage, 5);
		session.setAttribute("usersinfo", usersinfo);
		return "users/user";
	}
	
	@RequestMapping("/saveOrUpdate")
	@ResponseBody
	public String saveOrUpdate(SysUser user) {
		usersService.saveOrUpdate(user);
		return "保存成功";
	}
	
	@RequestMapping("/deleteUsersById/{usrId}")
	@ResponseBody
	public String deleteUsersById(@PathVariable long usrId) {
		usersService.deleteUsersById(usrId);
		return "删除成功";
	}
	
	@RequestMapping("/findUsersById/{usrId}")
	@ResponseBody
	public SysUser findUsersById(@PathVariable long usrId) {
		SysUser user = usersService.findUserById(usrId);
		return user;
	}
}
