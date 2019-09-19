package Assignments;

import java.util.Scanner;
import java.util.Stack;

public class PlayingWithCards {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int noc = sc.nextInt();
		int iter = sc.nextInt();
		int[] arr = new int[noc];
		Stack<Integer> s = new Stack<>();
		for(int i = 0; i< noc; i++) {
			arr[i] = sc.nextInt();
		}
		//calculate i primes and store in array
		
		int[] prime = new int[iter];
		int count = 0;
		int i = 2;
		while(count<iter) {
			if(isPrime(i)) {
				prime[count] = i;
				count++;
			}
			i++;
			
		}
		

	}

	private static boolean isPrime(int i) {
		for(int j  =2; j * j <= i; j++) {
			if(i%j==0) {
				return false;
			}
		}
		return true;
	}

}
