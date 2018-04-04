package team.girlsy.dao;

import java.util.List;

import team.girlsy.bean.ShoppingCar;

public interface ShoppingCarDao {
	//清空该顾客购物车
	public int delALLShippingCar(int cusID);
	//清空该顾客单个商品
	public int delShippingCar(int carId);
	//删除该客户已经购买的商品
	public int delShippingCarByGoodsId(int goodsId);
	//增加购物车内商品
	public int addShippingCar(int cusId,int goodsId, int buyNum);
	//修改购物车内商品数量
	public int updShippingCar(int carId,int buyNum);	
	//按类别查找购物车内商品
	public List<ShoppingCar> getShoppingCarsByType(int cusId,String type);	
	//查找全部购物车内商品
	public List<ShoppingCar> getAllShoppingCars(int cusID);	
	//查找购物车内单个商品
	public ShoppingCar getShoppingCarById(int carId);	
	//查询购物车的数量
	public int getNumShoppingCarById(int cusID);
	//判断该用户的购物车里面是否有这件商品
	public int checkCustomHaveIt(int cusId,int goodsId);
	//修改购物车中用户某件商品的数量
	public int updateShoppingCarAmount(int cusId,int goodsId,int amount);
	
}
