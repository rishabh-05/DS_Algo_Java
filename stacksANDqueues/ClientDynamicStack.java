package stacksANDqueues;

import java.util.Stack;

public class ClientDynamicStack {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		DynamicStack s = new DynamicStack();

		s.push(5);
		s.push(51);
		s.push(52);
		s.push(53);
		s.push(54);
		s.push(55);
		s.push(56);
		// s.display();

//		printReverse(s);
//		System.out.println();
//		s.display();

//		reverseStack(s, new DynamicStack());
//		s.display();

//		int[] arr = {22, 10, 3, 4, 11, 18, 6};
//		for(int val : arr) {
//			System.out.print(val + " ");
//		}
//		System.out.println();
//		int[] ans = nextGreaterinOrderN(arr);
//		for(int val : ans) {
//			System.out.print(val + " ");
//		}

		int[] arr = { 2, 4, 3, 6, 1, 5, 8, 7 };
		for (int val : arr) {
			System.out.print(val + " ");
		}
		System.out.println();
		int[] ans = stockSpan(arr);
		for (int val : ans) {
			System.out.print(val + " ");
		}

	}

	public static void printReverse(DynamicStack s) throws Exception {
		if (s.isEmpty()) {
			return;
		}

		int current = s.pop();
		printReverse(s);
		System.out.print(current + "=>");
		s.push(current);

	}

	public static void reverseStack(DynamicStack s, DynamicStack h) throws Exception {
		if (s.isEmpty()) {
			if (h.isEmpty()) {
				return;
			}
			int temp = h.pop();
			reverseStack(s, h);
			s.push(temp);

			return;
		}

		h.push(s.pop());
		reverseStack(s, h);

	}

	public static int[] nextGreaterinOrderN(int[] arr) throws Exception {

		int[] ans = new int[arr.length];
		Stack<Integer> s1 = new Stack<>();

		for (int i = 0; i < arr.length; i++) {

			while (!s1.isEmpty() && arr[i] > arr[s1.peek()]) {

				int temp = s1.pop();
				ans[temp] = arr[i];
			}

			s1.push(i);
		}

		while (!s1.isEmpty()) {
			ans[s1.pop()] = -1;
		}

		return ans;

	}

	public static int[] stockSpan(int[] prices) throws Exception {

		int[] ans = new int[prices.length];
		DynamicStack s = new DynamicStack();

		for (int i = 0; i < prices.length; i++) {

			while (!s.isEmpty() && prices[i] > prices[s.peek()]) {
				s.pop();

			}
			if (s.isEmpty()) {
				ans[i] = i + 1;
			} else {
				ans[i] = i - s.peek();
			}

			s.push(i);

		}
		return ans;
	}
}
