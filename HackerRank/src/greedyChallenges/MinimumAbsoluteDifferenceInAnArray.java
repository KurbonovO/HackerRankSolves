package greedyChallenges;

import java.util.Arrays;
import java.util.Scanner;

/*Given an array of n integers, find and print the minimum absolute difference between any two elements in the array.
Output Format: Print the minimum absolute difference between any two elements in the array*/

public class MinimumAbsoluteDifferenceInAnArray {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for(int arr_i=0; arr_i < n; arr_i++){
            a[arr_i] = in.nextInt();
        }
        in.close();
        
        Arrays.sort(a);
        int minDiff = a[n - 1] - a[0];
        for (int i = 0; i < n - 1; i++) {
            int tmpDiff = a[i + 1] - a[i];
            if (tmpDiff < minDiff) {
                minDiff = tmpDiff;
            }
        }
        
        System.out.println(minDiff);
    }
}

/*Sample Input
3
3 -7 0
Sample Output
3
Explanation: With n=3 integers in our array, we have three possible pairs: (3,-7), (3,0) and (-7, 0). The absolute values of
the differences between these pairs are as follows:
3 -- 7 -> 10
3 - 0  -> 3 
-7 - 0 -> 7
Notice that if we were to switch the order of the numbers in these pairs, the resulting absolute values would still be the same.
The smallest of these possible absolute differences is 3, so we print 3 as our answer*/