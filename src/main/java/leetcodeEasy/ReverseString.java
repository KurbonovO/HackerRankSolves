package leetcodeEasy;

import java.util.Arrays;

public class ReverseString {

    public static String reverseString(char[] arr) {

        int i = 0;
        int j = arr.length - 1;

        while (i < j) {

            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        return new String(Arrays.toString(arr));
    }

    public static void reverseSb(char[] arr) {

        StringBuilder sb = new StringBuilder();
        sb.append(arr);
        sb.reverse();
    }

    public static void main(String[] args) {

        char[] arr = {'a', 'b', 'c'};

        System.out.println(reverseString(arr));

        char[] arrB = {'q', 'w', 'e'};
        reverseSb(arrB);
        System.out.println(arrB);
    }
}
