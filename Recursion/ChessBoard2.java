package Recursion;
import java.util.*;

public class ChessBoard2 {

	public static boolean isPrime(int n) {

		if (n == 2 || n == 3) {
			return true;
		}

		for (int i = 2; i <= n / 2; i++) {

			if (n % i == 0) {
				return false;
			}

		}
		return true;

	}

	public static void mine_or_port(int[][] arr) {

		int flag = 0;
		for (int row = 0; row < arr.length; row++) {
			for (int col = 0; col < arr[0].length; col++) {
				int number = (row * arr.length) + col + 1;
				if (number != 1 && isPrime(number)) {
					if (flag == 0) {
						arr[row][col] = 1; // mine
						flag = 1;
					} else {
						arr[row][col] = 2; // port
						flag = 0;
					}
				}

			}
		}
	}

	public static void printChessboard(int end, int row, int col, String ans, int[][] arr) {

		if (row == end - 1 && col == end - 1) {
			System.out.print(ans + " ");
			return;
		}

		if (row >= end || col >= end) {
			return;
		}
		if (arr[row][col] == 1) { // mine
			return;
		}

		if (arr[row][col] == 2) { // port
			printChessboard(end, end - 1, end - 1, ans + "P{" + (end - 1) + "-" + (end - 1) + "}", arr);
		}

// knight
		printChessboard(end, row + 2, col + 1, ans + "K{" + (row + 2) + "-" + (col + 1) + "}", arr);
		printChessboard(end, row + 1, col + 2, ans + "K{" + (row + 1) + "-" + (col + 2) + "}", arr);

// Rook on walls
		if (row == 0 || row == end - 1 || col == 0 || col == end - 1) {
			for (int i = col; i < end; i++) {
				printChessboard(end, row, i + 1, ans + "R{" + row + "-" + (i + 1) + "}", arr);
			}
			for (int i = row; i < end; i++) {
				printChessboard(end, i + 1, col, ans + "R{" + (i + 1) + "-" + col + "}", arr);
			}
		}

// Bishop
		if (col == row || col + row == end - 1) {
			for (int i = row, j = col; i < end && j < end; i++, j++) {
				printChessboard(end, i + 1, j + 1, ans + "B{" + (i + 1) + "-" + (j + 1) + "}", arr);
			}
		}

	}

	public static int countChessboard(int end, int row, int col, int[][] arr) {

		int count = 0;

		if (row == end - 1 && col == end - 1) {
			return 1;
		}

		if (row >= end || col >= end) {
			return 0;
		}
		if (arr[row][col] == 1) { // mine
			return 0;
		}

		if (arr[row][col] == 2) { // port
			count += countChessboard(end, end - 1, end - 1, arr);
		}

// knight
		count += countChessboard(end, row + 2, col + 1, arr);
		count += countChessboard(end, row + 1, col + 2, arr);

// Rook on walls
		if (row == 0 || row == end - 1 || col == 0 || col == end - 1) {
			for (int i = col; i < end; i++) {
				count += countChessboard(end, row, i + 1, arr);
			}
			for (int i = row; i < end; i++) {
				count += countChessboard(end, i + 1, col, arr);
			}
		}

// Bishop
		if (col == row || col + row == end - 1) {
			for (int i = row, j = col; i < end && j < end; i++, j++) {
				count += countChessboard(end, i + 1, j + 1, arr);
			}
		}
		return count;

	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int[][] arr = new int[n][n];
		mine_or_port(arr);

//	for (int row = 0; row < arr.length; row++) {
//	for (int col = 0; col < arr[0].length; col++) {
//	System.out.print(arr[row][col]);
//	}
//	System.out.println();
//	}

		printChessboard(n, 0, 0, "{0-0}", arr);
		System.out.println("\n" + countChessboard(n, 0, 0, arr));
	}

}