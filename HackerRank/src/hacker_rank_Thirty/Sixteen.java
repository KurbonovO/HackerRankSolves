package hacker_rank_Thirty;

import java.util.Scanner;

/*Today, we're getting started with Exceptions by learning how to parse an integer
from a string and print a custom error message. Task: Read a string, S, and print
its integer value; if S cannot be converted to an integer, print Bad String.
intput : 3
Sample Output: 3
Sample Input: za
Sample Output: Bad String
Sample Case 0 contains an integer, so it should not raise an exception when we
attempt to convert it to an integer. Thus, we print the 3. 
Sample Case 2 does not contain any integers, so an attempt to convert it to an
integer will raise an exception. Thus, our exception handler prints Bad String*/

public class Sixteen {
	public static void main(String[] args) {

		try (Scanner scanner = new Scanner(System.in);) {
			System.out.println(Integer.parseInt(scanner.nextLine()));
		}

		catch (NumberFormatException e) {
			System.out.println("Bad String");
		}
	}
}
