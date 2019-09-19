package Arrays;

import java.util.Arrays;

public class SumPairOrderN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int targetSum = 50;
		int[] arr = {10, 40, 23, 27, 30, 20, 25};
		
		Arrays.sort(arr);
		
		int i = 0;
		int j = arr.length-1;
		
		while(i<j) {
			if(arr[i] + arr[j] == targetSum) {
				System.out.println(arr[i]+ " " + arr[j]);
				i++;
				j--;
			}else if(arr[i] + arr[j] > targetSum) {
				j--;	
			}
			else {
				i++;
			}
		}

	}

}
