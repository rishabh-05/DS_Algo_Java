package Assignments;

import java.util.*;
public class MaxinWindowK {
    public static void main(String args[]) {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int[] a = new int[n];
        
        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        
        maxWindow(a, k);

    }
    
    public static void maxWindow(int[] a, int k){
        int n = a.length;
        
        Deque<Integer> q = new ArrayDeque<>();
        int i = 0;
        for(; i < k; i++){
            while(!q.isEmpty() && a[i] >= a[q.peekLast()]){
                q.pollLast();
            }
            q.addLast(i);
        }
        for(; i < a.length; i++) {
        		
        	System.out.print(a[q.peek()] + " ");
        	
        	while(!q.isEmpty() && q.peek() <= i-k) {
        		q.removeFirst();
        	}
        	while(!q.isEmpty() && a[i] >= a[q.peekLast()]){
                q.pollLast();
            }
        	
        	q.addLast(i);
        	
        	
        }
        System.out.println(a[q.peek()] + " ");
        
    }
}
