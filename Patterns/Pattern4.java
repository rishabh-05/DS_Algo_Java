package Patterns;

/*
 		*
 	  * *
    * * *
  * * * *
* * * * *
 */
public class Pattern4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		int row = 1;

		int nsp = n - 1;
		int nst = 1;

		while (row <= n) {
			int col = 1;
			while (col <= nsp) {
				System.out.print("\t");
			col++;
			}
			int col1 = 1;
			while(col1<=nst) {
				System.out.print("*\t");
			col1++;
			}
			nst++;
			row++;
			nsp--;
			System.out.println();
		}
	}

}
