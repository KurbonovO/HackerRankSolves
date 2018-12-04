package leetcode_Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*47 Given a collection of numbers that might contain duplicates, return all
possible unique permutations.
Input: [1,1,2]	Output:
[ 	   [1,1,2],
       [1,2,1],
       [2,1,1]	]															 */

public class PermutationsII {
	public List<List<Integer>> permuteUnique(int[] nums) {

		List<List<Integer>> result = new ArrayList<List<Integer>>();

		if (nums == null || nums.length == 0) {
			return result;
		}
		boolean[] used = new boolean[nums.length];
		List<Integer> list = new ArrayList<Integer>();
		Arrays.sort(nums);
		dfs(nums, used, list, result);
		return result;
	}

	public void dfs(int[] numbers, boolean[] used, List<Integer> list, 
			List<List<Integer>> result) {

		if (list.size() == numbers.length) {
			result.add(new ArrayList<Integer>(list));
			return;
		}

		for (int i = 0; i < numbers.length; i++) {

			if (used[i]) {
				continue;
			}
			if (i > 0 && numbers[i - 1] == numbers[i] && !used[i - 1]) {
				continue;
			}
			used[i] = true;
			list.add(numbers[i]);
			dfs(numbers, used, list, result);
			used[i] = false;
			list.remove(list.size() - 1);
		}
	}
}
