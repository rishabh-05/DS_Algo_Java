package Arrays;

import java.util.Scanner;

public class BinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 3, 5, 12, 17, 28, 29, 31, 32, 34 };

		Scanner sc = new Scanner(System.in);
		int key = sc.nextInt();
		sc.close();
		binsearch(arr, key, arr.length);

	}

	public static void binsearch(int[] arr, int key, int l) {

		int lo = 0;
		int hi = l - 1;
		int mid = 0;
		int pos = -1;
		while (lo <= hi) {
			mid = (lo + hi) / 2;
			if (arr[mid] == key) {
				pos = mid + 1;
				break;
			} else if (key < arr[mid]) {
				lo = 0;
				hi = mid - 1;
			} else {
				lo = mid + 1;
				hi = l - 1;
			}
		}
		System.out.println(pos);
	}

}
