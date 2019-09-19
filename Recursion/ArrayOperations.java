package Recursion;

public class ArrayOperations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = { 10, 20, 30, 40, 60, 50, 60, 50, 30, 60 , 100};
		// printelements(arr, 0);
		//System.out.println(findmax(arr, 0));
		 System.out.println(firstoccurance(arr, 600, 0));
		//System.out.println(lastoccur(arr, 160, 0));
//		int[] ans = alloccurances(arr, 60, 0, 0);
//		for(int i =0; i<ans.length; i++) {
//			System.out.println(ans[i]);
//		}

	}

	public static void printelements(int[] a, int i) {
		if (i == a.length) {
			return;
		}
		System.out.println(a[i]);
		printelements(a, i + 1);
	}

	public static int findmax(int[] a, int i) {
		if (i == a.length) {
			return a[i-1];
		}

		int ans = Math.max(a[i], findmax(a, i + 1));
		return ans;
	}

	public static int firstoccurance(int[] arr, int key, int i) {
		if (i == arr.length) {
			return -1;
		}
		int pos;

		if (key != arr[i]) {
			pos = firstoccurance(arr, key, i + 1);
		} else {
			pos = i;
		}
		return pos;

	}

	public static int lastoccur(int[] arr, int key, int i) {
		if (i == arr.length) {
			return -1;
		}
		int pos;
		
		pos = lastoccur(arr, key, i+1);
		
		if(arr[i]==key) {
			pos = Math.max(i,  pos);
		}

		

		return pos;

	}
	
	public static int[] alloccurances(int[] arr, int key, int i, int count) {
		if(i==arr.length) {
			int[] ans = new int[count];
			return ans;
		}
		
		if(key == arr[i]) {
			count++;
		
		}
		int[] a = alloccurances(arr, key, i+1, count);
		
		if(arr[i]==key) {
			a[--count] = i;
		}
		return a;
		
	
	}

}
