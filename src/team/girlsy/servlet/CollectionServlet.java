package team.girlsy.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import team.girlsy.bean.Admin;
import team.girlsy.bean.Collection;
import team.girlsy.bean.Custom;
import team.girlsy.bean.Goods;
import team.girlsy.bean.ShoppingCar;
import team.girlsy.dao.CollectionDao;
import team.girlsy.dao.ShoppingCarDao;
import team.girlsy.dao.impl.CollectionDaoImpl;
import team.girlsy.service.CollectService;
import team.girlsy.service.impl.CollectServiceImpl;

public class CollectionServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		CollectionDao collectionDao = new CollectionDaoImpl();
		CollectService collectService = new CollectServiceImpl();
		if ("true".equals(session.getAttribute("loginState"))) {
			if (null!=request.getParameter("op")) {
				if ("del".equals(request.getParameter("op"))) {
					collectionDao.delCollection(Integer.parseInt(request.getParameter("colId")));
					int id=getUserId(request, response);
					List<Collection> collections = collectionDao.getAllCollection(id);
					session.setAttribute("collections", collections);
					request.getRequestDispatcher("collect.jsp").forward(request, response);
					return;
				}
				if ("sea".equals(request.getParameter("op"))) {
					String typeID = request.getParameter("type");
					String type = collectService.changeIdToChinese(typeID);
					int id=getUserId(request, response);
					List<Collection> collections = collectionDao.getCollectionByType(id, type);
					session.setAttribute("collections", collections);
					request.getRequestDispatcher("collect.jsp").forward(request, response);
					return;
				}
				//从商品搜索search_list.jsp传过来的增加商品
				if ("add".equals(request.getParameter("op"))&&null != request.getParameter("searchGoodId")) {
					int goodsId = Integer.parseInt(request.getParameter("searchGoodId"));
					int id=getUserId(request, response);
					//判断收藏夹里面是不是有这个商品
					int fid = collectionDao.checkCustomHaveIt(id, goodsId);
					if (0==fid) {
						if (1==collectionDao.addCollection(id, goodsId)) {
							request.setAttribute("addFlag", "addCollection");
						}else {
							request.setAttribute("addFlag", "fail");
						}
					}else {
						request.setAttribute("addFlag", "alreadyIn");
					}
					
					request.getRequestDispatcher("search_list.jsp").forward(request, response);
					return;
				}
				//从商品详情goods_detail.jsp传过来的增加商品
				else if ("add".equals(request.getParameter("op"))&&null != session.getAttribute("a_goods")) {
					Goods goods = (Goods)session.getAttribute("a_goods");
					int id=getUserId(request, response);
					//判断收藏夹里面是不是有这个商品
					int fid = collectionDao.checkCustomHaveIt(id, goods.getId());
					if (0==fid) {
						if (1==collectionDao.addCollection(id, goods.getId())) {
							request.setAttribute("addFlag", "addCollection");
						}else {
							request.setAttribute("addFlag", "fail");
						}
					}else {
						request.setAttribute("addFlag", "alreadyIn");
					}
					request.getRequestDispatcher("good_detail.jsp").forward(request, response);
					return;
				}
				
			}
			else {
				int id=getUserId(request, response);
				List<Collection> collections = collectionDao.getAllCollection(id);
				session.setAttribute("collections", collections);
				request.getRequestDispatcher("collect.jsp").forward(request, response);
				return;
			}
		}
	}
	
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
