package leetcode_Medium;

/*769 Given an array arr that is a permutation of [0, 1, ..., arr.length - 1],
we split the array into some number of "chunks" (partitions), and individually
sort each chunk.  After concatenating them, the result equals the sorted array.
What is the most number of chunks we could have made?
Input: arr = [4,3,2,1,0]	Output: 1
Splitting into two or more chunks will not return the required result. For
example, splitting into [4, 3], [2, 1, 0] will result in [3, 4, 0, 1, 2], which
isn't sorted.
Input: arr = [1,0,2,3,4]	Output: 4
We can split into two chunks, such as [1, 0], [2, 3, 4]. However, splitting
into [1, 0], [2], [3], [4] is the highest number of chunks possible			 */

public class MaxChunksToMakeSorted {
	public int maxChunksToSorted(int[] arr) {

		if (arr == null || arr.length == 0) {
			return 0;
		}

		int count = 0;
		int max = 0;

		for (int i = 0; i < arr.length; i++) {

			max = Math.max(max, arr[i]);

			if (max == i) {
				count++;
			}
		}
		return count;
	}
}
