package team.girlsy.bean;

/**
 * 订单详情
 * 
 * @author 罗干
 *
 */
public class OrderDetail {

	private OrderList orderList; // 订单
	private Integer detail_id; // 订单详情号
	private Integer order_id; // 订单号
	private Integer goods_id; // 商品号

	public Integer getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}

	public Integer getGoods_id() {
		return goods_id;
	}

	public void setGoods_id(Integer goods_id) {
		this.goods_id = goods_id;
	}

	// 商品
	private Goods goods;
	// 客户
	private Custom custom;
	// 商品数量
	private Integer goodNum;

	public OrderDetail() {
		super();
	}

	public OrderList getOrderList() {
		return orderList;
	}

	public void setOrderList(OrderList orderList) {
		this.orderList = orderList;
	}

	public Integer getDetail_id() {
		return detail_id;
	}

	public void setDetail_id(Integer detail_id) {
		this.detail_id = detail_id;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public Custom getCustom() {
		return custom;
	}

	public void setCustom(Custom custom) {
		this.custom = custom;
	}

	public Integer getGoodNum() {
		return goodNum;
	}

	public void setGoodNum(Integer goodNum) {
		this.goodNum = goodNum;
	}

	public OrderDetail(OrderList orderList, Integer detail_id, Goods goods,
			Custom custom, Integer goodNum) {
		super();
		this.orderList = orderList;
		this.detail_id = detail_id;
		this.goods = goods;
		this.custom = custom;
		this.goodNum = goodNum;
	}

}
