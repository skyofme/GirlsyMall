package team.girlsy.dao.impl;

import java.security.interfaces.RSAKey;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.jsp.jstl.sql.Result;

import team.girlsy.bean.Custom;
import team.girlsy.bean.Goods;
import team.girlsy.bean.OrderList;
import team.girlsy.dao.OrderListDao;
import team.girlsy.utils.BaseDao;

public class OrderListDaoImpl implements OrderListDao{

	@Override
	public int addOrderList(OrderList orderList) {
		String sql = "insert into order_list(cus_id,order_date,order_state) value(?,?,?)";
		return BaseDao.excuteUpdate(sql, orderList.getCusId(),orderList.getOrderDatetime(),orderList.getOrderState());
	}

	@Override
	public int delOrderList(Integer orderId) {
		String sql = "delete from order_detail where order_id = ?";
		if (0 <= BaseDao.excuteUpdate(sql, orderId)) {
		   	//删除订单详情表中数据
			sql = "delete from order_list where order_id = ?";
			return BaseDao.excuteUpdate(sql, orderId);
		}
		return 0;
	}

	@Override
	public List<OrderList> getOrderListByIdOrName(int whichPage,String search) {
		String sql = "select * from order_list as o left join custom as c on o.cus_id=c.cus_id where o.order_id like ? or c.cus_name like ? ";
		sql += " limit "+(whichPage-1)*4 +",4";
		//String[] paras ={ order_id.toString()};
		List<OrderList> orderLists = new ArrayList<OrderList>();
		List<Object> result = BaseDao.excuteQuery(sql, search,"%"+search+"%");
		for(Object  x:result){
			Map<String, Object> map =  (Map<String, Object>)x;
			OrderList orderList = new OrderList();
			Custom custom = new Custom(Integer.valueOf(map.get("cus_id").toString()), map.get("cus_name").toString(), map.get("cus_pwd").toString(), map.get("cus_sex").toString(),map.get("cus_tel").toString(),map.get("cus_addr").toString());
			orderList.setId(Integer.valueOf(map.get("order_id").toString()));
			orderList.setCustom(custom);
			orderList.setCusId(Integer.valueOf(map.get("cus_id").toString()));
			orderList.setOrderDatetime(map.get("order_date").toString());
			orderList.setOrderState(map.get("order_state").toString());
			orderLists.add(orderList);
		}
		return orderLists;
	}
	
	@Override
	public List<OrderList> getOrderListByState(String state) {
		String sql = "select * from order_list as o left join custom as c on o.cus_id=c.cus_id where o.order_state = ?";
		//String[] paras ={state};
		List<Object> result = BaseDao.excuteQuery(sql, state);
		if (null != result) {
			List<OrderList> orderLists = new ArrayList<OrderList>();
			for(Object x : result){
				Map<String, Object> map = (Map<String, Object>)x;
				OrderList orderList = new OrderList();
				Custom custom = new Custom(Integer.valueOf(map.get("cus_id").toString()), map.get("cus_name").toString(), map.get("cus_pwd").toString(), map.get("cus_sex").toString(),map.get("cus_tel").toString(),map.get("cus_addr").toString());
				orderList.setId(Integer.valueOf(map.get("order_id").toString()));
				orderList.setCustom(custom);
				orderList.setCusId(Integer.valueOf(map.get("cus_id").toString()));
				orderList.setOrderDatetime(map.get("order_date").toString());
				orderList.setOrderState(map.get("order_state").toString());
				orderLists.add(orderList);
			}
			return orderLists;
		}
		return null;
	}

