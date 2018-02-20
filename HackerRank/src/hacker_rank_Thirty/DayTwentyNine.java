package hacker_rank_Thirty;

import java.util.Scanner;

/*Given set S = {1,2,3,...,N}. Find two integers, A and B (where A < B), from set
S such that the value of A&B is the maximum possible and also less than a given
integer, K. In this case, & represents the bitwise AND operator				  */

public class DayTwentyNine {
	public static int findMaximum(int n, int k) {
		
		int max = 0;
		int a = n - 1; // we are constrained by a < b
		
		while (a-- > 0) {
			
			for (int b = a + 1; b <= n; b++) {
				int test = a & b;
				
				if (test < k && test > max) {
					max = test;
				}
			}
		}
		return max;
	}

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		
		for (int i = 0; i < t; i++) {
			int n = scanner.nextInt();
			int k = scanner.nextInt();
			System.out.println(findMaximum(n, k));
		}
		scanner.close();
	}
}

/*Sample Input: 3
5 2
8 5
2 2
Sample Output:
1
4
0
N = 5, K = 2, S = {1,2,3,4,5}
All possible values of A and B are:
A = 1, B = 2, A & B = 0
A = 1, B = 3, A & B = 1
A = 1, B = 4, A & B = 0
A = 1, B = 5, A & B = 1
A = 2, B = 3, A & B = 2
A = 2, B = 4, A & B = 0
A = 2, B = 5, A & B = 0
A = 3, B = 4, A & B = 0
A = 3, B = 5, A & B = 1
A = 4, B = 5, A & B = 4
The maximum possible value of A&B that is also < (K = 2) is 1, so we print 1 on
a new line																	  */
