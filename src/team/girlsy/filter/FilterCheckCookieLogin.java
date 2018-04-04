package team.girlsy.filter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import team.girlsy.bean.Admin;
import team.girlsy.bean.Custom;
import team.girlsy.dao.AdminDao;
import team.girlsy.dao.CustomDao;
import team.girlsy.dao.impl.AdminDaoImpl;
import team.girlsy.dao.impl.CustomDaoImpl;

public class FilterCheckCookieLogin {
	
	public boolean checkCookies(HttpServletRequest req, HttpServletResponse resp) {
		
		AdminDao adminDao = new AdminDaoImpl();
		CustomDao customDao = new CustomDaoImpl();
		 
		Admin admin = new Admin();
		Custom custom = new Custom();
		
		HttpSession session = req.getSession();
		
		String roleFlag = "";
		Cookie[] cookies = req.getCookies();
		if (null != cookies) {
			for (Cookie c : cookies ) {
				//判断role
				if ("role".equals(c.getName())) {
					if ("admin".equals(c.getValue())) {
						roleFlag = "admin";
					}
					else {
						roleFlag = "custom";
					}
				}
				//获取admin或者是custom
				else if ("id".equals(c.getName())) {
					if (null!=c.getValue()) {
						int id = Integer.valueOf(c.getValue());
						if (roleFlag.equals("admin")) {
							admin = adminDao.getAdminById(id);
						}
						if (roleFlag.equals("custom")) {
							custom = customDao.getCustomById(id);
						}
					}
				}
				//判断密码是否正确,并登录
				else if ("pwd".equals(c.getName())) {
					String pwd = c.getValue().toString();
					if (roleFlag.equals("admin")) {
						if (admin.getPwd().equals(pwd)) {
							session.setAttribute("admin", admin);
							session.setAttribute("loginState", "true");
							session.setAttribute("role", "admin");
							session.setAttribute("remember", "remember");
							session.setAttribute("cookieLogined", "true");
							return true;
						}					
					}
					if (roleFlag.equals("custom")) {
						if (custom.getPwd().equals(pwd)) {
							session.setAttribute("custom", custom);		// 顾客信息
							session.setAttribute("loginState", "true");	// 登录状态
							session.setAttribute("role", "custom");		// 角色信息
							session.setAttribute("remember", "remember");// 记住密码
							session.setAttribute("cookieLogined", "true");// 保存cookie
							return true;
						}						
					}
					
				}
			}
		}
		return false;
	}
}
