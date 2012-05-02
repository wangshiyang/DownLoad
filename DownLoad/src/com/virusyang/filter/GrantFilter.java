package com.virusyang.filter;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;


import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class GrantFilter extends AbstractInterceptor{
	
	private HttpServletRequest request; 
	private HttpServletResponse response; 
	private HttpSession session;
	
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// 取得请求相关的ActionContext实例 
		this.request=ServletActionContext.getRequest();
		String path=request.getSession().getServletContext().getRealPath("");
		System.out.println(path+request.getSession().getAttribute("user"));
		String path1=request.getRequestURI();
		path1=path1.substring(path1.lastIndexOf("/")+1);
		if("login".equals(path1))
			return invocation.invoke();
		if(request.getSession().getAttribute("user")==null)
		{
			request.getSession().setAttribute("user", "guest");
			System.out.println("action is: "+path1);
			return "INPUT";
		}
		return invocation.invoke();
	}

	

}
