package team.girlsy.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import team.girlsy.bean.Custom;
import team.girlsy.bean.Goods;
import team.girlsy.dao.GoodsDao;
import team.girlsy.utils.BaseDao;

public class GoodsDaoImpl implements GoodsDao {


@Override
	public int addGoods(Goods goods) {
		String sql = "insert into goods(goods_id,goods_name,goods_storage,goods_price,goods_discount,goods_sellCount,goods_type,goods_desc,goods_imgs) value(?,?,?,?,?,?,?,?,?)";
		return BaseDao.excuteUpdate(sql, goods.getId(),goods.getName(),goods.getStorage(),goods.getPrice(),goods.getDiscount(),goods.getSellCount(),goods.getType(),goods.getDesc(),goods.getImg());
	}

	@Override
	public int delGoods(int goodsId) {
		String sql = "delete from goods where goods_id = ?";
		return BaseDao.excuteUpdate(sql, goodsId);
	}

	@Override
	public int modifyGoods(Goods goods) {
		String sql = "update goods set goods_storage = ?,goods_price = ?,goods_discount = ? where goods_id = ?";
		return BaseDao.excuteUpdate(sql, goods.getStorage(),goods.getPrice(),goods.getDiscount(),goods.getId());
	}
	
	@Override
	public List<Goods> findAllList(String search) {
		String sql = "select * from goods";
		sql += " where  goods_name like ? or goods_desc like ?";
		if (search == null) {
			search = "";
		}
		char[] searchArr = search.toCharArray();
		String param = "%";
		for (int i = 0; i < searchArr.length; i++) {
			param += searchArr[i]+"%";
		}
		List<Object> result = BaseDao.excuteQuery(sql,param,param);
		List<Goods> goods = new ArrayList<Goods>();
		for(Object x : result){
			Map<String, Object> map = (Map<String, Object>)x;
			Goods good = new Goods();
			good.setId(Integer.valueOf(map.get("goods_id").toString()));
			good.setName(map.get("goods_name").toString());
			good.setStorage(Integer.valueOf(map.get("goods_storage").toString()));
			good.setPrice(Double.valueOf(map.get("goods_price").toString()));
			good.setDiscount(Float.valueOf(map.get("goods_discount").toString()));
			good.setSellCount(Integer.valueOf(map.get("goods_sellCount").toString()));
			good.setType(map.get("goods_type").toString());
			good.setDesc(""+map.get("goods_desc"));
			//放中图地址进去
			if (null != map.get("goods_imgs")) {
				String[] imgs = map.get("goods_imgs").toString().split(" ");
				good.setImg(imgs[1]);
			}else {
				good.setImg(" ");
			}
			
			goods.add(good);
		}
		return goods;
	}

	@Override
	public Goods getGoodsById(int goodsId) {
		String sql = "select * from goods where goods_id = ?";
		List<Object> result = BaseDao.excuteQuery(sql, goodsId);
		for(Object x : result){
			Map<String, Object> map = (Map<String, Object>)x;
			Goods good = new Goods();
			good.setId(Integer.valueOf(map.get("goods_id").toString()));
			good.setName(map.get("goods_name").toString());
			good.setStorage(Integer.valueOf(map.get("goods_storage").toString()));
			good.setPrice(Double.valueOf(map.get("goods_price").toString()));
			good.setDiscount(Float.valueOf(map.get("goods_discount").toString()));
			good.setSellCount(Integer.valueOf(map.get("goods_sellCount").toString()));
			good.setType(map.get("goods_type").toString());
			good.setDesc(""+map.get("goods_desc"));
			good.setImg(map.get("goods_imgs")+"");
			return good;
		}
		return null;
	}

	@Override
	public int dropGoods(Goods goods) {
		String sql = "update goods set goods_storage = 0 where goods_id = ?";
		return BaseDao.excuteUpdate(sql,goods.getId());
	}

