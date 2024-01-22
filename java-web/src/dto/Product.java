package dto;

public class Product {
	private int id;
	private String name;
	private int quantity;
	private Double price;
	private String description;
	private String image;
	private int status;
	private Category category;

	public Product() {

	}
	
	public Product(String name, int quantity, Double price, String description, String image, int status,
			Category category) {
		super();
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.description = description;
		this.image = image;
		this.status = status;
		this.category = category;
	}

	public Product(int id, String name, int quantity, Double price, String description, String image, int status,
			Category category) {
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.description = description;
		this.image = image;
		this.status = status;
		this.category = category;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", quantity=" + quantity + ", price=" + price + ", description="
				+ description + ", image=" + image + ", status=" + status + ", category=" + category + "]";
	}
}