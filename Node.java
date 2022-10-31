//Andrew Krasuski


public class Node  {

	private String data;
	private Node next;
	private Node head;

	public Node(String i, Node f) {
		data = i;
		next = f;
	}

	public Node() {
		this(null,null);
	}

	public Node(String a) {
		data = a;
		next = null;
	}


	public void setData(String newData) {
		data = newData;
	}

	public void setNext(Node newNext) {
		next = newNext;
	}

	public String getData() {
		return data;
	}

	public Node getNext() {
		return next;
	}

	public void displayNode() {
		System.out.print(data);
	}




}
