package DP;

import java.util.Arrays;

public class LongestCommonSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "akjsnasdjfa";
		String str2 = "sdjfasdmsaldn";
		int[][] strg = new int[str1.length() + 1][str2.length() + 1];

		for (int i = 0; i < strg.length; i++) {
			Arrays.fill(strg[i], -1);
		}

		System.out.println(lcsTD(str1, str2, strg));
		System.out.println(lcsBU(str1, str2));
	}

	public static int lcs(String str1, String str2) {

		if (str1.length() == 0 || str2.length() == 0)
			return 0;

		if (str1.equals(str2))
			return str1.length();

		char ch1 = str1.charAt(0);
		char ch2 = str2.charAt(0);

		String ros1 = str1.substring(1);
		String ros2 = str2.substring(1);
		int res1 = 0, res2 = 0;
		if (ch1 == ch2)
			return 1 + lcs(ros1, ros2);
		else {
			res1 = lcs(str1, ros2);
			res2 = lcs(ros1, str2);
		}

		return Math.max(res1, res2);
	}

	public static int lcsTD(String str1, String str2, int[][] strg) {

		if (str1.length() == 0 || str2.length() == 0)
			return 0;

		if (str1.equals(str2))
			return str1.length();

		if (strg[str1.length()][str2.length()] != -1) {
			return strg[str1.length()][str2.length()];
		}

		char ch1 = str1.charAt(0);
		char ch2 = str2.charAt(0);

		String ros1 = str1.substring(1);
		String ros2 = str2.substring(1);

		int ans = 0;
		if (ch1 == ch2)
			ans = 1 + lcs(ros1, ros2);
		else {
			int res1 = lcs(str1, ros2);
			int res2 = lcs(ros1, str2);
			ans = Math.max(res1, res2);
		}
		strg[str1.length()][str2.length()] = ans;

		return ans;
	}

	public static int lcsBU(String s1, String s2) {
		
		int[][] strg = new int[s1.length()+1][s2.length()+1];
		

		for (int i = 0; i < strg.length; i++) {
			Arrays.fill(strg[i], -1);
		}
		
		for(int r = s1.length()-1; r>=0; r--) {
			for(int c = s2.length()-1; c >=0; c--) {
				
				if(s1.charAt(r) == s2.charAt(c)) {
					strg[r][c] = strg[r+1][c+1] +1;
				}else {
					int o1 = strg[r][c+1];
					int o2 = strg[r+1][c];
					strg[r][c] = Math.max(o1,  o2);
				}
			}
		}
		return strg[0][0];
	}

}
