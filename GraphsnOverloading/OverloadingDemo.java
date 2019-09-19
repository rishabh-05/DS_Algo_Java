package GraphsnOverloading;

public class OverloadingDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(sum(3, 4, 8));
		//System.out.println(sum(3, 4));      gives error. unresolved compilation. Overloading not on return type basis.

	}
	
	public static void sum(int a, int b) {
		System.out.println(a+b);
	}
	
	public static int sum(int a, int b, int... arg) {
		int sum = 0;
		for(int val : arg) {
			sum += val;
		}
		
		return sum*a*b;
	}

}
