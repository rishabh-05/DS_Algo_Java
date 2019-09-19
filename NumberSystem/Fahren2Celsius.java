package NumberSystem;

import java.util.Scanner;

/*
 * c=(5/9)(f-32)
 */
public class Fahren2Celsius {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int min = sc.nextInt();
		int max = sc.nextInt();
		int step = sc.nextInt();
		sc.close();
		int temp = min;
		while(temp<=max) {
			int c = (int) ((5.0/9.0)*(temp-32));
			
			System.out.println(temp + "\t" + c);
			temp+=step;
		}

	}

}
