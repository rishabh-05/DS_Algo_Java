package Recursion;

import java.util.ArrayList;

public class AllPossibleAnswers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(ExpressionResult("10-2*3-4*5"));

	}

	public static int calculate(int a, int b, char op) {
		if (op == '*') {
			return a * b;
		} else if (op == '+') {
			return a + b;
		} else {
			return a - b;
		}
	}

	public static ArrayList<Integer> ExpressionResult(String exp) {
		
		
		ArrayList<Integer> mr = new ArrayList<>();

		for (int i = 0; i < exp.length(); i++) {
			if (!Character.isDigit(exp.charAt(i))) {

				String fh = exp.substring(0, i);
				String sh = exp.substring(i + 1);
				
				ArrayList<Integer> rr1 = ExpressionResult(fh);
				ArrayList<Integer> rr2 = ExpressionResult(sh);

				for(int valo : rr1) {
					for(int vali : rr2) {
						int ans = calculate(valo, vali, exp.charAt(i));
						mr.add(ans);
					}
				}
			}
		}
		if(mr.size()==0) {
			mr.add(Integer.parseInt(exp));
		}
		
		return mr;
	}
}
