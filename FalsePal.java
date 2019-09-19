import java.util.ArrayList;
import java.util.HashMap;

public class FalsePal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abc";
		ArrayList<String> substr = substrings(s);
		System.out.println(substr);
		System.out.println(solve(substr));

	}

	static ArrayList<String> substrings(String s) {
		ArrayList<String> ans = new ArrayList<>();

		int n = s.length();
		int r = (int)Math.pow(2, n);
		for (int i = 1; i < r; i++) {
			String nbin = generatebinary(i);
			System.out.println(nbin);
			StringBuilder sb = new StringBuilder();
			int j = 0;
			for (char cc : nbin.toCharArray()) {
				if (cc == '1') {
					sb.append(s.charAt(j));
					
				}
				j++;
				
			}
			ans.add(sb.toString());
		}

		return ans;

	}

	private static String generatebinary(int n) {
		String ans = "";
		while (n > 0) {
			int rem = n % 2;
			ans = ""+ rem + ans;
			n = n / 2;
		}

		return ans;
	}

	public static int solve(ArrayList<String> list) {
		int ans = 0;

		for (String str : list) {
			if (isPermPal(str))
				ans++;
		}

		return ans;

	}

	private static boolean isPermPal(String str) {
		if (str.length() == 1) {
			return true;
		}
		HashMap<Character, Integer> chfr = new HashMap<>();
		char[] strch = str.toCharArray();

		for (char cc : strch) {
			if (!chfr.containsKey(cc)) {
				chfr.put(cc, 1);
			} else {
				int val = chfr.get(cc) + 1;
				chfr.put(cc, val);
			}
		}
		int odd = 1;
		for (Character vals : chfr.keySet()) {
			int getval = chfr.get(vals);
			if (getval % 2 == 0)
				continue;

			else {
				odd--;
			}

			if (odd < 0) {
				return false;
			}
		}
		return true;

	}

}
