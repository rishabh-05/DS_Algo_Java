package DividenConquer;

/*
 * Pair such that A[i] > A[j] for i<j
 */
public class InversionPair {

	static int count = 0;

	public static int[] InvertedPair(int[] a, int[] b) {

		int i = 0;
		int j = 0;
		int k = 0;
		int[] merge = new int[a.length + b.length];
		while (i < a.length && j < b.length) {

			if (a[i] <= b[j]) {
				merge[k++] = a[i++];
			} else {
				count += a.length - i;

				merge[k++] = b[j++];
			}

		}
		while (i < a.length) {
			merge[k++] = a[i++];
		}
		while (j < b.length) {
			merge[k++] = b[j++];
		}

		return merge;
	}

	public static int[] inversionCount(int[] arr, int lo, int hi) {

		if (lo >= hi) {
			int[] ba = new int[1];
			ba[0] = arr[lo];
			return ba;
		}

		int mid = (lo + hi) / 2;
		int[] fh = inversionCount(arr, lo, mid);
		int[] sh = inversionCount(arr, mid + 1, hi);

		int ans[] = InvertedPair(fh, sh);
		// System.out.println(ans);
		return ans;
	}

	public static void main(String[] args) {

		int[] a = { 4, 3, 6, 1 };

		inversionCount(a, 0, a.length - 1);
		System.out.println(count);
	}

}
