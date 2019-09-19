package NumberSystem;

import java.util.Scanner;

public class Rotate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int rotby = sc.nextInt();
		sc.close();
		// count digits-----------------
		int k = n;
		int count = 0;
		while (k != 0) {
		
			count++;
			k = k / 10;
		}
		//handle rotation-----------------
		rotby = rotby % count;
		if(rotby>0) {
			rotby = rotby-count;
		}
		//negative rotation-----------------
		while (rotby != 0) {

			int rem = n % 10;
			n = n / 10;
			n = (int) (rem * Math.pow(10, count - 1) + n);
			rotby++;

		}


		System.out.println(n);
	}

}
