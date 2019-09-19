package Arrays;

import java.util.*;

public class Main {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int t = sc.nextInt();

		while (t != 0) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			input(arr, n);

			rainwater(arr, n);

			t--;
		}

	}

	public static void input(int[] a, int len) {
		for (int i = 0; i < len; i++) {
			a[i] = sc.nextInt();
		}
	}

	public static void rainwater(int[] arr, int n) {
		int ma = 0;
		for (int i = 0; i < n; i++) {
			if (arr[i] > ma) {
				ma = arr[i];
			}
		}

		int max = 0;
		int i = 0;
		int j = 0;
		int h = 0;
		int total = 0;
		int sum = 0;
		int min = 0;
		while (ma != 0) {
			max = 0;
			sum = 0;
			min = 0;
			for (i = 0; i < n - 2; i++) {

				for (j = i + 2; j < n; j++) {

					sum = 0;

					min = Math.min(arr[i], arr[j]);
					h = min;

					for (int k = i + 1; k < j; k++) {

						sum = sum + Math.max((min - arr[k]), 0);
					}
					if (sum > max) {
						max = sum;

					}
				}

				// System.out.println(sum);

			}
			for (int i1 = 0; i1 < n; i1++) {
				int temp = arr[i1] - h;
				arr[i1] = Math.max(temp, 0);
			}
			total = total + max;
			ma--;
			System.out.println(total);
		}
		

	}
}
