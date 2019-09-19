package Segmenttrees;

public class ClientST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {3, 8, 7, 6, -2, -8, 4, 9};
		SegmentTree st = new SegmentTree(arr, new STreeMin());
		st.display();
		
		System.out.println(st.query(2, 6));
		
		st.update(4, 10);
		st.display();
		System.out.println(st.query(2, 6));

	}

}
