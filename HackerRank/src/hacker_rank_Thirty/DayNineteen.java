package hacker_rank_Thirty;

/*The AdvancedArithmetic interface and the method declaration for the abstract
int divisorSum(int n) method are provided for you in the editor below. Write the
Calculator class, which implements the AdvancedArithmetic interface. The implementation
for the divisorSum method must be public and take an integer parameter, n, and return
the sum of all its divisors.
Sample Input: 6
Sample Output:
I implemented: AdvancedArithmetic
12
The integer 6 is evenly divisible by 1, 2, 3, and 6. Our divisorSum method should
return the sum of these numbers, which is 1+2+3+6 = 12. The Solution class then
prints I implemented: AdvancedArithmetic on the first line, followed by the sum
returned by divisorSum (which is 12) on the second line						  */

interface AdvancedArithmetic {
	int divisorSum(int n);
}

public class DayNineteen implements AdvancedArithmetic {
	public int divisorSum(int n) {

		// n has no divisors other than itself
		if (n == 1) {
			return n;
		}

		// Find and sum divisors:
		int half = n / 2;
		int sum = n;
		do {
			if (n % half == 0) {
				sum += half;
			}
		} while (half-- > 1);

		return sum;
	}
}