package Arrays;

import java.util.Scanner;

public class MaxSumPath {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int t = sc.nextInt();

		while (t != 0) {

			int n = sc.nextInt();
			int n1 = sc.nextInt();
			int[] arr = new int[n];
			int[] arr1 = new int[n1];
			input(arr, n);
			input(arr1, n1);
			
			

			int sum = maxsumpath(arr, arr1);
			System.out.println(sum);
			t--;
		}
	}

	public static void input(int[] a, int len) {
		for (int i = 0; i < len; i++) {
			a[i] = sc.nextInt();
		}
	}

	public static int maxsumpath(int[] arr, int[] arr1) {
		int ans = 0;
		int i = 0;
		int j = 0;
		int sum1 = 0;
		int sum2 = 0;

		while (i < arr.length && j < arr1.length) {

			if (arr[i] < arr1[j]) {
				sum1 += arr[i];
				i++;
			} else if (arr1[j] < arr[i]) {
				sum2 += arr1[j];
				j++;
			} else {
				ans += Math.max(sum1, sum2);
				ans += arr[i];
				//System.out.println(ans);
				sum1 = 0;
				sum2 = 0;
				i++;
				j++;
			}


		}
		sum1 = 0;
		sum2 = 0;
		if (j == arr1.length) {
			while (i < arr.length) {
				sum1 += arr[i];
				i++;
			}
		}
		if (i == arr.length) {
			while (j < arr.length) {
				sum2 += arr[j];
				j++;
			}
		}
		//System.out.println(ans);
		ans = ans + Math.max(sum1, sum2);

		return ans;
	}
}
