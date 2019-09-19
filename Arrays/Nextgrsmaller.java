package Arrays;

import java.util.Scanner;

public class Nextgrsmaller {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int t = sc.nextInt();
		while (t != 0) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			input(arr, n);

			nextgrsm(arr, n);

			t--;
		}

	}

	public static void input(int[] a, int len) {
		for (int i = 0; i < len; i++) {
			a[i] = sc.nextInt();
		}
	}

	public static void nextgrsm(int[] arr, int n) {

		for (int i = 0; i < n; i++) {
			int flag = -1;
			int elem = -1;
			int k = -1;
			for (int j = i + 1; j < n; j++) {

				if (arr[j] > arr[i]) {
					flag = 1;
					elem = arr[j];
					k = j + 1;
					break;
				}
			}

			while (k < n && flag == 1) {
				if (arr[k] < elem) {
					elem = arr[k];
					flag = 2;
					break;
				}

				k++;
			}
			if (flag == 2) {
				System.out.print(elem + " ");
				// break;
			}

			else if (flag < 2) {
				elem = -1;
				System.out.print(elem + " ");
			}

		}
		System.out.println();
	}

}
