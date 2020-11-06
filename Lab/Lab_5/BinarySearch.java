public class BinarySearch
{
	public static int binary(int array[], int low, int high, int key)
	{
		if(high>=low)
		{
			int mid = low+(high-low)/2;
			
			if(array[mid]==key)
			{
				return mid;
			}
			else if(array[mid]>key)
			{
				return binary(array,low,high-1,key);
			}
			else
			{
				return binary(array,low,high+1,key);
			}
		}
		return - 1;
	}
	public static void main(String[] args) {
		BinarySearch obj = new BinarySearch();
		int array[] = {1,2,3,4,5,6,7,8,9};
		int key = 6;
		int i = array.length;
		int display = obj.binary(array,0,i-1,key);
		if(display == -1)
		{
			System.out.println("Element not found in array");
		}
		else
		{
			System.out.println("Element is found in array");
		}
		System.out.println(""+key);
		System.out.println(key+" is found at index:"+binary(array,0,i-1,key));
	}
}