package Arrays;

import java.util.Scanner;

public class RainWater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t != 0) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			for(int i = 0; i<n; i++) {
				arr[i] = sc.nextInt();
			}

			int[] leftmax = new int[n];
			int[] rightmax = new int[n];

			leftmax[0] = arr[0];
			for (int i = 1; i < n; i++) {
				leftmax[i] = Math.max(arr[i], leftmax[i - 1]);
			}
			rightmax[n - 1] = arr[n - 1];
			for (int i = n - 2; i >= 0; i--) {
				rightmax[i] = Math.max(arr[i], rightmax[i + 1]);
			}
			int sum = 0;
			for (int i = 0; i < n; i++) {
				sum += (Math.min(leftmax[i], rightmax[i]) - arr[i]);
			}

			System.out.println(sum);

			t--;
		}
		sc.close();
	}

}
