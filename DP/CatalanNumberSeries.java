package DP;

import java.util.Arrays;

public class CatalanNumberSeries {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Given a number. Tell how many BSTs can be formed using 1 to n
		System.out.println(noBSTs(5));
		int n = 6;
		System.out.println(noBSTsTD(n, new int[n + 1]));
		System.out.println(noBSTsBU(n));

	}

	public static int noBSTs(int n) {
		if (n <= 1)
			return 1;

		int ans = 0;
		for (int k = 1; k <= n; k++) {
			int lp = noBSTs(k - 1);
			int rp = noBSTs(n - k);

			ans += lp * rp;
		}

		return ans;
	}

	public static int noBSTsTD(int n, int[] strg) {
		if (n <= 1)
			return 1;

		if (strg[n] != 0)
			return strg[n];

		int ans = 0;
		for (int k = 1; k <= n; k++) {
			int lp = noBSTsTD(k - 1, strg);
			int rp = noBSTsTD(n - k, strg);

			ans += lp * rp;
		}
		strg[n] = ans;

		return ans;
	}

	public static int noBSTsBU(int n) {
		int[] strg = new int[n + 1];

		Arrays.fill(strg, 1);

		for (int i = 1; i <= n; i++) {
			int ans = 0;
			for (int k = 1; k <= i; k++) {
				int lp = strg[k - 1];
				int rp = 1;
				if (i - k >= 0)
					rp = strg[i - k];

				ans += lp * rp;
			}
			strg[i] = ans;

		}
//		for(int vak : strg) {
//			System.out.print(vak + "~~");
//		}
		return strg[n];
	}

}
