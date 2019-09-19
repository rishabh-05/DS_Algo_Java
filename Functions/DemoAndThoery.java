package Functions;

public class DemoAndThoery {
	static int i = 0;			//global variable: doesn't form in stack. kyuuunki agar
								//stack khtm, variable khtm.
								//isilie, global variable in heap memory
	static int val = 20; 

	public static void main(String[] args) {

		System.out.println(++i + ".) Hello, going to add"); // stack after add called
		add(); 												// |add |
															// |main|
		System.out.println(++i + ".) Bye, back from add, going to sub");
		sub();
		System.out.println(++i + ".) Back from sub");// stack info after sub call
	} 											   	// |sub |
													// |main|

	public static void add() {
		System.out.println(++i + ".) In add function");
		int a = 3;
		int b = 4;
		System.out.println(a + b);
		System.out.println(++i + ".) going to sub from add");
		sub(); 												// stack info after this sub call
		System.out.println(++i + ".) Back from sub fun, into add");

	} 														// |sub |
															// |add |

	public static void sub() { 								// |main|
		System.out.println(++i + ".) In sub function");
		int a = 5;
		int b = 3;
		System.out.println(a - b);
		int val = 100;				//local variable val
		System.out.println("local "+val); 	//is conflict mein, local variable win. print: 100, not 20
		System.out.println("Global "+DemoAndThoery.val);//global variable gets printed
	}
	
	//overloading eg:

		public static void add(int a, int b) {		//overloaded function, different no./type of parameters
			System.out.println(a+b);
		}
		/* Function overloading does not take place on the basis of return type.
		 * Its obvious
		 * Say, you do
		 * System.out.println((addfun(a, b));
		 * addfun(int a, int b) could have been of int return type or void return type
		 */
		
		/*
		 * return:  control goes back to that statement which called that function
		 */


}



