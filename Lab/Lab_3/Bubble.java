import java.util.Scanner;
public class Bubble{
	public static void Bubbleup(int arr[]){
		int n = arr.length;
		int swap = 0;
		for(int i = 0; i < n; i++){
			for(int j = 1; j < (n-i); j++){
				if(arr[j-1] > arr[j]){
					swap = arr[j-1];
					arr[j-1] = arr[j];
					arr[j] = swap;
				}
			}
		}
	}
	public static void main(String[] args) {
		Scanner compare = new Scanner(System.in);
		System.out.println("Enter the length of the array: ");
		int n = compare.nextInt();

		int [] arr = new int[n];
		System.out.println("Enter the elements of the array: ");

		for(int i = 0; i < n; i++){
			arr[i] = compare.nextInt();
		}
		System.out.println("Array elements are: ");   // showing array elements using the for loop  
        for (int i=0; i<n; i++)   
            {  
                System.out.print(arr[i] + " ");  ;

            }
            System.out.println(); 
           System.out.println("Elements before bubblesort are: "); 
           for(int i:arr)
        {
            System.out.print(i + " ");
        }
        System.out.println();
        
        //After sorted
        System.out.println("Elements after bubblesort are: ");  
        Bubbleup(arr);
         for(int i:arr)
        {
            System.out.print(i + " ");
        }
        System.out.println();     
	}

}