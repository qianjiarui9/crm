package com.briup.crm.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.briup.crm.bean.SysRole;
import com.briup.crm.service.RoleService;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/role")
public class RolesController {
	@Autowired
	private RoleService roleService;
	@RequestMapping("/findAllRoleByPage/{curPage}")
	public String findAllRoleByPage(@PathVariable int curPage,HttpSession session) {
		PageInfo<SysRole> roleinfo = roleService.findAllRoleByPage(curPage, 5);
		session.setAttribute("roleinfo", roleinfo);
		return "roles/role";	
	}
	
	@RequestMapping("/saveOrUpdate")
	@ResponseBody
	public String saveOrUpdate(SysRole role) {
		roleService.saveOrUpdateRole(role);
		return "保存成功";
	}
	
	@RequestMapping("/deleteRoleById/{roleId}")
	@ResponseBody
	public String deleteRoleById(@PathVariable long roleId) {
		roleService.deleteRoleById(roleId);
		return "删除成功";
	}
	
	@RequestMapping("/findRoleById/{roleId}")
	@ResponseBody
	public SysRole findRoleById(@PathVariable long roleId) {
		SysRole role = roleService.findRoleById(roleId);
		return role;
	}
	
	
}
