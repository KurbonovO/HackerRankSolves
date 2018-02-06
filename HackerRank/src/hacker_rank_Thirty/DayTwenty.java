package hacker_rank_Thirty;

import java.util.Scanner;

/*Given an array, a, of size n distinct elements, sort the array in ascending order
using the Bubble Sort algorithm above. Once sorted, print the following 3 lines:
Array is sorted in numSwaps swaps. 
where  is the number of swaps that took place.
First Element: firstElement 
where firstElement is the first element in the sorted array.
Last Element: lastElement 
where lastElement is the last element in the sorted array					  */

public class DayTwenty {
	
	private static int[] array;

	private static void bubbleSort() {
		int n = array.length;

	  //Number of swaps for all array iterations
		int totalSwaps = 0;

		for (int i = 0; i < n; i++) {
		  
			//Track if a swap was made
			boolean swapped = false;

			for (int j = 0; j < array.length - 1; j++) {
				
				if (array[j] > array[j + 1]) {
					int tmp = array[j];
					array[j] = array[j + 1];

					array[j + 1] = tmp;
					swapped = true;
					totalSwaps++;
				}
			}

		  //Terminate loop as soon as array is sorted
			if (!swapped) {
				break;
			}
		}

	  //Print answer
		System.out.printf("Array is sorted in %d swaps.\n", totalSwaps);
		System.out.printf("First Element: %d\n", array[0]);
		System.out.printf("Last Element: %d\n", array[n - 1]);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		array = new int[n];
		
		for (int i = 0; i < n; i++) {
			array[i] = scanner.nextInt();
		}
		scanner.close();

		bubbleSort();
	}
}

/*Sample Input:
3
1 2 3
Sample Output:
Array is sorted in 0 swaps.
First Element: 1
Last Element: 3
The array is already sorted, so 0 swaps take place and we print the necessary 3
lines of output shown above.

Sample Input:
3
3 2 1
Sample Output:
Array is sorted in 3 swaps.
First Element: 1
Last Element: 3
The array a = [3,2,1] is not sorted, so we perform the following 3 swaps:
[321] -> [231]
[231] -> [213]
[213] -> [123]
At this point the array is sorted and we print the necessary 3 lines of output
shown above																	  */
