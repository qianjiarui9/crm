package com.briup.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.crm.bean.SysUser;
import com.briup.crm.bean.SysUserExample;
import com.briup.crm.dao.SysUserMapper;
import com.briup.crm.service.UsersService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service
public class UsersServiceImpl implements UsersService{
	@Autowired
	private SysUserMapper usersMapper;
	
	@Override
	public PageInfo<SysUser> findAllUsersByPage(int curPage, int size) {
		PageHelper.startPage(curPage,size);
		SysUserExample example = new SysUserExample();
		List<SysUser> userlist = usersMapper.selectByExample(example);
		PageInfo<SysUser> usersinfo = new PageInfo<SysUser>(userlist);
		return usersinfo;
	}

	@Override
	public void saveOrUpdate(SysUser users) {
		if(users.getUsrId()==null) {
			usersMapper.insertSelective(users);
		}else {
			usersMapper.updateByPrimaryKeySelective(users);
		}
		
	}

	@Override
	public void deleteUsersById(long usrId) {
		usersMapper.deleteByPrimaryKey(usrId);
	}

	@Override
	public SysUser findUserById(long usrId) {
		SysUser user = usersMapper.selectByPrimaryKey(usrId);
		return user;
	}
	
}
