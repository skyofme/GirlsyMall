package team.girlsy.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import team.girlsy.bean.Collection;
import team.girlsy.bean.Custom;
import team.girlsy.bean.Goods;
import team.girlsy.bean.ShoppingCar;
import team.girlsy.dao.CollectionDao;
import team.girlsy.utils.BaseDao;

public class CollectionDaoImpl implements CollectionDao{

	@Override
	public int delALLCollection(int cusID) {
		String sqlString = "delete from favourite where cus_id = ?";
		//String[] para = {cusID+""};
		if (0 <= BaseDao.excuteUpdate(sqlString, cusID)) {
			return 1;
		}
		return 0;
	}

	@Override
	public int delCollection(int favouriteId) {
		String sqlString = "delete from favourite where favourite_id = ?";
		//String[] para = {favouriteId+""};
		if (0 <= BaseDao.excuteUpdate(sqlString, favouriteId)) {
			return 1;
		}
		return 0;
	}

	@Override
	public int addCollection(int cusId, int goodsId) {
		String sql = "insert into favourite(cus_id,goods_id) values(?,?)";
		//String[] para = {cusId+"",goodsId+""};
		if (1==BaseDao.excuteUpdate(sql, cusId, goodsId)) {
			return 1 ;
		}		
		return 0;
	}

	@Override
	public List<Collection> getCollectionByType(int cusId, String type) {
		String sql = "select * from favourite as s left join goods as g on s.goods_id = g.goods_id left join custom as c on s.cus_id = c.cus_id where g.goods_type like ? and s.cus_id = ?";
		//String[] para = {type+"%",cusId+""};
		List<Object> result = BaseDao.excuteQuery(sql, type+"%",cusId);
		if (null != result) {
			List<Collection> Collections = new ArrayList<Collection>();
			for(Object x : result){
				Map<String, Object> map = (Map<String, Object>)x;
				Collection Collection = new Collection();
				//客户对象
				Custom custom = new Custom(Integer.valueOf(map.get("cus_id").toString()), map.get("cus_name").toString(), map.get("cus_pwd").toString(), map.get("cus_sex").toString(),map.get("cus_tel").toString(),map.get("cus_addr").toString());
				Collection.setCustom(custom);
				//商品对象
				Goods goods = null;
				if (null == map.get("goods_imgs")) {
					goods = new Goods(Integer.valueOf(map.get("goods_id").toString()), map.get("goods_name").toString(), Integer.valueOf(map.get("goods_storage").toString()), Double.valueOf(map.get("goods_price").toString()),Float.valueOf(map.get("goods_discount").toString()), Integer.valueOf(map.get("goods_sellCount").toString()), map.get("goods_type").toString(), map.get("goods_img")+"","");
				}else {
					String[] arr = map.get("goods_imgs").toString().split(" ");
					goods = new Goods(Integer.valueOf(map.get("goods_id").toString()), map.get("goods_name").toString(), Integer.valueOf(map.get("goods_storage").toString()), Double.valueOf(map.get("goods_price").toString()),Float.valueOf(map.get("goods_discount").toString()), Integer.valueOf(map.get("goods_sellCount").toString()), map.get("goods_type").toString(), map.get("goods_desc").toString(),arr[0]);
				}		
				Collection.setGoods(goods);
				//收藏夹ID
				Collection.setId(Integer.valueOf(map.get("favourite_id").toString()));
				
				Collections.add(Collection);
			}
			return Collections;
		}
		return null;
	}
	@Override
	public List<Collection> getAllCollection(int cusID) {

		String sql = "select * from favourite as s left join goods as g on s.goods_id = g.goods_id left join custom as c on s.cus_id = c.cus_id where s.cus_id = ?";
		//String[] paraStrings = {cusID+""};
		List<Object> result = BaseDao.excuteQuery(sql,cusID);
		if (null != result) {
			List<Collection> Collections = new ArrayList<Collection>();
			for(Object x : result){
				Map<String, Object> map = (Map<String, Object>)x;
				Collection Collection = new Collection();
				//客户对象
				Custom custom = new Custom(Integer.valueOf(map.get("cus_id").toString()), map.get("cus_name").toString(), map.get("cus_pwd").toString(), map.get("cus_sex").toString(),map.get("cus_tel").toString(),map.get("cus_addr").toString());
				Collection.setCustom(custom);
				//商品对象
				Goods goods = null;
				if (null == map.get("goods_imgs")) {
					goods = new Goods(Integer.valueOf(map.get("goods_id").toString()), map.get("goods_name").toString(), Integer.valueOf(map.get("goods_storage").toString()), Double.valueOf(map.get("goods_price").toString()),Float.valueOf(map.get("goods_discount").toString()), Integer.valueOf(map.get("goods_sellCount").toString()), map.get("goods_type").toString(), map.get("goods_img")+"","");
				}else {
					String[] arr = map.get("goods_imgs").toString().split(" ");
					goods = new Goods(Integer.valueOf(map.get("goods_id").toString()), map.get("goods_name").toString(), Integer.valueOf(map.get("goods_storage").toString()), Double.valueOf(map.get("goods_price").toString()),Float.valueOf(map.get("goods_discount").toString()), Integer.valueOf(map.get("goods_sellCount").toString()), map.get("goods_type").toString(), map.get("goods_desc").toString(),arr[0]);
				}		
				Collection.setGoods(goods);
				//收藏夹ID
				Collection.setId(Integer.valueOf(map.get("favourite_id").toString()));
				Collections.add(Collection);
			}
			return Collections;
		}
		return null;
	}
	
