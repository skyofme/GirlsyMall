package team.girlsy.service.impl;

import team.girlsy.dao.ShoppingCarDao;
import team.girlsy.dao.impl.ShoppingCarDaoImpl;
import team.girlsy.service.ShoppingCarService;

public class ShoppingCarServiceImpl implements ShoppingCarService{

	@Override
	public String changeIdToChinese(String type) {
		if (type.equals("1")) {
			return "食品";
		}
		if (type.equals("2")) {
			return "生活用品";
		}
		if (type.equals("3")) {
			return "衣物";
		}
		if (type.equals("4")) {
			return "电器";
		}else{
			return "";
		}
	}

	@Override
	public void updateAmount(int cusId, int goodsId, int amount) {
		// TODO Auto-generated method stub
		ShoppingCarDao shoppingCarDao = new ShoppingCarDaoImpl();
		int a = shoppingCarDao.updateShoppingCarAmount(cusId, goodsId, amount);
	}
}
