package NumberSystem;

import java.util.Scanner;

public class AnyBase2Decimal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int base = sc.nextInt();
		int nbase = sc.nextInt();
		sc.close();
		int ans = 0;
		int mul = 1;
		while(nbase!=0) {
			int rem = nbase%10;
			ans = ans + mul*rem;
			mul = mul*base;
			nbase/=10;
		}
		System.out.println(ans);
		

	}

}
