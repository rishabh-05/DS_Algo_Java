package Patterns;

public class Pattern7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int rows = 5;
		int j = 1;
		while (j <= rows) {
			for (int i = 1; i <= rows; i++) {
				if (j == 1 || j == rows || i == 1 || i == rows) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
				
			}
			System.out.println();
			
			j++;
		}

	}
}
