package Patterns;

public class Pattern14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 7;
		int nst = 1 ;
		int row = 1;
		int nsp = n/2;
		

		while (row <= n) {
			int col = 1;
			while (col <= nsp) {
				System.out.print(" ");
				col++;
			}

			int col1 = 1;
			while (col1 <= nst) {
				System.out.print("*");

				col1++;
			}

			
			
			if (row <= n/2) {
				nsp = nsp -1;
				nst= nst+2;
			} else {
				nsp++;
				nst= nst-2;
			}
			row++;
			System.out.println();
		}


	}

}
