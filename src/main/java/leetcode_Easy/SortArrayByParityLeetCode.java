package leetcode_Easy;

public class SortArrayByParityLeetCode {
	public int[] sortArrayByParityLeetCode(int[] array) {

		int i = 0;

		for (int n = 0; n < array.length; n++) {

			if ((array[n] % 2) == 0) {

				int tmp = array[i];
				array[i++] = array[n];
				array[n] = tmp;
			}
		}
		return array;
	}
}
