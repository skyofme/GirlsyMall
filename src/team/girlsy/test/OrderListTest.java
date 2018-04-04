package team.girlsy.test;

import org.junit.Test;

import team.girlsy.dao.OrderDetailDao;
import team.girlsy.dao.OrderListDao;
import team.girlsy.dao.impl.OrderDetailDaoImpl;
import team.girlsy.dao.impl.OrderListDaoImpl;
import team.girlsy.service.OrderService;
import team.girlsy.service.impl.OrderServiceImpl;

public class OrderListTest {
	
	@Test
	public void getOrderListByTime(){
		OrderListDao orderListDao = new OrderListDaoImpl();
		if (null!=(orderListDao.getOrderListByState("已发货"))) {
			System.out.println("1");
		}
	}
	
	@Test
	public void getAllOrderList(){
		OrderListDao orderListDao = new OrderListDaoImpl();
		if (null!=(orderListDao.getAllOrderList())) {
			System.out.println("1");
		}
	}
	
	@Test
	public void delectOrderList(){
		OrderListDao orderListDao = new OrderListDaoImpl();
		if (1==(orderListDao.delOrderList(1))) {
			System.out.println("1");

		}
	}
	
	@Test
	public void updateOrderState(){
		OrderDetailDao orderDetailDao = new OrderDetailDaoImpl();
		if (1==orderDetailDao.modifyOrderState("AAAA", 2)) {
			System.out.println("1");
		}
	}
	
	@Test
	public void searchOrderDetailById(){
		OrderDetailDao orderDetailDao = new OrderDetailDaoImpl();
		if (null!=(orderDetailDao.getOrderDetailById(7))) {
			System.out.println("1");
		}
		
	}
	
	@Test
	public void getNumOrderListByState(){
		OrderListDao orderListDao = new OrderListDaoImpl();
		System.out.println(orderListDao.getNumOrderListByState("交易完成"));
	}
	
	@Test
	public void getLimitOrderList(){
		OrderListDao orderListDao = new OrderListDaoImpl();
		if (null!=(orderListDao.getLimitOrderList(3, ""))) {
			System.out.println("1");
		}
	}
	
	@Test
	public void pageLimit(){
		OrderService orderService = new OrderServiceImpl();
		if (null!=(orderService.pageLimit(2, ""))) {
			System.out.println("1");
		}
	}
	
	@Test
	public void getOrderDetailByCusId(){
		OrderDetailDao orderDetailDao = new OrderDetailDaoImpl();
		if (null!=(orderDetailDao.getOrderDetailByCusId(6))) {
			System.out.println("1");
		}
		
	}
	
}
