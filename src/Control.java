import java.util.Scanner;

public class Control {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		try {
			System.out.println("Enter the product file to read from:");
			String productFile = scanner.nextLine();
			
			LinkedList<Product> products = TextFileReader.readProductFile(productFile);
			System.out.println("Loaded all lines from the Product File.");
			
			System.out.println("Enter the supplier file to read from:");
			String supplierFile = scanner.nextLine();
			
			LinkedList<Supplier> suppliers = TextFileReader.readSupplierFile(supplierFile);
			System.out.println("Loaded all lines from the Supplier File.");
			
			LinkedList<Inventory> inventory = new LinkedList<Inventory>();
			
			for (Data data: products.toArray()) {
				Product product = (Product) data;
				int productId = product.getId();
				String productName = product.getName();
				int productQuantity = product.getQuantity();
				double productPrice = product.getPrice();
				char productStatus = product.getStatus();
				int supplierId = product.getSupplierId();
				
				Supplier supplier = suppliers.search(supplierId);
				
				if (supplier != null) {
					String supplierName = supplier.getName();
					
					inventory.insert(
						new Inventory(productId, productName, productQuantity, productPrice, productStatus, supplierName)
					);
				} else {
					throw new Exception("Could not find supplier id: " + supplierId);
				}
			}
			System.out.println("Successfully loaded the InventoryList");
			
			OutputWriter.writeOutput("./src/Inventory.txt", inventory);
			
		} catch (Exception e) {
			System.out.println("");
			System.out.println("Encountered an error:");
			System.out.println(e.getMessage());
		} finally {
			scanner.nextLine();
			scanner.close();
		}
		
	}

}
