public class QueueTest{
	public static void main(String[] args) {
		Queue obj = new Queue();
		obj.enqueue(2);
		obj.enqueue(3);
		obj.enqueue(4);
		obj.enqueue(5);
		obj.enqueue(6);
		obj.enqueue(7);
		obj.enqueue(8);
		System.out.println("You have removed a number:" +obj.dequeue());
		System.out.println("First element is:" +obj.first());
		System.out.println("Checking if the size of the array is empty:" +obj.isEmpty());
		System.out.println("Number of elements in a queue:" +obj.len());
	}
}