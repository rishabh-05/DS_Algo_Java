package Patterns;

public class Pattern10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		
		int row=1;
		int nst = 1;
		int nsp = n-1;
		while(row<=2*n-1)
		{
		
			int col1 =1;
			while(col1<=nst) {
				System.out.print("*");
				
				col1++;
			}
			
			System.out.println();
			nsp=nsp-1;
			if(row<n)
				nst = nst+1;
			else
				nst--;
			row++;
		}

	}

}
