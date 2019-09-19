package First;

import java.util.Scanner;

public class CalculateReverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter no");
		int n = sc.nextInt();
		sc.close();
		int k = n;
		int sum = 0;
		while (k != 0) {
			int rem = k % 10;
			sum = 10 * sum + rem;
			k = k / 10;
		}
		if (n % 10 == 0) {
			System.out.println("0" + sum);
		} else {
			System.out.println(sum);
		}
	}

}
