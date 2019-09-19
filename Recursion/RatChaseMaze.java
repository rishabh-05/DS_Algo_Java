package Recursion;

import java.util.Scanner;
import java.util.Arrays;

public class RatChaseMaze {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int row = sc.nextInt();
		int col = sc.nextInt();
		char[][] mazearr = new char[row][col];
		for (int i = 0; i < mazearr.length; i++) {
			for (int j = 0; j < mazearr[0].length; j++) {
				mazearr[i][j] = sc.next().charAt(0);
			}
		}

		int[][] ansarr = new int[row][col];
		for (int i = 0; i < row; i++)
			Arrays.fill(ansarr[i], 0);

		MazePath(0, 0, row - 1, col - 1, mazearr, ansarr);

	}

	public static void MazePath(int currentrow, int currentcol, int endrow, int endcol, char[][] maze, int[][] ans) {
		if (currentrow == endrow && currentcol == endcol) {
			// System.out.println("BASE CASE");
			ans[endrow][endcol] = 1;
			for (int i = 0; i < maze.length; i++) {
				for (int j = 0; j < maze[0].length; j++) {
					System.out.print(ans[i][j] + " ");
				}
				System.out.println();
			}
			return;
		}

		if (currentrow > endrow || currentcol > endcol) {

			return;
		}

		if (maze[currentrow][currentcol] == 'X' || maze[currentrow][currentcol] == 'x') {
			return;
		}

		ans[currentrow][currentcol] = 1;
		MazePath(currentrow + 1, currentcol, endrow, endcol, maze, ans);
		ans[currentrow][currentcol] = 0;

		ans[currentrow][currentcol] = 1;
		MazePath(currentrow, currentcol + 1, endrow, endcol, maze, ans);
		ans[currentrow][currentcol] = 0;

		return;
	}

}
