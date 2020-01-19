package leetcodeEasy;

import java.util.Arrays;

public class PlusOne {

    public static int[] plusOne(int[] digits) {

        int numsLength = digits.length;

        if (numsLength == 1) {

            digits[0] += 1;

            return digits;
        }

        if (digits[numsLength - 1] + 1 != numsLength) {

            digits[numsLength - 1] += 1;
            return digits;
        } else {
            return null;
        }
    }

    public static int[] plusOneLeetCode(int[] nums) {

        //get the length of nums array
        int n = nums.length;

        //Start the loop from end
        for (int i = n - 1; i >= 0; i--) {

            //if the last number is less than number 9
            if (nums[i] < 9) {

                //increase the last digit in the array by one
                nums[i]++;
                //exit out
                return nums;
            }
            //turn all of the number in array to 0;
            nums[i] = 0;
        }

        //initialize new array but has one extra space
        int[] newNumber = new int[n + 1];
        //leading of new array is number 1
        newNumber[0] = 1;
        //exit out
        return newNumber;
    }

    public static void main(String[] args) {

        int[] arr = {9, 9, 9, 9};

        //System.out.println(Arrays.toString(plusOne(arr)));
        System.out.println(Arrays.toString(plusOneLeetCode(arr)));
    }
}
