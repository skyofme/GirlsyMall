package team.girlsy.test;

import java.util.List;

import org.junit.Test;

import team.girlsy.bean.ShoppingCar;
import team.girlsy.dao.ShoppingCarDao;
import team.girlsy.dao.impl.ShoppingCarDaoImpl;

public class ShoppingCarTest {
	
	/*//清空该顾客购物车
		public int delALLShippingCar(int cusID);
		
		//清空该顾客单个商品
		public int delShippingCar(int carId);
		
		//增加购物车内商品
		public int addShippingCar(int cusId,int goodsId, int buyNum);

		//修改购物车内商品数量
		public int updShippingCar(int carId,int buyNum);
		
		//按类别查找购物车内商品
		public List<ShoppingCar> getShoppingCarsByType(int cusId,String type);
		
		//查找全部购物车内商品
		public List<ShoppingCar> getAllShoppingCars(int cusID);
		
		//查找购物车内单个商品
		public ShoppingCar getShoppingCarById(int carId);*/
		
		
	@Test
	public void addShippingCar(){
		ShoppingCarDao shoppingCarDao = new ShoppingCarDaoImpl();
		if (1==shoppingCarDao.addShippingCar(1,1,1)) {
			System.out.println("1");
		}
	}
	
	@Test
	public void updShippingCar(){
		ShoppingCarDao shoppingCarDao = new ShoppingCarDaoImpl();
		if (1==shoppingCarDao.updShippingCar(10, 20)) {
			System.out.println("1");
		}
	}
	
	@Test
	public void delShippingCar(){
		ShoppingCarDao shoppingCarDao = new ShoppingCarDaoImpl();
		if (1 == shoppingCarDao.delShippingCar(11)) {
			System.out.println("1");
		}
	}
	
	@Test
	public void delALLShippingCar(){
		ShoppingCarDao shoppingCarDao = new ShoppingCarDaoImpl();
		if (1==shoppingCarDao.delALLShippingCar(1)) {
			System.out.println("1");
		}
	}
	
	@Test
	public void getShoppingCarsByType(){
		ShoppingCarDao shoppingCarDao = new ShoppingCarDaoImpl();
		if (null != shoppingCarDao.getShoppingCarsByType(6, "洗浴用品")) {
			System.out.println("1");
		}
	}
	
	@Test
	public void getAllShoppingCars(){
		ShoppingCarDao shoppingCarDao = new ShoppingCarDaoImpl();
		if (null != shoppingCarDao.getAllShoppingCars(26)) {
			System.out.println("1");

		}
	}
	
	@Test
	public void getShoppingCarById(){
		ShoppingCarDao shoppingCarDao = new ShoppingCarDaoImpl();
		if (null != shoppingCarDao.getShoppingCarById(8)) {
			System.out.println("1");

		}
	}
}
