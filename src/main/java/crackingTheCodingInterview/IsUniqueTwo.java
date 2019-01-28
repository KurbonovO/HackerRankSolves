package crackingTheCodingInterview;

import java.util.Arrays;

//O(n log n)

class IsUniqueTwo {
	public boolean isUniqueTwo(String input) {

		char[] characterToArray = input.toCharArray();

		Arrays.sort(characterToArray);

		for (int i = 0; i < characterToArray.length - 1; i++) {

			if (characterToArray[i] != characterToArray[i + 1]) {
				continue;
			} else {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {

		IsUniqueTwo isUniqueDriver = new IsUniqueTwo();

		if (isUniqueDriver.isUniqueTwo("abcd10jk")) {
			System.out.println("unique");
		} else {
			System.out.println("duplicate");
		}
	}
}
