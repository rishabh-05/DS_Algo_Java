package First;

import java.util.Scanner;

public class CheckPrime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter no to check");
		int n = sc.nextInt();
		sc.close();

		if (n <= 0) {
			System.out.println("Invalid number. Try again.");
			System.exit(0);
		}

		boolean flag = false;
		for (int i = 2; i <= n / 2; i++) {
			if (n % i == 0) {
				System.out.println("Not prime.");
				flag = true;
				break;
			}
		}
		if (flag == false) {
			System.out.println("Prime number");
		}
	}

}
