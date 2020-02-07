package leetcodeMedium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsD {

    public List<List<Integer>> subsetsL(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backTrack(result, new ArrayList<>(), nums, 0);

        return result;
    }

    public void backTrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, int start) {

        result.add(new ArrayList<>(tempList));

        for (int i = start; i < nums.length; i++) {

            tempList.add(nums[i]);
            backTrack(result, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3};

        SubsetsD subsets = new SubsetsD();
        System.out.println(subsets.subsetsL(nums));
    }
}
