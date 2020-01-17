package leetcodeEasy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DecompressRunLengthEncodedList {

    public static int[] decompressRLElist(int[] nums) {

        int[] result = new int[nums.length];
        int counter = 0;

        for (int i = 0; i < nums.length; i++) {

            for (int j = nums[i]; j > 0; j--) {

                result[counter] = nums[i + 1];
                counter++;
            }
            i++;
        }
        return result;
    }

    public static int[] decompressRLElistLeetCode(int[] nums) {

        List<Integer> resultList = new ArrayList<>();

        for (int i = 0; i < nums.length; i += 2) {

            for (int j = 0; j < nums[i]; ++j) {

                resultList.add(nums[i + 1]);
            }
        }
        return resultList.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4};
        System.out.println(Arrays.toString(decompressRLElist(arr)));
        System.out.println(Arrays.toString(decompressRLElistLeetCode(arr)));
    }
}
