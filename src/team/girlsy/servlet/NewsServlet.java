package team.girlsy.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.Application;

import com.mysql.fabric.xmlrpc.base.Value;

public class NewsServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {		
		/*req.getParameter("new1");
		req.getParameter("new2");
		req.getParameter("new3");
		req.getParameter("new4");
		req.getParameter("new5");*/
		
		ServletContext application = this.getServletContext();//application的初始化
		/*application.setAttribute("new1", req.getParameter("new1"));
		application.setAttribute("new2", req.getParameter("new2"));
		application.setAttribute("new3", req.getParameter("new3"));
		application.setAttribute("new4", req.getParameter("new4"));
		application.setAttribute("new5", req.getParameter("new5"));
		req.getRequestDispatcher("index.jsp").forward(req, resp);*/	
		int iButton=0;
		if (req.getParameter("news1")!=null) {
			iButton=1;	
		}else if (req.getParameter("news2") != null) {  
            iButton = 2;  
        } else if (req.getParameter("news3") != null) {  
            iButton = 3;  
        } else if (req.getParameter("news4") != null) {  
            iButton = 4;  
        } else if (req.getParameter("news5") != null) {  
            iButton = 5; 
        }
        switch (iButton) {  
        case 0:                
            break;  
        case 1:               
        	application.setAttribute("new1", req.getParameter("new1"));
        	req.getRequestDispatcher("index.html").forward(req, resp);
            break;  
        case 2:  
        	application.setAttribute("new2", req.getParameter("new2"));
        	req.getRequestDispatcher("index.html").forward(req, resp);
            break;  
        case 3:  
        	application.setAttribute("new3", req.getParameter("new3"));
        	req.getRequestDispatcher("index.html").forward(req, resp);  
            break;  
        case 4:  
        	application.setAttribute("new4", req.getParameter("new4"));
        	req.getRequestDispatcher("index.html").forward(req, resp);  
            break;  
        case 5:  
        	application.setAttribute("new5", req.getParameter("new5"));
        	req.getRequestDispatcher("index.html").forward(req, resp); 
            break;  
        }  
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
