package Recursion;

import java.util.Scanner;

public class ChessBoard {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		chess(0, 0, n - 1, n - 1, "{0-0}");
		System.out.println();
		System.out.println(countchess(0, 0, n - 1, n - 1));

	}

	public static void chess(int crow, int ccol, int erow, int ecol, String ans) {
		if (crow == erow && ccol == ecol) {
			System.out.print(ans + " ");
			return;
		}
		if (crow > erow || ccol > ecol) {
			return;
		}
		
		// knight
		chess(crow + 2, ccol + 1, erow, ecol, ans + "K{" + (crow + 2) + "-" + (ccol + 1) + "}");
		chess(crow + 1, ccol + 2, erow, ecol, ans + "K{" + (crow + 1) + "-" + (ccol + 2) + "}");
		// j defines no of steps the piece can move at a time
		// rook--- only from walls
		if (crow == 0 || ccol == 0 || crow == erow || ccol == ecol) {
			for (int j = 1; j <= erow || j <= ecol; j++) {

				chess(crow, ccol + j, erow, ecol, ans + "R{" + (crow) + "-" + (ccol + j) + "}");
				chess(crow + j, ccol, erow, ecol, ans + "R{" + (crow + j) + "-" + (ccol) + "}");

			}
		}
		if (ccol == crow || (crow + erow) == (2 * ecol - ccol)) {
			for (int j = 1; j <= erow && j <= ecol; j++) {
				// bishop--only when on diagonals--uunth

				chess(crow + j, ccol + j, erow, ecol, ans + "B{" + (crow + j) + "-" + (ccol + j) + "}");
			}

		}

	}

	public static int countchess(int crow, int ccol, int erow, int ecol) {
		if (crow == erow && ccol == ecol) {
			// System.out.print(ans + " ");
			return 1;
		}
		if (crow > erow || ccol > ecol) {
			return 0;
		}
		int c = 0;
		// knight
		c += countchess(crow + 2, ccol + 1, erow, ecol);
		c += countchess(crow + 1, ccol + 2, erow, ecol);
		// j defines no of steps the piece can move at a time
		// rook--- only from walls
		if (crow == 0 || ccol == 0 || crow == erow || ccol == ecol) {
			for (int j = 1; j <= erow && j <= ecol; j++) {

				c += countchess(crow, ccol + j, erow, ecol);
				c += countchess(crow + j, ccol, erow, ecol);

			}
		}
		if (ccol == crow || (crow + erow) == (2 * ecol - ccol)) {
			for (int j = 1; j <= erow && j <= ecol; j++) {
				// bishop--only when on diagonals--uunth

				c += countchess(crow + j, ccol + j, erow, ecol);
			}

		}

		return c;

	}

}
