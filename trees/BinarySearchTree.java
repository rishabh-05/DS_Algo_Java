package trees;

import java.util.Scanner;

public class BinarySearchTree {

	Scanner sc = new Scanner(System.in);

	private class Node {
		int data;
		Node left;
		Node right;
	}

	private Node root;

	BinarySearchTree(int[] in) {
		root = construct(in, 0, in.length - 1);
	}

	private Node construct(int[] in, int lo, int hi) {

		if (lo > hi) {
			return null;
		}

		int mid = (lo + hi) / 2;
		Node nn = new Node();
		nn.data = in[mid];

		nn.left = construct(in, lo, mid - 1);
		nn.right = construct(in, mid + 1, hi);

		return nn;
	}

	public void display() {
		display(root);
	}

	private void display(Node node) {
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

	public int size() {
		return size(root);
	}

	private int size(Node node) {
		if (node == null) {
			return 0;
		}
		int c = 0;
		c += size(node.left);
		c += size(node.right);

		return c + 1;

	}

	public int height() {
		return height(root);
	}

	private int height(Node node) {
		// TODO Auto-generated method stub
		if (node == null) {
			return -1;
		}
		int hleft = height(node.left);
		int hright = height(node.right);
		int maxh = Math.max(hleft, hright);

		return maxh + 1;

	}

	public int max() {
		return max(root);
	}

	private int max(Node node) {
		if (node == null) {
			return Integer.MIN_VALUE;
		}
		int mn = node.data;

		int maxright = Math.max(mn, max(node.right));

		return maxright;

	}

	public boolean find(int item) {
		return find(root, item);
	}

	private boolean find(Node node, int item) {
		if (node == null) {
			return false;
		}
		if (node.data == item) {
			return true;
		}

		if (item < node.data) {
			return find(node.left, item);
		} else {
			return find(node.right, item);
		}

	}

	public void printInRange(int lo, int hi) {
		printIR(root, lo, hi);
	}

	private void printIR(Node node, int lo, int hi) {

		if (node == null) {
			return;
		}

		if (node.data > hi) {
			printIR(node.left, lo, hi);
		} else if (node.data < lo) {
			printIR(node.right, lo, hi);
		} else {
			printIR(node.left, lo, hi);
			System.out.print(node.data + " ");
			printIR(node.right, lo, hi);

		}

	}

	public void replacewithsumlarger() {
		int ans[] = new int[1];
		replacesum(root, ans);
	}

	private void replacesum(Node node, int[] ans) {
		if (node == null) {

			return;
		}

		replacesum(node.right, ans);
		int temp = node.data;
		node.data = ans[0];
		ans[0] += temp;
		replacesum(node.left, ans);

	}

	public void add(int item) {
		add(root, item);
	}

	private void add(Node node, int item) {

		if (item < node.data) {

			if (node.left == null) {
				Node nn = new Node();
				nn.data = item;

				node.left = nn;
			} else
				add(node.left, item);
		} else {

			if (node.right == null) {
				Node nn = new Node();
				nn.data = item;

				node.right = nn;
			} else
				add(node.right, item);
		}
	}

	public void remove(int item) {
		remove(null, root, item);
	}

	private void remove(Node parent, Node node, int item) {
		
		if(node == null) {
			return;		//element not found
		}
		
		if (item < node.data) {
			remove(node, node.left, item);
		} else if (item > node.data) {
			remove(node, node.right, item);
		} else {
			// leaf node to be removed

			if (node.left == null && node.right == null) {
				if(node.data < parent.data)
				parent.left = null;
				else
				parent.right = null;
			}
			// left node null, right node not null
			if (node.left == null && node.right != null) {
				if (parent.left == node) {
					parent.left = node.right;
				} else {
					parent.right = node.right;
				}
			}

			// right node null left node not null
			if (node.left != null && node.right == null) {
				if (parent.left == node) {
					parent.left = node.left;
				} else {
					parent.right = node.left;
				}
			}

			// if both not null
			if (node.left != null && node.right != null) {
				// find max node in left subtree(a leaf node)
				// ( OR MIN IN RIGHT TREE)
				// replace data with node
				// delete leaf node
				int maxinleft = max(node.left);
				remove(node, node.left, maxinleft);
				node.data = maxinleft;

			}
		}

	}

	public void removereturn(int item) {
		root = removereturn(root, item);
	}

	private Node removereturn(Node node, int item) {
		
		if(node.data == item) {
			
			if(node.left == null) return node.right;
			
			else if(node.right == null) return node.left;
			
			else {
				int maxinleft = max(node.left);
				node.data = maxinleft;
				return removereturn(node, maxinleft);
				
			}
			
			
		}
		
		node.left = removereturn(node.left, item);
		node.right = removereturn(node.right, item);
		
		return node;
		
		
	}
	

}
