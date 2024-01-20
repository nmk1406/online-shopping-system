package dto;

public class OrderDetail {
	private int quantity;
	private double price;
	private Order order;
	private Product product;

	public OrderDetail() {

	}

	public OrderDetail(int quantity, double price, Order order, Product product) {
		this.quantity = quantity;
		this.price = price;
		this.order = order;
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "OrderDetail [quantity=" + quantity + ", price=" + price + ", order=" + order + ", product=" + product
				+ "]";
	}
}