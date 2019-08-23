package leetcodeEasy;

public class OccurrencesOfSubstringInAStringBeck {

	public static int OccurrencesOfSubstringInAString(String input, String subString) {

		int result = 0;
		int lastIndex = 0;

		while (lastIndex != -1) {

			lastIndex = input.indexOf(subString, lastIndex);

			if (lastIndex != -1) {

				result++;
				lastIndex += subString.length();
			}
		}
		return result;
	}

	public static void main(String[] args) {

		System.out.println(OccurrencesOfSubstringInAStringBeck
				.OccurrencesOfSubstringInAString("helloslkhellodjladfjhello", "hello"));
	}
}
