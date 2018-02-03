package hacker_rank_Thirty;

import java.util.Scanner;

/*Given an integer, , print its first 10 multiples. Each multiple n * i  (where i <_i<_10 )
should be printed on a new line in the form: n x i = result.
sample Input :2 												Sample Output:
2 x 1 = 2
2 x 2 = 4
2 x 3 = 6
2 x 4 = 8
2 x 5 = 10
2 x 6 = 12
2 x 7 = 14
2 x 8 = 16
2 x 9 = 18
2 x 10 = 20				  													  */

public class DayFive {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int N;
		N = scanner.nextInt();

		scanner.close();

		for (int i = 1; i < 11; i++) {
			int sum = N * i;

			System.out.println(N + " x " + i + " = " + sum);
		}
	}
}