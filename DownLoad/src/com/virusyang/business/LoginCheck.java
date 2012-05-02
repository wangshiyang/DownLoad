package com.virusyang.business;

import java.util.ArrayList;
import java.util.List;

import net.sf.ehcache.Cache;
import net.sf.ehcache.Element;

import com.virusyang.bean.Userinfo;
import com.virusyang.dao.UserDao;

public class LoginCheck {
	private Cache cache;
	
	public void setCache(Cache cache){
		this.cache=cache;
	}
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
		List l=new ArrayList();
//		System.out.println(userdao.findAll().size());
		Element element=cache.get(user.getUsername());
		if(element==null){
		l=userdao.findByUsername(user.getUsername());
		element=new Element(user.getUsername(), l);
		cache.put(element);
		System.out.println("我是不是为空?是还没初始化!");
		}
		System.out.println("我已经出来了!");
		l=(ArrayList)element.getValue();
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
