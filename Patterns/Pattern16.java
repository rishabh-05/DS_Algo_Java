package Patterns;

public class Pattern16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		// int nsp = 1 ;
		int row = 1;
		int nst = 1;

		int val = 1;
		while (row <= 2 * n - 1) {
			int col = 1;
			while (col <= nst) {
				if (col % 2 == 0) {
					System.out.print("*");
				} else
					System.out.print(val);
				col++;
			}

			if (row < n) {
				val++;
				nst = nst + 2;
			} else {
				val--;
				nst = nst - 2;
			}
			row++;

			System.out.println();
		}

	}

}
