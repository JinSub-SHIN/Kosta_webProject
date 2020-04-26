package model.domain;

public class Admin extends Person {
	private String accessNo;
	
	public Admin() {}

	public Admin(String accessNo) {
		super();
		this.accessNo = accessNo;
	}

	public String getAccessNo() {
		return accessNo;
	}

	public void setAccessNo(String accessNo) {
		this.accessNo = accessNo;
	}
}
