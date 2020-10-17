import java.util.Scanner;
public class selection{
	public static void main(String[] args) {
		//size of the array 
		Scanner c = new Scanner(System.in);
		System.out.println("Enter the length of the array: ");
		//scanner variable  
		int n = c.nextInt();                                                                                                                                                                                                                                                                                                                                       
		int array[] = new int[n];
		//user input
		System.out.println("Enter elements of the array: ");
		
		for(int i = 0; i < n; i++){
			int a = c.nextInt();
			array[i] = a;
		}
		System.out.println("Elements before selection sort are: ");
		for(int j = 0; j < n; j++){
			System.out.print(array[j] + " ");
		}
		//performing selection sort
		for(int i = 0; i < n; i ++){
			for(int k = i+1; k<n; k++){
				if (array[i] > array[k])
				{
					int temp = array[i];
					array[i] = array[k];
					array[k] = temp;
				}
			}
		}
		System.out.print("\nElements after selection sort are: ");
		System.out.println();
		for(int i=0; i<n; i++){
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
}