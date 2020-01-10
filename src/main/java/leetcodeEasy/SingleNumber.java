package leetcodeEasy;

import java.util.HashSet;

public class SingleNumber {

    public static int singleNumber(int[] nums) {

        HashSet<Integer> hs = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {

            hs.add(nums[i]);
        }
        return hs.toArray(new Integer[1])[0];
    }

    public static int singleNumberLeetCode(int[] nums) {

        int result = 0;

        for (int num : nums) {

            result ^= num;
        }
        return result;
    }

    public static void main(String[] args) {

        int[] nums = {2, 2, 1};

        System.out.println(singleNumber(nums));
        System.out.println(singleNumberLeetCode(nums));
    }
}
