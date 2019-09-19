package Recursion;

public class MergeNQuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] b = { 2, 20, 3, 6, 4, 46, 31, 9, 10, 11, 20, 13 };
		int[] ans = mergeSort(b, 0, b.length-1);
		for(int val : ans) {
			System.out.print(val + " ");
		}

	}

	public static int[] mergetwoSortedArrays(int[] a, int[] b) {

		int i = 0;
		int j = 0;
		int k = 0;
		int[] merge = new int[a.length + b.length];
		while (i < a.length && j < b.length) {

			if (a[i] <= b[j]) {
				merge[k++] = a[i++];
			} else {
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

	public static int[] mergeSort(int[] arr, int lo, int hi) {
		
		if(lo>=hi) {
			int[] ba = new int[1];
			ba[0] = arr[lo];
			return ba;
		}
		
			int mid = (lo + hi) / 2;
			int[] fh = mergeSort(arr, lo, mid);
			int[] sh = mergeSort(arr, mid + 1, hi);

			
		
		int[] ans = mergetwoSortedArrays(fh, sh);
		return ans;
	}

}
