package team.girlsy.test;

import java.util.List;

import org.junit.Test;

import team.girlsy.bean.Admin;
import team.girlsy.dao.AdminDao;
import team.girlsy.dao.impl.AdminDaoImpl;


public class AdminDaoTest {

	@Test
	public void findAllListTest(){
		AdminDao dao = new AdminDaoImpl();
		List<Admin> admins = dao.findAllList();
		for(Admin admin: admins){
			
			System.out.println("id:" + admin.getId() + " --> " + admin.getName());
		}
	}
	
	@Test
	public void getAdminByIdTest(){
		AdminDao dao = new AdminDaoImpl();
		Admin admin = dao.getAdminById(0);
		System.out.println("id:" + admin.getId() + " --> " + admin.getName());
	}
	
	@Test
	public void addAdminTest(){
		Admin admin = new Admin();
		admin.setId(19);
		admin.setName("张三");
		admin.setPwd("123");
		admin.setTel("123123456789");
		AdminDao adminDao = new AdminDaoImpl();
		if(adminDao.addAdmin(admin) == 1){
			System.out.println("添加成功");
		}
	}
	
	@Test
	public void modifyAdminTest(){
		Admin admin = new Admin();
		admin.setId(2);
		admin.setPwd("123");
		admin.setName("李四");
		admin.setTel("12312345678");
		AdminDao adminDao = new AdminDaoImpl();
		if(adminDao.modifyAdmin(admin) == 1){
			System.out.println("修改成功");
		}
	}
	
	@Test
	public void delAdmin(){
		AdminDao adminDao = new AdminDaoImpl();
		if(adminDao.delAdmin(0) == 1){
			System.out.println("删除成功");
		}
	}
}
