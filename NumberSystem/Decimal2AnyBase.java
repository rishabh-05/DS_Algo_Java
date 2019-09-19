package NumberSystem;

import java.util.*;

public class Decimal2AnyBase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int base = sc.nextInt();
		sc.close();
		int mul = 1;

		int ans = 0;
		while (n != 0) {
			int h = n % base;
			ans = ans + h * mul;
			mul = mul * 10;
			n /= base;

		}
		System.out.println(ans);
	}

}
