package Recursion;

public class RecDemo {

	public static void main(String[] args) {
		//principal of mathematical induction
		//1. Base case
		//2. Assumption
		//3. Work
		
		//countreverse(5);
		countright(5);
	}
	
	public static void countreverse(int n) {
		
		if(n==0) {
			return;
		}
		System.out.print(n + " ");
		countreverse(n-1);
		
	}
	
	public static void countright(int n) {
		if(n==0) {
			return;
		}
		countright(n-1);
		System.out.print(n + " ");
//		System.out.println("--------------------");
//		countright(--n);
//		System.out.print(n + " ");
//		
	}

}
