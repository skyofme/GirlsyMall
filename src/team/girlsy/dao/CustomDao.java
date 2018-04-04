package team.girlsy.dao;

import java.util.List;

import team.girlsy.bean.Custom;

public interface CustomDao {
	//添加顾客
	public int addCustom(Custom custom);
	//删除顾客
	public int delCustom(Integer customId);
	//修改顾客
	public int modifyCustom(Custom custom);
	//查询全部顾客
	public List<Custom> findAllList(String sch,int pageNow,int pageSize);
	//通过Id查询顾客
	public Custom getCustomById(Integer customId);
	//通过姓名查询顾客
	public Custom getCUstomByName(String customName);
}
