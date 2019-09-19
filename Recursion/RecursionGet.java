package Recursion;

import java.util.ArrayList;
import java.util.Random;

public class RecursionGet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// System.out.println(getPermutation("abc"));
		// System.out.println(keypad("145"));
		// System.out.println(getSS("abc"));
		System.out.println(getCoinToss(3));
		
		int[] a = {1,2,3,4,5,6,7,8,9};
		Random r=new Random();
		int x=r.nextInt(9);
System.out.println(x);

	}

	public static ArrayList<String> getSS(String str) {
		if (str.length() == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}

		char cc = str.charAt(0);
		String ros = str.substring(1);

		ArrayList<String> rr = getSS(ros);

		ArrayList<String> mr = new ArrayList<>();

		for (String val : rr) {
			mr.add(val);
			mr.add(cc + val);
		}

		return mr;

	}

	public static ArrayList<String> getSSwithASCII(String str) {
		if (str.length() == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}

		char cc = str.charAt(0);
		int asci = (int) cc;
		String ros = str.substring(1);

		ArrayList<String> rr = getSSwithASCII(ros);

		ArrayList<String> mr = new ArrayList<>();

		for (String val : rr) {
			mr.add(val);
			mr.add(asci + val);
			mr.add(cc + val);

		}

		return mr;

	}

	public static ArrayList<String> keypad(String str) {
		if (str.length() == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}

		char cc = str.charAt(0);
		String ros = str.substring(1);
		String key = getCode(cc);

		ArrayList<String> rr = keypad(ros);

		ArrayList<String> mr = new ArrayList<String>();

		for (String val : rr) {
			for (int i = 0; i < key.length(); i++) {
				mr.add(key.charAt(i) + val);
			}
		}

		return mr;

	}

	public static String getCode(char ch) {

		if (ch == '1')
			return "abc";
		else if (ch == '2')
			return "def";
		else if (ch == '3')
			return "ghi";
		else if (ch == '4')
			return "jk";
		else if (ch == '5')
			return "lmno";
		else if (ch == '6')
			return "pqr";
		else if (ch == '7')
			return "stu";
		else if (ch == '8')
			return "vwx";
		else if (ch == '9')
			return "yz";
		else if (ch == '0')
			return "@#";
		else
			return "";
	}

	public static ArrayList<String> getPermutation(String str) {
		if (str.length() == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}
		char cc = str.charAt(0);
		String ros = str.substring(1);

		ArrayList<String> rr = getPermutation(ros);
		ArrayList<String> mr = new ArrayList<>();

		for (String val : rr) {
			for (int i = 0; i <= val.length(); i++) {
				mr.add(val.substring(0, i) + cc + val.substring(i));
			}
		}

		return mr;

	}

	public static ArrayList<String> getCoinToss(int tosses) {
		if (tosses == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}
		ArrayList<String> rr = getCoinToss(tosses - 1);
		ArrayList<String> mr = new ArrayList<>();

		for (String val : rr) {
			mr.add("T" + val);
			mr.add("H" + val);

		}

		return mr;

	}

}
