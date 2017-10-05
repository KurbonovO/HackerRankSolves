package crackingTheCodingInterviewHackerRank;

import java.util.Scanner;

/*The Fibonacci sequence begins with fibonacci(0) = 0 and fibonacci(1) = 1 as its respective first and
second terms. After these first two elements, each subsequent element is equal to the sum of the previous two elements.
Here is the basic information you need to calculate fibonacci(n):
fibonacci(0) = 0
fibonacci(1) = 1
fibonacci(n) = fibonacci(n-1) + fibonacci(n-2)*/

public class TECHNIQUESANDCONCEPTS_Recursion_FibonacciNumbers {

	public static int fibonacci(int n) {
		if(n <= 0) {
		    return 0;
		}
		else if (n == 1) {
		    return 1;
		}
		else {
		    return fibonacci(n - 1) + fibonacci(n - 2);
		}
	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		scanner.close();

		System.out.println(fibonacci(n));
	}
}
/*Sample Input:
3  
Sample Output:
2
Explanation: Consider the Fibonacci sequence:
fibonacci(0) = 0
fibonacci(1) = 1
fibonacci(2) = (0+1) = 1
fibonacci(3) = (1+1) = 2
fibonacci(4) = (1+2) = 3
fibonacci(5) = (2+3) = 5
fibonacci(6) = (3+5) = 8
...
We want to know the value of fibonacci(3). If we look at the sequence above, fibonacci(3) evaluates to 2. Thus, we print 2 as our answer.*/