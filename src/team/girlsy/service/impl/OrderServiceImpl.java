package team.girlsy.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import team.girlsy.bean.Custom;
import team.girlsy.bean.Goods;
import team.girlsy.bean.OrderDetail;
import team.girlsy.bean.OrderList;
import team.girlsy.bean.ShoppingCar;
import team.girlsy.dao.CustomDao;
import team.girlsy.dao.GoodsDao;
import team.girlsy.dao.OrderListDao;
import team.girlsy.dao.impl.CustomDaoImpl;
import team.girlsy.dao.impl.GoodsDaoImpl;
import team.girlsy.dao.impl.OrderListDaoImpl;
import team.girlsy.service.OrderService;
import team.girlsy.utils.BaseDao;

public class OrderServiceImpl implements OrderService{

	@Override
	public String searchOrderList(String orderState, String orderId) {
		if (null==orderId||"".equals(orderId)) {
			if (orderState.equals("订单状态")||orderState.equals("")) {
				return "all";
			}else {
				return "searchByState";
			}
		}else {
			return "searchByIdOrName";
		}		
	}

	@Override
	public double getTotalPrice(List<OrderDetail> orderDetails) {
		//List<Double> price = new ArrayList<Double>();
		//List<Integer> number = new ArrayList<Integer>();
		double totalPrice = 0;		
		for (OrderDetail o : orderDetails) {
			totalPrice += (o.getGoods().getPrice())*(o.getGoodNum());
		}
		return totalPrice;
	}

	@Override
	public String changStateType(String state) {
		if ("1".equals(state)) {
			return "已付款";
		} else if ("2".equals(state)) {
			return "已发货";
		}else {
			return "交易完成";
		}
	}

	@Override
	public List<OrderList> pageLimit(int whichPage,String state) {
		OrderListDao orderListDao = new OrderListDaoImpl();
		return orderListDao.getLimitOrderList(whichPage, state);
	}

	@Override
	public int nowPage(int whichPage,String state,String search,int beforePage,String byIdFlag) {
		
		int totalNum ;
		OrderListDao orderListDao = new OrderListDaoImpl();
		if (byIdFlag.equals("false")) {
			totalNum = orderListDao.getNumOrderListByState(state);
		}else {
			totalNum = orderListDao.getNumOrderListByIdOrName(search);
		}
		
		//余数
		int remainder = totalNum % 4 ;
		//最后一页
		int lastPage;
		if (0 == remainder) {
			lastPage = totalNum/4;
		}else {
			lastPage = totalNum/4 + 1;
		}
		if (whichPage<0||(whichPage*4-totalNum)>remainder) {
			whichPage=lastPage;
			return whichPage;
		}
		if (whichPage==0) {			
			if (++beforePage > lastPage) {
				return --beforePage;
			}else {
				return beforePage;
			}
		}
		return whichPage;
	}

	@Override
	public List<ShoppingCar> showPickOrder(int[] id, int[] num,int cusId) {
		List<ShoppingCar> shoppingCars = new ArrayList<ShoppingCar>();
		
		for (int i = 0; i < id.length; i++) {
			ShoppingCar shoppingCar = new ShoppingCar();
			//要先定义一个GoodsDao类获取商品的名称和单价
			GoodsDao goodsDao  = new GoodsDaoImpl();
			Goods goods = goodsDao.getGoodsById(id[i]);
			//购买数量
			shoppingCar.setBuyNum(num[i]);
			//小图地址
			String[] imgAddrs = goods.getImg().split(" ");
			String imgAddr = imgAddrs[0];
			goods.setImg(imgAddr);
			shoppingCar.setGoods(goods);
			//客户对象
			CustomDao customDao = new CustomDaoImpl();
			Custom custom = customDao.getCustomById(cusId);
			shoppingCar.setCustom(custom);
			shoppingCar.setId(1);
			shoppingCars.add(shoppingCar);
		}
		return shoppingCars;
	}
//返回订单编号
	@Override
	public OrderList addOrder(OrderList orderList) {
		String sql = "insert into order_list(cus_id,order_date,order_state) value(?,?,?)";
		String state = orderList.getOrderState();
		OrderListDao o=new OrderListDaoImpl();
		BaseDao.excuteUpdate(sql, orderList.getCusId(),orderList.getOrderDatetime(),orderList.getOrderState());
		String sql2 = "select * from order_list order by order_id desc limit 1";	
		List<Object> result = BaseDao.excuteQuery(sql2);
		for(Object x : result){
			Map<String, Object> map = (Map<String, Object>)x;
			OrderList ol = new OrderList();
			ol.setId(Integer.valueOf(map.get("order_id").toString()));
			ol.setCusId(Integer.valueOf(map.get("cus_id").toString()));
			ol.setOrderDatetime(map.get("order_date").toString());
			ol.setOrderState(map.get("order_state").toString());
			return ol;
		}
		return null;
	}


	
}
