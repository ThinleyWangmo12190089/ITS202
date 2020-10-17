import java.util.Scanner;
public class Insertion{

	public static void insertion(int swap[]){
		int n = swap.length;
		for(int q = 1; q < n; q++){
			int o = swap[q];
			int i = q-1;

			while((i > -1) && swap[i] > o){
				swap[i+1] = swap[i];
				i--;
			}
			swap[i+1]=o;
		}
	}
	public static void main(String[] args) {
		//size of the array
		Scanner compare = new Scanner(System.in);
		System.out.println("Enter the length of the array: ");
		int i = compare.nextInt();

		int arr[] = new int[i];

		//user input
		System.out.println("Enter elements of the array: ");
		for(int j = 0; j < i; j++){
			arr [j] = compare.nextInt();
		}
		System.out.println("Elements before Insertion sort are: ");
		for(int k = 0; k < i; k++){
			System.out.print(arr[k] + " ");
		}
		System.out.println();

		System.out.println("Elements after Insertion sort are: ");
		insertion(arr);
		for(int k:arr){
			System.out.print(k + " ");
		}
		System.out.println();
	}
}