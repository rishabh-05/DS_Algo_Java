
package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class GenericTree {

	Scanner scn = new Scanner(System.in);

	private class Node {
		int data;
		ArrayList<Node> children = new ArrayList<>();
	}

	private Node root;

	public GenericTree() {
		root = takeInput(null, -1);
	}

	private Node takeInput(Node parent, int ith) {

		if (parent == null) {
			System.out.println("Enter the data for root node ?");
		} else {
			System.out.println("Enter the data for " + ith + " child of " + parent.data);
		}

		int item = scn.nextInt();

		// create a new node
		Node nn = new Node();
		nn.data = item;

		System.out.println("No. of children for " + nn.data);
		int noc = scn.nextInt();

		for (int i = 0; i < noc; i++) {

			Node child = takeInput(nn, i);
			nn.children.add(child);

		}

		return nn;
	}

	public void display() {
		display(root);
	}

	private void display(Node node) {

		String str = node.data + "->";

		for (Node child : node.children) {
			str += child.data + ", ";
		}

		str += ".";
		System.out.println(str);

		for (Node child : node.children) {
			display(child);
		}

	}

	public int size() {
		return size(root);
	}

	private int size(Node node) {

		int ts = 0;

		for (Node i : node.children) {
			int cs = size(i);
			ts += cs;
		}
		return ts + 1;
	}

	public int max() {
		return max(root);
	}

	private int max(Node node) {
		int max = node.data;
		int c = 0;
		for (Node val : node.children) {
			c = max(val);
		}
		return Math.max(max, c);
	}

	public boolean find(int item) {
		return find(item, root);
	}

	private boolean find(int item, Node node) {
		// TODO Auto-generated method stub
		if (node.data == item) {
			return true;
		}
		boolean ans = false;
		for (Node val : node.children) {
			ans = find(item, val);
			if (ans) {
				break;
			}
		}
		return ans;
	}

	public int height() {
		return height(root);
	}

	private int height(Node node) {
		int ht = -1;
		int ct;
		for (Node val : node.children) {
			ct = height(val);
			ht = Math.max(ct, ht);

		}
		return ht + 1;
	}

	public void linearize() {
		linearize(root);
	}

	private void linearize(Node root) {

		for (Node child : root.children) {
			linearize(child);
		}

		while (root.children.size() > 1) {
			Node firstind = root.children.remove(1);
			Node tail = getTail(root.children.get(0));
			tail.children.add(firstind);
		}

	}

	private Node getTail(Node node) {
		if (node.children.size() == 0) {
			return node;
		}
		return getTail(node.children.get(0));

	}

	public void mirror() {
		mirror(root);
	}

	private void mirror(Node node) {

		for (Node val : node.children) {
			mirror(val);

		}
		int left = 0;
		int right = node.children.size() - 1;
		while (left < right) {
			Node ln = node.children.get(left);
			Node rn = node.children.get(right);
			node.children.set(left, rn);
			node.children.set(right, ln);

			left++;
			right--;
		}

	}

	public void preorder() {
		preorder(root);
	}

	private void preorder(Node node) {
		System.out.print(node.data + "=>");

		for (Node child : node.children) {
			preorder(child);
		}
	}

	public void postorder() {
		postorder(root);
	}

	private void postorder(Node node) {

		for (Node child : node.children) {
			preorder(child);
		}
		System.out.print(node.data + "=>");
	}

	public void levelOrder() {

		LinkedList<Node> queue = new LinkedList<>();

		queue.add(root);

		while (!queue.isEmpty()) {

			Node rn = queue.removeFirst();

			System.out.print(rn.data + " ");

			for (Node child : rn.children) {
				queue.addLast(child);
			}

		}

		System.out.println();

	}

	public void levelOrderLineWise() {

		// null as delimiter
		LinkedList<Node> queue = new LinkedList<>();

		queue.addLast(root);
		queue.addLast(null);
		while (!queue.isEmpty()) {

			Node rn = queue.removeFirst();
			if (rn == null) {
				System.out.println();

				if (queue.isEmpty())
					break;

				queue.addLast(null);
			}

			if (rn == null) {
				continue;
			}
			System.out.print(rn.data + " ");

			for (Node child : rn.children) {
				queue.addLast(child);

			}

		}

		System.out.println();

	}

	public void levelOrderLineWise2Qs() {

		LinkedList<Node> queue = new LinkedList<>();
		LinkedList<Node> qhelper = new LinkedList<>();

		queue.addLast(root);

		while (!queue.isEmpty()) {

			Node rn = queue.removeFirst();

			System.out.print(rn.data + " ");

			for (Node child : rn.children) {
				qhelper.addLast(child);

			}
			if (queue.isEmpty()) {
				System.out.println();
				LinkedList<Node> temp = queue;
				queue = qhelper;
				qhelper = temp;
			}

		}

		System.out.println();

	}

	public void levelOrderLineWiseZigZag() {
		LinkedList<Node> primary = new LinkedList<>();
		LinkedList<Node> helper = new LinkedList<>();

		primary.addFirst(root);

		int count = 0;
		while (!primary.isEmpty()) {
			Node rn = primary.removeFirst();
			System.out.print(rn.data + " ");
			if (count % 2 == 0) {
				for (Node child : rn.children) {
					helper.addFirst(child);
				}
			} else {

				for (int i = rn.children.size() - 1; i >= 0; i--) {
					helper.addFirst(rn.children.get(i));
				}
			}
			
			if(primary.isEmpty()) {
				LinkedList<Node> temp = primary;
				primary = helper;
				helper = temp;
				count++;
				System.out.println();
			}

		}
	}

	public void printAtlevel(int level) {
		printAtlevel(root, level, 0);
	}

	private void printAtlevel(Node node, int level, int count) {
		// TODO Auto-generated method stub
		if (count == level) {
			System.out.println(node.data);
			// return; ......optional
			return;
		}

		for (Node child : node.children) {
			printAtlevel(child, level, count + 1);
		}
	}

}
