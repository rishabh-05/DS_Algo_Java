package Strings_StringBuilders;

public class MakeLargestNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//int[] arr = { 54, 546, 548, 60 };
		// output: 6054854654
		 int[] arr = {8, 85, 89, 879, 889, 899, 859};
		// output: 899 89 889 8 879 859 85
		// int[] arr = { 1, 34, 3, 98, 9, 976, 45, 4 };

		System.out.println(largestnumber(arr));
	}

	public static String largestnumber(int[] a) {
		int l = a.length;
		for (int i = 0; i < l; i++) {
			for (int j = 0; j < l - 1-i; j++) {
				if (compare(a[j], a[j + 1])) {
					int temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
			}
		}

		String ans = "";
		for (int i = 0; i < l; i++) {
			ans = a[i] + " " + ans;
		}
		return ans;

	}

	public static boolean compare(int n1, int n2) {
		String n1n2s = n1 + "" + n2;
		String n2n1s = n2 + "" + n1;

		int n1n2n = Integer.parseInt(n1n2s);
		int n2n1n = Integer.parseInt(n2n1s);
		if (n1n2n > n2n1n) {
			return true;
		} else {
			return false;
		}
	}

}
