package Arrays;

import java.util.Scanner;

/*
 * i/p:		DDDIDDID
 * O/P:		432176598
 * description: move until you get an I, start counting, from n to 0 position, move from I until
 * you get a next I. Start reverse counting from I.
 */

public class IncreasingDecreasingSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		sc.close();
		int[] ans = new int[str.length()+1];
		int count =1;
		for(int i = 0; i<=str.length(); i++) {
			if(i==str.length()|| str.charAt(i)=='I') {
				ans[i] = count++;
				
				for(int j = i-1; j>=0 && str.charAt(j)!='I'; j--) {
					ans[j] = count++;
				}
			}
		}
		for(int val:ans) {
			System.out.print(val);
		}
	}
	
	

}
