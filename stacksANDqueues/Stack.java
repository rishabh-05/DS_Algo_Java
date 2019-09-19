package stacksANDqueues;

public class Stack {
	
	protected int[] data;
	protected int top;



	public Stack()  {

		this.data = new int[5];
		this.top=-1;
	}

	public Stack(int capacity) throws Exception {
		if (capacity < 1) {
			throw new Exception("Invalid Capacity.");
		}

		this.data = new int[capacity];
		this.top = -1;
	}

	public int size() {
		return this.top + 1;
	}

	public boolean isEmpty()
	{
		return this.size()==0;
	}
	public boolean isFull()
	{
		return this.size()==this.data.length;
	}
	
	
	public void push(int value)throws Exception
	{
		
		if(this.data.length== this.size())
			throw new Exception("Overflow Error. Stack full.");
		
		this.top++;
		this.data[this.top] = value;
	}

	public int pop() throws Exception
	{
		if(this.size()==0)
			throw new Exception("Underflow Error. Stack Already Empty.");
		
		int rv = this.data[this.top];
		this.data[this.top] = 0;
		this.top--;
		return rv;
	}

	public int peek() throws Exception
	{
		if(this.size()==0)
			throw new Exception("Empty Stack.");
		int rv = this.data[this.top];
		return rv;
	}

	public void display()
	{
		for(int i = this.top; i>=0; i--)
		{
			System.out.print(this.data[i] + ", ");
			
		}
		System.out.println("END.");
	}

}
