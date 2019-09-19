package stacksANDqueues;



public class ClientQueue {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		DynamicQueue q1 = new DynamicQueue();
		q1.enqueue(10);
		q1.enqueue(20);
		q1.enqueue(30);
		q1.enqueue(40);
		q1.enqueue(50);

		q1.display();

		// actualReverse(q1);
		printReverse(q1, 0);
		System.out.println();
		q1.display();

	}

	public static void actualReverse(DynamicQueue q) throws Exception {

		if (q.isEmpty()) {
			return;
		}

		int rv = q.dequeue();
		actualReverse(q);
		q.enqueue(rv);

	}

	public static void printReverse(DynamicQueue q, int i) throws Exception {

		if (i==q.size()) {
			return;
		}

		int temp = q.dequeue();
		q.enqueue(temp);
		printReverse(q, i+1);
		System.out.print(temp + "=>");

	}

}
