package DP;

public class PalindromeSubSeq {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "bccacb";
		System.out.println(subseq(str, 0, str.length() - 1));
	}

	public static int subseq(String str, int left, int right) {
		if (left == right)
			return 1; // for odd substr, 1 is for middle character

		if (left > right)
			return 0; // for even substr

		int ans = 0;
		if (str.charAt(left) == str.charAt(right))
			ans += subseq(str, left + 1, right - 1) + 2;
		else {
			ans += Math.max(subseq(str, left, right - 1), subseq(str, left + 1, right));
		}

		return ans;

	}

}
