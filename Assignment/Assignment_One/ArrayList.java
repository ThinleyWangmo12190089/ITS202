import java.util.*;
public class ArrayList
{
	double full_1over4 = 0.25;
	double full_3over4 = 0.75;
	int capacity = 4;
	static int a;
	int remove;
	int top = 0;
	static double length;
	static int Array[];	
	
	public ArrayList()
	{
		Array = new int[capacity];
	}
	//adds elements to the dynamic array 
	public void add(int e)
	{
		Array[top] = e;
		top++;
	}
	//it will not take a parameter. it deletes the last element in the dynamic array
	public void pop()
	{
		top--;
		remove = Array[top];
		Array[top] = 0;
		int count = 0;
		for(int i = 0; i < Array[i]; i++){
			count++;
		}
		a = count;
		length = (double)a/capacity;
		System.out.println("Remove Element" +remove);
	}
	//it changes the size of the array to the value of the parameter sent
	public void resize()
	{
		if(length == full_1over4) {
			int newArray[] = new int[(capacity/2)*2];
			for(int i = 0; i < Array.length; i++){
				newArray[i] = Array[i];
			}
			Array = newArray;
			capacity = capacity/2;
			for(int n : newArray) {
				System.out.print(n + " ");
			}
		}
		else if(length == full_3over4){
			int newArray[] = new int[capacity*2];
			for(int i = 0; i < Array.length; i++){
				newArray[i] = Array[i];
			}
			capacity = capacity * 2;
			Array = newArray;
			for(int j : newArray){
				System.out.print(j + " ");
			}
			System.out.println();
		}
		else{
			System.out.println("ArrayIndexOutOfBoundRange");
		}
	}
	//it will not take any parameter.
	//it will print elements present in dynamic array
	public int size()
	{
		return capacity;
	}
	//it will give the string representation of an array
	public String toString()
	{
		String s = Arrays.toString(Array);
		return s;
	}

	public static void main(String[] args) {
		ArrayList obj = new ArrayList();
		obj.add(2);
		obj.add(4);
		obj.add(6);
		obj.add(8);
		obj.pop();
		obj.resize();

		System.out.println("toString " +obj.toString());
		System.out.println("The number of elements in the new array is " +a);
		System.out.println("The size of new array is " +obj.size());
		//System.out.println("Testcase3 passed");
	}
}