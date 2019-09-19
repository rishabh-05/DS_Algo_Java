package Heaps;

import java.util.ArrayList;

public class MergeKSortedListsinNLOGKComplexity {

	
	private static class Pair implements Comparable<Pair>{

		int data;
		int listno;
		int idx;
		@Override
		public int compareTo(Pair o) {
			// TODO Auto-generated method stub
			return o.data - this.data;
		} 

		
	}
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
		
		
		mergeKsorted(lists);
		int k = 4;
		kLargest(new int[] {20, 100, 5, 2, 30, 40, 4}, k);

	}
	public static void mergeKsorted(ArrayList<ArrayList<Integer>> lists) {
		int k = lists.size();
		HeapGeneric<Pair> heap = new HeapGeneric<>();
		int i = 0;
		for(; i <k; i++) {
			Pair np = new Pair();
			
			np.data = lists.get(i).get(0);
			np.idx = 0;
			np.listno = i;
			heap.add(np);
			
		}
		
		//remove and traverse
		
		while(!heap.isEmpty()) {
			
			Pair rp = heap.remove();
			System.out.print(rp.data + ", ");
			
			rp.idx++;
			
			if(rp.idx < lists.get(rp.listno).size()) {
				rp.data = lists.get(rp.listno).get(rp.idx);
				heap.add(rp);
			}
			
			
			
		}
		
	}
	
	public static void kLargest(int[] arr, int k) {
		
		Heap hp = new Heap();
		int i = 0;
		for(; i < k; i++) {
			hp.add(arr[i]);
		}
		for(; i < arr.length; i++) {
			
			if(arr[i] > hp.get()) {
				hp.remove();
				hp.add(arr[i]);
			}
		}
		System.out.println();
		hp.display();
	}

}
