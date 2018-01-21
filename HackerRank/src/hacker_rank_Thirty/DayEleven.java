package hacker_rank_Thirty;

import java.util.Scanner;

/*Given a 6 x 6  2D Array, A :
1 1 1 0 0 0
0 1 0 0 0 0
1 1 1 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0
We define an hourglass in A to be a subset of values with indices falling in this
pattern in A's graphical representation:
a b c
  d
e f g
There are 16 hourglasses in A, and an hourglass sum is the sum of an hourglass' values */

public class DayEleven {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int arr[][] = new int[6][6];
		
		for (int i = 0; i < 6; i++) {
			
			for (int j = 0; j < 6; j++) {
				arr[i][j] = scanner.nextInt();
			}
		}
		
		scanner.close();
		int sum = -10000;
		
		for (int i = 0; i < 4; i++) {
			
			for (int j = 0; j < 4; j++) {

				/* [00] [01] [02]
				 		[11]
				   [20] [21] [22] */

				int currentSum = arr[i][j] + arr[i][j + 1] + arr[i][j + 2]
						+ arr[i + 1][j + 1] + arr[i + 2][j] + arr[i + 2][j + 1]
						+ arr[i + 2][j + 2];
				
				if (currentSum > sum) {
					sum = currentSum;
				}
			}
		}
		System.out.println(sum);
	}
}

/*Sample Input:
1 1 1 0 0 0
0 1 0 0 0 0
1 1 1 0 0 0
0 0 2 4 4 0
0 0 0 2 0 0
0 0 1 2 4 0
Sample Output:
19
contains the following hourglasses:
1 1 1   1 1 0   1 0 0   0 0 0
  1       0       0       0
1 1 1   1 1 0   1 0 0   0 0 0

0 1 0   1 0 0   0 0 0   0 0 0
  1       1       0       0
0 0 2   0 2 4   2 4 4   4 4 0

1 1 1   1 1 0   1 0 0   0 0 0
  0       2       4       4
0 0 0   0 0 2   0 2 0   2 0 0

0 0 2   0 2 4   2 4 4   4 4 0
  0       0       2       0
0 0 1   0 1 2   1 2 4   2 4 0
The hourglass with the maximum sum (19) is:
2 4 4
  2
1 2 4											*/
