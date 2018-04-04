package team.girlsy.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import team.girlsy.bean.Custom;
import team.girlsy.dao.CustomDao;
import team.girlsy.dao.impl.CustomDaoImpl;
import team.girlsy.service.CustomService;
import team.girlsy.service.impl.CustomServiceImpl;

public class RegistCustom extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		/*CustomDao customDao = new CustomDaoImpl();
		Custom custom = new Custom();*/
		
		CustomService customService = new CustomServiceImpl();
		Custom custom = new Custom();
		
		
		String name = req.getParameter("User");
		String pswd = req.getParameter("Pswd");
		String sex = req.getParameter("Regi");
		String tel = req.getParameter("Tel");
		
		String addr = req.getParameter("province") + " " + req.getParameter("city") + " " + req.getParameter("county") + " " + req.getParameter("Addr");
		System.out.println(name + "..." + pswd + "..." + sex + "..." + tel + "..." + addr);
		
		
		custom.setName(name);
		custom.setPwd(pswd);
		custom.setSex(sex);
		custom.setTel(tel);
		custom.setAddr(addr);
		
		int regId = customService.addCustom(custom);
		
		HttpSession session = req.getSession();
		
		session.setAttribute("l_regId", regId);
		session.setAttribute("l_regPswd", pswd);
		
		session.setAttribute("login", "custom");
		session.setAttribute("pwdFlag", "true");
		
		req.getRequestDispatcher("login.jsp").forward(req, resp);
		//resp.sendRedirect("login.jsp");
	}
}
