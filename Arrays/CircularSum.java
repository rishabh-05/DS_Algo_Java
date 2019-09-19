package Arrays;

import java.util.Scanner;

public class CircularSum {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int t = sc.nextInt();
		while (t != 0) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			input(arr, n);
			int sum = findmaxsum(arr, n);
			System.out.println(sum);
			t--;
		}

	}

	public static void input(int[] a, int len) {
		for (int i = 0; i < len; i++) {
			a[i] = sc.nextInt();
		}
	}

	public static int findmaxsum(int[] arr, int n) {
		int sum = 0;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			sum = 0;
			int k = i;
			for (int j = 0; j < n; j++) {

				if (k >= n) {
					k = k - n;
				}
				sum = sum + arr[k];
				if (sum > max) {
					max = sum;
				}
				k++;
			}
			System.out.println(max);
		}
		return max;

	}

}
