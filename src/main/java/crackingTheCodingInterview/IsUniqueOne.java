package crackingTheCodingInterview;

//O(n^2)

class IsUniqueOne {
	public boolean isUniqueOne(String input) {

		for (int i = 0; i < input.length(); i++) {

			for (int n = i + 1; n < input.length(); n++) {

				if (input.charAt(i) == input.charAt(n)) {

					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {

		IsUniqueOne isUniqueDriver = new IsUniqueOne();
		if (isUniqueDriver.isUniqueOne("abcd10jka")) {
			System.out.println("unique");
		} else {
			System.out.println("duplicate");
		}
	}
}
