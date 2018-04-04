package team.girlsy.dao;

import java.util.List;

import team.girlsy.bean.Goods;

public interface GoodsDao {
	//添加商品
	public int addGoods(Goods goods);
	//删除商品
	public int delGoods(int goodsId);
	//修改商品
	public int modifyGoods(Goods goods);
	//查询全部商品
	public List<Goods> findAllList(String search);
	//通过Id查询商品
	public Goods getGoodsById(int goodsId);	
	//下架商品
	public int dropGoods(Goods goods);
	//通过名称查询商品
	public Goods getGoodsByName(String goodsName);
	//分页查询
	public List<Goods> findSomeGoods(String search, int page,int pageSize);
	//分类查询
	public List<Goods> getGoodsByState(String goodsType);
	//查询商品类别
	public List<Goods> getGoodsType();
	//查询id最大的商品
	public Goods getGoodsByMaxId();
	//获取库存最多的6件商品 ---> 推荐商品
	public List<Goods> getGoodsByStorage();
	//获取销量最多的6件商品 ---> 热销商品
	public List<Goods> getGoodsBySellCount();
	//获取折扣最大的6件商品 ---> 打折商品
	public List<Goods> getGoodsByDisc();
	//获取相同类型库存最多的3件商品 ---> 看了又看
	public List<Goods> getThreeGoodsByType(String Type,int goodID);
	//根据类型分页查询
	public List<Goods> findSomeGoods(String search, int page,int pageSize,String  listStyle);
	//查询商品库存
	public int getGoodsStorage(int goodId);
	//查询商品类别
	public List<Goods> getGoodsByState(String goodsType,int pageNow,int pageSize);
}
