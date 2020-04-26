package model.domain;

public class Teacher extends Person {
	private Category category;
	
	public Teacher() {}
	
	public Teacher(Category category) {
		super();
		this.category = category;
	}

	public Teacher(String id, String pwd, String name, String phone, String gender, int status, Category category) {
		super(id, pwd, name, phone, gender, status);
		this.category = category;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
}
