package Patterns;


public class Pattern8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n = 5;
		int nsp = n-1;
		int row=1;
		int nst = 1;
		
		while(row<=n)
		{
			int col = 1;
			while(col<=nsp) {
				System.out.print(" ");
				col++;
			}
			int col1 =1;
			while(col1<=nst) {
				System.out.print("*");
				col1++;
			}
			
			System.out.println();
			nsp--;
			nst = nst+2;
			row++;
		}

	}

}
