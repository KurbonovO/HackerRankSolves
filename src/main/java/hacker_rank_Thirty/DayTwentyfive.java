package hacker_rank_Thirty;

import java.util.Scanner;

/*A prime is a natural number greater than 1 that has no positive divisors other
than 1 and itself. Given a number, n, determine and print whether it's Prime or
Not Prime																	  */

public class DayTwentyfive {
	static boolean isPrime(int n) {

		for (int i = 2; i <= Math.sqrt(n); i++) {

			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int numOfTests = scanner.nextInt();

		for (int i = 0; i < numOfTests; i++) {
			int x = scanner.nextInt();
			String s;

			if (x >= 2 && isPrime(x)) {
				s = "Prime";
			} else {
				s = "Not prime";
			}

			scanner.close();
			System.out.println(s);
		}
	}
}

/*Sample Input: 3
12
5
7
Sample Output: Not prime
Prime
Prime
n = 12 
12 is divisible by numbers other than 1 and itself 2,3,6 so we print Not Prime 
on a new line
n = 5
5 is only divisible 1 and itself, so we print Prime on a new line
n = 7 
7 is only divisible 1 and itself, so we print Prime on a new line		      */
