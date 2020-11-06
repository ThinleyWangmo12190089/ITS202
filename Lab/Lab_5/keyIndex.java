public class keyIndex 
{
	public void keyfun(int a[])
	{
		int R = 256;
		int N = a.length;
		int[] aux = new int[N];
		int[] count = new int[R+1];

		//to compute frequency counts
		for (int i = 0; i < N; i++)
		{
			count [a[i]+1]++;
		}
		//to transform counts to indices 
		for (int r = 0; r < R; r++)
		{
			count[r+1] += count[r];
		}
		//to distribute the records 
		for (int i = 0; i < N; i++)
		{
			aux[count[a[i]]++] = a[i];
		}
		//to copy back
		for (int i = 0; i < N; i++)
		{
			a[i] = aux[i];
		}
		
		System.out.println("Array after sorting is: ");
		for (int i = 0; i < a.length; i++)
		{
			System.out.print(" "+a[i]);
		}
		System.out.println();
	}

	public static void main(String[] args) {
		keyIndex obj = new keyIndex();
		int a[] = {6,2,3,4,5,1};

		System.out.println("Array before sorting is: ");
		for (int i = 0; i < a.length; i++)
		{
			System.out.print(" "+a[i]);
		}
		System.out.println();
		obj.keyfun(a);
	}
}