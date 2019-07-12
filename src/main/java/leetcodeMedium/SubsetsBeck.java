package leetcodeMedium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsBeck {

	public static List<List<Integer>> subsetsBeck(int[] nums) {

		List<List<Integer>> output = new ArrayList<>();
		Arrays.sort(nums);
		backTrack(output, new ArrayList<Integer>(), nums, 0);
		return output;
	}

	private static void backTrack(List<List<Integer>> output, ArrayList<Integer> tempList, int[] nums, int start) {

		output.add(new ArrayList<>(tempList));

		for (int i = start; i < nums.length; i++) {

			tempList.add(nums[i]);
			backTrack(output, tempList, nums, start + 1);
			tempList.remove(tempList.size() - 1);
		}
	}

	public static void main(String[] args) {

		int[] nums = { 1, 2, 3 };
		
		System.out.println(SubsetsBeck.subsetsBeck(nums));
	}

}
