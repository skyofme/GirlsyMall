package team.girlsy.servlet;

import java.io.IOException;

import javassist.bytecode.stackmap.BasicBlock.Catch;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AdminOrCustomServlet extends HttpServlet {

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

		session.setAttribute("a_id", req.getParameter("id"));
		session.setAttribute("a_pwd", req.getParameter("password"));
		session.setAttribute("exitLogin", "true");

		//判断是否记住密码
		if (null != req.getParameter("remember")) {
			String remember = req.getParameter("remember");
			if (remember.equals("remember")) {
				session.setAttribute("a_cookieFlag", "true");
			}
			else {
				session.setAttribute("a_cookieFlag", "false");
			}
		}else {
			session.setAttribute("a_cookieFlag", "false");
		}

		// 获取是管理员还是用户登录
		String roleString = req.getParameter("login");

		if (roleString.equals("admin")) {
			session.removeAttribute("custom");
			session.setAttribute("role", "admin");
			req.getRequestDispatcher("/LoginAdmin").forward(req, resp);
		}
		if (roleString.equals("custom")) {
			session.removeAttribute("admin");
			session.setAttribute("role", "custom");
			req.getRequestDispatcher("/LoginCustom").forward(req, resp);
		}
	}

}
