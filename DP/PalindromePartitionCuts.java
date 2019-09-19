package DP;
import java.util.Arrays;
public class PalindromePartitionCuts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "ababbc";
		int[][] strg = new int[str.length()][str.length()];
		for(int[] val : strg) {
			Arrays.fill(val, -1);
		}
	//	System.out.println(cuts(str, 0, str.length()-1));
		System.out.println(cutsTD(str, 0, str.length()-1, strg));
	}

	public static int cuts(String str, int si, int ei) {
		if (isPalindrome(str, si, ei))
			return 0;
		
		
		int min = Integer.MAX_VALUE;
		for (int i = si; i < ei; i++) {
			
			int lpcut = cuts(str, si, i);
			int rpcut = cuts(str, i+1, ei);
			
			int sw = lpcut + rpcut +1; 		// +1 jo khud cut maara hai between left part and right part
			
			if(sw < min) {
				min = sw;
			}
		}
		
		return min;

	}
	
	public static int cutsTD(String str, int si, int ei, int[][] strg) {
		if (isPalindrome(str, si, ei))
			return 0;
		
		if(strg[si][ei] != -1) return strg[si][ei];
		int min = Integer.MAX_VALUE;
		for (int i = si; i < ei; i++) {
			
			int lpcut = cutsTD(str, si, i, strg);
			int rpcut = cutsTD(str, i+1, ei, strg);
			
			int sw = lpcut + rpcut +1; 		// +1 jo khud cut maara hai between left part and right part
			
			if(sw < min) {
				min = sw;
			}
		}
		strg[si][ei] = min;
		return min;

	}

	public static boolean isPalindrome(String str, int si, int ei) {
		

		int i = si;
		int j = ei;

		while (i < j) {
			if (str.charAt(i) != str.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		
		return true;
	}

}
