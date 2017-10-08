package crackingTheCodingInterviewHackerRank;

import java.util.Scanner;

/*Given , find and print the unique element.
Approach:
Create a result variable and initialize it to 0.
Iterate through each element in the array and XOR it with result.
Print the final value of result.
 */

public class TECHNIQUESANDCONCEPTS_BitManipulation_LonelyInteger {
	public static int lonelyInteger(int[] a) {

		int result = 0;

		for (int i : a) {
			result = result ^ i;
		}
		return result;
	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		
		int[] a = new int[n];

		for (int i = 0; i < n; i++) {
			a[i] = scanner.nextInt();
		}

		scanner.close();

		System.out.println(lonelyInteger(a));
	}
}
/*Sample Input:
1
1
Sample Output:
1
Explanation:
The array only contains a single 1, so we print 1 as our answer.

Sample Input:
3
1 1 2
Sample Output:
2
Explanation: 
We have two 1's and one 2. We print 2, because that's the only unique element in the array.

Sample Input:
5
0 0 1 2 1
Sample Output:
2
Explanation: 
We have two 0's, two 1's, and one 2. We print 2, because that's the only unique element in the array*/
