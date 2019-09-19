package stacksANDqueues;

public class DynamicQueue extends Queue{

	public DynamicQueue() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void enqueue(int item) throws Exception {
		
		if(isFull()) {
			int na[] = new int[2*data.length];
			
			int i = 0;
			while(i<data.length) {
				na[i] = data[(this.front+i)%this.data.length];
				i++;
			}
			
			front = 0;	
			
			
			data = na;
		}
		
		super.enqueue(item);
	}
	
	

}
