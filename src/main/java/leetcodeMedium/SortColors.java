package leetcodeMedium;

import java.util.Arrays;

public class SortColors {

    public static void sortColors(int[] nums) {

        int start = 0;
        int end  = nums.length - 1;

        for(int i = start; i <= end;) {

            if(nums[i] == 0) {

                int temp = nums[i];
                nums[i] = nums[start];
                nums[start] = temp;
                i++;
                start++;

            } else if(nums[i] == 2) {

                int temp = nums[i];
                nums[i] = nums[end];
                nums[end] = temp;
                end--;

            } else {

                i++;
            }
        }
    }

    public static void main(String[] args) {

        int[] nums = {2,0,2,1,1,0};

        sortColors(nums);

        System.out.println(Arrays.toString(nums));
    }
}
