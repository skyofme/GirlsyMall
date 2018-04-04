package team.girlsy.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.Application;

import team.girlsy.bean.Goods;
import team.girlsy.service.GoodsService;
import team.girlsy.service.impl.GoodsServiceImpl;


public class GoodsSearch extends HttpServlet{

	public void doPost(HttpServletRequest req,HttpServletResponse resp) throws IOException, ServletException{
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");		
		HttpSession session = req.getSession();	
		GoodsService service = new GoodsServiceImpl();
		String operation = req.getParameter("op");
		if("del".equals(operation)){
			
			}
		 else if("drop".equals(operation)){
			Goods goods = new Goods();
			goods.setId(Integer.valueOf(req.getParameter("id")));
			session.setAttribute("msg",service.dropGoods(goods));
			resp.sendRedirect("GoodsSearch");
			}
		else {
			String search=req.getParameter("search");
			List<Goods>  goods = service.findAllList(search);
			req.setAttribute("goods", goods);
			req.getRequestDispatcher("/product_delete.jsp").forward(req, resp);
			}
		
	}

		
	public void doGet(HttpServletRequest req,HttpServletResponse resp) throws IOException, ServletException{
		this.doPost(req, resp);
	}
	

}
