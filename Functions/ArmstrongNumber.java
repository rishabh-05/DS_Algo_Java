package Functions;

import java.util.Scanner;

public class ArmstrongNumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int lo = sc.nextInt();
		int hi = sc.nextInt();
		sc.close();
		printAllArm(lo, hi);

	}

	public static void printAllArm(int low, int high) {

		for (int i = low; i <= high; i++) {
			if (isArmstrong(i)) {
				System.out.println(i);
			}
		}
	}

	public static boolean isArmstrong(int n) {
		int k = n;
		int count = countDigits(n);
		boolean flag = false;
		int sum = 0;
		for (int i = 1; i <= count; i++) {
			int rem = n % 10;
			sum += (int) Math.pow(rem, count);
			n = n / 10;
		}
		if (sum == k) {
			flag = true;
		}

		return flag;
	}

	public static int countDigits(int n) {
		int nod = 0;
		while (n != 0) {
			nod++;
			n /= 10;
		}
		return nod;
	}

}
