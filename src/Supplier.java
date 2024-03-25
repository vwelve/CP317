
public class Supplier extends Data {
	private String address;
	private String phone;
	private String email;
	
	public Supplier(int id, String name, String address, String phone, String email) {
		super(id, name);
		this.address = address;
		this.phone = phone;
		this.email = email;
	}
	
	public String getAddress() {
		return address;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public String getEmail() {
		return email;
	}
}