	@Override
	public List<OrderList> getAllOrderList() {
		String sql = "select * from order_list as o left join custom as c on o.cus_id=c.cus_id ";
		List<Object> result = BaseDao.excuteQuery(sql);
		List<OrderList> orderLists = new ArrayList<OrderList>();
		for(Object x : result){
			Map<String, Object> map = (Map<String, Object>)x;
			OrderList orderList = new OrderList();
			Custom custom = new Custom(Integer.valueOf(map.get("cus_id").toString()), map.get("cus_name").toString(), map.get("cus_pwd").toString(), map.get("cus_sex").toString(),map.get("cus_tel").toString(),map.get("cus_addr").toString());
			orderList.setId(Integer.valueOf(map.get("order_id").toString()));
			orderList.setCustom(custom);
			orderList.setCusId(Integer.valueOf(map.get("cus_id").toString()));
			orderList.setOrderDatetime(map.get("order_date").toString());
			orderList.setOrderState(map.get("order_state").toString());
			orderLists.add(orderList);
		}
		return orderLists;
	}

	@Override
	public int getNumOrderListByState(String state) {
		String sql = "select count(*) as num from order_list where order_state like ?";
		//String[] para = {state+"%"};
		List<Object> result = BaseDao.excuteQuery(sql, state+"%");
		for(Object  x:result){
			Map<String, Object> map =  (Map<String, Object>)x;
			int num = Integer.valueOf((map.get("num").toString()));
			return num;
		}
		return 0;
	}

	@Override
	public List<OrderList> getLimitOrderList(int whichPage,String state) {
		String sql = "select * from order_list as o left join custom as c on o.cus_id=c.cus_id where o.order_state like ? ";
		sql += " limit "+(whichPage-1)*4 +",4";
		//String[] paras ={state+"%"};
		List<Object> result = BaseDao.excuteQuery(sql, state+"%");
		if (null != result) {
			List<OrderList> orderLists = new ArrayList<OrderList>();
			for(Object x : result){
				Map<String, Object> map = (Map<String, Object>)x;
				OrderList orderList = new OrderList();
				Custom custom = new Custom(Integer.valueOf(map.get("cus_id").toString()), map.get("cus_name").toString(), map.get("cus_pwd").toString(), map.get("cus_sex").toString(),map.get("cus_tel").toString(),map.get("cus_addr").toString());
				orderList.setId(Integer.valueOf(map.get("order_id").toString()));
				orderList.setCustom(custom);
				orderList.setCusId(Integer.valueOf(map.get("cus_id").toString()));
				orderList.setOrderDatetime(map.get("order_date").toString());
				orderList.setOrderState(map.get("order_state").toString());
				orderLists.add(orderList);
			}
			return orderLists;
		}
		return null;
	}

	@Override
	public List<OrderList> getOrderListByCusId(Integer cus_id) {
		String sql = "select * from order_list as o left join custom as c on o.cus_id=c.cus_id where o.cus_id = ?";
		List<Object> result = BaseDao.excuteQuery(sql, cus_id);
		List<OrderList> orderLists = new ArrayList<OrderList>();
		for(Object x : result){
			Map<String, Object> map = (Map<String, Object>)x;
			OrderList orderList = new OrderList();
			Custom custom = new Custom(Integer.valueOf(map.get("cus_id").toString()), map.get("cus_name").toString(), map.get("cus_pwd").toString(), map.get("cus_sex").toString(),map.get("cus_tel").toString(),map.get("cus_addr").toString());
			orderList.setId(Integer.valueOf(map.get("order_id").toString()));
			orderList.setCustom(custom);
			orderList.setCusId(Integer.valueOf(map.get("cus_id").toString()));
			orderList.setOrderDatetime(map.get("order_date").toString());
			orderList.setOrderState(map.get("order_state").toString());
			orderLists.add(orderList);
		}
		return orderLists;
	}

	@Override
	public int getNumOrderListByIdOrName(String search) {
		String sql = "select count(*) as num from order_list as o left join custom as c on o.cus_id=c.cus_id where o.order_id like ? or c.cus_name like ?";
		//String[] para = {state+"%"};
		List<Object> result = BaseDao.excuteQuery(sql, "%"+search+"%","%"+search+"%");
		for(Object  x:result){
			Map<String, Object> map =  (Map<String, Object>)x;
			int num = Integer.valueOf((map.get("num").toString()));
			return num;
		}
		return 0;
	}
}
