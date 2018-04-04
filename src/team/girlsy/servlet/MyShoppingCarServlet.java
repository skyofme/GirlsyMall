package team.girlsy.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import team.girlsy.bean.Admin;
import team.girlsy.bean.Custom;
import team.girlsy.bean.Goods;
import team.girlsy.bean.ShoppingCar;
import team.girlsy.dao.ShoppingCarDao;
import team.girlsy.dao.impl.ShoppingCarDaoImpl;
import team.girlsy.service.ShoppingCarService;
import team.girlsy.service.impl.ShoppingCarServiceImpl;

public class MyShoppingCarServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//购买数量
		int buyNum;
		if (null != request.getParameter("buyNum")) {
			buyNum = Integer.valueOf(request.getParameter("buyNum")) ;
		}else {
			buyNum = 0;
		}
		int CarCnt1;
		HttpSession session = request.getSession();
		ShoppingCarDao shoppingCarDao = new  ShoppingCarDaoImpl();
		if (null != request.getParameter("op")&& "true".equals(session.getAttribute("loginState"))) {
			//删除商品
			if ("del".equals(request.getParameter("op"))) {
				shoppingCarDao.delShippingCar(Integer.parseInt(request.getParameter("carId")));
				CarCnt1=(Integer) session.getAttribute("CarCnt")-1;//购物车数量图标-1
				int id=getUserId(request, response);
				//刷新购物车重新传值
				List<ShoppingCar> shoppingCars = shoppingCarDao.getAllShoppingCars(id);
				session.setAttribute("shoppingCars", shoppingCars);
				session.setAttribute("CarCnt",CarCnt1);
				request.getRequestDispatcher("shopping-car.jsp").forward(request, response);
				return;
			}
			//根据不同商品类型查询商品
			if ("sea".equals(request.getParameter("op"))) {
				int id=getUserId(request, response);
				List<ShoppingCar> shoppingCars = shoppingCarDao.getAllShoppingCars(id);
				//根据类型显示商品
				if (null!=request.getParameter("type")) {
					ShoppingCarService shoppingCarService = new ShoppingCarServiceImpl();
					String typeID = request.getParameter("type");
					String type = shoppingCarService.changeIdToChinese(typeID);
					shoppingCars = shoppingCarDao.getShoppingCarsByType(id, type);
				}
				
				session.setAttribute("shoppingCars", shoppingCars);
				request.getRequestDispatcher("shopping-car.jsp").forward(request, response);
				return;
			}
		}
		//从两个界面点进来的增加商品
		if(null == request.getParameter("op")&& "true".equals(session.getAttribute("loginState"))){
			int id=getUserId(request, response);	
			//从商品搜索页传来的
			if (null != request.getParameter("searchGoodId")) {
				
				int goodsId = Integer.parseInt(request.getParameter("searchGoodId"));
				//增加到购物车或者改变购物车内商品的数量
				int gId=shoppingCarDao.checkCustomHaveIt(id,goodsId);
				if (gId==0) {
					shoppingCarDao.addShippingCar(id,goodsId,1);
					CarCnt1=(Integer) session.getAttribute("CarCnt")+1;
				}else {
					shoppingCarDao.updShippingCar(gId,1);
					CarCnt1=(Integer) session.getAttribute("CarCnt");
				}
				
				session.setAttribute("CarCnt",CarCnt1);	
				request.setAttribute("addFlag", "addShoppingCar");
				
				request.getRequestDispatcher("search_list.jsp").forward(request, response);
				return;
			}
			//从购物详情传过来
			else if (null != session.getAttribute("a_goods")) {
				Goods goods = (Goods)session.getAttribute("a_goods");
				//增加到购物车或者改变购物车内商品的数量
				int gId=shoppingCarDao.checkCustomHaveIt(id, goods.getId());
				if (gId==0) {
					shoppingCarDao.addShippingCar(id, goods.getId(),buyNum);
					CarCnt1=(Integer) session.getAttribute("CarCnt")+1;
				}else {
					shoppingCarDao.updShippingCar(gId,buyNum);
					CarCnt1=(Integer) session.getAttribute("CarCnt");
				}
				session.setAttribute("CarCnt",CarCnt1);	
				response.getWriter().println(CarCnt1);
				//request.setAttribute("addFlag", "addShoppingCar");
				
				//request.getRequestDispatcher("good_detail.jsp").forward(request, response);
				
				return;
			}
		}
	}
	
	//获取登录的人的ID
	public int getUserId(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		int id = -1;
		if ("admin".equals(session.getAttribute("role"))) {
			Admin admin = (Admin)session.getAttribute("admin");
			id = admin.getId();
		}
		if ("custom".equals(session.getAttribute("role"))) {
			Custom custom= (Custom)session.getAttribute("custom");
			id = custom.getId();
		}
		return id;
	}
	
}
