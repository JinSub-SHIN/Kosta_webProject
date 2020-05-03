package model.domain;

import java.util.Date;;

public class OrderLine {
	private int lineNo;
	private int totalPrice;
	private Date payDate;
	private Customer customer;
	
	public OrderLine() {}
	
	/**
	 * 등록(insert) 시 lineNo은 시퀀스 값으로, payDate는 그 당시 날짜로 자동 설정된다.
	 */
	public OrderLine(int totalPrice, Customer customer) {
		super();
		this.totalPrice = totalPrice;
		this.customer = customer;
	}
		
	public OrderLine(int lineNo, int total, Date payDate, Customer customer) {
		this(total, customer);
		this.lineNo = lineNo;
		this.payDate = payDate;
	}

	public int getLineNo() {
		return lineNo;
	}

	public void setLineNo(int lineNo) {
		this.lineNo = lineNo;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Date getPayDate() {
		return payDate;
	}

	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}
