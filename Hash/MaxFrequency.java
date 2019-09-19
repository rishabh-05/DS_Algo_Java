package Hash;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class MaxFrequency {

	public static char MaxFreq(String str) {

		HashMap<Character, Integer> chmap = new HashMap<>();

		char[] charArr = str.toCharArray();

		for (char cc : charArr) {
			if (!chmap.containsKey(cc)) {
				chmap.put(cc, 1);
			} else {
				int val = chmap.get(cc);
				chmap.put(cc, val + 1);
			}
		}

		// find max freq now
		int max = Integer.MIN_VALUE;
		char ans = ' ';
		for (char key : chmap.keySet()) {
//			max = Math.max(max, chmap.get(key));
			if (chmap.get(key) > max) {
				max = chmap.get(key);
				ans = key;
			}
		}
		System.out.print(max + "-->");
		return ans;
	}

	public static ArrayList<Integer> intersection(int[] one, int[] two) {
		HashMap<Integer, Integer> map = new HashMap<>();

		ArrayList<Integer> list = new ArrayList<>();
		for (int val : one) {
			if (!map.containsKey(val)) {
				map.put(val, 1);
			} else {
				int exi = map.get(val);
				map.put(val, exi + 1);
			}
		}
		for (int t : two) {
			if (map.containsKey(t) && map.get(t) > 0) {
				list.add(t);
				int val = map.get(t);
				map.put(t, val - 1);
			}
		}
		

		return list;
	}

	public static ArrayList<Integer> consecNos(int[] arr) {
		HashMap<Integer, Boolean> map = new HashMap<>();

		ArrayList<Integer> list = new ArrayList<>();
		
		for(int val : arr) {
			
			if(map.containsKey(val-1)) {
				map.put(val, false);
			}else {
				map.put(val, true);
				
			}
			if(map.containsKey(val+1)) {
				map.put(val+1, false);
			}
		}
		
		int count  = 0;
		int maxcount = 0;
		int starting = 0;
		
		for(int key : map.keySet()) {
			count  = 0;
			if(map.get(key)) {
				
				while(map.containsKey(key+count)) {
					count++;
				}
				if(count> maxcount) {
					maxcount = count;
					starting = key;
				}
				
			}
		}
		
		for(int i = 0; i< maxcount; i++) {
			list.add(starting + i);
		}
		
		
		
		return list;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Scanner sc= new Scanner(System.in);
//		String str = sc.next();
		String str1 = "aaabbcddab";
		System.out.println(MaxFreq(str1));
		int[] one = { 21, 10, 40, 30, 10, 40, 40, 50, 60, 20, 70 };
		int[] two = { 10, 40, 10, 10, 10, 40, 10, 70, 80, 100 };
		ArrayList<Integer> ans = intersection(one, two);
		System.out.println(ans);
		
		int[] arr = {4, 2, 5, 1, 7, 8, 9, 13, 11, 14, 10, 22, 21, 6};
		System.out.println(consecNos(arr));
	}
}
