package com.briup.crm.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.briup.crm.bean.CstService;
import com.briup.crm.bean.SysUser;
import com.briup.crm.service.ServeService;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/service")
public class ServiceController {
	@Autowired
	private ServeService serveService;
	
	@RequestMapping("/findServiceByUserName/{curPage}")
	public String findServiceByUserName(@PathVariable int curPage,HttpSession session) {
		SysUser user = (SysUser)session.getAttribute("user");
		PageInfo<CstService> serveinfo = serveService.findServiceByUserName(curPage, 5, user.getUsrName());
		session.setAttribute("serveinfo", serveinfo);
		return "service/service";
	}
	
	@RequestMapping("/findServiceLike/{curPage}")
	public String findServiceLike(@PathVariable int curPage,CstService serve,HttpSession session) {
		SysUser user = (SysUser)session.getAttribute("user");
		serve.setSvrDispose(user.getUsrName());
		PageInfo<CstService> serveinfo = serveService.findServiceLike(curPage, 5, serve);
		session.setAttribute("serveinfo", serveinfo);
		return "service/serviceLike";
	}
	
	@RequestMapping("/saveOrUpdate")
	@ResponseBody
	public String saveOrUpdate(CstService service,HttpSession session) {
		serveService.saveOrUpdate(service);
		return "保存成功";
	}
	
	@RequestMapping("/findServiceById/{servId}")
	@ResponseBody
	public CstService findServiceById(@PathVariable long servId) {
		CstService service = serveService.findServiceById(servId);
		return service;
	}
	
	@RequestMapping("/toServiceDetail/{servId}")
	public String toServiceDetail(@PathVariable long servId,HttpSession session) {
		CstService service = serveService.findServiceById(servId);
		session.setAttribute("service", service);
		return "service/serviceDetail";
	}
	
	@RequestMapping("/findAllService/{curPage}")
	public String findAllService(@PathVariable int curPage,HttpSession session) {
		PageInfo<CstService> serviceInfo = serveService.findAllService(curPage,5);
		session.setAttribute("serviceInfo", serviceInfo);
		return "service/feedback";
	}
	
	@RequestMapping("/findServiceFeedbackLike/{curPage}")
	public String findServiceFeedbackLike(@PathVariable int curPage,CstService serve,HttpSession session) {
		PageInfo<CstService> serveinfo = serveService.findServiceFeedbackLike(curPage, 5, serve);
		session.setAttribute("serveinfo", serveinfo);
		return "service/feedback";
	}
}
