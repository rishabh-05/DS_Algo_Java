package Arrays;

public class StockProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 7, 1, 5, 3, 6, 14 };
		// int[] arr = {7, 6, 4, 3, 1};

		int profit = maximizeprofit(arr);
		System.out.println(profit);
		
		System.out.println(maxproInOofN(arr));
	}

	public static int maximizeprofit(int[] arr) {
		int l = arr.length;
		int cost = 0;

		for (int i = 0; i < l; i++) {

			for (int j = i + 1; j < l; j++) {
				int diff = arr[j] - arr[i];
				
				if (diff > cost) {
					cost = diff;
				}

			}
		}

		return cost;
	}
	
	public static int maxproInOofN(int[] a) {
		
		int n = a.length -1;
		int rightmax[]  = new int[a.length];
		rightmax[n] = a[n];
		int maxdiff = -1;
		int buyday = -1;
		for(int i = a.length - 2; i >=0; i--) {
			rightmax[i] = Math.max(a[i], rightmax[i+1]);
			int diff = rightmax[i] - a[i];
			
			if(diff > maxdiff) {
				maxdiff = diff;
				buyday = i+1;
			}
			
		}
		//getsell day now
		int sellvalue = maxdiff + a[buyday-1];
		int sellday = -1;
		
		for(int i = buyday; i <= n; i++) {
			if(a[i] == sellvalue) {
				sellday = i+1;
				break;
			}
				
		}
		
		System.out.println("bought:" + buyday +"\n" + "sold on:" + sellday);
		return maxdiff;
	}

}
