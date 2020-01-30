package leetcodeEasy;

import java.util.Arrays;

public class ReverseString {

    public char[] reverseString(char[] s) {

        char[] output = new char[s.length];

        int counter = 0;

        for(int i = s.length - 1; i >= 0; i--) {

            output[counter] = s[i];
            counter += 1;
        }
        return output;
    }

    public void reverseStringLeetCode(char[] s) {

        helper(s, 0, s.length - 1);
    }

    public void helper(char[] s, int left, int right) {

        //exit out
        if(left >= right) {

            return;
        }

        //Get left character to temp
        char temporaryCharacter = s[left];

        //left character becomes one from last to the right
        s[left] = s[right];

        //move to next left character
        left++;

        //last to the right becomes temporary character we held as variable
        s[right] = temporaryCharacter;

        //move to next right to left character
        right--;

        //Start the process again
        helper(s, left, right);
    }

    public static void main(String[] args) {

        char[] a = {'h','e','l','l','o'};

        ReverseString reverseString = new ReverseString();

        System.out.println(Arrays.toString(reverseString.reverseString(a)));

        char[] b = {'h','e','l','l','o'};

        reverseString.reverseStringLeetCode(b);

        System.out.println(Arrays.toString(b));
    }
}
