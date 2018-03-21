package hacker_rank_Thirty;

import java.util.Scanner;

public class DayNine {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.close();
		System.out.println(factorial(n));
	}

	private static int factorial(int n) {
		if (n == 1)
			return 1;
		return factorial(n - 1) * n;
	}
}