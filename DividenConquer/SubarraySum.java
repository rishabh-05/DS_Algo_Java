package DividenConquer;

public class SubarraySum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
		System.out.println(splitArray(a, 0, a.length-1));

	}
	
	public static int splitArray(int[] arr, int lo, int hi) {
		if(lo==hi) {
			return arr[lo];
		}
		
		
		int mid = (lo+hi)/2;
		int fh = splitArray(arr, lo, mid);
		int sh = splitArray(arr, mid+1, hi);
		int partsum = maxleft(arr, lo, mid) + maxright(arr, mid+1, hi);
		
		return Math.max(partsum, Math.max(fh,  sh));
	}

	public static int maxleft(int[] arr, int lo, int hi) {
		int max = Integer.MIN_VALUE;
		
		int sum = 0;
		for(int i = hi; i>=lo; i--) {
			sum+=arr[i];
			
			if(sum>max) {
				max = sum;
			}
			
		}
		return max;
	}

	public static int maxright(int[] arr, int lo, int hi) {
		int max = Integer.MIN_VALUE;
		
		int sum = 0;
		for(int i = lo; i<=hi; i++) {
			sum+=arr[i];
			
			if(sum>max) {
				max = sum;
			}
			
		}
		return max;
	}
	

}
