package Assignments;

import java.util.Scanner;
import java.util.Stack;
public class MaxDepth_Stacks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t!=0) {
			Stack<Character> st = new Stack<>();
			String str = sc.next();
			
			int max = 0;
			int count = 0;
			for(int i = 0; i< str.length(); i++) {
				if(str.charAt(i) == '(') {
					st.push(str.charAt(i));
					count++;
					if(count>max) {
						max = count;
					}
				}
				if(str.charAt(i) == ')') {
					if(!st.isEmpty()) {
						st.pop();
						
					}
					count--;
				}
				
			}
			if(!st.isEmpty() || count<0) {
				System.out.println(-1);
			}else {
				System.out.println(max);
			}
			
			
			t--;
		}

	}

}
