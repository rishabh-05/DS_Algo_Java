package Patterns;

import java.util.Scanner;

//    1

//  2 3 2
//3 4 5 4 3
//  2 3 2
//    1

public class PattternA1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		int nst = 1;
		int nsp = 2 * n - 1;
		int row = 1;

		while (row <= 2 * n + 1) {
			int val = n;
			// nums---------------
			int col = 1;
			while (col <= nst) {
				System.out.print(val + " ");
				val--;
				col++;
			}
			// spaces----------------
			col = 1;
			while (col <= nsp) {
				System.out.print("  ");
				col++;
			}
			// nums---------------
			col = 1;
			val = n;
			while (col <= nst) {
				if (row <= n)
					System.out.print(Math.abs(val + 1 - row) + " ");
				else if (row == n + 1) {
					if(col<nst)
					System.out.print((val - row+2) + " ");
					}
				else
					System.out.print( " ");
				val++;
				col++;
			}

			if (row <= n) {
				nst++;
				nsp -= 2;
			} else {
				nst--;
				nsp += 2;
			}

			row++;
			System.out.println();
		}
	}

}
