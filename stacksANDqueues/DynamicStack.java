package stacksANDqueues;

public class DynamicStack extends Stack {

	public DynamicStack() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public DynamicStack(int capacity) throws Exception{
		super();
	}

	@Override
	public void push(int item) throws Exception {

		if (isFull()) {
			// create new array of 2x size
			int[] na = new int[2 * data.length];

			// copy all elements from old array to new
			for (int i = 0; i < data.length; i++) {
				na[i] = data[i];
			}

			// change reference
			data = na;
		}
		// push the item using parent push
		super.push(item);
	}

}
