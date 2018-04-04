package team.girlsy.bean;

/**
 * 管理员类
 * 
 * @author 罗干
 * 
 */
public class Admin {
	private Integer id; // 管理员 Id
	private String name; // 管理员姓名
	private String pwd; // 管理员密码
	private String tel; // 管理员电话

	public Admin() {
		super();

	}

	public Admin(Integer id, String name, String pwd, String tel) {
		super();
		this.id = id;
		this.name = name;
		this.pwd = pwd;
		this.tel = tel;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", name=" + name + ", pwd=" + pwd + ", tel="
				+ tel + "]";
	}

}
