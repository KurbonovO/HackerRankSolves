package crackingTheCodingInterview;

public class IsUniqueBeck {
	public boolean isUniqueBeck(String input) {

		for (int i = 0; i < input.length(); i++) {

			for (int j = i + 1; j < input.length(); j++) {

				if (input.charAt(i) == input.charAt(j)) {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {

		IsUniqueBeck drive = new IsUniqueBeck();
		System.out.println(drive.isUniqueBeck("abc"));
	}
}
