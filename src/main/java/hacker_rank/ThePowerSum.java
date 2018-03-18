package hacker_rank;

import java.util.Scanner;

/*
Find the number of ways that a given integer, X , can be expressed as the sum of the N'th  power of unique, natural numbers.
If X=10 and N=2, we need to find the number of ways that 10 can be represented as the sum of squares of unique numbers.
10= 1^2 + 3^2
This is the only way in which 10 can be expressed as the sum of unique squares.
*/

public class ThePowerSum {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int x = scan.nextInt(), n = scan.nextInt();
		scan.close();
		System.out.println(pof(x, n, 0));
	}

	static int pof(int x, int n, int i) {
		x = x - (int) Math.pow(i, n);
		if (x == 0)
			return 1;
		if (x > 0) {
			int sum = 0;
			for (int j = i + 1; Math.pow(j, n) <= x; j++)
				sum += pof(x, n, j);
			return sum;
		} else
			return 0;
	}
}
