package com.briup.crm.service;

import com.briup.crm.bean.SysUser;
import com.github.pagehelper.PageInfo;

public interface UsersService {
	public PageInfo<SysUser> findAllUsersByPage(int curPage,int size);
	public void saveOrUpdate(SysUser users);
	public void deleteUsersById(long usrId);
	public SysUser findUserById(long usrId);
	
}
