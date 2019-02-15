package leetcode_Easy;

import java.util.HashMap;

//not fully finished
public class RomanToInteger {
	public int romanToInteger(String s) {

		int output = 0;

		HashMap<Character, Integer> roman = new HashMap<Character, Integer>();
		roman.put('I', 1);
		roman.put('V', 5);
		roman.put('X', 10);
		roman.put('L', 50);
		roman.put('C', 100);
		roman.put('D', 500);
		roman.put('M', 1000);

		char[] charArr = s.toCharArray();

		for (int i = 0; i < charArr.length; i++) {

			output += roman.get(charArr[i]);
		}
		return output;
	}

	public static void main(String[] args) {

		RomanToInteger romanToInteger = new RomanToInteger();
		System.out.println(romanToInteger.romanToInteger("IV"));
	}

}
