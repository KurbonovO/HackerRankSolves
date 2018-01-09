package hacker_rank_Thirty;

import java.util.Scanner;

/*you must save a line of input from stdin to a variable, print Hello, World. on
a single line, and finally print the value of your variable on a second line. 
Sample Input: Welcome to 30 Days of Code! Sample Output Hello, World. Welcome to
30 Days of Code! 															  */

public class DayZero {
	public static void main(String[] args) {

	  //Create a Scanner object to read input from stdin.
		Scanner scan = new Scanner(System.in);

	  //Read a full line of input from stdin and save it to our variable, inputString.
		String inputString = scan.nextLine();

	  /*Close the scanner object, because we've finished reading all of the input
		from stdin needed for this challenge */
		scan.close();

	  //Print a string literal saying "Hello, World." to stdout.
		System.out.println("Hello, World.");

	  //Write a line of code here that prints the contents of inputString to stdout.
		System.out.println(inputString);
	}
}