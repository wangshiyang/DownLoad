package com.virusyang.business;

import java.util.List;

import com.virusyang.bean.Userinfo;
import com.virusyang.dao.UserDao;

public class LoginCheck {
	private Userinfo user;
	public Userinfo getUser() {
		return user;
	}

	public void setUser(Userinfo user) {
		this.user = user;
	}
	private UserDao userdao;
	
	public UserDao getUserdao() {
		return userdao;
	}

	public void setUserdao(UserDao userdao) {
		this.userdao = userdao;
	}
	public boolean isVilable(Userinfo user){
//		System.out.println(userdao.findAll().size());
		List l=userdao.findByUsername(user.getUsername());
//		System.out.println(l.size());
		if(l.size()<=0) 
			return false;
		
		for(int i=0;i<l.size();i++){
			this.user=(Userinfo) l.get(i);
		}
		if(this.user.getPassword().equals(user.getPassword()))
			return true;
		else 
			return false;
	}
}
