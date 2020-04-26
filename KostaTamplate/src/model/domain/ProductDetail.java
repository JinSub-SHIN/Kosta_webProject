package model.domain;

public class ProductDetail {
	private String chapter;
	private String url;
	private String title;
	private Storage storage;
	private Product product;
	
	public ProductDetail() {}

	public ProductDetail(String chapter, String url, String title, Storage storage, Product product) {
		super();
		this.chapter = chapter;
		this.url = url;
		this.title = title;
		this.storage = storage;
		this.product = product;
	}

	public String getChapter() {
		return chapter;
	}

	public void setChapter(String chapter) {
		this.chapter = chapter;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Storage getStorage() {
		return storage;
	}

	public void setStorage(Storage storage) {
		this.storage = storage;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
}
