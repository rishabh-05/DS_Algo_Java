package Arrays;

import java.util.Scanner;

public class Matrix_Multiplication {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 
//		int row1 = sc.nextInt();
//		int col1 = sc.nextInt();
//		int[][] m = new int[row1][col1];
//		input(m, row1, col1);
//		display(m);
//		int row2 = sc.nextInt();
//		int col2 = sc.nextInt();
//		int[][] n = new int[row2][col2];
//		input(n, row2, col1);
//		display(n);
		
		int[][] test1 = {
				{1, 2, 3},
				{4, 5, 6},
		};
		
		int[][] test2 = {
				{1, 2, 3, 4},
				{5, 6, 7, 8},
				{9, 10, 11, 12}
		};
		
		int[][] ans = multiply(test1, test2);
		display(ans);



	}
	public static void input(int[][] arr, int row, int col) {
		for(int i = 0; i<row; i++) {
			for(int j = 0; j<col; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
	}
	public static void display(int[][] arr) {
		int row = arr.length;
		int col = arr[0].length;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
	}

	public static int[][] multiply(int[][] arr1, int[][] arr2) {
		int row1 = arr1.length;
		//int row2 = arr1[0].length;
		int col1 = arr2.length;
		int col2 = arr2[0].length;
		int[][] ans = new int[row1][col2];
		
		for(int i = 0; i<row1; i++) {
			for(int j = 0; j<col2; j++) {
				int sum = 0;
				for(int k  = 0; k<col1; k++) {
					sum = sum+ arr1[i][k]*arr2[k][j];
					
				}
				ans[i][j] = sum;
			}
		}
		
		return ans;
	}
}
