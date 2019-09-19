package Segmenttrees;

public class STreeMax implements STreeIN{

	@Override
	public int type(int a, int b) {
		// TODO Auto-generated method stub
		return Math.max(a, b);
	}

	@Override
	public int defaultValue() {
		// TODO Auto-generated method stub
		return Integer.MIN_VALUE;
	}

}
