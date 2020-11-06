public class LinearSearch
{
	public static int linearSearch(int array[], int key) 
	{
		for(int i = 0; i < array.length; i++)
		{
			if(array[i] == key)
			{
				return i;
			}
		}

		return - 1;
	}

	public static void main(String[] args)
	{
		int array[] = {5,10,15,20,25,30,35};
		int key = 20;

		int display = linearSearch(array, key);
		if(display == -1)
		{
			System.out.println("Element not Found in array");
		}
		else 
		{
			System.out.println("Element found in array");
		}
		System.out.println(""+key);
		System.out.println(key+" is found at index:"+linearSearch(array, key));
	}
}