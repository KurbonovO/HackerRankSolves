package leetcode_Easy;

public class ToLowerCaseBeck {
	public String toLowerCaseBeck(String input) {

		char[] arr = input.toCharArray();

		for (int i = 0; i < arr.length; i++) {

			if ('A' <= arr[i] && arr[i] <= 'Z') {

				arr[i] = (char) (arr[i] - 'A' + 'a');
			}
		}
		return new String(arr);
	}

	public static void main(String[] args) {
		ToLowerCaseBeck toLowerCaseBeck = new ToLowerCaseBeck();
		System.out.println(toLowerCaseBeck.toLowerCaseBeck("Hello"));
	}
}
