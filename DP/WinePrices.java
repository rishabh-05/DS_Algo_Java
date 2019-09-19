package DP;

public class WinePrices {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {2, 3, 5, 1, 4};
		int[][] strg = new int[arr.length][arr.length];
		int pd = WineProbTD(arr, 0, arr.length-1, 1, strg);
		System.out.println(pd);
		int pb = WineProbBU(arr);
		System.out.println(pb);
		int p = WineProb(arr, 0, arr.length-1, 1, "");
		System.out.println(p);
		
	}
	
	public static int WineProb(int[] price, int start, int end, int year, String ans) {
		if(start == end) {
			System.out.println(ans);
			return year*price[start];
		}
		
		int s = WineProb(price, start + 1, end, year+1, ans + "P" + start) + price[start] *year;
		int e = WineProb(price, start, end-1, year+1, ans) + price[end] *year;
		
		int profit = Math.max(s, e);
		
		return profit;
	}
	
	public static int WineProbTD(int[] price, int start, int end, int year, int[][] strg) {
		if(start == end) {
			return year*price[start];
		}
		
		if(strg[start][end] != 0) {
			return strg[start][end];
		}
		
		int s = WineProbTD(price, start + 1, end, year+1, strg) + price[start] *year;
		int e = WineProbTD(price, start, end-1, year+1, strg) + price[end] *year;
		
		int profit = Math.max(s, e);
		strg[start][end] = profit;
		return profit;
	}
	
	public static int WineProbBU(int[] price) {
		
		int n = price.length;
		
		int strg[][] = new int[n][n];
		
		//base case values
		for(int i =0; i<strg.length; i++) {
			for(int j = 0; j<strg.length; j++) {
				if(i==j) {
					strg[i][j] = price[i]*n;
				}
			}
		}
		
		for(int slide = 1;slide <= n-1; slide++) {
			for(int si = 0; si<=n-1-slide; si++) {
				
				int ei = si +slide;
				int year = n - slide;
			
				int s =  strg[si+1][ei]+ price[si] *year;
				int e = strg[si][ei-1] + price[ei] *year;
				
				int profit = Math.max(s, e);
				strg[si][ei] = profit;
				
					
				
			}
			
		}
		return strg[0][n-1];
	}

}
