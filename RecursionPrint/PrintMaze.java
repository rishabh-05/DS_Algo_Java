package RecursionPrint;

public class PrintMaze {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrintMaze1(0, 0, 2, 2, "");

		System.out.println(countPath(0, 0, 2, 2, 0));

	}

	public static void PrintMaze1(int crow, int ccol, int erow, int ecol, String ans) {
		// TODO Auto-generated method stub
		if (crow == erow && ccol == ecol) {
			System.out.print(ans + " ");

			return;
		}

		if (crow < erow) {
			PrintMaze1(crow + 1, ccol, erow, ecol, ans + "V");
		}
		if (ccol < ecol) {
			PrintMaze1(crow, ccol + 1, erow, ecol, ans + "H");
		}
		if (ccol < ecol && crow < erow /* && ccol == crow */) {
			PrintMaze1(crow + 1, ccol + 1, erow, ecol, ans + "D");
		}

	}

	public static int countPath(int crow, int ccol, int erow, int ecol, int count) {
		if (crow == erow && ccol == ecol) {

			return 1;
		}
		if (crow > erow || ccol > ecol) {
			return 0;
		}
		int count3 = 0;

		int count1 = countPath(crow + 1, ccol, erow, ecol, count );

		int count2 = countPath(crow, ccol + 1, erow, ecol, count);
		/* if (ccol == crow) */
			count3 = countPath(crow + 1, ccol + 1, erow, ecol, count);

		return count1 + count2 + count3;
	}
}
