package team.girlsy.service;

public interface ShoppingCarService {
	
	//将购物车的类别ID替换成中文
	public String changeIdToChinese(String type);
	//修改购物车里面的用户某件物品的数量
	public void updateAmount(int cusId, int goodsId, int amount);
}
