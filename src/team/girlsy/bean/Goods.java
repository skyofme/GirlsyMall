package team.girlsy.bean;

/**
 * 
 * 商品类
 * 
 * @author 罗干
 * 
 */
public class Goods {

	private Integer id; // 商品Id
	private String name; // 商品名称
	private Integer storage; // 商品库存
	private Double price; // 商品价格
	private Float discount; // 商品折扣
	private Integer sellCount; // 商品销量
	private String type; // 商品种类
	private String desc; // 商品描述
	private String img; // 商品图片地址

	public Goods() {
		super();

	}

	public Goods(Integer id, String name, Integer storage, Double price,
			Float discount, Integer sellCount, String type, String desc,
			String img) {
		super();
		this.id = id;
		this.name = name;
		this.storage = storage;
		this.price = price;
		this.discount = discount;
		this.sellCount = sellCount;
		this.type = type;
		this.desc = desc;
		this.img = img;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getStorage() {
		return storage;
	}

	public void setStorage(Integer storage) {
		this.storage = storage;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Float getDiscount() {
		return discount;
	}

	public void setDiscount(Float discount) {
		this.discount = discount;
	}

	public Integer getSellCount() {
		return sellCount;
	}

	public void setSellCount(Integer sellCount) {
		this.sellCount = sellCount;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	@Override
	public String toString() {
		return "Goods [id=" + id + ", name=" + name + ", storage=" + storage
				+ ", price=" + price + ", discount=" + discount
				+ ", sellCount=" + sellCount + ", type=" + type + ", desc="
				+ desc + "img=" + img + "]";
	}

}
