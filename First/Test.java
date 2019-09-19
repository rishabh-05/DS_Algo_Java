package First;

import java.util.Scanner;

public class Test {			//boston_raw

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		int c = n;
		int n1 = n;
		int k = 2;
		int sum_fact = 0;
		int sum_dig = 0;
		int sum_num = 0;
		while (k <= n) {
			boolean flag = false;
//			for (int i = 2; i <= k / 2; i++) {
//				if (k % i == 0) {
//					// System.out.println("Not prime.");
//					flag = true;
//					break;
//				}
//			}

			if (!flag) {
				System.out.println(k);// if k prime then i till k/2
				if (c % k == 0) { // k is factor of c
					while (c % k != 0) {
						int k1 = k;
						while (k1 != 0) { // single or double digit, doesnt matter
							int rem = k1 % 10;
							sum_dig += rem;
							k1 /= 10;
						}
						sum_fact += sum_dig;
						c /= k;
					}

				}
			}

			k++;
		}

		while (n1 != 0) {
			int rem1 = n1 % 10;
			sum_num += rem1;
			n /= 10;
		}
		System.out.println(sum_num + " " + sum_fact);
		if (sum_num == sum_fact) {
			System.out.println("1");
		} else {
			System.out.println("0");
		}

	}

}