	@Override
	public Collection getCollectionById(int favouriteId) {
		String sqlString = "select * from favourite as s left join goods as g on s.goods_id = g.goods_id left join custom as c on s.cus_id = c.cus_id where favourite_id = ?";
		//String[] para = {favouriteId+""};
		List<Object> result = BaseDao.excuteQuery(sqlString, favouriteId);
		for(Object x : result){
			Map<String, Object> map = (Map<String, Object>)x;
			Collection Collection = new Collection();
			//客户对象
			Custom custom = new Custom(Integer.valueOf(map.get("cus_id").toString()), map.get("cus_name").toString(), map.get("cus_pwd").toString(), map.get("cus_sex").toString(),map.get("cus_tel").toString(),map.get("cus_addr").toString());
			Collection.setCustom(custom);
			//商品对象
			Goods goods = null;
			if (null == map.get("goods_imgs")) {
				goods = new Goods(Integer.valueOf(map.get("goods_id").toString()), map.get("goods_name").toString(), Integer.valueOf(map.get("goods_storage").toString()), Double.valueOf(map.get("goods_price").toString()),Float.valueOf(map.get("goods_discount").toString()), Integer.valueOf(map.get("goods_sellCount").toString()), map.get("goods_type").toString(), map.get("goods_img")+"","");
			}else {
				String[] arr = map.get("goods_imgs").toString().split(" ");
				goods = new Goods(Integer.valueOf(map.get("goods_id").toString()), map.get("goods_name").toString(), Integer.valueOf(map.get("goods_storage").toString()), Double.valueOf(map.get("goods_price").toString()),Float.valueOf(map.get("goods_discount").toString()), Integer.valueOf(map.get("goods_sellCount").toString()), map.get("goods_type").toString(), map.get("goods_desc").toString(),arr[0]);
			}		
			Collection.setGoods(goods);
			//收藏夹ID
			Collection.setId(favouriteId);
			return Collection;
		}
		return null;
	}

	@Override
	public int checkCustomHaveIt(int cusId, int goodsId) {
		String sql = "select * from favourite where cus_id = ? and goods_id = ?";
		String[] para = {cusId+"",goodsId+""};
		List<Object> result = BaseDao.excuteQuery(sql, para);
		if (null == result) {
			return 0;
		}else {
			int fId = 0;
			for(Object  x:result){
				Map<String, Object> map =  (Map<String, Object>)x;
				fId = Integer.valueOf((map.get("favourite_id").toString()));
			}
			return fId;
		}
	}
}
