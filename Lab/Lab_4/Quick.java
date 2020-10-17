class Quick 
{
	int partition(int arr[], int low, int high)
	{
		int pivot = arr[high];
		//index of smaller element 
		int i = (low-1);
		for (int j=low; j<high; j++)
		{
			if(arr[j] < pivot)
			{
				i++;

				//swap arr[i] and arr[j]
				int swap = arr[i];
				arr[i] = arr[j];
				arr[j] = swap;
			}
		}

		//swap arr[i+1] and arr[high] (or pivot)
		int swap = arr[i+1];
		arr[i+1] = arr[high];
		arr[high] = swap;

		return i+1;
	}

	void sort(int arr[], int low, int high)
	{
		if (low < high)
		{
			//pi is partitioning index, arr[pi] is now at right place
			int pi = partition(arr, low, high);

			//recursively sort elements before
			//partition and after partition
			sort(arr, low, pi-1);
			sort(arr, pi+1, high);
		}
	}

	//a utility function to print array of size n
	static void printArray(int arr[])
	{
		int n = arr.length;
		for(int i=0; i<n; ++i)
			System.out.print(arr[i]+" ");
		System.out.println();
	}

	//Driver program
	public static void main(String args[])
	{
		int arr[] = {10, 7, 8, 9, 1, 5};
		int n = arr.length;
		System.out.println("Unsorted Array: ");
		printArray(arr);

		Quick obj = new Quick();
		obj.sort(arr, 0, n-1);

		System.out.println("Sorted Array using quick sort: ");
		printArray(arr);
	}
}