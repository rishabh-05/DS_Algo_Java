package Segmenttrees;

public class STreeMin implements STreeIN{

	@Override
	public int type(int a, int b) {
		// TODO Auto-generated method stub
		return Math.min(a, b);
	}

	@Override
	public int defaultValue() {
		// TODO Auto-generated method stub
		return Integer.MAX_VALUE;
	}
}
