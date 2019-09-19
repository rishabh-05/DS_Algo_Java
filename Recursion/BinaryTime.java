package Recursion;

import java.util.ArrayList;

public class BinaryTime {

	/*
	 * hrs: o o o o (8) (4) (2) (1) mins: o o o o o o (32)(16)(8) (4) (2) (1)
	 * 
	 * o is the led. time is represented in binary. for 3:25 hrs led: 0 0 1 1 mins
	 * led: 0 1 1 0 0 1
	 * 
	 * Ques: given max no of LEDs that can glow(int LEDs), return all the times that
	 * can be represented with given no of LEDs
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(getTimes(1));
		
		System.out.println(getTimeAns(2));

	}
	
	public static ArrayList<String> getTimeAns(int leds){
		ArrayList<String> intermediate = getTimes(leds);
		ArrayList<String> answer = convertToTime(intermediate);
		return answer;
		
		
	}

	public static ArrayList<String> getTimes(int leds) {
		if (leds == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("0000000000");
			return br;
		}

		ArrayList<String> rr = getTimes(leds - 1);
		ArrayList<String> mr = new ArrayList<>();

		for (String val : rr) {
			for (int i = 0; i < 10; i++) {
				if (val.charAt(i) == '0') {
					mr.add(val.substring(0, i) + '1' + val.substring(i + 1));
				}
			}
		}
		return mr;


	}

	public static ArrayList<String> convertToTime(ArrayList<String> mr) {
		ArrayList<String> finans = new ArrayList<>();
		for (int i = 0; i < mr.size(); i++) {
			String str = mr.get(i);

			String hrs = str.substring(0, 4);
			int hrsn = Integer.parseInt(hrs);
			String mins = str.substring(4);
			int minsn = Integer.parseInt(mins);

			hrsn = bin2dec(hrsn);
			
			minsn = bin2dec(minsn);
			if(hrsn>11 || minsn>59) {
				continue;
			}
			String ans = "";
			if (minsn < 9) {
				ans = hrsn + ":0" + minsn;
			} else {
				ans = hrsn + ":" + minsn;
			}
			finans.add(ans);
		}
		return finans;
	}

	public static int bin2dec(int n) {
		// TODO Auto-generated method stub

		int ans = 0;
		int mul = 1;
		while (n != 0) {
			int rem = n % 10;
			ans = ans + rem * mul;
			mul *= 2;
			n = n / 10;
		}
		return ans;
	}

}
