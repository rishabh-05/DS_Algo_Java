import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Stack;

public class GFG {
//platform problem

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

//		int n = sc.nextInt();
//		int[] a = new int[n];
//		int[] d = new int[n];
//		takeinput(a, n);
//		takeinput(d, n);
		int[] a = { 900, 940, 950, 1100, 1500, 1800 };
		int[] d = { 910, 1200, 1120, 1130, 1900, 2000 };

		ADPair[] pairs = new ADPair[a.length];

		for (int i = 0; i < a.length; i++) {
			ADPair np = new ADPair();
			np.ar = a[i];
			np.de = d[i];
			pairs[i] = np;
		}

		Arrays.sort(pairs, new ADPair());
		for(ADPair pair : pairs) {
			System.out.println(pair);
		}
		
		int plt = 1;
		
		int ia = 1;
		int jd = 0;
		
		while(ia < a.length && jd < a.length) {
			if(pairs[ia].ar <= pairs[jd].de) {
				plt++;
				ia++;
			}
			else {
				jd++;
			}
		}
		
		System.out.println(plt);
		
		
		
	}

	public static class ADPair implements Comparator<ADPair> {

		int ar;
		int de;

		@Override
		public int compare(ADPair o1, ADPair o2) {
			// TODO Auto-generated method stub
			return o1.ar - o2.ar;
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return ar + " --> " + de;
		}

	}

}
