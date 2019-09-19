

public class LLGeneric<T> {
	
	

		private class Node {
			T data;
			Node next;

			
			Node() {
				this.data = null;
				this.next = null;
			}

			Node(T data) {
				this.data = data;
				this.next = null;
			}
		}

		private Node head;
		private Node tail;
		private int size;

		public int size() {
			return this.size;
		}

		public boolean isEmpty() {
			return this.size == 0;
		}

		public T getFirst() throws Exception {
			if (this.size == 0) {
				throw new Exception("Empty LinkedList");
			}
			return this.head.data;
		}

		public T getLast() throws Exception {
			if (this.size == 0) {
				throw new Exception("Empty LinkedList");
			}
			return this.tail.data;
		}

		public T getAt(int pos) throws Exception {
			if (this.size == 0) {
				throw new Exception("Empty LinkedList");
			}
			if (pos < 0 || pos >= this.size) {
				throw new Exception("Invalid Position");
			}
			Node temp = head;
			for (int i = 1; i <= pos; i++) {
				temp = temp.next;
			}
			return temp.data;
		}

		public Node getNodeAt(int pos) throws Exception {
			if (this.size == 0) {
				throw new Exception("Empty LinkedList");
			}
			if (pos < 0 || pos > this.size) {
				throw new Exception("Invalid Position");
			}
			Node temp = head;
			for (int i = 1; i <= pos; i++) {
				temp = temp.next;
			}
			return temp;
		}

		public void display() {
			System.out.println("-----------------------");
			Node temp = this.head;

			while (temp != null) {
				System.out.print(temp.data + " ");
				temp = temp.next;
			}
			System.out.println("\n-----------------------");
		}

		public void addfirst(T item) {
			// create
			Node nn = new Node(item);

			// connect

			if (this.size == 0) {
				head = nn;
				tail = nn;
				this.size++;
			} else {
				nn.next = head;
				head = nn;
				this.size++;
			}

		}

		public void addAt(T item, int pos) throws Exception {

			if (pos > this.size || pos < 0) {
				throw new Exception("Invalid position");
			}
			if (pos == 0) {
				addfirst(item);
			} else {
				// traverse till pos-1
				Node temp = head;
				for (int i = 1; i < pos; i++) {
					temp = temp.next;
				}

				// create
				Node nn = new Node(item);
				// connect
				nn.next = temp.next;
				temp.next = nn;

				this.size++;
			}

		}

		public void addlast(T item) {
			// create new node
			Node nn = new Node(item);
//				nn.data = item;
//				nn.next = null;

			// attach
			if (this.size >= 1) {
				this.tail.next = nn;

			}
			// update object
			if (this.size == 0) {
				this.head = nn;
				this.tail = nn;
				this.size++;
			} else {
				this.tail = nn;
				this.size++;
			}

		}

		public T removeFirst() throws Exception {
			if (this.size == 0) {
				throw new Exception("Empty list.");
			}

			if (this.size == 1) {
				T rv = head.data;
				head = null;
				tail = null;
				this.size--;
				return rv;
			}
			T rv = head.data;
			this.head = this.head.next;
			this.size--;
			return rv;
		}

		public T removelast() throws Exception {
			if (this.size == 0) {
				throw new Exception("Empty list.");
			}

			if (this.size == 1) {
				head = null;
				tail = null;
				this.size--;
				return this.head.data;
			}

			Node temp = head;
			for (int i = 0; i < this.size - 2; i++) {
				temp = temp.next;
			}
			T rv = this.tail.data;
			tail = temp;
			tail.next = null;
			this.size--;
			return rv;

		}

}
