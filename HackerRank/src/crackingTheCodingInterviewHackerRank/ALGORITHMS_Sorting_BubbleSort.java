package crackingTheCodingInterviewHackerRank;

import java.util.Scanner;

/*Sample Input:
3
3 2 1
Sample Output:
Array is sorted in 3 swaps.
First Element: 1
Last Element: 3
Explanation: 
The array is not sorted, and its initial values are: {3,2,1}. The following 3 swaps take place:
{3,2,1} -> {2,3,1}
{2,3,1} -> {2,1,3}
{2,1,3} -> {1,2,3}*/

public class ALGORITHMS_Sorting_BubbleSort {
	private static int[] array;

	private static void bubbleSort() {
		int n = array.length;

		// number of swaps for all array iterations
		int totalSwaps = 0;

		for (int i = 0; i < n; i++) {
			// number of swaps for current array iteration
			int numSwaps = 0;

			for (int j = 0; j < array.length - 1; j++) {
				if (array[j] > array[j + 1]) {
					int tmp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = tmp;
					numSwaps++;
					totalSwaps++;
				}
			}

			if (numSwaps == 0) {
				System.out.printf("Array is sorted in %d swaps.\n", totalSwaps);
				System.out.printf("First Element: %d\n", array[0]);
				System.out.printf("Last Element: %d\n", array[n - 1]);

				break;
			}
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		array = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = in.nextInt();
		}
		in.close();

		bubbleSort();
	}
}