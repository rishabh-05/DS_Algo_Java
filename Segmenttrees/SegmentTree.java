package Segmenttrees;

public class SegmentTree {
	// made generic using STreeIn Interface. queries = Sum, Product, Max, Min.

	class Node {
		int data;
		Node left;
		Node right;
		int nsi;
		int nei;
	}

	private Node root;
	private STreeIN sti;

	public SegmentTree(int[] arr, STreeIN sti) {
		// TODO Auto-generated constructor stub
		this.sti = sti;
		root = construct(arr, 0, arr.length - 1);
	}

	private Node construct(int[] arr, int lo, int hi) {
		// TODO Auto-generated method stub
		if (lo == hi) {
			Node bc = new Node();
			bc.nsi = lo;
			bc.nei = hi;
			bc.data = arr[lo];
			return bc;
		}

		Node nn = new Node();
		int mid = (lo + hi) / 2;
		nn.nsi = lo;
		nn.nei = hi;
		nn.left = construct(arr, lo, mid);
		nn.right = construct(arr, mid + 1, hi);

		nn.data = sti.type(nn.left.data, nn.right.data);

		return nn;

	}

	public void display() {
		System.out.println("----------------------");
		display(root);
		System.out.println("----------------------");
	}

	private void display(Node node) {
		// TODO Auto-generated method stub
		if (node == null) {
			return;
		}

		String str = "";
		if (node.left == null) {
			str += ".";
		} else {
			str += node.left.data;
		}
		str += " -> " + node.data + " <- ";
		if (node.right == null) {
			str += ".";
		} else {
			str += node.right.data;
		}
		System.out.println(str);
		display(node.left);
		display(node.right);

	}

	public int query(int qsi, int qei) {
		return query(root, qsi, qei);
	}

	private int query(Node node, int qsi, int qei) {
		// TODO Auto-generated method stub

		if (node.nsi >= qsi && node.nei <= qei) { // full contribution
			return node.data;
		} else if (node.nsi > qei || node.nei < qsi) { // no contribution
			return sti.defaultValue();
		} else { // overlapping
			int lqr = query(node.left, qsi, qei);
			int rqr = query(node.right, qsi, qei);

			return sti.type(lqr, rqr);
		}

	}

	public void update(int idx, int item) {
		update(root, idx, item);
	}

	private void update(Node node, int idx, int item) {

		if (idx == node.nei && idx == node.nsi) {
			node.data = item;
			return;
		} else if (idx >= node.nsi && idx <= node.nei) {
			update(node.left, idx, item);
			update(node.right, idx, item);

			node.data = sti.type(node.left.data, node.right.data);
		} else {
			// do nothing
		}

	}

}
