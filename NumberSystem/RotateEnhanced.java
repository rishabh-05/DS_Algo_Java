package NumberSystem;

import java.util.Scanner;

/*logic:
 * no: 123456 rotate by 4 gives = 561234
 * rem = no%10^2 gives rem = 56
 * no = no/10^2 gives no = 1234
 * form no = rem + no
 * 10^k>>>>>>>k is no of digits - rotation
 */

public class RotateEnhanced {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int rotby = sc.nextInt();
		sc.close();
		// count digits-----------------
		int k = n;
		int count = 0;
		while (k != 0) {
			//int rem = n % 10;
			count++;
			k = k / 10;
		}
		rotby = rotby%count;
		if(rotby<0) {
			rotby = rotby+count;
		}
		
		int divisor = (int)Math.pow(10, count-rotby);
		int multiplier = (int)Math.pow(10, rotby);
		int rem = n%divisor;
		int quo = n/divisor;
		int ans = rem*multiplier+quo;
		System.out.println(ans);
		
		

	}

}
