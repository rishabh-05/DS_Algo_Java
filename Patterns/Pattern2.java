package Patterns;

/*
*
* *
* * *
* * * *
* * * * *
 */
public class Pattern2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n = 5;
		
		int row = 1;
		int nst = 1;
		
		while(row<=n) {
			
			int col =1;
			while(col<=nst) {
				System.out.print("* ");
				col++;
			}
			row++;
			nst++;
			System.out.println();
			
		}
	}

}
