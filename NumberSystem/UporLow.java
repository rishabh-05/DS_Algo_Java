package NumberSystem;

import java.util.Scanner;

public class UporLow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		char ch = sc.next().charAt(0);
		sc.close();
		if(ch>='a'&&ch<'z') {
			System.out.println("LOWER");
		}else if(ch>='A' && ch<='Z'){
			System.out.println("UPPER");
		}else {
			System.out.println("Other character");
		}
		

	}

}
