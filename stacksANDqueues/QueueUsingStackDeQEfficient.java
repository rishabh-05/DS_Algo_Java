package stacksANDqueues;

public class QueueUsingStackDeQEfficient {

	static DynamicStack s = new DynamicStack();

	public static boolean isEmpty() throws Exception {
		return s.isEmpty();
	}

	public static void enqueue(int item) throws Exception {
		try {
			DynamicStack helper = new DynamicStack();
			while (!s.isEmpty()) {
				helper.push(s.pop());
			}
			s.push(item);
			while (!helper.isEmpty()) {
				s.push(helper.pop());
			}
		} catch (Exception e) {
			throw new Exception("Queue Full");
		}
//		System.out.println("----");
//		s.display();
//		System.out.println("----");

	}

	public static void getFront() throws Exception {
		try {
			s.peek();
		} catch (Exception e) {
			throw new Exception("Queue Empty");
		}
	}

	public static int dequeue() throws Exception {
		try {
			int rv = s.pop();
			return rv;
		} catch (Exception e) {
			throw new Exception("Queue Empty");
		}
	}

	public static void display() throws Exception {
		s.display();
	}

	public static void main(String[] args) throws Exception {

		enqueue(5);
		enqueue(15);
		enqueue(25);
		enqueue(35);
		enqueue(45);
		
		display();
		dequeue();
		display();
	}

}
