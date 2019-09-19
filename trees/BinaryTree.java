package trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class BinaryTree {
	static Scanner sc = new Scanner(System.in);

	private class Node {
		int data;
		Node left;
		Node right;
	}

	private static Node root;

	BinaryTree() {
		root = construct(null, false);
	}

	private Node construct(Node parent, boolean ilc) {
		if (parent == null) {
			// parent
			System.out.println("Enter the root node data");
		} else {
			if (ilc) {
				System.out.println("Enter the left child of " + parent.data);
			} else {
				System.out.println("Enter the right child of " + parent.data);
			}
		}
		Node nn = new Node();
		nn.data = sc.nextInt();
		System.out.println("Does it have left child?");
		boolean hlc = sc.nextBoolean();
		if (hlc) {
			nn.left = construct(nn, true);
		}
		System.out.println("Does it have right child?");
		boolean hrc = sc.nextBoolean();
		if (hrc) {
			nn.right = construct(nn, false);
		}

		return nn;
	}

	BinaryTree(int[] pre, int[] in) {
		root = construct(pre, 0, pre.length - 1, in, 0, in.length - 1);
	}

	private Node construct(int[] pre, int plo, int phi, int[] in, int ilo, int ihi) {

		if (plo > phi || ilo > ihi) {
			return null;
		}
		Node nn = new Node();
		nn.data = pre[plo];

		// search for pre[plo] in in[]
		int si = -1;
		int nel = 0;
		for (int i = ilo; i <= ihi; i++) {
			if (in[i] == pre[plo]) {
				si = i;
				break;
			}
			nel++;
		}

		nn.left = construct(pre, plo + 1, plo + nel, in, ilo, si - 1);
		nn.right = construct(pre, plo + nel + 1, phi, in, si + 1, ihi);

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

	public int max() {
		return max(root);
	}

	private int max(Node node) {
		if (node == null) {
			return Integer.MIN_VALUE;
		}
		int mn = node.data;

		int maxleft = Math.max(mn, max(node.left));
		int maxright = Math.max(mn, max(node.right));

		return Math.max(maxleft, maxright);

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
		boolean inlefttree = find(node.left, item);

		// optimise.
		// Agar left tree me mil gya hai to right tree ki call na lage
		if (inlefttree) {
			return true;
		}
		boolean inrighttree = find(node.right, item);
		return inlefttree || inrighttree;

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

	public int diameter() {
		return diameter(root);
	}

	private int diameter(Node node) {

		if (node == null) {
			return 0;
		}
		int lh = height(node.left);
		int rh = height(node.right);
		int d = rh + lh;
		if (node.right != null) {
			d++;
		}
		if (node.left != null) {
			d++;
		}

		int ld = diameter(node.left);
		int rd = diameter(node.right);
		return Math.max(d, Math.max(ld, rd));

	}

	private class Diapair {
		int diameter;
		int height;
	}

	public int Diameter2() {
		return Diameter2(root).diameter;
	}

	private Diapair Diameter2(Node node) {
		if (node == null) {
			Diapair bd = new Diapair();
			bd.height = -1;
			bd.diameter = 0;
			return bd;
		}

		Diapair ldp = Diameter2(node.left);
		Diapair rdp = Diameter2(node.right);

		int ld = ldp.diameter;
		int rd = rdp.diameter;
		int sd = ldp.height + rdp.height + 2;

		int mlr = Math.max(sd, Math.max(ld, rd));

		Diapair ans = new Diapair();
		ans.diameter = mlr;
		ans.height = Math.max(ldp.height, rdp.height) + 1;

		return ans;

	}

	public boolean isBalanced() {
		return isBalanced(root);
	}

// O(n^2) approach using height
	private boolean isBalanced(Node node) {
		if (node == null) {
			return true;
		}
		boolean isleft = isBalanced(node.left);
		boolean isright = isBalanced(node.right);
		int lh = height(node.left);
		int rh = height(node.right);

		int bal = Math.abs(lh - rh);
		boolean flag = (bal == 0 || bal == 1);
		return flag && isleft && isright;
	}

	private class BalPair {
		int height;
		boolean isBal;
	}

	public boolean isBalanced2() {
		return isBalanced2(root).isBal;
	}

	private BalPair isBalanced2(Node node) {
		if (node == null) {
			BalPair bc = new BalPair();
			bc.height = -1;
			bc.isBal = true;
			return bc;
		}

		BalPair lib = isBalanced2(node.left);
		BalPair rib = isBalanced2(node.right);

		int lh = lib.height;
		int rh = rib.height;

		int bal = Math.abs(lh - rh);
		boolean flag = (bal == 0 || bal == 1);
		BalPair ans = new BalPair();
		ans.height = Math.max(lh, rh) + 1;
		ans.isBal = flag;

		return ans;

	}

	public void preorder() {
		preorder(root);
		System.out.println();
	}

	private void preorder(Node node) {
		if (node == null) {
			return;
		}

		System.out.print(node.data + " ");
		preorder(node.left);
		preorder(node.right);

	}

	private class Pair {
		Node node;
		boolean sd;
		boolean ld;
		boolean rd;
	}

	public void preorderI() {
		Stack<Pair> s = new Stack<>();
		Pair rv = new Pair();
		rv.node = root;
		s.add(rv);

		while (!s.isEmpty()) {
			Pair tp = s.peek();

			if (!tp.sd) {

				tp.sd = true;
				System.out.print(tp.node.data + " ");

			} else if (!tp.ld) {

				tp.ld = true;
				Pair np = new Pair();
				np.node = tp.node.left;

				if (np.node != null) {
					s.add(np);
				}

			} else if (!tp.rd) {
				tp.rd = true;
				Pair np = new Pair();
				np.node = tp.node.right;

				if (np.node != null) {
					s.add(np);
				}
			} else {
				s.pop();
			}

		}

	}

	public void postorder() {
		postorder(root);
	}

	private void postorder(Node node) {
		if (node == null) {
			return;
		}

		postorder(node.left);
		postorder(node.right);
		System.out.print(node.data + " ");

	}

	public void inorder() {
		inorder(root);
	}

	private void inorder(Node node) {
		if (node == null) {
			return;
		}

		inorder(node.left);
		System.out.print(node.data + " ");
		inorder(node.right);

	}

	public boolean flipEquivalent(BinaryTree other) {
		return flipEquivalent(this.root, other.root);
	}

	private boolean flipEquivalent(Node node1, Node node2) {
		if (node1 == null && node2 == null) {
			return true;
		}
		if (node1 == null || node2 == null) {
			return false;
		}
		if (node1.data != node2.data) {
			return false;
		}

		boolean noflipl = flipEquivalent(node1.left, node1.left);
		boolean noflipr = flipEquivalent(node1.right, node2.right);

		boolean yesflipl = flipEquivalent(node1.left, node2.right);
		boolean yesflipr = flipEquivalent(node1.right, node2.left);

		return (noflipl && noflipr) || (yesflipl && yesflipr);
	}

	public int maxSumPath() {
		int[] ans = new int[1];
		maxsumpath(root, ans);
		return ans[0];
	}

	private int maxsumpath(Node node, int[] ans) {

		if (node == null) {
			return 0;
		}

		int ls = maxsumpath(node.left, ans);
		int rs = maxsumpath(node.right, ans);

		// agar ls rs <0 hain to add he kyuun krna node mein
		int selfsum = (ls > 0 ? ls : 0) + (rs > 0 ? rs : 0) + node.data;

		if (selfsum > ans[0]) {
			ans[0] = selfsum;
		}

		return Math.max(ls, rs) + node.data;
	}

	public int maxsubtree() {
		int[] ans = new int[1];
		maxsubtree(root, ans);
		return ans[0];
	}

	private int maxsubtree(Node node, int[] ans) {
		if (node == null) {
			return 0;
		}

		int ls = maxsubtree(node.left, ans);
		int rs = maxsubtree(node.right, ans);

		int subtreesum = ls + rs + node.data;

		if (subtreesum > ans[0]) {
			ans[0] = subtreesum;
		}

		return subtreesum;

	}

	public ArrayList<ArrayList<Integer>> levelorder() {
		return levelorder(root);
	}

	private ArrayList<ArrayList<Integer>> levelorder(Node root) {
		LinkedList<Node> qPrim = new LinkedList<>();
		LinkedList<Node> qsec = new LinkedList<>();

		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		qPrim.addLast(root);

		ArrayList<Integer> l1 = new ArrayList<>();
		
		while (!qPrim.isEmpty()) {
			Node rp = qPrim.removeFirst();
			
			l1.add(rp.data);
			if (rp.left != null)
				qsec.addLast(rp.left);
			if (rp.right != null)
				qsec.addLast(rp.right);
			
			if(qPrim.isEmpty()) {
				LinkedList<Node> temp = qPrim;
				qPrim = qsec;
				qsec = temp;
				ans.add(l1);
				l1 = new ArrayList<>();
			}

		}
		return ans;
	}

	/*--------------------------------BST QUES--------------------------------
	 */
	private class BSTPair {
		boolean isBST = true;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;

		Node largestBSTNode;
		int size = 0;
	}

	public boolean isBST() {
		return isBST(root).isBST;
	}

	private BSTPair isBST(Node node) {
		if (node == null) {
			BSTPair bp = new BSTPair();
			return bp;
		}

		BSTPair leftsub = isBST(node.left);
		BSTPair rightsub = isBST(node.right);

		BSTPair ans = new BSTPair();
		if (!leftsub.isBST || !rightsub.isBST) {
			ans.isBST = false;

		} else if (leftsub.max > node.data || rightsub.min < node.data) {
			ans.isBST = false;

		} else {
			ans.isBST = true;

		}
		// instead of 3 ifs
		// ans.isBST = leftsub.isBST && rightsub.isBST && leftsub.max < node.data &&
		// rightsub.min > node.data
		ans.max = Math.max(node.data, Math.max(leftsub.max, rightsub.max));
		ans.min = Math.min(node.data, Math.min(leftsub.min, rightsub.min));
		return ans;

	}

	public void largestBST() {

		BSTPair res = largestBSTinBT(root);
		System.out.println(res.largestBSTNode.data);
		System.out.println(res.size);

	}

	private BSTPair largestBSTinBT(Node node) {

		if (node == null) {
			BSTPair bp = new BSTPair();
			return bp;
		}

		BSTPair leftsub = largestBSTinBT(node.left);
		BSTPair rightsub = largestBSTinBT(node.right);

		BSTPair ans = new BSTPair();
		ans.isBST = leftsub.isBST && rightsub.isBST && leftsub.max < node.data && rightsub.min > node.data;

		ans.max = Math.max(node.data, Math.max(leftsub.max, rightsub.max));
		ans.min = Math.min(node.data, Math.min(leftsub.min, rightsub.min));

		if (ans.isBST) {
			ans.largestBSTNode = node;
			ans.size = leftsub.size + rightsub.size + 1;
		} else {
			if (leftsub.size > rightsub.size) {
				ans.largestBSTNode = leftsub.largestBSTNode;
				ans.size = leftsub.size;
			} else {
				ans.largestBSTNode = rightsub.largestBSTNode;
				ans.size = rightsub.size;
			}
		}

		return ans;
	}

	public void verticalDisplay() {

		HashMap<Integer, ArrayList<VOPair>> map = new HashMap<>();
		verticalDisplay(root, 0, 0, map);

		// sorting wala tamjham

		ArrayList<Integer> keylist = new ArrayList<>(map.keySet());

		Collections.sort(keylist);

		for (int key : keylist) {

			ArrayList<VOPair> pair = map.get(key);

			Collections.sort(pair, new VOComparator());

			System.out.println(pair);
		}

	}

	private class VOComparator implements Comparator<VOPair> {

		@Override
		public int compare(VOPair o1, VOPair o2) {
			// TODO Auto-generated method stub
			return o1.hl - o2.hl;
		}

	}

	private class VOPair {
		int data;
		int vl;
		int hl;

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return this.data + "";
		}


	}

	private void verticalDisplay(Node node, int vLevel, int hLevel, HashMap<Integer, ArrayList<VOPair>> map) {
		if (node == null) {
			return;
		}

		if (!map.containsKey(vLevel)) {
			map.put(vLevel, new ArrayList<VOPair>());
		}
		VOPair np = new VOPair();
		np.data = node.data;
		np.hl = hLevel;
		np.vl = vLevel;
		map.get(vLevel).add(np);

		verticalDisplay(node.left, vLevel - 1, hLevel + 1, map);
		verticalDisplay(node.right, vLevel + 1, hLevel + 1, map);
	}

	public static void roottoleaf(int target) {
		roottoleaf(root, target, "");
	}

	private static void roottoleaf(Node node, int target, String ans) {
		if (node.left == null && node.right == null && target - node.data == 0) {
			System.out.println(ans + node.data);
			return;
		}
		if (node.right == null && node.left == null) {
			return;
		}
		int nodeval = node.data;
		roottoleaf(node.left, target - nodeval, ans + nodeval + " ");
		roottoleaf(node.right, target - nodeval, ans + nodeval + " ");
	}

	public static void main(String args[]) {
		new BinaryTree();
		int target = sc.nextInt();

		BinaryTree.roottoleaf(target);
	}
}
