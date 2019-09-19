
import java.util.*;

class GFG1 {
	public static void main(String[] args) {
		// code

		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = sc.nextInt();
			}

			int zp = 0;
			int nzp = 1;

			while (nzp < a.length) {

				if (a[zp] != 0 && a[nzp] != 0) {
					zp++;
					
				}
				if (a[zp] == 0 && a[nzp] == 0) {
					
				}
				if (a[zp] == 0 && a[nzp] != 0) {
					a[zp] = a[nzp];
					a[nzp] = 0;
					zp++;
					
				}
				nzp++;

			}
			for (int val : a) {
				System.out.print(val + " ");
			}
		}

	}
}
