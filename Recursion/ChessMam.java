package Recursion;

import java.util.Scanner;

public class ChessMam {

	public static void printChessboard(int end, int row, int col, String ans) {

		if (row == end - 1 && col == end - 1) {
			System.out.print(ans + " ");
			return;
		}

		if (row >= end || col >= end) {
			return;
		}

		int count = 0;

// knight
		printChessboard(end, row + 2, col + 1, ans + "K{" + (row + 2) + "-" + (col + 1) + "}");
		printChessboard(end, row + 1, col + 2, ans + "K{" + (row + 1) + "-" + (col + 2) + "}");

// Rook on walls
		if (row == 0 || row == end - 1 || col == 0 || col == end - 1) {
			for (int i = col; i < end; i++) {
				printChessboard(end, row, i + 1, ans + "R{" + row + "-" + (i + 1) + "}");
			}
			for (int i = row; i < end; i++) {
				printChessboard(end, i + 1, col, ans + "R{" + (i + 1) + "-" + col + "}");
			}
		}

// Bishop
		if (col == row || col + row == end - 1) {
			for (int i = row, j = col; i < end && j < end; i++, j++) {
				printChessboard(end, i + 1, j + 1, ans + "B{" + (i + 1) + "-" + (j + 1) + "}");
			}
		}

	}

	public static int countChessboard(int end, int row, int col) {

		if (row == end - 1 && col == end - 1) {
			return 1;
		}

		if (row >= end || col >= end) {
			return 0;
		}

		int count = 0;

// knight
		count += countChessboard(end, row + 2, col + 1);
		count += countChessboard(end, row + 1, col + 2);

// Rook on walls
		if (row == 0 || row == end - 1 || col == 0 || col == end - 1) {
			for (int i = col; i < end; i++) {
				count += countChessboard(end, row, i + 1);
			}
			for (int i = row; i < end; i++) {
				count += countChessboard(end, i + 1, col);
			}
		}

// Bishop
		if (col == row || col + row == end - 1) {
			for (int i = row, j = col; i < end && j < end; i++, j++) {
				count += countChessboard(end, i + 1, j + 1);
			}
		}
		return count;

	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		printChessboard(n, 0, 0, "{0-0}");
		System.out.println("\n" + countChessboard(n, 0, 0));
	}

}
