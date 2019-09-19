package Recursion;

import java.util.Scanner;

public class GeneratedSortedArrays {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		int an = sc.nextInt();
		int bn = sc.nextInt();
		int[] a = new int[an];
		int[] b = new int[bn];
		input(a, an);
		input(b, bn);
		sortedArrays(a, 0, b, 0, new int[a.length + b.length] , 0, true);
	}

	public static void input(int[] a, int an) {
		// TODO Auto-generated method stub
		for(int i = 0; i < an; i++) {
			a[i] = sc.nextInt();
		}

	}

	public static void sortedArrays(int[] A, int avidx, int[] B, int bvidx, int[] C, int cvidx, boolean flag) {

		// flag : true : A
		// flag : false : B
		if (flag) {

			for (int i = avidx; i < A.length; i++) {

				if (cvidx == 0 || A[i] > C[cvidx - 1]) {
					C[cvidx] = A[i];
					sortedArrays(A, i + 1, B, bvidx, C, cvidx + 1, !flag);
				}

			}
		} else {

			for (int i = bvidx; i < B.length; i++) {

				if (B[i] > C[cvidx - 1]) {
					C[cvidx] = B[i];

					
					display(C, cvidx);
					sortedArrays(A, avidx, B, i + 1, C, cvidx + 1, !flag);
					//display(C, cvidx);

				}

			}
		}

	}

	public static void display(int[] C, int vidx) {

		for (int i = 0; i <= vidx; i++) {
			System.out.print(C[i] + " ");
		}
		System.out.println();
	}

}
