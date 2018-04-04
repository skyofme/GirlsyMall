package team.girlsy.servlet;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jboss.weld.context.SessionContext;

import team.girlsy.bean.Admin;
import team.girlsy.dao.AdminDao;
import team.girlsy.dao.impl.AdminDaoImpl;
import team.girlsy.service.AdminService;
import team.girlsy.service.impl.AdminServiceImpl;
import team.girlsy.utils.BaseDao;

public class LoginAdminServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = req.getSession();
		AdminService adminService = new AdminServiceImpl();
		ServletContext application = this.getServletContext();

		int userId = Integer.valueOf(session.getAttribute("a_id").toString()) ;
		String pwd = session.getAttribute("a_pwd").toString();
		String cookieFlag = session.getAttribute("a_cookieFlag").toString();
		
		//查看密码是否正确，然后登录到index或者重新登录
		if (adminService.loginCheckById(userId,pwd)) {
			
			AdminDao adminDao = new AdminDaoImpl();
			Admin admin = new Admin();
			admin = adminDao.getAdminById(userId);
			
			session.setAttribute("pwdFlag", "true");
			session.setAttribute("admin", admin);//传递admin的信息
			session.setAttribute("loginState", "true");//传递登录状态
			
			//是否需要记住密码
			if (cookieFlag.equals("true")) {
				
				remeberAdminId(req, resp, admin);	
			}
				
			else {
				dropAdminId(req, resp, userId);
			}
			
			session.removeAttribute("a_pwd");
			req.getRequestDispatcher("adminindex.jsp").forward(req, resp);
		}
		else {
			session.setAttribute("pwdFlag", "false");
			session.setAttribute("loginState", "false");//传递登录状态
			
			System.out.println("pwdFlag"+session.getAttribute("pwdFlag").toString());

			resp.sendRedirect(req.getContextPath()+"/login.jsp");
		}


	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}
	
	//记住账号方法体
	public void remeberAdminId(HttpServletRequest req, HttpServletResponse resp,Admin admin) {
		
		ServletContext application = this.getServletContext();
		
		Cookie[] cookies = req.getCookies();
		for(Cookie c:cookies){
			c.setMaxAge(0);
			resp.addCookie(c);
		}
		
		Cookie pwdCookie = new Cookie("pwd", admin.getPwd());
		Cookie roleCookie = new Cookie("role", "admin");
		Cookie idCookie = new Cookie("id", admin.getId().toString());				
		pwdCookie.setMaxAge(30*24*60*60);//有效时长一个月
		roleCookie.setMaxAge(30*24*60*60);//有效时长一个月
		idCookie.setMaxAge(30*24*60*60);//有效时长一个月
		resp.addCookie(roleCookie);
		resp.addCookie(idCookie);
		resp.addCookie(pwdCookie);
		
	
	}
	
	//不要记住账号了
	public void dropAdminId(HttpServletRequest req, HttpServletResponse resp,int userId) {

		ServletContext application = this.getServletContext();
		boolean killCookie = true;
		
		Cookie[] cookies = req.getCookies();
		if (null != cookies) {
			for (Cookie c:cookies) {
				if ("id".equals(c.getName())) {	
					if (userId != Integer.valueOf(c.getValue())) {
						killCookie = false;
					}
				}
				if ("role".equals(c.getName())) {
					if ("custom".equals(c.getValue())) {
						killCookie = false;
					}
				}
			}
			if (killCookie) {
				for(Cookie c:cookies){
				c.setMaxAge(0);
				resp.addCookie(c);
				}
			}
			
		}
		
	}
	
}
