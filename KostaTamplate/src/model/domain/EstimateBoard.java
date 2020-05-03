package model.domain;

import java.util.Date;

public class EstimateBoard {
	private int estimateNo;
	private String subject;
	private Customer customer;
	private Product product;
	private Date writeDay;
	private int grade;

	public EstimateBoard() {}
	
	public EstimateBoard(int estimateNo, String subject, int grade) {
		super();
		this.estimateNo = estimateNo;
		this.subject = subject;
		this.grade = grade;
	}

	public EstimateBoard(String subject, Customer customer, Product product,int grade) {
		super();
		this.subject = subject;
		this.customer = customer;
		this.product = product;
		this.grade = grade;
	}

	public EstimateBoard(int estimateNo, String subject, Customer customer, Product product, Date writeDay,
			int grade) {
		this(subject, customer, product, grade);
		this.estimateNo = estimateNo;
		this.writeDay = writeDay;
	}

	public int getEstimateNo() {
		return estimateNo;
	}

	public void setEstimateNo(int estimateNo) {
		this.estimateNo = estimateNo;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Date getWriteDay() {
		return writeDay;
	}

	public void setWriteDay(Date writeDay) {
		this.writeDay = writeDay;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}
}
