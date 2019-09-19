package RecursionPrint;

import java.util.*;

/*
 * Initially, there is an array, A , containing 'N' integers.

In each move, Vivek must divide the array into  two non-empty contiguous parts such that the sum of 
the elements in the left part is equal  to the sum of the elements in the right part.
 If Vivek can make such a move, he gets '1' point; otherwise, the game ends.
After each successful move, Vivek have to discards either the left part or the right 
part and continues playing by using 
 * 
 */

public class VivekLovesArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		int sum = 0;
		for(int i = 0; i<n; i++) {
			arr[i] = sc.nextInt();
			sum += arr[i];
		}
		System.out.println(SplitEqually(arr, 0, sum, ""));
	}
	
	public static int SplitEqually(int[] arr, int left, int sum, String ans) {
		
		if(left == sum - left) {
			System.out.println(ans + " ");
			return 1;
		}
		
		int i = 0;
		int sum1 = 0;
		int count1 = 0;
		int count2 = 0;
		for(; i<arr.length; i++) {
			sum1 += arr[i];
			if(isEqual(sum1, arr, i )) {
				int[] arr1 = new int[i];
				int[] arr2 = new int[arr.length-i];
				for(int j =0; j<arr.length; j++) {
					if(j<i) {
						arr1[j] = arr[j];
					}else {
						arr2[j-i] = arr[j];
					}
					
				}
				int sum11 = arrsum(arr1);
				int sum22 = arrsum(arr2);
				count1 += SplitEqually(arr1, 0, sum11, ans + arr[i]);
				count2 += SplitEqually(arr2, 0, sum22 , ans+ arr[i]);
			}
		}
		
		return Math.max(count1, count2);
		
	}
	
	public static boolean isEqual(int sum1, int[] arr, int i) {
		int sumjj = 0;
		for(int j = i; j<arr.length; j++) {
			sumjj += arr[j];
		}
		if(sum1==sumjj) {
			return true;
		} else {
			return false;
		}
	}
	public static int arrsum(int[] arr) {
		int sum = 0;
		for(int val : arr) {
			sum+= val;
		}
		return sum;
	}

}
