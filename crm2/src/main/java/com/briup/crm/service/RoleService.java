package com.briup.crm.service;

import com.briup.crm.bean.SysRole;
import com.github.pagehelper.PageInfo;

public interface RoleService {
	public PageInfo<SysRole> findAllRoleByPage(int curPage,int size);
	public void saveOrUpdateRole(SysRole role);
	public void deleteRoleById(long roleId);
	public SysRole findRoleById(long roleId);
}
