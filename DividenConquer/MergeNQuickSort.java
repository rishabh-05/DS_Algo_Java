package DividenConquer;

public class MergeNQuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] b = { 2, 20, 3, 6, 4, 46, 31, 9, 10, 11, 20, 13 };
		Quicksort(b, 0, b.length-1);
		for(int val : b) {
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
	
	public static void Quicksort(int arr[], int low, int high) 
	{ 
		if (low < high) 
		{ 
			
			int pi = partition(arr, low, high); 

			
			Quicksort(arr, low, pi-1); 
			Quicksort(arr, pi+1, high); 
		} 
	}

	private static int partition(int[] arr, int low, int high) {
		// TODO Auto-generated method stub
		return 0;
	} 
	
	

}
