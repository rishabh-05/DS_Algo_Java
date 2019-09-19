package Recursion;

import java.util.*;

public class SplitArrays {
	public static void main(String args[]) {
		// Your Code Here
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}

		splitArray(a, 0, 0, "", 0, "");
		System.out.println(countArray(a, 0, 0, 0));
	}

	public static void splitArray(int[] arr, int vidx, int g1sum, String g1str, int g2sum, String g2str) {

		if (vidx == arr.length) {

			if (g1sum == g2sum) {
				System.out.println(g1str + "and " + g2str);
			}

			return;
		}
		splitArray(arr, vidx + 1, g1sum + arr[vidx], g1str + arr[vidx] + " ", g2sum, g2str);

		splitArray(arr, vidx + 1, g1sum, g1str, g2sum + arr[vidx], g2str + arr[vidx] + " ");

	}

	public static int countArray(int[] arr, int vidx, int g1sum, int g2sum) {

		if (vidx == arr.length) {

			if (g1sum == g2sum) {
				return 1;
			}

			return 0;
		}
		int c = 0;
		c += countArray(arr, vidx + 1, g1sum + arr[vidx], g2sum);

		c += countArray(arr, vidx + 1, g1sum, g2sum + arr[vidx]);
		
		return c;

	}
}
