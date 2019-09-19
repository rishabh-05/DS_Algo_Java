package DP;

public class MatrixChainMiltiplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {2, 3, 4, 5, 345, 234, 12, 23, 12, 12, 45, 23, 232,334, 32,3,231,23 };
		System.out.println(MCMTD(arr, 0, arr.length - 1, new int[arr.length][arr.length]));
		System.out.println(MCMBU(arr));
		System.out.println(MCM(arr, 0, arr.length - 1));
		
		
		
	}

	public static int MCM(int[] arr, int si, int ei) {
		if (si+1 == ei) {
			return 0;
		}

		int min = Integer.MAX_VALUE;
		for (int k = si + 1; k <= ei - 1; k++) {

			int lp = MCM(arr, si, k);
			int rp = MCM(arr, k, ei);

			int sw = arr[si] * arr[k] * arr[ei];

			int ans = lp + rp + sw;

			if (ans < min) {
				min = ans;
			}
		}
		return min;
	}

	public static int MCMTD(int[] arr, int si, int ei, int[][] strg) {
		if (si+1 == ei) {
			return 0;
		}

		if (strg[si][ei] != 0) {
			return strg[si][ei];
		}
		int min = Integer.MAX_VALUE;
		for (int k = si + 1; k <= ei - 1; k++) {

			int lp = MCM(arr, si, k);
			int rp = MCM(arr, k, ei);

			int sw = arr[si] * arr[k] * arr[ei];

			int ans = lp + rp + sw;

			if (ans < min) {
				min = ans;
			}
		}
		strg[si][ei] = min;
		return min;

	}
	
	public static int MCMBU(int[] arr) {
		int n = arr.length;
		int[][] strg = new int[n][n];
		
		for(int slide = 1; slide<= n-2; slide++) {
			
			for(int si= 0; si <= n-slide-2; si ++) {
				int ei = si + slide+2;
				int min = Integer.MAX_VALUE;
				for (int k = si + 1; k <= ei - 1; k++) {

					int lp = strg[si][k];
					int rp = strg[k][ei];

					int sw = arr[si] * arr[k] * arr[ei];

					int ans = lp + rp + sw;

					if (ans < min) {
						min = ans;
					}
				}
				strg[si][ei] = min;
				
			}
		}
		
		return strg[0][n-1];
	}

}
