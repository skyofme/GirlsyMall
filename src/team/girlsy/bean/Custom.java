package team.girlsy.bean;

/**
 * 客户类
 * 
 * @author 罗干
 *
 */
public class Custom {

	private Integer id;  // 客户Id
	private String name; // 客户姓名
	private String pwd;  // 客户密码
	private String sex;  // 客户性别
	private String tel;  // 客户号码
	private String addr; // 客户地址

	public Custom() {
		super();

	}

	public Custom(Integer id, String name, String pwd, String sex, String tel,
			String addr) {
		super();
		this.id = id;
		this.name = name;
		this.pwd = pwd;
		this.sex = sex;
		this.tel = tel;
		this.addr = addr;
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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	@Override
	public String toString() {
		return "Custom [id=" + id + ", name=" + name + ", pwd=" + pwd
				+ ", sex=" + sex + ", tel=" + tel + ", addr=" + addr + "]";
	}

}
