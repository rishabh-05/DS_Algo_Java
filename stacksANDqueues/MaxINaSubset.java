package stacksANDqueues;

public class MaxINaSubset {

	/*
	 * i/p: 1, 2, 3, 1, 4, 5, 2, 3, 6 k: 3 o/p: 3, 3, 4, 5, 5, 5, 6
	 * 
	 */

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		int[] arr = { 8, 5, 10, 7, 9, 4, 5, 12, 90, 13 };
		MaxinWindow(arr, 4);
	}

	public static void MaxinWindow(int[] arr, int k) throws Exception {

		DynamicQueue q = new DynamicQueue();

		q.enqueue(0);
		for (int i = 1; i < k; i++) {
			if (arr[i] > arr[q.getFront()]) {
				q.dequeue();
				q.enqueue(i);
			}
		}

		for (int i = 1; i <= arr.length - k; i++) {
			if (!q.isEmpty())
				System.out.print(arr[q.getFront()] + " ");
			
			if (arr[i + k - 1] > arr[q.getFront()]) {
				// remove if useless
				if (q.getFront() < i) {
					q.dequeue();
				}
 
				if (!q.isEmpty())
					q.dequeue();
				q.enqueue(i + k - 1);
			}
		

		}

		System.out.println(arr[q.getFront()]);

	}

}
