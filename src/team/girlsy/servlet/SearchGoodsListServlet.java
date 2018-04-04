package team.girlsy.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.fabric.xmlrpc.base.Array;

import team.girlsy.bean.Goods;
import team.girlsy.dao.GoodsDao;
import team.girlsy.dao.impl.GoodsDaoImpl;

public class SearchGoodsListServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//找到了符合搜索条件的LIST集合了
		String searchName = "";		
		if (null != request.getParameter("searchName")) {
			searchName =  request.getParameter("searchName");
		}
		GoodsDaoImpl goodsDao = new GoodsDaoImpl();
		List<Goods> goods = goodsDao.findAllList(searchName);
		
		//发送到下一个JSP中
		HttpSession session = request.getSession();
		session.setAttribute("searchGoods", goods);
		
		//跳转
		request.getRequestDispatcher("search_list.jsp").forward(request, response);
		
	}
}
