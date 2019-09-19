package Recursion;

public class Backtracking {

	static int count = 1;

	public static void QueenPermutation(boolean[] board, int tq, int qpsf, String ans) {
		if (qpsf == tq) {
			System.out.println(count++ + ".\t" + ans + " ");
			return;
		}

		for (int i = 0; i < board.length; i++) {
			if (board[i] == false) {
				board[i] = true;
				QueenPermutation(board, tq, qpsf + 1, ans + "Q" + qpsf + "B" + i);
			}
			board[i] = false;
		}
	}

	static int count1 = 1;

	public static void QueenCombination(boolean[] board, int tq, int qpsf, int lastplace, String ans) {
		if (qpsf == tq) {
			System.out.println(count1++ + ".\t" + ans + " ");
			return;
		}
		for (int i = lastplace + 1; i < board.length; i++) {

			board[i] = true;
			QueenCombination(board, tq, qpsf + 1, i, ans + "Q" + qpsf + "B" + i);

			board[i] = false;
		}
	}

	static int count3 = 1;

	public static void QueenCombinationBoardRespect(boolean[] board, int col, int tq, int qpsf, String ans) {
		if (qpsf == tq) {
			System.out.println(count1++ + ".\t" + ans + " ");
			return;
		}
		if (col == board.length) {
			return;
		}

		// placed
		board[col] = true;
		QueenCombinationBoardRespect(board, col + 1, tq, qpsf + 1, ans + "B" + col + " ");
		board[col] = false;

		// not placed
		QueenCombinationBoardRespect(board, col + 1, tq, qpsf, ans);

	}

	static int count2 = 1;

	public static void coinsum(int[] coins, int target, int currentsum, String ans, int lastindex) {
		if (target == currentsum) {
			System.out.println(count2++ + ".\t" + ans);
			return;
		}

		if (currentsum > target) {
			return;
		}

		for (int i = lastindex; i < coins.length; i++) {

			currentsum += coins[i];
			coinsum(coins, target, currentsum, ans + coins[i], i);
			currentsum -= coins[i];

			/*
			 * or: coinsum(coins, target, currentsum+coins[i], i);
			 */

		}

	}

	public static boolean WordCheck(char[][] board, boolean[][] boardcheck, int row, int col, String target,
			String current) {
		if (target.equals(current)) {
			return true;
		}
		if (row > board.length - 1 || row < 0) {
			return false;
		}
		if (col > board[0].length - 1 || col < 0) {
			return false;
		}

		boolean col_inc = false, col_dec = false, row_inc = false, row_dec = false;
		if (!boardcheck[row][col]) {
			boardcheck[row][col] = true;
			col_inc = WordCheck(board, boardcheck, row, col + 1, target, current + board[row][col]);
			boardcheck[row][col] = false;
		}
		if (!boardcheck[row][col]) {
			boardcheck[row][col] = true;
			row_inc = WordCheck(board, boardcheck, row + 1, col, target, current + board[row][col]);
			boardcheck[row][col] = false;
		}
		if (!boardcheck[row][col]) {
			boardcheck[row][col] = true;
			col_dec = WordCheck(board, boardcheck, row, col - 1, target, current + board[row][col]);
			boardcheck[row][col] = false;
		}
		if (!boardcheck[row][col]) {
			boardcheck[row][col] = true;
			row_dec = WordCheck(board, boardcheck, row - 1, col, target, current + board[row][col]);
			boardcheck[row][col] = false;
		}

		return col_inc || col_dec || row_inc || row_dec;

	}

	static int count4 = 0;

	public static void NQueen(boolean[][] board, int tq, int qpsf, int row, int col, String ans) {
		if (tq == qpsf) {
			System.out.print(ans + " ");
			return;
		}
		if (col == board[0].length) {
			NQueen(board, tq, qpsf, row + 1, 0, ans); // next row
			return;
		}
		if (row == board.length) {
			return;
		}

		// placed
		if (isitSafeQueen(board, row, col)) {
			board[row][col] = true;
			NQueen(board, tq, qpsf + 1, row, col + 1, ans + "{" + (row + 1) + "-" + (col + 1) + "} ");
			// optimised call(for n queen only):
			// NQueen(board, tq, qpsf + 1, row+1, 0, ans + "[" + row + "-" + col + "]");
			board[row][col] = false;
		}

		// not placed
		NQueen(board, tq, qpsf, row, col + 1, ans);

	}

