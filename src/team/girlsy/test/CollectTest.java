package team.girlsy.test;

import java.util.List;

import org.junit.Test;

import team.girlsy.bean.Collection;
import team.girlsy.dao.CollectionDao;
import team.girlsy.dao.GoodsDao;
import team.girlsy.dao.ShoppingCarDao;
import team.girlsy.dao.impl.CollectionDaoImpl;
import team.girlsy.dao.impl.GoodsDaoImpl;
import team.girlsy.dao.impl.ShoppingCarDaoImpl;


public class CollectTest {
	/*//清空该顾客收藏夹
	public int delALLCollection(int cusID);
		
	//清空该顾客单个商品
	public int delCollection(int favouriteId);
		
	//增加收藏夹内商品
	public int addCollection(int cusId,int goodsId);

	//按类别查找收藏夹内商品
	public List<Collection> getCollectionByType(int cusId,String type);
		
	//查找全部收藏夹内商品
	public List<Collection> getAllCollection(int cusID);
		
	//查找收藏夹内单个商品
	public Collection getCollectionById(int favouriteId);*/
	
	@Test
	public void delALLCollection(){
		CollectionDao collectionDao = new CollectionDaoImpl();
		if(1 == collectionDao.delALLCollection(1)) {
			System.out.println("1");
		}
	}
	
	@Test
	public void addCollection(){
		CollectionDao CollectionDao = new CollectionDaoImpl();
		if (1==CollectionDao.addCollection(1, 1)) {
			System.out.println("1");
		}
	}
	
	@Test
	public void delCollection(){
		CollectionDao CollectionDao = new CollectionDaoImpl();
		if (1 == CollectionDao.delCollection(12)) {
			System.out.println("1");
		}
	}
	
	@Test
	public void getCollectionByType(){
		CollectionDao CollectionDao = new CollectionDaoImpl();
		if (null != CollectionDao.getCollectionByType(6, "洗浴用品")) {
			System.out.println("1");
		}
	}
	
	@Test
	public void getAllCollections(){
		CollectionDao Collection = new CollectionDaoImpl();
		if (null != Collection.getAllCollection(6)) {
			System.out.println("1");

		}
	}
	
	@Test
	public void getCollectionById(){
		CollectionDao CollectionDao = new CollectionDaoImpl();
		if (null != CollectionDao.getCollectionById(8)) {
			System.out.println("1");

		}
	}
	
	@Test
	public void getGoodsStorage(){
		GoodsDao goodsDao = new GoodsDaoImpl();
		System.out.println(goodsDao.getGoodsStorage(80));
	}
}
