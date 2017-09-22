package hacker_rank;

import java.util.Scanner;

/*
To prove Insertion Sort is correct, you will then demonstrate it for the three stages:
1) Initialization - The subarray starts with the first element of the array, and it is (obviously) sorted to begin with.
2) Maintenance - Each iteration of the loop expands the subarray, but keeps the sorted property.
An element  gets inserted into the array only when it is greater than the element to its left. 
Since the elements to its left have already been sorted, it means  is greater than all the elements to its left, so the array remains sorted.
(In Insertion Sort 2 we saw this by printing the array each time an element was properly inserted.)
3) Termination - The code will terminate after  has reached the last element in the array, which means the sorted subarray has expanded
to encompass the entire array. The array is now fully sorted.
Challenge:
In the InsertionSort code below, there is an error. Can you fix it? Print the array only once, when it is fully sorted.
 */

public class CorrectnessAndTheLoopInvariant {

	public static void insertionSort(int[] A) {
		for (int i = 1; i < A.length; i++) {
			int value = A[i];
			int j = i - 1;
			while (j >= 0 && A[j] > value) { // We just had to add the = to >
												// part
				A[j + 1] = A[j];
				j = j - 1;
			}
			A[j + 1] = value;
		}

		printArray(A);
	}

	static void printArray(int[] ar) {
		for (int n : ar) {
			System.out.print(n + " ");
		}
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] ar = new int[n];
		for (int i = 0; i < n; i++) {
			ar[i] = in.nextInt();
		}
		insertionSort(ar);
		in.close();
	} // as example input: 6 and then 1 4 3 5 6 2 output: 1 2 3 4 5 6
}
