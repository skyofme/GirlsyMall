package team.girlsy.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import team.girlsy.bean.Admin;
import team.girlsy.dao.AdminDao;
import team.girlsy.utils.BaseDao;

public class AdminDaoImpl implements AdminDao {

	@Override
	public int addAdmin(Admin admin) {
		String sql = "insert into admin(admin_id,admin_name,admin_pwd,admin_tel) values (?,?,?,?)";
		return BaseDao.excuteUpdate(sql, admin.getId(),admin.getName(),admin.getPwd(),admin.getTel());
	}

	@Override
	public int delAdmin(Integer adminId) {
		String sql = "delete from admin where admin_id = ?";
		return BaseDao.excuteUpdate(sql, adminId);
	}

	@Override
	public int modifyAdmin(Admin admin) {
		String sql = "update admin set admin_tel = ?,admin_name = ?,admin_pwd = ? where admin_id = ?";
		return BaseDao.excuteUpdate(sql, admin.getTel(),admin.getName(),admin.getPwd(),admin.getId());
	}

	@Override
	public List<Admin> findAllList() {
		String sql = "select * from admin";
		List<Object> result = BaseDao.excuteQuery(sql);
		List<Admin> admins = new ArrayList<Admin>();
		for(Object x : result){
			Map<String, Object> map = (Map<String, Object>)x;
			Admin admin = new Admin();
			admin.setId(Integer.valueOf(map.get("admin_id").toString()));
			admin.setName(map.get("admin_name").toString());
			admin.setPwd(map.get("admin_pwd").toString());
			admin.setTel(map.get("admin_tel").toString());
			admins.add(admin);
		}
		return admins;
	}

	@Override
	public Admin getAdminById(Integer adminId) {
		String sql = "select * from admin where admin_id = ?";
		List<Object> result = BaseDao.excuteQuery(sql, adminId);
		for(Object x : result){
			Map<String, Object> map = (Map<String, Object>)x;
			Admin admin = new Admin();
			admin.setId(Integer.valueOf(map.get("admin_id").toString()));
			admin.setName(map.get("admin_name").toString());
			admin.setPwd(map.get("admin_pwd").toString());
			admin.setTel(map.get("admin_tel").toString());
			return admin;
		}
		return null;
	}
}
