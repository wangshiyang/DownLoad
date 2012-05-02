package com.virusyang.download;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.virusyang.bean.Userinfo;
import com.virusyang.business.LoginCheck;
/**
 * 
 * @author "wangshiyang"
 *
 */
public class DownActionCheck extends ActionSupport {

	
	private static final long serialVersionUID = 1L;
	
	private LoginCheck lc;
	
	public LoginCheck getLc() {
		return lc;
	}

	public void setLc(LoginCheck lc) {
		this.lc = lc;
	}
	private Userinfo user;
	public Userinfo getUser() {
		return user;
	}

	public void setUser(Userinfo user) {
		this.user = user;
	}
	public String login(){
//		System.out.println("i am here!");
		boolean flag=lc.isVilable(user);
		
//		System.out.println(flag);
		if(flag){
			HttpServletRequest request=ServletActionContext.getRequest();
			request.getSession().setAttribute("user", user);
			return "SUCCESS";
		}
		else
			return "INPUT";
	}

	
	@Override
	public String execute(){
		System.out.println("i am here!");
		return "INPUT";
	}
	

}
