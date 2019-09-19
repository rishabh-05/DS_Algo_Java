package Recursion;

public class RecursionFunctions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int ans = factorial(7);
		System.out.println(ans);

		float ans1 = power(3, -5);
		System.out.println(ans1);

		ans = fibonacci(7);
		System.out.println(ans);

	}

	public static int factorial(int n) {
		if (n == 2) {
			return 2;
		}

		int fnm1 = factorial(n - 1);

		int fn = fnm1 * n;

		return fn;
	}

	public static float power(int base, int pow) {
		if (pow == 0) {
			return 1;
		}
		float numpower;
		if (pow < 0) {
			numpower = power(base, pow + 1);
		} else {
			numpower = power(base, pow - 1);
		}
		float ans;
		
		if(pow<0) {
			ans = (float)numpower / base;
		}else {
			ans = (float)numpower * base;
		}

		return ans;

	}

	public static int fibonacci(int n) {
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}

		int fibm1 = fibonacci(n - 1);
		int fibm2 = fibonacci(n - 2);
		int ans = fibm1 + fibm2;

		return ans;

	}

}
