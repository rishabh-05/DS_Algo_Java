package LinkedLists;

public class ClientLL {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		LinkedList ll = new LinkedList();
		
		ll.addlast(10);
		ll.addlast(20);
		ll.addlast(30);
		ll.addlast(40);
		ll.addlast(50);
		ll.addlast(60);
		ll.addlast(70);
		ll.addlast(80);
		//ll.addlast(90);
		
		
		ll.display();
		
//		ll.RecReversePointer();
//		ll.display();
//		ll.addAt(55, 3);
//		ll.display();
//		System.out.println(ll.getAt(3));
//		System.out.println(ll.getFirst());
//		System.out.println(ll.getLast());
//		System.out.println(ll.removeFirst());
//		System.out.println(ll.removelast());
//		//ll.display();
//		System.out.println(ll.removeAt(2));
//		ll.display();
//		ll.itReverseData();
//		ll.display();
		
		//ll.RecRevData();
		//ll.display();
//		ll.fold();
//		ll.display();
//		ll.reverseDRHM();
//		ll.display();
		
//		System.out.println(ll.midnode());
		System.out.println(ll.kthfromlast(3));
		ll.kreverse(3);
		ll.display();
		
		//ll.intersection();
		//ll.createDummyListLoop();
		//ll.display();
		//ll.detectRemoveLoop();
//		ll.createUnique();
//		
//		ll.display();
	}

}
