package GraphsnOverloading;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

import Heaps.HeapGeneric;

public class Graph {

	private class Vertex {
		HashMap<String, Integer> nbrs = new HashMap<>(); // neighbors
	}

	HashMap<String, Vertex> vtces = new HashMap<>();

	public int numVertex() { // vertex is node
		return vtces.size();
	}

	public boolean containsVertex(String vname) {
		return vtces.containsKey(vname);
	}

	public void addVertex(String vname) {

		Vertex vt = new Vertex();

		vtces.put(vname, vt);
	}

	public void removeVertex(String vname) {
		// -----------DIY

		Vertex v1 = vtces.get(vname);

		for (String othervtc : v1.nbrs.keySet()) {
			Vertex reqd = vtces.get(othervtc);
			reqd.nbrs.remove(vname);
		}
		vtces.remove(vname);
	}

	public int numEdges() {
		int sum = 0;
		for (String key : vtces.keySet()) {
			Vertex vtx = vtces.get(key);
			sum += vtx.nbrs.size();
		}

		return sum / 2;
	}

	public boolean containsEdge(String vname1, String vname2) {

		Vertex v1 = vtces.get(vname1);
		Vertex v2 = vtces.get(vname2);

		if (v1 == null || v2 == null || !v1.nbrs.containsKey(vname2)) {
			return false;
		}

		return true;
	}

	public void addEdge(String vname1, String vname2, int cost) {
		Vertex v1 = vtces.get(vname1);
		Vertex v2 = vtces.get(vname2);

		if (v1 == null || v2 == null || v1.nbrs.containsKey(vname2)) {
			return;
		}

		v1.nbrs.put(vname2, cost);
		v2.nbrs.put(vname1, cost);
	}

	public void removeEdge(String vname1, String vname2) {
		Vertex v1 = vtces.get(vname1);
		Vertex v2 = vtces.get(vname2);

		if (v1 == null || v2 == null || !v1.nbrs.containsKey(vname2)) {
			return;
		}

		v1.nbrs.remove(vname2);
		v2.nbrs.remove(vname1);
	}

	public void display() {
		System.out.println("-----------------------");

		for (String key : vtces.keySet()) {
			Vertex v1 = vtces.get(key);
			System.out.println(key + " -> " + v1.nbrs);
		}

		System.out.println("-----------------------");
	}

	@Override
	public String toString() {

		String str = "";
		str += "-----------------------\n";

		for (String key : vtces.keySet()) {
			Vertex v1 = vtces.get(key);
			str += key + " -> " + v1.nbrs + "\n";
		}

		str += "-----------------------";

		return str;
	}

	public boolean hasPath(String src, String dst, HashSet<String> processed) {
		processed.add(src);
		if (containsEdge(src, dst))
			return true;

		Vertex v1 = vtces.get(src);
		for (String inter : v1.nbrs.keySet()) {
			if (!processed.contains(inter) && hasPath(inter, dst, processed)) {
				return true;
			}
		}

		return false;

	}

	public void printAllPaths(String src, String dst) {
		HashSet<String> processed = new HashSet<>();
		printAllPaths(src, dst, processed, src);
	}

	public void printAllPaths(String src, String dst, HashSet<String> processed, String ans) {

		if (src.equals(dst)) {
			System.out.println(ans);
			return;
		}

		Vertex v1 = vtces.get(src);
		processed.add(src);
		for (String inter : v1.nbrs.keySet()) {

			if (!processed.contains(inter)) {
				printAllPaths(inter, dst, processed, ans + "->" + inter);
			}

		}
		processed.remove(src);// backtracking. undo.

	}

	private class Pair {
		String name;
		String psf; // path so far. for bfs.
		String color; // for isBipartite
	}

