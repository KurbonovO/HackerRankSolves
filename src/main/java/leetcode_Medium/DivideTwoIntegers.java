package leetcode_Medium;

/*29 Given two integers dividend and divisor, divide two integers without using
multiplication, division and mod operator. Return the quotient after dividing
dividend by divisor. The integer division should truncate toward zero.
Input: dividend = 10, divisor = 3		Output: 3
Input: dividend = 7, divisor = -3		Output: -2							 */

public class DivideTwoIntegers {
	public int divide(int dividend, int divisor) {

		if (divisor == 0 || dividend == Integer.MIN_VALUE && divisor == -1) {
			return Integer.MAX_VALUE;
		}

		int result = 0;
		int sign = (dividend < 0) ^ (divisor < 0) ? -1 : 1;
		long dvd = Math.abs((long) dividend);
		long dvs = Math.abs((long) divisor);

		while (dvs <= dvd) {

			long temp = dvs, mul = 1;

			while (dvd >= temp << 1) {
				temp <<= 1;
				mul <<= 1;
			}
			dvd -= temp;
			result += mul;
		}
		return sign == 1 ? result : -result;
	}
}
