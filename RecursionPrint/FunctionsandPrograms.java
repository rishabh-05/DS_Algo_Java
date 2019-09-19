package RecursionPrint;

import java.util.ArrayList;

public class FunctionsandPrograms {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// PrintSSASCII("abc", "");
		 printPermu("cabd", "", "cabd");
		// PrintParenthesis(2,0, 0, "");

//		printPermuNoRepeat("abca", "");
//		System.out.println(count);
//		printPermuNoDuplicatesMam("abca", "");
	//	lexicoCount(1008, 0);

	}

	public static void PrintSS(String ques, String ans) {
		if (ques.length() == 0) {
			System.out.print(ans + ", ");
			return;
		}

		char ch = ques.charAt(0);
		String roq = ques.substring(1);

		PrintSS(roq, ans);
		PrintSS(roq, ans + ch);
	}

	public static void PrintSSASCII(String ques, String ans) {
		if (ques.length() == 0) {
			System.out.print(ans + ", ");
			return;
		}

		char ch = ques.charAt(0);
		String roq = ques.substring(1);

		PrintSSASCII(roq, ans);
		PrintSSASCII(roq, ans + ch);
		PrintSSASCII(roq, ans + (int) ch);
	}

	public static void PrintKeypad(String ques, String ans) {
		if (ques.length() == 0) {
			System.out.print(ans + ", ");
			return;
		}
		char ch = ques.charAt(0);
		String roq = ques.substring(1);
		String key = getCode(ch);

		for (int i = 0; i < key.length(); i++) {
			PrintKeypad(roq, ans + key.charAt(i));
		}

	}

	public static String getCode(char ch) {

		if (ch == '1')
			return "abc";
		else if (ch == '2')
			return "def";
		else if (ch == '3')
			return "ghi";
		else if (ch == '4')
			return "jk";
		else if (ch == '5')
			return "lmno";
		else if (ch == '6')
			return "pqr";
		else if (ch == '7')
			return "stu";
		else if (ch == '8')
			return "vwx";
		else if (ch == '9')
			return "yz";
		else if (ch == '0')
			return "@#";
		else
			return "";
	}

	public static void PrintPermutation(String ques, String ans) {
		if (ques.length() == 0) {
			System.out.print(ans + ", ");
			return;
		}

		char ch = ques.charAt(0);
		String roq = ques.substring(1);

		for (int i = 0; i <= ans.length(); i++) {

			String ans1 = ans.substring(0, i) + ch + ans.substring(i);
			PrintPermutation(roq, ans1);
		}

	}

	public static void printPermu(String ques, String ans, String original) {
		if (ques.length() == 0 ) {
			System.out.print(ans + ", ");
			return;
		}
		for (int i = 0; i < ques.length(); i++) {
			char ch = ques.charAt(i);

			String roq = ques.substring(0, i) + ques.substring(i + 1);
			printPermu(roq, ans + ch, original);
		}

	}

	static int count = 0;

	public static void printPermuNoRepeat(String ques, String ans) {
		if (ques.length() <= 0) {
			System.out.print(ans + ", ");
			count++;
			return;
		}
		ArrayList<Character> donechar = new ArrayList<>();
		for (int i = 0; i < ques.length(); i++) {
			boolean flag = false;
			char ch = ques.charAt(i);

			for (int j = 0; j < donechar.size(); j++) {
				if (ch == donechar.get(j)) {
					flag = true;
					break;
				}

			}

			if (flag) {
				continue;
			}
			donechar.add(ch);
			// System.out.println(donechar);
			String roq = ques.substring(0, i) + ques.substring(i + 1);
			// System.out.println(roq + "--" +ch + "--" + donechar);
			printPermuNoRepeat(roq, ans + ch);
			// System.out.println(roq + "--" +ch + "--" + donechar);
		}

	}

	public static void printPermuNoDuplicatesMam(String ques, String ans) {
		if (ques.length() == 0) {
			System.out.print(ans + ", ");
			return;
		}

		for (int i = 0; i < ques.length(); i++) {
			boolean flag = true;
			char ch = ques.charAt(i);
			String roq = ques.substring(0, i) + ques.substring(i + 1);
			for (int j = i + 1; j < ques.length(); j++) {
				if (ch == ques.charAt(j)) {
					flag = false;
				}
			}

			if (flag)
				printPermuNoDuplicatesMam(roq, ans + ch);
		}

	}

	public static void PrintParenthesis(int n, int open, int close, String ans) {
		if (close == n && open == n) {
			System.out.print(ans + ", ");
			return;
		}

		if (close > n || open > n || close > open) {

			return;
		}
		if (open <= n)
			PrintParenthesis(n, open + 1, close, ans + "(");
		if (close <= n)
			PrintParenthesis(n, open, close + 1, ans + ")");

	}

	public static void lexicoCount(int n, int ans) {
		if (ans > n) {
			return;
		}

		if (ans <= n) {
			System.out.print(ans + " ");

		}

		int i = 0;
		if (ans == 0) {
			i = 1;
		}

		// lexicoCount(n, ans * 10);
		for (; i < 10; i++)
			lexicoCount(n, ans * 10 + i);

	}
}