	public boolean BFS(String src, String dest) { // guarantees shortest path
		HashSet<String> processed = new HashSet<>();

		LinkedList<Pair> que = new LinkedList<>();

		// make pair of src and put in queue
		Pair sp = new Pair();
		sp.name = src;
		sp.psf = src;

		que.addLast(sp);

		// work till q empty
		while (!que.isEmpty()) {

			// remove pair from q

			Pair rp = que.removeFirst();

			if (processed.contains(rp.name))
				continue;

			// drect edge from src to dest

			if (containsEdge(rp.name, dest)) {
				System.out.println(rp.psf + "->" + dest);
				return true;
			}

			processed.add(rp.name);

			// neighbors

			for (String nbr : vtces.get(rp.name).nbrs.keySet()) {
				if (!processed.contains(nbr)) {
					Pair np = new Pair();
					np.name = nbr;
					np.psf = rp.psf + "->" + np.name;
					que.addLast(np);
				}
			}

		}

		return false;
	}

	public boolean DFS(String src, String dest) {
		HashSet<String> processed = new HashSet<>();

		LinkedList<Pair> stack = new LinkedList<>();

		// make pair of src and put in queue
		Pair sp = new Pair();
		sp.name = src;
		sp.psf = src;

		stack.addFirst(sp);

		// work till q empty
		while (!stack.isEmpty()) {

			// remove pair from q

			Pair rp = stack.removeFirst();

			if (processed.contains(rp.name))
				continue;

			// drect edge from src to dest

			if (containsEdge(rp.name, dest)) {
				System.out.println(rp.psf + "->" + dest);
				return true;
			}

			processed.add(rp.name);

			// neighbors

			for (String nbr : vtces.get(rp.name).nbrs.keySet()) {
				if (!processed.contains(nbr)) {
					Pair np = new Pair();
					np.name = nbr;
					np.psf = rp.psf + "->" + np.name;
					stack.addFirst(np);
				}
			}

		}

		return false;
	}

	public void bft() {

		HashMap<String, Boolean> processed = new HashMap<>();

		LinkedList<Pair> queue = new LinkedList<>();

		for (String key : vtces.keySet()) {

			if (processed.containsKey(key)) {
				continue;
			}

			// make the pair of src and put in queue(indicates no of components created. A
			// fully connected graph has one component)
			Pair sp = new Pair();
			sp.name = key;
			sp.psf = key;

			queue.addLast(sp);

			// work till queue is not empty
			while (!queue.isEmpty()) {

				// remove the pair from queue
				Pair rp = queue.removeFirst();

				// ignore the second C-----indicates graph has cycle
				if (processed.containsKey(rp.name)) {
					continue;
				}

				System.out.println(rp.name + " via " + rp.psf);

				// processed
				processed.put(rp.name, true);

				// nbrs
				for (String nbr : vtces.get(rp.name).nbrs.keySet()) {

					// work only for unprocessed nbrs
					if (!processed.containsKey(nbr)) {
						Pair np = new Pair();
						np.name = nbr;
						np.psf = rp.psf + nbr;

						queue.addLast(np);
					}
				}

			}

		}

	}

	public void dft() {

		HashMap<String, Boolean> processed = new HashMap<>();

		LinkedList<Pair> stack = new LinkedList<>();

		for (String key : vtces.keySet()) {

			if (processed.containsKey(key)) {
				continue;
			}

			// make the pair of src and put in queue
			Pair sp = new Pair();
			sp.name = key;
			sp.psf = key;

			stack.addFirst(sp);

			// work till queue is not empty
			while (!stack.isEmpty()) {

				// remove the pair from queue
				Pair rp = stack.removeFirst();

				// ignore the second C
				if (processed.containsKey(rp.name)) {
					continue;
				}

				System.out.println(rp.name + " via " + rp.psf);

				// processed
				processed.put(rp.name, true);

				// nbrs
				for (String nbr : vtces.get(rp.name).nbrs.keySet()) {

					// work only for unprocessed nbrs
					if (!processed.containsKey(nbr)) {
						Pair np = new Pair();
						np.name = nbr;
						np.psf = rp.psf + nbr;

						stack.addFirst(np);
					}
				}

			}

		}

	}

	// ----------------------ques---------------------------------------------

