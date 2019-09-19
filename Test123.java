import java.util.*;

public class Test123 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = "100[leetcode]";
		

		System.out.println(decode(str));
	}

	public static String decode(String str) {

		StringBuilder cur = new StringBuilder();
		
		Stack<Integer> intst = new Stack<>();
		Stack<StringBuilder> strst =  new Stack<>();
		int k = 0;
		for(char ch : str.toCharArray()) {
			
			if(Character.isDigit(ch)) {
				k = 10*k + ch - '0';
				
			}
			else if(ch == '[') {
				intst.push(k);
				strst.push(cur);
				k = 0;
				cur = new StringBuilder();
				
			}
			else if(ch == ']') {
				StringBuilder temp = cur;
				cur = strst.pop();
				for(k = intst.pop(); k>0; k--) {
					cur.append(temp);
				}
			}
			else {
				cur.append(ch);
			}
			
		}

		
		return cur.toString();

	}

}
