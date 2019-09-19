package Arrays;

import java.util.Scanner;
import java.util.Arrays;

public class AggressiveCows {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		int nstalls = sc.nextInt();
		int ncows = sc.nextInt();
		int[] stallpos = new int[nstalls];
		input(stallpos, nstalls);
		Arrays.sort(stallpos);

		int lo = 0; // minimum distance possible at which cow can be placed
		int hi = stallpos[stallpos.length-1] - stallpos[0]; // maximum distance-----------------------------------
		
		int lastrue = 0;

		while (lo <= hi) {
			
			int mid = (lo + hi) / 2;
			//System.out.println("in while");
			if (isitPossible(nstalls, ncows, stallpos, mid)) {
				lo = mid + 1;
				lastrue = mid;
			} else {
				hi = mid - 1;
			}

		}
		System.out.println(lastrue);

	}

	public static void input(int[] a, int len) {
		for (int i = 0; i < len; i++) {
			a[i] = sc.nextInt();
		}
	}
	

	public static boolean isitPossible(int nos, int noc, int[] arr, int mid) {

		int cowsPlaced = 1;
		int lastcowplaced = arr[0];

		for (int i = 0; i < nos; i++) {

			if (arr[i] - lastcowplaced >= mid) {
				cowsPlaced++;
				lastcowplaced = arr[i];
			}
			if (cowsPlaced == noc) {
				return true;
			}
		}

		return false;
	}

}
