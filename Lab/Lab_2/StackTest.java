public class StackTest{
	public static void main(String[] args) {
		Stack obj = new Stack();
		obj.push(2);
		obj.push(4);
		obj.push(6);
		obj.push(8);
		obj.push(10);
		obj.push(12);	

		System.out.println("The element that has been removed is: "+obj.pop());
		System.out.println("The element which is on top is: "+obj.top());
		System.out.println("The size of the array is: "+obj.size());
		System.out.println(obj.isEmpty());
	}
}