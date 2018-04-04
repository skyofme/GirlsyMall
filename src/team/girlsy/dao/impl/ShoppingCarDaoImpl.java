package team.girlsy.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import team.girlsy.bean.Custom;
import team.girlsy.bean.Goods;
import team.girlsy.bean.ShoppingCar;
import team.girlsy.dao.ShoppingCarDao;
import team.girlsy.utils.BaseDao;

public class ShoppingCarDaoImpl implements ShoppingCarDao{

	private static final List<ShoppingCar> map1 = null;

	@Override
	public int delALLShippingCar(int cusID) {
		String sqlString = "delete from shopping_list where cus_id = ?";
		//String[] para = {cusID+""};
		if (0 <= BaseDao.excuteUpdate(sqlString, cusID)) {
			return 1;
		}
		return 0;
	}

	@Override
	public int delShippingCar(int carId) {
		String sqlString = "delete from shopping_list where g_id = ?";
		//String[] para = {carId+""};
		if (0 <= BaseDao.excuteUpdate(sqlString, carId)) {
			return 1;
		}
		return 0;
	}

	@Override
	public List<ShoppingCar> getShoppingCarsByType(int cusId,String type) {
		String sql = "select * from shopping_list as s left join goods as g on s.goods_id = g.goods_id left join custom as c on s.cus_id = c.cus_id where g.goods_type like ? and s.cus_id = ?";
		String[] para = {type+"%",cusId+""};
		List<Object> result = BaseDao.excuteQuery(sql, para);
		if (null != result) {
			List<ShoppingCar> ShoppingCars = new ArrayList<ShoppingCar>();
			for(Object x : result){
				Map<String, Object> map = (Map<String, Object>)x;
				ShoppingCar ShoppingCar = new ShoppingCar();
				//购买数量
				ShoppingCar.setBuyNum(Integer.valueOf(map.get("goods_buyNum").toString()));
				//客户对象
				Custom custom = new Custom(Integer.valueOf(map.get("cus_id").toString()), map.get("cus_name").toString(), map.get("cus_pwd").toString(), map.get("cus_sex").toString(),map.get("cus_tel").toString(),map.get("cus_addr").toString());
				ShoppingCar.setCustom(custom);
				//商品对象
				Goods goods = null;
				if (null == map.get("goods_imgs")) {
					goods = new Goods(Integer.valueOf(map.get("goods_id").toString()), map.get("goods_name").toString(), Integer.valueOf(map.get("goods_storage").toString()), Double.valueOf(map.get("goods_price").toString()),Float.valueOf(map.get("goods_discount").toString()), Integer.valueOf(map.get("goods_sellCount").toString()), map.get("goods_type").toString(), map.get("goods_img")+"","");
				}else {
					String[] arr = map.get("goods_imgs").toString().split(" ");
					goods = new Goods(Integer.valueOf(map.get("goods_id").toString()), map.get("goods_name").toString(), Integer.valueOf(map.get("goods_storage").toString()), Double.valueOf(map.get("goods_price").toString()),Float.valueOf(map.get("goods_discount").toString()), Integer.valueOf(map.get("goods_sellCount").toString()), map.get("goods_type").toString(), map.get("goods_desc").toString(),arr[0]);
				}		
				ShoppingCar.setGoods(goods);
				//购物车ID
				ShoppingCar.setId(Integer.valueOf(map.get("g_id").toString()));
				ShoppingCars.add(ShoppingCar);
			}
			return ShoppingCars;
		}
		return null;
	}
	@Override
	public List<ShoppingCar> getAllShoppingCars(int cusID) {
		String sql = "select * from shopping_list as s left join goods as g on s.goods_id = g.goods_id left join custom as c on s.cus_id = c.cus_id where s.cus_id = ?";
		//String[] paraStrings = {cusID+""};
		List<Object> result = BaseDao.excuteQuery(sql,cusID);
		if (null != result) {
			List<ShoppingCar> ShoppingCars = new ArrayList<ShoppingCar>();
			for(Object x : result){
				Map<String, Object> map = (Map<String, Object>)x;
				ShoppingCar ShoppingCar = new ShoppingCar();
				//购买数量
				ShoppingCar.setBuyNum(Integer.valueOf(map.get("goods_buyNum").toString()));
				//客户对象
				Custom custom = new Custom(Integer.valueOf(map.get("cus_id").toString()), map.get("cus_name").toString(), map.get("cus_pwd").toString(), map.get("cus_sex").toString(),map.get("cus_tel").toString(),map.get("cus_addr").toString());
				ShoppingCar.setCustom(custom);
				//商品对象
				Goods goods = null;
				if (null == map.get("goods_imgs")) {
					goods = new Goods(Integer.valueOf(map.get("goods_id").toString()), map.get("goods_name").toString(), Integer.valueOf(map.get("goods_storage").toString()), Double.valueOf(map.get("goods_price").toString()),Float.valueOf(map.get("goods_discount").toString()), Integer.valueOf(map.get("goods_sellCount").toString()), map.get("goods_type").toString(), map.get("goods_img")+"","");
				}else {
					String[] arr = map.get("goods_imgs").toString().split(" ");
					goods = new Goods(Integer.valueOf(map.get("goods_id").toString()), map.get("goods_name").toString(), Integer.valueOf(map.get("goods_storage").toString()), Double.valueOf(map.get("goods_price").toString()),Float.valueOf(map.get("goods_discount").toString()), Integer.valueOf(map.get("goods_sellCount").toString()), map.get("goods_type").toString(), map.get("goods_desc").toString(),arr[0]);
				}			
				ShoppingCar.setGoods(goods);
				//购物车ID
				ShoppingCar.setId(Integer.valueOf(map.get("g_id").toString()));
				ShoppingCars.add(ShoppingCar);
			}
			return ShoppingCars;
		}
		return null;
	}

