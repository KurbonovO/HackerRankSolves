package leetcode_Easy;

public class PeakIndexInAMountainArrayLeetCode {
	public int peakIndexInAMountainArray(int[] array) {

		if (array.length >= 3) {

			for (int i = 1; i + 1 < array.length; ++i) {

				if (array[i] > array[i + 1]) {
					
					return 0;
				}
			}
		}
		return -1;
	}
}
