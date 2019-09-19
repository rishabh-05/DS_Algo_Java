package LinkedLists;

public class StockBuySellFixedtransactions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int k = 3; // no of transactions
		int[] a = {2,5,7,1,4,3,1,3}; // prices of stock ar that day

		int profit = maxprofit(a, a.length, k, 0);
		System.out.println(profit);
	}

	public static int maxprofit(int[] a, int n, int k, int vidx) {
		if(vidx<0)
		{
			return 0;
		}
		if(vidx>=n)
			return 0;
		int c = maxprofit(a, n, k, vidx-1);
		//vidx signifies kis din becha hai
		int maxdiff = 0;
		for (int i = 0; i < vidx; i++) {
			maxdiff = Math.max(maxdiff, a[vidx] - a[i]+ maxprofit(a, n, k-1, i));
		}
//		return maxdiff;
		return Math.max(c, maxdiff);

	}

}
