package DP;

/*
 * ? ans *
 * ? can replace any one character
 * * can replace any sequence/one character(s) including empty character
 * return true or false whether the wild card string can form original string
 * 
 */

public class WildCardMatching {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String pat = "**ba***b*";
		String src = "baababaa";
		System.out.println(wildcard(pat,src ));
		System.out.println(wildcardTD(pat, src, new int[pat.length()+1][src.length()+1]));

	}

	public static boolean wildcard(String pattern, String src) {

		if (src.length() == 0 && pattern.length() == 0)
			return true;
		if (src.length() != 0 && pattern.length() == 0)
			return false;
		if (src.length() == 0 && pattern.length() != 0) {
			for (int i = 0; i < pattern.length() ; i++) {
				if (pattern.charAt(i) != '*')
					return false;
			}
			return true;
		}
		

		boolean ans = false;

		char ch = src.charAt(0);
		String ros = src.substring(1);

		char patch = pattern.charAt(0);
		String patros = pattern.substring(1);
		if (ch == patch || patch == '?')
			return wildcard(patros, ros);
		else if (patch == '*') {
			ans = ans || wildcard(patros, src)|| wildcard(pattern, ros); // * with empty subsequence
			  // * with multiple characters. One at a time. * matches one character
													// and is not consumed

		} else {
			ans = false;
		}

		return ans;

	}

	public static int wildcardTD(String pattern, String src, int[][] strg) { // 0 khaali, 1 false, 2 true

		if (src.length() == 0 && pattern.length() == 0)
			return 2;
		if (src.length() != 0 && pattern.length() == 0)
			return 1;
		if (src.length() == 0 && pattern.length() != 0) {
			for (int i = 0; i < pattern.length(); i++) {
				if (pattern.charAt(i) != '*')
					return 1;
			}
			return 2;
		}

		if (pattern.equals("*"))
			return 2;
		if (strg[pattern.length()][src.length()] != 0)
			return strg[pattern.length()][src.length()];
		
		int ans = 1;

		char ch = src.charAt(0);
		String ros = src.substring(1);

		char patch = pattern.charAt(0);
		String patros = pattern.substring(1);
		if (ch == patch || patch == '?')
			return wildcardTD(patros, ros, strg);
		else if (patch == '*') {
			if(wildcardTD(patros, src, strg) == 2 || wildcardTD(pattern, ros, strg) ==2)
			ans = 2;

		} else {
			ans = 1;
		}
		strg[pattern.length()][src.length()] = ans;
		return ans;

	}
	
	public boolean WildCardBUIncomplete(String pattern, String src) {
		boolean strg[][] = new boolean[pattern.length()+1][src.length()+1];
		
		//base case values
		strg[pattern.length()][src.length()] = true;
		
		for(int i = 0; i <= strg.length; i++) {
			for(int j = 0; j<= strg[0].length; j++) {
				
			}
		}
		
		return strg[0][0];
		
	}
	
	public static boolean WildcardMatchingBU(String src, String pat) {

		boolean[][] strg = new boolean[src.length() + 1][pat.length() + 1];

		for (int r = src.length(); r >= 0; r--) {
			for (int c = pat.length(); c >= 0; c--) {

				if (r == src.length() && c == pat.length()) {
					strg[r][c] = true;
					continue;
				}
				if (c == pat.length()) {
					strg[r][c] = false;
					continue;
				}

				if (r == src.length()) {

					if (pat.charAt(c) == '*') {
						strg[r][c] = strg[r][c + 1];
					} else {
						strg[r][c] = false;
					}

					continue;
				}

				char chs = src.charAt(r);
				char chp = pat.charAt(c);

				boolean ans;
				if (chs == chp || chp == '?') {
					ans = strg[r + 1][c + 1];
				} else if (chp == '*') {
					ans = strg[r][c + 1] || strg[r + 1][c];
				} else {
					ans = false;
				}

				strg[r][c] = ans;
			}

		}

		return strg[0][0];

	}
}
