package Patterns;

public class PatternX {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 7;
		int nsp = 0;
		int row = 1;
		int nst = n;
		int  nsp1 = 2*nst+1;
		

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
			//int col2 = 0;
			while (col < nsp1) {
				System.out.print(" ");
				col++;
			}
			
			col1 = 1;
			while (col1 <= nst) {
				if(row!=n)
				System.out.print("*");
				else
					System.out.print(" ");

				col1++;
			}
			//System.out.print(" ");

			

			System.out.println();
			
			if (row < n) {
				nst--;
				nsp= nsp+2;
				nsp1= nsp1-1;
			} else {
				nst++;
				nsp= nsp-2;
				nsp1= nsp1+1;
			}
			row++;
		}


	}

}
