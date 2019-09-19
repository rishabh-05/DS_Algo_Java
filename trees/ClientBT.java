package trees;


public class ClientBT {

	public static void main(String[] args) {
		// 10 true 20 true 40 false false true 50 false false true 30 false true 60 false false
//		BinaryTree bt = new BinaryTree();
//		bt.display();
//		int[] pre = {-10, 2, 4, 5, 7, 8, 3, 6};
//		int[] in = {4, 2, 7, 5, 8, -10, 6, 3};
//		BinaryTree bt1 = new BinaryTree(pre, in);
//		
//		int[] pre1 = {-10, 3, 6, 2, 4, 5, 8, 7};
//		int[] in1 = {3, 6, -10, 4, 2, 8, 5, 7};
//		BinaryTree bt2 = new BinaryTree(pre1, in1);
//		bt1.display();
//		System.out.println("----------------");
//		bt2.display();
//		System.out.println("----------------");
//		System.out.println(bt.size());
//		System.out.println(bt.max());
//		System.out.println(bt.find(20));
//		System.out.println(bt.find(40));
//		System.out.println(bt.find(100));
//		System.out.println(bt.find(60));
//		System.out.println(bt.height());
//		System.out.println(bt.diameter());
//		System.out.println(bt.Diameter2());
//		System.out.println(bt.isBalanced());
//		System.out.println(bt.isBalanced2());
		//bt1.preorder();
//		bt.preorderI();
		
		//System.out.println(bt1.flipEquivalent(bt2));
	//	System.out.println(bt1.maxSumPath());
		//System.out.println(bt2.maxsubtree());
//		int[] bst = {10, 20, 30, 40, 50, 60, 70 };
//		BinarySearchTree btr = new BinarySearchTree(bst);
//		System.out.println("-----------------");
//		btr.display();
//		btr.add(35);
//		btr.add(34);
//		System.out.println("-----------------");
//		btr.display();
//		btr.remove(20);
//		System.out.println(btr.max());
//		System.out.println(btr.find(20));
//		System.out.println(btr.find(10));
//		System.out.println(btr.find(200));
//		System.out.println("-----------------");
//		btr.printInRange(40, 52);
//		System.out.println("\n-----------------");
//		btr.replacewithsumlarger();
//		System.out.println("~~~~~~~~~~~~~~~~");
//		btr.display();
		
		int[] in = {40, 110, 80, 90, 20, 50, 130, 10, 60, 30, 70};
		int[] pre = {10, 20, 40, 80, 110, 90, 50, 130, 30, 60, 70};
		BinaryTree bt = new BinaryTree(pre, in);
		bt.display();
		//bt.verticalDisplay();
		System.out.println(bt.levelorder());
	}

}
