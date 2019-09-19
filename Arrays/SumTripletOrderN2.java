package Arrays;

import java.util.Arrays;

public class SumTripletOrderN2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int targetSum = 13;
		int[] arr = { 1, 4, 2, 7, 3, 10, 25, 9, 7, 3 };

		Arrays.sort(arr);
		for (int k = 0; k < arr.length; k++) {
			int i = k+1;
			int j = arr.length - 1;

			while (i < j) {

				if (arr[k] + arr[i] + arr[j] == targetSum ) {
					System.out.println(arr[k] + " " + arr[i] + " " + arr[j]);
					i++;
					j--;
				} else if (arr[k] + arr[i] + arr[j] > targetSum) {
					j--;
				} else {
					i++;
				}

			}
		}

	}

}