	@Override
	public ShoppingCar getShoppingCarById(int carId) {
		String sqlString = "select * from shopping_list as s left join goods as g on s.goods_id = g.goods_id left join custom as c on s.cus_id = c.cus_id where g_id = ?";
		//String[] para = {carId+""};
		List<Object> result = BaseDao.excuteQuery(sqlString, carId);
		for(Object x : result){
			Map<String, Object> map = (Map<String, Object>)x;
			ShoppingCar ShoppingCar = new ShoppingCar();
			//购买数量
			ShoppingCar.setBuyNum(Integer.valueOf(map.get("goods_buyNum").toString()));
			//客户对象
			Custom custom = new Custom(Integer.valueOf(map.get("cus_id").toString()), map.get("cus_name").toString(), map.get("cus_pwd").toString(), map.get("cus_sex").toString(),map.get("cus_tel").toString(),map.get("cus_addr").toString());
			ShoppingCar.setCustom(custom);
			//商品对象
			Goods goods = null;
			if (null == map.get("goods_imgs")) {
				goods = new Goods(Integer.valueOf(map.get("goods_id").toString()), map.get("goods_name").toString(), Integer.valueOf(map.get("goods_storage").toString()), Double.valueOf(map.get("goods_price").toString()),Float.valueOf(map.get("goods_discount").toString()), Integer.valueOf(map.get("goods_sellCount").toString()), map.get("goods_type").toString(), map.get("goods_img")+"","");
			}else {
				String[] arr = map.get("goods_imgs").toString().split(" ");
				goods = new Goods(Integer.valueOf(map.get("goods_id").toString()), map.get("goods_name").toString(), Integer.valueOf(map.get("goods_storage").toString()), Double.valueOf(map.get("goods_price").toString()),Float.valueOf(map.get("goods_discount").toString()), Integer.valueOf(map.get("goods_sellCount").toString()), map.get("goods_type").toString(), map.get("goods_desc").toString(),arr[0]);
			}	
			ShoppingCar.setGoods(goods);
			//购物车ID
			ShoppingCar.setId(carId);
			return ShoppingCar;
		}
		return null;
	}

	@Override
	public int addShippingCar(int cusId, int goodsId, int buyNum) {
		String sql = "insert into shopping_list(cus_id,goods_id,goods_buyNum) values(?,?,?)";
		//String[] para = {cusId+"",goodsId+"",buyNum+""};
		if (1==BaseDao.excuteUpdate(sql, cusId, goodsId, buyNum)) {
			return 1 ;
		}		
		return 0;
	}

	@Override
	public int updShippingCar(int gId, int buyNum) {
		List<Object> result = BaseDao.excuteQuery("select * from shopping_list where g_id = ?", gId);
		int beforeNum = 0;
		for(Object  x:result){
			Map<String, Object> map =  (Map<String, Object>)x;
			beforeNum = Integer.valueOf((map.get("goods_buyNum").toString()));
		}
		String sql = "update shopping_list set goods_buyNum = ? where g_id = ?";
		String[] para = {(buyNum+beforeNum)+"",gId+""};
		if (1==BaseDao.excuteUpdate(sql, para)) {
			return 1 ;
		}		
		return 0;
	}

	@Override
	public int getNumShoppingCarById(int cusID) {
		//这句话把like改成了=   cusID+“%”改成了cusId
		String sql = "select count(*) as num from shopping_list where cus_id = ?";
		//String[] para = {cusID+"%"};
		List<Object> result = BaseDao.excuteQuery(sql, cusID);
		for(Object  x:result){
			Map<String, Object> map =  (Map<String, Object>)x;
			int num = Integer.valueOf((map.get("num").toString()));
			return num;
		}
		return 0;
	}
	@Override
	public int checkCustomHaveIt(int cusId, int goodsId) {
		String sql = "select * from shopping_list where cus_id = ? and goods_id = ?";
		String[] para = {cusId+"",goodsId+""};
		List<Object> result = BaseDao.excuteQuery(sql, para);
		if (null == result) {
			return 0;
		}else {
			int gId = 0;
			for(Object  x:result){
				Map<String, Object> map =  (Map<String, Object>)x;
				gId = Integer.valueOf((map.get("g_id").toString()));
			}
			return gId;
		}
		
	}
	@Override
	public int delShippingCarByGoodsId(int goodsId) {
		String sqlString = "delete from shopping_list where goods_id = ?";
		if (0 <= BaseDao.excuteUpdate(sqlString, goodsId)) {
			return 1;
		}
		return 0;
	}

	@Override
	public int updateShoppingCarAmount(int cusId, int goodsId, int amount) {
		// TODO Auto-generated method stub
		int result = BaseDao.excuteUpdate("update shopping_list set goods_buyNum = ? where cus_id = ? and goods_id = ?", amount, cusId, goodsId);
			if(result==1){
				return 1;
			}else{
				return 0;
			}
		}
	
}
