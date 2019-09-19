package DividenConquer;

public class SearchinMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] arr = { { 1, 3, 5, 8, 15 }, { 2, 6, 12, 14, 19 }, { 4, 9, 13, 16, 21 }, { 23, 25, 28, 31, 34 } };
		int target = 13;
		boolean ans = search(arr, target);
	}

	private static boolean search(int[][] arr, int target) {
		int i = 0;
		int j = arr[0].length - 1;
		while (i < arr.length && j >= 0) {

			if (target > arr[i][j]) {
				i++;
			} else if (target < arr[i][j]) {
				j--;
			} else {
				System.out.println(i + " " + j);
				return true;
			}

		}

		return false;
	}

}