	// NQUEEN with respect to
	// queen----------------------------------------------------
	static int count0 = 1;

	public static void NQueenWRTqueen(boolean[][] board, int tq, int qpsf, int row, String ans) {

		if (qpsf == tq) {
			System.out.println(count++ + ans);
			return;
		}

		if (row == board.length) {
			return;
		}

		for (int col = 0; col < board[0].length; col++) {
			board[row][col] = true;
			NQueenWRTqueen(board, tq, qpsf + 1, row + 1, ans + "{" + row + "-" + col + "}");
			board[row][col] = false;
		}

		// not placed-----call used when tq< board.length
		NQueenWRTqueen(board, tq, qpsf, row + 1, ans);

	}

	// --------------------------------------------------------------------------------

	public static int CountNQueen(boolean[][] board, int tq, int qpsf, int row, int col, int count) {
		if (tq == qpsf) {

			return 1;
		}
		if (col == board[0].length) {
			return CountNQueen(board, tq, qpsf, row + 1, 0, count); // next row

		}
		if (row == board.length) {
			return 0;
		}
		int count1 = 0;
		// placed
		if (isitSafeQueen(board, row, col)) {
			board[row][col] = true;
			count1 = CountNQueen(board, tq, qpsf + 1, row, col + 1, count + 1);
			// optimised call(for n queen only):
			// NQueen(board, tq, qpsf + 1, row+1, 0, ans + "[" + row + "-" + col + "]");
			board[row][col] = false;
		}

		// not placed
		int count2 = CountNQueen(board, tq, qpsf, row, col + 1, count + 1);

		return count1 + count2;
	}

//NKnight problem-------------------

	public static void NKnight(boolean[][] board, int tk, int kpsf, int row, int col, String ans) {
		if (tk == kpsf) {
			System.out.print( ans+" ");
			return;
		}
		if (col == board[0].length) {
			NKnight(board, tk, kpsf, row + 1, 0, ans); // next row
			return;
		}
		if (row == board.length) {
			return;
		}

		// placed
		if(isitSafeKnight(board, row, col)) {
			board[row][col] = true;
			NKnight(board, tk, kpsf + 1, row, col + 1, ans + "{" + (row) + "-" + (col) + "} ");
		
			board[row][col] = false;
		}
		
		// not placed
		NKnight(board, tk, kpsf, row, col + 1, ans);

	}
	
	public static int CountNKnight(boolean[][] board, int tk, int kpsf, int row, int col, int count) {
		if (tk == kpsf) {

			return 1;
		}
		if (col == board[0].length) {
			return CountNKnight(board, tk, kpsf, row + 1, 0, count); // next row

		}
		if (row == board.length) {
			return 0;
		}
		int count1 = 0;
		// placed
		if (isitSafeKnight(board, row, col)) {
			board[row][col] = true;
			count1 = CountNKnight(board, tk, kpsf + 1, row, col + 1, count + 1);

			board[row][col] = false;
		}

		// not placed
		int count2 = CountNKnight(board, tk, kpsf, row, col + 1, count + 1);

		return count1 + count2;
	}

	// -------------------------

	public static boolean isitSafeQueen(boolean[][] board, int row, int col) {
		int r = row - 1;
		int c = col;

		// check up
		while (r >= 0) {
			if (board[r][c]) {
				return false;
			}
			r--;
		}

		// diagonally left
		r = row - 1;
		c = col - 1;
		while (r >= 0 && c >= 0) {
			if (board[r][c]) {
				return false;
			}
			r--;
			c--;
		}
		// diagonally right
		r = row - 1;
		c = col + 1;
		while (r >= 0 && c < board[0].length) {
			if (board[r][c]) {
				return false;
			}
			r--;
			c++;
		}
		// left
		r = row;
		c = col - 1;
		while (c >= 0) {
			if (board[r][c]) {
				return false;
			}

			c--;
		}

		return true;
	}

