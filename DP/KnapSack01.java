package DP;

import java.util.Arrays;

public class KnapSack01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int wt[] = { 1, 3, 4, 5 };
		int price[] = { 1, 4, 5, 7 };
		int cap = 7;

		int[][] strg = new int[cap + 2][wt.length];
		for (int[] val : strg) {
			Arrays.fill(val, -1);
		}
		System.out.println(knapTD(wt, 0, price, cap, strg));
//		for (int[] val : strg) {
//			for (int cap1 : val) {
//				System.out.print(cap1 + "\t");
//			}
//			System.out.println();
//		}
		System.out.println(knap(wt, 0, price, cap));

	}

	public static int knap(int[] wt, int i, int[] price, int cap) {

		// either this or the if condition of yesprice
		if (cap < 0) {
			return -price[i - 1];
		}

		if (i == wt.length) {
			return 0;
		}

		int yesprice = 0;
		// if (cap - wt[i] >= 0)
		yesprice = knap(wt, i + 1, price, cap - wt[i]) + price[i];

		int noprice = knap(wt, i + 1, price, cap);

		int profit = Math.max(yesprice, noprice);

		return profit;

	}

	public static int knapTD(int[] wt, int i, int[] price, int cap, int[][] strg) {

		// either this or the if condition of yesprice
		if (cap < 0) {
			return -price[i - 1];
		}

		if (i == wt.length) {
			return 0;
		}
		if (strg[cap][i] != -1)
			return strg[cap][i];

		int yesprice = 0;
		// if (cap - wt[i] >= 0)
		yesprice = knapTD(wt, i + 1, price, cap - wt[i], strg) + price[i];

		int noprice = knapTD(wt, i + 1, price, cap, strg);

		int profit = Math.max(yesprice, noprice);
		strg[cap][i] = profit;
		return profit;

	}

	public static int KnapBU(int[] wt, int i, int[] price, int cap) {
		int[][] strg = new int[wt.length + 1][cap + 1];

		for (int row = strg.length-2; row >= 0; row--) {
			for (int col = 1; col <= strg[0].length-1; col++) {

				int noprice = strg[row + 1][col];
				int yesprice = 0;
				if (cap - wt[i] >= 0)
					yesprice = price[i] + strg[row + 1][col - wt[row]];

				int profit = Math.max(yesprice, noprice);
				strg[row][col] = profit;

			}
		}
		
		return strg[0][strg[0].length-1];

	}

}
