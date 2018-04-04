package team.girlsy.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import team.girlsy.bean.Goods;
import team.girlsy.dao.GoodsDao;
import team.girlsy.dao.impl.GoodsDaoImpl;

public class ShoppingCarServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		HttpSession session = req.getSession();
		GoodsDao goodsDao = new GoodsDaoImpl();
		Goods goods = new Goods();
		int goodsId = Integer.parseInt(req.getParameter("goodsId"));
		goods = goodsDao.getGoodsById(goodsId);
		
		//看了又看图片地址
		List<Goods> moreGoods = goodsDao.getThreeGoodsByType(goods.getType(),goods.getId());
		session.setAttribute("moreGoods", moreGoods);
		
		session.setAttribute("a_goods", goods);
		//图片地址
		String[] imgsArry = goods.getImg().split(" ");
		session.setAttribute("p1", imgsArry[0]);
		session.setAttribute("p2", imgsArry[1]);
		session.setAttribute("p3", imgsArry[2]);
		session.setAttribute("p4", imgsArry[3]);
		session.setAttribute("p5", imgsArry[4]);
		session.setAttribute("p6", imgsArry[5]);
		session.setAttribute("p7", imgsArry[6]);
		session.setAttribute("p8", imgsArry[7]);
		session.setAttribute("p9", imgsArry[8]);
		session.setAttribute("p10", imgsArry[9]);
		session.setAttribute("p11", imgsArry[10]);
		session.setAttribute("p13", imgsArry[12]);
		session.setAttribute("p14", imgsArry[13]);
		session.setAttribute("p15", imgsArry[14]);
		
		req.getRequestDispatcher("good_detail.jsp").forward(req, resp);
		
	}
	
	

}
