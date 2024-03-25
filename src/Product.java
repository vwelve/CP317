
public class Product extends Data {
	private String description;
	private double price;
	private int quantity;
	private char status;
	private int supplierId;
	
	public Product(int id, String name, String description, double price, int quantity, char status, int supplierId) {
		super(id, name);
		this.description = description;
		this.price = price;
		this.quantity = quantity;
		this.status = status;
		this.supplierId = supplierId;
	}
	
	public String getDescription() {
		return description;
	}
	
	public double getPrice() {
		return price;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public char getStatus() {
		return status;
	}
	
	public int getSupplierId() {
		return supplierId;
	}
}
