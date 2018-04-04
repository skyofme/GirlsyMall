package team.girlsy.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import team.girlsy.dao.impl.CustomDaoImpl;
import team.girlsy.bean.Custom;;

public class SearchCustom extends HttpServlet {
	private int pageSize=6;
	 public void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{ 
		 String search=req.getParameter("search");
		 String isPageNow=req.getParameter("pageNow");
		 int pageNow=1;
		 if(isPageNow!=null&&isPageNow.length()>0){
			 pageNow=Integer.parseInt(isPageNow);//类型转换
		 }		
		 try {
			int pageCnt=CustomDaoImpl.queryPageCnt(search, pageSize);
			req.setAttribute("pageCnt", pageCnt);
		 } catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		 }	
		 //保存
		 List<Custom> list;
		 try {
			list=CustomDaoImpl.search(search, pageNow, pageSize);
			for (Custom custom : list) {
				System.out.println(custom);
			}
			
			req.setAttribute("customs", list);
			//System.out.println(list);
		 } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		 }
		 req.setAttribute("pageNow",pageNow);
         req.getRequestDispatcher("user_list.jsp").forward(req, resp);
   	 //应该做检测，是否为空
   	 //伪代码    	 													
	 }
    public void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
   	 this.doPost(req, resp);
    }  
    public void init(ServletConfig config){
   	 String IsPageSize=config.getInitParameter("pageSize");
   	 if(IsPageSize!=null&&IsPageSize.length()>0){
        pageSize=Integer.parseInt(IsPageSize);
   	 }
    }
}