	public boolean isConnected() { // check if full graph vrtces are connected to each other

		HashMap<String, Boolean> processed = new HashMap<>();

		LinkedList<Pair> queue = new LinkedList<>();
		int componentcount = 0;

		for (String key : vtces.keySet()) {

			if (processed.containsKey(key)) {
				continue;
			}

			// make the pair of src and put in queue(indicates no of components created. A
			// fully connected graph has one component)
			Pair sp = new Pair();
			sp.name = key;
			sp.psf = key;
			componentcount++;

			queue.addLast(sp);

			// work till queue is not empty
			while (!queue.isEmpty()) {

				// remove the pair from queue
				Pair rp = queue.removeFirst();

				// ignore the second C-----indicates graph has cycle
				if (processed.containsKey(rp.name)) {
					continue;
				}

				// System.out.println(rp.name + " via " + rp.psf);

				// processed
				processed.put(rp.name, true);

				// nbrs
				for (String nbr : vtces.get(rp.name).nbrs.keySet()) {

					// work only for unprocessed nbrs
					if (!processed.containsKey(nbr)) {
						Pair np = new Pair();
						np.name = nbr;
						np.psf = rp.psf + nbr;

						queue.addLast(np);
					}
				}

			}

		}
		if (componentcount > 1)
			return false;
		else
			return true;

	}

	// --------------------

	public boolean isCyclic() { // check if graph contains a cycle

		HashMap<String, Boolean> processed = new HashMap<>();

		LinkedList<Pair> queue = new LinkedList<>();
		int componentcount = 0;

		for (String key : vtces.keySet()) {

			if (processed.containsKey(key)) {
				continue;
			}

			// make the pair of src and put in queue(indicates no of components created. A
			// fully connected graph has one component)
			Pair sp = new Pair();
			sp.name = key;
			sp.psf = key;

			queue.addLast(sp);

			// work till queue is not empty
			while (!queue.isEmpty()) {

				// remove the pair from queue
				Pair rp = queue.removeFirst();

				// ignore the second C-----indicates graph has cycle
				if (processed.containsKey(rp.name)) {
					componentcount++; // or direct return true
					continue;
				}

				// System.out.println(rp.name + " via " + rp.psf);

				// processed
				processed.put(rp.name, true);

				// nbrs
				for (String nbr : vtces.get(rp.name).nbrs.keySet()) {

					// work only for unprocessed nbrs
					if (!processed.containsKey(nbr)) {
						Pair np = new Pair();
						np.name = nbr;
						np.psf = rp.psf + nbr;

						queue.addLast(np);
					}
				}

			}

		}
		if (componentcount >= 1)
			return true;
		else
			return false;

	}

	// -------------------------------------------

	public boolean isTree() { // check if graph is a tree
		// return !isCyclic() && isConnected()
		HashMap<String, Boolean> processed = new HashMap<>();

		LinkedList<Pair> queue = new LinkedList<>();
		int componentcount = 0;
		int cyclecount = 0;
		for (String key : vtces.keySet()) {

			if (processed.containsKey(key)) {
				continue;
			}

			// make the pair of src and put in queue(indicates no of components created. A
			// fully connected graph has one component)
			Pair sp = new Pair();
			sp.name = key;
			sp.psf = key;
			componentcount++;

			queue.addLast(sp);

			// work till queue is not empty
			while (!queue.isEmpty()) {

				// remove the pair from queue
				Pair rp = queue.removeFirst();

				// ignore the second C-----indicates graph has cycle
				if (processed.containsKey(rp.name)) {
					cyclecount++;
					continue;
				}

				// System.out.println(rp.name + " via " + rp.psf);

				// processed
				processed.put(rp.name, true);

				// nbrs
				for (String nbr : vtces.get(rp.name).nbrs.keySet()) {

					// work only for unprocessed nbrs
					if (!processed.containsKey(nbr)) {
						Pair np = new Pair();
						np.name = nbr;
						np.psf = rp.psf + nbr;

						queue.addLast(np);
					}
				}

			}

		}
		if (cyclecount >= 1 && componentcount <= 1)
			return false;
		else
			return true;

	}

	// ----------------------------------

