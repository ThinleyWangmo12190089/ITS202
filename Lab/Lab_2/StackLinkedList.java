public class StackLinkedList{
	//initialization
	Node top;
	Node head;
	Node tail;
	int size;

	public StackLinkedList(){
		top = null;
		head = null;
		tail = null;
		size = 0;
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
		if(this.top == null){
			return true;
		}
		else{
			return false;
		}
	}
	//
	public int size(){
		return size;
	}
	//
	public int top(){
		if(isEmpty()){
			return 0;
		}
		else{
			return top.element;
		}
	}
	//
	public void push(int n){
		Node newest = new Node(n, null);
		if(this.isEmpty()){
			this.head = newest;
			this.top = newest;
			this.tail = newest;
		}
		else{
			this.top.next = newest;
			this.top = newest;
		}
		size = size + 1;
	}
	public int pop(){
		if(this.isEmpty()){
			return 0;
		}
		else{
			int x = this.top.element;
			if(this.head == this.top){
				this.top = null;
				this.head = null;
			}
			else{
				Node newest = this.head;
				while(newest.next != this.top)
				newest = newest.next;
				newest.next = null;
				this.top = newest;
			}
			size = size - 1;
			return x;
		}
	}
	//
	public static void main(String[] args) {
		StackLinkedList obj = new StackLinkedList();

		obj.push(2);
		obj.push(4);
		obj.push(6);


        assert(obj.isEmpty() == false);
        assert(obj.size() == 3);
        assert(obj.top() == 3);
        assert(obj.pop() == 3);
        assert(obj.size() == 2);
        assert(obj.top() == 2);
        assert(obj.size() == 2);

        System.out.println("All test cases Passed!");
        
        /*System.out.println(obj.isEmpty());
        System.out.println(obj.size());
        System.out.println(obj.top());
        System.out.println(obj.pop());
        System.out.println(obj.size());
        System.out.println(obj.top());
        System.out.println(obj.size());*/

	}
}