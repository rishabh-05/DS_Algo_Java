package Functions;

import java.util.Scanner;

public class PrintPrime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int lo = sc.nextInt();
		int hi = sc.nextInt();
		sc.close();
		printAllprimes(lo, hi);

	}

	public static void printAllprimes(int low, int high) {
		for (int i = low; i <= high; i++) {
			if (isPrime(i)) {
				System.out.println(i);
			}
		}

	}

	public static boolean isPrime(int n) {
		boolean flag = true;
		for (int i = 2; i <= n / 2; i++) {
			if (n % i == 0) {
				flag = false;
				break;
			}
		}
		return flag;

	}

}
