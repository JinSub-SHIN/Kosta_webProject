package model.domain;

import java.util.Date;

public class OrderItem {
	private int itemNo;
	private Date endDate;
	private int isRefund;
	private OrderLine orderLine;
	private Product product;
	
	public OrderItem() {}
	
	
	/**
	 * 등록(insert) 시 itemNo은 시퀀스 값으로, isRefund는 0(구매)로 자동 설정된다.
	 */
	
	public OrderItem(OrderLine orderLine, Product product) {
		this.orderLine = orderLine;
		this.product = product;
	}
	
	public OrderItem(Date endDate, OrderLine orderLine, Product product) {
		super();
		this.endDate = endDate;
		this.orderLine = orderLine;
		this.product = product;
	}

	public OrderItem(int itemNo, Date endDate, int isRefund, OrderLine orderLine, Product product) {
		this(endDate, orderLine, product);
		this.itemNo = itemNo;
		this.isRefund = isRefund;
	}

	public int getItemNo() {
		return itemNo;
	}

	public void setItemNo(int itemNo) {
		this.itemNo = itemNo;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getIsRefund() {
		return isRefund;
	}

	public void setIsRefund(int isRefund) {
		this.isRefund = isRefund;
	}

	public OrderLine getOrderLine() {
		return orderLine;
	}

	public void setOrderLine(OrderLine orderLine) {
		this.orderLine = orderLine;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
}
