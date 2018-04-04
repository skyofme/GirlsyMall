package team.girlsy.service;

import java.util.List;

import team.girlsy.bean.Custom;
import team.girlsy.bean.OrderDetail;
import team.girlsy.bean.OrderList;
import team.girlsy.bean.ShoppingCar;

public interface OrderService {
	//查询订单
	public  String searchOrderList(String orderState,String orderId);
	//获得订单总价
	public double getTotalPrice(List<OrderDetail> orderDetails);
	//把传来的订单状态改成String类型
	public String changStateType(String state);
	//分页功能
	public List<OrderList> pageLimit(int whichPage,String state);
	//不记录数据库只是显示勾选订单
	public List<ShoppingCar> showPickOrder(int[] id,int[] num,int cusId);
	//现在是哪一页
	public int nowPage(int whichPage,String state,String search,int beforePage,String byIdFlag);
	//添加顾客 返回顾客id
    public  OrderList addOrder(OrderList orderList);
}
