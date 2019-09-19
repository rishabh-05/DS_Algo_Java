package DP;

public class MinzStepsto1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(countminsteps(30));
		System.out.println(count(30, 1, "", new int[31]));
	}

	
	public static int countminsteps(int n) {
		if(n < 1) {
			return Integer.MAX_VALUE-100;
		}
		if (n == 1) {
			return 0;
		}
//		System.out.println(n);
		int c1, c2 = Integer.MAX_VALUE, c3 = Integer.MAX_VALUE;
		// divide 2 call
		if (n % 2 == 0) {
			c2 = countminsteps(n / 2);
		}
		// divide 3 call
		if (n % 3 == 0) {
			c3 = countminsteps(n / 3);
		}
		// subtract 1 call
		c1 = countminsteps(n - 1);
		return 1+Math.min(c1, Math.min(c2, c3));
	}

	
	public static int count(int n, int vidx, String ans, int[] strg) {
		if (vidx > n)
			return (Integer.MAX_VALUE);
		if (n == vidx) {
			System.out.println(ans);
			return 0;
			
		}
		if(strg[vidx] != 0) {
			return strg[vidx];
		}
			

		int c1 = 0, c2 = 0, c3 = 0;

		c3 = count(n, vidx * 3, ans + vidx + ", ", strg);

		c2 = count(n, vidx * 2, ans + vidx + ", ", strg);

		c1 = count(n, vidx + 1, ans + vidx + ", ", strg);
		
		strg[vidx] = Math.min(c1, Math.min(c2, c3)) + 1;

		return Math.min(c1, Math.min(c2, c3)) + 1;
	}
}
