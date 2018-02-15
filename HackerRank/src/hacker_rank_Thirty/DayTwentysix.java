package hacker_rank_Thirty;

import java.util.Scanner;

/*Your local library needs your help! Given the expected and actual return dates
for a library book, create a program that calculates the fine (if any). The fee
structure is as follows:
1) If the book is returned on or before the expected return date, no fine will be
charged (i.e.: fine = 0)
2) If the book is returned after the expected return day but still within the same
calendar month and year as the expected return date fine = 15 Hackos * number of days
3) If the book is returned after the expected return month but still within the
same calendar year as the expected return date, the fine = 500 Hackos * number of
months
4) If the book is returned after the calendar year in which it was expected, there
is a fixed fine of 10,000 Hackos											  */

class BookReturnDate {
	public int day;
	public int month;
	public int year;

	BookReturnDate(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}
}

public class DayTwentysix {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		BookReturnDate actual = new BookReturnDate(scanner.nextInt(),
				scanner.nextInt(), scanner.nextInt());
		BookReturnDate expected = new BookReturnDate(scanner.nextInt(),
				scanner.nextInt(), scanner.nextInt());
		
		scanner.close();

		int fine = 0;

	  //Returned within the current year:
		if (expected.year == actual.year) {
			
		  //Returned 1+ months late in current year
			if (expected.month < actual.month) {
				fine = (actual.month - expected.month) * 500;
			}
		  
		  //Returned 1+ days late within the current month
			else if ((expected.month == actual.month) && (expected.day < actual.day)) {
				fine = (actual.day - expected.day) * 15;
			}
	
		//Else it is implied that the book was returned early
		} else if (expected.year < actual.year) {
			// Returned 1+ years late
			fine = 10000;
		}
		
		// Else it is implied that the book was returned 1+ years early
		System.out.println(fine);
	}
}

/*Sample Input:
9 6 2015
6 6 2015
Sample Output:
45
Given the following return dates: 
Actual: Da = 9, Ma = 6 Ya = 2015  
Expected: De = 6, Me = 6 Ye = 2015 
Because Ye = Ya, we know it is less than a year late. 
Because Me = Ma, we know it's less than a month late. 
Because De < Da, we know that it was returned late (but still within the same month
and year). Per the library's fee structure, we know that our fine will be 
15 Hackos * (# of days late). We then print the result of 
15 * (Da - De) -> 15 * (9 - 6) as our output								  */
