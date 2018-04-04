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

import team.girlsy.bean.Custom;
import team.girlsy.bean.OrderDetail;
import team.girlsy.bean.OrderList;
import team.girlsy.bean.ShoppingCar;
import team.girlsy.dao.OrderDetailDao;
import team.girlsy.dao.OrderListDao;
import team.girlsy.dao.ShoppingCarDao;
import team.girlsy.dao.impl.OrderDetailDaoImpl;
import team.girlsy.dao.impl.OrderListDaoImpl;
import team.girlsy.dao.impl.ShoppingCarDaoImpl;
import team.girlsy.service.CustomService;
import team.girlsy.service.OrderService;
import team.girlsy.service.impl.CustomServiceImpl;
import team.girlsy.service.impl.OrderServiceImpl;

import java.util.Date;
import java.text.SimpleDateFormat;

public class MyOrderServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		OrderService orderService = new OrderServiceImpl();
		OrderListDao orderListDao = new OrderListDaoImpl();
		OrderDetailDao orderDetailDao=new OrderDetailDaoImpl();
		ShoppingCarDao shoppingCarDao=new ShoppingCarDaoImpl();
		OrderList orderList = new OrderList();
		HttpSession session = request.getSession();		 
		String operation = null;
		operation = request.getParameter("op").toString();
		int id=0;
		if (null != request.getParameter("op")&& "true".equals(session.getAttribute("loginState"))) {
			
			System.out.println(id);
			if ("del".equals(operation)) {
				//清空该行信息
				int delId = Integer.valueOf(request.getParameter("id").toString());
				orderListDao.delOrderList(delId);
				request.setAttribute("deleteFlag", "true");
				List<OrderList> orderLists = orderListDao.getOrderListByCusId(id);
				session.setAttribute("orderLists", orderLists);
				request.getRequestDispatcher("check-deal.jsp").forward(request, response);
				return;
			}else if ("searchByCusId".equals(operation)) {
					if ("custom".equals(session.getAttribute("role"))) {
					Custom custom= (Custom)session.getAttribute("custom");
					id = custom.getId();
					}
					//插入新订单
					List<ShoppingCar> shoppingCars=(List<ShoppingCar>)session.getAttribute("pickShoppingCars");
					int size=shoppingCars.size();
					SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
					String orderdate=df.format(new Date());
					String orderstate="已付款";
					OrderList orderList1=new OrderList();
					orderList1.setCusId(id);
					orderList1.setOrderDatetime(orderdate);
					orderList1.setOrderState(orderstate);
					int orderId=orderService.addOrder(orderList1).getId();
					for(int i=0;i<size;i++){
						int goodsId=shoppingCars.get(i).getGoods().getId();
						int goodsBuyNum=shoppingCars.get(i).getBuyNum();
						OrderDetail orderDetail=new OrderDetail();
						orderDetail.setOrder_id(orderId);
						orderDetail.setGoods_id(goodsId);
						orderDetail.setGoodNum(goodsBuyNum);
						orderDetailDao.addOrderDetail(orderDetail);
						shoppingCarDao.delShippingCarByGoodsId(goodsId);
						int CarCnt2=(Integer) session.getAttribute("CarCnt")-1;
						session.setAttribute("CarCnt",CarCnt2);	
					}
					//通过客户id查找订单
					List<OrderList> orderLists = orderListDao.getOrderListByCusId(id);
					session.setAttribute("orderLists", orderLists);
					request.getRequestDispatcher("check-deal.jsp").forward(request, response);
					
					return;} 
			else if("see".equals(operation)) {
				if ("custom".equals(session.getAttribute("role"))) {
					Custom custom= (Custom)session.getAttribute("custom");
					id = custom.getId();
					List<OrderList> orderLists = orderListDao.getOrderListByCusId(id);
					session.setAttribute("orderLists", orderLists);
					request.getRequestDispatcher("check-deal.jsp").forward(request, response);
					
					}
			}
		}
		}
	}
		
	

