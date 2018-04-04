package team.girlsy.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;



import team.girlsy.utils.BaseDao;
import team.girlsy.bean.Admin;
import team.girlsy.bean.Custom;
import team.girlsy.dao.CustomDao;
import team.girlsy.utils.BaseDao;

public class CustomDaoImpl implements CustomDao {

	@Override
	public int addCustom(Custom custom) {
		String sql = "insert into custom(cus_id,cus_name,cus_pwd,cus_sex,cus_tel,cus_addr) value(?,?,?,?,?,?)";
		return BaseDao.excuteUpdate(sql, custom.getId(),custom.getName(),custom.getPwd(),custom.getSex(),custom.getTel(),custom.getAddr());
	}

	@Override
	public int delCustom(Integer customId) {
		String sql = "delete * from custom where cus_id = ?";
		return BaseDao.excuteUpdate(sql, customId);
	}

	@Override
	public int modifyCustom(Custom custom) {
		String sql = "update custom set cus_name = ?, cus_pwd = ?, cus_sex = ?, cus_tel = ?, cus_addr = ? where cus_id = ?";
		return BaseDao.excuteUpdate(sql, custom.getName(),custom.getPwd(),custom.getSex(),custom.getTel(),custom.getAddr(),custom.getId());
	}

	public  List<Custom> findAllList(String sch,int pageNow,int pageSize) {
		String sql = "select * from custom ";//一共有多少条记录
		sql += " where cus_id like ? or cus_name like ? or cus_sex like ? or cus_tel like ? or cus_addr like ?";
		sql += " limit "+(pageNow-1)*pageSize +","+ pageSize;
		Object[] params = {"%"+sch+"%","%"+sch+"%", "%"+sch+"%", "%"+sch+"%","%"+sch+"%"};
		ResultSet rs = BaseDao.query(sql, params);
		List<Object> result = BaseDao.excuteQuery(sql, params);
		List<Custom> customs = new ArrayList<Custom>();
		for(Object x : result){
			Map<String, Object> map = (Map<String, Object>)x;
			Custom custom = new Custom();
			custom.setId(Integer.valueOf(map.get("cus_id").toString()));
			custom.setName(map.get("cus_name").toString());			
			custom.setSex(map.get("cus_sex").toString());
			custom.setTel(map.get("cus_tel").toString());
			custom.setAddr(map.get("cus_addr").toString());
			customs.add(custom);		
		}
		return customs;
	}
	public static List<Custom> search(String sch,int pageNow,int pageSize) throws SQLException{		
		List<Custom> list = new ArrayList();
		if (sch.equals("")){
			CustomDaoImpl customDaoImpl = new CustomDaoImpl();
			list = customDaoImpl.findAllList(sch,pageNow,6);			
		}else {
			String sql = " select cus_id, cus_name, cus_sex, cus_tel, cus_addr from custom ";
			sql += " where cus_id like ? or cus_name like ? ";
			sql += " limit "+(pageNow-1)*pageSize +","+ pageSize;
			Object[] params = {"%"+sch+"%","%"+sch+"%"};
			ResultSet rs =  BaseDao.query(sql, params);
			
			while(rs.next()){
				Custom custom = new Custom();
				custom.setId(rs.getInt("cus_id"));
				custom.setName(rs.getString("cus_name"));
				custom.setSex(rs.getString("cus_sex"));
				custom.setTel(rs.getString("cus_tel"));
				custom.setAddr(rs.getString("cus_addr"));
				list.add(custom);
			}
			rs.close();
		}
		return list;
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
	public static  int queryPageCnt(String sch,int pageSize) throws SQLException {				
		if (sch.equals(null)){
			sch = "";
		}
		String sql = "select count(*) cnt from custom ";//一共有多少条记录
		sql += " where cus_id like ? or cus_name like ? or cus_sex like ? or cus_tel like ? or cus_addr like ?";		
		Object[] params = {"%"+sch+"%","%"+sch+"%", "%"+sch+"%", "%"+sch+"%","%"+sch+"%"};
		ResultSet rs = BaseDao.query(sql, params);			
		int cnt=0;
		try {
			if(rs.next()){
				cnt=(rs).getInt("cnt");
				if(cnt%pageSize==0){
				    return cnt/pageSize;
				}else{
			        return cnt/pageSize + 1; 		 
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		(rs).close();
		return 0;			
		}
	
	
	@Override
	public Custom getCUstomByName(String customName) {
		
		String sql = "select * from custom where cus_name = ? ORDER BY cus_id DESC LIMIT 1";
		List<Object> result = BaseDao.excuteQuery(sql, customName);
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
