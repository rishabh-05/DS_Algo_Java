package First;

import java.util.Scanner;

public class GCDLong {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter no 1");
		int n1 = sc.nextInt();
		System.out.println("Enter no 2");
		int n2 = sc.nextInt();
		sc.close();

		int dividend = n1;
		int divisor = n2;

		while (dividend % divisor != 0) {
			int rem = dividend % divisor;

			dividend = divisor;
			divisor = rem;

		}
		System.out.println(divisor);
	}

}
