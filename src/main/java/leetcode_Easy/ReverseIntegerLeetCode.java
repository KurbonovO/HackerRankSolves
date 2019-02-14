package leetcode_Easy;

public class ReverseIntegerLeetCode {
	public int reverseInteger(int input) {

		int output = 0;

		while (input != 0) {

			int tail = input % 10;
			int newResult = output * 10 + tail;
			if ((newResult - tail) / 10 != output) {
				return 0;
			}
			output = newResult;
			input = input / 10;
		}
		return output;
	}

	public static void main(String[] args) {

		ReverseIntegerLeetCode reverseIntegerLeetCode = new ReverseIntegerLeetCode();
		System.out.println(reverseIntegerLeetCode.reverseInteger(-123));
	}
}
