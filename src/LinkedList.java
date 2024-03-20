
public class LinkedList {
	private Node head;
	
	public Node getHead() {
		return head;
	}
	
	private void addNode(Node node) {
		if (head == null) {
			head = node;
		} else {
			Node curr = head;
			
			while (curr.getNext() != null) {
				curr = curr.getNext();
			}
			
			curr.setNext(node);
		}
	}
	
	public Product search(int id) {
		Product product = null;
		Node curr = head;
		
		while (curr != null || product != null) {
			Product data = curr.getData();
			int productId = data.getProductID();
			if (productId == id) {
				product = data;
			} else {
				curr.getNext();
			}
		}	
		
		return product;
	}
	
	public void insert(Product product) {
		Node node = new Node(product);
		
		addNode(node);
	}
}
