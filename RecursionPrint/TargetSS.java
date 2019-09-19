package RecursionPrint;

import java.util.*;

public class TargetSS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		int target = sc.nextInt();

		printSS(arr, n, target, 0, "");
		System.out.println();
		System.out.println(countSS(arr, n, target, 0, 0));

	}

	public static void printSS(int[] arr, int n, int target, int sum, String ans) {
		if (sum == target) {
			System.out.print(ans + "  ");
			return;
		}
		if (sum > target || arr.length==0) {
			return;
		}

		int[] arr_new = new int[n-1];
		for(int i=0; i<n-1; i++) {
			arr_new[i] = arr[i+1];
		}
		
		printSS(arr_new, n-1, target, sum+arr[0], ans + arr[0] +" ");
		printSS(arr_new, n-1, target, sum, ans);
		
	}
	
	public static int countSS(int[] arr, int n, int target, int sum, int count) {
		if (sum == target) {
			
			return 1;
		}
		if (sum > target || arr.length==0) {
			return 0;
		}

		int[] arr_new = new int[n-1];
		for(int i=0; i<n-1; i++) {
			arr_new[i] = arr[i+1];
		}
		
		int count1 = countSS(arr_new, n-1, target, sum+arr[0],count);
		int count2 = countSS(arr_new, n-1, target, sum,count);
		return count1+count2;
	}

}
