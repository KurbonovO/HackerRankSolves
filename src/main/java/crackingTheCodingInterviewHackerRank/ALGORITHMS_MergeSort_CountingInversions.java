package crackingTheCodingInterviewHackerRank;

import java.util.Arrays;
import java.util.Scanner;

/*inverted elements arri and arrj are considered to be "out of order". To correct an inversion, we can swap adjacent elements.
For example, consider arr = [2,4,1]. It has two inversions: 2,1 and 4,1.
To sort the array, we must perform the following two swaps to correct the inversions:
arr = [2,4,1] -> swap (arr1, arr2) and swap (arr0, arr1) -> 1,2,4
Given d datasets, print the number of inversions that must be swapped to sort each dataset on a new line.*/

public class ALGORITHMS_MergeSort_CountingInversions {
	public static long countInversions(int[] a) {
		
		int n = a.length;

	  //Base Case
		if (n <= 1) {
			return 0;
		}

	  //Recursive Case
		int mid = n >> 1;
		int[] left = Arrays.copyOfRange(a, 0, mid);
		int[] right = Arrays.copyOfRange(a, mid, a.length);
		long inversions = countInversions(left) + countInversions(right);

		int range = n - mid;
		int iLeft = 0;
		int iRight = 0;
		for (int i = 0; i < n; i++) {
			if (iLeft < mid
					&& (iRight >= range || left[iLeft] <= right[iRight])) {
				a[i] = left[iLeft++];
				inversions += iRight;
			} else if (iRight < range) {
				a[i] = right[iRight++];
			}
		}
		return inversions;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int t = scanner.nextInt();

		for (int i = 0; i < t; i++) {
			int n = scanner.nextInt();
			int[] a = new int[n];

			for (int j = 0; j < n; j++) {
				a[j] = scanner.nextInt();
			}

			System.out.println(countInversions(a));
		}
		scanner.close();
	}
}
/*Sample Input:
2  
5  
1 1 1 2 2  
5  
2 1 3 1 2
Sample Output:
0  
4   
Explanation:
We sort the following d=2 datasets:
1) arr = [1,1,1,2,2] is already sorted, so there are no inversions for us to correct. Thus, we print 0 on a new line.
2) arr = [2,1,3,1,2] ->1swap [1,2,3,1,2] ->2swap [1,1,2,3,2] ->1swap [1,1,2,2,3]
As we performed a total of 1+2+1=4 swaps to correct inversions, we print 4 on a new line*/


