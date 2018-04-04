 package team.girlsy.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.girlsy.service.ShoppingCarService;
import team.girlsy.service.impl.ShoppingCarServiceImpl;

public class UpdateServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public UpdateServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); 
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int amount = Integer.parseInt(request.getParameter("amount"));
		int cusId = Integer.parseInt(request.getParameter("cusId"));
		int goodsId = Integer.parseInt(request.getParameter("goodsId"));
		ShoppingCarService shoppingCarService = new ShoppingCarServiceImpl();
		shoppingCarService.updateAmount(cusId, goodsId, amount);
		//response.getWriter().println("ceshi");
	}

	public void init() throws ServletException {
	}

}
