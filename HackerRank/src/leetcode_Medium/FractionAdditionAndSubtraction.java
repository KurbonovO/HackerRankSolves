package leetcode_Medium;

import java.util.Scanner;

/*592 Given a string representing an expression of fraction addition and subtraction,
you need to return the calculation result in string format. The final result should be
irreducible fraction. If your final result is an integer, say 2, you need to change it
to the format of fraction that has denominator 1. So in this case, 2 should be converted to 2/1.
Input:"-1/2+1/2"
Output: "0/1"
Input:"-1/2+1/2+1/3"
Output: "1/3"
Input:"1/3-1/2"
Output: "-1/6"
Input:"5/3+1/3"
Output: "2/1"*/

public class FractionAdditionAndSubtraction {
	public String fractionAddition(String expression) {
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(expression).useDelimiter("/|(?=[-+])");
		
		int A = 0, B = 1;
		
		while ( scanner.hasNext() ) {
			
			int a = scanner.nextInt(), b = scanner.nextInt();
			A = A * b + a * B;
			B *= b;
			int g = gcd(A, B);
			A /= g;
			B /= g;
		}
		
		return A + "/" + B;
	}

	private int gcd(int a, int b) {
		return a != 0 ? gcd(b % a, a) : Math.abs(b);
	}
}