package Strings_StringBuilders;

public class StringDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String str = "Hello Rishabh";
//		System.out.println(str.substring(6));
//		System.out.println(str.substring(3, 6));
		String s = "nitin";
		System.out.println(isPalindrome(s));
		printSubstring(s);

	}

	public static boolean isPalindrome(String str) {
		int l = str.length();
		boolean flag = false;
		int si = 0;
		int ei = l - 1;
		while (si < ei) {
			if (str.charAt(si) == str.charAt(ei)) {
				si++;
				ei--;
			} else {
				flag = false;
				return flag;
			}

		}
		flag = true;

		return flag;
	}

	public static void printSubstring(String str) {
		int l = str.length();
		for (int i = 0; i < l; i++) {
			for (int j = i + 1; j <= l; j++) {
				String subs = str.substring(i, j);
				System.out.println(subs + "\tisPalindrome:\t" + isPalindrome(subs));
			}

		}

	}
}
