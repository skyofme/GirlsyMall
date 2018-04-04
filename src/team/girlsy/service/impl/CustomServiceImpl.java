package team.girlsy.service.impl;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import team.girlsy.bean.Custom;
import team.girlsy.dao.CustomDao;
import team.girlsy.dao.impl.CustomDaoImpl;
import team.girlsy.service.CustomService;
import team.girlsy.utils.BaseDao;

public class CustomServiceImpl implements CustomService {
 
	@Override
	public boolean loginCheckById(int customId, String customPwd) {
		CustomDao customDao = new CustomDaoImpl();
		
		if(null == customDao.getCustomById(customId)){
			return false;			
		}
		
		else {
			Custom custom = new Custom();
			custom = customDao.getCustomById(customId);
			if (customPwd.equals(custom.getPwd())) {
				return true;
			}
		}
		return false;
	}
	
	//需要返回id
	@Override
	public Integer addCustom(Custom custom) {
		String sql = "insert into custom(cus_name,cus_pwd,cus_sex,cus_tel,cus_addr) value(?,?,?,?,?)";
		String name = custom.getName();
		CustomDao c = new CustomDaoImpl(); 
		
		/*if (c.getCUstomByName(name) != null) {
			System.out.println("存在同名用户");
			System.out.println("添加失败");
			return -1;
		}*/
		
		BaseDao.excuteUpdate(sql, custom.getName(),custom.getPwd(),custom.getSex(),custom.getTel(),custom.getAddr());
		custom = c.getCUstomByName(name);
		System.out.println(custom);
		System.out.println("添加成功" + "id->" + custom.getId());
		return custom.getId();
	}

	@Override
	public String delCustom(Integer customId) {
		String sql = "delete * from custom where cus_id = ?";
		BaseDao.excuteUpdate(sql, customId);
		return "删除成功";
	}

	@Override
	public String modifyCustom(Custom custom) {
		String sql = "update custom set cus_name = ?, cus_pwd = ?, cus_sex = ?, cus_tel = ?, cus_addr = ? where cus_id = ?";
		BaseDao.excuteUpdate(sql, custom.getName(),custom.getPwd(),custom.getSex(),custom.getTel(),custom.getAddr(),custom.getId());
		return "修改成功";
	}

	@Override
	public List<Custom> findAllList() {
		String sql = "select * from custom";
		List<Object> result = BaseDao.excuteQuery(sql);
		List<Custom> customs = new ArrayList<Custom>();
		for(Object x : result){
			Map<String, Object> map = (Map<String, Object>)x;
			Custom custom = new Custom();
			custom.setId(Integer.valueOf(map.get("cus_id").toString()));
			custom.setName(map.get("cus_name").toString());
			custom.setPwd(map.get("cus_pwd").toString());
			custom.setSex(map.get("cus_sex").toString());
			custom.setTel(map.get("cus_tel").toString());
			custom.setAddr(map.get("cus_addr").toString());
			customs.add(custom);
		}
		return customs;
	}

	@Override
	public Custom getCustomById(Integer customId) {
		String sql = "select * from custom where cus_id = ?";
		List<Object> result = BaseDao.excuteQuery(sql, customId);
		for(Object x : result){
			Map<String, Object> map = (Map<String, Object>)x;
			Custom custom = new Custom();
			custom.setId(Integer.valueOf(map.get("cus_id").toString()));
			custom.setName(map.get("cus_name").toString());
			custom.setPwd(map.get("cus_pwd").toString());
			custom.setSex(map.get("cus_sex").toString());
			custom.setTel(map.get("cus_tel").toString());
			custom.setAddr(map.get("cus_addr").toString());
			return custom;
		}
		return null;
	}
}
