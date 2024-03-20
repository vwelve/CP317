
public class Supplier {
	private int supplierId;
	private String supplierName;
	private String supplierAddress;
	
	public Supplier(int supplierId, String supplierName, String supplierAddress) {
		this.supplierId = supplierId;
		this.supplierName = supplierName;
		this.supplierAddress = supplierAddress;
	}
	
	public int getSupplierId() {
		return supplierId;
	}
	
	public String getSupplierName() {
		return supplierName;
	}
	
	public String getSupplierAddress() {
		return supplierAddress;
	}
}
