package Recursion;

import java.util.ArrayList;


public class GetMazePath {
	static int count =0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(MazePathDiagMulti(0, 0, 3, 2).size());

	}

	public static ArrayList<String> MazePath(int currentrow, int currentcol, int endrow, int endcol) {
		if (currentrow == endrow && currentcol == endcol) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}
		ArrayList<String> mr = new ArrayList<>();
		if (currentrow < endrow) {
			ArrayList<String> rr = MazePath(currentrow + 1, currentcol, endrow, endcol);
			for (String val : rr) {
				mr.add("V" + val);
			}
		}
		if (currentcol < endcol) {
			ArrayList<String> rr = MazePath(currentrow, currentcol + 1, endrow, endcol);
			for (String val : rr) {
				mr.add("H" + val);
			}
		}
		
		return mr;
	}

	public static ArrayList<String> MazePathDiag(int currentrow, int currentcol, int endrow, int endcol) {
		if (currentrow == endrow && currentcol == endcol) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}
		if (currentrow > endrow && currentcol > endcol) {
			ArrayList<String> br = new ArrayList<>();

			return br;
		}
		ArrayList<String> mr = new ArrayList<>();
		if (currentrow < endrow) {
			ArrayList<String> rr = MazePathDiag(currentrow + 1, currentcol, endrow, endcol);
			for (String val : rr) {
				mr.add("V" + val);
			}
		}

		if (currentcol < endcol) {
			ArrayList<String> rr = MazePathDiag(currentrow, currentcol + 1, endrow, endcol);
			for (String val : rr) {
				mr.add("H" + val);
			}
		}
		if (currentcol < endcol && currentrow < endrow) {
			ArrayList<String> rr = MazePathDiag(currentrow + 1, currentcol + 1, endrow, endcol);
			for (String val : rr) {
				mr.add("D" + val);
			}
		}

		return mr;
	}

	public static ArrayList<String> MazePathDiagMulti(int currentrow, int currentcol, int endrow, int endcol) {
		if (currentrow == endrow && currentcol == endcol) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}
		if (currentrow > endrow && currentcol > endcol) {
			ArrayList<String> br = new ArrayList<>();

			return br;
		}
		ArrayList<String> mr = new ArrayList<>();

		for (int i = 1; i <= Math.max(endrow, endcol); i++) {
			if (currentrow < endrow) {
				ArrayList<String> rr = MazePathDiagMulti(currentrow + i, currentcol, endrow, endcol);
				for (String val : rr) {
					if (i == 1) {
						mr.add("V" + val);
					} else
						mr.add("V" + i + val);
				}
			}

			if (currentcol < endcol) {
				ArrayList<String> rr = MazePathDiagMulti(currentrow, currentcol + i, endrow, endcol);
				for (String val : rr) {
					if (i == 1) {
						mr.add("H" + val);
					} else
						mr.add("H" + i + val);
				}
			}
			if (currentcol < endcol && currentrow < endrow) {
				ArrayList<String> rr = MazePathDiagMulti(currentrow + i, currentcol + i, endrow, endcol);
				for (String val : rr) {
					if (i == 1) {
						mr.add("D" + val);
					} else
						mr.add("D" + i + val);
				}
			}
		}
		//System.out.println(mr);
		count++;
		System.out.println(count);
		return mr;
	}


}
