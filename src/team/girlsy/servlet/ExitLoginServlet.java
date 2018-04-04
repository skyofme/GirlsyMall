package team.girlsy.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ExitLoginServlet extends HttpServlet{

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
		ServletContext application = this.getServletContext(); 
		HttpSession session = req.getSession();
		session.removeAttribute("a_id");
		session.removeAttribute("l_regId");
		session.removeAttribute("l_regPswd");
		session.removeAttribute("CarCnt");
		session.removeAttribute("orderDetails");
		session.setAttribute("loginState", "false");//传递登录状态
		session.setAttribute("exitLogin", "true");
		session.setAttribute("pwdFlag", "true");
		resp.sendRedirect(req.getContextPath()+"/index.html");
	}

}