	@Override
	public Goods getGoodsByName(String goodsName) {
		String sql = "select * from goods where goods_name = ?";
		List<Object> result = BaseDao.excuteQuery(sql, goodsName);
		for(Object x : result){
			Map<String, Object> map = (Map<String, Object>)x;
			Goods good = new Goods();
			good.setId(Integer.valueOf(map.get("goods_id").toString()));
			good.setName(map.get("goods_name").toString());
			good.setStorage(Integer.valueOf(map.get("goods_storage").toString()));
			good.setPrice(Double.valueOf(map.get("goods_price").toString()));
			good.setDiscount(Float.valueOf(map.get("goods_discount").toString()));
			good.setSellCount(Integer.valueOf(map.get("goods_sellCount").toString()));
			good.setType(map.get("goods_type").toString());
			good.setDesc(""+map.get("goods_desc"));
			return good;
		}
		return null;
	}

	@Override
	public List<Goods> findSomeGoods(String search, int page, int pageSize) {
		List<Goods> list = new ArrayList();
		if(search==null){
			search ="";
		}
		String sql = " select goods_id, goods_name, goods_storage, goods_price, goods_discount, goods_sellCount, goods_type from goods ";
		sql += " where goods_id like ? or goods_name like ?";
		sql += " limit "+(page-1)*pageSize +","+ pageSize;
		Object[] params = {"%"+search+"%","%"+search+"%"};
		ResultSet rs =  BaseDao.query(sql, params);
		try {
			while(rs.next()){
				Goods goods = new Goods();
				goods.setId(rs.getInt("goods_id"));
				goods.setName(rs.getString("goods_name"));
				goods.setStorage(rs.getInt("goods_storage"));
				goods.setPrice(rs.getDouble("goods_price"));
				goods.setDiscount(rs.getFloat("goods_discount"));
				goods.setSellCount(rs.getInt("goods_sellCount"));
				goods.setType(rs.getString("goods_type"));
				list.add(goods);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	return list;
	}

	@Override
	public List<Goods> getGoodsByState(String goodsType) {
		String sql = "select * from goods where goods_type = ?";
		List<Object> result = BaseDao.excuteQuery(sql, goodsType);
		List<Goods> goods = new ArrayList<Goods>();
		for(Object x : result){
			Map<String, Object> map = (Map<String, Object>)x;
			Goods good = new Goods();
			good.setId(Integer.valueOf(map.get("goods_id").toString()));
			good.setName(map.get("goods_name").toString());
			good.setStorage(Integer.valueOf(map.get("goods_storage").toString()));
			good.setPrice(Double.valueOf(map.get("goods_price").toString()));
			good.setDiscount(Float.valueOf(map.get("goods_discount").toString()));
			good.setSellCount(Integer.valueOf(map.get("goods_sellCount").toString()));
			good.setType(map.get("goods_type").toString());
			good.setDesc(""+map.get("goods_desc"));
			goods.add(good);
		}
		return goods;
	}

	public List<Goods> getGoodsType() {
		String sql = "select DISTINCT goods_type from goods";
		List<Object> result = BaseDao.excuteQuery(sql);
		List<Goods> goods = new ArrayList<Goods>();
		for(Object x : result){
			Map<String, Object> map = (Map<String, Object>)x;
			Goods good = new Goods();
			good.setType(map.get("goods_type").toString());
			goods.add(good);
		}
		return goods;
	}
	public static int queryPageCnt(String sch,int pageSize) throws SQLException{
		if (sch==null){ 
			sch = "";
		}
		String sql = "select count(*) cnt from goods ";//一共有多少条记录
		sql += " where goods_id like ? or goods_name like ?";		
		Object[] params = {"%"+sch+"%","%"+sch+"%"};
		ResultSet rs = BaseDao.query(sql, params);			
		int cnt=0;
		try {
			if(rs.next()){
				cnt=(rs).getInt("cnt");
				if(cnt%pageSize==0){
				    return cnt/pageSize;
				}else{
			        return cnt/pageSize + 1; 		 
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		(rs).close();
		return 0;			
	}
	public static int queryPageCnt2(String listStyle,int pageSize) throws SQLException{
		if (listStyle==null){ 
			listStyle = "";
		}
		String sql = "select count(*) cnt from goods ";//一共有多少条记录
		sql += " where goods_type=?";		
		Object[] params = {listStyle};
		ResultSet rs = BaseDao.query(sql, params);			
		int cnt=0;
		try {
			if(rs.next()){
				cnt=(rs).getInt("cnt");
				if(cnt%pageSize==0){
				    return cnt/pageSize;
				}else{
			        return cnt/pageSize + 1; 		 
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		(rs).close();
		return 0;			
	}
	public static int queryPageCnt(String sch,int pageSize,String  listStyle) throws SQLException{
		if (sch==null){ 
			sch = "";
		}
		String sql = "select count(*) cnt from goods ";//一共有多少条记录
		sql += " where  goods_type=? and (goods_id like ? or goods_name like ?)";		
		Object[] params = {listStyle,"%"+sch+"%","%"+sch+"%"};
		ResultSet rs = BaseDao.query(sql, params);			
		int cnt=0;
		try {
			if(rs.next()){
				cnt=(rs).getInt("cnt");
				if(cnt%pageSize==0){
				    return cnt/pageSize;
				}else{
			        return cnt/pageSize + 1; 		 
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		(rs).close();
		return 0;			
	}
	@Override
	public Goods getGoodsByMaxId() {
		String sql = "select * from goods where goods_id = (select goods_id from goods order by goods_id desc limit 1)";
		List<Object> result = BaseDao.excuteQuery(sql);
		for(Object x : result){
			Map<String, Object> map = (Map<String, Object>)x;
			Goods good = new Goods();
			good.setId(Integer.valueOf(map.get("goods_id").toString()));
			good.setName(map.get("goods_name").toString());
			good.setStorage(Integer.valueOf(map.get("goods_storage").toString()));
			good.setPrice(Double.valueOf(map.get("goods_price").toString()));
			good.setDiscount(Float.valueOf(map.get("goods_discount").toString()));
			good.setSellCount(Integer.valueOf(map.get("goods_sellCount").toString()));
			good.setType(map.get("goods_type").toString());
			good.setDesc(""+map.get("goods_desc"));
			return good;
		}
		return null;
	}

	@Override
	public List<Goods> getGoodsByStorage() {
		String sql = "select * from goods order by goods_storage desc limit 6";
		List<Object> result = BaseDao.excuteQuery(sql);
		List<Goods> goods = new ArrayList<Goods>();
		for(Object x : result){
			Map<String, Object> map = (Map<String, Object>)x;
			Goods good = new Goods();
			good.setId(Integer.valueOf(map.get("goods_id").toString()));
			good.setName(map.get("goods_name").toString());
			good.setStorage(Integer.valueOf(map.get("goods_storage").toString()));
			good.setPrice(Double.valueOf(map.get("goods_price").toString()));
			good.setDiscount(Float.valueOf(map.get("goods_discount").toString()));
			good.setSellCount(Integer.valueOf(map.get("goods_sellCount").toString()));
			good.setType(map.get("goods_type").toString());
			good.setDesc(""+map.get("goods_desc"));
			good.setImg(""+map.get("goods_imgs"));
			goods.add(good);
		}
		return goods;
	}

	@Override
	public List<Goods> getGoodsBySellCount() {
		String sql = "select * from goods order by goods_sellCount desc limit 6";
		List<Object> result = BaseDao.excuteQuery(sql);
		List<Goods> goods = new ArrayList<Goods>();
		for(Object x : result){
			Map<String, Object> map = (Map<String, Object>)x;
			Goods good = new Goods();
			good.setId(Integer.valueOf(map.get("goods_id").toString()));
			good.setName(map.get("goods_name").toString());
			good.setStorage(Integer.valueOf(map.get("goods_storage").toString()));
			good.setPrice(Double.valueOf(map.get("goods_price").toString()));
			good.setDiscount(Float.valueOf(map.get("goods_discount").toString()));
			good.setSellCount(Integer.valueOf(map.get("goods_sellCount").toString()));
			good.setType(map.get("goods_type").toString());
			good.setDesc(""+map.get("goods_desc"));
			good.setImg(""+map.get("goods_imgs"));
			goods.add(good);
		}
		return goods;
	}

	@Override
	public List<Goods> getGoodsByDisc() {
		String sql = "select * from goods order by goods_discount limit 6";
		List<Object> result = BaseDao.excuteQuery(sql);
		List<Goods> goods = new ArrayList<Goods>();
		for(Object x : result){
			Map<String, Object> map = (Map<String, Object>)x;
			Goods good = new Goods();
			good.setId(Integer.valueOf(map.get("goods_id").toString()));
			good.setName(map.get("goods_name").toString());
			good.setStorage(Integer.valueOf(map.get("goods_storage").toString()));
			good.setPrice(Double.valueOf(map.get("goods_price").toString()));
			good.setDiscount(Float.valueOf(map.get("goods_discount").toString()));
			good.setSellCount(Integer.valueOf(map.get("goods_sellCount").toString()));
			good.setType(map.get("goods_type").toString());
			good.setDesc(""+map.get("goods_desc"));
			good.setImg(""+map.get("goods_imgs"));
			goods.add(good);
		}
		return goods;
	}

	@Override
	public List<Goods> getThreeGoodsByType(String Type,int goodId) {
		String sqlString = "select * from goods where goods_type = ? and goods_id not in (?) order by goods_storage desc limit 3 ";
		List<Object> result = BaseDao.excuteQuery(sqlString,Type,goodId);
		List<Goods> goods = new ArrayList<Goods>();
		for(Object x : result){
			Map<String, Object> map = (Map<String, Object>)x;
			Goods good = new Goods();
			good.setId(Integer.valueOf(map.get("goods_id").toString()));
			good.setName(map.get("goods_name").toString());
			good.setStorage(Integer.valueOf(map.get("goods_storage").toString()));
			good.setPrice(Double.valueOf(map.get("goods_price").toString()));
			good.setDiscount(Float.valueOf(map.get("goods_discount").toString()));
			good.setSellCount(Integer.valueOf(map.get("goods_sellCount").toString()));
			good.setType(map.get("goods_type").toString());
			good.setDesc(""+map.get("goods_desc"));
			
			String[] imgs = map.get("goods_imgs").toString().split(" ");
			good.setImg(imgs[1]);
			
			goods.add(good);
		}
		return goods;
	}

	@Override
	public List<Goods> findSomeGoods(String search, int page, int pageSize,
			String listStyle) {
		// TODO Auto-generated method stub
		List<Goods> list = new ArrayList();
		if(search==null){
			search ="";
		}
		String sql = " select goods_id, goods_name, goods_storage, goods_price, goods_discount, goods_sellCount, goods_type from goods ";
		sql += " where goods_type=? and (goods_id like ? or goods_name like ?)";
		sql += " limit "+(page-1)*pageSize +","+ pageSize;
		Object[] params = {listStyle,"%"+search+"%","%"+search+"%"};
		ResultSet rs =  BaseDao.query(sql, params);
		try {
			while(rs.next()){
				Goods goods = new Goods();
				goods.setId(rs.getInt("goods_id"));
				goods.setName(rs.getString("goods_name"));
				goods.setStorage(rs.getInt("goods_storage"));
				goods.setPrice(rs.getDouble("goods_price"));
				goods.setDiscount(rs.getFloat("goods_discount"));
				goods.setSellCount(rs.getInt("goods_sellCount"));
				goods.setType(rs.getString("goods_type"));
				list.add(goods);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	return list;
	}

	@Override
	public List<Goods> getGoodsByState(String goodsType, int pageNow,
			int pageSize) {
		List<Goods> list = new ArrayList();
		if(goodsType==null){
			goodsType ="";
		}
		String sql = " select goods_id, goods_name, goods_storage, goods_price, goods_discount, goods_sellCount, goods_type from goods ";
		sql += " where goods_type=?";
		sql += " limit "+(pageNow-1)*pageSize +","+ pageSize;
		Object[] params = {goodsType};
		ResultSet rs =  BaseDao.query(sql, params);
		try {
			while(rs.next()){
				Goods goods = new Goods();
				goods.setId(rs.getInt("goods_id"));
				goods.setName(rs.getString("goods_name"));
				goods.setStorage(rs.getInt("goods_storage"));
				goods.setPrice(rs.getDouble("goods_price"));
				goods.setDiscount(rs.getFloat("goods_discount"));
				goods.setSellCount(rs.getInt("goods_sellCount"));
				goods.setType(rs.getString("goods_type"));
				list.add(goods);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	return list;
	}

	@Override
	public int getGoodsStorage(int goodId) {
		String sqlString = "select goods_storage from goods where goods_id = ?";
		List<Object> result = BaseDao.excuteQuery(sqlString, goodId);
		for(Object x : result){
			Map<String, Object> map = (Map<String, Object>)x;
			return Integer.valueOf(map.get("goods_storage").toString());
		}
		return 0;
	}
}
