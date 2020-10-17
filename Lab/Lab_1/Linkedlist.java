public class Linkedlist{

	//declaration
	int size;
	Node head;
	Node tail;
	//initialization 
	public Linkedlist(){
		size =0;
		head = null;
		tail = null;
	}
//methods of linked list
	//1.it will return the size of the list
	public int size(){
		return size;
	}
	//2.returns true if the list is empty
	public boolean isEmpty(){
		if (size() == 0){
			return true;
		}
		return false;
	}
	//3.
	public int first(){
		if (isEmpty()){
			return 0;
		}
		return head.getElement();	//to access private of node class 
	}
	//
	public int last(){
		if(isEmpty()) {
			return 0;
		}
		return tail.getElement();	//to access private of node class
	}

	public int addFirst(int value){
		Node newest = new Node(value, null);
		//when there is no linked list
		if(size() == 0) {
			head = newest;
			tail = newest;
		}
		//when there are nodes in linked list
		else{
			newest.setNext(head);
			head = newest;
		}

		size = size + 1; //increment
	}

	public int addLast(int value){
		Node newest = new Node(value, null);
		//when there is no linked list
		if(size() == 0) {
			head = newest;
			tail = newest;
		}
		//when there are nodes in linked list
		else{
			tail.setNext(newest);
			tail = newest;
		}

		size = size + 1; //increment
	}

	//remove a node from a linked list 
	public int removeFirst(){
		int deletedElement = head.getElement();
		if (size() == 0) {
			return 0;
		}
		else {
			head = head.getNext();
		}
		size = size - 1; //decerement
		return deletedElement;
	}

	class Nodes{     
		//declaration 
		private int element;
		private Node next;
	}
	//constructor
	public Nodes(int value, Node n){
		element = value;
		next = n;
	}
	//to access private class we use get element 
	public int getElement(){
		return element;
	}
	//set is used to insert element
	public void setElement(int ele){
		element = ele;
	}
	//
	public Node getNext(){
		return next;
	}
	//
	public void setNext( Node n1){
		next = n1;
	}
	public static void main(String[] args){

	}
}


//in java, class will create and object even if we dont have it cause java takes default constructor which is empty.