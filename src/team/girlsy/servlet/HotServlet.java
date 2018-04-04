package team.girlsy.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import team.girlsy.bean.Custom;
import team.girlsy.bean.Goods;
import team.girlsy.bean.OrderDetail;
import team.girlsy.bean.OrderList;
import team.girlsy.dao.GoodsDao;
import team.girlsy.dao.OrderDetailDao;
import team.girlsy.dao.OrderListDao;
import team.girlsy.dao.ShoppingCarDao;
import team.girlsy.dao.impl.GoodsDaoImpl;
import team.girlsy.dao.impl.OrderDetailDaoImpl;
import team.girlsy.dao.impl.OrderListDaoImpl;
import team.girlsy.dao.impl.ShoppingCarDaoImpl;

public class HotServlet extends HttpServlet {
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		GoodsDao goodsDao = new GoodsDaoImpl();
		HttpSession session = req.getSession();
		//推荐商品
		List<Goods> list1 = goodsDao.getGoodsByStorage();
		String[][] imgs1 = getImgs(list1);
		session.setAttribute("first_hot", list1);
		session.setAttribute("first_hot_imgs", imgs1);
		//打折商品
		List<Goods> list2 = goodsDao.getGoodsByDisc();
		String[][] imgs2= getImgs(list2);
		session.setAttribute("second_hot", list2);
		session.setAttribute("second_hot_imgs", imgs2);
		//热销商品
		List<Goods> list3 = goodsDao.getGoodsBySellCount();
		String[][] imgs3 = getImgs(list3);
		session.setAttribute("third_hot", list3);
		session.setAttribute("third_hot_imgs", imgs3);
		//购物车数量和历史订单
		if (null != session.getAttribute("custom")&&null!=session.getAttribute("loginState")) {
			if ("true".equals(session.getAttribute("loginState"))&&"custom".equals(session.getAttribute("role"))) {
				ServletContext application = this.getServletContext();
				ShoppingCarDao shoppingCarDao = new ShoppingCarDaoImpl();
				Custom custom1 = (Custom)session.getAttribute("custom");
				int id = custom1.getId();
				int CarCnt=shoppingCarDao.getNumShoppingCarById(id);
				session.setAttribute("CarCnt",CarCnt);	
				
				OrderDetailDao orderDetailDao = new OrderDetailDaoImpl();
				List<OrderDetail> orderDetails= orderDetailDao.getOrderDetailByCusId(custom1.getId());
				session.setAttribute("orderDetails", orderDetails);
			}	
		}
		
		
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		this.doPost(req, resp);
	}
	
	public String[][] getImgs(List<Goods> list) {
		
		//获取每个商品
		Goods g = new Goods();
		String arr[][] = new String[6][15];
		for(int i = 0; i < 6; i++) {
			g = list.get(i);
			//images//product_add/9__1__.jpg images//product_add/9__2__.jpg images//product_add/9__3__.jpg images//product_add/9__4__.jpg images//product_add/9__5__.jpg images//product_add/9__6__.jpg images//product_add/9__7__.jpg images//product_add/9__8__.jpg images//product_add/9__9__.jpg images//product_add/9__10__.jpg images//product_add/9__11__.jpg images//product_add/9__12__.jpg images//product_add/9__13__.jpg images//product_add/9__14__.jpg images//product_add/9__15__.jpg
			String imgs[] = g.getImg().split(" ");
			for(int j = 0; j < 15; j++) {
				arr[i][j] = imgs[j]; 
			}
		}
		return arr;
	}
}
