package team.girlsy.service;

import java.util.List;

import team.girlsy.bean.Admin;

public interface AdminService {

	// 判断账户密码是否正确
	public boolean loginCheckById(int adminId, String adminPwd);

	// 添加管理员
	public String addAdmin(Admin admin);

	// 删除管理员
	public String delAdmin(Integer adminId);

	// 修改管理员
	public String modifyAdmin(Admin admin);

	// 查询全部管理员
	public List<Admin> findAllList();

	// 通过Id查询管理员
	public Admin getAdminById(Integer adminId);
}
