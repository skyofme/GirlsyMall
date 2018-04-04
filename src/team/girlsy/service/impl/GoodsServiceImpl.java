package team.girlsy.service.impl;

import java.util.List;

import team.girlsy.bean.Goods;
import team.girlsy.dao.GoodsDao;
import team.girlsy.dao.impl.GoodsDaoImpl;
import team.girlsy.service.GoodsService;

public class GoodsServiceImpl implements GoodsService {
	
	private GoodsDao goodsDao = new GoodsDaoImpl();

	public String addGoods(Goods goods) {
		if(goods.getName() == null || "".equals(goods.getName())){
			return "商品名称不能为空";
		}
		if(goods.getDiscount() == 0){
			return "商品折扣不能为空";
		}
		if(goods.getPrice() == 0){
			return "商品价格不能为空";
		}
		if(goods.getStorage() == 0){
			return "商品库存不能为空";
		}
		if(goodsDao.addGoods(goods) == 1){
			return "添加成功";
		}
		return "添加失败";
	} 

	public String delGoods(int goodsId) {
		if(goodsId == 0){
			return "商品ID不能为空";
		}
		if(goodsDao.delGoods(goodsId) == 1){
			return "删除成功";
		}
		return "删除失败";
	}

	public String modifyGoods(Goods goods) {
		if(goods.getName() == null || "".equals(goods.getName())){
			return "商品名称不能为空";
		}
		if(goods.getDiscount() == 0){
			return "商品折扣不能为空";
		}
		if(goods.getPrice() == 0){
			return "商品价格不能为空";
		}
		if(goods.getStorage() == 0){
			return "商品库存不能为空";
		}
		if(goodsDao.modifyGoods(goods) == 1){
			return "修改成功";
		}
		return "修改失败";
	}




	public Goods getGoodsById(int goodsId) {
		// TODO Auto-generated method stub
		return goodsDao.getGoodsById(goodsId);
		}

	@Override
	public List<Goods> findAllList(String search) {
		// TODO Auto-generated method stub
		return goodsDao.findAllList(search);
	}

	@Override
	public String dropGoods(Goods goods) {
		// TODO Auto-generated method stub
		if(goodsDao.dropGoods(goods)==1){
			return "下架成功";
			
		}
		return "下架失败";
	}

	@Override
	public Goods getGoodsByName(String goodsName) {
		
		return goodsDao.getGoodsByName(goodsName);
	}

	@Override
	public List<Goods> findSomeGoods(String search, int pageNow, int pageSize) {
		// TODO Auto-generated method stub
		return goodsDao.findSomeGoods(search,pageNow,pageSize);
	}

	@Override
	public String searchGoodsList(String goodsType, String search) {
		// TODO Auto-generated method stub
		if (search==null||"".equals(search)) {
			if ("商品类型".equals(goodsType)) {
				return "all";
			}else {
				return "searchBygoodsType";
			}
		}else {
			if ("商品类型".equals(goodsType)){
				return "searchBysearch";
			}else {
				return "searchByBoth";
			}
			
		}	
	}

	@Override
	public List<Goods> getGoodsByState(String goodsType) {
		// TODO Auto-generated method stub
		return goodsDao.getGoodsByState(goodsType);
	}

	@Override
	public List<Goods> findGoodsType() {
		// TODO Auto-generated method stub
		return goodsDao.getGoodsType();
	}

	@Override
	public List<Goods> findSomeGoods(String search, int pageNow, int pageSize,
			String listStyle) {
		// TODO Auto-generated method stub
		return goodsDao.findSomeGoods(search,pageNow,pageSize,listStyle);
	}

	@Override
	public List<Goods> getGoodsByState(String goodsType, int pageNow,
			int pageSize) {
		// TODO Auto-generated method stub
		return goodsDao.getGoodsByState(goodsType,pageNow,pageSize);
	}

}
