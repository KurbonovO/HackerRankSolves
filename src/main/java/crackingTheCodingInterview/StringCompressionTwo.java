package crackingTheCodingInterview;

public class StringCompressionTwo {
	public String stringCompressionTwo(String input) {

		String compressedString = "";
		int countConsecutive = 0;

		for (int i = 0; i < input.length(); i++) {

			countConsecutive++;

			if (i + 1 >= input.length() || input.charAt(i) != input.charAt(i + 1)) {

				compressedString += "" + input.charAt(i) + countConsecutive;
				countConsecutive = 0;
			}
		}
		return compressedString.length() < input.length() ? compressedString : input;
	}
}
