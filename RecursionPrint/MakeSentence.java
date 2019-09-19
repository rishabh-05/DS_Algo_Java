package RecursionPrint;

import java.util.*;

public class MakeSentence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] Dictionary = {"I", "like", "sam","sung", "samsung","mobile", "phones", "mobilephones", "verymuch", "very", "much"};
		Arrays.sort(Dictionary);
		wordBreak("Ilikesamsungmobilephonesverymuch", "", Dictionary);

	}

	public static boolean inDictionary(String str, String[] dictionary) {

		if (Arrays.binarySearch(dictionary, str) >= 0) {
			return true;
		} else {
			return false;
		}

	}
	
	public static void wordBreak(String str, String ans, String[] dictionary) {
		if(str.length()==0) {
			System.out.println(ans + " ");
			return;
		}
		
		int i = 1;
		for(; i<=str.length(); i++) {
			String cstr = str.substring(0, i);
			if(inDictionary(cstr, dictionary)) {
				String ros = str.substring(i);
				wordBreak(ros, ans+cstr+" ", dictionary);
			}
		}
	}

}
