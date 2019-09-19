package Recursion;

public class CreateIPAddress {

	/*
	 * i/p: 25525511135 o/p: [255.255.111.35 , 255.255.11.135]
	 * 
	 * i/p: 12345 o/p: [1.23.4.5, 12.3.4.5, 1.2.34.5, 1.2.3.45]
	 * 
	 * rules: 1. must be split in 4 parts(3 periods) 2. every part in [0, 255]
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IPCreate("12345", "", 0);

	}

	public static void IPCreate(String str, String ans, int count) {
		if (str.length() == 0 && count == 4) {
			System.out.println(ans.substring(0, ans.length()-1) + " ");
			return;
		}
		
		int i = 1;
		
		for(; i<=str.length(); i++) {
			//count = 0;
			String cstr = str.substring(0, i);
			if(isValid(cstr)) {
				String ros = str.substring(i);
				
					IPCreate(ros, ans+cstr+".", count+1);
					
				
				
			}
		}
	}

	public static boolean isValid(String str) {
		long st = Long.parseLong(str);
		if (st >= 0 && st <= 255) {
			return true;
		} else {
			return false;
		}
	}

}
