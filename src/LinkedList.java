
public class LinkedList<T extends Data> {
	private Node<T> head;
	private int count = 0;
	
	public Node<T> getHead() {
		return head;
	}
	
	private void addNode(Node<T> node) {
		if (head == null) {
			head = node;
		} else {
			Node<T> curr = head;
			
			while (curr.getNext() != null) {
				curr = curr.getNext();
			}
		
			curr.setNext(node);
		}
		count++;
	}
	
	public T search(int id) {
		T product = null;
		Node<T> curr = head;
		
		while (curr != null || product != null) {
			T data = curr.getData();
			int productId = data.getId();
			if (productId == id) {
				product = data;
			} else {
				curr.getNext();
			}
		}
		
		return product;
	}
	
	public void insert(T product) {
		Node<T> node = new Node<T>(product);
		
		addNode(node);
	}
	
	public Data[] toArray() {
		Node<T> curr = head;
		Data[] list = new Data[count]; 
		
		for (int i = 0; i < count; i++) {
			Data data = curr.getData();
			list[i] = data;
			curr = curr.getNext();
		}
		
		
		return list; 
	}
	
	public int getCount() {
		return count;
	}
}
