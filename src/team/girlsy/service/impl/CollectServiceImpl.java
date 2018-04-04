package team.girlsy.service.impl;

import team.girlsy.service.CollectService;

public class CollectServiceImpl implements CollectService{

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

}
