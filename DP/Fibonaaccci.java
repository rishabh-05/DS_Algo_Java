package DP;

public class Fibonaaccci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = fibonacciTD(10, new int[11] );
		int b = fibBU(10);
		int c = fibBUSE(10);
		System.out.println(a+ "---" + b + "---" + c);
	}
	
	public static int fibonacciTD(int n, int[] strg) {		// TD -> DP
		if(n == 0 || n==1) {
			return n;
		}
		
		if(strg[n] != 0) {
			return strg[n];
		}
		
		int fibm1 = fibonacciTD(n-1, strg);
		int fibm2 = fibonacciTD(n-2, strg);
		
		int fibans = fibm1 + fibm2;
		strg[n] = fibans;
		
		return fibans;
	}
	
	public static int fibBU(int n) {
		
		
		int[] strg = new int[n+1];
		strg [0] = 0;
		strg[1] = 1;
		
		for(int i = 2; i<=n; i++) {
			strg[i] = strg[i-1] + strg[i-2];
		}
		
		return strg[n];
	}
	
	public static int fibBUSE(int n) {		//space Efficient. instead of creating a array of n+1, array of size 2 is required
		
		int[] strg = new int[2];
		
		strg[0] = 0;
		strg[1] = 1;
		int ans = 0;
		for(int i = 2; i <= n; i++) {
			ans = strg[0] + strg[1];
			strg[0] = strg[1];
			strg[1] = ans;
		}
		return strg[1];
		
	}

}
