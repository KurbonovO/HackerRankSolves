package leetcode;

import java.util.stream.Stream;

/*Given two strings representing two complex numbers. You need to return a string representing their multiplication.
Note i^2 = -1 according to the definition. Multiplication of two complex numbers can be done as:
(a + ib) * (x+iy) = ax + i^2by + i(bx+ay) = ax - by + i(bx+ay) */

public class ComplexNumberMultiplication {
	
	public String complexNumberMultiply(String a, String b) {
		
		int[] coefs1 = Stream.of(a.split("\\+|i")).mapToInt(Integer::parseInt).toArray(),
			  coefs2 = Stream.of(b.split("\\+|i")).mapToInt(Integer::parseInt).toArray();
		
		return (coefs1[0] * coefs2[0] - coefs1[1] * coefs2[1]) + "+" + (coefs1[0] * coefs2[1] + coefs1[1] * coefs2[0]) + "i";
	}
}

/*Input: "1+1i", "1+1i"
Output: "0+2i"
Explanation: (1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i, and you need convert it to the form of 0+2i.

Input: "1+-1i", "1+-1i"
Output: "0+-2i"
Explanation: (1 - i) * (1 - i) = 1 + i2 - 2 * i = -2i, and you need convert it to the form of 0+-2i. */