package team.girlsy.bean;

/**
 * 
 * 购物车类
 * 
 * @author 罗干
 *
 */
public class ShoppingCar {

	private Integer id; // 购物车id
	private Custom custom; // 购物车所有人
	private Goods goods; // 购物车中的商品
	private Integer buyNum; // 各种商品的数量

	public ShoppingCar() {
		super();
	}

	public ShoppingCar(Integer id, Custom custom, Goods goods, Integer buyNum) {
		super();
		this.id = id;
		this.custom = custom;
		this.goods = goods;
		this.buyNum = buyNum;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Custom getCustom() {
		return custom;
	}

	public void setCustom(Custom custom) {
		this.custom = custom;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public Integer getBuyNum() {
		return buyNum;
	}

	public void setBuyNum(Integer buyNum) {
		this.buyNum = buyNum;
	}

	@Override
	public String toString() {
		return "ShoppingCar [id=" + id + ", custom=" + custom + ", goods="
				+ goods + ", buyNum=" + buyNum + "]";
	}
	
	
}
