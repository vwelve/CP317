
public class Node {
	private Product data;
	private Node next;
	
	public Node(Product data) {
		assert(data == null);
		
		this.data = data;
		next = null;
	}
	
	public Product getData() {
		return data;
	}
	
	public Node getNext() {
		return next;
	}
	
	public void setNext(Node node) {
		this.next = node;
	}
	
	public boolean equals(Node node) {
		return false;
		
	}
}
