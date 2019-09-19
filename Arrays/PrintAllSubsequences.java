package Arrays;

import java.util.Scanner;

public class PrintAllSubsequences {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n = sc.nextInt();
		
		int[] arr = new int[n];
		input(arr, n);
		String ans = "";
		int finsize = (int) Math.pow(2, n);
		int count = 0;
		for (int i = 0; i < finsize; i++) {
			ans = "";
			int pos = 0;
			int ibin = c2binary(i);
			System.out.println(ibin);
			while (ibin != 0) {

				int rem = ibin % 10;
				if (rem != 0) {
					ans = ans + arr[pos];
				}
				pos++;
				ibin /= 10;

			}
			count++;
			System.out.print(ans + ", ");

		}
		System.out.println("\n" + count + " elements");

	}

	public static void input(int[] a, int len) {
		for (int i = 0; i < len; i++) {
			a[i] = sc.nextInt();
		}
	}

	public static int c2binary(int n) {
		int ans = 0;
		int mul = 1;
		int k = n;
		while (k != 0) {
			int h = k % 2;
			ans = ans + h * mul;
			mul *= 10;
			k = k / 2;
		}
		return ans;

	}

}
