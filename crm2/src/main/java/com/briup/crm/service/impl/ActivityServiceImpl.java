package com.briup.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.crm.bean.CstActivity;
import com.briup.crm.bean.CstActivityExample;
import com.briup.crm.dao.CstActivityMapper;
import com.briup.crm.service.ActivityService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service
public class ActivityServiceImpl implements ActivityService{
	@Autowired
	private CstActivityMapper activityMapper;
	@Override
	public PageInfo<CstActivity> findActivitiesByCustId(int curPage, int size, long custId) {
		
		PageHelper.startPage(curPage,size);
		CstActivityExample example = new CstActivityExample();
		example.createCriteria().andAtvCustIdEqualTo(custId);
		List<CstActivity> activitylist = activityMapper.selectByExample(example);
		//将顾客信息传递给分页对象
		PageInfo<CstActivity> activityinfo = new PageInfo<CstActivity>(activitylist);
		return activityinfo;
	}
	@Override
	public void saveOrUpdate(CstActivity activity) {
		
		if(activity.getAtvId()==null) {
			activityMapper.insertSelective(activity);
		}
		else {
			activityMapper.updateByPrimaryKey(activity);
		}
	}
	@Override
	public void deleteActivityById(long atvId) {
		
		activityMapper.deleteByPrimaryKey(atvId);
	}
	@Override
	public CstActivity findActivityById(long atvId) {
		CstActivity activity = activityMapper.selectByPrimaryKey(atvId);
		return activity;
		
	}

}
