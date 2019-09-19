package DP;

public class SmokenColor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int smokeamt(int[] color, int lo, int hi) {
		if (lo == hi)
			return 0;
		
		int min = Integer.MAX_VALUE;

		for (int k = lo; k <= hi - 1; k++) {		//k defines partition at value
			int lpsmoke = smokeamt(color, lo, k);
			int rpsmoke = smokeamt(color, k + 1, hi);

			int selfsmoke = rescolor(color, lo, k) * rescolor(color, k + 1, hi);

			int totsmoke = selfsmoke + lpsmoke + rpsmoke;
			
			if(totsmoke < min) {
				min = totsmoke;
			}
		}
		return min;

	}
	
	// instead of calling rescolor again nand again. Form a rescolor matrix and take the value from the matrix.
	// An upper diagonal matrix will be formed.
	
	private static int rescolor(int[] arr, int si, int ei) {
		int sum = 0;
		for(int i = si; i<=ei; i++) {
			sum += arr[i];
		}
		
		return sum%100;
	}
	

}
