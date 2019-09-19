package stacksANDqueues;

public class Queue {

	protected int[] data;
	protected int front;
	protected int size;
	public static int Default_capacity = 5;

	public Queue() throws Exception {
		this(Default_capacity);
		front = 0;
		size = 0;
	}

	public Queue(int capacity) throws Exception {
		if (capacity < 1)
			throw new Exception("Invalid Capacity.");
		this.data = new int[capacity];
		front = 0;
		size = 0;
		// TODO Auto-generated constructor stub
	}

	public int size() throws Exception {
		return this.size;
	}

	public boolean isEmpty() throws Exception {
		return this.size() == 0;
	}

	public boolean isFull() throws Exception {
		return this.size() == this.data.length;
	}

	public void enqueue(int value) throws Exception {
		if (this.data.length == this.size())
			throw new Exception("Queue is full. Overflow error");

		int ai = (this.front + this.size) % this.data.length;
		this.data[ai] = value;
		this.size++;
	}

	public int dequeue() throws Exception {
		if (this.size() == 0)
			throw new Exception("Queue already empty. Underflow error");

		int rv = this.data[this.front];
		this.data[this.front] = 0;
		this.front = (this.front + 1) % this.data.length;
		this.size--;
		return rv;
	}

	public int getFront() throws Exception {
		if (this.size == 0) {
			throw new Exception("Empty Queue. Underflow error.");
		}
		int rv = this.data[this.front];
		return rv;
	}

	public void display() {

		for (int i = 0; i < this.size; i++) {
			int ai = (this.front + i) % this.data.length;
			System.out.print(this.data[ai] + "=>");
		}
		System.out.println("END");

	}

}
