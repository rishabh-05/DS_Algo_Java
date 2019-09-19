package DP;

public class EditDistanceToMatch2Strings {
	/*
	 * insert, delete, remove operations are allowed to make the 2nd sting same as
	 * first one e.g. S1: saturday S2: sunday no of operations reqd : 3 1. replace n
	 * with r : surday 2. add t : sturday 3. add a : saturday
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "Saturday";
		String str2 = "Sunday";
		int strg[][] = new int[str1.length() + 1][str2.length() + 1];
		System.out.println(nopSameTD(str1, str2, strg));
		System.out.println(nopSame(str1, str2));

	}

	public static int nopSame(String str1, String str2) {

		if (str1.length() == 0 && str2.length() == 0) {
			return 0;
		}
		if (str1.length() == 0)
			return str2.length();
		if (str2.length() == 0)
			return str1.length();

		char ch1 = str1.charAt(0);
		char ch2 = str2.charAt(0);

		String ros1 = str1.substring(1);
		String ros2 = str2.substring(1);

		if (ch1 == ch2)
			return nopSame(ros1, ros2);

		else {
			int i = nopSame(ros1, str2);
			int d = nopSame(str1, ros2);
			int r = nopSame(ros1, ros2);

			return Math.min(i, Math.min(d, r)) + 1;

		}

	}

	public static int nopSameTD(String str1, String str2, int[][] strg) {

		if (str1.length() == 0 && str2.length() == 0) {
			return 0;
		}
		if (str1.length() == 0)
			return str2.length();
		if (str2.length() == 0)
			return str1.length();

		if (strg[str1.length()][str2.length()] != 0)
			return strg[str1.length()][str2.length()];

		char ch1 = str1.charAt(0);
		char ch2 = str2.charAt(0);

		String ros1 = str1.substring(1);
		String ros2 = str2.substring(1);
		int ans = 0;
		if (ch1 == ch2)
			ans = nopSameTD(ros1, ros2, strg);

		else {
			int i = nopSameTD(ros1, str2, strg);
			int d = nopSameTD(str1, ros2, strg);
			int r = nopSameTD(ros1, ros2, strg);

			ans = Math.min(i, Math.min(d, r)) + 1;

		}

		strg[str1.length()][str2.length()] = ans;
		return ans;
	}

	public static int EditDistanceBU(String s1, String s2) {

		int[][] strg = new int[s1.length() + 1][s2.length() + 1];

		for (int row = s1.length(); row >= 0; row--) {

			for (int col = s2.length(); col >= 0; col--) {

				if (row == s1.length()) {
					strg[row][col] = s2.length() - col; // deletion
					continue;
				}

				if (col == s2.length()) {
					strg[row][col] = s1.length() - row; // insertion
					continue;
				}

				if (s1.charAt(row) == s2.charAt(col)) {
					strg[row][col] = strg[row + 1][col + 1];
				} else {

					int i = strg[row + 1][col];
					int d = strg[row][col + 1];
					int r = strg[row + 1][col + 1];

					strg[row][col] = Math.min(i, Math.min(d, r)) + 1;

				}

			}
		}

		return strg[0][0];

	}
}
