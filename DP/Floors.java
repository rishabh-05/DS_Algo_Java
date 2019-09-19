package DP;

public class Floors {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ans = ways(13, 0);
		System.out.println(ans);
	}

	public static int ways(int n, int vidx) {
		if (n == 1)
			return 1;

		if (n == vidx) {
			return 1;
		}
		if (vidx > n)
			return 0;

		int i1 = ways(n, vidx + 1);
		int i2 = ways(n, vidx + 2);
		int i3 = ways(n, vidx + 3);
		
		return i1 + i2 + i3;
	}

}
