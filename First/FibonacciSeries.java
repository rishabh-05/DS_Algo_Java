package First;

import java.util.Scanner;

public class FibonacciSeries {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter no of elements");
		int n = sc.nextInt();
		sc.close();
		int a = 0;
		int b = 1;
		
		
		for(int i = 1; i<=n+1; i++) {
			int c = a+b;
			System.out.print(a+",\t");
			a = b;
			b = c;
		}
		
	}

}
