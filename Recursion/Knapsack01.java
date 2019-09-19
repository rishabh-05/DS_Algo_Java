package Recursion;

public class Knapsack01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		float f = 1.2f;
		float f1 = 1.0f;
		boolean ans = f1%1 == 0;
		boolean ans1 = f%1 == 0;
		System.out.println(ans + ans1);

	}

	public static int maxprice(int[] w, int[] p, int capacity, int vidx) {

		if (capacity < 0)
			return Integer.MIN_VALUE;
		if (vidx >= w.length)
			return 0;

		int yesprice = maxprice(w, p, capacity - w[vidx], vidx + 1) + p[vidx];
		int noprice = maxprice(w, p, capacity, vidx + 1);

		int price = Math.max(yesprice, noprice);

		return price;
	}

}
