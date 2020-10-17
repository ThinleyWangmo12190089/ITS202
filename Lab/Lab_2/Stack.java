public class Stack{
	//initialization and declartaion 
	int size = 0;
	int top = -1;
	int smax = 10;
	int [] array = new int[smax];

//methods
	//adds elements to the top of the stack 
	public void push(int i){
		if(size() == 0){
			array[0] = i;
			top = 0;
		}
		else{
			array[top + 1] = i;
			top = top +1;
		}
		size = size + 1;
		System.out.println(i);
	}

	//removes and returns the top element from the stack 
	public int pop(){
		if(size() == 0){
			System.out.println("Null");
		}
		else{
			top = top -1;
			size = size -1;
		}
		return array[top + 1];
	}
	//returns the top of the element 
	public int top(){
		return array[top];
	}
	//returns the size of the array
	public int size(){
		return size;
	}
	//if the size is not empty it will print false 
	public boolean isEmpty(){
		if(size()==0){
			return true;
		}
		return false;
	}

}
