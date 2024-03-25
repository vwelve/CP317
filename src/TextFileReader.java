import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TextFileReader {
	
	private static int parseQuantity(String quantity) throws Exception {
		int parsedQuantity = Integer.parseInt(quantity);
		
		if (parsedQuantity < 0) {
			throw new Exception("Quantity has to be a positive number.");
		}
		
		return parsedQuantity;
	}
	
	private static double parsePrice(String price) throws Exception {
		if (price.charAt(0) != '$') {
			throw new Exception("Price has incorrect format.");
		} else if (price.indexOf('.') != -1 && price.length() - price.indexOf('.') - 1 > 2) {
			throw new Exception("Price has more than 2 decimal points.");
		}
		
		double parsedPrice = Double.parseDouble(price.substring(1));
		
		if (parsedPrice < 0) {
			throw new Exception("Price has to be a positive number.");
		}
		
		return parsedPrice;
	}
	
	private static int parseId(String id) throws Exception {
		int parsedId = Integer.parseInt(id);
		
		return parsedId;
	}
	
	private static char parseStatus(String status) throws Exception {
		return status.charAt(0);
	}
	
	public static LinkedList<Product> readProductFile(String inputFile) throws Exception {
		LinkedList<Product> productList = new LinkedList<Product>();
		try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
			String line = reader.readLine();
			while (line != null && line.trim().strip() != "") {
				String[] values = line.trim().strip().split(",");
				
				if (values.length == 7) {
					int id = parseId(values[0].trim());
					String name = values[1].trim();
					String description = values[2].trim();
					double price = parsePrice(values[3].trim());
					int quantity = parseQuantity(values[4].trim());
					char status = parseStatus(values[5].trim());
					int supplierId = parseId(values[6].trim());
					
					Product product = new Product(id, name, description, price, quantity, status, supplierId);
					productList.insert(product);
				} else {
					throw new Exception("Each line must be in format 'id,name,description,price,quantity,status,supplierId'");
				}
				
				line = reader.readLine();
			}
		} catch (IOException e) {
			throw new Exception("Cannot read from the file: " + inputFile);
		} catch (NumberFormatException e) {
			throw new Exception("Had issue converting text into numerical value.");
		} catch (IndexOutOfBoundsException e) {
			throw new Exception("Couldn't find the status of the product.");
		}
		
		return productList;
	}
	
	public static LinkedList<Supplier> readSupplierFile(String inputFile) throws Exception {
		LinkedList<Supplier> supplierList = new LinkedList<Supplier>();
		
		try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
			String line = reader.readLine();
			while (line != null && line != "") {
				String[] values = line.trim().strip().split(",");
				
				if (values.length == 5) {
					int id = parseId(values[0]);
					String name = values[1];
					String address = values[2];
					String phone = values[3];
					String email = values[4];
					
					Supplier supplier = new Supplier(id, name, address, phone, email);
					supplierList.insert(supplier);
				} else {
					throw new Exception("Each line must be in format 'id,name,address,phone,email'");
				}
				line = reader.readLine();
			}
			
		} catch (IOException e) {
			throw new Exception("Cannot read the file double check the file name.");
		} catch (NumberFormatException e) {
			throw new NumberFormatException("The types of the fields are incorrect.");
		}
		
		return supplierList;
	}
}
