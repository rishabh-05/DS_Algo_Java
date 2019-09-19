package Arrays;

import java.util.Scanner;

public class TwoDArrayDemo {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// jagged array input-----with different columns
//		int rows = sc.nextInt();
//		int[][] arr = new int[rows][];
//		input(arr, rows);
//		display(arr);

		int[][] test = { 
				{ 1, 2, 3, 4, 5 }, 
				{ 6, 7, 8, 9, 10 },
				{ 11, 12, 13, 14, 15},
				{16, 17, 18, 19, 20 },
				{21, 22, 23, 24, 25}
				};
		spiraldisplay(test);

	}

	public static void input(int[][] arr, int rows) {

		for (int i = 0; i < rows; i++) {
			int cols = sc.nextInt();
			arr[i] = new int[cols];

			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
	}

	public static void display(int[][] arr) {

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
	}

	public static void verticaldisplay(int[][] arr) {
		for (int i = 0; i < arr[0].length; i++) {
			for (int j = 0; j < arr.length; j++) {
				System.out.print(arr[j][i] + "\t");
			}
			// System.out.println();
		}
	}

	public static void wavedisplay(int[][] arr) {
		for (int i = 0; i < arr[0].length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (i % 2 == 0)
					System.out.print(arr[j][i] + "\t");
				else
					System.out.print(arr[arr.length - 1 - j][i] + "\t");
			}
			// System.out.println();
		}
	}

	public static void spiraldisplay(int[][] arr) {
		/*
		 * 4 operations 
		 * printdown 
		 * printright 
		 * printup 
		 * printleft
		 */
		
		int rowstart = 0;
		int rowend = arr.length-1;
		int colstart = 0;
		int colend = arr[0].length-1;
		int total = arr.length*arr[0].length;  //no of elements
		int count = 0;
		// ------printdown----------
		// count<elem cond necessary bcoz for loop cond can fail. eg 3X5
while(count<total) {
		for (int i = rowstart; i <= rowend&&count<total; i++) {
			System.out.print(arr[i][colstart]+ " ");
			count++;
		}
		colstart++;

		// ------printright----------

		for (int i = colstart; i <= colend&&count<total; i++) {
			System.out.print(arr[rowend][i]+ " ");
			count++;
		}
		rowend--;
		

		// ------printup----------

		for (int i = rowend; i >= rowstart&&count<total; i--) {
			System.out.print(arr[i][colend]+ " ");
			count++;
		}
		colend--;
		

		// ------printleft----------

		for (int i = colend; i >= colstart&&count<total; i--) {
			System.out.print(arr[rowstart][i]+ " ");
			count++;
		}
		rowstart++;
		
}
	}
}
