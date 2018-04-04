package team.girlsy.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;

import team.girlsy.bean.Admin;
import team.girlsy.bean.Custom;
import team.girlsy.bean.OrderDetail;
import team.girlsy.dao.AdminDao;
import team.girlsy.dao.CustomDao;
import team.girlsy.dao.OrderDetailDao;
import team.girlsy.dao.ShoppingCarDao;
import team.girlsy.dao.impl.AdminDaoImpl;
import team.girlsy.dao.impl.CustomDaoImpl;
import team.girlsy.dao.impl.OrderDetailDaoImpl;
import team.girlsy.dao.impl.ShoppingCarDaoImpl;
import team.girlsy.service.AdminService;
import team.girlsy.service.CustomService;
import team.girlsy.service.impl.AdminServiceImpl;
import team.girlsy.service.impl.CustomServiceImpl;

public class LoginCustomServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}
 
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = req.getSession();
		
		ServletContext application = this.getServletContext();
		
		CustomService customService = new CustomServiceImpl();

		int userId = Integer.valueOf(session.getAttribute("a_id").toString()) ;
		String pwd = session.getAttribute("a_pwd").toString();
		String cookieFlag = session.getAttribute("a_cookieFlag").toString();
		
		//查看密码是否正确，然后登录到index或者重新登录
		if (customService.loginCheckById(userId,pwd)) {
			
			CustomDao customDao = new CustomDaoImpl();
			Custom custom = new Custom();
			custom = customDao.getCustomById(userId);
			ShoppingCarDao shoppingDao=new ShoppingCarDaoImpl();
			session.setAttribute("pwdFlag", "true");
			session.setAttribute("custom", custom);//传递custom的信息
			session.setAttribute("loginState", "true");//传递登录状态
			//购物车数量
			Custom custom1 = (Custom)session.getAttribute("custom");
			int id = custom1.getId();
			int CarCnt=shoppingDao.getNumShoppingCarById(id);
			/*application.setAttribute("CarCnt",CarCnt);*/
			session.setAttribute("CarCnt",CarCnt);
			//显示订单详情
			OrderDetailDao orderDetailDao = new OrderDetailDaoImpl();
			List<OrderDetail> orderDetails= orderDetailDao.getOrderDetailByCusId(custom1.getId());
			session.setAttribute("orderDetails", orderDetails);
			//是否需要记住密码
			if (cookieFlag.equals("true")) {				
				remeberCustomId(req, resp, custom);

			}
			else {
				dropCustomId(req, resp, userId);

			}
			
			req.getRequestDispatcher("index.jsp").forward(req, resp);
			
			
		}
		else {

			session.setAttribute("pwdFlag", "false");
			session.setAttribute("loginState", "false");//传递登录状态
			resp.sendRedirect(req.getContextPath()+"/login.jsp");
		}
	}
	
	//记住密码方法体
	public void remeberCustomId(HttpServletRequest req, HttpServletResponse resp,Custom custom) {

		ServletContext application = this.getServletContext();
		
		Cookie[] cookies = req.getCookies();
		for(Cookie c:cookies){
			c.setMaxAge(0);
			resp.addCookie(c);
		}
		
		Cookie pwdCookie = new Cookie("pwd", custom.getPwd());
		Cookie idCookie = new Cookie("id", custom.getId().toString());
		Cookie roleCookie = new Cookie("role", "custom");
		pwdCookie.setMaxAge(30*24*60*60);//有效时长一个月
		idCookie.setMaxAge(30*24*60*60);//有效时长一个月
		roleCookie.setMaxAge(30*24*60*60);//有效时长一个月
		resp.addCookie(roleCookie);
		resp.addCookie(idCookie);
		resp.addCookie(pwdCookie);
	}
	
	//不要记住账号了
	public void dropCustomId(HttpServletRequest req, HttpServletResponse resp,int userId) {

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
					if ("admin".equals(c.getValue())) {
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
