package team.girlsy.servlet;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.Application;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import team.girlsy.bean.Goods;
import team.girlsy.dao.GoodsDao;
import team.girlsy.dao.impl.GoodsDaoImpl;
import team.girlsy.service.GoodsService;
import team.girlsy.service.impl.GoodsServiceImpl;


public class AllGoods extends HttpServlet{
	//将文件上传到该路径路径
	private static final String UPLOAD_DIRECTORY = "images//product_add";
	//上传配置
	//上传时的临时空间的大小
	private static final int MERORY_THRESHOLD = 1024*1024*10;//3MB
	//文件上传时的大小
	private static final int MAX_FILE_SIZE = 1024*1024*40;//40MB
	//上传请求的大小
	private static final int MAX_REQUEST_SIZE = 1024*1024*60;//50MB
	int pageSize = 5;
	public void doPost(HttpServletRequest req,HttpServletResponse resp) throws IOException, ServletException{
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");		
		HttpSession session = req.getSession();	
		GoodsService service = new GoodsServiceImpl();
		
		String operation = req.getParameter("op");
		if("getOne".equals(operation)){
			int goodsid = Integer.valueOf(req.getParameter("id"));
			Goods good = service.getGoodsById(goodsid);
			req.setAttribute("good", good);
			req.getRequestDispatcher("/product_change.jsp").forward(req, resp);
			
		}
		else if("upd".equals(operation)){
			Goods goods=new Goods();
			goods.setId(Integer.valueOf(req.getParameter("id")));
			goods.setName(req.getParameter("name"));
			goods.setStorage(Integer.valueOf(req.getParameter("storage")));
			goods.setPrice(Double.valueOf(req.getParameter("price")));
			goods.setDiscount(Float.valueOf(req.getParameter("discount")));
			session.setAttribute("msg",service.modifyGoods(goods));
			resp.sendRedirect("AllGoods");
			}
		else if("add".equals(operation)){
			System.out.println("进入商品添加");
			//判断是否是上传文件的操作
			if(!ServletFileUpload.isMultipartContent(req)){
				System.out.println("没有进行图片上传");
				req.setAttribute("message", "你这个不是上传文件的操作");
				req.getRequestDispatcher("/product_add.jsp").forward(req, resp);
			}else{
				System.out.println("进入图片上传");
				//配置上传参数
				DiskFileItemFactory factory = new DiskFileItemFactory();
				//设置内存临界值-如果超过后将产生临时文件并存储到临时目录中
				factory.setSizeThreshold(MERORY_THRESHOLD);
				//设置临时存储文件的目录
				System.out.println(System.getProperty("java.io.tmpdir"));
				factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
				
				ServletFileUpload upload = new ServletFileUpload(factory);
				
				//设置最大文件上传值
				upload.setFileSizeMax(MAX_FILE_SIZE);
				//设置最大请求值(包含表单数据和文件)
				upload.setSizeMax(MAX_REQUEST_SIZE);
				
				upload.setHeaderEncoding("UTF-8");
				
				//构造临时路径来存储上传的文件
				String uploadPath = req.getServletContext().getRealPath("") + File.separator + UPLOAD_DIRECTORY;
				
				File uploadDir = new File(uploadPath);
				//如果目录不存在则创建
				if(!uploadDir.exists()){
					System.out.println("创建文件夹");
					uploadDir.mkdir();
				}
				
				try {
					List<FileItem> formItems = upload.parseRequest(req);
					if(formItems != null && formItems.size() > 0){
						Goods goods = new Goods();
						Goods MaxIdGoods = new Goods();
						GoodsDao gd = new GoodsDaoImpl();
						//商品图片路径
						String imgs = "";
						//查询id最大的商品
						MaxIdGoods = gd.getGoodsByMaxId();
						int i = 0;
						for(FileItem item : formItems){
							//获取文件表单
							if(!item.isFormField()){
								String fileName = new File(item.getName()).getName();
								String filePath = uploadPath + File.separator + fileName;
								//更名操作
								i++;
								File storeFile = new File(filePath);
								//将图片路径写入数据库,解决中文error,解决id+序号命名
								imgs += new String((UPLOAD_DIRECTORY + "//" + (MaxIdGoods.getId()+1) + "__" + i + "__" + ".jpg" + " ").getBytes("ISO-8859-1"),"UTF-8");
								System.out.println("存入数据库===》" + (UPLOAD_DIRECTORY + "\\" + (MaxIdGoods.getId()+1) + "__" + i + "__" + ".jpg" + " "));
								item.write(storeFile);
								storeFile.renameTo(new File(uploadPath + File.separator + (MaxIdGoods.getId()+1) + "__" + i + "__" + ".jpg"));
								System.out.println("更名后===》" + uploadPath + File.separator + (MaxIdGoods.getId()+1) + "__" + i + "__" + ".jpg");
								System.out.println(storeFile);
								req.setAttribute("message","文件上传成功！");
								System.out.println("文件上传成功" + fileName);
							}else{
								//获取普通表单
								if(item.getFieldName().equals("goodsName")) {
									goods.setName(new String(item.getString().getBytes("ISO-8859-1"),"UTF-8"));
								}else if(item.getFieldName().equals("goodsStorage")) {
									goods.setStorage(Integer.valueOf(item.getString()));
								}else if(item.getFieldName().equals("goodsPrice")) {
									goods.setPrice(Double.valueOf(item.getString()));
								}else if(item.getFieldName().equals("goodsKinds")) {
									//解决中文问题
									goods.setType(new String(item.getString().getBytes("ISO-8859-1"),"UTF-8"));
								}else if(item.getFieldName().equals("goodsDiscount")) {
									goods.setDiscount(Float.valueOf(item.getString()));
								}else if(item.getFieldName().equals("goodsDesc")) {
									goods.setDesc(new String(item.getString().getBytes("ISO-8859-1"),"UTF-8"));
								}
								goods.setSellCount(0);
								//System.out.println(item.getFieldName());
								//System.out.println(new String(item.getString().getBytes("ISO-8859-1"),"UTF-8"));
							}
						}
						goods.setImg(imgs);
						session.setAttribute("msg", service.addGoods(goods));
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			resp.sendRedirect("AllGoods");
		}
		else if("getOne".equals(operation)){
			String search=req.getParameter("search");
			List<Goods>  goods = service.findAllList(search);
			
			List<Goods> listType = service.findGoodsType();
			req.setAttribute("listType", listType);
			req.setAttribute("goods", goods);
			req.getRequestDispatcher("/product_delete.jsp").forward(req, resp);
			}
		else if("getList".equals(operation)){
				int pageNow=1;
				String goodsType = req.getParameter("goodsType");
				String search = req.getParameter("search");
				List<Goods> goods = new ArrayList<Goods>();
				
				if("searchBysearch".equals(service.searchGoodsList(goodsType, search))||"all".equals(service.searchGoodsList(goodsType, search))){
					goods = service.findSomeGoods(search,pageNow,pageSize);
					try {
						int pageCnt = GoodsDaoImpl.queryPageCnt(search,pageSize);
						if(goods.size()==0){
							pageCnt=1;
						}
						req.setAttribute("pageCnt", pageCnt);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else if("searchBygoodsType".equals(service.searchGoodsList(goodsType, search))){
					goods = service.getGoodsByState(goodsType,pageNow, pageSize);
					int pageCnt;
					try {
						pageCnt = GoodsDaoImpl.queryPageCnt2(goodsType,pageSize);
						if(goods.size()==0){
							pageCnt=1;
						}
						req.setAttribute("pageCnt", pageCnt);	
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else{
					goods = service.findSomeGoods(search,pageNow,pageSize,goodsType);
					int pageCnt = 1;
					try {
						pageCnt = GoodsDaoImpl.queryPageCnt(search,pageSize,goodsType);
						if(goods.size()==0){
							pageCnt=1;
						}
						req.setAttribute("pageCnt", pageCnt);	
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				List<Goods> listType = service.findGoodsType();
				req.setAttribute("goodsType", goodsType);
				req.setAttribute("listType", listType);
				req.setAttribute("goods", goods);
				req.setAttribute("pageNow", pageNow);
				req.getRequestDispatcher("/product_check.jsp").forward(req, resp);
			}
		
		else if("getPage".equals(operation)){
			String isPageNow=req.getParameter("pageNow");
			 int pageNow=1;
			 String listStyle2 = req.getParameter("option");
			 List<Goods> goods = new ArrayList<Goods>();
				 if(isPageNow!=null&&isPageNow.length()>0){
					 pageNow=Integer.parseInt(isPageNow);//类型转换
					 if(pageNow<1){
						 pageNow = 1;
					 }
				 }	
			String search = req.getParameter("search");
			 if(null==listStyle2||"".equals(listStyle2)||"商品类型".equals(listStyle2)){
			try {
				int pageCnt = GoodsDaoImpl.queryPageCnt(search,pageSize);
				
				req.setAttribute("pageCnt", pageCnt);
				if(pageNow>=pageCnt){
					pageNow = pageCnt;
				}
				if((!"".equals(req.getParameter("searchPageNum")))&&"true".equals(req.getParameter("skip"))){
					if(Integer.parseInt(req.getParameter("searchPageNum"))>0&&Integer.parseInt(req.getParameter("searchPageNum"))<=pageCnt){
						pageNow = Integer.parseInt(req.getParameter("searchPageNum"));
					}
				}else if("".equals(req.getParameter("searchPageNum"))&&"true".equals(req.getParameter("skip"))){
					pageNow = 1;
				}else{}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			goods = service.findSomeGoods(search,pageNow,pageSize);
			 }else {
				 int pageCnt  = 1;
				 try {
					 pageCnt = GoodsDaoImpl.queryPageCnt(search,pageSize,listStyle2);
					if(pageNow>=pageCnt){
						pageNow = pageCnt;
						if(pageCnt==0){
							pageNow=1;
						}
					}
					if((!"".equals(req.getParameter("searchPageNum")))&&"true".equals(req.getParameter("skip"))){
						if(Integer.parseInt(req.getParameter("searchPageNum"))>0&&Integer.parseInt(req.getParameter("searchPageNum"))<=pageCnt){
							pageNow = Integer.parseInt(req.getParameter("searchPageNum"));
						}
					}else if("".equals(req.getParameter("searchPageNum"))&&"true".equals(req.getParameter("skip"))){
						pageNow = 1;
					}else{}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 goods = service.findSomeGoods(search,pageNow,pageSize,listStyle2);
				 if(goods.size()==0){
					 pageCnt=1;
				 }
				 req.setAttribute("pageCnt", pageCnt);
			 }
			List<Goods> listType = service.findGoodsType();
			req.setAttribute("listType", listType);
			req.setAttribute("goods", goods);
			req.setAttribute("pageNow", pageNow);
			req.setAttribute("goodsType", listStyle2);
			req.getRequestDispatcher("/product_check.jsp").forward(req, resp);
			}
		else {
				int pageNow=1;
				int pageCnt;
				try {
					pageCnt = GoodsDaoImpl.queryPageCnt(null,pageSize);
					req.setAttribute("pageCnt", pageCnt);
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				List<Goods> goods = service.findSomeGoods(null,pageNow,pageSize);
				
				List<Goods> listType = service.findGoodsType();
				req.setAttribute("listType", listType);
				
				req.setAttribute("goods", goods);
				req.setAttribute("pageNow", pageNow);
				req.getRequestDispatcher("/product_check.jsp").forward(req, resp);
			}
	}
		
	public void doGet(HttpServletRequest req,HttpServletResponse resp) throws IOException, ServletException{
		this.doPost(req, resp);
	}
	

}
