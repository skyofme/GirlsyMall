package team.girlsy.service;

import java.util.List;

import team.girlsy.bean.Goods;

public interface GoodsService {

	// 添加商品
	public String addGoods(Goods goods);

	// 删除商品
	public String delGoods(int goodsId);

	// 修改商品
	public String modifyGoods(Goods goods);

	// 查询全部商品
	public List<Goods> findAllList(String search);

	// 通过商品Id查询商品
	public Goods getGoodsById(int goodsId);

	// 下架商品
	public String dropGoods(Goods goods);

	// 通过商品名称查询商品
	public Goods getGoodsByName(String goodsName);

	// 分页查询商品
	public List<Goods> findSomeGoods(String search, int pageNow, int pageSize);

	// 判断查询方式
	public String searchGoodsList(String goodsType, String search);

	// 分类查询
	public List<Goods> getGoodsByState(String goodsType);

	// 查询商品类别
	public List<Goods> findGoodsType();

	// 分页查询某类商品
	public List<Goods> findSomeGoods(String search, int pageNow, int pageSize,
			String listStyle);

	// 分类分页查询
	public List<Goods> getGoodsByState(String goodsType, int pageNow,
			int pageSize);

}
