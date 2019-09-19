package DP;

public class EggDropping {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// n floors k eggs
		int floors = 7;
		int eggs = 2;
		//
		
		System.out.println(eggDropTD(floors, eggs, new int[floors+1][eggs+1]));

		System.out.println(eggDrop(36, 2));
	}

	public static int eggDrop(int floors, int eggs) {
		if (floors == 0 || floors == 1) {
			return floors;
		}
		if (eggs == 1) {
			return floors;
		}

		int min = Integer.MAX_VALUE;
		
		for(int i = 1; i <= floors; i++) {
			int eggBreak = eggDrop(i - 1, eggs - 1);
			int eggnoBreak = eggDrop(floors - i, eggs);

			int worstcase = Math.max(eggBreak, eggnoBreak);

			min = Math.min(min, worstcase);
		}

		return min + 1;
	}
	
	public static int eggDropTD(int floors, int eggs, int[][] strg) {
		if (floors == 0 || floors == 1) {
			return floors;
		}
		if (eggs == 1) {
			return floors;
		}
		
		if(strg[floors][eggs] != 0) return strg[floors][eggs];

		int min = Integer.MAX_VALUE;
		
		for(int i = 1; i <= floors; i++) {
			int eggBreak = eggDropTD(i - 1, eggs - 1, strg);
			int eggnoBreak = eggDropTD(floors - i, eggs, strg);

			int worstcase = Math.max(eggBreak, eggnoBreak);

			min = Math.min(min, worstcase);
		}
		strg[floors][eggs] = min+1;

		return min + 1;
	}
	
//	public static int eggDropBU(int floors, int eggs) {
//		
//		//base case ; rem floors are 1
//		int[][] strg = new int[floors+1][eggs+1];
//		
//		for(int c = 1; c<=strg[0].length; c++) {
//			strg[1][c] = 1;
//		}
//		//eggs =1; drops = floors
//		for(int r = 1; r<=strg.length; r++) {
//			strg[r][1] = r;
//		}
//		
//	}
	
	

}
