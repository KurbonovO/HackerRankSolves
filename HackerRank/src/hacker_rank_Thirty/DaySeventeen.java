package hacker_rank_Thirty;

import java.util.Scanner;

/*Write a Calculator class with a single method: int power(int,int). The power
method takes two integers, n and p, as parameters and returns the integer result
of n^p. If either n or p is negative, then the method must throw an exception with
the message: n and p should be non-negative.
Sample Input:
4
3 5
2 4
-1 -2
-1 3
Sample Output:
243
16
n and p should be non-negative
n and p should be non-negative
T = 4
t0: 3 and 5 are positive, so power returns the result of 3^5, which is 243 
t1: 2 and 4 are positive, so power returns the result of 2^4, which is 16 
t2: Both inputs (-1 and -2) are negative, so power throws an exception and n and
p should be non-negative  is printed. 
t3: One of the inputs (-1) is negative, so power throws an exception and n and p
should be non-negative is printed									*/

class Calculator {
	public int power(int n, int p) throws Exception {
		
		if (n < 0 || p < 0) {
			throw new Exception("n and p should be non-negative");
		}
		return (int) Math.pow(n, p);
	}
}

public class DaySeventeen {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
		int t = scanner.nextInt();
		
		while (t-- > 0) {

			int n = scanner.nextInt();
			int p = scanner.nextInt();
			Calculator myCalculator = new Calculator();
			
			try {
				int ans = myCalculator.power(n, p);
				System.out.println(ans);
			} 
			catch (Exception exception) {
				System.out.println(exception.getMessage());
			}
		}
		scanner.close();
	}
}
