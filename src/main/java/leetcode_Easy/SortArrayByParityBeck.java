package leetcode_Easy;

public class SortArrayByParityBeck {
	public int[] sortArrayByParity(int[] array) {

		int[] outputEven = new int[array.length];
		int[] outputOdd = new int[array.length];

		for (int i = 0; i < array.length; i++) {

			if ((array[i] % 2) == 0) {

				outputEven[i] = array[i];
			} else {

				outputOdd[i] = array[i];
			}
		}
		return outputEven;
	}
	
}
