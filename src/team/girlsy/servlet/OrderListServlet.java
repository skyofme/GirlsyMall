package team.girlsy.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.spi.Context;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;

import team.girlsy.bean.OrderList;
import team.girlsy.dao.OrderListDao;
import team.girlsy.dao.impl.OrderListDaoImpl;
import team.girlsy.service.OrderService;
import team.girlsy.service.impl.OrderServiceImpl;

public class OrderListServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 
		OrderListDao orderListDao = new OrderListDaoImpl();
		OrderList orderList = new OrderList();
		HttpSession session = request.getSession();
		 
		String operation = null;
		if (null == request.getParameter("op")) {
			List<OrderList> orderLists = orderListDao.getLimitOrderList(1, "");
			session.setAttribute("orderLists", orderLists);
			session.setAttribute("nowPage", "1");
			request.getRequestDispatcher("order_list.jsp").forward(request, response);
			return;
		}else {
			operation = request.getParameter("op").toString();
			if ("del".equals(operation)) {
				//删除信息
				int delId = Integer.valueOf(request.getParameter("id").toString());
				orderListDao.delOrderList(delId);
				request.setAttribute("deleteFlag", "true");
				List<OrderList> orderLists = orderListDao.getLimitOrderList(1, "");
				session.setAttribute("orderLists", orderLists);
				session.setAttribute("nowPage", "1");
				request.getRequestDispatcher("order_list.jsp").forward(request, response);
				return;
			}else if ("sea".equals(operation)) {
				String orderState = request.getParameter("orderState");
				String orderId = request.getParameter("orderId");
				int whichPage;
				OrderService orderService = new OrderServiceImpl();
				
				
				
				if (null != request.getParameter("whichPage")) {
					whichPage = Integer.valueOf(request.getParameter("whichPage"));
					
					String state=null;
					String search = null;
					if (null != session.getAttribute("orderStateForLimitPage")) {
						state = session.getAttribute("orderStateForLimitPage").toString();
					}else {
						state = "";
					}
					if (null != session.getAttribute("orderSearchForLimitPage")) {
						search = session.getAttribute("orderSearchForLimitPage").toString();
					}else {
						search = "";
					}
					
					//判断是否是根据Id或名称查找的，方便之后分页确定总数量
					String byIdFlag;
					if ("searchByIdOrName".equals(orderService.searchOrderList(state,orderId))) {
						byIdFlag = "true";
					}else {
						byIdFlag = "false";
					}
				
					int beforePage = 1;
					if (null!=session.getAttribute("nowPage")) {
						beforePage=Integer.valueOf(session.getAttribute("nowPage").toString());
					}
					
					int nowPage = orderService.nowPage(whichPage, state,search,beforePage,byIdFlag);
					session.setAttribute("nowPage", nowPage);
					List<OrderList> orderLists= new ArrayList<OrderList>();					
					if ("true".equals(byIdFlag)) {
						orderLists=(orderListDao.getOrderListByIdOrName(nowPage,orderId));
					}else {
						orderLists = orderService.pageLimit(nowPage, state);
					}
					
					session.setAttribute("orderLists", orderLists);
					request.getRequestDispatcher("order_list.jsp").forward(request, response);
					return;
				}
				
				if ("all".equals(orderService.searchOrderList(orderState,orderId))) {
					//显示所有商品
					List<OrderList> orderLists = orderListDao.getLimitOrderList(1, "");
					session.setAttribute("orderLists", orderLists);
					session.setAttribute("orderStateForLimitPage", "");
					session.setAttribute("nowPage", "1");
					session.removeAttribute("orderId");
					request.getRequestDispatcher("order_list.jsp").forward(request, response);
					return;
				}else if ("searchByIdOrName".equals(orderService.searchOrderList(orderState,orderId))) {
					//通过ID查找订单
					
					List<OrderList> orderLists = new ArrayList<OrderList>();
					orderLists = orderListDao.getOrderListByIdOrName(1,orderId);
					session.setAttribute("orderLists", orderLists);
					session.setAttribute("orderId",orderId );
					session.setAttribute("orderSearchForLimitPage", orderId);
					session.setAttribute("nowPage", "1");
					request.getRequestDispatcher("order_list.jsp").forward(request, response);
					return;
				}else if ("searchByState".equals(orderService.searchOrderList(orderState,orderId))) {
					//通过订单状态查找订单
					List<OrderList> orderLists = orderListDao.getLimitOrderList(1, orderState);
					session.setAttribute("orderLists", orderLists);
					session.setAttribute("nowPage", "1");
					session.removeAttribute("orderId");
					session.setAttribute("orderStateForLimitPage", orderState);
					request.getRequestDispatcher("order_list.jsp").forward(request, response);
					return;
				}
			}
		} 
		
	}
}
