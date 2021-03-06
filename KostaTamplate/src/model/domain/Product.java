package model.domain;

import java.util.Date;

public class Product {
	private String id;
	private String name;
	private int price;
	private String description;
	private String level;
	private Teacher teacher;
	private Category category;
	private Date uploadDate;
	private int validDate;
	private int status;
	
	
	private String uploadDateConvert;
	
	public Product() {}
	
	public Product(String id) {
		this.id = id;
	}
	
	public Product(String id, String name, int price, String description) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.description = description;
	}
	
	public Product(String id, String name, int price, String description, int validDate) {
		this(id, name, price, description);
		this.description = description;
		this.validDate = validDate;
	}
	
	public Product(String id, String name, int price, String description, String level, Teacher teacher,
			Category category, Date uploadDate, int validDate) {
		this(id, name, price, description, validDate);
		this.level = level;
		this.teacher = teacher;
		this.category = category;
		this.uploadDate = uploadDate;
	}
	
	public Product(String id, String name, int price, String description, String level, Teacher teacher,
			Category category, Date uploadDate, int validDate, int status) {
		this(id, name, price, description, validDate);
		this.level = level;
		this.teacher = teacher;
		this.category = category;
		this.uploadDate = uploadDate;
		this.status = status;
	}

	public int getValidDate() {
		return validDate;
	}

	public void setValidDate(int validDate) {
		this.validDate = validDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Date getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getUploadDateConvert() {
		return uploadDateConvert;
	}

	public void setUploadDateConvert(String uploadDateConvert) {
		this.uploadDateConvert = uploadDateConvert;
	}
	
	
}
