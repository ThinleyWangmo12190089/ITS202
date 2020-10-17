public class QueueLinkedList{
	//initialization
	Node front;
	Node rear;
	Node head;
	int len;

	public QueueLinkedList(){
		front = null;
		rear = null;
		head = null;
		len = 0;
	}
	//creating a class
	class Node{
		public int element;
		public Node next;

		//constructor
		public Node(int element, Node next){
			this.element = element;
			next = null;
		}
	}

	//
	public boolean isEmpty(){
		if(len() == 0){
			return true;
		}
		else{
			return false;
		}
	}
	//
	public int len(){
		return len;
	}
	//
	public int first(){
		if(isEmpty()){
			return 0;
		}
		else{
			return front.element;
		}
	}
	public void enqueue(int n){
		Node newest = new Node(n, null);
		if(this.isEmpty()){
			this.head = newest;
			this.rear = newest;
			this.front = newest;
		}
		else{
			this.rear.next = newest;
			this.rear = newest;
		}
		len = len + 1;
	}
	//
	public int dequeue(){
		int x = front.element;
		
		if(isEmpty()){
			return 0;
		}

		else{
			front = front.next;
		}
		len = len - 1;
		return x;
	}
	public static void main(String[] args){
		QueueLinkedList obj = new QueueLinkedList();

		obj.enqueue(2);
        obj.enqueue(3);
        obj.enqueue(6);
        
        assert(obj.isEmpty() == false);
        assert(obj.len() == 3);
        assert(obj.first() == 3);
        assert(obj.dequeue() == 3);
        assert(obj.len() == 2);
        assert(obj.first() == 2);  

       /*System.out.println(obj.isEmpty());
        System.out.println(obj.len());
        System.out.println(obj.first());
        System.out.println(obj.dequeue());
        System.out.println(obj.len());
        System.out.println(obj.first());*/
        System.out.println("All test cases Passed!");
	}
}