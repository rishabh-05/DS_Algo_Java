package Arrays;

import java.util.Scanner;

public class PainterPartition {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int nob = sc.nextInt();
		int nop = sc.nextInt();
		int[] boards = new int[nob];
		int sum = 0;
		for (int i = 0; i < boards.length; i++) {
			boards[i] = sc.nextInt();
			sum += boards[i];
		}

		int lo = 0;
		int hi = sum;
		int finalans = 0;
		while(lo<= hi) {
			
			int mid = (lo+hi)/2;
			
			if(isitPossible(nob, nop, boards, mid)) {
				hi = mid-1;
				finalans = mid;
				
			}else {
				lo = mid+1;
			}
		}
		System.out.println(finalans);

	}
	
	public static boolean isitPossible(int nob, int nos, int[] boards, int mid) {
		
		int numPainter = 1;
		int boardspainted = 0;
		
		int i =0;
		
		while(i<boards.length) {
			if(boardspainted + boards[i]<=mid) {
				boardspainted += boards[i];
				i++;
			}else {
				numPainter++;
				boardspainted  =0;
				
				if(numPainter> nos) {
					return false;
				}
			}
		}
		
		return true;	
	}
	
	

}
