package NumberSystem;

public class BinaryToDecimal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 1101110;
		int ans = 0;
		int mul = 1;
		while (n != 0) {
			int rem = n % 10;
			ans = ans + rem * mul;
			mul *= 2;
			n = n / 10;
		}
		System.out.println(ans);
	}

}
