package stacksANDqueues;

public class ClientStack {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		DynamicStack s = new DynamicStack();
		
		s.push(5);
		s.push(51);
		s.push(52);
		s.push(53);
		s.push(54);
		s.push(55);
		s.push(56);
		
		s.display();
		
		
		System.out.println(s.isEmpty());
		System.out.println(s.peek());
		System.out.println(s.size());
		
		
	}

}
