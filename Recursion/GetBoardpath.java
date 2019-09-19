package Recursion;

import java.util.ArrayList;

public class GetBoardpath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getBoard(5, 0));

	}

	public static ArrayList<String> getBoard(int end, int current) {
		if (current == end) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}
		if(current>end) {
			ArrayList<String> br = new ArrayList<>();
			
			return br;
		}

		ArrayList<String> mr = new ArrayList<>();
		for (int dice = 1; dice <= 6; dice++) {

			int newdice = dice + current;
			if (newdice <= end) {

				ArrayList<String> rr = getBoard(end, newdice);

				for (String val : rr) {
					mr.add(dice + val);
				}
			}

		}

		return mr;

	}

}
