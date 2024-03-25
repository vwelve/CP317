
public class Node<T extends Data> {
	private T data;
	private Node<T> next;
	
	public Node(T data) {
		assert(data == null);
		
		this.data = data;
		next = null;
	}
	
	public T getData() {
		return data;
	}
	
	public Node<T> getNext() {
		return next;
	}
	
	public void setNext(Node<T> node) {
		this.next = node;
	}
	
	public boolean equals(Node<T> node) {
		return false;
		
	}
}
