package team.girlsy.service;

import java.util.List;

import team.girlsy.bean.Custom;

public interface CustomService {
	// 判断账户密码是否正确
	public boolean loginCheckById(int customId, String customPwd);

	// 添加顾客 返回顾客id
	public Integer addCustom(Custom custom);

	// 删除顾客
	public String delCustom(Integer customId);

	// 修改顾客
	public String modifyCustom(Custom custom);

	// 查询全部顾客
	public List<Custom> findAllList();

	// 通过Id查询顾客
	public Custom getCustomById(Integer customId);
}
