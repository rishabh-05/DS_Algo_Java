package NumberSystem;

import java.util.Scanner;

public class ReplaceAll {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        int k = n;
        int count = 0;
        while(k!=0){
            int rem = k%10;
            if(rem ==0){
                n+=(5* (int) Math.pow(10, count));
                 
            }
         count++;
            k/=10;  
            
        }
        System.out.println(n);


	}

}
