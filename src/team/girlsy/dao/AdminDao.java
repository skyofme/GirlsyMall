package team.girlsy.dao;

import java.util.List;

import team.girlsy.bean.Admin;


public interface AdminDao {
	//添加管理员
	public int addAdmin(Admin admin);
	//删除管理员
	public int delAdmin(Integer adminId);
	//修改管理员
	public int modifyAdmin(Admin admin);
	//查询全部管理员
	public List<Admin> findAllList();
	//通过Id查询管理员
	public Admin getAdminById(Integer adminId);
}
