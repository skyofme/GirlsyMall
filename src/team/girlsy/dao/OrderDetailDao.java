package team.girlsy.dao;

import java.util.List;

import team.girlsy.bean.OrderDetail;

public interface OrderDetailDao {
	//查询订单
	public List<OrderDetail> getOrderDetailById(Integer order_id);	
	//添加订单
    public int addOrderDetail(OrderDetail OrderDetail) ;
	//修改订单状态
	public int modifyOrderState(String state,Integer order_id);
	//根据客户Id查询订单
	public List<OrderDetail> getOrderDetailByCusId(Integer cus_id);
} 
