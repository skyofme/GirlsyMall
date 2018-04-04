package team.girlsy.dao;

import java.util.List;

import team.girlsy.bean.Collection;

public interface CollectionDao {
	//清空该顾客收藏夹
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
	public Collection getCollectionById(int favouriteId);
	//判断该用户的收藏夹里面是否有这件商品
	public int checkCustomHaveIt(int cusId,int goodsId);
}
