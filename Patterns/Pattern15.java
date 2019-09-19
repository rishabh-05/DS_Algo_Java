package Patterns;

public class Pattern15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 18;
		int nst = 1;
		int row = 1;
		int nsp = 2 * n - 3;

		while (row <= n) {
			int col = 1;
			while (col <= nst) {
				System.out.print("*");
				col++;
			}

			int col1 = 1;
			while (col1 <= nsp) {
				System.out.print(" ");

				col1++;
			}
			col1 = 1;
			if (row < n) {
				while (col1 <= nst) {

					System.out.print("*");

					col1++;
				}
			} else {
				while (col1 < nst) {

					System.out.print("*");

					col1++;
				}
			}
//			// ---------------------------------
//			col = 1;
//			while (col <= nst) {
//				System.out.print("*");
//				col++;
//			}
//
//			col1 = 1;
//			while (col1 <= nsp) {
//				if (row > 1 && row <= 4 && ((col1 > 7 - nst && col1 <= 13 - nst))) {
//
//					System.out.print("!");
//
//				} else {
//					System.out.print(" ");
//				}
//
//				col1++;
//			}
//			col1 = 1;
//			if (row < n) {
//				while (col1 <= nst) {
//
//					System.out.print("*");
//
//					col1++;
//				}
//			} else {
//				while (col1 < nst) {
//
//					System.out.print("*");
//
//					col1++;
//				}
//			}
//			// ---------------------------------
//			col = 1;
//			while (col <= nst) {
//				System.out.print("*");
//				col++;
//			}
//
//			col1 = 1;
//			while (col1 <= nsp) {
//				System.out.print(" ");
//
//				col1++;
//			}
//			col1 = 1;
//			if (row < n) {
//				while (col1 <= nst) {
//
//					System.out.print("*");
//
//					col1++;
//				}
//			} else {
//				while (col1 < nst) {
//
//					System.out.print("*");
//
//					col1++;
//				}
//			}
			nst++;
			nsp = nsp - 2;
			row++;
			System.out.println();
		}

	}

}
