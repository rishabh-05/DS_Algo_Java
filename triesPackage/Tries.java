package triesPackage;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class Tries {
	private class Node {
		char data;
		boolean isTerminal;
		HashMap<Character, Node> table = new HashMap<>();

		Node(char data) {
			this.data = data;
		}
	}

	private Node root;

	public Tries() {
		root = new Node('*');
	}

	public void addWord(String word) {
		addWord(root, word);
	}

	private void addWord(Node node, String word) {
		if (word.length() == 0) {
			node.isTerminal = true;
			return;
		}

		char cc = word.charAt(0);
		String ros = word.substring(1);
		if (node.table.containsKey(cc)) {
			addWord(node.table.get(cc), ros);
		} else {
			Node nn = new Node(cc);
			node.table.put(cc, nn);
			addWord(nn, ros);
		}

	}

	public boolean searchWord(String word) {
		return searchWord(root, word);
	}

	private boolean searchWord(Node node, String word) {

		if (word.length() == 0) {
			return node.isTerminal;

		}

		char cc = word.charAt(0);
		String ros = word.substring(1);
		if (node.table.containsKey(cc)) {
			return searchWord(node.table.get(cc), ros);
		} else {
			return false;
		}

	}

	public void display() {
		display(root, "");
	}

	private void display(Node node, String ans) {
		if (node.isTerminal) {
			System.out.println(ans);

		}

		for (char cc : node.table.keySet()) {
			display(node.table.get(cc), ans + cc);
		}

	}

	public void removeWord(String word) {
		remove(root, word);
	}

	private void remove(Node node, String word) {
		if (word.length() == 0) {
			node.isTerminal = false;
			return;
		}
		char cc = word.charAt(0);
		String ros = word.substring(1);
		Node ch = node.table.get(cc);
		//

		remove(ch, ros);
		// remove nodes from memory
		if (!ch.isTerminal && ch.table.size() == 0) {
			node.table.remove(cc);
		}

	}
	
	public boolean startsWith(String word) {
		return startsWith(root, word);
	}

	private boolean startsWith(Node node, String word) {

		if (word.length() == 0) {
			return true;
		}

		char ch = word.charAt(0);
		String row = word.substring(1);

		if (node.table.containsKey(ch)) {
			return startsWith(node.table.get(ch), row);
		} else {
			return false;
		}

	}

}
