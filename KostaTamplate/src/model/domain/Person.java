package model.domain;

public class Person {
	private String id;
	private String pwd;
	private String name;
	private String phone;
	private String gender;
	private int status;
	
	public Person() {}
	
	public Person(String id, String pwd, String phone, int status) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.phone = phone;
		this.status = status;
	}
	
	public Person(String id, String pwd, String name, String phone, String gender, int status) {
		this(id, pwd, phone, status);
		this.name = name;
		this.gender = gender;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
}
