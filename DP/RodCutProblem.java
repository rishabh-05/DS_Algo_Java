package DP;

public class RodCutProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int prices[] = { 0, 1, 5, 8, 9, 10, 17, 17, 20, 29, 39, 49, 59, 69, 73, 85, 99, 100, 102, 120, 150 };
		int l = prices.length - 1;
		System.out.println(rodcutTD(prices, l, new int[prices.length]));
		System.out.println(rodcutBU(prices, l));
		System.out.println(rodcut(prices, l));

	}

	public static int rodcut(int[] price, int length) {

		// partitions

		int left = 1;
		int right = length - 1;

		int max = price[length]; // last piece.agar as it is bechna hai

		while (left <= right) {

			int fp = rodcut(price, left);
			int sp = rodcut(price, right);

			int total = fp + sp;

			if (total > max) {
				max = total;
			}

			left++;
			right--;
		}

		return max;

	}

	public static int rodcutTD(int[] price, int length, int[] strg) {

		// partitions
		if (strg[length] != 0) {
			return strg[length];
		}
		int left = 1;
		int right = length - 1;

		int max = price[length]; // last piece.agar as it is bechna hai

		while (left <= right) {

			int fp = rodcutTD(price, left, strg);
			int sp = rodcutTD(price, right, strg);

			int total = fp + sp;

			if (total > max) {
				max = total;
			}

			left++;
			right--;
		}
		strg[length] = max;
		return max;

	}
	
	public static int rodcutBU(int[] prices, int length) {
		int[] strg = new int[prices.length];
		
		strg[0] = 0;	//prices[0]
		strg[1] = prices[1];
		
		for(int i = 2; i < strg.length; i++) {
			int max = prices[i];
			
			int left = 1;
			int right = i - 1;
			
			while(left <= right) {
				int fp = strg[left];
				int sp = strg[right];
				
				int total = fp + sp;

				if (total > max) {
					max = total;
				}
				strg[i] = max;
				
				left++;
				right--;
			}
		}
		for(int val : strg) {
			System.out.print(val + "~~");
		}
		return strg[strg.length - 1];
	}

}
