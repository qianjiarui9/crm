package com.briup.crm.service;

import com.briup.crm.bean.CstActivity;
import com.github.pagehelper.PageInfo;

public interface ActivityService {
	public PageInfo<CstActivity> findActivitiesByCustId(int curPage,int size,long custId);
	public void saveOrUpdate(CstActivity activity);
	public void deleteActivityById(long atvId);
	public CstActivity findActivityById(long atvId);
}
