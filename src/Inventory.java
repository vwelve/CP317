
public class Inventory extends Data {
	private int quantity;
	private double price;
	private char status;
	private String supplierName;
	
	public Inventory(int id, String name, int quantity, double price, char status, String supplierName) {
		super(id, name);
		this.quantity = quantity;
		this.price = price;
		this.status = status;
		this.supplierName = supplierName;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public double getPrice() {
		return price;
	}
	
	public char getStatus() {
		return status;
	}
	
	public String getSupplierName() {
		return supplierName;
	}
}
