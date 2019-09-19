package First;

import java.util.*;

public class ProgramsReducedTimeComplexity {

	public static void main(String[] args) {

//1.    X^n + 2X^n-1 + 3X^n-2+.......... + nX^1	

		int x = 3;
		int n = 5;
		poly(x, n);

//2.	count No. of substring which are palindrome in n^2 complexity
		String str = "nitin";

		int count = subCount(str);
		System.out.println(count);
		
		//SeiveOfEr(100);
		
		
		System.out.println(powerFast(2, 8));

	}

	public static int subCount(String str) {
		int count = 0;

		// odd substrings
		for (int axis = 0; axis < str.length(); axis++) {

			for (int orbit = 0; axis - orbit >= 0 && axis + orbit < str.length(); orbit++) {
				if (str.charAt(axis - orbit) == str.charAt(axis + orbit)) {
					count++;
				} else {
					break;
				}
			}
		}

		// even substrings
		for (double axis = 0.5; axis < str.length(); axis++) {

			for (double orbit = 0.5; axis - orbit >= 0 && axis + orbit < str.length(); orbit++) {
				if (str.charAt((int)(axis - orbit)) == str.charAt((int)(axis + orbit))) {
					count++;
				} else {
					break;
				}
			}
		}

		return count;
	}
	
	

	public static void poly(int x, int n) {
		int k = x;
		int sum = 0;
		while (n != 0) {
			sum = sum + n * x;
			x = x * k;
			n = n - 1;
		}
		System.out.println(sum);
		
	

	}

	public static void SeiveOfEr(int n) {
		
		
		boolean[] primes = new boolean[n+1];
		Arrays.fill(primes, true);
		
		primes[0] = false;
		primes[1] = false;
		
		for(int table = 2; table*table <= n; table++) {
			if(!primes[table]) {
				continue;
			}
			for(int multiplier = 2; table*multiplier<=n; multiplier++) {
				primes[table*multiplier] = false;
			}
		}
		
		for(int i = 0; i<=n; i++) {
			if(primes[i]) {
				System.out.println(i);
			}
		}
		//--------
		HashSet<Integer> set = new HashSet<>();
		for(int i = 1; i<10; i++) {
			set.add(i);
		
		}
		
		
		//-------
	}

	public static long powerFast(int base, int po) {
		
		if(po==0) {
			return 1;
		}
		
		long numpower;
		numpower = powerFast(base, po/2);
		if(po%2==0) {
			return numpower*numpower;
		}
		else {
			return numpower*numpower*base;
		}
		

		
	}

}
