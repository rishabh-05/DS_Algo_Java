package Patterns;

public class Pattern13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		int nsp = 0;
		int row = 1;
		int nst = n / 2;

		while (row <= n) {
			int col = 1;
			while (col <= nst) {
				System.out.print("*");
				col++;
			}

			int col1 = 0;
			while (col1 <= nsp) {
				if (nsp == 0)
					System.out.print("*");
				else
					System.out.print(" ");

				col1++;
			}

			col = 1;
			while (col <= nst) {
				System.out.print("*");
				col++;
			}

			if (row <= n / 2) {
				nst = nst - 1;
				nsp = nsp + 1;
			} else {
				nst++;
				nsp = nsp - 1;
			}
			row++;
			System.out.println();
		}

	}

}
