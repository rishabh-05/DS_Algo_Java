package NumberSystem;

import java.util.Scanner;

/*
 * logic:
 * number:	25413
 * places:	54321
 * switch places and digits
 * output:	43152
 * itr_wise:--1-->>>>place 3 pr 1(earlier 1 pr 3)
 * 		   :--1-2
 * 		   :-31-2
 * 		   :431-2
 */
public class Inverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		int ans = 0;
		int place = 1;
		while (n != 0) {
			int rem = n % 10;
			ans = (int) (ans + place * Math.pow(10, rem - 1));

			place++;
			n /= 10;
		}
		System.out.println(ans);

	}

}