	public static boolean isitSafeKnight(boolean[][] board, int row, int col) {
		// ghodey ke possible moves (8 positions)

		int r, c;
		r = row - 2;
		c = col - 1;
		if (r >= 0 && c >= 0 && r < board.length && c < board[0].length) {
			if (board[r][c]) {
				return false;
			}
		}

		r = row - 2;
		c = col + 1;
		if (r >= 0 && c >= 0 && r < board.length && c < board[0].length) {
			if (board[r][c]) {
				return false;
			}
		}

		r = row + 2;
		c = col - 1;
		if (r >= 0 && c >= 0 && r < board.length && c < board[0].length) {
			if (board[r][c]) {
				return false;
			}
		}

		r = row + 2;
		c = col + 1;
		if (r >= 0 && c >= 0 && r < board.length && c < board[0].length) {
			if (board[r][c]) {
				return false;
			}
		}
		// -----------------
		r = row - 1;
		c = col - 2;
		if (r >= 0 && c >= 0 && r < board.length && c < board[0].length) {
			if (board[r][c]) {
				return false;
			}
		}

		r = row - 1;
		c = col + 2;
		if (r >= 0 && c >= 0 && r < board.length && c < board[0].length) {
			if (board[r][c]) {
				return false;
			}
		}

		r = row + 1;
		c = col - 2;
		if (r >= 0 && c >= 0 && r < board.length && c < board[0].length) {
			if (board[r][c]) {
				return false;
			}
		}

		r = row + 1;
		c = col + 2;
		if (r >= 0 && c >= 0 && r < board.length && c < board[0].length) {
			if (board[r][c]) {
				return false;
			}
		}

		return true;

	}

	
	
	public static void FindWaysinMaze(int[][] maze, int row, int col, String ans, boolean[][] visited) {
		if (row == maze.length - 1 && col == maze[0].length - 1) {
			System.out.println(ans);
			return;
		}
		if (row >= maze.length || col >= maze[0].length || row < 0 || col < 0) {
			return;
		}
		if (maze[row][col] == 1 || visited[row][col]) {
			return;
		}

		visited[row][col] = true;
		FindWaysinMaze(maze, row + 1, col, ans + 'D', visited);
		FindWaysinMaze(maze, row, col + 1, ans + 'R', visited);
		FindWaysinMaze(maze, row - 1, col, ans + 'U', visited);
		FindWaysinMaze(maze, row, col - 1, ans + 'L', visited);
		visited[row][col] = false;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// QueenCombination(new boolean[4], 2, 0, -1, "");
//		int[] coins = { 2, 3, 5, 6 };
//		coinsum(coins, 10, 0, "", 0);
		// QueenCombinationBoardRespect(new boolean[4], 0, 2, 0, "");
//		NQueen(new boolean[5][5], 5, 0, 0, 0, "");
//		System.out.println();
//		System.out.println(CountNQueen(new boolean[5][5], 5, 0, 0, 0, 0));
		NKnight(new boolean[2][2], 2, 0, 0, 0, "");
		System.out.println();
		System.out.println(CountNKnight(new boolean[2][2], 2, 0, 0, 0, 0));
//		NQueenWRTqueen(new boolean[3][3], 1, 0, 0, "");
//		char[][] board = {);
//				{'a', 's', 'd', 'f'},
//				{'c', 'v', 'k', 'l'},
//				{'r', 't', 'y', 'p'}
//		};
		// System.out.println(WordCheck(board, new
		// boolean[board.length][board[0].length], 0, 0, "asdkvcrtyplf", ""));

//		int[][] maze = {
//				{0, 1, 0, 0},
//				{0, 0, 0, 0},
//				{0, 1, 0, 0},
//				{0, 0, 1, 0}
//		};
//		
//		FindWaysinMaze(maze, 0, 0, "", new boolean[maze.length][maze[0].length]);
	}

}
