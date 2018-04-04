package team.girlsy.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import team.girlsy.bean.Custom;
import team.girlsy.bean.OrderDetail;
import team.girlsy.bean.OrderList;
import team.girlsy.dao.CustomDao;
import team.girlsy.dao.OrderDetailDao;
import team.girlsy.dao.OrderListDao;
import team.girlsy.dao.impl.CustomDaoImpl;
import team.girlsy.dao.impl.OrderDetailDaoImpl;
import team.girlsy.dao.impl.OrderListDaoImpl;
import team.girlsy.service.OrderService;
import team.girlsy.service.impl.OrderServiceImpl;

public class OrderDetaiServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		OrderDetailDao orderDetailDao = new OrderDetailDaoImpl();
		OrderDetail orderDetail = new OrderDetail();
		OrderService orderService = new OrderServiceImpl();
		HttpSession session = request.getSession();
		
		if (null!=request.getParameter("orderId")) {
			int orderId = Integer.valueOf(request.getParameter("orderId").toString());
			
			String state = null;
			if (null!=request.getParameter("state")) {
				state =request.getParameter("state").toString();
				state = orderService.changStateType(state);
				orderDetailDao.modifyOrderState(state, orderId);//修改订单状态
			}
			//加载订单详情页面内容
			List<OrderDetail> orderDetails = new ArrayList<OrderDetail>();
			orderDetails = orderDetailDao.getOrderDetailById(orderId);
			request.setAttribute("orderDetails", orderDetails);
			request.setAttribute("totalPrice", orderService.getTotalPrice(orderDetails));
			
			request.getRequestDispatcher("order_detail.jsp").forward(request, response);
			return;
		}
		
		
		/*try {
			int orderId = Integer.valueOf(request.getParameter("orderId").toString());
			List<OrderDetail> orderDetails = new ArrayList<OrderDetail>();
			orderDetails = orderDetailDao.getOrderDetailById(orderId);
			request.setAttribute("orderDetails", orderDetails);
			
			//获取订单总价
			request.setAttribute("totalPrice", orderService.getTotalPrice(orderDetails));
			
			request.getRequestDispatcher("order_detail.jsp").forward(request, response);
			return;
		} catch (Exception e) {
			// TODO: handle exception
			request.getRequestDispatcher("order_detail.jsp").forward(request, response);
			return;
		}*/
		
		
	}

}