	public ArrayList<ArrayList<String>> getCC() { // check if full graph vrtces are connected to each other

		HashMap<String, Boolean> processed = new HashMap<>();

		LinkedList<Pair> queue = new LinkedList<>();

		ArrayList<ArrayList<String>> list = new ArrayList<>();
		for (String key : vtces.keySet()) {

			if (processed.containsKey(key)) {
				continue;
			}
			ArrayList<String> ml = new ArrayList<>();
			// make the pair of src and put in queue(indicates no of components created. A
			// fully connected graph has one component)
			Pair sp = new Pair();
			sp.name = key;
			sp.psf = key;

			queue.addLast(sp);

			// work till queue is not empty
			while (!queue.isEmpty()) {

				// remove the pair from queue
				Pair rp = queue.removeFirst();

				// ignore the second C-----indicates graph has cycle
				if (processed.containsKey(rp.name)) {
					continue;
				}

				// System.out.println(rp.name + " via " + rp.psf);

				// processed
				processed.put(rp.name, true);
				ml.add(rp.name);
				// nbrs
				for (String nbr : vtces.get(rp.name).nbrs.keySet()) {

					// work only for unprocessed nbrs
					if (!processed.containsKey(nbr)) {
						Pair np = new Pair();
						np.name = nbr;
						np.psf = rp.psf + nbr;

						queue.addLast(np);
					}
				}

			}
			list.add(ml);
		}
		return list;

	}

	public boolean isBipartite() { // 2 colorable
		HashMap<String, String> processed = new HashMap<>();

		LinkedList<Pair> queue = new LinkedList<>();

		for (String key : vtces.keySet()) {

			if (processed.containsKey(key)) {

				continue;
			}

			// make the pair of src and put in queue(indicates no of components created. A
			// fully connected graph has one component)
			Pair sp = new Pair();
			sp.name = key;
			sp.psf = key;
			sp.color = "r";

			queue.addLast(sp);

			// work till queue is not empty
			while (!queue.isEmpty()) {

				// remove the pair from queue
				Pair rp = queue.removeFirst();

				// ignore the second C-----indicates graph has cycle
				if (processed.containsKey(rp.name)) {
					String c1 = processed.get(rp.name);
					String c2 = rp.color;

					if (!c1.equals(c2))
						return false;

					continue;
				}

				// System.out.println(rp.name + " via " + rp.psf);

				// processed
				processed.put(rp.name, rp.color);

				// nbrs
				for (String nbr : vtces.get(rp.name).nbrs.keySet()) {

					// work only for unprocessed nbrs
					if (!processed.containsKey(nbr)) {
						Pair np = new Pair();
						np.name = nbr;
						np.psf = rp.psf + nbr;
						np.color = rp.color.equals("r") ? "g" : "r";
						queue.addLast(np);
					}
				}

			}

		}

		return true;

	}

	private class PrimPair implements Comparable<PrimPair> {
		String vname;
		String acqvtx;
		int cost = Integer.MAX_VALUE;

		@Override
		public int compareTo(PrimPair o) {
			// TODO Auto-generated method stub
			return o.cost - this.cost;
		}
	}

	public Graph prims() {

		Graph mst = new Graph();

		HeapGeneric<PrimPair> heap = new HeapGeneric<>();
		HashMap<String, PrimPair> map = new HashMap<>();
		// put vtces in heap and hashmap

		for (String key : vtces.keySet()) {
			PrimPair sp = new PrimPair();
			sp.vname = key;
			heap.add(sp);
			map.put(key, sp);
		}

		// work till heap not empty
		
		

		while (!heap.isEmpty()) {
			PrimPair rp = heap.remove();
			map.remove(rp.vname);

			// add in mst
			if (rp.acqvtx == null) {
				mst.addVertex(rp.vname);

			} else {
				mst.addVertex(rp.vname);
				mst.addEdge(rp.vname, rp.acqvtx, rp.cost);

			}
			// work for neighbours

			for (String nbr : vtces.get(rp.vname).nbrs.keySet()) {
				// update only those nbrs whih are present in heap
				if (map.containsKey(nbr)) {

					PrimPair nbrpair = map.get(nbr);

					int oldcost = nbrpair.cost;
					int newcost = vtces.get(rp.vname).nbrs.get(nbr);
					if (newcost < oldcost) {
						// update heap priority
						nbrpair.cost = newcost;
						nbrpair.acqvtx = rp.vname;
						heap.updatePriority(nbrpair);
					}
				}
			}

		}

		return mst;
	}

}
