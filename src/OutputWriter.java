import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class OutputWriter {
	public static void writeOutput(String outputFile, LinkedList<Inventory> inventory) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
			Node<Inventory> node = inventory.getHead();
			
			while (node != null) {
				Inventory data = node.getData();
				String line = String.format("%d,%s,%d,$%.2f,%c,%s", data.getId(), data.getName(), data.getQuantity(), data.getPrice(), data.getStatus(), data.getSupplierName());
				
				writer.write(line);
				writer.newLine();
				
				node = node.getNext();
			}
			
			System.out.println("Successfully wrote Inventory to " + outputFile);
		} catch (IOException e) {
			System.out.println("Could not write to the specified file");
		}
	}
}
