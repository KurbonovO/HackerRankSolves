package hacker_rank_Thirty;

import java.util.Scanner;

public class DayThree {
	private static String weird = "Weird";
	private static String notWeird = "Not Weird";
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		scan.close();
		String ans = "";

		// if 'n' is NOT evenly divisible by 2 (i.e.: n is odd)
		if (n % 2 == 1) {
			ans = weird;
		}
		// 'n' must be even; proceed if 'n' >= 2
		else if (n >= 2) {
			if (n > 20) {
				ans = notWeird;
			} else if (n >= 6) {
				ans = weird;
			} else if (n >= 2) {
				ans = notWeird;
			}
		}
		System.out.println(ans);
	}
}