package Recursion;

/*
 * n=7 o/p:  7 5 3 1 2 4 6
 * n=8 o/p:  7 5 3 1 2 4 6 8
 * n=6 o/p:  5 3 1 2 4 6
 * n=9 o/p:  9 7 5 3 1 2 4 6 8
 */

public class PDISkips {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PDISkip(8);

	}

	public static void PDISkip(int n) {

		if (n <= 0) {
			return;
		}

		if (n % 2 != 0) {
			System.out.println(n);
		} 
		PDISkip(n-1);
		if(n%2==0) {
			System.out.println(n);
		}

		

	}

}
