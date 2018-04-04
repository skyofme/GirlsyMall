package team.girlsy.bean;

/**
 * 
 * 订单列表类
 * 
 * @author 罗干
 *
 */
public class OrderList {

	private Integer id;// 订单列表id
	private String orderState;// 订单状态
	private String orderDatetime;// 订单创建时间
	private Goods goods;// 订单中的商品
	private Custom custom;// 订单所有人
	private Integer cusId;// 顾客id

	public OrderList(Integer id, String orderState, String orderDatetime,
			Goods goods, Custom custom, Integer cusId) {
		super();
		this.id = id;
		this.orderState = orderState;
		this.orderDatetime = orderDatetime;
		this.goods = goods;
		this.custom = custom;
		this.cusId = cusId;
	}

	public OrderList() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOrderState() {
		return orderState;
	}

	public void setOrderState(String orderState) {
		this.orderState = orderState;
	}

	public String getOrderDatetime() {
		return orderDatetime;
	}

	public void setOrderDatetime(String orderDatetime) {
		this.orderDatetime = orderDatetime;
	}

	public Custom getCustom() {
		return custom;
	}

	public void setCustom(Custom custom) {
		this.custom = custom;
	}

	public Integer getCusId() {
		return cusId;
	}

	public void setCusId(Integer cusId) {
		this.cusId = cusId;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

}
