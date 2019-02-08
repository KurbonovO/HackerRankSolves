package crackingTheCodingInterview;

public class StringCompressionOne {
	public String stringCompressionOne(String input) {

		char[] inputToCharArray = input.toCharArray();

		int counter = 0;
		String result = null;

		for (int i = 0; i < inputToCharArray.length; i++) {

			if (inputToCharArray[i] == inputToCharArray[i + 1]) {
				counter++;
				result = result + inputToCharArray[i];
			} else {
				result = result + counter;
				counter = 0;
			}
		}
		return result;
	}
}
