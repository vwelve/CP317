import java.util.Scanner;

public class Control {

	public static void main(String[] args) {
		try {
			Scanner scanner = new Scanner(System.in);
			
			System.out.println("Enter the product file to read from:");
			String productFile = scanner.nextLine();
			
			LinkedList<Product> products = TextFileReader.readProductFile(productFile);
			
			System.out.println("Enter the supplier file to read from:");
			String supplierFile = scanner.nextLine();
			
			LinkedList<Supplier> suppliers = TextFileReader.readSupplierFile(supplierFile);
			
			scanner.close();
			
			LinkedList<Inventory> inventory = new LinkedList<Inventory>();
			
			for (Data data: products.toArray()) {
				Product product = (Product) data;
				int productId = product.getId();
				String productName = product.getName();
				int productQuantity = product.getQuantity();
				double productPrice = product.getPrice();
				char productStatus = product.getStatus();
				
				Supplier supplier = suppliers.search(productId);
				
				if (supplier != null) {
					String supplierName = supplier.getName();
					
					inventory.insert(
						new Inventory(productId, productName, productQuantity, productPrice, productStatus, supplierName)
					);
				} else {
					throw new Exception("Some of the products have invalid supplier ids");
				}
			}
			
			OutputWriter.writeOutput("./src/Inventory.txt", inventory);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
