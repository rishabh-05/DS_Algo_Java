package LinkedLists;

public class LinkedList {

	private class Node {
		int data;
		Node next;

		
		Node() {
			this.data = 0;
			this.next = null;
		}

		Node(int data) {
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

	public int getFirst() throws Exception {
		if (this.size == 0) {
			throw new Exception("Empty LinkedList");
		}
		return this.head.data;
	}

	public int getLast() throws Exception {
		if (this.size == 0) {
			throw new Exception("Empty LinkedList");
		}
		return this.tail.data;
	}

	public int getAt(int pos) throws Exception {
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

	public void addfirst(int item) {
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

	public void addAt(int item, int pos) throws Exception {

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

	public void addlast(int item) {
		// create new node
		Node nn = new Node(item);
//			nn.data = item;
//			nn.next = null;

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

	public int removeFirst() throws Exception {
		if (this.size == 0) {
			throw new Exception("Empty list.");
		}

		if (this.size == 1) {
			int rv = head.data;
			head = null;
			tail = null;
			this.size--;
			return rv;
		}
		int rv = head.data;
		this.head = this.head.next;
		this.size--;
		return rv;
	}

	public int removelast() throws Exception {
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
		int rv = this.tail.data;
		tail = temp;
		tail.next = null;
		this.size--;
		return rv;

	}

	public int removeAt(int index) throws Exception {
		int rv = 0;
		if (this.size == 0)
			throw new Exception("No Element Present. Empty List.");
		if (index > this.size || index < 0) {
			throw new Exception("Invalid position");
		}
		if (index == this.size - 1) {
			removelast();
		}

		if (index == 0)
			removeFirst();
		else {
			Node temp = head;
			for (int i = 0; i < index - 1; i++) {
				temp = temp.next;
			}
			rv = temp.next.data;
			temp.next = temp.next.next;
			this.size--;
		}
		return rv;
	}

	public void itReverseData() throws Exception {

		int left = 0;
		int right = this.size - 1;
		while (left < right) {
			Node front = getNodeAt(left);
			Node back = getNodeAt(right);
			int temp = front.data;
			front.data = back.data;
			back.data = temp;
			front = front.next;
			left++;
			right--;
		}

	}

	public void itreversePointer() throws Exception {

		Node prev = head;
		Node curr = head.next;

		while (curr != null) {

			Node ne = curr.next;
			curr.next = prev;
			prev = curr;
			curr = ne;

		}

		// swap head and tail
		Node temp = head;
		head = tail;
		tail = temp;

		tail.next = null;
	}

	public void RecReversePointer() {
		revPR(head, head.next);
		Node temp = head;
		head = tail;
		tail = temp;

		tail.next = null;
	}

	private void revPR(Node prev, Node curr) {
		if (curr == null) {
			return;
		}
		revPR(curr, curr.next);
		curr.next = prev;

	}

	public void RecRevData() {
		revDR(head, head, 0);
	}

	private Node revDR(Node left, Node right, int count) {
		if (right == null) {
			return left;

		}

		Node cl = revDR(left, right.next, count + 1);

		if (count >= this.size / 2) {
			int temp = cl.data;
			cl.data = right.data;
			right.data = temp;
		}
		cl = cl.next;
		return cl;

	}

	public void fold() {
		fold(head, head, 0);
	}

	private Node fold(Node left, Node right, int count) {

		if (right == null) {
			return left;
		}
		Node cl = fold(left, right.next, count + 1);
		Node ahead = null;
		if (count > this.size / 2) {

			ahead = cl.next;
			cl.next = right;

			right.next = ahead;
			// System.out.print(cl.data + " " +right.data + " ");

		}
		if (count == this.size / 2) {
			tail = right;
			tail.next = null;
		}

		return ahead;

	}

	private class HeapMover {
		Node left;
	}

	public void reverseDRHM() {
		HeapMover mover = new HeapMover();
		mover.left = head;
		reverseDRHM(mover, head, 0);
	}

	private void reverseDRHM(HeapMover mover, Node right, int count) {
		if (right == null) {
			return;

		}

		reverseDRHM(mover, right.next, count + 1);

		if (count >= this.size / 2) {
			int temp = mover.left.data;
			mover.left.data = right.data;
			right.data = temp;
		}
		mover.left = mover.left.next;
	}

	public int midnode() {
		Node temp = head;
		Node temp1 = head;
		while (temp1.next != null && temp1.next.next != null) {
			temp = temp.next;
			temp1 = temp1.next.next;
		}

		return temp.data;
	}

	public int kthfromlast(int k) {

		Node temp = head;
		for (int i = 0; i < k; i++) {
			temp = temp.next;
		}
		Node temp1 = head;
		while (temp != null) {
			temp1 = temp1.next;
			temp = temp.next;
		}
		return temp1.data;
	}

	public void kreverse(int k) throws Exception {

		LinkedList prev = null;

		while (size != 0) {
			LinkedList curr = new LinkedList();
			
			for (int i = 0; i < k && size != 0; i++) {
				curr.addfirst(this.removeFirst());
			}
			
			

			if (prev == null) {
				prev = curr;
				

			} else {
				//connect
				prev.tail.next = curr.head;
				prev.tail = curr.tail;
				prev.size += curr.size;
			}

		}
		
		this.head = prev.head;
		this.tail = prev.tail;
		this.size = prev.size;

	}

	public void intersection() {
		// dummy list for logic testing

		Node n1 = new Node(10);
		Node n2 = new Node(20);
		Node n3 = new Node(30);
		Node n4 = new Node(40);
		Node n5 = new Node(50);
		Node n6 = new Node(60);
		Node n7 = new Node(70);
		Node n8 = new Node(80);

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n7.next = n8;
		n8.next = n4;

		// logic

		Node a = n1;
		Node b = n7;

		while (a != b) {

			a = a == null ? n7 : a.next;
			b = b == null ? n1 : b.next;
		}

		System.out.println(a.data);

	}

	public void createDummyListLoop() {
//for ll loop
		Node n1 = new Node(10);
		Node n2 = new Node(20);
		Node n3 = new Node(30);
		Node n4 = new Node(40);
		Node n5 = new Node(50);
		Node n6 = new Node(60);
		Node n7 = new Node(70);
		Node n8 = new Node(80);
		Node n9 = new Node(90);

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = n8;
		n8.next = n9;
		n9.next = n4;

		this.head = n1;
	}

	public void detectRemoveLoop() {

		// detect loop
		Node slow = head;
		Node fast = head;

		while (fast != null || fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;

			if (slow == fast) {
				break;
			}
		}

		if (slow == fast) {
			// loop was present
			// now remove it
			Node start = head;
			Node loop = slow;

			while (start.next != loop.next) {
				start = start.next;
				loop = loop.next;
			}

			loop.next = null;

		} else {
			// loop not present
		}

	}

	
	public void removeAllDuplicates() {

		Node fakehead = new Node();
		fakehead.next = head;

		Node prev = fakehead;
		Node curr = head;

		while (curr != null) {

			while (curr.next != null && curr.data == curr.next.data) {
				curr = curr.next;
			}

			if (prev.next == curr) {
				prev = curr;
			} else {
				prev.next = curr.next;
			}

			curr = curr.next;
		}

		head = fakehead.next;

	}

}
