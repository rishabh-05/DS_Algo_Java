package Strings_StringBuilders;

import java.util.ArrayList;

/*
 * i/p = a1b2
 * o/p = a1b2, A1b2, a1B2, A1B2
 * i/p = 3z4
 * o/p = 3z4, 3Z4
 * i/p = 1234
 * o/p = 1234
 * 
 */

public class TransformedSubstrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "a1b2c";
		System.out.println(trans_substrings(str));

	}

	public static ArrayList<String> trans_substrings(String str) {

		if (str.length() == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}

		char cc = str.charAt(0);
		String ros = str.substring(1);

		ArrayList<String> rr = trans_substrings(ros);
		ArrayList<String> mr = new ArrayList<String>();

		for (String val : rr) {
			if (cc >= 'a' && cc <= 'z') {
				mr.add(cc + val);
				cc = (char) (cc - 32);
				mr.add(cc + val);
			} else if (cc >= 'A' && cc <= 'Z') {
				mr.add(cc + val);
				cc = (char) (cc + 32);
				mr.add(cc + val);
			} else {
				mr.add(cc + val);
			}

		}

		return mr;

	}

	/*
	 * Direct functions:
	 * 
	 * Character.isDigit(cc) --->> true or false 
	 * Character.toLowerCase(cc)
	 */

}
