public class LSD 
{
	public static void sort(String [] a, int W)
	{
		//sort a[] on leading W characters
		W = 5;
		int N = a.length;
		int R = 256;
		String[] aux = new String[N];
		//sort by key-indexed counting on dth char
		for (int d = W-1; d >= 0; d--)
		{
			int[] count = new int[R+1]; 
			//to compute frequency count 
			for(int i = 0; i < N; i++)
			{
				count [a[i].charAt(d) + 1]++;
			}
			//to transform counts to indcies
			for(int r = 0; r < R; r++)
			{
				count[r+1] += count[r];
			}
			//distributes
			for(int i = 0; i < N; i++)
			{
				aux[count [a[i].charAt(d)]++] = a[i];
			}
			// to copy back 
			for(int i=0; i < N; i++)
			{
				a[i] = aux[i];
			}		
		}
		System.out.println("-----------Array after sorting is: ---------------");
			for (int i = 0; i < a.length; i++)
			{
				System.out.print(a[i]+" ");
			}
			System.out.println();	
		
	}
	public static void main(String[] args) 
	{
		LSD obj = new LSD();
		String a[] = {"sonam", "karma", "choki", "peshi"};
		System.out.println("-----------Array before sorting is: ----------------");
		for (int i = 0; i < a.length; i++)
		{
			System.out.print(a[i]+" ");
		}
		System.out.println();
		obj.sort(a,5);
	}
}