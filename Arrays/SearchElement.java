package Arrays;

import java.util.Scanner;

public class SearchElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 3, 5, 2, 7, 8, 9, 1, 12, 34 };
		
		Scanner sc = new Scanner(System.in);
		int key = sc.nextInt();
		sc.close();
		search(arr, key);
	}

	public static void search(int[] a, int k) {
		int i;
		int pos = -1;
		for (i = 0; i < a.length; i++) {
			if (k == a[i]) {
				pos = i + 1;
				break;
			}
		}
		System.out.println(k + " found at " + pos);
	}

}
