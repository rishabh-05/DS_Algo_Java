package Patterns;

/*
* * * * *
* * * * *
* * * * *
* * * * *
* * * * *
 */

		//no of rows
		// work to be done for row
		// prepare for next line

public class Pattern1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		int rows = 5;
		int j = 1;
		while (j <= rows) {
			for (int i = 0; i < rows; i++) {
				System.out.print("*");
			}
			System.out.println();
			j++;
		}

	}

}
