package Arrays;

import java.util.Scanner;

public class BookAllocation {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int nob = sc.nextInt();
		int nos = sc.nextInt();
		int[] pages = new int[nob];
		int sum = 0;
		for (int i = 0; i < pages.length; i++) {
			pages[i] = sc.nextInt();
			sum += pages[i];
		}

		int lo = 0;
		int hi = sum;
		int finalans = 0;
		while(lo<= hi) {
			
			int mid = (lo+hi)/2;
			
			if(isitPossible(nob, nos, pages, mid)) {
				hi = mid-1;
				finalans = mid;
				
			}else {
				lo = mid+1;
			}
		}
		System.out.println(finalans);

	}
	
	public static boolean isitPossible(int nob, int nos, int[] pages, int mid) {
		
		int numStud = 1;
		int pagesRead = 0;
		
		int i =0;
		
		while(i<pages.length) {
			if(pagesRead + pages[i]<=mid) {
				pagesRead += pages[i];
				i++;
			}else {
				numStud++;
				pagesRead  =0;
				
				if(numStud> nos) {
					return false;
				}
			}
		}
		
		return true;	
	}
	
	

}
