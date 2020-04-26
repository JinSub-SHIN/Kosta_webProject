package model.domain;

import java.util.Date;

public class EstimateBoard {
	private int sequence;
	private String subject;
	private Customer customer;
	private Product product;
	private Date writeDay;
	private int grade;

	public EstimateBoard() {}

	public EstimateBoard(int sequence, String subject, Customer customer, Product product, Date writeDay,
			int grade) {
		super();
		this.sequence = sequence;
		this.subject = subject;
		this.customer = customer;
		this.writeDay = writeDay;
		this.product = product;
		this.grade = grade;
	}

	public int getSequence() {
		return sequence;
	}

	public void setSequence(int sequence) {
		this.sequence = sequence;
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
