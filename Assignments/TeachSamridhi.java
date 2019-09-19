package Assignments;

import java.util.Arrays;

public class TeachSamridhi {

	// recursion------------------
	public static void mazepath(int[][] a, int cr, int cc, int er, int ec, String ans) {
		if (cr == er && cc == ec) {
			System.out.print(ans + ", ");
			return;
		}

		if (cr > er || cc > ec)
			return;

		mazepath(a, cr + 1, cc, er, ec, ans + "V");
		mazepath(a, cr, cc + 1, er, ec, ans + "H");
		mazepath(a, cr + 1, cc + 1, er, ec, ans + "D");

	}

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
		int cd = countwaysTD(cr + 1, cc + 1, er, ec, strg);
		strg[cr][cc] = ch + cv;

		return ch + cv + cd;
	}

	public static int mincost(int[] a, int vidx, boolean[] isvis, int[] strg) {
		if (vidx < 0)
			return 100000;
		if (vidx >= a.length)
			return 0;
		if(strg[vidx] != -1) return strg[vidx];
		int ja = 0;
		int jb = 0;
		
		if (vidx < a.length  && !isvis[vidx]) {
			
			isvis[vidx] = true;
			ja = mincost(a, vidx + 2, isvis, strg);
			isvis[vidx] = false;
			
		}

		if (vidx < a.length && !isvis[vidx]) {
			
			isvis[vidx] = true;
			jb = mincost(a, vidx - 1, isvis, strg);
			isvis[vidx] = false;
			
		}
		System.out.println("~~"+vidx);

		int sw = Math.min(ja, jb) + a[vidx];
		strg[vidx] = sw;
		return sw;
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// mazepath(new int[3][3], 0, 0, 2, 2, "");

		int[] a = { 1, 2, 8, 4, 100 };
		int[] strg = new int[a.length + 1];
		Arrays.fill(strg, -1);
		System.out.println(mincost(a, 1, new boolean[a.length+1], strg));
		for(int i : strg) System.out.println(i);

	}

}
