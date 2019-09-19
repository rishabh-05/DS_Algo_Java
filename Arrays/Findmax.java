package Arrays;

import java.util.Scanner;

public class Findmax {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = sc.nextInt();
		int[] arr = new int[n];
		input(arr, n);

		findmax(arr, n);

	}

	public static void input(int[] a, int len) {
		for (int i = 0; i < len; i++) {
			a[i] = sc.nextInt();
		}
	}

	public static void findmax(int[] a, int n) {
		int max = a[0];
		int i;
		int j = 0;
		for (i = 1; i < n; i++) {
			if (a[i] > max) {
				max = a[i];
				j = i;
			}
		}
		System.out.println(max + " at position " + (j + 1));
	}
}
