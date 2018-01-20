package hacker_rank_Thirty;

import java.util.Scanner;

/*Given a base-10 integer, n, convert it to binary (base-2). Then find and print
the base-10 integer denoting the maximum number of consecutive 1's in n's binary
representation.		Sample Input :5
Sample Output: 1
Sample Input: 13
Sample Output: 2
Explanation: The binary representation of 5 is 101, so the maximum number of
consecutive 1's is 1.
Sample Case 2: 
The binary representation of 13 is 1101, so the maximum number of consecutive 1's
is 2					*/

public class dayTen {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.close();

		int sum = 0, max = 0;
		while (n > 0) {
			if (n % 2 == 1) {
				sum++;
				if (sum > max) {
					max = sum;
				}
			} else {
				sum = 0;
			}
			n = n / 2;
		}
		System.out.println(max);
	}
}
