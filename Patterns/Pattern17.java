package Patterns;

public class Pattern17 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n =10;
		int row=1;
		int nst = 1;
		int nsp = n-1;
		

		while(row<=n) {
			//int val = n;
			int col1 = 1;
			while(col1<=nsp) {
				System.out.print(" ");
				col1++;
			}
			
			int col=1;
			while(col<=nst) {
				if(col==nst/2+1) {
					System.out.print("0");
				}
				else if(col<=nst/2) {
					System.out.print(n-row+col);
				}
				else {
					System.out.print(n+row-col);
				}
				col++;
			}
			row++;
			nst=nst+2;
			nsp--;
			System.out.println();
		}


	}

}
