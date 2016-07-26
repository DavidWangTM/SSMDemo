package com.davidwang.core;

import com.davidwang.model.User;
import com.davidwang.shiro.UserRealm;
import com.davidwang.utils.SpringContextUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;


public class TokenManager {
	//用户登录管理
	public final UserRealm realm = SpringContextUtil.getBean("userRealm",UserRealm.class);
	/**
	 * 获取当前登录的用户User对象
	 * @return
	 */
	public static User getToken(){
		User token = (User)SecurityUtils.getSubject().getPrincipal();
		return token ;
	}

	/**
	 * 获取当前用户的Session
	 * @return
	 */
	public static Session getSession(){
		return SecurityUtils.getSubject().getSession();
	}

	/**
	 * 把值放入到当前登录用户的Session里
	 * @param key
	 * @param value
	 */
	public static void setVal2Session(Object key ,Object value){
		getSession().setAttribute(key, value);
	}
	/**
	 * 从当前登录用户的Session里取值
	 * @param key
	 * @return
	 */
	public static Object getVal2Session(Object key){
		return getSession().getAttribute(key);
	}
	/**
	 * 获取验证码，获取一次后删除
	 * @return
	 */
	public static String getYZM(){
		String code = (String) getSession().getAttribute("CODE");
		getSession().removeAttribute("CODE");
		return code ;
	}

}
