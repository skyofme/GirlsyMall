package team.girlsy.dao;

import java.util.List;

import team.girlsy.bean.OrderList;

public interface  OrderListDao {
	//添加订单
	public int addOrderList(OrderList orderList) ;
	//删除订单
	public int delOrderList(Integer orderId);
	//查询订单
	public List<OrderList> getOrderListByIdOrName(int whichPage,String search);
	//查询订单
	public List<OrderList> getOrderListByCusId(Integer cus_id);
	//查询所有订单
	public List<OrderList> getAllOrderList();
	//根据状态查询订单
	public List<OrderList> getOrderListByState(String state);
	//查询订单的数量
	public int getNumOrderListByState(String state);
	//查询订单的数量
	public int getNumOrderListByIdOrName(String search);
	//查询分页之后的订单
	public List<OrderList> getLimitOrderList(int whichPage,String state);

}
