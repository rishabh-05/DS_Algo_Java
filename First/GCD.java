package First;

import java.util.Scanner;

public class GCD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter no 1");
		int n1 = sc.nextInt();
		System.out.println("Enter no 2");
		int n2 = sc.nextInt();
		sc.close();
		int gcd = 0;
		for (int i = 1; i <= n1 && i <= n2; i++) {

			if (n1 % i == 0 && n2 % i == 0) {
				gcd = i;
			}
		}
		System.out.println("o/p is " + gcd);

	}

}
