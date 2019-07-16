package leetcodeEasy;

public class DefangingAnIPAddressBeck {

	public static String defangingAnIPAddressBeck(String input) {

		if (input.contains(".")) {

			input = input.replace(".", "[.]");
		}
		return input;
	}

	public static String defangingAnIPAddressLeetCode(String input) {

		return input.replace(".", "[.]");
	}

	public static void main(String[] args) {

		System.out.println(DefangingAnIPAddressBeck.defangingAnIPAddressBeck("255.100.50.0"));
	}

}
