package RecursionPrint;

public class BoardPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BoardP(0, 3, 3, "");
		System.out.println(countPath(0, 3, 3));

	}

	public static void BoardP(int current, int end, int dice, String ans) {
		// TODO Auto-generated method stub
		if (current == end) {
			System.out.print(ans + " ");

			return;
		}
		if (current > end) {
			return;
		}

		for (int i = 1; i <= dice; i++) {

			BoardP(current + i, end, dice, ans + "" + i);

		}

	}
	
	public static int countPath(int current, int end, int dice) {
		if (current == end) {
		
			return 1;
		}
		if (current > end) {
			return 0;
		}
		int count = 0;
		for (int i = 1; i <= dice; i++) {

			count+= countPath(current + i, end, dice);


		}
		
		return count;
		
	}

}
