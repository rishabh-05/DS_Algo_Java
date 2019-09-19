package stacksANDqueues;

public class NegativeINaWindow {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		int[] arr = { 2, -3, 5, 6, -2, -9, -4, -10, -15 };
		firstNegative(arr, 3);
	}

	public static void firstNegative(int[] arr, int k) throws Exception { // k is window size

		DynamicQueue q = new DynamicQueue();

		// 1. add -ves of first window elements

		for (int i = 0; i <= k - 1; i++) {
			if (arr[i] < 0) {
				q.enqueue(i);
			}
		}

		// 2. window updation by running loop from 1 to n-k(last possible window)

		for (int i = 1; i <= arr.length - k; i++) {

			if (!q.isEmpty()) {
				System.out.print(arr[q.getFront()] + " ");
			} else {
				System.out.println(0 + " ");
			}

			if (!q.isEmpty() && q.getFront() < i) {
				q.dequeue();
			}

			// add next element to queue if negative
			if (arr[i + k - 1] < 0) {
				q.enqueue(i + k - 1);
			}
		}
		if (!q.isEmpty()) {
			System.out.print(arr[q.getFront()] + " ");
		} else {
			System.out.println(0 + " ");
		}

	}
}
