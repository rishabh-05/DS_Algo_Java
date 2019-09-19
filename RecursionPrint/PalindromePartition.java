package RecursionPrint;

public class PalindromePartition {
	
	/*
	 * i/p: bcc
	 * o/p: b c c
	 * 		b cc
	 * i/p: nitin
	 * o/p: n i t i n
	 * 		n iti n
	 * 		nitin
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printPartition("nitinssa", "");

	}
	static int count = 0;
	public static void printPartition(String str, String ans) {
		if(str.length()==0) {
			System.out.println(count++ + ans + " ");
			return;
		}
		
		int i = 1;
		for(; i<=str.length(); i++) {
			String cstr = str.substring(0, i);
			if(isPalindrome(cstr)) {
				String ros = str.substring(i);
				printPartition(ros, ans+cstr+" ");
			}
		}
	}
	
	public static boolean isPalindrome(String str) {
		boolean flag = false;
		
		int i = 0;
		int j = str.length()-1;
		
		while(i<=j) {
			if(str.charAt(i)!=str.charAt(j)) {
				break;
			}
			i++;
			j--;
		}
		if(i>=j) {
			flag = true;
		}
		return flag;
	}

}
