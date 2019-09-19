package RecursionPrint;

import java.util.Scanner;

public class SplitArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i =0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		int sum = 0;
		for(int val : arr) {
			sum+=val;
		}
		splitArray(arr, 0, "", sum);

	}
	
	public static void splitArray(int[] arr, int index, String ans, int sum) {
		
		
	}

	

}
