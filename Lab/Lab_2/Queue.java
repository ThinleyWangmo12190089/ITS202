public class Queue{
	int first = -1;
	int len = 0; //size of the array initalized as zero 
	int front = -1;
	int rear = -1;
	int [] array = new int[8];
//methods 
	//adds elements to the back of the Queue
	public void enqueue(int i){
		if(len() == 0){
			array[0] = i;
			first = array[0];
			front = 0;
			rear = 0;
		}
		else{
			array[rear+1]=i;
		}
		len = len + 1;
		System.out.println(i);
	}
	//removes an element from queue
	public int dequeue(){
		if(len() == 0){
			System.out.println("Queue is empty");
		}
		else{
			front = front + 1;
		}
		len = len - 1;
		return array[front-1];
	}
	//gives error if the queue is empty
	public int first(){
		if(len() == 0){
			return 0;
		}
		else{
			return array[front];
		}
	}
	//returns false if the queue is not empty
	public boolean isEmpty(){
		if(len() == 0){
			return true;
		}
		else{
			return false;
		}
	}
	//number of elements in a queue	
	public int len(){
		return len;
	}
}

