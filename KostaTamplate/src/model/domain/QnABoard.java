package model.domain;

import java.util.Date;

public class QnABoard {
	private int qaBoardNo;
	private String subject;
	private Date writeDay;
	private Customer customer;
	private Product product;
	private String title;
	private QnABoard parentNo;
	private int status;
	private int pwd;
	private int count;

	public QnABoard() {}
	public QnABoard(String subject, Customer customer, Product product, String title, int status) {
		this.subject = subject;
		this.customer = customer;
		this.product = product;
		this.title = title;
		this.status = status;
	}
	
	public QnABoard(String subject, Customer customer, Product product, String title, int status, int pwd) {
		this(subject, customer, product, title, status);
		this.pwd = pwd;
	}

	public QnABoard(int qaBoardNo, String subject, Date writeDay, Customer customer, Product product, String title,
			QnABoard parentNo, int status, int pwd, int count) {
		this(subject, customer, product, title, status, pwd);
		this.qaBoardNo = qaBoardNo;
		this.writeDay = writeDay;
		this.parentNo = parentNo;
		this.count = count;
	}

	public int getQaBoardNo() {
		return qaBoardNo;
	}

	public void setQaBoardNo(int qaBoardNo) {
		this.qaBoardNo = qaBoardNo;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Date getWriteDay() {
		return writeDay;
	}

	public void setWriteDay(Date writeDay) {
		this.writeDay = writeDay;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public QnABoard getParentNo() {
		return parentNo;
	}

	public void setParentNo(QnABoard parentNo) {
		this.parentNo = parentNo;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getPwd() {
		return pwd;
	}

	public void setPwd(int pwd) {
		this.pwd = pwd;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
}