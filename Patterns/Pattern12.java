package Patterns;

public class Pattern12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n = 5;
		int nsp = 0;
		int row = 1;
		int nst = n;
		

		while (row <= 2 * n - 1) {
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
			

			

			System.out.println();
			
			if (row < n) {
				nst--;
				nsp= nsp+2;
			} else {
				nst++;
				nsp= nsp-2;
			}
			row++;
		}


	}

}
