import java.util.*;

public class GraphRevision {

	class Vertex {
		HashMap<String, Integer> nbrs = new HashMap<>();
	}

	HashMap<String, Vertex> map = new HashMap<>();

	public int numVertices() {
		return map.size();
	}

	public boolean containVertex(String vname) {
		return map.containsKey(vname);
	}

	public void addVertex(String vname) {
		Vertex nbrset = new Vertex();
		map.put(vname, nbrset);
	}

	public void removeVertex(String vname) {
		Vertex nbrinfo = map.get(vname);

		for (String node : nbrinfo.nbrs.keySet()) {
			Vertex n = map.get(node);
			n.nbrs.remove(vname);
		}
		map.remove(vname);
	}

	public int numEdges() {
		int count = 0;

		for (String nodes : map.keySet()) {
			Vertex n = map.get(nodes);
			count = count + n.nbrs.size();
		}

		return count / 2;
	}

	public boolean containsEdge(String vname1, String vname2) {

		Vertex v1 = map.get(vname1);
		Vertex v2 = map.get(vname2);

		boolean v2inv1 = v1.nbrs.containsKey(vname2);
		boolean v1inv2 = v2.nbrs.containsKey(vname1);

		return v2inv1 && v1inv2;

	}

	public void addEdge(String vname1, String vname2, int cost) {
		// if cost update, remove if. do all the operations
		if (!containsEdge(vname1, vname2)) {

			Vertex v1 = map.get(vname1);
			Vertex v2 = map.get(vname2);

			v1.nbrs.put(vname2, cost);
			v2.nbrs.put(vname1, cost);

		}

	}

	public void removeEdge(String vname1, String vname2) {

		if (containsEdge(vname1, vname2)) {

			Vertex v1 = map.get(vname1);
			Vertex v2 = map.get(vname2);

			v1.nbrs.remove(vname2);
			v2.nbrs.remove(vname1);

		}

	}

	public void display() {

		System.out.println("--------------------");
		for (String node : map.keySet()) {
			Vertex v1 = map.get(node);
			System.out.println(node + " --> " + v1.nbrs);

		}
		System.out.println("--------------------");
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String str = "";
		str += "-----------------\n";
		for (String node : map.keySet()) {
			Vertex v1 = map.get(node);
			str += node + " --> " + v1.nbrs + "\n";

		}
		str += "-----------------\n";
		return str;
	}

	// ---------------GRAPH CREATED-------------------------------
	// --------------PROBLEMS---------------------------------------

	// --1. hasPath from one to other vertex

	// visited to prevent infinite recursion

	static HashSet<String> vis = new HashSet<>();

	public boolean hasPath(String src, String dest) {
		vis.add(src);
		if (map.get(src).nbrs.containsKey(dest))
			return true;

		boolean ans = false;
		for (String nbr : map.get(src).nbrs.keySet()) {
			if (!vis.contains(nbr))
				ans = hasPath(nbr, dest);
		}

		return ans;
	}

	// 2 Print All paths

	public void printPaths(String src, String dest) {
		HashSet<String> visi = new HashSet<>();
		printPaths(src, dest, visi, src);
	}

	private void printPaths(String src, String dest, HashSet<String> visi, String ans) {
		// TODO Auto-generated method stub

		if (src.equals(dest)) {
			System.out.println(ans);
			return;
		}
		visi.add(src);
		for (String nbr : map.get(src).nbrs.keySet()) {
			if (!visi.contains(nbr))
				printPaths(nbr, dest, visi, ans + "->" + nbr);
		}

		visi.remove(src);

	}

	// ------BFS and DFS----------

	class Pair {
		String vrt;
		String psf; // path so far upto that node(vertices)

		// is pair ki bnaaenge queue
	}

	public boolean BFS(String src, String dest) {

		HashSet<String> vis = new HashSet<>();
		Queue<Pair> que = new LinkedList<>();

		Pair np = new Pair();
		np.vrt = src;
		np.psf = src;

		que.add(np);

		while (!que.isEmpty()) {

			Pair rp = que.remove();

			if (vis.contains(rp.vrt))
				continue;

			vis.add(rp.vrt);

			if (containsEdge(rp.vrt, dest)) {
				System.out.println(rp.psf + dest);
				return true;
			}

			for (String node : map.get(rp.vrt).nbrs.keySet()) {

				if (!vis.contains(node)) {
					Pair cp = new Pair();

					cp.vrt = node;
					cp.psf = rp.psf + node;

					que.add(cp);
				}

			}
		}

		return false;
	}

	public boolean DFS(String src, String dst) {
		// using stacks

		HashSet<String> vis = new HashSet<>();
		LinkedList<Pair> stk = new LinkedList<>();

		Pair np = new Pair();
		np.vrt = src;
		np.psf = src;

		stk.addFirst(np);

		while (!stk.isEmpty()) {

			Pair rp = stk.removeFirst();

			if (vis.contains(rp.vrt))
				continue;

			vis.add(rp.vrt);

			if (containsEdge(rp.vrt, dst)) {
				System.out.println(rp.psf + dst);
				return true;
			}

			for (String node : map.get(rp.vrt).nbrs.keySet()) {
				if (!vis.contains(node)) {

					Pair cp = new Pair();
					cp.vrt = node;
					cp.psf = rp.psf + node;

					stk.addFirst(cp);

				}

			}
		}

		return false;
	}

	public void BFT() {

		HashSet<String> vis = new HashSet<>();
		Queue<Pair> que = new LinkedList<>();

		ArrayList<String> keys = new ArrayList<>(map.keySet());
		for (String key : keys) {
			Pair np = new Pair();
			np.vrt = key;
			np.psf = key;

			que.add(np);

			while (!que.isEmpty()) {

				Pair rp = que.remove();

				if (vis.contains(rp.vrt))
					continue;

				vis.add(rp.vrt);

				System.out.println(rp.vrt + " via " + rp.psf);

				for (String node : map.get(rp.vrt).nbrs.keySet()) {

					if (!vis.contains(node)) {
						Pair cp = new Pair();

						cp.vrt = node;
						cp.psf = rp.psf + node;

						que.add(cp);
					}

				}
			}

		}
	}

	public void DFT() {
		// using stacks

		HashSet<String> vis = new HashSet<>();
		LinkedList<Pair> stk = new LinkedList<>();

		ArrayList<String> keys = new ArrayList<>(map.keySet());
		for (String key : keys) {
			Pair np = new Pair();
			np.vrt = key;
			np.psf = key;

			stk.addFirst(np);

			while (!stk.isEmpty()) {

				Pair rp = stk.removeFirst();

				if (vis.contains(rp.vrt))
					continue;

				vis.add(rp.vrt);

				System.out.println(rp.vrt + " via " + rp.psf);

				for (String node : map.get(rp.vrt).nbrs.keySet()) {
					if (!vis.contains(node)) {

						Pair cp = new Pair();
						cp.vrt = node;
						cp.psf = rp.psf + node;

						stk.addFirst(cp);

					}

				}
			}
			
		}

	}

}
