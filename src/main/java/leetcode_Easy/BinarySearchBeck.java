package leetcode_Easy;

public class BinarySearchBeck {
	public int binarySearchBeck(int[] array, int target) {

		for (int i = 0; i < array.length; i++) {

			if (array[i] == target) {

				return i;
			}
		}
		return -1;
	}

	public static void main(String[] args) {

		BinarySearchBeck binarySearchBeck = new BinarySearchBeck();

		int[] array = { -1, 0, 3, 5, 9, 12 };
		int target = 9;
		System.out.println(binarySearchBeck.binarySearchBeck(array, target));
	}
}
