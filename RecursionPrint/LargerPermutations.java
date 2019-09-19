package RecursionPrint;

import java.util.*;

public class LargerPermutations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		char[] cc = str.toCharArray();
		Arrays.sort(cc);
		String str1 = "";
		for(char val : cc) {
			str1+=val;
		}
		printPermu(str1, "", str);

	}
	
	public static void printPermu(String ques, String ans, String original) {
		if (ques.length() == 0 && ans.compareTo(original)>0) {
			System.out.print(ans + ", ");
			return;
		}
		for (int i = 0; i < ques.length(); i++) {
			char ch = ques.charAt(i);

			String roq = ques.substring(0, i) + ques.substring(i + 1);
			printPermu(roq, ans + ch, original);
		}

	}

}
