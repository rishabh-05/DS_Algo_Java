package Arrays;

import java.util.ArrayList;

public class ArrayListDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr1 = { 10, 10, 20, 20, 30, 40, 40, 50 };
		int[] arr2 = { 10, 30, 50, 70 }; // both sorted
		System.out.println(intersection(arr1, arr2));

		// add two arrays..(each element between 0-9)
		// [9, 9, 9, 9, 8]
		// + [ 2, 6]
		// = [1, 0, 0, 0, 2, 4] (ans)
		int[] arr3 = { 8, 9, 9, 9, 8 };
		int[] arr4 = { 2, 6 };
		System.out.println(sumarray(arr3, arr4));

	}

	public static ArrayList<Integer> intersection(int[] a, int[] b) {
		ArrayList<Integer> list = new ArrayList<>();

		int i = 0;
		int j = 0;
		while (i < a.length && j < b.length) {
			if (a[i] == b[j]) {
				list.add(a[i]);
				i++;
				j++;
			} else if (a[i] > b[j]) {
				j++;
			} else {
				i++;
			}
		}

		return list;
	}

	public static ArrayList<Integer> sumarray(int[] a, int[] b) {
		ArrayList<Integer> list = new ArrayList<>();
		int al = a.length - 1;
		int bl = b.length - 1;
		int carry = 0;
		int sum = 0;
		while (al >= 0 || bl >= 0) {
			if (al >= 0 && bl >= 0) // better way
				sum = a[al] + b[bl] + carry; // sum = carry
												// if(al>=0)
			if (al < 0 && bl >= 0) // sum = sum+a[al]
				sum = b[bl] + carry; // for bl also

			if (bl < 0 && al >= 0)
				sum = a[al] + carry;

			carry = 0;
			if (sum > 9) {
				carry = 1;
				sum = sum - 10;
			}
			list.add(0, sum);

			al--;
			bl--;
		}
		if (carry == 1)
			list.add(0, 1);

		return list;
	}

}
