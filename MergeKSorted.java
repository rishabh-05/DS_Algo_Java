import java.util.*;

import Heaps.HeapGeneric;

public class MergeKSorted {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<ArrayList<Integer>> lists = new ArrayList<>();

		lists.add(new ArrayList<>());
		lists.add(new ArrayList<>());
		lists.add(new ArrayList<>());
		lists.add(new ArrayList<>());

		lists.get(0).add(1);
		lists.get(0).add(8);
		lists.get(0).add(9);
		lists.get(0).add(10);
		lists.get(0).add(12);

		lists.get(1).add(5);
		lists.get(1).add(15);
		lists.get(1).add(20);

		lists.get(2).add(7);
		lists.get(2).add(13);
		lists.get(2).add(25);
		lists.get(2).add(30);

		lists.get(3).add(2);
		lists.get(3).add(3);

		System.out.println(mergeKsorted(lists));

	}

	private static class Pair implements Comparable<Pair> {
		int data;
		int idx;
		int listid;

		@Override
		public int compareTo(Pair o) {
			// TODO Auto-generated method stub
			return o.data - this.data;
		}
	}

	public static ArrayList<Integer> mergeKsorted(ArrayList<ArrayList<Integer>> lists) {
		ArrayList<Integer> ans = new ArrayList<>();

		int k = lists.size();
		HeapGeneric<Pair> heap = new HeapGeneric<>();

		for (int i = 0; i < k; i++) {
			Pair np = new Pair();
			np.data = lists.get(i).get(0);
			np.idx = 0;
			np.listid = i;
			heap.add(np);
		}

		while (!heap.isEmpty()) {

			Pair rp = heap.remove();

			ans.add(rp.data);

			rp.idx = rp.idx + 1;
			if (rp.idx < lists.get(rp.listid).size()) {
				rp.data = lists.get(rp.listid).get(rp.idx);
				heap.add(rp);
			}
		}

		return ans;
	}

}
