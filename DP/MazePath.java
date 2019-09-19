package DP;

import java.util.Arrays;

public class MazePath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int er = 3, ec = 3;

		int a = countwaysTD(0, 0, er, ec, new int[er + 1][ec + 1]);
		int b = countwaysBU(0, 0, er, ec);
		int c = countwayDiagBUSE(0, 0, er, ec);
		System.out.println(a + "---" + b+"---"+c);
	}

	// why dp -> ways from (0,0) to (1,1) : HV and VH. Uske baad ke saare ways same.
	// But two recursive calls for two two different stacks. Isilie DP.

	public static int countwaysTD(int cr, int cc, int er, int ec, int[][] strg) {

		if (cr == er && cc == ec) {
			return 1;
		}
		if (cr > er || cc > ec) {
			return 0;
		}
		if (strg[cr][cc] != 0) {
			return strg[cr][cc];
		}

		int ch = countwaysTD(cr + 1, cc, er, ec, strg);
		int cv = countwaysTD(cr, cc + 1, er, ec, strg);
		int cd = countwaysTD(cr+1, cc+1, er, ec, strg);
		strg[cr][cc] = ch + cv+cd;

		return ch + cv+cd;
	}

	public static int countwaysBU(int cr, int cc, int er, int ec) {
		int[][] strg = new int[er + 2][ec + 2];
		strg[er][ec] = 1;

		// bottom row, bottom col se
		for (int row = er; row >= 0; row--) {
			for (int col = ec; col >= 0; col--) {
				strg[row][col] += strg[row + 1][col] + strg[row][col + 1];
			}
		}

		return strg[0][0];
	}

	public static int countwayBUSE(int cr, int cc, int er, int ec) {

		int[] strg = new int[ec + 1];

		Arrays.fill(strg, 1);

		for (int i = er - 1; i >= 0; i--) {

			for(int j = ec-1; j>=0; j--) {
				strg[j]  = strg[j] + strg[j+1];
			}
		}
		return strg[0];
		
	}
	
	public static int countwayDiagBUSE(int cr, int cc, int er, int ec) {

		int[] strg = new int[ec + 1];
		int rightdown =1;
		Arrays.fill(strg, 1);

		for (int i = er - 1; i >= 0; i--) {

			for(int j = ec-1; j>=0; j--) {
				strg[j]  = strg[j] + strg[j+1] +rightdown;
				rightdown = strg[strg.length-10];
			}

			
		}
		return strg[0];
		
	}

}
