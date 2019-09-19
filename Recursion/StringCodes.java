package Recursion;

import java.util.ArrayList;

public class StringCodes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getStringCode("1123"));

	}

	public static ArrayList<String> getStringCode(String str) {
		if (str.length() == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}

		ArrayList<String> mr = new ArrayList<>();
		String cc = str.substring(0, 1);
		int cc2n = Integer.parseInt(cc);
		String ros = str.substring(1);
		ArrayList<String> rr1 = getStringCode(ros);
		for (String val : rr1) {

			mr.add(("" + (char) (cc2n + 96)) + val);
		}

		String cc2 = "";
		String ros1 = "";
		if (str.length() >= 2) {
			cc2 = str.substring(0, 2);
			int cc2n1 = Integer.parseInt(cc2);
			ros1 = str.substring(2);
			
			if (cc2n1 <= 26) {
				ArrayList<String> rr = getStringCode(ros1);
				for (String val : rr) {

					mr.add(((char) (cc2n1 + 96)) + val);

				}
			}
			
		}

		return mr;
	}

}
