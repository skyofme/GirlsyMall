package team.girlsy.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import team.girlsy.bean.Custom;
import team.girlsy.bean.OrderList;
import team.girlsy.bean.ShoppingCar;
import team.girlsy.dao.CustomDao;
import team.girlsy.dao.impl.CustomDaoImpl;
import team.girlsy.service.CustomService;
import team.girlsy.service.OrderService;
import team.girlsy.service.impl.CustomServiceImpl;
import team.girlsy.service.impl.OrderServiceImpl;

public class ShoppingServlet extends HttpServlet {

	public ShoppingServlet() {
		super();
	}
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String[] ids = request.getParameterValues("id1");
		String[] nums = request.getParameterValues("num1");
		if (!(ids==null)) {
		//获取用户地址电话姓名
		CustomService customService = new CustomServiceImpl();
		HttpSession session = request.getSession();
		//ServletContext application = this.getServletContext();
		CustomDao customDao = new CustomDaoImpl();
		Custom custom = (Custom) session.getAttribute("custom");		
		int userId = custom.getId();
		String pwd = custom.getPwd();
		if (customService.loginCheckById(userId,pwd)) {
		custom = customDao.getCustomById(userId);	
		Custom custom1 = (Custom)session.getAttribute("custom");
		int id = custom1.getId();	
		
		String cus_addr=custom1.getAddr();
		session.setAttribute("cus_addr", cus_addr);
		
		String cus_name=custom1.getName();
		session.setAttribute("cus_name", cus_name);
		
		String cus_tel=custom1.getTel();
		session.setAttribute("cus_tel", cus_tel);
		}
		//获取勾选购物车信息
		int[] intIds = new int[ids.length];
		for (int i = 0; i < nums.length; i++) {
			intIds[i] = Integer.parseInt(ids[i]);
		}
		int[] intNums = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			intNums[i] = Integer.parseInt(nums[i]);
		}
		OrderService orderService  = new OrderServiceImpl();
		List<ShoppingCar> shoppingCars = orderService.showPickOrder(intIds, intNums,userId);
		session.setAttribute("pickShoppingCars", shoppingCars);
		
		//获取订单总价
		double sumPrice=0.0;
		for (ShoppingCar s : shoppingCars) {
			sumPrice+=(s.getGoods().getPrice())*(s.getGoods().getDiscount())*(s.getBuyNum())*0.1;
		}
		request.setAttribute("sumPrice", sumPrice);
		request.getRequestDispatcher("/pay.jsp").forward(request, response);       
        }else {
	        request.getRequestDispatcher("/shopping-car.jsp").forward(request, response);
        }
	}
	public void init() throws ServletException {
		// Put your code here
	}

}
