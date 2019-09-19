package Patterns;

public class Pattern5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		* * * * *
//		  * * * *
//		    * * *
//		      * *
//		        *
		
		int n = 5;
		int row = 1;
		int nst = n;
		int nsp = 0;
		
		while(row<=n) {
			int col = 0;
			while(col<nsp) {
				System.out.print(" ");
				col++;
			}
			int col1 = 1;
			while(col1<=nst) {
				System.out.print("*");
				col1++;
			}
			
			nst--;
			nsp++;
			row++;
			System.out.println();
			
			
			
		}
	
	}

}
