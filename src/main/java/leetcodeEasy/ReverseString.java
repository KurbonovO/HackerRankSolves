package leetcodeEasy;

import java.util.Arrays;

public class ReverseString {

	public void reverseString(char[] input) {

		char[] output = new char[input.length];
		int a = 0;

		for (int i = input.length - 1; i >= 0; i--) {

			output[a] = input[i];
			a++;
		}
		input = output;
		System.out.println(Arrays.toString(input));
	}

	public void reverseStringLeetCode(char[] input) {

		helper(input, 0, input.length - 1);
	}

	public void helper(char[] input, int left, int right) {

		if (left >= right) {
			return;
		}
		char temp = input[left];
		input[left++] = input[right];
		input[right--] = temp;
		helper(input, left, right);
	}
	
	public static void main(String[] args) {

		char[] input = { 'h', 'e', 'l', 'l', 'o' };

		ReverseString reverseString = new ReverseString();
		reverseString.reverseStringLeetCode(input);
		System.out.println(Arrays.toString(input));
	}
}
