package model.domain;

public class GangiMokRok {

	private Product product;
	private Category category;		
	
	public GangiMokRok() {}

	public GangiMokRok(Product product, Category category) {
		super();
		this.product = product;
		this.category = category;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "GangiMokRok [product=" + product + ", category=" + category + "]";
	}

   
    
	
}
