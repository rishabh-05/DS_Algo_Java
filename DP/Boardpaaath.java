package DP;

public class Boardpaaath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = BoardPathTD(0, 100, new int[101]);
		int b = BoardPathBU(0, 1000000);
		int c = BoardPathBUSE(0, 1000000);
		System.out.println(1 + "--" + b + "--" + c);

	}

	public static int BoardPathTD(int curr, int end, int[] dpstr) {

		if (curr == end) {
			return 1;
		}
		if (curr > end) {
			return 0;
		}

		if (dpstr[curr] != 0) {
			return dpstr[curr];
		}
		int c = 0;
		for (int i = 1; i <= 6; i++) {
			c += BoardPathTD(curr + i, end, dpstr);
		}
		dpstr[curr] = c;
		return c;
	}

	public static int BoardPathBU(int curr, int end) {

		int[] dpstr = new int[end - curr + 6];
		dpstr[end] = 1;
		for (int i = end - 1; i >= curr; i--) {
			int sum = 0;
			for (int j = i + 1; j <= i + 6; j++) {
				sum += dpstr[j];
			}
			dpstr[i] = sum;
		}

		return dpstr[curr];
	}

	public static int BoardPathBUSE(int curr, int end) {

		int[] dpstr = new int[6];
		dpstr[0] = 1;
		for (int i = end - 1; i >= curr; i--) {
			int sum = 0;
			for (int j = 0; j < 6; j++) {
				sum += dpstr[j];
			}
			// khiskaao to right side, then insert sum to 0th index

			for (int k = 5; k > 0; k--) {
				dpstr[k] = dpstr[k - 1];
			}
			dpstr[0] = sum;
		}

		return dpstr[curr];
	}

}
