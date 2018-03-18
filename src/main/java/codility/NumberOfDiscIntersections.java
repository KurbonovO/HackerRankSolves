package codility;

import java.util.Arrays;
/*
 * We draw N discs on a plane. The discs are numbered from 0 to N - 1. A zero-indexed array A of N non-negative integers, specifying the radiuses of the discs, is given.
 *  The J-th disc is drawn with its center at (J, 0) and radius A[J].

We say that the J-th disc and K-th disc intersect if J not equals K and the J-th and K-th discs have at least one common point (assuming that the discs contain their borders).

The figure below shows discs drawn for N = 6 and A as follows:

  A[0] = 1
  A[1] = 5
  A[2] = 2
  A[3] = 1
  A[4] = 4
  A[5] = 0
  
There are eleven (unordered) pairs of discs that intersect, namely:

discs 1 and 4 intersect, and both intersect with all the other discs;
disc 2 also intersects with discs 0 and 3.
Write a function:

int solution(int A[], int N);
that, given an array A describing N discs as explained above, returns the number of (unordered) pairs of intersecting discs. 
The function should return -1 if the number of intersecting pairs exceeds 10,000,000.

Given array A shown above, the function should return 11, as explained above.
 */

public class NumberOfDiscIntersections {

	public int solution(int[] A) {

		int counter = 0, j = 0;
		long[] upper = new long[A.length];
		long[] lower = new long[A.length];

		for (int i = 0; i < A.length; i++) {
			lower[i] = (long) i - A[i];
			upper[i] = (long) i + A[i];
		}

		Arrays.sort(lower);
		Arrays.sort(upper);

		for (int i = 0; i < A.length; i++) {
			while (j < A.length && upper[i] >= lower[j]) {
				counter += j - i;
				j++;
			}
			if (counter > 10000000)
				System.exit(0);
		}

		return counter;
	}
}
