package stacksANDqueues;

import java.util.Stack;

public class BalancedPara {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String str = "(({}))(()(())[])";
		Stack<Character> s = new Stack<>();
		System.out.println(isBalanced(str, s));

	}

	public static boolean isBalanced(String str, Stack<Character> stack) throws Exception {
		char c0 = str.charAt(0);
		if(c0 == ')' || c0 == ']' || c0 == '}')
			return false;
		
		for (int i = 0; i < str.length(); i++) {
			char cc = str.charAt(i);

			if (cc == '(' || cc == '[' || cc == '{') {
				stack.push(cc);
			} else {
				if (isClosing(cc, stack.peek())) {
					stack.pop();
				}
			}
		}
		if (stack.isEmpty()) {
			return true;
		} else {
			return false;
		}

	}

	private static boolean isClosing(char c1, char c2) {
		if (c1 == ')' && c2 == '(')
			return true;
		else if (c1 == '}' && c2 == '{')
			return true;
		else if (c1 == ']' && c2 == '[')
			return true;
		else
			return false;
	}

}
