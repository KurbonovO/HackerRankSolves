package crackingTheCodingInterviewHackerRank;

import java.util.Scanner;

/*Given a number of dollars, n, and a list of dollar values for m distinct coins, C = {c0, c1, c2, ... ,c(m-1)},
find and print the number of different ways you can make change for n dollars if each coin is available in an infinite quantity*/

public class TECHNIQUESANDCONCEPTS_DynamicProgramming_CoinChange {
	
	//Explanation: https://www.youtube.com/watch?v=ZaVM057DuzE
	
	public static long makeChange(int[] coins, int money) {
		
		long[] DP = new long[money + 1]; // O(N) space.
		
		DP[0] = (long) 1; // n == 0 case.
		
		for (int coin : coins) {
			for (int j = coin; j < DP.length; j++) {
				// The only tricky step.
				DP[j] += DP[j - coin];
			}
		}
		return DP[money];
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		int m = scan.nextInt();
		
		int coins[] = new int[m];
		for (int coins_i = 0; coins_i < m; coins_i++) {
			coins[coins_i] = scan.nextInt();
		}
		System.out.println(makeChange(coins, n));
		scan.close();
	}
}
/*Sample Input:
4 3
1 2 3 
Sample Output: 
4
Explanation: For n = 4 and C = {1,2,3} there are four solutions:
{1,1,1,1}
{1,1,2}
{2,2}
{1,3}
Thus, we print 4 on a new line
Sample Input:
10 4
2 5 3 6
Sample Output:
5
Explanation:
For n = 10 and C = {2,5,3,6} there are five solutions:
{2,2,2,2,2}
{2,2,3,3}
{2,2,6}
{2,3,5}
{5,5}
Thus, we print 5 on a new line.*/