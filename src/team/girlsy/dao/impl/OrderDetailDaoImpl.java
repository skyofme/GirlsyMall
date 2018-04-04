package team.girlsy.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.jsp.jstl.sql.Result;

import team.girlsy.bean.Custom;
import team.girlsy.bean.Goods;
import team.girlsy.bean.OrderDetail;
import team.girlsy.bean.OrderList;
import team.girlsy.dao.OrderDetailDao;
import team.girlsy.utils.BaseDao;

public class OrderDetailDaoImpl implements OrderDetailDao{

	@Override
	public List<OrderDetail> getOrderDetailById(Integer order_id) {
		
		List<OrderDetail> OrderDetails = new ArrayList<OrderDetail>();
		String cusId;
		String detailId;
		
		//获取订单详情和订单的结果集
		String sql = "select * from order_detail as o left join order_list as c on o.order_id=c.order_id where o.order_id = ?";
		//String[] paras ={order_id.toString()};
		List<Object> resultDL = BaseDao.excuteQuery(sql, order_id);
		
		if (null != resultDL) {
			for(Object x : resultDL){
				OrderDetail OrderDetail = new OrderDetail();
				Map<String, Object> map = (Map<String, Object>)x;
				Custom custom = new Custom();
				Goods goods = new Goods();
				//获取客户ID
				cusId =(map.get("cus_id").toString());
				//初始化custom对象
				String sql1 = "select * from order_list as o inner join custom as c on o.cus_id=c.cus_id where o.cus_id = ?";
				//String[] paras1 = {cusId};
				List<Object> resultCL = BaseDao.excuteQuery(sql1, cusId);
				if (null != resultCL) {
					List<OrderList> orderLists = new ArrayList<OrderList>();
					for(Object x1 : resultCL){
						Map<String, Object> map1 = (Map<String, Object>)x1;
						custom = new Custom(Integer.valueOf(map1.get("cus_id").toString()), map1.get("cus_name").toString(), map1.get("cus_pwd").toString(), map1.get("cus_sex").toString(),map1.get("cus_tel").toString(),map1.get("cus_addr").toString());
					}
			    }
				OrderDetail.setCustom(custom);
				//获取订单详情ID
				detailId = (map.get("detail_id").toString());
				//初始化goods对象
				String sql2 = "select * from order_detail as o inner join goods as g on o.goods_id = g.goods_id where o.detail_id = ?";
				//String[] paras2 = {detailId};
				List<Object> resultDG = BaseDao.excuteQuery(sql2, detailId);
				if (null != resultDG) {
					List<OrderList> orderLists = new ArrayList<OrderList>();
					for(Object x1 : resultDG){
						Map<String, Object> map1 = (Map<String, Object>)x1;
						if (null == map1.get("goods_desc")||null == map1.get("goods_img")) {
							goods = new Goods(Integer.valueOf(map1.get("goods_id").toString()), map1.get("goods_name").toString(), Integer.valueOf(map1.get("goods_storage").toString()), Double.valueOf(map1.get("goods_price").toString()),Float.valueOf(map1.get("goods_discount").toString()), Integer.valueOf(map1.get("goods_sellCount").toString()), map1.get("goods_type").toString(), "","");
						}else {
							goods = new Goods(Integer.valueOf(map1.get("goods_id").toString()), map1.get("goods_name").toString(), Integer.valueOf(map1.get("goods_storage").toString()), Double.valueOf(map1.get("goods_price").toString()),Float.valueOf(map1.get("goods_discount").toString()), Integer.valueOf(map1.get("goods_sellCount").toString()), map1.get("goods_type").toString(), map1.get("goods_desc").toString(),map1.get("goods_img").toString());
						}
					}
			    }
				OrderDetail.setGoods(goods);
				//初始化OrderList对象
				OrderList orderList = new OrderList(Integer.valueOf(map.get("order_id").toString()), map.get("order_state").toString(), map.get("order_date").toString(), goods, custom, Integer.valueOf(map.get("cus_id").toString()));
				OrderDetail.setOrderList(orderList);
				//初始化其它对象
				OrderDetail.setDetail_id(Integer.valueOf(map.get("detail_id").toString()));
				OrderDetail.setGoodNum(Integer.valueOf(map.get("goods_buyNum").toString()));
				//添加到List里面
				OrderDetails.add(OrderDetail);
			}
			return OrderDetails;
		}
		return null;
	}

	@Override
	public int modifyOrderState(String state,Integer order_id) {
		String sql = "update order_list set order_state = ? where order_id = ?";
		//String[] paras = {state,order_id.toString()};
		return BaseDao.excuteUpdate(sql, state, order_id);
	}

	@Override
	public int addOrderDetail(OrderDetail OrderDetail) {
		// TODO Auto-generated method stub
		String sql = "insert into order_detail(order_id,goods_id,goods_buyNum) value(?,?,?)";
		return BaseDao.excuteUpdate(sql,OrderDetail.getOrder_id(),OrderDetail.getGoods_id(),OrderDetail.getGoodNum() );
	}

	@Override
	public List<OrderDetail> getOrderDetailByCusId(Integer cus_id) {
		String sql = "select * from order_detail as od inner join order_list as ol on od.order_id = ol.order_id inner join goods as g on od.goods_id = g.goods_id where ol.cus_id = ? order by detail_id desc";
		List<OrderDetail> orderDetails = new ArrayList<OrderDetail>();
		List<Object> result = BaseDao.excuteQuery(sql, cus_id+"");
		for (Object r : result) {
			Map<String, Object> map = (Map<String, Object>) r;
			OrderDetail orderDetail = new OrderDetail();
			Custom custom = new Custom();
			orderDetail.setCustom(custom);
			orderDetail.setDetail_id(Integer.parseInt(map.get("detail_id")+""));
			orderDetail.setGoodNum(Integer.parseInt(map.get("goods_buyNum")+""));
			
			String[] img = map.get("goods_imgs").toString().split(" ");
			Goods goods = new Goods(Integer.parseInt(map.get("goods_id")+""), map.get("goods_name")+"", Integer.parseInt(map.get("goods_storage")+""), Double.parseDouble(map.get("goods_price")+""), Float.parseFloat(map.get("goods_discount")+""), Integer.parseInt(map.get("goods_sellCount")+""), map.get("goods_type")+"", map.get("goods_desc")+"", img[0]);
			orderDetail.setGoods(goods);
			orderDetail.setGoods_id(Integer.parseInt(map.get("goods_id")+""));
			
			//初始化OrderList对象
			OrderList orderList = new OrderList(Integer.valueOf(map.get("order_id").toString()), map.get("order_state").toString(), map.get("order_date").toString(), goods, custom, Integer.valueOf(map.get("cus_id").toString()));
			orderDetail.setOrderList(orderList);
			orderDetail.setOrder_id(Integer.valueOf(map.get("order_id").toString()));
			
			orderDetails.add(orderDetail);
		}
		return orderDetails;
	}



	
}
