package team.girlsy.bean;

/**
 * 收藏夹类
 * 
 * @author 罗干
 *
 */
public class Collection {

	private Integer id; 	// 收藏夹id
	private Custom custom;  // 收藏夹所有者
	private Goods goods;    // 收藏的物品

	public Collection() {
		super();
	}

	public Collection(Integer id, Custom custom, Goods goods) {
		super();
		this.id = id;
		this.custom = custom;
		this.goods = goods;
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

	@Override
	public String toString() {
		return "Collection [id=" + id + ", custom=" + custom + ", goods="
				+ goods + "]";
	}

}
