package model.domain;

public class Cart {
	private int cartNo;
	private Customer customer;
	private Product product;
	
	public Cart() {}

	public Cart(int cartNo, Customer customer, Product product) {
		super();
		this.cartNo = cartNo;
		this.customer = customer;
		this.product = product;
	}

	public int getCartNo() {
		return cartNo;
	}

	public void setCartNo(int cartNo) {
		this.cartNo = cartNo;
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
}
