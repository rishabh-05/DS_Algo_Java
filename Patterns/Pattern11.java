package Patterns;

public class Pattern11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 7;
		int nsp = n - 1;
		int row = 1;
		int nst = 1;
		

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
				nst = nst + 1;
				nsp--;
			} else {
				nst--;
				nsp++;
			}
			row++;
		}

	}

}
