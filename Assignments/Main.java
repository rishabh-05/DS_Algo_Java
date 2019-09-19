package Assignments;


import java.util.*;
public class Main {
    public static void main(String args[]) throws Exception{
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t!=0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i< n; i++){
                arr[i] = sc.nextInt();
            }
            int[] ans = nextGreaterinOrderN(arr);
            
            //print
            
            for(int i = 0; i < n; i++){
                System.out.println(""+arr[i] + ","+ans[i]);
            }
            
            
            
            t--;
        }
    }
        
        public static int[] nextGreaterinOrderN(int[] arr) throws Exception {

		int[] ans = new int[arr.length];
		Stack<Integer> s1 = new Stack<>();

		for (int i = 0; i < arr.length; i++) {

			while (!s1.isEmpty() && arr[i] > arr[s1.peek()]) {

				int temp = s1.pop();
				ans[temp] = arr[i];
			}

			s1.push(i);
		}

		while (!s1.isEmpty()) {
			ans[s1.pop()] = -1;
		}

		return ans;

	}

    
}
