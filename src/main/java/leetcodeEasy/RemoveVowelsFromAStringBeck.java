package leetcodeEasy;

public class RemoveVowelsFromAStringBeck {

	public static String removeVowelsFromAStringBeck(String input) {

		StringBuilder sb = new StringBuilder();

		for (char c : input.toCharArray()) {

			if (c != 'A' && c != 'E' && c != 'I' && c != 'O' && c != 'U' && c != 'a' && c != 'e' && c != 'i' && c != 'o'
					&& c != 'u') {

				sb.append(c);
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {

		System.out.println(RemoveVowelsFromAStringBeck.removeVowelsFromAStringBeck("ABCDEFGHTIYO"));
	}
}