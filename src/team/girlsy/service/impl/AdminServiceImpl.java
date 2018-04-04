package team.girlsy.service.impl;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import team.girlsy.bean.Admin;
import team.girlsy.dao.AdminDao;
import team.girlsy.dao.impl.AdminDaoImpl;
import team.girlsy.service.AdminService;
import team.girlsy.utils.BaseDao;

public class AdminServiceImpl implements AdminService {

	@Override
	public boolean loginCheckById(int adminId, String adminPwd) {
		AdminDao adminDao = new AdminDaoImpl();
		if (null == adminDao.getAdminById(adminId)) {
			return false;
		} else {
			Admin admin = new Admin();
			admin = adminDao.getAdminById(adminId);
			// 将获得的明文加密成md5进行和数据库的核对
			StringBuilder sb = new StringBuilder();
			// 获取数据摘要器
			try {
				MessageDigest messageDigest = MessageDigest.getInstance("MD5");
				// 将一个byte数组进行加密操作，返回的是一个加密的byte数组，二进制的哈西计算，md5加密的第一步
				byte[] digest = messageDigest.digest(adminPwd.getBytes());
				for (int i = 0; i < digest.length; i++) {
					int result = digest[i] & 0xff;
					// 将得到的int类型的值转化为16进制的值
					String hexString = Integer.toHexString(result);
					if (hexString.length() < 2) {// 系统会自动把0省略，所以添加0
						sb.append("0");
					}
					sb.append(hexString);
				}
				adminPwd = sb.toString();
			} catch (NoSuchAlgorithmException e) {// 找不到加密方式异常
				e.printStackTrace();
			}
			if (adminPwd.equals(admin.getPwd())) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String addAdmin(Admin admin) {
		String sql = "insert into admin(admin_id,admin_name,admin_pwd,admin_tel) values (?,?,?,?)";
		BaseDao.excuteUpdate(sql, admin.getId(), admin.getName(),
				admin.getPwd(), admin.getTel());
		return "添加成功";
	}

	@Override
	public String delAdmin(Integer adminId) {
		String sql = "delete from admin where admin_id = ?";
		BaseDao.excuteUpdate(sql, adminId);
		return "删除成功";
	}

	@Override
	public String modifyAdmin(Admin admin) {
		String sql = "update admin set admin_tel = ?,admin_name = ?,admin_pwd = ? where admin_id = ?";
		BaseDao.excuteUpdate(sql, admin.getTel(), admin.getName(),
				admin.getPwd(), admin.getId());
		return "修改成功";
	}

	@Override
	public List<Admin> findAllList() {
		String sql = "select * from admin";
		List<Object> result = BaseDao.excuteQuery(sql);
		List<Admin> admins = new ArrayList<Admin>();
		for (Object x : result) {
			Map<String, Object> map = (Map<String, Object>) x;
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
		for (Object x : result) {
			Map<String, Object> map = (Map<String, Object>) x;
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