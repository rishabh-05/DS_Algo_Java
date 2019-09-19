package NumberSystem;

public class DecimaltoBinary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 177;
		int ans = 0;
		int mul = 1;
		int k = n;
		while (k != 0) {
			int h = k % 2;
			ans = ans + h * mul;
			mul *= 10;
			k = k / 2;
		}
		System.out.println(ans);

	}

}
